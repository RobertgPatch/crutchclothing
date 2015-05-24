package com.crutchclothing.cart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.crutchclothing.orders.model.Order;
import com.crutchclothing.orders.model.OrderLine.Id;
import com.crutchclothing.products.model.Product;
import com.crutchclothing.products.model.ProductDetail;

@Entity
@Table(name="cart_product_ref", catalog="crutch")
public class CartProductRef implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private Id id = new Id();
	
	@ManyToOne
	@JoinColumn(name = "product_details_id", insertable = false, updatable = false)
	private ProductDetail productDetail;
	
	@ManyToOne
	@JoinColumn(name = "cart_product_id", insertable = false, updatable = false)
	private CartProduct cartProduct;	
	
	@Column(name = "product_quantity")
	private int productQuantity;
	
	
	@Embeddable
	public static class Id implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Column(name = "product_details_id")
		private Integer productDetailsId;
		
		@Column(name = "cart_product_id")
		private Integer cartProductId;
		
		public Id() {}
		
		public Id(Integer productDetailsId, Integer cartProductId) {
			this.productDetailsId = productDetailsId;
			this.cartProductId = cartProductId;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj != null && obj instanceof Id) {
				Id that = (Id)obj;
				return this.productDetailsId.equals(that.productDetailsId) 
						&& this.cartProductId.equals(that.cartProductId);
			}
			return false;
		}

		@Override
		public int hashCode() {
			return cartProductId.hashCode() + productDetailsId.hashCode();
		}
		
		
	}
	
	public CartProductRef() {
		
	}
	
	public CartProductRef(ProductDetail productDetail, CartProduct cartProduct, int productQuantity) {
		this.productDetail = productDetail;
		this.cartProduct = cartProduct;
		this.productQuantity = productQuantity;
		this.id.cartProductId = cartProduct.getCartProductId();
		this.id.productDetailsId = productDetail.getId();
	}
	
	public Id getId() {
		return this.id;
	}
	
	public void setId(Id id) {
		this.id = id;
	}
	
	public ProductDetail getProductDetail() {
		return this.productDetail;
	}
	
	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}
	
	public CartProduct getCartProduct() {
		return this.cartProduct;
	}
	
	public void setCartProduct(CartProduct cartProduct) {
		this.cartProduct = cartProduct;
	}
	
	public int getProductQuantity() {
		return this.productQuantity;
	}
	
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
}
