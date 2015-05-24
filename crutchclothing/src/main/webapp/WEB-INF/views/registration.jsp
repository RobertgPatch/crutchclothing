<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@page session="false"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
    
    <sec:authorize access="hasRole('ROLE_ADMIN')">
		<c:redirect url="/admin"/>
	</sec:authorize>


	<sec:authorize access="hasRole('ROLE_USER')">
		<c:redirect url="/welcome"/>
	</sec:authorize>
<html>
	<head>
		<title>Crutch Clothing - SF Based Appperal</title>
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
	</head>
	<body>
		<!----start-container----->
		<div class="header-bg">
			<div class="container">
			  <ul class="list-inline pull-right">
		 			<li><a href="login">Login</a></li>
		 			<li><a href="registration">Register</a></li>
		 		</ul>
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
							           <li><a href="#">New arrivals</a></li>
							             <c:forEach items="${category}" var="cat">
     									 	<li><a href="#">${cat.name}</a></li>
    									 </c:forEach>
							            <li><a href="#">More Coming Soon!!!</a></li>						            
							          </ul>
							        </div>						          
						        </li>
						        <li><a href="about.html">About</a></li>
						        <li><a href="blog.html">Blog</a></li>
						        <li><a href="contact.html">Contact</a></li>
						      </ul>							      					    					      
						    </div><!-- /.navbar-collapse -->
						  </div><!-- /.container-fluid -->
						</nav>
						<div class="right pull-right">
							<ul class="list-unstyled">
								
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
        
        
         <div class="container">
       	   <div class="main">
       	   	 <div class="row">
	       	   	<div class="col-md-12 text-center">
			 		<h2>Registration</h2>
			 	</div>	
		 	</div>
       	     <form:form class="form-horizontal col-md-12 center-block" method="post" modelAttribute="user" commandName="user" action="process-user.html">
       	     	 
       	     	 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
       	     	 
       	     	 <div class="form-group">
				    <label for="username" class="col-sm-2 control-label">Username</label>
				    <div class="col-sm-10">
				      <form:input path="username" type='text' name='username' class="form-control input-lg" placeholder="username" id="username"/>
				      <form:errors path="username" cssStyle="color: #ff0000;"/>				      
				    </div>
				  </div>
				  
				   <div class="form-group">
				    <label for="password" class="col-sm-2 control-label">Password</label>
				    <div class="col-sm-10">
				      <form:input path="password" type='password' name='password' class="form-control input-lg" placeholder="password" id="password"/>
				      <form:errors path="password" cssStyle="color: #ff0000;"/>				      
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="passwordConf" class="col-sm-2 control-label">Confirm Password</label>
				    <div class="col-sm-10">
				      <form:input path="passwordConf" type='password' name='passwordConf' class="form-control input-lg" placeholder="confirm password" id="passwordConf"/>
				      <form:errors path="passwordConf" cssStyle="color: #ff0000;"/>				      
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="firstName" class="col-sm-2 control-label">First Name</label>
				    <div class="col-sm-10">
				      <form:input path="firstName" type='text' name='firstName' class="form-control input-lg" placeholder="first name" id="firstName"/>
				      <form:errors path="firstName" cssStyle="color: #ff0000;"/>				      
				    </div>
				  </div>
					
				  <div class="form-group">
				    <label for="middleInit" class="col-sm-2 control-label">Middle Initial</label>
				    <div class="col-sm-10">
				      <form:input path="middleInit" type='text' name='middleInit' class="form-control input-lg" placeholder="middle initial" id="middleInit"/>
				      <form:errors path="middleInit" cssStyle="color: #ff0000;"/>				      
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="lastName" class="col-sm-2 control-label">Last Name</label>
				    <div class="col-sm-10">
				      <form:input path="lastName" type='text' name='lastName' class="form-control input-lg" placeholder="last name" id="lastName"/>
				      <form:errors path="lastName" cssStyle="color: #ff0000;"/>				      
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="phoneNumber" class="col-sm-2 control-label">Phone Number</label>
				    <div class="col-sm-10">
				      <form:input path="phoneNumber" type='text' name='phoneNumber' class="form-control input-lg" placeholder="phone number" id="phoneNumber"/>
				      <form:errors path="phoneNumber" cssStyle="color: #ff0000;"/>				      
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="email" class="col-sm-2 control-label">Email Address</label>
				    <div class="col-sm-10">
				      <form:input path="email" type='text' name='email' class="form-control input-lg" placeholder="email" id="email"/>
				      <form:errors path="email" cssStyle="color: #ff0000;"/>				      
				    </div>
				  </div>
				  
				  <input type="hidden" name="enabled" path="enabled" value="true"/>
				  
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      <button class="btn btn-default btn-lg" type="submit" name="submit" value="submit">Register!</button>
				    </div>
				  </div>
				 
              
			 </form:form>

           </div>
       </div>
       

		
          <div class="modal-footer">
            <div class="col-md-12">
            </div>
          </div>
 
    <!-- script references -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"
    >
    </script>
    </body>
    
    </html>