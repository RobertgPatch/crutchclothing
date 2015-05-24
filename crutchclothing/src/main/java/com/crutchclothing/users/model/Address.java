package com.crutchclothing.users.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.crutchclothing.util.AddressType;

@Entity
@Table(name = "addresses", catalog = "crutch")
public class Address implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String firstName;
	private String lastName;
	private String company;
	private String address1;
	private String city;
	private String state;
	private String zipcode;
	private String address2;
	private String address3;
	private String shortName;
	private AddressType addressType;
	private Set<User> users = new HashSet<User>();
	
	public Address(){
	}
	
	public Address(String firstName, String lastName, String address1, String city, String state, String zipcode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address1 = address1;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	public Address(String firstName, String lastName, String address1, String address2, String city, String state, String zipcode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	public Address(String firstName, String lastName, String address1, String address2, String address3, String city, String state, String zipcode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	@Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "first_name")
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name")
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="company")
	public String getCompany() {
		return this.company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Column(name = "address1")
	public String getAddress1() {
		return this.address1;
	}
	
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	@Column(name = "address2")
	public String getAddress2() {
		return this.address2;
	}
	
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	@Column(name = "address3")
	public String getAddress3() {
		return this.address3;
	}
	
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	
	@Column(name = "city")
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "state")
	public String getState() {
		return this.state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name = "zipcode")
	public String getZipcode() {
		return this.zipcode;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "user_addresses", 
                joinColumns = { @JoinColumn(name = "address_id") }, 
                inverseJoinColumns = { @JoinColumn(name = "username") }) 
	public Set<User> getUsers() {
		return this.users;
	}
	
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "address_type")
	public AddressType getAddressType() {
	    return this.addressType;
	}
	
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
	
	@Transient
	public String getShortName() {
		String firstName = capitalizeName(this.firstName);
		String lastInit = this.lastName.substring(0, 1).toUpperCase() + ".";
		
		this.shortName = (firstName + " " + lastInit);
		
		return this.shortName;
	}
	
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	

	private String capitalizeName(String name) {
		String formattedName = name.substring(0,1).toUpperCase() + name.substring(1, name.length()).toLowerCase();
		return formattedName;
	}
	
	

}
