package com.crutchclothing.cart.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crutchclothing.cart.model.Cart;
import com.crutchclothing.cart.model.CartProduct;
import com.crutchclothing.cart.model.CartProductDetail;
import com.crutchclothing.cart.model.CartProductRef;
import com.crutchclothing.cart.model.CartProductRef.Id;
import com.crutchclothing.products.model.Product;
import com.crutchclothing.products.model.ProductDetail;
import com.crutchclothing.users.model.User;

@Repository
public class CartDaoImpl implements CartDao {
	
	//@Autowired
	private SessionFactory sessionFactory; 
		  
	public CartDaoImpl() {  
	}  
	
	@Override
	public Cart createCart() {  
		Cart cart = new Cart();  
		save(cart);  
		return cart;  
	}  
	
	@Override
	@Transactional
	public Cart findCart(Integer cart_id) {  
		    return (Cart) sessionFactory.getCurrentSession().get(Cart.class, cart_id);  
	}  
	
	@Override
	@Transactional
	public Cart findCartWithCartProducts(Integer cartId) {
		Cart cart = (Cart) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.idEq(cartId)).uniqueResult();
		Hibernate.initialize(cart.getCartProducts());
		return cart;
	}
	
	@Override
	@Transactional
	public void save(Cart cart) {
		 sessionFactory.getCurrentSession().save(cart);
	}  
	
	@Override
	@Transactional
	public void update(Cart cart) {
		Cart foundCart = findCart(cart.getCartId());
		 sessionFactory.getCurrentSession().merge(foundCart);
	}
	
	@Override
	@Transactional
	public void addProductToCart(Integer cartId, Product product) {
		Cart foundCart = findCart(cartId);
		//System.out.println("productid = " + product.getId());
		//foundCart.getProducts().add(product);
		//sessionFactory.getCurrentSession().saveOrUpdate(product);
		 sessionFactory.getCurrentSession().merge(foundCart);
		//sessionFactory.getCurrentSession().saveOrUpdate(foundCart);
	}
	
	@Override
	@Transactional
	public void increaseCartProductQuantity(Integer productDetailId, Integer cartProductId, int quantity) {
		//String query = "select * from cart_products where cart_id = " + cartId + " and product_id = " + productId + ";";
		
		String hql = "from CartProductRef where product_details_id = ? and cart_product_id = ?";
	
		//List<CartProduct> cartProducts = sessionFactory.getCurrentSession().createSQLQuery(query).list();
		List<CartProductRef> cprs = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, productDetailId)
				.setParameter(1, cartProductId)
				.list();
		
		if(cprs.size() > 0) {
			CartProductRef cpr = (CartProductRef) cprs.get(0);
			cpr.setProductQuantity(cpr.getProductQuantity() + quantity);
			sessionFactory.getCurrentSession().saveOrUpdate(cpr);
		}
		
	}
	
	
	@Override
	@Transactional
	public void changeCartProductQuantity(Integer cartProductId, Integer productDetailId, 
			int newQuantity) {
		//String query = "select * from cart_products where cart_id = " + cartId + " and product_id = " + productId + ";";
		String hql = "from CartProductRef where cart_product_id = ? and product_details_id = ?";
		String cartSizeHql = "from CartProductRef where cart_product_id = ?";
		//List<CartProduct> cartProducts = sessionFactory.getCurrentSession().createSQLQuery(query).list();
		List<CartProductRef> cprs = sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0, cartProductId)
				.setParameter(1, productDetailId)
				.list();
		
		
		if(cprs.size() > 0) {
			CartProductRef cpr = (CartProductRef) cprs.get(0);
			if(newQuantity == 0) {
				cpr.getCartProduct().getCartProductRefs().remove(cpr);
				cpr.getProductDetail().getCartProductRefs().remove(cpr);
				//boolean val = cp.getProductDetails().remove(productDetail);
				sessionFactory.getCurrentSession().delete(cpr);
				
				List<CartProductRef> cartProducts = sessionFactory.getCurrentSession().createQuery(cartSizeHql)
						.setParameter(0, cartProductId)
						.list();
				
				if(cartProducts.size() == 0) {
					String delHql = "delete from CartProduct where cart_product_id = ?";
					sessionFactory.getCurrentSession().createQuery(delHql)
					.setParameter(0, cartProductId)
					.executeUpdate();
					//sessionFactory.getCurrentSession().(cp);
				}
			}
			else {
				cpr.setProductQuantity(newQuantity);
				sessionFactory.getCurrentSession().merge(cpr);
			}
		}
		
	}
	
	@Override
	@Transactional
	public void saveCartProduct(CartProduct cartProduct) {
		sessionFactory.getCurrentSession().persist(cartProduct);
	}
	
	@Override
	@Transactional
	public void saveProductDetail(CartProduct cartProduct, ProductDetail productDetail) {
		CartProduct cp = findCartProduct(cartProduct.getCartProductId());
		CartProductRef cpr = new CartProductRef(productDetail, cp, productDetail.getQuantity());
		
		sessionFactory.getCurrentSession().persist(cpr);
		
		cp.getCartProductRefs().add(cpr);
		sessionFactory.getCurrentSession().merge(cp);
		
		productDetail.getCartProductRefs().add(cpr);
		sessionFactory.getCurrentSession().merge(productDetail);
	}
	
	@Override
	@Transactional
	public void saveDetailToCartProduct(Integer cartProductId, ProductDetail productDetail) {
		
		String hql = "from CartProduct where cart_product_id = ?";
		List<CartProduct> cps = sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter(0, cartProductId).list();
		if(cps.size() > 0) {
			CartProduct cp = (CartProduct) cps.get(0);
			Id cprId = new Id(productDetail.getId(), cartProductId);
			CartProductRef cpr = new CartProductRef(productDetail, cp, productDetail.getQuantity());
			cpr.setId(cprId);
			//productDetail.getCartProductRefs().add(cpr);
			//cp.getCartProductRefs().add(cpr);
			
			//sessionFactory.getCurrentSession().merge(productDetail);
			//sessionFactory.getCurrentSession().merge(cp);
			sessionFactory.getCurrentSession().save(cpr);
			
			//productDetail.setCartProduct(cp);
			//productDetail.getCartProductRefs().add(cpr);
			
			//cp.getCartProductRef().add(cpr);
			//sessionFactory.getCurrentSession().merge(cp);
		}

				
		
		//sessionFactory.getCurrentSession().persist(cpd);
	}
	
	@Override
	@Transactional
	public CartProduct findCartProduct(Integer id) {
		return (CartProduct) sessionFactory.getCurrentSession().get(CartProduct.class, id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<CartProduct> getCartProducts() {
		System.out.println();
		return sessionFactory.getCurrentSession().createQuery("from CartProduct").list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ProductDetail> getProductDetails() {
		return sessionFactory.getCurrentSession().createQuery("from ProductDetail").list();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public CartProductRef findCartProductRef(Integer cartProductId,
			Integer productDetailsId) {
		CartProductRef cpr = null;
		
		String hql = "from CartProductRef where cart_product_id = ? and product_details_id = ?";
		
		List<CartProductRef> cprs = this.sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0, cartProductId)
				.setParameter(1, productDetailsId)
				.list();
		
		if(cprs.size() > 0) {
			cpr = cprs.get(0);
		}
		
		return cpr;
	}

	@Override
	@Transactional
	public Cart findCart(String email) {
		
		String hql = "from Cart where User.email = ?";
		
		return null;
	}
		
		
}
