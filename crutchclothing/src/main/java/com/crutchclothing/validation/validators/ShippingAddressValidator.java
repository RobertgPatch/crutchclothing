package com.crutchclothing.validation.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.crutchclothing.users.model.Address;

public class ShippingAddressValidator {

	 public boolean supports(Class<?> paramClass) {
	        return Address.class.equals(paramClass);
	    }
	 
	 public void validate(Object obj, Errors errors) {
		 
		 
		 Address address = (Address) obj;
		 
		// if(address.getAddressType() == AddressType.DEFAULT ||
				// address.getAddressType() == AddressType.BILLING) {
			 
			 //if(address.getAddressType() ==
			 
			 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipAddress.firstName", "valid.firstName", "Please enter first name.");
			 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipAddress.lastName", "valid.lastName", "Please enter last name");
		     ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipAddress.address1", "valid.street", "Please enter street.");
		     ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipAddress.city", "valid.city", "Please enter city.");
		     //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "primaryAddress.state", "valid.state", "Please enter state");
		     ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipAddress.zipcode", "valid.zipcode", "Please enter zip code");
		        
		     if(address.getState().equalsIgnoreCase("default")) {
		    	 errors.rejectValue("shipAddress.state", "valid.state", "Please select a state");
		     }
		        
		     /*
		     if(address.getAddressType() == AddressType.DEFAULT) {
		    	 errors.rejectValue("shipAddress.addressType", "valid.addressType", "Please select an address type");
		     }
		     
		 //}
		 
		 if(address.getAddressType() == AddressType.BILLING) {
			 
		 }
		 
		 if(address.getAddressType() == AddressType.SHIPPING) {
			 
		 }
		 */
		 
		 //if(address.isBilling()) {
		 	
		 //}
		// else if(address.isShipping()) {

		 //}
	       
	        
	        //if (userService.userExists(user)) { 
	                   // errors.rejectValue( "name", "user.name.exists"); 
	               //} 

			
	    }

}
