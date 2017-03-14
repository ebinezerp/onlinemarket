
<div class="container-fluid">
<div class="row">

<div class="col-sm-2"></div>
<div class="col-sm-8">

<table class="table table-hover">
<tr>
<th>Product Name</th>
<th>Product Price</th>
<th>Product Quantity</th>
<th>Total</th>
<th></th>
</tr>
<c:set var="temp" value="${0}"/>
<c:forEach items="${cartItems}" var="cartItem">
<c:set var="temp" value="${temp+cartItem.grandTotal}"/>
<tr>
<td>${cartItem.product.productName}</td>
<td>${cartItem.product.productName}</td>
<td>${cartItem.quantity}</td>
<td>${cartItem.grandTotal}</td>
<td><a href='delete/${cartItem.id}/cartItem'><input type='button' value='Delete' class='btn btn-primary'></a></td>
</tr>




</c:forEach>
<tr><td colspan="2"><a href="cart/deleteall"><input type="button" value="Delete All" class="btn btn-danger"></a></td>
<td>Grand Total:${temp}</td>
</tr>
</table>
<div style="float:right"><a href="checkout"><input type="button" value="Check Out" class="btn btn-info"></a></div>


</div>
<div class="col-sm-2"></div>
</div>



</div>