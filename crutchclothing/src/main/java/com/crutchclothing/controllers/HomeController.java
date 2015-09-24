package com.crutchclothing.controllers;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crutchclothing.cart.model.Cart;
import com.crutchclothing.products.service.ProductService;
import com.crutchclothing.users.model.User;
import com.crutchclothing.users.service.UserService;
import com.crutchclothing.util.CrutchUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private UserService userService;
	private ProductService productService;
	private User user;
	private Cart cart;
	private List<User> userList;
	
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public String welcomePage(Model model, Principal auth) {

		model.addAttribute("title", "Spring Security Custom Login Form");
		model.addAttribute("message", "This is welcome page!");
		
		String name = "anonymoususer";
		
		if(auth != null) {
			name = auth.getName();
		}
		
		model.addAttribute("name", capitalizeName(name));
	    //System.out.println(name);
	    
	   if(!name.equalsIgnoreCase("anonymoususer")) {

			this.user = userService.findUser(name);
			this.cart = user.getUserCart();

			model.addAttribute("user", this.user);
			model.addAttribute("cartQuan", cart.getTotalQuantity());
	   }
	   
		
		return "home";

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public String adminPage(Model model, Principal auth) {
		
		String name = "Anonymoususer";
		
		if(auth != null) {
			name = auth.getName();
		}
		
		model.addAttribute("name", CrutchUtils.capitalizeName(name));
	    
	   if(!name.equalsIgnoreCase("anonymoususer")) {
		   if(this.user == null) {
			   this.user = userService.findUser(name);
		   }
		   if(this.cart == null) {
			   cart = user.getUserCart();
		   }
		   if(this.userList == null) {
			   userList = userService.findAllUsers();
		   }

		   
		   model.addAttribute("title", "Spring Security Custom Login Form");
		   model.addAttribute("message", "This is protected page!");
		   model.addAttribute("cartQuan", this.cart.getTotalQuantity());
		   model.addAttribute("shortRole", this.user.getTopRole());
		   model.addAttribute("products", productService.findAllProducts());
		   model.addAttribute("addUser", new User());
		   model.addAttribute("users", userList);

	   }
		return "admin";

	}
	
	@RequestMapping(value="/admin/delete-user/{username}")
	public String deleteUser(@PathVariable String username, Model model, Principal auth) {
		
		userService.deleteUser(username);
		userList = userService.findAllUsers();
		return adminPage(model, auth);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		
		StringBuilder nameBldr = new StringBuilder();
		//if(user != null) {
			//nameBldr.append(user.getName());
		//}
		//else {
			nameBldr.append("Anonymoususer");
		//}
		
		model.addAttribute("name", nameBldr.toString());
		model.addAttribute("cartQuant", "10");
		
		return "login";

	}
	
	@RequestMapping(value = "/contact")
	public String contact(ModelMap model, Principal auth) {
		
		String name = "anonymoususer";
		
		if (auth != null) {
			name = auth.getName();
		}

		   if(!name.equalsIgnoreCase("anonymoususer")) {
				User user = userService.findUser(name);
				model.addAttribute("user", user);
				model.addAttribute("cartQuan", user.getUserCart().getTotalQuantity());
		   }
		   
		   model.addAttribute("name", capitalizeName(name));
		   
		return "contact";
	}
	
	

	
	// for 403 access denied page
		@RequestMapping(value = "/403", method = RequestMethod.GET)
		public String accesssDenied(Model model) {

			// check if user is login
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (!(auth instanceof AnonymousAuthenticationToken)) {
				UserDetails userDetail = (UserDetails) auth.getPrincipal();
				System.out.println(userDetail);

				model.addAttribute("username", userDetail.getUsername());

			}

			return "403";

		}
		
		private String capitalizeName(String name) {
			String formattedName = name.substring(0,1).toUpperCase() + name.substring(1, name.length()).toLowerCase();
			return formattedName;
		}
		
		private void initVariables() {
			
		}
		
		public UserService getUserService() {
			return this.userService;
		}
		
		public void setUserService(UserService userService) {
			this.userService = userService;
		}
		
		public ProductService getProductService() {
			return this.productService;
		}
		
		public void setProductService(ProductService productService) {
			this.productService = productService;
		}

}
