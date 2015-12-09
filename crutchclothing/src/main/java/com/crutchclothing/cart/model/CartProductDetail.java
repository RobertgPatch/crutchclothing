package com.crutchclothing.cart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.crutchclothing.cart.model.CartProduct;
import com.crutchclothing.products.model.ProductDetail;
import com.crutchclothing.users.model.User;


@Entity
@Table(name="cart_products_details")
public class CartProductDetail implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id; // primary key
	//private String size;
	//private String color;
	private int quantity;
	private String name;
	private CartProduct cartProduct;
	//private CartProduct cartProduct;
	
 public CartProductDetail() {
 }

 public CartProductDetail(CartProduct cartProduct/*, String size*/, String color, int quantity) 
 {
  this.cartProduct = cartProduct;
  //this.size = size;
  this.quantity = quantity;
 }
 
 public CartProductDetail(CartProduct cartProduct, ProductDetail productDetail) {
	 this.cartProduct = cartProduct;
	 //this.size = productDetail.getSize();
	 this.quantity = productDetail.getQuantity();
	 this.name = cartProduct.getProduct().getName();
 }
 

 @Id
 @GeneratedValue
 @Column(name = "cart_product_details_id", unique = true, nullable = false)
 public Integer getId() {
  return this.id;
 }
 
 public void setId(Integer id) {
 	this.id = id;
 }
 

 /*
 @Column(name="cart_product_size", nullable = false)
 public String getSize() {
	 return this.size;
 }
 
 public void setSize(String size) {
	 this.size = size;
 }
 */
 
 @Column(name="cart_product_quantity", nullable = true)
 public int getQuantity() {
	 return this.quantity;
 }
 
 public void setQuantity(int quantity) {
	 this.quantity = quantity;
 }
 
 @Column(name="cart_product_name", nullable = true)
 public String getName() {
	 return this.name;
 }
 
 public void setName(String name) {
	 this.name = name;
 }
 
 
 @ManyToOne(fetch = FetchType.EAGER)
 @JoinColumn(name = "cart_product_id", nullable = false)
 public CartProduct getCartProduct() {
	 return this.cartProduct;
 }
 
 public void setCartProduct(CartProduct cartProduct) {
	 this.cartProduct = cartProduct;
 }
 
 
 
 //public enum Size {
// S, M, L, XL
 //}
 

}
