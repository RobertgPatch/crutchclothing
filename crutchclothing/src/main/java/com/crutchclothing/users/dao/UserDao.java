package com.crutchclothing.users.dao;

import java.util.List;
import java.util.Set;

import com.crutchclothing.users.model.Address;
import com.crutchclothing.users.model.User;
import com.crutchclothing.util.AddressType;

public interface UserDao {

	User findByUserName(String username);

	void addUser(User user);
	
	//void addUserWithCart(User user, Cart cart);
	
	String findStripeId(String email);
	
	void updateUser(String namne, User user);
	
	void saveAddress(String username, Address address);
	
	void deleteAddress(String username, Integer addressId);
	
	Address findAddress(Integer addressId);
	
	List<User> findAllUsers();
	
	List<User> getUserSet(int currPosition, int pageSize);
	
	void updateUserAddressType(Integer addressId, AddressType addressType);
	
	void deleteUser(String username);
	
}