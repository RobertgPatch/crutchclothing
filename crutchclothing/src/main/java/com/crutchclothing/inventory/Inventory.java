package com.crutchclothing.inventory;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import com.crutchclothing.products.model.Color;
import com.crutchclothing.products.model.Product;
import com.crutchclothing.products.model.ProductDetail;
import com.crutchclothing.products.model.ProductStyle;
import com.crutchclothing.products.model.Size;

@Entity
@Table(name="daily_clothing_inventory", catalog="crutch")
public class Inventory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private LocalDate date;
	//private InventoryAmount inventoryAmount;
	private ProductDetail productDetail;
	private ProductStyle productStyle;
	//private Set<Color> colors;
	//private Size size;
	private int inventoryAmount;
	
	public Inventory() {
		this.date = new LocalDate();
	}
	
	public Inventory(ProductDetail productDetail) {
		this.date = new LocalDate();
		this.productDetail = productDetail;
	}
	
	/*
	public Inventory(ProductDetail productDetail, int amount) {
		this.date = new LocalDate();
		this.productDetail = productDetail;
		this.amount = amount;
	}
	*/
	public Inventory(ProductDetail productDetail/*, int amount*/, Size size, Set<Color> colors) {	
		this.productDetail = productDetail;
		//this.amount = amount;
		//this.size = size;
		//this.colors = colors;
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
	public int getInventoryAmount() {
		return inventoryAmount;
	}
	
	public void setInventoryAmount(int inventoryAmount) {
		this.inventoryAmount = inventoryAmount;
	}
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_detail_id", nullable = false)
	public ProductDetail getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_style_id", nullable = false)
	public ProductStyle getProductStyle() {
		return productStyle;
	}

	public void setProductStyle(ProductStyle productStyle) {
		this.productStyle = productStyle;
	}
	
	
	/*
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "dailyInventory")
	public Set<Color> getColors() {
		return colors;
	}

	public void setColors(Set<Color> colors) {
		this.colors = colors;
	}
	
	@Transient
	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}
	*/
}
