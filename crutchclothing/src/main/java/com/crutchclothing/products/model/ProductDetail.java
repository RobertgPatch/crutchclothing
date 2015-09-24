	package com.crutchclothing.products.model;

	import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.crutchclothing.cart.model.CartProduct;
import com.crutchclothing.cart.model.CartProductRef;
import com.crutchclothing.inventory.Inventory;
import com.crutchclothing.users.model.Address;
import com.crutchclothing.users.model.User;


	@Entity
	@Table(name="products_details")
	public class ProductDetail implements Serializable  {
		
		private static final long serialVersionUID = 1L;
		
		private Integer id; // primary key
		//private String size;
		private String size;
		private int quantity;
		private Product product;
		private Inventory currentInventory;
		private Set<Inventory> dailyInventory;
		private Set<CartProductRef> cartProductRefs = new HashSet<CartProductRef>(0);
		
		/*
		@Transient
		private static final String SIZE_SMALL = "small";
		@Transient
		private static final String SIZE_MEDIUM = "medium";
		@Transient
		private static final String SIZE_LARGE = "large";
		@Transient
		private static final String SIZE_XLARGE = "xlarge";
		*/
		//private Set<CartProduct> cartProducts = new HashSet<>(0);
		//private CartProduct cartProduct;
		
	 public ProductDetail() {
	 }

	 public ProductDetail(Product product, String size, int quantity) 
	 {
	  this.product = product;
	  this.size = size;
	  this.quantity = quantity;
	 }
	 
	 public ProductDetail(Product product, Set<CartProductRef> cartProductRefs, String size, 
			 int quantity) 
	 {
	  this.product = product;
	  this.cartProductRefs = cartProductRefs;
	  this.size = size;
	  this.quantity = quantity;
	 }
	 
	 public ProductDetail(String size) 
	 {
	  this.size = size;
	 }


	 @Id
	 @GeneratedValue
	 @Column(name = "product_details_id", unique = true, nullable = false)
	 public Integer getId() {
	  return this.id;
	 }
	 
	 public void setId(Integer id) {
	 	this.id = id;
	 }
	 
	 @Column(name="size", nullable = false)
	 public String getSize() {
		 return this.size;
	 }
	 
	 public void setSize(String size) {
		 this.size = size;
	 }	 
	
	 //@Column(name="product_quantity", nullable = true)
	 @Transient
	 public int getQuantity() {
		 return this.quantity;
	 }
	 
	 public void setQuantity(int quantity) {
		 this.quantity = quantity;
	 }
	 
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "product_id", nullable = false)
	 public Product getProduct() {
		 return this.product;
	 }
	 
	 public void setProduct(Product product) {
		 this.product = product;
	 }
	 
	 /*
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "cart_product_id", nullable = false)
	 public CartProduct getCartProduct() {
		 return this.cartProduct;
	 }
	 
	 public void setCartProduct(CartProduct cartProduct) {
		 this.cartProduct = cartProduct;
	 }
	 */
	 
	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "productDetail")
	 public Set<CartProductRef> getCartProductRefs() {
		 return this.cartProductRefs;
	 }
	 
	 public void setCartProductRefs(Set<CartProductRef> cartProductRefs) {
		 this.cartProductRefs = cartProductRefs;
	 }
	 
	 @Transient
	 public Inventory getCurrentInventory() {
		if(dailyInventory == null) {
			return null;
		}
		currentInventory = dailyInventory.iterator().next();
		
		return currentInventory;
	 }

	 public void setCurrentInventory(Inventory currentInventory) {
		this.currentInventory = currentInventory;
	 }

	 @OneToMany(fetch = FetchType.EAGER, mappedBy = "productDetail")
	 public Set<Inventory> getDailyInventory() {
		 return this.dailyInventory;
	 }
	 
	 public void setDailyInventory(Set<Inventory> dailyInventory) {
		 this.dailyInventory = dailyInventory;
	 }
	 

	}
