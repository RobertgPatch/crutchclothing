<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@page session="false"%>
<%@taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>Crutch Clothing - Checkout</title>
		<link href="/resources/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
		<link href="/resources/css/bootstrap.css" rel='stylesheet' type='text/css' />
		<link href="/resources/css/theme.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

		<!----webfonts---->
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800,300' rel='stylesheet' type='text/css'>
		<!----//webfonts---->

		<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
		<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
		<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
		<!--  jquery plguin -->
	<!--start slider -->
	    <link rel="stylesheet" href="/resources/css/fwslider.css" media="all">
		<script src="<c:url value="/resources/js/jquery-1.4.2.min.js" />"></script>
		<script src="<c:url value="/resources/js/css3-mediaqueries.js" />"></script>
		<script src="<c:url value="/resources/js/jquery-ui.min.js" />"></script>
		<script src="<c:url value="/resources/js/fwslider.js" />"></script>
		<script src="<c:url value="/resources/jquery.validate.min.js" />"></script>
		<script src="<c:url value="/resources/additional-methods.min.js" />"></script>
		
	<!--end slider -->
	</head>
	
	
	
	<link href="/resources/css/jquery.mCustomScrollbar.css" rel='stylesheet' type='text/css'>

<!-- GOOGLE FONT-->
<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700italic,700,500&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
<!-- /GOOGLE FONT-->
<style type="text/css">
      body {
		font-family: 'Roboto', sans-serif;
		
      }
	
	.navbar .container  {
		max-width: 1170px;
		}

	  h1,h2,h3,h4,h5,h6{
		font-weight:200;
	  }
	  
	.navbar{
		border-radius:0px;
	}
	

		
		.page-header{
			border:none;
			padding: 10px 0px 0px;
			margin: 0px 0 0px;
		}
		.brand{
			color:#282828;
			margin-left:20px;
			font-weight:700;
		}
		
		.thumbnail{
			margin-bottom:20px;
			padding:0px;
			-webkit-border-radius: 0px;
			-moz-border-radius: 0px;
			border-radius: 0px;

		}
		
	.panel {
			min-height: 40px;
			margin-bottom: 20px;
		}

	.nav-tabs > li > a {

		-webkit-border-radius: 0px;
		-moz-border-radius: 0px;
		border-radius: 0px;
	}

	.carousel-inner > .item > img, 
	.carousel-inner > .item > a > img {
		min-width:100%;
	}
		
	/* CUSTOM DROPDOWNS STYLE FOR SHOPING CART 
	========================================= */
	.dropdown-menu.dropdown-cart .list-group-item {
		padding-top:10px;
		padding-bottom:10px;
		min-width:250px;
	}
	
	.dropdown-menu .list-group-item:first-child {
		border-radius:0px;
	}
	.dropdown-menu.dropdown-cart {
		padding-top:0px;
		padding-bottom:0px;
	}
	.dropdown-menu.dropdown-cart {
		padding-top:0px;
		padding-bottom:0px;
	}
	
	.list-group-item>.badge {
		float: right;
		margin-right: -15px;
		margin-left:10px;
	}

	
	.fixed-top{
		position:fixed;
		top:0px;
		bottom:0px;
		display:inline-block;
		max-width:370px;
		background:e0e0e0;
		barder:1px solid #dfdfdf;
		z-index:1030;
	}
	
	.tab-content .tab-pane{
		max-height:600px;
		position:relative;
		overflow:auto;
	}

	footer{
		padding-top:40px;
		margin-top:40px;
		border-top:1px solid #dedede;
	}
	.related-projects{
		padding-top:40px;
		margin-top:40px;
		
	}
	
	#cat-navi select{
			display:none;
		}
	.carousel-control span, .carousel-control .icon-prev, .carousel-control .icon-next {
		position: absolute;
		top: 50%;
		left: 50%;
		z-index: 5;
		display: inline-block;
		width: 20px;
		height: 20px;
		margin-top: -10px;
		margin-left: -10px;
		font-family: serif;
	}
		/*************** @media ******************/
	@media (max-width: 940px){
	.brand {
		display:block;
		text-align:center;
		font-size:26px;
		}
		#cat-navi select{
			display:block;
			width:100%;
		}
		#cat-navi li{
			display:none;
		}
}

