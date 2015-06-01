<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@page session="false"%>
<%@taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<!-- saved from url http://www.bootstraptor.com ####################################################################
Don't remove this attribution. 
This template build on DevKit http://www.bootstraptor.com 
##########################################################################
-->
<html lang="en">
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
	<!--end slider -->
	
	<script>
				
				function changeToSmall() {
						document.getElementById("size").value="sm";
				}
				function changeToMedium() {
					document.getElementById("size").value="md";
				}
				function changeToLarge() {
					document.getElementById("size").value="lg";
				}
				function changeToXLarge() {
					document.getElementById("size").value="xl";
				}
				
				function removeItem() {
					  var rows = $('input');
					  if ( rows.length > 2 ) {
					    // change: work on filtered jQuery object
					    rows.filter(":last").html('');
					    $('form :hidden:last').val('');
					  } else {
					    alert('Cannot remove any more rows');
					  }
					}
				
				function toggleFormElements(bDisabled) { 
				    var inputs = document.getElementsByTagName("input"); 
				    for (var i = 0; i < inputs.length; i++) { 
				        	inputs[i].disabled = bDisabled;
				    }
				    
				    document.getElementById("update").disabled = false;
				
				}
				
				(function($) {
					  $.fn.toggleDisabled = function() {
					    return this.each(function() {
					        var $this = $(this);
					        if ($this.attr('disabled')) $this.removeAttr('disabled').show();
					        else $this.attr('disabled', 'disabled');
					    });
					 };
					})(jQuery);

					 $(function() {
					 $('#edits').click(function() {
					    $('#inputSubmit').toggleDisabled();
					    $('#email').toggleDisabled();
					    $('#phoneNumber').toggleDisabled();
					    $('#firstName').toggleDisabled();
					    $('#lastName').toggleDisabled();
					    $('#middleInit').toggleDisabled();
					    $('#edits').toggleDisabled();
					    $('#cancel').toggleDisabled();
					  });
					 
					 });
					 
					 $(function() {
						 $('#cancel').click(function() {
						    $('#inputSubmit').toggleDisabled();
						    $('#email').toggleDisabled();
						    $('#phoneNumber').toggleDisabled();
						    $('#firstName').toggleDisabled();
						    $('#lastName').toggleDisabled();
						    $('#middleInit').toggleDisabled();
						    $('#edits').toggleDisabled();
						    $('#cancel').toggleDisabled();
						    
						    
						  });
						 
						 });
					 
					 
					 //$('#addressBtn').click(function(){
					//	  $('#show-address').toggle();
						//});
					 
					 
					 jQuery('#addressBtn').live('click', function(event) {        
				         jQuery('#show-address').toggle('show');
				    });
					 
					 
					 $(document).ready(
				    		   function() {
				    		      //getParameterById("show-address-anchor").show();
				    		   });
					 
		
	</script>
	
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
<link rel="shortcut icon" href="images/crutch-favicon.ico">
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
		</script>
		
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
							            <li><a href="products">New arrivals</a></li>
							            <li><a href="products">Men</a></li>
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
									<li class="a text-left"><a href="cart"><span class="glyphicon glyphicon-shopping-cart"></span></a>${cartQty }</li>
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
                       
        
    <div class="container">
	<div class="panel panel-default">
	<div class="panel-heading">
		<h2>${name}'s Account</h2>
	</div>	
	

	<hr>
	

	<div class="tabbable"> <!-- Only required for left/right tabs -->
  		<ul class="nav nav-tabs">
   			<li class="active"><a href="#tab1" data-toggle="tab">Profile</a></li>
    		<li><a href="#tab2" data-toggle="tab">Orders</a></li>
  		</ul>
  	<div class="tab-content">
    <div class="tab-pane active" id="tab1">    


	<div class="panel-body">
		<div class="row">
		<div class="col-12 col-lg-12">

       	     <form:form class="form-horizontal col-md-12 center-block" method="post" modelAttribute="user" commandName="user" action="edit-account" id="accountForm">
       	     	 
       	     	 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
       	     	 
       	     	 <br>
       	     	 
       	     	 <div class="form-group">
				    <label>Username</label>
				      <form:input path="username" type='text' name='username' class="form-control input-lg" id="username" disabled="true" value="${username}"/>
				      <form:errors path="username" cssStyle="color: #ff0000;"/>				     
				  </div>				 
				  
				  
				  <div class="form-group">
				    <label for="email">Email Address</label>
				      <form:input path="email" type='text' name='email' class="form-control input-lg" placeholder="email" id="email" disabled="true"/>
				      <form:errors path="email" cssStyle="color: #ff0000;"/>				      
				  </div>
	
				  
				  
				  
				  <input type="hidden" name="enabled" path="enabled" value="true"/>
				  
				  
				  <div class="form-group">
					<div class="pull-left" style="padding-right: 10px">
				      <button class="btn btn-default btn-lg" type="submit" name="submit" value="submit" id="inputSubmit" disabled="true">Update!</button>
				      <button class="btn btn-default btn-lg" type="button" id="edits" >Edit</button>
					</div>
					<div class="pull-right" style="padding-top: 15px">
				      <button class="btn btn-default btn-lg" type="button" id="cancel" disabled="true" >Cancel</button>
				  	</div>
				  </div>

			 </form:form> 			

			<hr>
		</div>
			
