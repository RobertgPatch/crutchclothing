package com.crutchclothing.orders.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crutchclothing.orders.model.Order;
import com.crutchclothing.orders.model.OrderLine;
import com.crutchclothing.products.model.Category;
import com.crutchclothing.products.model.Product;
import com.crutchclothing.users.model.User;

@Repository
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void saveOrder(Order order) {
		
		/*
		Set<Product> products = order.getProducts();
		if(products != null) {
			for(Product p : products) {
				sessionFactory.getCurrentSession().saveOrUpdate(p);
			}
		}
		*/
		sessionFactory.getCurrentSession().save(order);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Order> findAllOrders() {
		List<Order> orders = new ArrayList<Order>();

		orders = sessionFactory.getCurrentSession().createQuery("from Order").list();

		if (orders.size() > 0) {
			return orders;
		} else {
			return null;
		}
	}

	
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public Order findOrderById(Integer orderId) {
		List<Order> orders = new ArrayList<Order>();

		orders = sessionFactory.getCurrentSession().createQuery("from Order where order_id = ?").setParameter(0, orderId)
				.list();

		if (orders.size() > 0) {
			return orders.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	@Transactional
	public void saveOrderLine(OrderLine orderLine) {
		sessionFactory.getCurrentSession().save(orderLine);
	}

	

	@Override
	@Transactional
	public void addOrderLineToOrder(OrderLine orderLine, Order order) {
		
		Order fOrder = findOrderById(order.getId());
		fOrder.getOrderLines().add(orderLine);
		
		sessionFactory.getCurrentSession().saveOrUpdate(fOrder);
		sessionFactory.getCurrentSession().persist(orderLine);
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public OrderLine findOrderLine(Integer orderId, Integer productId) {
		
		List<OrderLine> orderLines = new ArrayList<OrderLine>();
		orderLines = sessionFactory.getCurrentSession().createSQLQuery(
				"select * from order_line where order_id = " + orderId + 
				" and product_id = " + productId).list();
		
		if(orderLines == null) {
			return null;
		}
		else if(orderLines.size() > 0) {
			return orderLines.get(0);
		}
		else {
			return null;
		}

	}
	
	@Override
	@Transactional
	public void updateUserWithOrder(Order order, User user) {
		user.getOrders().add(order);
		order.setUser(user);
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	
}
