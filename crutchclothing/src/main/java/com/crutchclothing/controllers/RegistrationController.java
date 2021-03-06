package com.crutchclothing.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crutchclothing.cart.model.Cart;
import com.crutchclothing.users.model.Address;
import com.crutchclothing.users.model.User;
import com.crutchclothing.users.service.MyUserDetailsService;
import com.crutchclothing.users.service.UserService;
import com.crutchclothing.util.CrutchUtils;


@Controller
public class RegistrationController {
	
	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	@Autowired
	@Qualifier("myUserDetailsService")
	MyUserDetailsService userDetailsService;
	
	@Autowired
	@Qualifier("authenticationManager")
	AuthenticationManager authenticationManager;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	@Qualifier("userValidator")
	private Validator validator;
	
	@InitBinder("user")	
	private void initBinder(WebDataBinder binder) {
	        binder.setValidator(validator);
	    }

	@RequestMapping(value="/registration")  
    public ModelAndView initForm() {  
		ModelAndView model = new ModelAndView("registration");
		//Address address = new Address();
		User user = new User();
		//user.getAddresses().add(address);
		//user.setPrimaryAddress(address);
		model.addObject("user", user);
        return model;
       
    }  
	
	@RequestMapping(value="/process-user")  
    public String submitForm(@ModelAttribute("user") @Validated User user, BindingResult result,
    		Model model, Principal auth, HttpServletRequest request) {  
		
        model.addAttribute("user", user);
        if(result.hasErrors()) {
        	return "registration"; 
        }  
        else{

        	user.setPassword(passwordEncoder.encode(user.getPassword()));
        	Cart cart = new Cart();
        	//user.setCart(cart);
        	formatUser(user);
            userService.addUser(user);
            model.addAttribute("name", CrutchUtils.capitalizeName(user.getFirstName()));
            //userService.saveAddress(address);
            authenticateUserAndSetSession(user, request);
            return "registrationsuccess";
        }

    }
	
	
	
	private void authenticateUserAndSetSession(User user, HttpServletRequest request) {
		String username = user.getUsername();
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
	
	private void formatUser(User user) {
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		
		user.setFirstName(CrutchUtils.capitalizeName(firstName));
		user.setLastName(CrutchUtils.capitalizeName(lastName));
		
		//capitalizeAddress()
	}
	
	
	
	
	
	private void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
      
}
