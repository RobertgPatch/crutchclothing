package com.crutchclothing.inventory;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import com.crutchclothing.products.model.Product;
import com.crutchclothing.products.model.ProductDetail;

@Entity
@Table(name="daily_inventory", catalog="crutch")
public class Inventory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private LocalDate date;
	private int amount;
	private ProductDetail productDetail;
	
	public Inventory() {
		this.date = new LocalDate();
	}
	
	public Inventory(ProductDetail productDetail) {
		this.date = new LocalDate();
		this.productDetail = productDetail;
	}
	
	public Inventory(ProductDetail productDetail, int amount) {
		this.date = new LocalDate();
		this.productDetail = productDetail;
		this.amount = amount;
	}
	

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "inventory_id")
	 public Integer getId() {
	  return this.id;
	 }
	 
	 public void setId(Integer id) {
	 	this.id = id;
	 }
	
	@Columns(columns = { @Column(name = "date_of_inventory", nullable = false) })
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	@Column(name = "amount", nullable = true)
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_detail_id", nullable = false)
	public ProductDetail getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}
}
