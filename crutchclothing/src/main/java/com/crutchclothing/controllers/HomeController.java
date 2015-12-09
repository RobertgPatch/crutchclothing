package com.crutchclothing.controllers;

import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.crutchclothing.cart.model.Cart;
import com.crutchclothing.products.model.Color;
import com.crutchclothing.products.model.ProductStyle;
import com.crutchclothing.products.model.Size;
import com.crutchclothing.products.service.ProductService;
import com.crutchclothing.users.model.User;
import com.crutchclothing.users.service.UserService;
import com.crutchclothing.util.CrutchUtils;

/**
 * Handles requests for the application home page.
 */
@SessionAttributes("anonymousCart")
@Controller
public class HomeController {

	private UserService userService;
	private ProductService productService;
	private User user;
	private Cart cart;
	private List<User> userList;
	private static final String COOKIE_NAME = "CRUTCH_COOKIE";
	//private Cart anonymousCart;
	
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public String welcomePage(Model model, Principal auth, HttpServletRequest request, HttpServletResponse response) {

		model.addAttribute("title", "Spring Security Custom Login Form");
		model.addAttribute("message", "This is welcome page!");
		
		//uniqueId = UUID.randomUUID().toString();
		
		String name = "anonymoususer";
		
		if(auth != null) {
			name = auth.getName();
		}
		
		model.addAttribute("name", capitalizeName(name));
	    //System.out.println(name);
	    
	   if(!name.equalsIgnoreCase("anonymoususer")) {
			//this.user = userService.findUser(name);
		   this.user = userService.findUserWithCart(name);
	   }
	   // anonymous user
	   else {
		   	String sessionId = getCookie(request, response);
		   	
		   	System.out.println("Session id = " + sessionId + " =---------------");
		   	if(sessionId == null) {
		   		sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
		   		setCookie(request, response, sessionId);
		   	}
		   	
		   	this.user = findOrCreateAnonymousUser(sessionId);
		   	this.cart = user.getUserCart();

	   }
	   
	   
	   model.addAttribute("user", this.user);
	   model.addAttribute("cartQuan", cart.getTotalQuantity());
		
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
			System.out.println("error = " + error + " and size = " + error.length());                                                                                                                                                                                                                                                                                                                                              
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
	
	@RequestMapping(value = "/style")
	public String style(Model model, Principal auth) {
		
		String name = "anonymoususer";
		
		if (auth != null) {
			name = auth.getName();
		}

		   if(!name.equalsIgnoreCase("anonymoususer")) {
				User user = userService.findUser(name);
				model.addAttribute("user", user);
				model.addAttribute("cartQuan", user.getUserCart().getTotalQuantity());
		   }
		   
		   Size size = productService.getSizeByid(2);
		   
		   Color color1 = productService.getColorById(1);
		   Color color2 = productService.getColorById(2);
		   
		   System.out.println(color1.getColor());
		   System.out.println(color2.getColor());
		   
		   ProductStyle style = new ProductStyle();
		   
		   style.setColors(new HashSet<Color>(Arrays.asList(color1,color2)));
		   style.setSize(size);
		   
		   System.out.println("before saving product style--------------");
		   productService.saveProductStyle(style);
		   System.out.println("product style saved------------------");
		   
		   model.addAttribute("name", capitalizeName(name));
		   
		return "/";
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
		
		private User findOrCreateAnonymousUser(String sessionId) {
			
			User anon = userService.findUserBySessionIdWithCartInfo(sessionId);

			if(anon == null) {
				anon = new User();
				Cart anonCart = new Cart();
				anon.setUserCart(anonCart);
				anonCart.setUser(anon);
				anon.setSessionId(sessionId);
				userService.addUser(anon);
			}
			
			return anon;
		}
		
		private String getCookie(HttpServletRequest request, HttpServletResponse response) {
			
			String value = null;
	        response.setContentType("text/html");
	        Cookie crutchCookie = null;
	        Cookie[] cookies = request.getCookies();
	        if (cookies != null) {
	        	System.out.println("number of cookies = " + cookies.length);
	            for (Cookie cookie : cookies) {
	            	System.out.println("cookie name = " + cookie.getName());
	                if (cookie.getName().equals(COOKIE_NAME)) {
	                    crutchCookie = cookie;
	                    break;
	                }
	            }
	        }
	        if (crutchCookie != null) {
	            crutchCookie.setMaxAge(0);
	            response.addCookie(crutchCookie);
	            value = crutchCookie.getValue();
	        }
	        
	        return value;
		}
		
		private void setCookie(HttpServletRequest request, HttpServletResponse response, String sessionId) {
	        Cookie crutchCookie = new Cookie(COOKIE_NAME, sessionId);
	        // setting cookie to expiry in 60 mins
	        crutchCookie.setMaxAge(60 * 60 * 24 * 7);
	        crutchCookie.setPath("/");
	        response.addCookie(crutchCookie);
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
