package com.crutchclothing.users.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.crutchclothing.cart.model.CartProduct;
import com.crutchclothing.cart.model.CartProductRef;
import com.crutchclothing.config.EMF;
import com.crutchclothing.users.dao.UserDao;
import com.crutchclothing.users.model.Address;
import com.crutchclothing.users.model.User;
import com.crutchclothing.users.model.UserRole;
import com.crutchclothing.util.AddressType;

@Repository
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	

	@SuppressWarnings("unchecked")
	@Transactional
	public User findByUserName(final String username) {

		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession().createQuery("from User where username=?").setParameter(0, username)
				.list();
		//users = entityManager.createQuery("from User where username=?").setParameter(0, username).getResultList();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
		

	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public User findByUserNameWithRoles(final String username) {

		List<User> users = new ArrayList<User>();
		
		users = sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("username", username)).list();
				
//		users = sessionFactory.getCurrentSession().createQuery("from User where username=?").setParameter(0, username)
//				.list();
		//users = entityManager.createQuery("from User where username=?").setParameter(0, username).getResultList();

		if (users.size() > 0) {
			User user = users.get(0);
			Hibernate.initialize(user.getUserRole());
			return user;
			//return users.get(0);
		} else {
			return null;
		}
		

	}
	@Transactional
	public User findUserByNameWithProfile(final String username) {
		
		try {
			User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.eq("username", username)).uniqueResult();
			
			Hibernate.initialize(user.getUserCart());
			Hibernate.initialize(user.getUserRole());
			Hibernate.initialize(user.getAddresses());
			Hibernate.initialize(user.getOrders());
			
			return user;
		}	
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	@Transactional
	public User findUserByNameWithCart(final String username) {
		
		try {
			User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.eq("username", username)).uniqueResult();
			
			System.out.println("Before init user cart and quantity = " + user.getUserCart().getTotalQuantity());
			Hibernate.initialize(user.getUserCart());
			System.out.println("Before init user cart products quantity = " + user.getUserCart().getCartProducts().size());
			
			for(CartProduct cp : user.getUserCart().getCartProducts()) {
				Hibernate.initialize(cp);
				for(CartProductRef cpr : cp.getCartProductRefs()) {
					Hibernate.initialize(cpr);
				}
			}
			
			return user;
		}	
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public User getBySessionIdWithCartInfo(String sessionId) {
		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("sessionId", sessionId)).list();
//		users = sessionFactory.getCurrentSession().createQuery("from User where session_id=?").setParameter(0, sessionId)
//				.list();
		//users = entityManager.createQuery("from User where username=?").setParameter(0, username).getResultList();
		
		User user = null;
		if (users.size() > 0) {
			user = users.get(0);
		} else {
			return null;
		}
		
		Hibernate.initialize(user.getUserCart());
		
		for(CartProduct cp : user.getUserCart().getCartProducts()) {
			Hibernate.initialize(cp);
			for(CartProductRef cpr : cp.getCartProductRefs()) {
				Hibernate.initialize(cpr);
			}
		}
		
		return user;
		
	}
	@Override
	@Transactional
	public void addUser(User user) {
		
		//Cookie cookie
		UserRole userRole = null;
		LocalDate memberSince = null;
		LocalDate firstPageVisit = null;
		if(user.getUsername() == null) {
			userRole = new UserRole(user, "ROLE_ANONYMOUS");
			firstPageVisit = new LocalDate();
		}
		else {
			userRole = new UserRole(user, "ROLE_USER");
			removeAnonymousRole(user.getUserRole());
			memberSince =  new LocalDate();
		}
	
		user.setMemberSince(memberSince);
		user.setFirstPageVisit(firstPageVisit);
		//entityManager.persist(user);
		//entityManager.persist(userRole);
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		sessionFactory.getCurrentSession().persist(userRole);
		
	}
	
	@Override
	@Transactional
	public void deleteUserRole(UserRole userRole) {
		sessionFactory.getCurrentSession().delete(userRole);
	}
	/*
	@Override
	@Transactional
	public void addUserWithCart(User user, Cart cart) {
		UserRole userRole = new UserRole(user, "ROLE_USER");
		//user.getUserRole().add(userRole);
		//user.getUserRole().add(e)
		user.setMemberSince(new LocalDate());
		user.getUserRole().add(userRole);
		user.setUserCart(cart);
		Integer cartId = cart.getCartId();
		System.out.println("cart id = " + cartId);
		sessionFactory.getCurrentSession().persist(user);
		//sessionFactory.getCurrentSession().persist(userRole);
		
	}
	*/
	@Override
	@Transactional
	public List<User> findAllUsers() {
		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession().createQuery("from User").list();

		if (users.size() > 0) {
			return users;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> getUserSet(int currPosition, int pageSize) {
		  
		  return sessionFactory.getCurrentSession().createQuery("from User")
				  .setMaxResults(pageSize).setFirstResult(currPosition).list();
	}
	
	@Override
	@Transactional
	public void updateUser(String name, User user) {
		
		User currUser = findByUserName(name);
		
		currUser.setEmail(user.getEmail());
		
		//user.get
		//currUser.setFirstName(user.getFirstName());
		//currUser.setLastName(user.getLastName());
		//currUser.setMiddleInit(user.getMiddleInit());
		//currUser.setPhoneNumber(user.getPhoneNumber());

		sessionFactory.getCurrentSession().saveOrUpdate(currUser);
	}
	
	@Override
	@Transactional
	public void saveAddress(String username, Address address) {
		
		User user = findByUserName(username);
		user.getAddresses().add(address);
		if(user.getAddresses().size() == 1) {
			user.setNewAddress(address);
		}
		address.getUsers().add(user);
		sessionFactory.getCurrentSession().persist(address);
	}
	
	@Override
	@Transactional
	public Address findAddress(Integer addressId) {
		
		String hql = "from Address where address_id =?";
		List<Address> addresses = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,addressId).list();
		
		if (addresses.size() > 0) {
			return addresses.get(0);
		}
		
		return null;
	}
	
	@Override
	@Transactional
	public void deleteAddress(String username, Integer addressId) {
		
		String hql = "from Address where address_id = ?";
		List addresses = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, addressId).list();
		User user = findByUserName(username);
		
		if(addresses.size() > 0) {
			Address address = (Address) addresses.get(0);
			//user.deleteAddress(address);
			user.getAddresses().remove(address);
			
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			sessionFactory.getCurrentSession().delete(address);
		}
		
	}
	
	@Override
	@Transactional
	public void deleteUser(String username) {
		User user = findByUserName(username);
		for (UserRole role : user.getUserRole()) {
			this.sessionFactory.getCurrentSession().delete(role);
		}
		this.sessionFactory.getCurrentSession().delete(user);
	}
	@Override
	public void updateUserAddressType(Integer addressId, AddressType addressType) {
		
		Address currAddress = findAddress(addressId);
		currAddress.setAddressType(addressType);
		sessionFactory.getCurrentSession().saveOrUpdate(currAddress);
		
	}
	
	@Override
	@Transactional
	public String findStripeId(String username) {
		String id = null;
		
		User user = findByUserName(username);
		
		if(user != null) {
			id = user.getStripeId();
		}
		
		return id;
	}
	
	private void removeAnonymousRole(Set<UserRole> userRoles) {
		for(UserRole role : userRoles) {
			if(role.getRole().equals("ROLE_ANONYMOUS")) {
				deleteUserRole(role);
				break;
			}
		}
	}
	
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	

}