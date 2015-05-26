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
<link rel="shortcut icon" href="/resources/images/crutch-favicon.ico">
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
        
        <br>

<!-- MAIN CONTAINER-->
<div class="container">
<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
					<div id="myCarousel" class="carousel slide">
						<ol class="carousel-indicators">
						  <li data-target="#myCarousel" data-slide-to="0" class=""></li>
						  <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
						</ol>
						<div class="carousel-inner">
						  <div class="item active">
							<img class="img-responsive"  src="/resources/images/crutch_big_front${product.id}.png" alt="post image">
						  </div>
						  <div class="item">
							<img class="img-responsive"  src="/resources/images/crutch_big_back${product.id}.png" alt="post image">
						  </div>
						</div>
						<a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="icon-prev"></span></a>
						<a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="icon-next"></span></a>
					</div>
					<hr>
					<ul id="myTab" class="nav nav-tabs">
						<li class="active"><a href="#home" data-toggle="tab">INFO &amp; CARE</a></li>
						<li class=""><a href="#profile" data-toggle="tab">DELIVERY</a></li>
						<li class=""><a href="#return" data-toggle="tab">RETURN</a></li>
					</ul>
					<div id="myTabContent" class="tab-content" style="margin-bottom:20px;">
						<div class="tab-pane fade active in" id="home">
						  <p>Only the highest quality material was used in the making of this shirt.  Machine wash on cold and tumble dry.  Shirt material is 100% cotton</p>
						</div>
						<div class="tab-pane fade" id="profile">
						  <p>All items are shipped via USPS Priority Mail unless specifically stated otherwise.  We can combine shipping and multi-order items, every three shirts must be sent in their own shipment.  Express Mail can be used at the buyers expense.</p>
						</div>
						<div class="tab-pane fade" id="return">
						  <p>If for are reason you are unsatisfied with your order please contact us immediately so we can resolve the issue.  Here at Crutch Clothing customer service is our number one priority.</p>
						</div>
					  </div>
	  
	  
			</div><!-- /.col-xs-12 col-sm-12 col-md-6 .carousel -->
			
			
			<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-12 col-lg-12">
						<h2>${product.name }</h2>
						<p class="lead text-danger"><strong>Price: $${product.price}</strong></p>
					
						
				

    
    <sec:authorize access="hasRole('ROLE_USER')">
		
			
			<form:form method="post" modelAttribute="productDetail" commandName="productDetail" action="add-to-cart">
       	     	 
       	     	 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
       	     	 <form:hidden path="size" id="size" name="size"/>
				 <input type="hidden" id="id" name="id" value="${product.id}"/>
				 
       	     	 <ul class="options list-unstyled">
					<h4 class="m_9">Select a Size</h4>
					<li><a href="#" onCLick="changeToSmall()">S</a></li>
					<li><a href="#" onClick="changeToMedium()">M</a></li> 
					<li><a href="#" onClick="changeToLarge()">L</a></li>
					<li><a href="#" onClick="changeToXLarge()">XL</a></li>		
					<div class="clearfix"></div>
					<form:errors path="size" cssStyle="color: #ff0000;"/>		
					<div class="clearfix"></div>
					
					
					<div class="clearfix"></div>	
					<h4 class="m_9">Select Quantity</h4>
					<form:input path="quantity" type="tel" name="quantity" id="quantity" value="1"/>
					<div class="clearfix"></div>
					<form:errors path="quantity" cssStyle="color: #ff0000;"/>
					
					<div class="clearfix"></div>
					<h4 class="m_9">Select Color</h4>
					<form:select path="color">
						<form:option value="default">--SELECT COLOR--</form:option>
               			<form:option value="black">BLACK</form:option>
               			<form:option value="white">WHITE</form:option>
            		</form:select>
					<!-- <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6" style="margin-bottom:10px;"> -->
					<div class="clearfix"></div>			
					<form:errors path="color" cssStyle="color: #ff0000;"/>
					<div class="clearfix"></div>
					
					
					<div class="clearfix"></div>
					<!--  
					<div class="btn_form">
						<input type="submit" value="Add To Cart" title="">
					</div>
					 -->
					<div class="clearfix"></div>
					<h4 class="m_9">Description</h4>
					<li>
						${product.description }
					</li>			
					
					<!-- </div>  -->
					
					<div class="clearfix"></div>
					
				  	<br>
				  	
				    <div>
				      <button class="btn btn-default btn-lg" type="submit" name="submit" value="submit">Adds To Cart!</button>
				    </div>
				 
              </ul>
			 </form:form>
			
			 
	</sec:authorize>
			 		<c:if test="${name == 'Anonymoususer'}">
						<p>Please <a href="login">login</a> or <a href="registration">register</a> to purchase product</p>
					</c:if>
					</div>
					<div class="col-xs-6 col-sm-6 col-md-12 col-lg-12">
						<!-- 
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<a class="btn btn-block btn-warning" href="#" title="" style="margin-bottom:10px;">ADD TO CART</a>
							</div>
							
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<a class="btn btn-block btn-default" href="#" title="" style="margin-bottom:10px;">SAVE FOR LATER</a>
							</div>
							 -->
							<hr>
						</div>
					</div>
				</div>
			</div>
			  
	</div>
</div> <!-- /container -->


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





    <!-- Le javascript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/jquery.js" type="text/javascript"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="js/bootstrap.min.js"></script>


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