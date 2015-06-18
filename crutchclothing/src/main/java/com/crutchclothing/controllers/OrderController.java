package com.crutchclothing.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crutchclothing.cart.model.Cart;
import com.crutchclothing.cart.model.CartProduct;
import com.crutchclothing.cart.model.CartProductRef;
import com.crutchclothing.cart.service.CartService;
import com.crutchclothing.inventory.Inventory;
import com.crutchclothing.orders.model.Order;
import com.crutchclothing.orders.model.OrderLine;
import com.crutchclothing.orders.service.OrderService;
import com.crutchclothing.products.model.Product;
import com.crutchclothing.users.model.Address;
import com.crutchclothing.users.model.User;
import com.crutchclothing.users.service.UserService;
import com.crutchclothing.util.AddressType;
import com.crutchclothing.util.OrderNumber;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Card;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.PaymentSource;
import com.stripe.model.PaymentSourceCollection;
import com.stripe.model.Token;

@Controller
public class OrderController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("cartService")
	private CartService cartService;
	
	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;
	
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
		
		Stripe.apiKey = "sk_test_JMHGITpDdOWOtIjc7sd9E0QH";
		
		if(order == null) {
			order = new Order();
		}
		
		String name = "anonymoususer";
		
		if (auth != null) {
			name = auth.getName();
		}
		
		
		/*
		Customer cu = Customer.retrieve(user.getStripeId());
		PaymentSource source = cu.getSources().retrieve({CARD_ID});
		if (source.getObject().equals("card")) {
		  Card card = (Card) source;
		  // use the card!
		}
		*/
		
		model.addAttribute("name", capitalizeName(name));
	    //System.out.println(name);
	    
	   if(!name.equalsIgnoreCase("anonymoususer")) {
		  // ArrayList<CartProduct> cartProducts =
		   	User user = userService.findUser(name);
			Cart cart = user.getUserCart();
			model.addAttribute("order", order);
			model.addAttribute("user", user);
			model.addAttribute("cartQty", cart.getTotalQuantity());
			model.addAttribute("orderTotalAmount", order.getOrderTotal());
			model.addAttribute("cartProducts", new ArrayList<CartProduct>(cart.getCartProducts()));
			model.addAttribute("addressList", user.getAddresses());
			model.addAttribute("subtotal", cart.getTotal());			
			model.addAttribute("paymentCards", listAllCards(user.getStripeId()));
	   }

	   return "checkout";
	}

	
	//@RequestMapping(value="/verify-billing-info")  
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
	
	
	
	@RequestMapping(value="/order", method = RequestMethod.POST)  
	public String verifyShippingInfo(@RequestParam("stripeToken") String stripeToken, 
			@ModelAttribute("order") Order order, @RequestParam("paymentId") String paymentId,
			ModelMap model, Principal auth) {  
		
		
		String view = "home";
		
		String name = "anonymoususer";
		
		if (auth != null) {
			name = auth.getName();
		}
		
		double orderTotal = 0;
		Set<OrderLine> orderLines = new HashSet<OrderLine>();
		if(!name.equalsIgnoreCase("anonymoususer")) {
			User user = userService.findUser(order.getUser().getUsername());
			Cart cart = user.getUserCart();
			
			order.setOrderDate(new DateTime());
			order.getShipment().setShipDate(new LocalDate());
			orderService.saveOrder(order);
			
			for(CartProduct cartProd : cart.getCartProducts()) {
				for(CartProductRef cpr : cartProd.getCartProductRefs()) {
					orderTotal += (cartProd.getProduct().getPrice() * cpr.getProductQuantity());
				}
			}
			order.setOrderTotal(orderTotal);
			
			for(CartProduct cartProd : cart.getCartProducts()) {
				for(CartProductRef cpr : cartProd.getCartProductRefs()) {
					Product prod = cartProd.getProduct();					
					OrderLine orderLine = new OrderLine(prod, order);
					orderLine.setProductQuantity(cpr.getProductQuantity());
					orderService.saveOrderLine(orderLine);
					orderLines.add(orderLine);
				}
			}
			
			//order.setOrderLines(orderLines);
			
			
			System.out.println(orderTotal);
		}
		// charge card but dont save payment method to account
		// if card should not be saved and there is no payment id
		if(!order.isCardSaved() && paymentId.equals("")) {
			Stripe.apiKey = "sk_test_JMHGITpDdOWOtIjc7sd9E0QH";
			Map<String, Object> chargeParams = new HashMap<String, Object>();
			chargeParams.put("amount", (int)((orderTotal + order.getShipment().getShippingPrice()) * 100));
			chargeParams.put("currency", "usd");
			chargeParams.put("source", stripeToken); // obtained with Stripe.js
			chargeParams.put("description", "Charge without saving payment.");
			
			createCharge(chargeParams);
			
			//return "home";
		}
		
		// User wants to pay with a saved card.  Retrieve 
		// the card and charge it.
		else if(!paymentId.equals("")) {
			
			Stripe.apiKey = "sk_test_JMHGITpDdOWOtIjc7sd9E0QH";

			String username = order.getUser().getUsername();
			String stripeId = userService.findStripeId(username);
			Customer cu = retrieveCustomer(stripeId);
			Map<String, Object> cardParams = new HashMap<String, Object>();
			cardParams.put("limit", 3);
			cardParams.put("object", "card");
			PaymentSourceCollection paySourceCollection = getAllSources(cu, cardParams);
				
			for (PaymentSource paySource : paySourceCollection.getData() ) {
				Card card = (Card) paySource;
				if(card.getFingerprint().equals(paymentId)) {
						
					Stripe.apiKey = "sk_test_JMHGITpDdOWOtIjc7sd9E0QH";

					Map<String, Object> chargeParams = new HashMap<String, Object>();
					chargeParams.put("amount", (int)((orderTotal + order.getShipment().getShippingPrice()) * 100));
					chargeParams.put("currency", "usd");
					chargeParams.put("customer", stripeId);
					chargeParams.put("card", card.getId());
					chargeParams.put("description", "saved card for test@example.com");
						
					createCharge(chargeParams);
						
					break;
				}
			}
		
		}
		else { // Save payment method to account.
			
		Stripe.apiKey = "sk_test_JMHGITpDdOWOtIjc7sd9E0QH";
		
		String username = order.getUser().getUsername();
		
		Map<String, Object> customerParams = new HashMap<String, Object>();
		customerParams.put("description", "Customer for test@example.com");
		customerParams.put("email", "test@example.com");
		customerParams.put("source", stripeToken); // obtained with Stripe.js
		
		String stripeId = null;

		if((stripeId = userService.findStripeId(username)) != null) {
			// Save card to customer
			Customer cust = retrieveCustomer(stripeId);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("source", stripeToken);
			createCard(cust, params);
				
			PaymentSource source = getDefaultPaymentSource(cust);
			if (source.getObject().equals("card")) {
				Card card = (Card) source;
				Map<String, Object> chargeParams = new HashMap<String, Object>();
				chargeParams.put("amount", (int)((orderTotal + order.getShipment().getShippingPrice()) * 100)); //amount in cents
				chargeParams.put("currency", "usd");
				chargeParams.put("customer", stripeId);
				chargeParams.put("description", "Charge for test@example.com");

				createCharge(chargeParams);
			}
				
		}
		
		//return "home";
		
		}
			return view;
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
	
	private List<PaymentSource> listAllCards(String stripeId) {
		
		Stripe.apiKey = "sk_test_JMHGITpDdOWOtIjc7sd9E0QH";
		
		List<PaymentSource> cards = null;
		Customer cu;
		try {
			cu = Customer.retrieve(stripeId);
			Map<String, Object> cardParams = new HashMap<String, Object>();
			//cardParams.put("limit", 3);
			cardParams.put("object", "card");
			cards = cu.getSources().all(cardParams).getData();
			
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
		
		return cards;
		
	}
	private Customer retrieveCustomer(String stripeId) {
		
		Customer customer = null;
		
		try {
			customer = Customer.retrieve(stripeId);
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
		
		return customer;
	}
	
	private PaymentSourceCollection getAllSources(Customer customer, Map<String, Object> cardParams) {
		
		PaymentSourceCollection paySourceCol = null;
		
		try {
			paySourceCol = customer.getSources().all(cardParams);
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
		
		return paySourceCol;
	}
	private void createCharge(Map<String, Object> params) {
		
		try {
			Charge.create(params);
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
		
	}
	
	private void createCard(Customer cust, Map<String, Object> params) {
		try {
			cust.createCard(params);
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
	}
	
	private PaymentSource getDefaultPaymentSource(Customer cust) {
		
		PaymentSource paySource = null;
		try {
			paySource = cust.getSources().retrieve(cust.getDefaultSource());
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
		
		return paySource;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	//public void setValidator(Validator validator) {
		//this.validator = validator;
	//}
}
