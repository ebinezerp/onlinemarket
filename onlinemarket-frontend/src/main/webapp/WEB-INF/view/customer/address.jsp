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
			<form:form class="form" modelAttribute="useraddress" commandName="useraddress" method="post" >
			<h1>User Address</h1>
			<div class="form-group">
		      <form:label path="houseNo">House No</form:label>
			<form:input path="houseNo" class="form-control address" readonly="true" id="houseNo" />
			</div>
			<div class="form-group">
		      <form:label path="street">Street</form:label>
			<form:input path="street" class="form-control address" readonly="true" id="street" />
			</div>
			<div class="form-group">
		      <form:label path="city">City</form:label>
			<form:input path="city" class="form-control address" readonly="true" id="city" />
			</div>
			<div class="form-group">
		      <form:label path="state">State</form:label>
			<form:input path="state" class="form-control address" readonly="true" id="state" />
			</div>
			<div class="form-group">
		      <form:label path="country">Country</form:label>
			<form:input path="country" class="form-control address" readonly="true" id="country" />
			</div>
			<div class="form-group">
		      <form:label path="pin">PIN</form:label>
			<form:input path="pin" class="form-control address" readonly="true" id="pin" />
			</div>
			<input type="submit" name="_eventId_conform" value="Confrom" id="conform" class="btn btn-primary">
			<input type="submit" name="_eventId_cancel" value="Cancel" id="cancel" class="btn btn-danger">
			<input type="submit" value="Update" name="_eventId_update" id="update" class="btn btn-primary" style="display:none">
			<input type="button" value="Edit" id="edit" class="btn btn-info">
			
			</form:form>
			
			
			</div>
			</div>
			</div>
			</div>
			<script>
			$(document).ready(function(){
				
				$("#edit").click(function(){
					$(".address").each(function(){
						
						$(this).prop('readonly',false);
						
					});
					$("#edit").css('display','none');
					$("#update").css('display','block');
					$("#conform").css('display','none');
					
					
				});
				
				
				
			});
			
			
			</script>
			</body>
			</html>