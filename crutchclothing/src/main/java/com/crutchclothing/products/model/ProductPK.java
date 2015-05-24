package com.crutchclothing.products.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;



@Embeddable
public class ProductPK implements Serializable { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer product_id;
	
	//@GeneratedValue
	@Column(name="product_id")
	public Integer getProductId() {
		return this.product_id;
	}
	
	public void setProductId(Integer product_id) {
		this.product_id = product_id;
	}
	
	 /** (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((product_id == null) ? 0 : product_id.hashCode());
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
        if (!(obj instanceof ProductPK)) {
            return false;
        }
        ProductPK other = (ProductPK) obj;
        if (product_id == null) {
            if (other.product_id != null) {
                return false;
            }
        } else if (!product_id.equals(other.product_id)) {
            return false;
        }
        
        return true;
    }
}