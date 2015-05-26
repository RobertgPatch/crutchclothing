package com.crutchclothing.controllers;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crutchclothing.cart.model.Cart;
import com.crutchclothing.cart.model.CartProduct;
import com.crutchclothing.inventory.Inventory;
import com.crutchclothing.orders.model.Order;
import com.crutchclothing.users.model.Address;
import com.crutchclothing.users.model.User;
import com.crutchclothing.users.service.UserService;
import com.crutchclothing.util.AddressType;
import com.crutchclothing.util.OrderNumber;

@Controller
public class OrderController {

	//@Autowired
	//@Qualifier("userService")
	private UserService userService;

	//@Autowired
	//@Qualifier("userValidator")
	//private Validator validator;
	
	//@InitBinder("user")	
	//private void initBinder(WebDataBinder binder) {
	        //binder.setValidator(validator);
	    //}
	
	private Order order;
	
	@RequestMapping(value="/checkout")
	public String checkout(ModelMap model, Principal auth) {
		//ModelAndView model = new ModelAndView("checkout");
		System.out.println("Hello checkout");
		if(order == null) {
			order = new Order();
		}
		
		String name = "anonymoususer";
		
		if (auth != null) {
			name = auth.getName();
		}
		
		model.addAttribute("name", capitalizeName(name));
	    //System.out.println(name);
	    
	   if(!name.equalsIgnoreCase("anonymoususer")) {
		  // ArrayList<CartProduct> cartProducts =
			User user = userService.findUser(name);
			Cart cart = user.getUserCart();
			model.addAttribute("order", order);
			model.addAttribute("user", user);
			model.addAttribute("cartQty", cart.getTotalQuantity());
			model.addAttribute("cartProducts", new ArrayList<CartProduct>(cart.getCartProducts()));
			model.addAttribute("addressList", user.getAddresses());
			model.addAttribute("subtotal", cart.getTotal());
	   }

	   return "checkout";
	}

	
	@RequestMapping(value="/verify-billing-info")  
    public String verifyBillingInfo(/*@ModelAttribute("order")*/ Order order/*, BindingResult userResult, */,ModelMap model, RedirectAttributes redir) {  
		
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		
		order.setBillingAddress(userService.findAddress(order.getBillingAddress().getId()));
		
		model.addAttribute("name", capitalizeName(name));
		User foundUser = userService.findUser(name);
		model.addAttribute("user", foundUser);
		model.addAttribute("cartQty", foundUser.getUserCart().getTotalQuantity());
		model.addAttribute("cartProducts", new ArrayList<CartProduct>(foundUser.getUserCart().getCartProducts()));
		model.addAttribute("addressList", foundUser.getAddresses());
		model.addAttribute("order", order);
		
		System.out.println();
		
		/*
		if(userResult.hasErrors()) {
			return "checkout";
		}
		*/
		//userService.updateUserAddressType(user.getNewAddress().getAddressId(), com.crutchclothing.util.AddressType.BILLING);
		//model.addAttribute("user", user);
		return "checkout";
	}
	
	@RequestMapping(value="/verify-shipping-info")  
    public String verifyShippingInfo(/*@ModelAttribute("order") */Order order,/* BindingResult shipAddressResult,*/ ModelMap model, RedirectAttributes redir) {  
		
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		
		model.addAttribute("name", capitalizeName(name));
		User foundUser = userService.findUser(name);
		model.addAttribute("user", foundUser);
		model.addAttribute("cartQty", foundUser.getUserCart().getTotalQuantity());
		model.addAttribute("cartProducts", new ArrayList<CartProduct>(foundUser.getUserCart().getCartProducts()));
		model.addAttribute("addressList", foundUser.getAddresses());
		System.out.println();
		
		/*
		if(shipAddressResult.hasErrors()) {
			return "checkout";
		}
		*/
		//userService.updateUserAddressType(user.getShipAddress().getAddressId(), AddressType.SHIPPING);

		///model.addAttribute("user", user);
		return "checkout";
	}
	
	
	public String createOrder(){
		
		Order order = new Order();
		long orderNumber = OrderNumber.getID();
		return null;
	}
	
	
	private String capitalizeName(String name) {
		String formattedName = name.substring(0,1).toUpperCase() + name.substring(1, name.length()).toLowerCase();
		return formattedName;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	//public void setValidator(Validator validator) {
		//this.validator = validator;
	//}
}
