<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
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
						<div class="logo"><a href="welcome"><img src="/resources/images/crutch_logo_final3.png" alt=""/></a></div>
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
									<li class="a text-left"><a href="cart"><span class="glyphicon glyphicon-shopping-cart"></span></a>${cartQuan}</li>
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
    <div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
           <!----start-images-slider---->
		<div class="images-sliderx">
		    <div id="fwslider">
		        <div class="slider_container">
		            <div class="slide"> 
		                    <img src="/resources/images/thecity.png" alt=""/>
		                <div class="slide_content">
		                    <div class="slide_content_wrap">
		                         <p class="description">New Arrivals</p>
		                        <h4 class="title"><a href="products">Men's Tops</a></h4>	
		                         <p class="description"><a href="products">Men's Tops</a></p>	                      
		                        <div class="slide-btns description">		            	                      
		                        </div>
		                    </div>
		                </div>
		            </div>		        
				   <div class="slide">
		                <img src="/resources/images/sf-port.jpg" alt=""/>
		                <div class="slide_content">
		                     <div class="slide_content_wrap">		                   
		                          <p class="description">New Arrivals</p>
		                        <h4 class="title"><a href="products">Men's Tops</a></h4>	
		                         <p class="description"><a href="products">Men's Tops</a></p>		 	                       		                       
		                        <div class="slide-btns description">		                      
		                        </div>
		                    </div>
		                </div>
		            </div>
		            <!--/slide -->
		        </div>
		        <div class="timers"> </div>
		        <div class="slidePrev"><span> </span></div>
		        <div class="slideNext"><span> </span></div>
		    </div>
		    <!--/slider -->
		</div>
        </div>
    </div>
</div>
<!----//End-container----->
 <div class="container">
 
 <br>
 
<div class="top">
	<div class="row">
					<div class="col-md-4">
						<div class="grid">
							<h2>About Us</h2>
					        <p>Crutch Clothing is a Bay-Area and Hawaii inspired clothing company based out of San Francisco. We will launch with a two limited edition men's tees.  As always we strive in delivering quality products and outstanding customer service to our members.</p>                          
	                    </div>
					</div>
					<div class="col-md-4">
						<div class="grid">
							<h2>Our Mission</h2>
					        <p>Our mission is to take our ideas and bring them to life, we hope to provide our customers with a fresh original designs starting with men's tees.  We plan to expand our operations in the coming months.</p>
	                    </div>
					</div>
					<div class="col-md-4">
						<div class="grid1 pull-left">
							<h2>Contact</h2>
					        <address>
					        	<p>Crutch Clothing</p>
					        	<p>San Francisco - Honolulu</p>
					        	<p><a href="#">info@crutchclothing.com</a></p>
					        </address>
	                    </div>
	                    <div class="grid2 pull-right">
							<div class="social-icons-set">
									<ul>
										<li><a class="facebook" href="#"> </a></li>
										<li><a class="twitter" href="#"> </a></li>
										<li><a class="vimeo" href="#"> </a></li>								
										<div class="clear"> </div>
									</ul>
								</div>
	                    </div>
					</div>
					<div class="clearfix"></div>
	</div>
</div>
</div>
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

