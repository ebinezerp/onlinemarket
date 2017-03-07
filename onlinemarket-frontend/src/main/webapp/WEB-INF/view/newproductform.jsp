
<div class="container-fluid">
	<div class="row">

		<div class="col-sm-2"></div>
		<div class="col-sm-8" id="newproductformform">
			<form:form action="addproduct" method="post" class="form" commandName="product">
				<div class="form-group">
					<label for="product-name">Product Name</label>
					<form:input path="productName" class="form-control" />
					<form:errors path="productName"></form:errors>
				</div>
				<div class="form-group">
					<label for="product-price">Product Price</label>
					<form:input path="productPrice" class="form-control" />
				</div>
				<div class="form-group">
					<label for="product-status">Product Status</label> <label
						class="radio-inline"><form:radiobutton path="status"
							value="true" />Available</label> <label class="radio-inline"><form:radiobutton
							path="status" value="false" />Out of Stock</label>
				</div>
				<div class="form-group">
					<label for="product-status">Product Description</label>
					<form:textarea path="productDespription" class="form-control" />
				</div>
				<center>
					<input type="submit" class="btn btn-primary">&nbsp;&nbsp;<input
						type="reset" class="btn btn-primary">
				</center>

			</form:form>


		</div>
		<div class="col-sm-2"></div>
	</div>




</div>