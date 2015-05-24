package com.crutchclothing.controllers;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.util.HashMap;
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

import com.crutchclothing.users.model.User;
import com.crutchclothing.users.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private UserService userService;

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
			User user = userService.findUser(name);
			model.addAttribute("user", user);
			model.addAttribute("cartQuan", user.getUserCart().getTotalQuantity());
	   }
	   
		
		return "home";

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public String adminPage(Model model) {

		model.addAttribute("title", "Spring Security Custom Login Form");
		model.addAttribute("message", "This is protected page!");
		
		return "admin";

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
		
		public UserService getUserService() {
			return this.userService;
		}
		
		public void setUserService(UserService userService) {
			this.userService = userService;
		}

}
