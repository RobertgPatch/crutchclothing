package com.crutchclothing.products.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crutchclothing.cart.model.Cart;
import com.crutchclothing.cart.model.CartProduct;
import com.crutchclothing.inventory.Inventory;
import com.crutchclothing.orders.model.Order;
import com.crutchclothing.orders.model.OrderLine;
import com.crutchclothing.products.model.Category;
import com.crutchclothing.products.model.Product;
import com.crutchclothing.products.model.ProductDetail;
import com.crutchclothing.users.model.User;

@Repository
public class ProductDaoImpl implements ProductDao {

	//@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addProduct(Product product, ProductDetail details) {
		
		//Category c = findCategory(category.getName());
		//Integer i = c.getId();
		//System.out.println(i);
		//c.getProducts().add(product);
		//product.setCategory(c);
		
		//sessionFactory.getCurrentSession().update(c);
		//sessionFactory.getCurrentSession().persist(savedCat);
		product.getProductDetail().add(details);
		details.setProduct(product);
		product.addToQuantity(details.getQuantity());
		sessionFactory.getCurrentSession().persist(product);
		sessionFactory.getCurrentSession().persist(details);
		
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Product findProduct(String name) {
		List<Product> products = new ArrayList<Product>();

		products = sessionFactory.getCurrentSession().createQuery("from Product where product_name =?").setParameter(0, name)
				.list();

		if (products.size() > 0) {
			return products.get(0);
		} else {
			return null;
		}
		
	}
	
	@Override
	@Transactional
	public void updateProduct(Product product, ProductDetail details) {
		Product productFound = 
                (Product)sessionFactory.getCurrentSession().get(Product.class, product.getId()); 
		productFound.getProductDetail().add(details);
		productFound.addToQuantity(details.getQuantity());
		details.setProduct(productFound);
		sessionFactory.getCurrentSession().persist(details);
		sessionFactory.getCurrentSession().merge(productFound);
	}
	
	@Override
	@Transactional
	public void updateProductInventory(Product product, Inventory inventory) {
		Product productFound =
				(Product)sessionFactory.getCurrentSession().get(Product.class, product.getId());
		productFound.getDailyInventory().add(inventory);
		inventory.setProduct(product);
		sessionFactory.getCurrentSession().persist(inventory);
		sessionFactory.getCurrentSession().merge(productFound);
	}
	@Transactional
	public ProductDetail findProductDetail(Product product, String size, String color) {
		String sql = "select * from products_details where product_id = " 
				+ product.getId() + " and product_size = '" + size 
				+ "' and product_color = '" + color + "'";
		
		String hql = "from ProductDetail where product_id = ? and product_size = ? and product_color = ?";
		
		//List<CartProduct> cartProducts = sessionFactory.getCurrentSession().createSQLQuery(query).list();
		List<ProductDetail> productDetails = sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0, product.getId())
				.setParameter(1, size)
				.setParameter(2, color)
				.list();
		
		
		if(productDetails.size() > 0) {
			return productDetails.get(0);
		}
		else {
			return null;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public Category findCategory(String name) {
		List<Category> categories = new ArrayList<Category>();

		categories = sessionFactory.getCurrentSession().createQuery("from Category where category_name =?").setParameter(0, name)
				.list();

		if (categories.size() > 0) {
			return categories.get(0);
		} else {
			return null;
		}
	}
	
	@Transactional
	public Category findCategoryById(Integer Id) {
		String hql = "from Category where category_id = ?";
		Category cat = null;
		List cats = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, Id).list();
		if(cats.size() > 0) {
			cat = (Category) cats.get(0);
		}
		
		return cat;
	}
	
	@Override
	@Transactional
	public void addCartToProduct(Product product, Cart cart) {
		Product foundProduct = findProduct(product.getId());
		//foundProduct.getCarts().add(cart);
		sessionFactory.getCurrentSession().update(foundProduct);
	}
	
	/*
	@SuppressWarnings("unchecked")
	@Transactional
	public Product findProductById(Integer id) {

		List<Product> products = new ArrayList<Product>();

		products = sessionFactory.getCurrentSession().createQuery("from Product where product_id=?").setParameter(0, id)
				.list();

		if (products.size() > 0) {
			return products.get(0);
		} else {
			return null;
		}

	}
	*/
	@Transactional
	public Product findProduct(Integer product_id) {  
		    return (Product) sessionFactory.getCurrentSession().get(Product.class, product_id);  
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Product> findAllProducts() {
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Category> findAllCategories() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Product> findProductsWithPriceRange(double min, double max) {
		String hql = "from Product where product_price >= ? and product_price <= ?";
		List<Product> products = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, min).setParameter(1, max).list();
		if(products.size() > 0) {
			return products;
		}
		
		return null;
		//Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
		//criteria.add(Restrictions.between("price", min, max));
		
		//return criteria.list();
	}
	
	
	@Override
	@Transactional
	public void addCategoryToProduct(Product product, Category cat) {
		product.setCategory(cat);
		
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}
	
	@Override
	@Transactional
	public void addOrderLineToProduct(OrderLine orderLine, Product product) {
		
		Product fProduct = findProduct(product.getId());
		fProduct.getOrderLines().add(orderLine);
		sessionFactory.getCurrentSession().saveOrUpdate(fProduct);
		sessionFactory.getCurrentSession().persist(orderLine);
		
	}
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

}
