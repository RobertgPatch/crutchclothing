package com.crutchclothing.validation.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.crutchclothing.cart.model.CartProduct;
import com.crutchclothing.cart.service.CartService;
import com.crutchclothing.products.model.ProductDetail;

public class ProductDetailValidator implements Validator {
	
	//@Autowired
	//@Qualifier("cartService")
	//private CartService cartService;

    public boolean supports(Class<?> paramClass) {
        return ProductDetail.class.equals(paramClass);
    }

    public void validate(Object obj, Errors errors) {
    	
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "valid.quantity", "Please enter a quantity");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "size", "valid.size", "Please select a size.");
        //ValidationUtils.
        ProductDetail productDetail = (ProductDetail) obj;
        
        if(productDetail.getColor().equalsIgnoreCase("default")){
        	errors.rejectValue("color", "valid.color", "Please select a color.");
        }
        
        //int val = productDetail.getQuantity();
        if(productDetail.getQuantity() <= 0){
        	errors.rejectValue("quantity", "minimum.quantity", "Please select quantity greater than 0.");
        }
    
		
        /*
        if (userService.userExists(user)) { 
        	errors.rejectValue( "username", "valid.exists.username", "Username already exists, please try again."); 
        } 

		*/
        

/*
        try{ 
            ValidationUtils.invokeValidator(addressValidator, user.getPrimaryAddress(), errors); 
        }catch (Exception e){ 
             e.printStackTrace();
        }

*/       
        /*
        try {
        	errors.pushNestedPath("primaryAddress");
        	addressValidator.validate(((User)user).getPrimaryAddress(), errors);           
        } finally {
            errors.popNestedPath();
        }
        */
       
    }
    /*
    public void setCartService(CartService cartService) {
    	this.cartService = cartService;
    }
    
    public void setAddressValidator(AddressValidator addressValidator) {
        this.addressValidator = addressValidator;
    }
*/


}