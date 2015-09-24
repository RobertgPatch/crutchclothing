package com.crutchclothing.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crutchclothing.orders.dao.OrderDao;
import com.crutchclothing.orders.model.Order;
import com.crutchclothing.orders.model.OrderLine;
import com.crutchclothing.orders.model.Shipment;
import com.crutchclothing.products.model.Product;
import com.crutchclothing.users.model.User;

@Service("orderService")
public class OrderService {
	
	@Autowired
	OrderDao orderDao;
	
	public void saveOrder(Order order, Integer shipmentId, Integer billingId) {
		orderDao.saveOrder(order, shipmentId, billingId);
	}
	
	public List<Order> findAllOrders() {
		return orderDao.findAllOrders();
	}
	
	public Order findOrderById(Integer orderId) {
		return orderDao.findOrderById(orderId);
	}
	
	public void saveOrderLine(OrderLine orderLine) {
		orderDao.saveOrderLine(orderLine);
	}
	
	public OrderLine findOrderLine(Integer productId, Integer orderId) {
		return orderDao.findOrderLine(productId, orderId);
	}
	
	public void updateUserWithOrder(Order order, User user) {
		orderDao.updateUserWithOrder(order, user);
	}
	
	public void saveShipment(Shipment shipment) {
		orderDao.saveShipment(shipment);
	}
	
	public void saveAddressToShipment(Shipment shipment, Integer addressId) {
		orderDao.saveAddressToShipment(shipment, addressId);
	}
	
	//public addOrderLineToOrder(OrderLine orderLine, Order)
}
	
