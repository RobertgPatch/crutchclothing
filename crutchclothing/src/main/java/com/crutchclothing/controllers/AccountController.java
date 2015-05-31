package com.crutchclothing.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crutchclothing.cart.model.Cart;
import com.crutchclothing.cart.model.CartProduct;
import com.crutchclothing.cart.service.CartService;
import com.crutchclothing.products.model.ProductDetail;
import com.crutchclothing.users.model.Address;
import com.crutchclothing.users.model.User;
import com.crutchclothing.users.model.UserRole;
import com.crutchclothing.users.service.UserService;
import com.crutchclothing.util.CrutchUtils;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Customer;

@Controller
public class AccountController {

	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	//@Autowired
	//@Qualifier("cartService")
	//CartService cartService;
	
	@Autowired
	@Qualifier("userValidator")
	private Validator validator;
	
	@InitBinder("user")	
	private void initBinder(WebDataBinder binder) {
	        binder.setValidator(validator);
	    }
	
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String showAccount(ModelMap model, Principal auth) {
		
		 //String name = SecurityContextHolder.getContext().getAuthentication().getName();		
		 String name = auth.getName(); 
		 if(!name.equalsIgnoreCase("anonymoususer")) {
			 User user = userService.findUser(name);
			 model.addAttribute("user", user);
			 model.addAttribute("userFirstName", user.getFirstName());
			 model.addAttribute("username", user.getUsername());
			 model.addAttribute("addressList", user.getAddresses());
			 model.addAttribute("cartQty", user.getUserCart().getTotalQuantity());
			 //model.addAttribute("cartProducts", new ArrayList<CartProduct>(user.getUserCart().getCartProducts()));
		 }
		 
		 model.addAttribute("name", CrutchUtils.capitalizeName(name));
		
		return "account";
	}
	
	@RequestMapping(value="/edit-account")  
    public String submitForm(@ModelAttribute("user") @Validated User user, BindingResult userResult, ModelMap model, RedirectAttributes redir) {  
       
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		String view = null;
		
		model.addAttribute("user", user);
		
		User oldUser = userService.findUser(name);
		
		model.addAttribute("username", oldUser.getUsername());
		//model.addAttribute("cartProducts", new ArrayList<CartProduct>(cart.getCartProducts()));
		model.addAttribute("cartQty", oldUser.getUserCart().getTotalQuantity());
		model.addAttribute("name", CrutchUtils.capitalizeName(name));
		model.addAttribute("addressList", oldUser.getAddresses());
		
		
        if(userResult.hasErrors()) {
        	
        	//redir.addFlashAttribute("org.springframework.validation.BindingResult.user", userResult);
        	//redir.addFlashAttribute("user", user); 
        	//redir.addFlashAttribute("name", capitalizeName(name)); 
        	//redir.addFlashAttribute("cartProducts", new ArrayList<CartProduct>(user.getUserCart().getCartProducts()));
        	 
        	
        	//view = "redirect:/account";
        	//model.addAttribute("user", currUser);
			//model.addAttribute("cartProducts", new ArrayList<CartProduct>(user.getUserCart().getCartProducts()));
        	return "account";
        }
        else{
        	
        	if(!name.equalsIgnoreCase("anonymoususer")) {
    			
    			//model.addAttribute("user", oldUser);
        		userService.updateUser(name, user);
        		User updatedUser = userService.findUser(name);
        		model.addAttribute("user", updatedUser);
    			//model.addAttribute("cartProducts", new ArrayList<CartProduct>(oldUser.getUserCart().getCartProducts()));
    			model.addAttribute("cartQty", oldUser.getUserCart().getTotalQuantity());
        		model.addAttribute("name", CrutchUtils.capitalizeName(name));
    			model.addAttribute("username", updatedUser.getUsername());
    			/*
        		redir.addFlashAttribute("user", updatedUser);
        		redir.addFlashAttribute("cartProducts", new ArrayList<CartProduct>(oldUser.getUserCart().getCartProducts()));
        		redir.addFlashAttribute("name", capitalizeName(name));
    			*/
    			return "account";
        	}
        	
        }
                
        return "account";  
    }
	
	@RequestMapping(value="/add-address")  
    public String addAddress(@ModelAttribute("user") @Validated User user, BindingResult result, ModelMap model, RedirectAttributes redir) { 
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		String view = null;
		User foundUser = userService.findUser(name);
		model.addAttribute("name", CrutchUtils.capitalizeName(name));
		model.addAttribute("user", user);
		model.addAttribute("addressList", foundUser.getAddresses());
		//model.addAttribute("cartProducts", new ArrayList<CartProduct>(foundUser.getUserCart().getCartProducts()));
		model.addAttribute("cartQty", foundUser.getUserCart().getTotalQuantity());
		if(result.hasErrors()) {
			//redir.addFlashAttribute("user", foundUser);
			
			//redir.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
			//redir.addFlashAttribute("user", user);
			//redir.addFlashAttribute("cartProducts", new ArrayList<CartProduct>(foundUser.getUserCart().getCartProducts()));
			//redir.addFlashAttribute("name", capitalizeName(name));
			
			return "account";
		}
		else {
			CrutchUtils.capitalizeAddress(user.getNewAddress());
			userService.saveAddress(name, user.getNewAddress());
			User updatedUser = userService.findUser(name);
			model.addAttribute("user", foundUser);
			model.addAttribute("cartProducts", new ArrayList<CartProduct>(foundUser.getUserCart().getCartProducts()));
			model.addAttribute("addressList", updatedUser.getAddresses());
			
			//redir.addFlashAttribute("user", foundUser);
			//redir.addFlashAttribute("cartProducts", new ArrayList<CartProduct>(foundUser.getUserCart().getCartProducts()));
			//redir.addFlashAttribute("addressList", user.getAddresses());
			
			return "account";
		}
	}
	
	@RequestMapping(value="/delete-address", method = RequestMethod.POST)  
    public String removeAddress(@RequestParam("addressId") Integer addressId, ModelMap model, Principal auth) { 
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println();
		userService.deleteAddress(name,addressId);
		
		return showAccount(model, auth);
	}
     
	@RequestMapping(value="/account")  
    public String resendAccount(Model model) {
		Integer id = (Integer) model.asMap().get("id");
		System.out.println("id ====== " + id);
		return "account";
	}
	
	//@RequestMapping(value="stripe-account")
	public String createStripeAccount(Model model) {
		
		Stripe.apiKey = "sk_test_JMHGITpDdOWOtIjc7sd9E0QH";
		
		String uuid = UUID.randomUUID().toString();
		Map<String, Object> customerParams = new HashMap<String, Object>();
		customerParams.put("description", "Customer for test@example.com");
		//customerParams.put("source", ""); // obtained with Stripe.js

		try {
			Customer.create(customerParams);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (APIConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CardException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "welcome";
	}
	
}
