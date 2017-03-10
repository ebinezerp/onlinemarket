<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12">

			<nav class="navbar navbar-default" id="product">
				<div class="container-fluid">
					<div class="navbar-header">

						<a class="navbar-brand" href="#"><b>Category </b></a>


					</div>
					<ul class="nav navbar-nav">
						<c:forEach items="${category}" var="category">

							<li><a href="${contextPath}/${category.categoryName}">${category.categoryName}</a></li>





						</c:forEach>



					</ul>


				</div>


			</nav>




		</div>

	</div>

</div>
