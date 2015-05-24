package com.crutchclothing.products.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.crutchclothing.cart.model.CartProduct;
import com.crutchclothing.inventory.Inventory;
import com.crutchclothing.orders.model.OrderLine;

@Entity
@Table(name="products", catalog="crutch")
public class Product implements Serializable  {

	private static final long serialVersionUID = 1L;
	private Integer id; // primary key
	//private Integer category_id; //foreign key
	//private Integer shoppingcart_id; //foreign key
	private String name;
	private double price;
	private double msrp;
	private int quantity;
	private String description;
	private Set<ProductDetail> productDetails = new HashSet<ProductDetail>();
	private Set<OrderLine> orderLines = new HashSet<OrderLine>();
	private Set<CartProduct> cartProducts = new HashSet<CartProduct>();
	private Set<Inventory> dailyInventory = new HashSet<Inventory>();
	private Category category;
	//private Set<Order> orders = new HashSet<>();
	
	//private Set<Product_Order> product_Order = new HashSet<Product_Order>();
	//private Set<Cart> carts = new HashSet<Cart>();
	//private byte[] shirt_image;
 
 public Product() {
 }

 public Product(/*, Integer shoppingcart_id*/String name, double msrp,
		 double price, String description) 
 {
	 
  this.name = name;
  this.price = price;
  this.description = description;
  //this.category = category;
 }


 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name = "product_id")
 public Integer getId() {
  return this.id;
 }
 
 public void setId(Integer id) {
 	this.id = id;
 }
 
 /*
 @Column(name = "category_id")
 public Integer getCategoryId() {
	 return this.category_id;
 }
 
 public void setCategoryId(Integer category_id) {
	 this.category_id = category_id;
 }
 */
 /*
 @Column(name = "shoppingcart_id")
 public Integer getShoppingCartId() {
	 return this.shoppingcart_id;
 }
 
 public void setShoppingCartId(Integer shoppingcart_id) {
	 this.shoppingcart_id = shoppingcart_id;
 }
 */
 
 @Column(name="product_name", nullable=false)
 public String getName() {
  return this.name;
 }
 
 public void setName(String name) {
	 this.name = name;
 }

 @Column(name="product_price", nullable=false, precision=22, scale=0)
 public double getPrice() {
  return price;
 }
 
 public void setPrice(double price) {
	  this.price = price;
 }
 
 @Column(name="product_msrp", nullable=true, precision=22, scale=0)
 public double getMsrpPrice() {
  return this.msrp;
 }
 
 public void setMsrpPrice(double price) {
	  this.price = price;
 }
 
 @Column(name="product_quantity", nullable=true)
 public int getQuantity() {
	 return this.quantity;
 }
 
 public void setQuantity(int quantity) {
	 this.quantity = quantity;
 }
 
 @Column(name="product_description", nullable=true)
 public String getDescription() {
  return this.description;
 }
  
 public void setDescription(String description) {
  this.description = description;
 }
 
 @OneToMany(fetch = FetchType.EAGER, mappedBy = "product", cascade=CascadeType.ALL)
 public Set<ProductDetail> getProductDetail() {
	 return this.productDetails;
 }
 
 public void setProductDetail(Set<ProductDetail> productDetails) {
	 this.productDetails = productDetails;
 }
 
 @ManyToOne(fetch = FetchType.EAGER)
 @JoinColumn(name = "category_id", nullable = false)
 public Category getCategory() {
     return category;
 }
 
 public void setCategory(Category category) {
	 this.category = category;
 }

 /*
 @ManyToMany(mappedBy = "products")
 public Set<Order> getOrders() {
	 return this.orders;
 }
 
 public void setOrders(Set<Order> orders) {
	 this.orders = orders;
 }
 */
 
 @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
 public Set<OrderLine> getOrderLines() {
	 return this.orderLines;
 }
 
 public void setOrderLines(Set<OrderLine> orderLines) {
	 this.orderLines = orderLines;
 }
 
 
 
 public void calculateQuantity() {
	 Iterator<ProductDetail> iter = this.productDetails.iterator();
	 this.quantity = 0;
	 while(iter.hasNext()){
		 this.quantity += iter.next().getQuantity();
	 }
 }
 
 public void addToQuantity(int quantity) {
	 this.quantity += quantity;
 }
 
 @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
 public Set<CartProduct> getCartProducts() {
	 return this.cartProducts;
 }
 
 public void setCartProducts(Set<CartProduct> cartProducts) {
	 this.cartProducts = cartProducts;
 }
 
 @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
 public Set<Inventory> getDailyInventory() {
	 return this.dailyInventory;
 }
 
 public void setDailyInventory(Set<Inventory> dailyInventory) {
	 this.dailyInventory = dailyInventory;
 }
 
 /*
 @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
 public Set<Product_Order> getProduct_Order() {
	return product_Order;
 } 
 public void setProduct_Order(
	Set<Product_Order> product_Order) {
	 	this.product_Order = product_Order;
 }
 */
 /*
 @ManyToMany(fetch = FetchType.EAGER, mappedBy = "products")
 public Set<Cart> getCarts() {
	 return this.carts;
 }
 
 public void setCarts(Set<Cart> carts) {
	 this.carts = carts;
 }
*/
 
 /*
 @Override
 public int hashCode() {
     final int prime = 31;
     int result = 1;
     result = prime * result + ((productPk == null) ? 0 : productPk.hashCode());
     
     return result;
 }
  */
 /**
  * (non-Javadoc)
  * 
  * @see java.lang.Object#equals(java.lang.Object)
  */
 /*
 @Override
 public boolean equals(Object obj) {
     if (this == obj) {
         return true;
     }
     if (obj == null) {
         return false;
     }
     if (!(obj instanceof Product)) {
         return false;
     }
     Product other = (Product) obj;
     if (productPk == null) {
         if (other.productPk != null) {
             return false;
         }
     } else if (!productPk.equals(other.productPk)) {
         return false;
     }
   
     return true;
 }
*/
}

