package com.crutchclothing.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crutchclothing.cart.model.Cart;
import com.crutchclothing.inventory.Inventory;
import com.crutchclothing.orders.model.OrderLine;
import com.crutchclothing.products.dao.ProductDao;
import com.crutchclothing.products.model.Category;
import com.crutchclothing.products.model.Color;
import com.crutchclothing.products.model.Product;
import com.crutchclothing.products.model.ProductDetail;
import com.crutchclothing.products.model.ProductStyle;
import com.crutchclothing.products.model.Size;

@Service("productService")
public class ProductService {
	
	//@Autowired
	private ProductDao productDao;
	

	public void addProduct(Product product, ProductDetail details) {
		productDao.addProduct(product, details);
	}
	
	public Product findProduct(String name) {
		return productDao.findProduct(name);
	}
	
	public void updateProduct(Product product, ProductDetail details) {
		productDao.updateProduct(product, details);
	}
	
	/*
	public void updateProductInventory(Product product, Inventory inventory) {
		productDao.updateProductInventory(product, inventory);
	}
	*/
	
	public ProductDetail findProductDetail(Product product, String size) {
		return productDao.findProductDetail(product, size);
	}
	
	public Product findProduct(Integer id) {
		return productDao.findProduct(id);
	}
	
	public Category findCategory(String name) {
		return productDao.findCategory(name);
	}
	
	public Category findCategory(Integer Id) {
		return productDao.findCategoryById(Id);
	}
	
	public void addCart(Product product, Cart cart) {
		productDao.addCartToProduct(product, cart);
	}
	
	public List<Product> findAllProducts() {
		return productDao.findAllProducts();
	}
	
	public List<Category> findAllCategories() {
		return productDao.findAllCategories();
	}
	
	public List<Product> findProductsBetween(double min, double max) {
		return productDao.findProductsWithPriceRange(min, max);
	}
	
	public void addProductToCategory(Product product, Category category) {
		productDao.addCategoryToProduct(product, category);
	}
	
	public void addOrderLineToProduct(OrderLine orderLine, Product product) {
		productDao.addOrderLineToProduct(orderLine, product);
	}
	
	public List<Color> getAllColors() {
		return productDao.getAllColors();
	}
	
	public Color getColorById(int colorId) {
		return productDao.getColorById(colorId);
	}
	
	public List<Size> getAllSizes() {
		return productDao.getAllSizes();
	}
	
	public Size getSizeByid(int sizeId) {
		return productDao.getSizeById(sizeId);
	}
	
	public void saveProductStyle(ProductStyle productStyle) {
		productDao.saveProductStyle(productStyle);
	}
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	
}

