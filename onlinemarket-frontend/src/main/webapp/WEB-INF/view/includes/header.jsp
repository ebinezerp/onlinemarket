<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="header">

	<div class="container-fluid">
		<div class="row" id="header">
			<div class="col-sm-12">
				<nav class="navbar navbar-inverse navbar-fixed-top navbar-colapse">
					<div class="container-fluid">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse" data-target="#mainnav">
								<span class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<a class="navbar-brand"><img src="${images}/logo/logo.png"
								style="height: 60px;"></a>

						</div>
						<div class="collapse navbar-collapse" id="mainnav">
							<ul class="nav navbar-nav navbar-right mainnav mainnav-items">
								<li><a href="${contextPath}/home" id="home">HOME</a></li>
								<li><a href="${contextPath}/aboutus" id="aboutus">ABOUT
										US</a></li>
								<li><a href="${contextPath}/products" id="products">PRODUCTS</a></li>
								<li><a href="${contextPath}/contactus" id="contactus">CONTACT US</a></li>
								<security:authorize access="isAuthenticated()">
								<security:authorize access="hasAuthority('CUSTOMER')">
								<li id="cart"><a href="customer/cart"><span style="border-radius:6px;color:white;background-color:blue;padding:8px;">${cartcount}</span><span class="glyphicon glyphicon-shopping-cart"></span>Cart</a></li>
								</security:authorize>
									<li id="logout"><a href="${contextPath}/perform_logout"><span class="glyphicon glyphicon-user"></span>Logout</a>
									</li>
								</security:authorize>
								<security:authorize access="isAnonymous()">
									<li id="logout"><a href="${contextPath}/login"><span class="glyphicon glypicon-log-in"></span>LOGIN</a>
									</li>
								</security:authorize>
							</ul>
						</div>

					</div>



				</nav>
			</div>
		</div>
	</div>

	<!-- ---------------------Category menu ----------------------------- -->

</div>


