package com.crutchclothing.validation.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.crutchclothing.users.model.User;
import com.crutchclothing.users.service.UserService;

public class UserValidator implements Validator {
	
	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	@Autowired
	@Qualifier("addressValidator")
	private Validator addressValidator;

	
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private static final String PHONE_PATTERN = 
			"\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})";

    public boolean supports(Class<?> paramClass) {
        return User.class.equals(paramClass);
    }

    public void validate(Object obj, Errors errors) {
    	 
    	User user = (User) obj;
    	
    	if(user.getPassword() != null) {
    		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "valid.username", "Please type your username");
    	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.password", "Please type your password.");
    	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConf", "valid.passwordConf", "Please confirm password.");
    	}
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "valid.firstName", "Please type your first name.");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "valid.lastName", "Please type your last name.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "valid.email", "Please type your email address.");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "valid.phone", "Please type your phone number.");
   
        
       

        if(user.getPassword() != null) {
        	if (!user.getPassword().equals(user.getPasswordConf())) {
        		errors.rejectValue("passwordConf", "valid.passwordConfDiff", "Passwords do not match!");
        	}
        
        
        	if (user != null && userService.userExists(user)) { 
        		errors.rejectValue( "username", "valid.exists.username", "Username already exists, please try again."); 
        	} 
        }

        Pattern pattern = null;
        pattern = Pattern.compile(EMAIL_PATTERN);
        if(user.getEmail() != null) {
        	Matcher matcher = pattern.matcher(user.getEmail());
        	if(!matcher.matches()) {
        		errors.rejectValue("email", "matcher.email", "Email address entered does not match expected format.");
        	}
        }
        
        /*
        pattern = null;
        pattern = Pattern.compile(PHONE_PATTERN);
        if(user.getEmail() != null) {
        	Matcher matcher = pattern.matcher(user.getPhoneNumber());
        	if(!matcher.matches()) {
        		errors.rejectValue("phoneNumber", "matcher.phone", "Phone number entered does not match expected format.");
        	}
        }
        */
        
        //if(user.getNewAddress() != null /*|| user.getShipAddress() != null*/) {

        	//try{
        		//if(user.getNewAddress() != null) {
        			//ValidationUtils.invokeValidator(addressValidator, user.getNewAddress(), errors); 
        		//}
        		/*
        		else if(user.getShipAddress() != null) {
        			ValidationUtils.invokeValidator(addressValidator, user.getShipAddress(), errors); 
        		}
        		*/
        	//}catch (Exception e){ 
        		//e.printStackTrace();
        	//}
        //}

    
        /*
        try {
        	errors.pushNestedPath("primaryAddress");
        	addressValidator.validate(((User)user).getPrimaryAddress(), errors);           
        } finally {
            errors.popNestedPath();
        }
        */
       
    }
    
    public void setAddressValidator(AddressValidator addressValidator) {
        this.addressValidator = addressValidator;
    }

    public void setUserService(UserService userService) {
    	this.userService = userService;
    }

}