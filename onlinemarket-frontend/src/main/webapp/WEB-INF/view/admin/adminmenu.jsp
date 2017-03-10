<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12">

			<nav class="navbar navbar-default" id="product">
				<div class="container-fluid">
					<div class="navbar-header">

						<a class="navbar-brand" href="#"><b>Category </b></a>


					</div>
					<ul class="nav navbar-nav">
					<li><a href="${contextPath}/admin/category">Category</a></li>
					<li><a href="${contextPath}/admin/product">Product</a></li>
					
					</ul>


				</div>


			</nav>




		</div>

	</div>

</div>
<c:if test="${categories==true}">
<%@include file="categories.jsp" %>

</c:if>
<c:if test="${adminproducts==true}">
<%@include file="adminproducts.jsp" %>

</c:if>