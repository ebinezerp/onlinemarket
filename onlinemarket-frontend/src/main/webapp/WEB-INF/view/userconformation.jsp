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

		<%@include file="includes/header.jsp" %>
		<div class="content">
			<div class="container-fluid">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
<h3 style="color:#D35A40;">Conform Details</h3>
					<form:form modelAttribute="registerModel">
						<div class="form-group">
							<label for="userName">UserName</label>
							<form:input path="users.userName" class="form-control" readonly="true" />
						</div>
						<div class="form-group">
							<label for="email">Email</label>
							<form:input path="users.email" class="form-control" readonly="true" />
						</div>
						<div class="form-group">
							<label for="mobile">Mobile</label>
							<form:input path="users.mobile" class="form-control" readonly="true" />
						</div>
						<div>User Address</div>
						<div class="form-group">
							<label for="houseNo">House Number</label>
							<form:input path="userAddress.houseNo" class="form-control" readonly="true"/>
						</div>
						<div class="form-group">
							<label for="street">Street</label>
							<form:input path="userAddress.street" class="form-control" readonly="true" />
						</div>
						<div class="form-group">
							<label for="city">City</label>
							<form:input path="userAddress.city" class="form-control" readonly="true"/>
						</div>
						<div class="form-group">
							<label for="state">State</label>
							<form:input path="userAddress.state" class="form-control" readonly="true" />
						</div>
						<div class="form-group">
							<label for="country">Country</label>
							<form:input path="userAddress.country" class="form-control" readonly="true" />
						</div>
						<div class="form-group">
							<label for="pin">PIN</label>
							<form:input path="userAddress.pin" class="form-control"  readonly="true"/>
						</div>
						
						<div>Billing Address</div>
						<div class="form-group">
							<label for="houseNo">House Number</label>
							<form:input path="billingAddress.houseNo" class="form-control" readonly="true" />
						</div>
						<div class="form-group">
							<label for="street">Street</label>
							<form:input path="billingAddress.street" class="form-control" readonly="true"/>
						</div>
						<div class="form-group">
							<label for="city">City</label>
							<form:input path="billingAddress.city" class="form-control" readonly="true" />
						</div>
						<div class="form-group">
							<label for="state">State</label>
							<form:input path="billingAddress.state" class="form-control" readonly="true" />
						</div>
						<div class="form-group">
							<label for="country">Country</label>
							<form:input path="billingAddress.country" class="form-control" readonly="true"  />
						</div>
						<div class="form-group">
							<label for="pin">PIN</label>
							<form:input path="billingAddress.pin" class="form-control" readonly="true"/>
						</div>
						<center><input name="_eventId_edit" type="submit" value="Edit" class="btn btn-info"/>
						<input name="_eventId_submit" type="submit"
							value="Confirm Details" class="btn btn-primary" />
							<input name="_eventId_cancel" type="submit"
							value="Cancel" class="btn btn-danger" /></center>
						<br />
					</form:form>




				</div>
				<div class="col-sm-4"></div>


			</div>





		</div>
		<%@include file="includes/footer.jsp" %>
	</div>
</body>
</html>