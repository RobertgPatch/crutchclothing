package com.crutchclothing.cart.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionService;

import com.crutchclothing.products.model.Product;
import com.crutchclothing.products.model.ProductDetail;
import com.crutchclothing.users.model.User;

@Entity
@Table(name = "cart", catalog="crutch")
public class Cart implements Serializable{
 
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer cart_id;
    
    private double total;
 
    //private Set<Product> products = new HashSet<>(0);
    
    private Set<CartProduct> cartProducts = new HashSet<CartProduct>(0);
    
    private User user;
    
    private int size;
    
    public Cart() {
    	
    }
    
    //public Cart(Set<Product> products) {
    	//this.products = products;
    //}
    
    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getCartId() {
    	return this.cart_id;
    }
    
    public void setCartId(Integer cart_id) {
    	this.cart_id = cart_id;
    }
    
    @Column(name = "cart_total")
    public double getTotal() {
    	return computeTotal();
    }
    
    private double computeTotal() {
    	double total = 0;
    	for(CartProduct cartProduct : cartProducts) {
    		for(CartProductRef cpr : cartProduct.getCartProductRefs()) {
    			total += (cartProduct.getProduct().getPrice() * cpr.getProductQuantity());
    		}
    	}
    	return round(total, 2);
    }
    
    public void setTotal(double total) {
    	this.total = total;
    }
    
    /*
    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "cart_products", 
                joinColumns = { @JoinColumn(name = "cart_id") }, 
                inverseJoinColumns = { @JoinColumn(name = "product_id") }) 
    public Set<Product> getProducts() {
    	return this.products;
    }
    
    public void setProducts(Set<Product> products) {
    	this.products = products;
    }
    */
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cart")
    public Set<CartProduct> getCartProducts() {
     this.total = computeTotal();
   	 return this.cartProducts;
    }
    
    public void setCartProducts(Set<CartProduct> cartProducts) {
    	this.total = computeTotal();
    	this.cartProducts = cartProducts;
    }
    
    @OneToOne(mappedBy="userCart")
    public User getUser() {
    	return this.user;
    }
    
    public void setUser(User user) {
    	this.user = user;
    }
    
    @Transient
    public int getTotalQuantity() {
    	int totalQ = 0;
    	for(CartProduct cartProduct : cartProducts) {
    		for(CartProductRef cpr : cartProduct.getCartProductRefs()) {
    		//ProductDetail productDetail = cpr.getProductDetail();	
    		totalQ += cpr.getProductQuantity();
    		}
    	}
    	return totalQ;
    }
    
    /*
    public void addProduct(Product product) {
    	this.total += product.getPrice();
    	products.add(product);
    }
    
    public void removeProduct(String name) {
    	Product foundProduct = findCartProduct(name);
    	if(foundProduct != null) {
    		this.total -= foundProduct.getPrice();
    		products.remove(foundProduct);
    	}
    }
    
    public void removeProduct(Integer cart_id) {
    	Product foundProduct = findCartProduct(cart_id);
    	if(foundProduct != null) {
    		this.total -= foundProduct.getPrice();
    		products.remove(foundProduct);
    	}
    }
    
    @Transient
    public int getCartSize() {
    	this.size = this.products.size();
    	return this.size;
    }
    */
    /*
    private double calculateTotal() {
    	double total = 0;
    	for(Product p: products) {
    		total += p.getPrice();
    	}
    	return total;
    }
    */
    /*
    private Product findCartProduct(String name) {
    	for(Product p : products) {
    		if(p.getName().equalsIgnoreCase(name)) {
    			return p;
    		}
    	}
    	return null;
    }
    
    private Product findCartProduct(Integer cart_id) {
    	for(Product p : products) {
    		if(p.getId() == cart_id) {
    			return p;
    		}
    	}
    	return null;
    }
    */
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
 

}