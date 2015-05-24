package com.crutchclothing.orders.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;



@Embeddable
public class OrderPK implements Serializable { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer order_id;
	
	//@GeneratedValue
	@Column(name="order_id")
	public Integer getOrderId() {
		return this.order_id;
	}
	
	public void setOrderId(Integer order_id) {
		this.order_id = order_id;
	}
	
	 /** (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
        return result;
    }
 
    /** (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof OrderPK)) {
            return false;
        }
        OrderPK other = (OrderPK) obj;
        if (order_id == null) {
            if (other.order_id != null) {
                return false;
            }
        } else if (!order_id.equals(other.order_id)) {
            return false;
        }
        
        return true;
    }
}