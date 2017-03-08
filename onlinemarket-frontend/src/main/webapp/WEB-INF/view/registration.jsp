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

		<%@include file="header.jsp"%>
		<div class="content">
			<div class="container-fluid">

				<div class="row">
					<div class="col-sm-4"></div>
					<div class="col-sm-4">

						<form:form method="post" commandName="user" modelAttribute="users">
							<div class="form-group">
								<label for="userName">User Name</label>
								<form:input path="userName" class="form-control" />
								<form:errors path="userName"></form:errors>
							</div>
							<div class="form-group">
								<label for="email">Email</label>
								<form:input path="email" class="form-control" />
								<form:errors path="email"></form:errors>
							</div>
							<div class="form-group">
								<label for="email">Mobile</label>
								<form:input path="mobile" class="form-control" />
								<form:errors path="mobile"></form:errors>
							</div>
							<div class="form-group">
								<label for="password">Password</label>
								<form:password path="password" class="form-control" />
								<form:errors path="password"></form:errors>
							</div>
							<div class="form-group">

								<form:hidden path="role" value="CUSTOMER" hidden='true'
									class="form-control" />
							</div>
							<div class="form-group">

								<form:hidden path="is_Active" value="true" hidden="true"
									class="form-control" />
							</div>
							<input type="submit" name="_eventId_submit"
								class="btn btn-primary" value="SUBMIT">&nbsp;&nbsp;<input type="submit" name="_eventId_cancel" value="CANCEL" class="btn btn-primary"/>


						</form:form>



					</div>
					<div class="col-sm-4"></div>
				</div>

			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>