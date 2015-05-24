package com.crutchclothing.inventory;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import com.crutchclothing.products.model.Product;

@Entity
@Table(name="daily_inventory", catalog="crutch")
public class Inventory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDate date;
	private int amount;
	private Product product;
	
	public Inventory() {
		this.date = new LocalDate();
	}
	
	public Inventory(Product product) {
		this.date = new LocalDate();
		this.product = product;
	}
	
	public Inventory(Product product, int amount) {
		this.date = new LocalDate();
		this.product = product;
		this.amount = amount;
	}
	
	@Id
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
	@JoinColumn(name = "product_id", nullable = false)
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
