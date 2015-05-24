package com.crutchclothing.orders.dao;

import java.util.List;

import com.crutchclothing.orders.model.Order;
import com.crutchclothing.orders.model.OrderLine;
import com.crutchclothing.products.model.Product;
import com.crutchclothing.users.model.User;

public interface OrderDao {
	
	void saveOrder(Order order);
	
	List<Order> findAllOrders();
	
	Order findOrderById(Integer orderId);
	
	void saveOrderLine(OrderLine orderLine);
	
	void addOrderLineToOrder(OrderLine orderLine, Order order);
	
	OrderLine findOrderLine(Integer orderId, Integer productId);
	
	void updateUserWithOrder(Order order, User user);

	
}
