package com.crutchclothing.cart.dao;

import java.util.List;

import com.crutchclothing.cart.model.Cart;
import com.crutchclothing.cart.model.CartProduct;
import com.crutchclothing.cart.model.CartProductDetail;
import com.crutchclothing.cart.model.CartProductRef;
import com.crutchclothing.products.model.Product;
import com.crutchclothing.products.model.ProductDetail;

public interface CartDao {
	
	public Cart createCart();
	
	public Cart findCart(Integer cart_id);
		  
	public void save(Cart cart);

	public void update(Cart cart);
	
	public void addProductToCart(Integer cartId, Product product);
	
	public void increaseCartProductQuantity(Integer productDetailId, Integer cartProductId, int quantity);
	
	public void changeCartProductQuantity(Integer cartProductId, Integer productDetailId, int newQuantity);
	
	public void saveCartProduct(CartProduct cartProduct);
	
	public void saveProductDetail(CartProduct cartProduct, ProductDetail productDetail);
	
	public void saveDetailToCartProduct(Integer cartProductId, ProductDetail productDetail);
	
	public CartProduct findCartProduct(Integer id);
	
	public List<CartProduct> getCartProducts();
	
	public List<ProductDetail> getProductDetails();
	
	public CartProductRef findCartProductRef(Integer cartProductId, Integer productDetailsId);
}