@media (max-width: 1200px) and (min-width: 940px){
		
	
	
}

@media (max-width: 940px) and (min-width: 768px){
	.fixed-top{
		max-width:225px;
	}
	.row-fluid [class*="span"].left-side:last-child {
		clear:both;
	}
	


}

	
	 
    </style>

<link href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css" rel="stylesheet">

<!--[if lt IE 7]>
	<link href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome-ie7.min.css" rel="stylesheet">
	<![endif]-->
    <!-- Fav and touch icons -->


<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js" type="text/javascript"></script>
    <![endif]-->
<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="/resources/images/favicon.ico">
<!-- 
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
 -->	
	
	
	<body>
	
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
			
			function fillInBillingFields() {
				   var fields = document.getElementById("billAddresses").value.split(",");
				   document.getElementById("billAddressId").value = fields[0];
				   //document.getElementById("billFirstName").value = fields[1]; // name
				   //document.getElementById("billLastName").value = fields[2]; // name
				   //document.getElementById("billAddress1").value = fields[3]; // name
				   //document.getElementById("billAddress2").value = fields[4]; // name
				   //document.getElementById("billAddress3").value = fields[5];
				   //document.getElementById("billCompany").value = fields[6];
				   //document.getElementById("billCity").value = fields[7];
				   //document.getElementById("billState").value = fields[8];
				   //document.getElementById("billZipcode").value = fields[9];
				}
			
			function fillInShippingFields() {
				   var fields = document.getElementById("shipAddresses").value.split(",");
				   
				   document.getElementById("shipFirstName").value = fields[0]; // name
				   document.getElementById("shipLastName").value = fields[1]; // name
				   document.getElementById("shipAddress1").value = fields[2]; // name
				   document.getElementById("shipAddress2").value = fields[3]; // name
				   document.getElementById("shipAddress3").value = fields[4];
				   document.getElementById("shipCity").value = fields[5];
				   document.getElementById("shipState").value = fields[6];
				   document.getElementById("shipPostCode").value = fields[7];
				}
			
			
			function setFocusToTextBox(){
			    document.getElementById("FirstName").focus();
			}
			
			function validateBillingAddress() {
				select = document.getElementById('billAddresses'); // or in jQuery use: select = this;
				if (select.value) {
				  // value is set to a valid option, so submit form
				   document.getElementById("billingError").innerHTML = "";
				   $("#collapseTwo").collapse('hide');
				   $("#collapseThree").collapse('show');
				   window.location.replace("#collapseThree");
				}
				else {
					document.getElementById("billingError").innerHTML = "Please select an address!";
				}

			}
			
			function validateShippingAddress() {
				select = document.getElementById('shipAddresses'); // or in jQuery use: select = this;
				if (select.value) {
				  // value is set to a valid option, so submit form
				   document.getElementById("shippingError").innerHTML = "";
				   $("#collapseThree").collapse('hide');
				   $("#collapseFour").collapse('show');
				   window.location.replace("#collapseFour");
				}
				else {
					document.getElementById("shippingError").innerHTML = "Please select an address!";
				}

			}
			
	
			function validateShipping() {

			if (document.getElementById("optionsRadios1").checked != true ||
				document.getElementById("optionsRadios2").checked != true)
			{
				document.getElementById("shipChoiceError").innerHTML = "Please select a shipping method!";
			}
			else {
		  	  // value is set to a valid option, so submit form
		  	    document.getElementById("shipChoiceError").innerHTML = "";
				$("#collapseFour").collapse('hide');
				$("#collapseFive").collapse('show');
				window.location.replace("#collapseFive");	
			}
			}
			
			
		</script>
		
	
			
			<c:if test="${not empty order.billingAddress}">
				<script>
					$('#accordion').accordion('option', 'active', ( 3 ));
				</script>
			</c:if>
		<!----start-container----->
		<div class="header-bg">
			<div class="container">
			
			<c:if test="${name != 'Anonymoususer'}">
				<ul class="list-inline pull-right">
		 			<li><span class="text-right" style="color: gray">Welcome back : ${name} | </span><a href="javascript:formSubmit()"> Logout</a></li>
		 			<sec:authorize access="hasRole('ROLE_USER')">
		 				<li><a href="account">Account</a></li>
		 			</sec:authorize>
		 			<sec:authorize access="hasRole('ROLE_ADMIN')">
		 				<li><a href="admin">Admin</a></li>
		 			</sec:authorize>
		 		</ul>
			</c:if>

    		<c:if test="${name == 'Anonymoususer'}">
        		<ul class="list-inline pull-right">
		 			<li><a href="login">Login</a></li>
		 			<li><a href="registration">Register</a></li>
		 		</ul>
    			
			</c:if>
			 
				<div class="row">
					<div class="col-md-4">
						<div class="logo"><a href="welcome"><img src="/resources/images/crutch_logo_final.png" alt=""/></a></div>
					</div>
					<div class="col-md-8">		
								
	 					<nav class="navbar navbar-default" role="navigation">
						  <div class="container-fluid">
						    <!-- Brand and toggle get grouped for better mobile display -->
						    <div class="navbar-header"><span class="text-left"><a href="#">MENU</a></span>
						      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						        <span class="sr-only">Toggle navigation</span>
						        <span class="icon-bar"></span>
						        <span class="icon-bar"></span>
						        <span class="icon-bar"></span>
						      </button>						   
						    </div>					
						    <!-- Collect the nav links, forms, and other content for toggling -->
						    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						      <ul class="nav navbar-nav">
						      	 <li>
						         <div class="btn-group show-on-hover">
							          <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
							            Categories<span class="caret"></span>
							          </button>
							          <ul class="dropdown-menu" role="menu">
							            <li><a href="products">New Arrivals</a></li>
							            <li><a href="products">Men's Tees</a></li>
							            <li><a href="#">More Coming Soon!!!</a></li>						            
							          </ul>
							        </div>						          
						        </li>
						        <li><a href="#">About</a></li>
						        <li><a href="contact">Contact</a></li>
						      </ul>							      					    					      
						    </div><!-- /.navbar-collapse -->
						  </div><!-- /.container-fluid -->
						</nav>
						<div class="right pull-right">
							<ul class="list-unstyled">
								<c:if test="${name != 'Anonymoususer'}">
									<li class="a text-left"><a href="cart"><span class="glyphicon glyphicon-shopping-cart"></span></a>${cartQty}</li>
								</c:if>
								<c:if test="${name == 'Anonymoususer'}">
									<li class="a text-left"><a href="cart"><span class="glyphicon glyphicon-shopping-cart"></span></a></li>
								</c:if>
								<li><a href="checkout">Checkout</a></li>						
							</ul>							
						</div>	
					</div>
					<!----start-images-slider---->	
				  <!-- Single button -->
      
				</div>
			</div>
        </div>	
        
        <br>
        
        
