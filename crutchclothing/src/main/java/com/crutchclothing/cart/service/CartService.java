package com.crutchclothing.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crutchclothing.cart.dao.CartDao;
import com.crutchclothing.cart.model.Cart;
import com.crutchclothing.cart.model.CartProduct;
import com.crutchclothing.cart.model.CartProductDetail;
import com.crutchclothing.cart.model.CartProductRef;
import com.crutchclothing.products.model.Product;
import com.crutchclothing.products.model.ProductDetail;

@Service("cartService")
public class CartService {
	
	//@Autowired
	private CartDao cartDao;
	
	public void saveCart(Cart cart) {
		cartDao.save(cart);
	}
	
	public void createCart() {
		cartDao.createCart();
	}
	
	public void updateCart(Cart cart) {
		cartDao.update(cart);
	}
	
	public Cart findCart(Integer cart_id) {
		return cartDao.findCart(cart_id);
	}
	
	public Cart findCartWithCartProducts(Integer cartId) {
		return cartDao.findCartWithCartProducts(cartId);
	}
	
	public void addToCart(Integer cartId, Product product) {
		//System.out.println("productid = " + product.getId());
		cartDao.addProductToCart(cartId, product);
	}
	
	public void increaseCartProductQuantity(Integer productDetailId, Integer cartProductId, int quantity) {
		cartDao.increaseCartProductQuantity(productDetailId, cartProductId, quantity);
	}
	
	public void changeCartProductQuantity(Integer cartProductId, Integer productDetailId, 
			int newQuantity) {
		
		cartDao.changeCartProductQuantity(cartProductId, productDetailId, newQuantity);
	}
	
	public void saveCartProduct(CartProduct cartProduct) {
		cartDao.saveCartProduct(cartProduct);
	}
	
	public CartProduct findCartProduct(Integer id) {
		return cartDao.findCartProduct(id);
	}
	
	public void saveProductDetail(CartProduct cartProduct, ProductDetail productDetail) {
		cartDao.saveProductDetail(cartProduct, productDetail);
	}
	
	public void saveDetailToCartProduct(Integer cartProductId, ProductDetail productDetail) {
		cartDao.saveDetailToCartProduct(cartProductId, productDetail);
	}
	
	
	public List<CartProduct> getCartProducts() {
		return cartDao.getCartProducts();
	}
	
	public List<ProductDetail> getProductDetails() {
		return cartDao.getProductDetails();
	}
	
	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}
	
	public CartProductRef findCartProductRef(Integer cartProductId, Integer productDetailsId) {
		return this.cartDao.findCartProductRef(cartProductId, productDetailsId);
	}
	/*
	private Cart findOrCreateCart(final Integer pk) {
    	
		Cart cart = cartDao.findCart(pk);
        if (cart == null) {
            cart = cartDao.createCart();
        }
        return cart;
    }
    */
}
