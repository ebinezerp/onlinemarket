<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!---------------------------------- Tag library for directories -------------------- -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="page" value="${pageName}" />
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/assets/css" var="css" />
<spring:url value="/assets/js" var="js" />
<spring:url value="/assets/font" var="font" />
<spring:url value="/assets/style" var="style" />
<spring:url value="/assets/jquery" var="jquery" />
<spring:url value="/assets/images" var="images" />

<!-- ------------------------------------------------------------------------------ -->
<link rel="stylesheet" href="${css}/bootstrap.css" />
<link rel="stylesheet" href="${css}/bootstrap-theme.css" />


<link rel="stylesheet" href="${style}/style2.css" />

<!-- <link rel="stylesheet" href="${css}/dataTable.bootstrap.min.css" />-->

<script type="text/javascript" src="${jquery}/jquery.js"></script>
<script type="text/javascript" src="${js}/bootstrap.js"></script>
<script type="text/javascript" src="${jquery}/jquery.dataTables.js"></script>
<script type="text/javascript" src="${js}/dataTables.bootstrap.js"></script>
<!-- <script type="text/javascript" src="${js}/dataTables.bootstrap.min.js"></script>-->
<link rel="stylesheet" href="${css}/dataTables.bootstrap.css" />
<!-- <script type="text/javascript" src="${jquery}/jquery.dataTables.min.js"></script>-->

<script type="text/javascript" src="${js}/mainmenu.js"></script>


<script>
	$(document).ready(function() {
		var page = '${page}';

		$($("#" + page).parent()).css('background-color', '#3498DB');
		$($("#" + page).parent()).css('border-radius', '4px');
		$($("#" + page)).css('color', 'white');
		$($("#" + page)).css('font-weight', '700')
	});
</script>
<title>Insert title here</title>

</head>
<body>
	<div class="wrapper">
		<div class="header">
			<%@include file="../includes/header.jsp"%>
		</div>
		<div class="content">
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6">
				<form:form model="cart">
					<table class="table table-hover">
						<tr>
							<th>Product Name</th>
							<th>Product Price(INR)</th>
							<th>Product Quantity</th>
							<th>Total Price(INR)</th>
						</tr>
						<c:set var="temp" value="${0}"/>
						
						<c:forEach items="${cart.cartItems}" var="cartItem">
						<c:set var="temp" value="${temp+cartItem.grandTotal}"/>
							<tr>
								<td>${cartItem.product.productName}</td>
								<td>${cartItem.product.productPrice}</td>
								<td>${cartItem.quantity}</td>
								<td>${cartItem.grandTotal}</td>
							</tr>
					
					</c:forEach>
					<tr><td colspan="3"><td colspan="2">Grand Total:${temp}</td></tr>
					</table>
					<input type="submit" value="Conform" name="_eventId_conform">
					<input type="submit" value="Cancel" name="_eventId_cancel">
					</form:form>
				</div>
				<div class="col-sm-3"></div>
			</div>
			</div>
			<div>
				<%@include file="../includes/footer.jsp"%>


			</div>
			</div>
</body>
</html>