<!-- MAIN CONTAINER-->
<div class="container">
	<div class="row">
		<div class="col-lg-12">
			
<div class="panel-group" id="accordion">
  <div class="panel panel-default">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
           STEP 1: CHECKOUT OPTIONS
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in">
       <div class="panel-body">
              <div class="row">
				<div class="col-6 col-lg-5">
					<!-- FORM -->
						<form action="login">
						  <fieldset>
							<legend>Sign in</legend>
							<!--  
							<div class="form-group">
							  <label for="exampleInputEmail">Email address</label>
							  <input type="text" class="form-control" id="exampleInputEmail" placeholder="Enter email">
							</div>
							<div class="form-group">
							  <label for="exampleInputPassword">Password</label>
							  <input type="password" class="form-control" id="exampleInputPassword" placeholder="Password">
							</div>
							<div class="checkbox">
							  <label>
								<input type="checkbox"> Check me out
							  </label>
							</div>
							-->
							<button type="submit" class="btn btn-default">Sign In</button>
						  </fieldset>
						</form>
					<!-- /FORM -->
					
				</div>
				<div class="col-6 col-lg-5 col-offset-1">
					<!-- FORM -->
						<form action="registration">
						  <fieldset>
						    
							<legend>New Registration</legend>
							<!--
							<div class="form-group">
							  <label for="exampleInputEmail">Email address</label>
							  <input type="text" class="form-control" id="exampleInputEmail" placeholder="Enter email">
							</div>
							<div class="form-group">
							  <label for="exampleInputPassword">Password</label>
							  <input type="password" class="form-control" id="exampleInputPassword" placeholder="Password">
							</div>
							<div class="checkbox">
							  <label>
								<input type="checkbox"> Check me out
							  </label>
							</div>
							-->
							<button type="submit" class="btn btn-default">Register</button>
						  </fieldset>
						</form>
					<!-- /FORM -->
				</div>
			  </div>
            </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a class="accordion-toggle panel-collapse collapse in" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
          STEP 2: ACCOUNT &amp; BILLING DETAILS
        </a>
      </h4>
    </div>
    
   
    
    <div id="collapseTwo" class="panel-collapse collapse">
       <div class="panel-body">
              <div class="row">
				<div class="col-12 col-lg-12">
					<!-- FORM -->
					<form:form method="post"  action="checkout" commandName="order" id="verifyBilling">
						  <fieldset>
							<legend>Select your billing address</legend>
							
							<c:if test="${not empty addressList}">
							<div class="form-group">
								<select class="form-control required" id="billAddresses" onchange="fillInBillingFields()">
	   								<c:forEach var="address" items="${addressList}">
	   									<option value="">--Select From Addresses--</option>
	      								<option value="${address.id}">${address.shortName}, ${address.address1}...${address.zipcode}</option>
	   								</c:forEach>
								</select>
								<span id="billingError" style="color: #ff0000; padding-top:3px;" class="help-inline"></span>
							<div id="demo"></div>
							</div>
							</c:if>
							<form:hidden path="billingAddress.id" id="billAddressId"/>
							<form:hidden path="billingAddress.firstName" id="billFirstName"/>
							<form:hidden path="billingAddress.lastName" id="billLastName"/>
							<form:hidden path="billingAddress.company" id="billCompany"/>
							<form:hidden path="billingAddress.address1" id="billAddress1"/>
							<form:hidden path="billingAddress.address2" id="billAddress2"/>
							<form:hidden path="billingAddress.address3" id="billAddress3"/>
							<form:hidden path="billingAddress.city" id="billCity"/>
							<form:hidden path="billingAddress.state" id="billState"/>
							<form:hidden path="billingAddress.zipcode" id="billZipcode"/>
							
							<!--  
							<div class="form-group">
							  <label for="FirstName">First Name</label>
							  <form:input type="text" path="billingAddress.firstName" class="form-control" id="FirstName" placeholder="Enter First Name"/>
							</div>
							<div class="form-group">
							  <label for="LastName">Last Name</label>
							  <form:input type="text" path="billingAddress.lastName" class="form-control" id="LastName" placeholder="Enter Last Name"/>
							</div>
							<div class="form-group">
							  <label for="Company">Company</label>
							  <form:input type="text" path="billingAddress.company" class="form-control" id="Company" placeholder="Enter Company"/>
							</div>
							<div class="form-group">
							  <label for="Adress1">Adress 1</label>
							  <form:input type="text" path="billingAddress.address1" class="form-control" id="Address1" placeholder="Enter Adress 1"/>
							</div>	
							
							<div class="form-group">
							  <label for="Adress2">Adress 2</label>
							  <form:input type="text" path="billingAddress.address2" class="form-control" id="Address2" placeholder="Enter Adress 2"/>
							</div>
							
							<div class="form-group">
							  <label for="Adress3">Adress 3</label>
							  <form:input type="text" path="billingAddress.address3" class="form-control" id="Address3" placeholder="Enter Adress 3"/>
							</div>
							
							<div class="form-group">
							  <label for="City">City</label>
							  <form:input type="text" path="billingAddress.city" class="form-control" id="City" placeholder="Enter City"/>
							</div>
							 
							
							<div class="form-group">
							  <label for="CountrySelect">State</label>
									<form:select path="billingAddress.state" id="State" class="form-control" name="CountrySelect">
										<form:option value="default" selected="selected"> - Select State - </form:option>
										<form:option value="Alabama">Alabama</form:option>
										<form:option value="Alaska">Alaska</form:option>
										<form:option value="Arizona">Arizona</form:option>
										<form:option value="Arkansas">Arkansas</form:option>
										<form:option value="California">California</form:option>
										<form:option value="Colorado">Colorado</form:option>
										<form:option value="Connecticut">Connecticut</form:option>
										<form:option value="Delaware">Delaware</form:option>
										<form:option value="Florida">Florida</form:option>
										<form:option value="Georgia">Georgia</form:option>
										<form:option value="Hawaii">Hawaii</form:option>
										<form:option value="Idaho">Idaho</form:option>
										<form:option value="Illinois">Illinois</form:option>
										<form:option value="Indiana">Indiana</form:option>
										<form:option value="Iowa">Iowa</form:option>
										<form:option value="Kansas">Kansas</form:option>
										<form:option value="Kentucky">Kentucky</form:option>
										<form:option value="Louisiana">Louisiana</form:option>
										<form:option value="Maine">Maine</form:option>
										<form:option value="Maryland">Maryland</form:option>
										<form:option value="Massachusetts">Massachusetts</form:option>
										<form:option value="Michigan">Michigan</form:option>
										<form:option value="Minnesota">Minnesota</form:option>
										<form:option value="Mississippi">Mississippi</form:option>
										<form:option value="Missouri">Missouri</form:option>
										<form:option value="Montana">Montana</form:option>
										<form:option value="Nebraska">Nebraska</form:option>
										<form:option value="Nevada">Nevada</form:option>
										<form:option value="New Hampshire">New Hampshire</form:option>
										<form:option value="New Jersey">New Jersey</form:option>
										<form:option value="New Mexico">New Mexico</form:option>
										<form:option value="New York">New York</form:option>
										<form:option value="North Carolina">North Carolina</form:option>
										<form:option value="North Dakota">North Dakota</form:option>
										<form:option value="Ohio">Ohio</form:option>
										<form:option value="Oklahoma">Oklahoma</form:option>
										<form:option value="Oregon">Oregon</form:option>
										<form:option value="Pennsylvania">Pennsylvania</form:option>
										<form:option value="Rhode Island">Rhode Island</form:option>
										<form:option value="South Carolina">South Carolina</form:option>
										<form:option value="South Dakota">South Dakota</form:option>
										<form:option value="Tennessee">Tennessee</form:option>
										<form:option value="Texas">Texas</form:option>
										<form:option value="Utah">Utah</form:option>
										<form:option value="Vermont">Vermont</form:option>
										<form:option value="Virginia">Virginia</form:option>
										<form:option value="Washington">Washington</form:option>
										<form:option value="West Virginia">West Virginia</form:option>
										<form:option value="Wisconsin">Wisconsin</form:option>
										<form:option value="Wyoming">Wyoming</form:option>
									</form:select>
							</div>
							
							<div class="form-group">
							  <label for="PostCode">Post Code</label>
							  <form:input type="text" path="billingAddress.zipcode" class="form-control" id="PostCode" placeholder="Enter Post Code"/>
							</div>
							-->
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		
							<button type="button" class="btn btn-info collapseTwoBtn" data-toggle="collapse" onclick="validateBillingAddress()" >Continue</button>
						  </fieldset>
						</form:form>
					<!-- /FORM -->
				</div>
			  </div>
            </div>
    </div>
    
    	
    
  </div>
  
  <div class="panel panel-default">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
          STEP 3: SHIPPING DETAILS
        </a>
      </h4>
    </div>
    <div id="collapseThree" class="panel-collapse collapse">
       <div class="panel-body">
              <div class="row">
				<div class="col-12 col-lg-12">
					<!-- FORM -->
						<form:form method="post" action="checkout" commandName="order" id="verifyShipping">
						  <fieldset>
							<legend>Choose shipping address</legend>
							
							<c:if test="${not empty addressList}">
							<div class="form-group">
								<select class="form-control" id="shipAddresses" onchange="fillInShippingFields()">
	   								<c:forEach var="address" items="${addressList}">
	   									<option value="">--Select Saved Address--</option>
	      								<option value="${address.firstName},${address.lastName},${address.address1},${address.address2},${address.address3},${address.city},${address.state},${address.zipcode}">${address.shortName}${address.address1}...${address.zipcode}</option>
	   								</c:forEach>
								</select>
								<span id="shippingError" style="color: #ff0000;" class="help-inline"></span>
							</div>
							</c:if>
							
							<!-- 
							<div class="form-group">
							  <label for="shipFirstName">First Name</label>
							  <form:input type="text" path="shippingAddress.firstName" class="form-control" id="shipFirstName" placeholder="Enter First Name" disabled="true"/>
							</div>
							<div class="form-group">
							  <label for="shipLastName">Last Name</label>
							  <form:input type="text" path="shippingAddress.lastName" class="form-control" id="shipLastName" placeholder="Enter Last Name"/>	
							</div>
							<div class="form-group">
							  <label for="Company">Company</label>
							  <input type="text" path="shippingAddress.company" class="form-control" id="shipCompany" placeholder="Enter Company">
							</div>
							<div class="form-group">
							  <label for="shipAddress1">Address1</label>
							  <form:input type="text" path="shippingAddress.address1" class="form-control" id="shipAddress1" placeholder="Enter Address 1"/>
							</div>
							
							<div class="form-group">
							  <label for="Adress2">Adress 2</label>
							  <input type="text" class="form-control" id="shipAddress2" placeholder="Enter Adress 2">
							</div>	
							
							<div class="form-group">
							  <label for="Adress3">Adress 3</label>
							  <input type="text" class="form-control" id="shipAddress3" placeholder="Enter Adress 3">	
							</div>
							<div class="form-group">
							  <label for="City">City</label>
							  <input type="text" path="shippingAddress.city" class="form-control" id="shipCity" placeholder="Enter City">
				
							</div>
						
							<div class="form-group">
							  <label for="CountrySelect">State</label>
							  <form:select id="shipState" path="shippingAddress.state" class="form-control" name="CountrySelect">
										<form:option value="default" selected="selected"> - Select State - </form:option>
										<form:option value="Alabama">Alabama</form:option>
										<form:option value="Alaska">Alaska</form:option>
										<form:option value="Arizona">Arizona</form:option>
										<form:option value="Arkansas">Arkansas</form:option>
										<form:option value="California">California</form:option>
										<form:option value="Colorado">Colorado</form:option>
										<form:option value="Connecticut">Connecticut</form:option>
										<form:option value="Delaware">Delaware</form:option>
										<form:option value="Florida">Florida</form:option>
										<form:option value="Georgia">Georgia</form:option>
										<form:option value="Hawaii">Hawaii</form:option>
										<form:option value="Idaho">Idaho</form:option>
										<form:option value="Illinois">Illinois</form:option>
										<form:option value="Indiana">Indiana</form:option>
										<form:option value="Iowa">Iowa</form:option>
										<form:option value="Kansas">Kansas</form:option>
										<form:option value="Kentucky">Kentucky</form:option>
										<form:option value="Louisiana">Louisiana</form:option>
										<form:option value="Maine">Maine</form:option>
										<form:option value="Maryland">Maryland</form:option>
										<form:option value="Massachusetts">Massachusetts</form:option>
										<form:option value="Michigan">Michigan</form:option>
										<form:option value="Minnesota">Minnesota</form:option>
										<form:option value="Mississippi">Mississippi</form:option>
										<form:option value="Missouri">Missouri</form:option>
										<form:option value="Montana">Montana</form:option>
										<form:option value="Nebraska">Nebraska</form:option>
										<form:option value="Nevada">Nevada</form:option>
										<form:option value="New Hampshire">New Hampshire</form:option>
										<form:option value="New Jersey">New Jersey</form:option>
										<form:option value="New Mexico">New Mexico</form:option>
										<form:option value="New York">New York</form:option>
										<form:option value="North Carolina">North Carolina</form:option>
										<form:option value="North Dakota">North Dakota</form:option>
										<form:option value="Ohio">Ohio</form:option>
										<form:option value="Oklahoma">Oklahoma</form:option>
										<form:option value="Oregon">Oregon</form:option>
										<form:option value="Pennsylvania">Pennsylvania</form:option>
										<form:option value="Rhode Island">Rhode Island</form:option>
										<form:option value="South Carolina">South Carolina</form:option>
										<form:option value="South Dakota">South Dakota</form:option>
										<form:option value="Tennessee">Tennessee</form:option>
										<form:option value="Texas">Texas</form:option>
										<form:option value="Utah">Utah</form:option>
										<form:option value="Vermont">Vermont</form:option>
										<form:option value="Virginia">Virginia</form:option>
										<form:option value="Washington">Washington</form:option>
										<form:option value="West Virginia">West Virginia</form:option>
										<form:option value="Wisconsin">Wisconsin</form:option>
										<form:option value="Wyoming">Wyoming</form:option>
									</form:select>	
							</div>
							
							<div class="form-group">
							  <label for="PostCode">Post Code</label>
							  <input type="text" path="shippingAddress.zipcode" class="form-control" id="shipPostCode" placeholder="Enter Post Code">	
							</div>
							 -->
							 
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>							
							
							<button type="button" class="btn btn-info collapseThreeBtn" data-toggle="collapse" data-parent="#accordion" onclick="validateShippingAddress()" >Continue</button>
						  </fieldset>
						</form:form>
					<!-- /FORM -->
				</div>
			  </div>
            </div>
    </div>
  </div> 
  
  <div class="panel panel-default">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseFour">
          STEP 4: SHIPPING METHOD
        </a>
      </h4>
    </div>
    <div id="collapseFour" class="panel-collapse collapse">
        <div class="panel-body">
              <div class="row">
				<div class="col-12 col-lg-12">
				<form>
					<fieldset>
							<legend>CHOOSE SHIPPING METHOD</legend>
						<div class="radio">
						  <label>
							<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
							Flat USPS Priority Mail Shipping Rate - $8.00
						  </label>
						</div>
						<div class="radio">
						  <label>
							<input type="radio" name="optionsRadios" id="optionsRadios3" value="option3">
							USPS Expedited Mail Shipping Rate - $24.00
						  </label>
						</div>
						<button type="button" class="btn btn-info collapseFourBtn" data-toggle="collapse" onclick="validateShipping()" >Continue</button></a>
					</fieldset>
				</form>
				<span id="shipChoiceError" style="color: #ff0000;" class="help-inline"></span>
				</div>
			  </div>
            </div>
    </div>
  </div> 
  
  <div class="panel panel-default">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseFive">
           STEP 5: PAYMENT METHOD
        </a>
      </h4>
    </div>
    <div id="collapseFive" class="panel-collapse collapse">
       <div class="panel-body">
              <div class="row">
				<div class="col-12 col-lg-12">
					<form>
						<fieldset>
								<legend>CHOOSE PAYMENT METHOD</legend>
						<div class="radio">
							  <label>
								<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
								PayPal 
							  </label>
							</div>
							<div class="radio">
							  <label>
								<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
								Cash on Delivery
							  </label>
							</div>
							<a href="#collapseSix"><button type="button" class="btn btn-info collapseFiveBtn" data-toggle="collapse" data-parent="#accordion" data-target="#collapseSix" >Continue</button></a>
						</fieldset>
					</form>
			  </div>
            </div>
          </div>
    </div>
  </div> 
  
  <div class="panel panel-default">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseSix">
          STEP 6: CONFIRM ORDER
        </a>
      </h4>
    </div>
    <div id="collapseSix" class="panel-collapse collapse">
       <div class="panel-body">
              <div class="row">
				<div class="col-12 col-lg-12">
					<table class="table table-striped">
						<thead>
							  <tr>
								<th>Item</th>
								<th>Qty</th>
								<th>Size</th>
								<th>Color</th>
								<th>Price</th>
								<th>Total</th>
							  </tr>
							</thead>
							<tbody>
							<c:forEach var="cartProd" items="${cartProducts}">
							<c:forEach var="cartRef" items="${cartProd.cartProductRefs}">
								<tr>
								<td>${cartRef.cartProduct.product.name }</td>
								<c:set var="totalQuan" value="${cartRef.productQuantity}"></c:set>
								<td>${totalQuan}</td>
								<td>${cartRef.productDetail.size}</td>
								<td>${cartRef.productDetail.color}</td>
								<td>$${cartRef.productDetail.product.price}</td>
								<c:set var="eachTotal" value="${totalQuan * cartRef.productDetail.product.price}"></c:set>
								<td><fmt:formatNumber value="${eachTotal}" type="currency" maxFractionDigits="2"/></td>
							  
							  </tr>
							  </c:forEach>
							</c:forEach>
							</tbody>
					  </table>
					  <hr>
						<dl class="dl-horizontal pull-right">
						  <c:set var="sub_total" value="0"></c:set>
						  <c:if test="${subtotal > 0 }" >
						  <c:set var="sub_total" value="${subtotal}" ></c:set>
						  </c:if>
						  <dt>Sub-total:</dt>
						  <dd>$${subtotal}</dd>
						  <dt>Shipping Cost:</dt>
						  <c:set var="shipping" value="" ></c:set>
						  <c:if test="${subtotal > 0 }" >
						  <c:set var="shipping" value="8" ></c:set>
						  </c:if>
						  <dd>$${shipping}</dd>
						  <dt>Total:</dt>
						  <dd>$${subtotal + shipping}</dd>
						</dl>
					<div class="clearfix"></div>
					<button type="submit" class="btn btn-info pull-right">Confirm Order</button>
					
					<form action="" method="POST">
  <script
    src="https://checkout.stripe.com/checkout.js" class="stripe-button"
    data-key="pk_test_Eb0m2uBHbsPfIarhifiMcBd1"
    data-amount="2000"
    data-name="Demo Site"
    data-description="2 widgets ($20.00)"
    data-image="/128x128.png">
  </script>
