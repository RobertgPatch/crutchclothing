package com.crutchclothing.cart.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.crutchclothing.orders.model.Order;
import com.crutchclothing.products.model.Product;
import com.crutchclothing.products.model.ProductDetail;
import com.crutchclothing.users.model.User;

@Entity
@Table(name = "cart_products", catalog="crutch")
public class CartProduct implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	@EmbeddedId
	private CartProductId id = new CartProductId();
	*/
	
	
	private Integer cartProductId;
	private Product product;
	private Cart cart;
	//private int quantity;
	//private Set<CartProductDetail> cartProductDetails = new HashSet<CartProductDetail>();
	private Set<CartProductRef> cartProductRefs = new HashSet<CartProductRef>();
	
	/*
	@Column(name = "product_quantity")
	private int productQuantity;
		
	@Column(name = "product_size", insertable= false, updatable = false)
	private String productSize = "";
	
	@Column(name = "product_color")
	private String productColor;
	*/
	
	
	
	/*
		@Embeddable
		public static class CartProductId implements Serializable {

		private static final long serialVersionUID = 1L;

		@Column(name = "product_id")
		private Integer productId;
		
		@Column(name = "cart_id")
		private Integer cartId;
		
		public CartProductId() {}
		
		public CartProductId(Integer productId, Integer cartId) {
			this.productId = productId;
			this.cartId = cartId;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj != null && obj instanceof Id) {
				CartProductId that = (CartProductId)obj;
				return this.productId.equals(that.productId) && this.cartId.equals(that.cartId);
			}
			return false;
		}

		@Override
		public int hashCode() {
			return cartId.hashCode() + productId.hashCode();
		}
		
		
	}
	*/
	public CartProduct(){}
	
	public CartProduct(Product product, Cart cart) {
		this.product = product;
		this.cart = cart;
		//this.getId().productId = product.getId();
		//this.getId().cartId = cart.getCartId();
	}
	/*
	public CartProduct(Product product, Cart cart, Set<ProductDetail> productDetails /*String productSize, int productQuantity, String productColor*///) {
		/*
		this.product = product;
		this.cart = cart;
		this.getId().productId = product.getId();
		this.getId().cartId = cart.getCartId();
		//this.productDetails = productDetails;
		
		this.productSize = productSize;
		this.productQuantity = productQuantity;
		this.productColor = productColor;
		
	}
	*/
	/*
	public CartProductId getId() {
		return id;
	}

	public void setCartProductId(CartProductId id) {
		this.id = id;
	}
	*/
	
    @Id
    @Column(name = "cart_product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getCartProductId() {
		return this.cartProductId;
	}
	
	public void setCartProductId(Integer cartProductId) {
		this.cartProductId = cartProductId;
	}
	
	@ManyToOne(/*fetch = FetchType.EAGER*/)
	@JoinColumn(name = "product_id")
	public Product getProduct() {
		return this.product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cart_id")
	public Cart getCart() {
		return this.cart;
	}
	
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	/*
	@Column(name="product_quantity", nullable = true)
	public int getQuantity() {
		return this.quantity;
	}
	 
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	*/
	/*
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cartProduct", cascade=CascadeType.ALL)
	public Set<ProductDetail> getProductDetails() {
		return this.productDetails;
	}
	
	public void setProductDetails(Set<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}
	
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "cart_product_reference", 
                joinColumns = { @JoinColumn(name = "cart_product_id") }, 
                inverseJoinColumns = { @JoinColumn(name = "product_details_id") }) 
	public Set<ProductDetail> getProductDetails() {
		return this.productDetails;
	}
	
	public void setProductDetails(Set<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}
	*/
	
	@OneToMany(mappedBy = "cartProduct", cascade=CascadeType.ALL)
	public Set<CartProductRef> getCartProductRefs() {
		return this.cartProductRefs;
	}
	
	public void setCartProductRefs(Set<CartProductRef> cartProductRefs) {
		this.cartProductRefs = cartProductRefs;
	}
	
	/*
	public int getProductQuantity() {
		return this.productQuantity;
	}
	
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	public String getProductSize() {
		return this.productSize;
	}
	
	public void setProductSize(String productSize) { 
		this.productSize = productSize;
	}
	
	public String getProductColor() {
		return this.productColor;
	}
	
	public void setProductColor(String productColor) { 
		this.productColor= productColor;
	}
	*/
	
	

}
