package com.crutchclothing.products.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "category", catalog="crutch")
public class Category implements Serializable{
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
    private String name;
    private Set<Product> products = new HashSet<Product>();
    private int productSize = 0;
    
    public Category() {
    }
 
    public Category(String name) {
        this.name = name;
    }
    
    public Category(String name, Set<Product> products) {
        this.name = name;
        this.products = products;
    }
 
    @Id
    @Column(name = "category_id")
    @GeneratedValue
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
    	this.id = id;
    }
    @Column(name = "category_name", nullable=false)
    public String getName() {
    	return this.name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
 
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> items) {
    	this.products = items;
    }
    
    @Transient
    public Integer getProductSize() {
    	productSize = products.size();
    	return this.productSize;
    }
    
    public void setProductSize(Integer productSize) {
    	this.productSize = productSize;
    }
    
    
 
}
