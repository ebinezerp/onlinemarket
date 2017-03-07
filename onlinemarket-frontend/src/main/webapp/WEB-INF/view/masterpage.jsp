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
			<c:if test="${fn:containsIgnoreCase(pageName, 'home')}">
				<%@include file="index.jsp"%>
			</c:if>
			<c:if test="${admin==true}">
				<%@include file="adminmenu.jsp"%>
				
				
					<%@include file="categorydivisions.jsp"%>
				
				
					<%@include file="adminproductdivisions.jsp"%>
				
			</c:if>

			<c:if test="${fn:containsIgnoreCase(pageName, 'aboutus')}">
				<%@include file="aboutus.jsp"%>

			</c:if>

			<c:if test="${fn:containsIgnoreCase(pageName, 'products')}">
				<%@include file="categorymenu.jsp"%>
				<c:if test="${table}">
					<%@include file="products.jsp"%>
				</c:if>
				<c:if test="${fn:containsIgnoreCase(pageName,'productpage')}">
					<%@include file="productpage.jsp"%>
				</c:if>
			</c:if>

			<c:if test="${fn:containsIgnoreCase(pageName, 'sucess')}">
				<%@include file="sucess.jsp"%>
			</c:if>
			<c:if test="${fn:containsIgnoreCase(pageName, 'newproductform')}">
				<%@include file="newproductform.jsp"%>
			</c:if>

		</div>

		<%@include file="footer.jsp"%>

	</div>
</body>
</html>