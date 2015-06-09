package com.crutchclothing.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crutchclothing.cart.model.Cart;
import com.crutchclothing.cart.model.CartProduct;
import com.crutchclothing.cart.model.CartProductDetail;
import com.crutchclothing.cart.model.CartProductRef;
import com.crutchclothing.cart.service.CartService;
import com.crutchclothing.inventory.Inventory;
import com.crutchclothing.products.model.Product;
import com.crutchclothing.products.model.ProductDetail;
import com.crutchclothing.products.service.ProductService;
import com.crutchclothing.users.model.User;
import com.crutchclothing.users.service.UserService;

@Controller
public class CartController {

	
	//@Autowired
	//@Qualifier("cartService")
	private CartService cartService;
	
	

	//@Autowired
	//@Qualifier("userService")
	private UserService userService;
	
	//@Autowired
	//@Qualifier("productService")
	private ProductService productService;
	
	@Autowired
	@Qualifier("productDetailValidator")
	private Validator validator;
	
	@InitBinder("productDetail")
	private void initBinder(WebDataBinder binder) {
	        binder.setValidator(validator);
	    }
	
	@RequestMapping(value="/cart")
	public String showCart(ModelMap model, Principal auth) {
		
		String name = "anonymoususer";
		
		if (auth != null) {
			name = auth.getName();
		}
		
		model.addAttribute("name", capitalizeName(name));
	    //System.out.println(name);
	    
	   if(!name.equalsIgnoreCase("anonymoususer")) {
		    
			User user = userService.findUser(name);
			Cart cart = user.getUserCart();
			model.addAttribute("user", user);
			model.addAttribute("cartProducts", new ArrayList<CartProduct>(cart.getCartProducts()));
			model.addAttribute("cartQuan", cart.getTotalQuantity());
			model.addAttribute("subtotal", cart.getTotal());
			//model.addAttribute(attributeValue)
	   }
	   
		return "cart";
	}
	
	
	@RequestMapping(value = "/showproduct")
	public String showProduct(@RequestParam("id") Integer id, Model model, Principal auth/*@PathVariable("id") Integer id*/) {
		//Integer id = Integer.valueOf(stringId);
		
		String name = "anonymoususer";
		
		if (auth != null) {
			name = auth.getName();
		}
		model.addAttribute("name", capitalizeName(name));
	    System.out.println(id);
		
		Product product = productService.findProduct(id);
		
	   if(!name.equalsIgnoreCase("anonymoususer")) {
			User user = userService.findUser(name);
			Cart cart = user.getUserCart();
			model.addAttribute("user", user);
			model.addAttribute("cartQuan", cart.getTotalQuantity());
			ProductDetail productDetail = new ProductDetail();
			model.addAttribute("productDetail", productDetail);
	   }
	  
	   model.addAttribute("product", product);
		
		return "product";
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String getProducts(Model model, Principal auth) {
	   //ModelAndView model = new ModelAndView("products");
	   
		String name = "anonymoususer";
		
		if (auth != null) {
			name = auth.getName();		
		}
		
		if(!name.equalsIgnoreCase("anonymoususer")) {
			User user = userService.findUser(name);
			model.addAttribute("user", user);
			model.addAttribute("cartQuan", user.getUserCart().getTotalQuantity());
		}
	   
	    int criteria1 = productService.findProductsBetween(0, 34.99).size();
	    int criteria2 = productService.findProductsBetween(35, 49.99).size();
		model.addAttribute("name", capitalizeName(name));
		List<Product> products = productService.findAllProducts(); 
		model.addAttribute("products", products);
		model.addAttribute("categories", productService.findAllCategories());
		model.addAttribute("crit1", criteria1);
		model.addAttribute("crit2", criteria2);
		return "products";
		
	}
	
	@RequestMapping(value="/add-to-cart", method = RequestMethod.POST)  
    public String submitForm(/*@RequestParam("size") String size, */@RequestParam("id") Integer productId,
    		@ModelAttribute("productDetail") @Validated ProductDetail productDetail, BindingResult result, 
    		RedirectAttributes redir, Principal auth, Model model) {  
		
		String name = "anonymoususer";
		
		if (auth != null) {
			name = auth.getName();	
		}
		
		String view = null;
		User user = null;
		Product product = null;
		user = userService.findUser(name);
		Cart cart = user.getUserCart();
		product = productService.findProduct(productId);
		model.addAttribute("id", productId);
    	model.addAttribute("user", user); 
    	model.addAttribute("name", capitalizeName(user.getUsername()));
    	model.addAttribute("product", productService.findProduct(productId));
    	//model.addAttribute("productDetail", new ProductDetail());
    	model.addAttribute("productDetail", productDetail);
    	model.addAttribute("cartQuan", cart.getTotalQuantity());
    	model.addAttribute("org.springframework.validation.BindingResult.productDetail", result);
		if(result.hasErrors()) {
			//user = userService.findUser(name);
			//product = productService.findProduct(productId);
			//redir.addFlashAttribute("org.springframework.validation.BindingResult.productDetail", result);
        	
			/*
			redir.addFlashAttribute("id", productId);
        	redir.addFlashAttribute("user", user); 
        	redir.addFlashAttribute("name", capitalizeName(user.getUsername()));
        	redir.addFlashAttribute("product", productService.findProduct(productId));
        	redir.addFlashAttribute("productDetail", productDetail); 
        	redir.addFlashAttribute("cartQuan", user.getUserCart().getTotalQuantity()); 
			*/
			//model.addAttribute("org.springframework.validation.BindingResult.productDetail", result);
        	//model.addAttribute("id", productId);
        	//model.addAttribute("user", user); 
        	//model.addAttribute("name", capitalizeName(user.getUsername()));
        	//model.addAttribute("product", productService.findProduct(productId));
        	//model.addAttribute("productDetail", new ProductDetail());
        	//model.addAttribute("cartQuan", user.getUserCart().getTotalQuantity());
        	//Map<String, Object> map = new HashMap<>();
        	//map.put(", value)
        	//copyErrorsToFlash(model, redir);
        	//return showProduct(productId, model, auth);
        	//view = "redirect:/product";
			return "product";
        }
		else {
			if(!name.equalsIgnoreCase("anonymoususer")) {
				product = productService.findProduct(productId);
				user = userService.findUser(name);
				
				ProductDetail foundProductDetail = productService.findProductDetail(product, 
							productDetail.getSize(), productDetail.getColor()); 
				
				int quant = productDetail.getQuantity();
				
				foundProductDetail.setQuantity(quant);
				CartProduct cartProduct = new CartProduct(product, user.getUserCart());
				//cartProduct.getProductDetails().add(productDetail);
				//productDetail.setCartProduct(cartProduct);
				//CartProductDetail cpd = new CartProductDetail(cartProduct, foundProductDetail);
				//cartProduct.setQuantity(foundProductDetail.getCartProduct().getQuantity());
				//cpd.setQuantity(productDetail.getQuantity());
				//cpd.setName(product.getName());
				Integer cartPid = cartProductExists(cartProduct);
				if(cartPid >= 0){
						if(productInstanceExistsInCart(cartPid, foundProductDetail.getId())) {
							String cartSize = productDetail.getSize();
							String cartColor = productDetail.getColor();
							int newQty = productDetail.getQuantity();
							
							Integer pDetailId = foundProductDetail.getId();
							cartService.increaseCartProductQuantity(pDetailId, cartPid, newQty);
						}
						else {
							cartService.saveDetailToCartProduct(cartPid, foundProductDetail);
						}
				}
				else {
					cartService.saveCartProduct(cartProduct);
					cartService.saveDetailToCartProduct(cartProduct.getCartProductId(),
							foundProductDetail);
				}
				view = "cart";
			}
		}

        return view;
 
    }
	
	
	@RequestMapping(value="/updatecart", method = RequestMethod.POST)  
    public String checkQuantity(@RequestParam("cartProductId") Integer cartProductId, 
    		@RequestParam("prodDetailId") Integer productDetailId, 
    		@RequestParam("newQuantity") int newQuantity, ModelMap 
    		model, Principal auth) {  
        
		cartService.changeCartProductQuantity(cartProductId, productDetailId, newQuantity);

		return showCart(model, auth);
	}
	
	@RequestMapping(value="/product")  
    public String resendProduct(Model model) {
		Integer id = (Integer) model.asMap().get("id");
		System.out.println("id ====== " + id);
		return "product";
	}
	
	@RequestMapping(value="/category")
	public String showCategory(@RequestParam("categoryId") Integer categoryId, ModelMap model, Principal auth) {
		
		String name = "anonymoususer";
		
		if (auth != null) {
			name = auth.getName();
		}
		
		int criteria1 = productService.findProductsBetween(0, 34.99).size();
	    int criteria2 = productService.findProductsBetween(35, 49.99).size();
		User user = userService.findUser(name);
		model.addAttribute("name", capitalizeName(name));
		Set<Product> products = productService.findCategory(categoryId).getProducts();
		model.addAttribute("products", products);
		model.addAttribute("categories", productService.findAllCategories());
		model.addAttribute("crit1", criteria1);
		model.addAttribute("crit2", criteria2);
		model.addAttribute("cartQuan", user.getUserCart().getTotalQuantity());
		return "products";
	}
	
	@RequestMapping(value="/filterbyprice")
	public String showPriceRange(@RequestParam("min") double min, @RequestParam("max") double max, ModelMap model) {
		
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		
		List<Product> products = productService.findProductsBetween(min, max);
		int criteria1 = productService.findProductsBetween(0, 34.99).size();
	    int criteria2 = productService.findProductsBetween(35, 49.99).size();
	    User user = userService.findUser(name);
		model.addAttribute("name", capitalizeName(name)); 
		model.addAttribute("products", products);
		model.addAttribute("categories", productService.findAllCategories());
		model.addAttribute("crit1", criteria1);
		model.addAttribute("crit2", criteria2);
		model.addAttribute("cartQuan", user.getUserCart().getTotalQuantity());
		return "products";
	}
	
	@RequestMapping(value="/inventory")
	public String inventory() {
		
		Product p = productService.findProduct(1);
		Inventory in = new Inventory(p, 10);
		productService.updateProductInventory(p, in);
		
		return null;
	}
	
	
	private String capitalizeName(String name) {
		String formattedName = name.substring(0,1).toUpperCase() + name.substring(1, name.length()).toLowerCase();
		return formattedName;
	}
	
	private boolean productInstanceExistsInCart(Integer cartProductId, 
			Integer productDetailId) {
		
		if (cartService.findCartProductRef(cartProductId,productDetailId) != null) {
			return true;
		}
		/*
		String newSize = productDetail.getSize();
		String newColor = productDetail.getColor();
		for(CartProductRef cpr : productDetail.getCartProductRefs()) {
			ProductDetail pd = cpr.getProductDetail();
			if(newSize.equalsIgnoreCase(pd.getSize()) && 
					newColor.equalsIgnoreCase(pd.getColor())) {
				return true;
			}
		}
		*/
		return false;
	}
	
	private Integer cartProductExists(CartProduct cartProduct) {
		Integer newCartId = cartProduct.getCart().getCartId();
		Integer newProdId = cartProduct.getProduct().getId();
		
		List<CartProduct> cartProducts = cartService.getCartProducts();
		for(CartProduct cartProd : cartProducts) {
			Integer currCartId = cartProd.getCart().getCartId();
			Integer currProdId = cartProd.getProduct().getId();
			if(newCartId == currCartId && newProdId == currProdId) {
				return cartProd.getCartProductId();
			}
		}
		return -1;
	}
	
	
	
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	/*
	private  static void copyErrorsToFlash(Model model, RedirectAttributes redirectAttrs) {
		  Map<String, Object> modelMap = model.asMap();
		  for (Map.Entry<String, Object> entry : modelMap.entrySet()) {
		    if (entry.getValue() instanceof Errors) {
		      redirectAttrs.addFlashAttribute(entry.getKey(),
		          (entry.getValue()).getAllErrors());
		    }
		  }
		}
	*/
	
	private boolean checkCardExists() {
		return false;
	}
}
