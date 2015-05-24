package com.crutchclothing.orders.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ForeignKey;

import com.crutchclothing.products.model.Product;
import com.crutchclothing.products.model.Size;


@Entity
@Table(name="order_line", catalog="crutch")
public class OrderLine implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private Id id = new Id();
	
	@ManyToOne
	@JoinColumn(name = "product_id", insertable = false, updatable = false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "order_id", insertable = false, updatable = false)
	private Order order;	
	
	@Column(name = "product_quantity")
	private int productQuantity;
	
	@Column(name = "subtotal")
	private double subtotal;
	
	@Column(name = "size")
	private String size;
	
	@Column(name = "color")
	private String color;
	/*
	@Id 
	@GeneratedValue
	//@AttributeOverride(name="product_id", column=@Column(name="product_id"))
    public Integer product_id;
	
	@EmbeddedId 
	@GeneratedValue
	//@AttributeOverride(name="order_id", column=@Column(name="order_id"))
	private Integer order_id;
	*/
	/*
	@Id
	@AttributeOverrides({
	@AttributeOverride(name = "product_id",
	column = @Column(name="product_id")),
	@AttributeOverride(name = "order_id",
	column = @Column(name="order_id"))
	})
	*/
	
   // public Integer product_id;
   // public Integer order_id;
	//private OrderLineId orderLineId;
	
	//private Product product;
	//private Order order;
	
	
	@Embeddable
	public static class Id implements Serializable {
		
		@Column(name = "product_id")
		private Integer productId;
		
		@Column(name = "order_id")
		private Integer orderId;
		
		public Id() {}
		
		public Id(Integer productId, Integer orderId) {
			this.productId = productId;
			this.orderId = orderId;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj != null && obj instanceof Id) {
				Id that = (Id)obj;
				return this.productId.equals(that.productId) && this.orderId.equals(that.orderId);
			}
			return false;
		}

		@Override
		public int hashCode() {
			return orderId.hashCode() + productId.hashCode();
		}
		
		
	}
	
	public OrderLine(){}
	
	public OrderLine(Product product, Order order, int productQuantity, double subtotal, String size, String color) {
		this.product = product;
		this.order = order;
		this.productQuantity = productQuantity;
		this.subtotal = subtotal;
		this.size = size;
		this.color = color;
		this.getId().productId = product.getId();
		this.getId().orderId = order.getId();
	}
	
	public OrderLine(Product product, Order order) {
		this.product = product;
		this.order = order;
		this.getId().productId = product.getId();
		this.getId().orderId = order.getId();
	}
	
	
	
	/*
	public OrderLineId getOrderLineId() {
		return this.orderLineId;
	}
	
	public void setOrderLineId (OrderLineId orderLineId) {
		this.orderLineId = orderLineId;
	}
	*/
	/*
	@Id 
	@Column(name = "product_id", insertable= false, updatable= false)
	public Integer getProductId() {
		return this.product_id;
	}
	
	public void setProductId(Integer product_id) {
		this.product_id = product_id;
	}
	
	@Id 
	@Column(name = "order_id", insertable= false, updatable= false)
	public Integer getOrderId() {
		return this.order_id;
	}
	
	public void setOrderId(Integer order_id) {
		this.order_id = order_id;
	}
	

	*/
	
	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}
	
	
	public Product getProduct() {
		return this.product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Order getOrder() {
		return this.order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public int getProductQuantity() {
		return this.productQuantity;
	}
	
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	
	public double getSubtotal() {
		return this.product.getPrice() * this.productQuantity;
	}
	
	public void setSubtotal(double subtotal) { 
		this.subtotal = subtotal;
	}
	
	public String getSize() {
		return this.size;
	}
	
	public void setSize(String size) { 
		this.size = size;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) { 
		this.color = color;
	}
	
	
	//@AttributeOverride(name="produtc_id", column=@Column(name="product_id"))
	//@ManyToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name = "product_id", nullable = false)
	/*
	 @ManyToOne
	 @JoinColumns ({
	        @JoinColumn(name="product_id", referencedColumnName = "product_id")
	 })
	 */
	//@Id
	//@GeneratedValue
   // @ManyToOne
   // @JoinColumn(name = "product_id")
    //@Id
	
	
	/*
    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
	public Product getProduct() {
		return this.product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	*/
	//@EmbeddedId
	//@AttributeOverride(name="order_id", column=@Column(name="order_id"))
	//@ManyToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name = "order_id", nullable = false)
	/*
	@ManyToOne
	@JoinColumns ({
	        @JoinColumn(name="order_id", referencedColumnName = "order_id")
	 })
	 */
	////@Id
	//@GeneratedValue
    //@ManyToOne
    //@JoinColumn(name = "order_id")
	//@Id
	/*
	@ManyToOne
	@JoinColumn(name = "order_id", insertable = false, updatable = false)
	public Order getOrder() {
		return this.order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	*/
}
