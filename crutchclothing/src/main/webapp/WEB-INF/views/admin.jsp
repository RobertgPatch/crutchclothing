<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    	<script src="<c:url value="/resources/js/jquery-1.9.1.min.js" />"></script>

		<script src="<c:url value="/resources/" />"></script>
		
		<script src="<c:url value="/resources/js/jquery-migrate-1.0.0.min.js" />"></script>
		<script src="<c:url value="/resources/js/jquery-ui-1.10.0.custom.min.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.ui.touch-punch.js" />"></script>
		<script src="<c:url value="/resources/js/modernizr.js" />"></script>
		<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.cookie.js" />"></script>
		<script src="<c:url value="/resources/js/fullcalendar.min.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.dataTables.min.js" />"></script>
		<script src="<c:url value="/resources/js/excanvas.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.flot.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.flot.pie.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.flot.stack.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.flot.resize.min.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.chosen.min.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.uniform.min.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.cleditor.min.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.noty.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.elfinder.min.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.raty.min.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.iphone.toggle.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.uploadify-3.1.min.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.gritter.min.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.imagesloaded.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.masonry.min.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.knob.modified.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.sparkline.min.js" />"></script>
		<script src="<c:url value="/resources/js/counter.js" />"></script>
		<script src="<c:url value="/resources/js/retina.js" />"></script>
		<script src="<c:url value="/resources/js/custom.js" />"></script>
		



    
    </script>
	<!--end slider -->
	
	

        <title>Applying jQuery DataTables plugin in the Java Server application</title>

<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css" />
 <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>


<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
<script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>


<!-- 
<link rel="stylesheet" type="text/css" href="/resources/css/jquery.dataTables.css">
<script type="text/javascript"src="<c:url value="resources/js/jquery.dataTables.js"/>"></script>
<script type="text/javascript"src="<c:url value="resources/js/jquery.dataTables.min.js"/>"></script> 
<script type="text/javascript"src="<c:url value="resources/js/jquery.jeditable.js"/>"></script> 
 -->
        <script type="text/javascript">
       // $(document).ready(function() {
       // $('#users').dataTable({
          //  'bPaginate': true,
           // 'sAjaxSource': './UserDataServlet',
           // 'iDisplayLength': 5,
           // 'bSort' : false,
           // 'aoColumns' : [{'mData' : 'username'},
                           //{ 'mData': 'firstName' },
                           //{ 'mData': 'middleInit' },
                           //{ 'mData': 'lastName' },
                           //{ 'mData': 'phoneNumber' },
                          //{ 'mData': 'address1' },
                           //{ 'mData': 'city' },
                           //{ 'mData': 'state' },
                           //{ 'mData': 'email' }]

             //});
        
       // });
        
        
        
        </script>
        
        <script type="text/javascript">
       
        $(document).ready( function () {
            $('#userinfo').dataTable( {
                "bJQueryUI": true,
                "sPaginationType": "full_numbers",
                "bProcessing": true,
                "sAjaxSource": 'dtables/users.json',
                "aoColumnDefs": [
                                 { "bVisible": false,  "aTargets": [ 1 ] },
                                 {
                                   "fnRender": function ( oObj,sVal ) {
                                     return '<a href="usradm/fetch?' + sVal + '">edit</a>';
                                   },
                                   "bUseRendered": false,
                                   "aTargets": [ 3 ]
                                 }
                               ]        
            } );

        } );
        
        

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
        
        
        
        
        
        <script type="text/javascript">
        //$(document).ready(function() { 
            //$('.jqueryDataTable').dataTable( { 
              //  'bProcessing': false, 
                //'bServerSide': false, 
                //'sAjaxSource': './UserDataServlet', 
                //'bJQueryUI': true, 
                //'aoColumns': [ 
                  //  { 'mData': 'username' }, 
                    //{ 'mData': 'firstName' },
                    //{ 'mData': 'middleInit' },
                    //{ 'mData': 'lastName' },
                   // { 'mData': 'phoneNumber' },
                   // { 'mData': 'address1' },
                    //{ 'mData': 'city' },
                    //{ 'mData': 'state' },
                    //{ 'mData': 'email' }
                //] 
           // } );  
        //} ); 

        //$(document).ready(function () {
          //  $('users').dataTable({
            //    "bServerSide": true,
              //  "bProcessing": true,
                //"sAjaxSource" : "admin/users",
                //"sPaginationType": "full_numbers",
                //"bJQueryUI": true
           // });
        //});
        
        </script>
    </head>
<body>


	
<!----start-container----->
		<div class="header-bg">
			<div class="container">
			
			<c:if test="${name != 'Anonymoususer'}">
				<ul class="list-inline pull-right">
		 			<li><span class="text-right" style="color: gray">Welcome back : ${name} | </span><a href="javascript:formSubmit()"> Logout</a></li>
		 			<li><a href="account">Account</a></li>
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
									<c:if test="${cartQuan == 0}" >
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

	<c:url value="/logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	
	
	
	
	<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white user"></i><span class="break"></span>Members</h2>
						<div class="box-icon">
							<a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr>
								  <th>Username</th>
								  <th>Date registered</th>
								  <th>Role</th>
								  <th>Status</th>
								  <th>Actions</th>
							  </tr>
						  </thead>   
						  <tbody>
						  <c:forEach var="member" items="${users}">
							<tr>
								<td class="center">${member.username}</td>
								<td class="center">${member.memberSince}</td>
								<td class="center">${member.topRole}</td>
								<td class="center">
									<span class="label label-success">Active</span>
								</td>
								<td class="center">
								
									<a href="admin/delete-user/${member.username}" ><span style="color:red" class="glyphicon glyphicon-trash" /></a>
									
								</td>
							</tr>
							</c:forEach>
						  </tbody>
					  </table>            
					</div>
				</div><!--/span-->
			
			</div><!--/row-->
	
	
	
	
	<!--  
	 <div id="table-container">
	 <table cellpadding="0" cellspacing="0" border="1" class="display" id="userinfo">
        <thead>
            <tr>
                <th>Username</th>
                <th>First Name</th>
                <th>Middle Initial</th>
                <th>Last Name</th>
                <th>Phone Number</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
   
        </tbody>     
   			<button id="btnDeleteRow">Delete selected company</button>      
        </table>
         </div>
		-->

         
         

</body>
 <!-- script references -->
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
			<p>&#169Copyright 2014 All Rights Reserved  Crutch Clothing<a href="welcome">  crutchclothing.com</a></p>	
		</div>
	</div>
</div>
    
    
</html>
    