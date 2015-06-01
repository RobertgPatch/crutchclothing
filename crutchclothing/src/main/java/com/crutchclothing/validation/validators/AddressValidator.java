package com.crutchclothing.validation.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.crutchclothing.users.model.Address;

public class AddressValidator implements Validator{
	
	
	private static final String PHONE_PATTERN = 
			"\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})";

	 public boolean supports(Class<?> paramClass) {
	        return Address.class.equals(paramClass);
	    }
	 
	 public void validate(Object obj, Errors errors) {
		 
		 
		 Address address = (Address) obj;
		 
		 
		 
		// if(address.getAddressType() == AddressType.DEFAULT ||
				// address.getAddressType() == AddressType.BILLING) {
			 
			 //if(address.getAddressType() ==
			 
			 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newAddress.firstName", "valid.firstName", "Please enter first name.");
			 //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipAddress.firstName", "valid.firstName", "Please enter first name.");
			 
			 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newAddress.lastName", "valid.lastName", "Please enter last name");
			 //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipAddress.lastName", "valid.lastName", "Please enter last name");
			 
		     ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newAddress.address1", "valid.street", "Please enter street.");
		     //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipAddress.address1", "valid.street", "Please enter street.");
		     
		     ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newAddress.city", "valid.city", "Please enter city.");
		     //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipAddress.city", "valid.city", "Please enter city.");
		     //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "primaryAddress.state", "valid.state", "Please enter state");
		     
		     ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newAddress.zipcode", "valid.zipcode", "Please enter zip code");
		     //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipAddress.zipcode", "valid.zipcode", "Please enter zip code");
		     
		     ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newAddress.phone", "valid.phone", "Please type your phone number.");
		     
		     
		     if(address.getState().equalsIgnoreCase("default")) {
		    	 errors.rejectValue("newAddress.state", "valid.state", "Please select a state");
		    	 //errors.rejectValue("shipAddress.state", "valid.state", "Please select a state");
		     }
		     
		     Pattern pattern = null;
		        pattern = Pattern.compile(PHONE_PATTERN);
		        if(address.getPhone() != null) {
		        	Matcher matcher = pattern.matcher(address.getPhone());
		        	if(!matcher.matches()) {
		        		errors.rejectValue("phoneNumber", "matcher.phone", "Phone number entered does not match expected format.");
		        	}
		        }
		        
		     /*
		     if(address.getAddressType() == AddressType.DEFAULT) {
		    	 errors.rejectValue("newAddress.addressType", "valid.addressType", "Please select an address type");
		     }
		     */
		 //}

		 
		 
		 //if(address.isBilling()) {
		 	
		 //}
		// else if(address.isShipping()) {

		 //}
	       
	        
	        //if (userService.userExists(user)) { 
	                   // errors.rejectValue( "name", "user.name.exists"); 
	               //} 

			
	    }

}


