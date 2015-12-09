<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<!-- all javascript and css imports -->
<jsp:include
	page="/resources/crutch_resources/includes/imports/javascript-css-imports.jsp"></jsp:include>


<body>
<!-- header, logo with cart amount -->
	<jsp:include
		page="/resources/crutch_resources/includes/header/header.jsp"></jsp:include>


	<!-- start of main content -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<!----start-images-slider---->
				<div class="images-sliderx">
					<div id="fwslider">
						<div class="slider_container">
							<div class="slide">
								<img src="/resources/images/thecity.png" alt="" />
								<div class="slide_content">
									<div class="slide_content_wrap">
										<p class="description">New Arrivals</p>
										<h4 class="title">
											<a href="products">Men's Tops</a>
										</h4>
										<p class="description">
											<a href="products">Men's Tops</a>
										</p>
										<div class="slide-btns description"></div>
									</div>
								</div>
							</div>
							<div class="slide">
								<img src="/resources/images/sf-port.jpg" alt="" />
								<div class="slide_content">
									<div class="slide_content_wrap">
										<p class="description">New Arrivals</p>
										<h4 class="title">
											<a href="products">Men's Tops</a>
										</h4>
										<p class="description">
											<a href="products">Men's Tops</a>
										</p>
										<div class="slide-btns description"></div>
									</div>
								</div>
							</div>
							<!--/slide -->
						</div>
						<div class="timers"></div>
						<div class="slidePrev">
							<span> </span>
						</div>
						<div class="slideNext">
							<span> </span>
						</div>
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
						<p>Crutch Clothing is a Bay-Area and Hawaii inspired clothing
							company based out of San Francisco. We will launch with a two
							limited edition men's tees. As always we strive in delivering
							quality products and outstanding customer service to our clients.</p>
					</div>
				</div>
				<div class="col-md-4">
					<div class="grid">
						<h2>Our Mission</h2>
						<p>Our mission is to take our ideas and bring them to life, we
							hope to provide our customers with a fresh original designs
							starting with men's tees. We plan to expand our operations in the
							coming months.</p>
					</div>
				</div>
				<div class="col-md-4">
					<div class="grid1 pull-left">
						<h2>Contact</h2>
						<address>
							<p>Crutch Clothing</p>
							<p>San Francisco - Honolulu</p>
							<p>
								<a href="#">info@crutchclothing.com</a>
							</p>
						</address>
					</div>
					<div class="grid2 pull-right">
						<div class="social-icons-set">
							<ul>
								<li><a class="facebook" href="#"> </a></li>
								<li><a class="twitter" href="#"> </a></li>
								<li><a class="vimeo" href="#"> </a></li>
								<div class="clear"></div>
							</ul>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>

	<jsp:include page="/resources/crutch_resources/includes/footer/footer.jsp"></jsp:include>

</body>
</html>

