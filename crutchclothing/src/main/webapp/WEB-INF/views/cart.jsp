<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@page session="false"%>
<%@taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<title>Crutch Clothing - Shopping Cart</title>
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
	
	.buttonlink {
    background:none!important;
     border:none; 
     padding:0!important;
    /*border is optional*/
     border-bottom:1px solid #444; 
     cursor: pointer;
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
		</script>

		<!----start-container----->
		<div class="header-bg">
			<div class="container">
			
			<c:if test="${name != 'Anonymoususer'}">
				<ul class="list-inline pull-right">
		 			<li><span class="text-right" style="color: gray">Welcome back : ${name}  |  </span><a href="javascript:formSubmit()"> Logout</a></li>
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
									<c:if test="${cartQuan > 0 }" >
										<li class="a text-left"><a href="cart"><span class="glyphicon glyphicon-shopping-cart"></span></a>${cartQuan}</li>
									</c:if>
									<c:if test="${cartQuan == 0 }" >
										<li class="a text-left"><a href="cart"><span class="glyphicon glyphicon-shopping-cart"></span></a></li>
									</c:if>
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
<div class="panel panel-default">
	<div class="panel-heading">
		<h3>Shopping Cart</h3>
	</div>
	
		<div class="panel-body">
			<div class="row">
				<div class="col-12 col-lg-12">
						<table class="table table-striped">
							<thead>
							  <tr>
								<th>Item</th>
								<th>Qty</th>
								<th></th>
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
								<form method="post" action="updatecart">
									<td><input style="width: 50%" "type="number" value=${totalQuan} name="newQuantity" id="finalq" /></td>
									<input type="hidden" name="prodDetailId" value=${cartRef.productDetail.id} />
									<input type="hidden" name="cartProductId" value=${cartRef.cartProduct.cartProductId } />
									<td><button class="buttonlink" type="submit" name="updateQ">update</button></td>
									<!-- <input type="hidden" name="currQuantity" value=${totalQuan} />  -->
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								</form>
								
								<td>${cartRef.productDetail.size}</td>
								<td>${cartRef.productDetail.color}</td>
								<td>$${cartRef.productDetail.product.price}</td>
								<c:set var="eachTotal" value="${totalQuan * cartRef.productDetail.product.price}"></c:set>
								<td><fmt:formatNumber value="${eachTotal}" type="currency" maxFractionDigits="2"/></td>
							  </tr>
							  </c:forEach>
							</c:forEach>
							<div><span class="glyphicons glyphicons-remove-2"></span></div>
							</tbody>
					  </table>
					  <hr>
						<dl class="dl-horizontal pull-right">
						  <fmt:setLocale value="en_US"/>
						  <c:set var="sub_total" value="0"></c:set>
						  <c:if test="${subtotal > 0 }" >
						  <c:set var="sub_total" value="${subtotal}" ></c:set>
						  </c:if>
						  <dt>Sub-total:</dt>
						  <dd><fmt:formatNumber value="${subtotal}" type="currency"/></dd>
						  <dt>Shipping Cost:</dt>
						  <c:set var="shipping" value="0" ></c:set>
						  <c:if test="${subtotal > 0 }" >
						  <c:set var="shipping" value="8" ></c:set>
						  </c:if>
						  <dd><fmt:formatNumber value="${shipping}" type="currency"/></dd>
						  <dt>Total:</dt>
						  <c:set var="grandtotal" value="${subtotal + shipping }" ></c:set>
						  <dd><fmt:formatNumber value="${grandtotal}" type="currency" maxFractionDigits="2"/></dd>
						</dl>
						<div class="clearfix"></div>
						
				</div>
			</div>
		</div>
		<div class="panel-footer">
			<div class="row">
				<div class="col-lg-12">
					<form action="checkout">
					 <button type="submit" class="btn btn-success pull-right"><i class="icon-ok-sign"></i> Proceed to checkout</button>
					</form>
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
<script src="/resources/assets/js/bootstrap.min.js"></script>


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