</form>
				</div>
			  </div>
            </div>
    </div>
  </div>
</div>
				
				

		</div>
	</div>
</div> <!-- /container -->
<!-- FOOTER-->
<div class="footer">
	<div class="container">
		 <div class="row">
		 	<div class="col-md-12">
		 		<ul class="list-inline pull-right">
		 			<li><a href="welcome">Home</a></li>
		 			<li><a href="products">Products</a></li>
		 			<li><a href="cart">Cart</a></li>
		 			<li><a href="account">Account</a></li>
		 			<li><a href="contact">Contact</a></li>
		 		</ul>
		 		<!-- 
		 		<form class="navbar-form pull-right" role="search">
			        <div class="form-group">
			        <input type="text" class="form-control" placeholder="Search">
			        </div>
			        <button type="Find" class="btn btn-default">Find</button>
			    </form>
			     -->
		 	</div>	
		 </div>	
		 <div class="copy-right text-center">
			<p>&#169Copyright 2014 All Rights Reserved Crutch Clothing <a href="welcome">crutchclothing.com</a></p>	
		</div>
	</div>
</div>
<!-- /Footer-->







    <!-- Le javascript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="assets/js/jquery.js" type="text/javascript"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="assets/js/bootstrap.min.js"></script>


<script>
/***************************************************
responsive menu
***************************************************/

jQuery(function (jQuery) {
    jQuery("#cat-navi").append("<select/>");
	jQuery("#cat-navi select").addClass("form-control");
    jQuery("<option />", {
        "selected": "selected",
        "value": "",
        "text": "Choose category"
    }).appendTo("#cat-navi select");
    //new dropdown menu
    jQuery("#cat-navi a").each(function () {
        var el = jQuery(this);
        var perfix = '';
        switch (el.parents().length) {
            case (11):
                perfix = '-';
                break;
            case (13):
                perfix = '--';
                break;
            default:
                perfix = '';
                break;

        }
        jQuery("<option />", {
            "value": el.attr("href"),
            "text": perfix + el.text()
        }).appendTo("#cat-navi select");
    });

    jQuery('#cat-navi select').change(function () {

        window.location.href = this.value;

    });
});

</script>

</body>
</html>