package com.crutchclothing.orders.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.IdClass;

//@IdClass(OrderLineId.class)
public class OrderLineId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer order_id;
	private Integer product_id;
	
	public OrderLineId(){}
	
	public OrderLineId(Integer order_id, Integer product_id) {
		this.order_id = order_id;
		this.product_id = product_id;
	}
	
	//@Column(name = "order_id")
	public Integer getOrder() {
		return this.order_id;
	}
	
	public void setOrder(Integer order_id) {
		this.order_id = order_id;
	}
	
	//@Column(name = "product_id")
	public Integer getProduct() {
		return this.product_id;
	}
	
	public void setProduct(Integer product_id) {
		this.product_id = product_id;
	}
	
	  @Override
	    public int hashCode() {
	        return order_id + product_id;
	    }
	 
	    @Override
	    public boolean equals(Object obj) {
	        if(obj instanceof OrderLineId){
	        	OrderLineId orderLineId = (OrderLineId) obj;
	            return orderLineId.order_id == order_id && orderLineId.product_id == product_id;
	        }
	 
	        return false;
	    }
}
