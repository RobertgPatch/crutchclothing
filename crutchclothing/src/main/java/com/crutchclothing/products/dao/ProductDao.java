package com.crutchclothing.products.dao;

import java.util.List;

import com.crutchclothing.cart.model.Cart;
import com.crutchclothing.orders.model.OrderLine;
import com.crutchclothing.products.model.Category;
import com.crutchclothing.products.model.Color;
import com.crutchclothing.products.model.Product;
import com.crutchclothing.products.model.ProductDetail;
import com.crutchclothing.products.model.ProductStyle;
import com.crutchclothing.products.model.Size;

public interface ProductDao {
	
	void addProduct(Product product, ProductDetail details);
	
	Product findProduct(String name);
	
	void updateProduct(Product product, ProductDetail details);
	
	//void updateProductInventory(Product product, Inventory inventory);
	
	ProductDetail findProductDetail(Product product, String size);
	
	Product findProduct(Integer id);
	
	Category findCategory(String name);
	
	Category findCategoryById(Integer categoryId);
	
	void addCartToProduct(Product product, Cart cart);
	
	List<Product> findAllProducts();
	
	List<Category> findAllCategories();
	
	List<Product> findProductsWithPriceRange(double min, double max);
	
	void addCategoryToProduct(Product product, Category cat);
	
	void addOrderLineToProduct(OrderLine orderLine, Product product);
	
	List<Size> getAllSizes();
	
	Size getSizeById(int sizeId);
	
	List<Color> getAllColors();
	
	Color getColorById(int colorId);
	
	void saveProductStyle(ProductStyle productStyle);

}
