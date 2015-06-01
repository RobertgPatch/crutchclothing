package com.crutchclothing.orders.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
	private final static double TAX_RATE = 8.25;
	private Integer id;
	private String username;
	private Integer orderNumber;
	private LocalDate shipDate;
	private DateTime orderDate;
	private double salesTax;
	private double orderTotal;
	private double shippingPrice;
	private String shippingMethod;
	private String orderStatus;
	private String shippingCompany;
	private String trackingNumber;
	private User user;
	//private Set<Product> products = new HashSet<>();
	private Set<OrderLine> orderLines = new HashSet<OrderLine>();
	private Address billingAddress;
	private Address shippingAddress;
	
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
	
	@Columns(columns = { @Column(name = "ship_date", nullable = false) })
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    public LocalDate getShipDate() {
		return this.shipDate;
	}
	
	public void setShipDate(LocalDate shipDate) {
		this.shipDate = shipDate;
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
		for(int i = 0; i < oLines.size(); i++){
			this.orderTotal += oLines.get(i).getSubtotal();
		}
		return this.orderTotal;
	}
	
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	
	
	@Column(name = "order_status", nullable = true)
	public String getOrderStatus() {
		return this.orderStatus;
	}
	
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	@Column(name = "shipping_co", nullable = true)
	public String getShippingCompany() {
		return this.shippingCompany;
	}
	
	public void setShippingCompany(String shippingCompany) {
		this.shippingCompany = shippingCompany;
	}
	
	@Column(name = "shipping_price", nullable = true)
	public double getShippingPrice() {
		return shippingPrice;
	}


	public void setShippingPrice(double shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	
	@Column(name = "shipping_method")
	public String getShippingMethod() {
		return shippingMethod;
	}


	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}


	@Column(name = "tracking_number", nullable = true)
	public String getTrackingNumber() {
		return this.trackingNumber;
	}
	
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username", nullable = false) 
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
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "shipping_address_id")
	public Address getShippingAddress() {
		return this.shippingAddress;
	}
	
	 
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
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
	 */
}