</div>
</div>
<!-- 
</div>
    <div class="tab-pane" id="tab2">
      <p>Howdy, I'm in Section 2.</p>
    </div>
  	</div>
  	-->


	
	<div class="panel panel-default">
	<div class="panel-heading">
		<h3>Addresses</h3>
	</div>
	
	
	<div class="panel-body">
		<div class="row">
		<div class="col-12 col-lg-12">
		
		
		
	
	<div class="form-group">
	<div class="pull-left">
		<button class="btn btn-default btn-small" type="button" id="addressBtn">Add Address</button>
	</div>
	</div>
	<br>
	<br>
	<br>
	

       <div class="panel-body" id="show-address">
              <div class="row">
				<div class="col-12 col-lg-12">
			
					<!-- FORM -->
						<form:form class="form-horizontal col-md-12 center-block" method="post" modelAttribute="user" commandName="user" action="add-address.html" id="accountForm">
						  <fieldset>
							<legend>Enter your address</legend>
							
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							
							<div class="form-group">
							  <label for="firstName">First Name</label>
							  <form:input path="newAddress.firstName" type='text' name='newAddress.firstName' class="form-control input-lg" placeholder="first name" id="newAddress.firstName"/>
							  <form:errors path="newAddress.firstName" cssStyle="color: #ff0000;"/>
							</div>
							
							<div class="form-group">
							  <label for="lastName">Last Name</label>
							  <form:input path="newAddress.lastName" type='text' name='newAddress.lastName' class="form-control input-lg" placeholder="last name" id="newAddress.lastName"/>
							  <form:errors path="newAddress.lastName" cssStyle="color: #ff0000;"/>
							</div>
							
							<div class="form-group">
							  <label for="company">Company</label>
							  <form:input path="newAddress.company" type='text' name='newAddress.company' class="form-control input-lg" placeholder="company" id="newAddress.company"/>
							</div>	
							
							<div class="form-group">
							  <label for="Adress1">Adress 1</label>
							  <form:input path="newAddress.address1" type='text' name='newAddress.address1' class="form-control input-lg" placeholder="address 1" id="newAddress.address1"/>
							  <form:errors path="newAddress.address1" cssStyle="color: #ff0000;"/>
							</div>	
							
							<div class="form-group">
							  <label for="Adress2">Adress 2</label>
							  <form:input path="newAddress.address2" type='text' name='newAddress.address2' class="form-control input-lg" placeholder="address 2" id="newAddress.address2"/>
							  <form:errors path="newAddress.address2" cssStyle="color: #ff0000;"/>
							</div>
							
							<div class="form-group">
							  <label for="Adress3">Adress 2</label>
							  <form:input path="newAddress.address3" type='text' name='newAddress.address3' class="form-control input-lg" placeholder="address 3" id="newAddress.address3"/>
							  <form:errors path="newAddress.address3" cssStyle="color: #ff0000;"/>
							</div>
							
							<div class="form-group">
							  <label for="city">City</label>
							  <form:input path="newAddress.city" type='text' name='newAddress.city' class="form-control input-lg" placeholder="city" id="newAddress.city"/>
							  <form:errors path="newAddress.city" cssStyle="color: #ff0000;"/>
							</div>
							
							<div class="form-group">
							  <label for="zipcode">Zip Code</label>
							  <form:input path="newAddress.zipcode" type='text' name='newAddress.zipcode' class="form-control input-lg" placeholder="zip code" id="newAddress.zipcode"/>
							  <form:errors path="newAddress.zipcode" cssStyle="color: #ff0000;"/>
							</div>
							
							<div class="form-group">
							  <label for="phone">Phone Number</label>
							  <form:input path="newAddress.phone" type='text' name='newAddress.phone' class="form-control input-lg" placeholder="phone number" id="newAddress.phone"/>
							  <form:errors path="newAddress.phone" cssStyle="color: #ff0000;"/>
							</div>
							
							<div class="form-group">
							  <label for="CountrySelect">State</label>
							  <form:select path="newAddress.state" name="newAddress.state" class="form-control">
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
									<form:errors path="newAddress.state" cssStyle="color: #ff0000;"/>
									</div>
							
									
									<form:hidden path="username" value="${username}"/>
									<form:hidden path="email"/>

									
									<div class="form-group">
										<div class="pull-left" style="padding-left: 17px; padding-top: 10px">
				     						<button class="btn btn-default btn-lg" type="submit" name="addressSubmit" value="submit" id="addressSubmit">Add Address</button>
										</div>
				 					</div>
															

						  </fieldset>
						</form:form>
					<!-- /FORM -->
				</div>
			  </div>
            </div>
    		
    
    
    
    
    
    <!-- MAIN PRODUCTS GRID-->
	<div class="container-folio row">
			
				<!-- PROD GRID 
				============================================================ -->
				
				<c:forEach var="address" items="${addressList}">
				<!-- PROD. ITEM -->
				 <div class="col-xs-6 col-sm-6 col-md-4 col-lg-4">
					<div class="thumbnail">
						<!-- IMAGE CONTAINER-->
						<!--  <img class="img-responsive"  src="images/thumb.jpg" alt="post image"> -->
						<!--END IMAGE CONTAINER-->
						<!-- CAPTION -->
						<div class="caption">
						<h2 class="">Address</h2>							
							<div class="row">
								<hr>
								<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
								<address>
									<p>${address.firstName} ${address.lastName}</p>
									<p>${address.address1 }</p>
									<c:if test="not empty ${address.company }">
										<p>${address.company}</p>
									</c:if>
									<c:if test="not empty ${address.address2 }">
										<p>${address.address2}</p>
									</c:if>
									<c:if test="not empty ${address.address3 }">
										<p>${address.address3}</p>
									</c:if>
									<p>${address.city}
									${address.state}, ${address.zipcode}</p>
									</address>
								</div>
							
								
								
									<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
									
										<form method="post" action="change-primary-address">
											<p><a class="btn btn-success btn-block" href="#">Edit Address</a></p>
											<input type="hidden" name="addressId" value=${address.id} />
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
										</form>
										
										<form method="post" action="delete-address">
											<button class="btn btn-success btn-block" type="submit">Delete Address</button>
											<input type="hidden" name="addressId" value=${address.id} />
											<input type="hidden" name="username" value=${username} />
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
										</form>
									</div>
									
								
								</div>
							</div>
						</div> 
						<!--END CAPTION -->
					</div>
					<!-- END: THUMBNAIL -->
					</c:forEach>
				</div>
				<!-- PROD. ITEM -->
				
				
				
			
				
				<!-- / PROD GRID 
				======================================= -->
			</div>
 
	
	</div>
	
</div>
</div>
</div>
<div class="tab-pane" id="tab2">
      <p>Section 2.</p>
    </div>
</div>
    
  	</div>

</div>
</div> <!-- container -->

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
		
</body>
</html>