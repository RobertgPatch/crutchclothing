package com.crutchclothing.orders.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.hibernate.loader.custom.Return;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.crutchclothing.users.model.Address;
import com.crutchclothing.users.model.User;

@Entity
@Table(name="orders", catalog="crutch")
public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static double TAX_RATE = 8.25000;
	private Integer id;
	private Integer orderNumber;
	private DateTime orderDate;
	private double salesTax;
	private double orderTotal;
	private OrderStatus orderStatus;
	private User user;
	private Set<OrderLine> orderLines = new HashSet<OrderLine>();
	private Shipment shipment;
	private Address billingAddress;
	private boolean cardSaved;
	
	public Order() {
		
	}
	
	
	//@GeneratedValue
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "order_number", unique = true, nullable = false)
	public Integer getOrderNumber() {
		return this.orderNumber;
	}
	
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	
	@Columns(columns = { @Column(name = "order_date_time", nullable = false),
    @Column(name = "order_date_time_zone", nullable = false) })
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTimeWithZone")
	public DateTime getOrderDate() {
		return this.orderDate;
	}
	
	public void setOrderDate(DateTime orderDate) {
		this.orderDate = orderDate;
	}
	
	@Column(name = "order_sales_tax", nullable = true)
	public double getSalesTax() {
		

			//if(user.getPrimaryAddress().getState().equalsIgnoreCase("california")) {
			double orderTotal = getOrderTotal();
			return (this.salesTax = orderTotal * (TAX_RATE/100));
		
		//return (this.salesTax = 0);
	}
	
	public void setSalesTax(double salesTax) {
		this.salesTax = salesTax;
	}
	
	@Column(name = "order_total", nullable = true)
	public double getOrderTotal() {
		List<OrderLine> oLines = new ArrayList<OrderLine>(this.orderLines);
		this.orderTotal = 0;
		for(int i = 0; i < oLines.size(); i++){
			this.orderTotal += oLines.get(i).getSubtotal();
		}
		return this.orderTotal;
	}
	
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "order_status", nullable = true)
	public OrderStatus getOrderStatus() {
		return this.orderStatus;
	}
	
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false) 
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	/*
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "order_products", 
                joinColumns = { @JoinColumn(name = "order_id") }, 
                inverseJoinColumns = { @JoinColumn(name = "product_id") }) 
    public Set<Product> getProducts() {
    	return this.products;
    }
	*/
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
	public Set<OrderLine> getOrderLines() {
		return this.orderLines;
	}
	
	 
	public void setOrderLines(Set<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "billing_address_id")
	public Address getBillingAddress() {
		return this.billingAddress;
	}
	
	 
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	

	@Transient
	public boolean isCardSaved() {
		return this.cardSaved;
	}


	public void setCardSaved(boolean cardSaved) {
		this.cardSaved = cardSaved;
	}
	
	//@OneToOne(mappedBy="order")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "shipment_id")
	public Shipment getShipment() {
		return this.shipment;
	}
	
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}
	

	/*
	public void addProduct(Product product) {
    	products.add(product);
    }
	 */
	
	/*
	 @Override
	 public int hashCode() {
	     final int prime = 31;
	     int result = 1;
	     result = prime * result + ((orderPk == null) ? 0 : orderPk.hashCode());
	     
	     return result;
	 }
	  
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
	     if (!(obj instanceof Order)) {
	         return false;
	     }
	     Order other = (Order) obj;
	     if (orderPk == null) {
	         if (other.orderPk != null) {
	             return false;
	         }
	     } else if (!orderPk.equals(other.orderPk)) {
	         return false;
	     }
	    
	     return true;
	 }
	 
	public enum OrderStatus {
		
	}
	*/
	public enum OrderStatus {
		INCOMPLETE("Incomplete"), COMPLETE("Complete"), SHIPPED("shippied"), 
			REFUNDED("Refunded"), PARTIALLY_REFUNDED("Partially Refunded"), 
			CANCELLED("Canelled");
		
		private String status;
		private OrderStatus(String status) {
			this.status = status;
		}
		public String getStatus() {
			return this.status;
		}
		
	}
}

