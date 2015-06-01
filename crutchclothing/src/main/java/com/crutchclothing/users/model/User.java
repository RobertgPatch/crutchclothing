package com.crutchclothing.users.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import com.crutchclothing.cart.model.Cart;
import com.crutchclothing.orders.model.Order;


@Entity
@Table(name = "users", catalog = "crutch")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String stripeId;
	private String firstName;
	//private String middleInit;
	//private String lastName;
	//private String phoneNumber;
	private String password;
	private String passwordConf;
	private String email;
	private LocalDate memberSince;
	private boolean enabled;
	private Set<UserRole> userRole = new HashSet<UserRole>(0);
	private Set<Order> orders = new HashSet<Order>(0);
	private Set<Address> addresses = new HashSet<Address>(0);
	private Cart userCart = new Cart();
	private Address newAddress = null;
	//private Address shipAddress = null;

	public User() {
	}

	public User(String username, String password, String email, boolean enabled) {
		
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
	}

	public User(String username, String password, String email, boolean enabled,
			Set<UserRole> userRole) {
		
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.userRole = userRole;
	}

	@Id
	@Column(name = "username", unique = true, nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="stripe_id", unique = true, nullable = true)
	public String getStripeId() {
		return stripeId;
	}

	public void setStripeId(String stripeId) {
		this.stripeId = stripeId;
	}
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
	@JsonIgnore
	public Cart getUserCart() {
		return this.userCart;
	}
	
	public void setUserCart(Cart userCart) {
		this.userCart = userCart;
	}
	
	/*
	@Transient
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	@Column(name = "middle_init", unique = false, nullable = true, length = 45)
	public String getMiddleInit() {
		return this.middleInit;
	}
	
	public void setMiddleInit(String middleInit) {
		this.middleInit = middleInit;
	}
	
	@Column(name = "last_name", unique = false, nullable = false, length = 45)
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "phone_number", unique = false, nullable = true, length = 45)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	*/
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "users")
	public Set<Address> getAddresses() {
		return this.addresses;
	}
	
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
	/*
	@Column(name = "address_1", unique = false, nullable = false, length = 100)
	public String getAddress1() {
		return this.address1;
	}
	
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	@Column(name = "address_2", unique = false, nullable = true, length = 100)
	public String getAddress2() {
		return this.address2;
	}
	
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	@Column(name = "address_3", unique = false, nullable = true, length = 100)
	public String getAddress3() {
		return this.address3;
	}
	
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	
	
	
	@Column(name = "city", unique = false, nullable = false)
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "state", unique = false, nullable = false)
	public String getState() {
		return this.state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	*/
	
	@Column(name = "password", nullable = false, length = 255)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Transient
	public String getPasswordConf() {
		return this.passwordConf;
	}

	public void setPasswordConf(String passwordConf) {
		this.passwordConf = passwordConf;
	}
	
	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Columns(columns = { @Column(name = "member_since", nullable = false) })
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    public LocalDate getMemberSince() {
		return this.memberSince;
	}
	
	public void setMemberSince(LocalDate memberSince) {
		this.memberSince = memberSince;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	@JsonIgnore
	public Set<UserRole> getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	public Set<Order> getOrders() {
		return this.orders;
	}
	
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	
	@Transient
	public Address getNewAddress() {
		//List<Address> addresses = new ArrayList<>(this.addresses);
		
		return this.newAddress;
	}
	
	public void setNewAddress(Address newAddress) {
		this.newAddress = newAddress;
	}
	/*
	@Transient
	public Address getShipAddress() {
		
		return this.shipAddress;
	}
	
	public void setShipAddress(Address shipAddress) {
		this.shipAddress = shipAddress;
	}
	*/
	
	public void deleteAddress(Address address) {
		addresses.remove(address);
	}
	
	@Transient
	public String getTopRole(){
		for(UserRole role : userRole) {
			if(role.getRole().contains("ADMIN")) {
				return role.getShortName();
			}
		}
		
		return ("User");
	}


}
