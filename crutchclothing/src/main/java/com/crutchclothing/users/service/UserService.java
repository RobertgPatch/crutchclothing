package com.crutchclothing.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import com.crutchclothing.users.dao.UserDao;
import com.crutchclothing.users.model.Address;
import com.crutchclothing.users.model.User;
import com.crutchclothing.util.AddressType;

@Service("userService")
public class UserService {
	
	//@Autowired
	private UserDao userDao;
	
	
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	public void updateUser(String name, User user) {
		userDao.updateUser(name, user);
	}
	
	public void saveAddress(String username, Address address) {
		userDao.saveAddress(username, address);
	}
	
	public Address findAddress(Integer addressId) {
		return userDao.findAddress(addressId);
	}
	
	public void deleteAddress(String username, Integer addressId) {
		userDao.deleteAddress(username, addressId);
	}
	public User findUser(String username) {
		return userDao.findByUserName(username);
	}
	
	
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}
	
	public List<User> findUserSet(int currPosition, int pageSize) {
		return userDao.getUserSet(currPosition, pageSize);
	}
	
	public boolean userExists(User user) {
		if(userDao.findByUserName(user.getUsername()) != null) {
			return true;
		}
		return false;
	}
	
	public void updateUserAddressType(Integer addressId, AddressType addressType) {
		userDao.updateUserAddressType(addressId, addressType);
	}
	
	public UserDao getUserDao() {
		return this.userDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void deleteUser(String username) {
		this.userDao.deleteUser(username);
	}
	
	public String findStripeId(String username) {
		return this.userDao.findStripeId(username);
	}
}
