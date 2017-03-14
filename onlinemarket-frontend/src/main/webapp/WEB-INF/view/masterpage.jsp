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
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
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
<c:set var="cart" value="${sessionScope.cart}"/>
	<div class="wrapper">
	<div class="header">
       <%@include file="includes/header.jsp" %>
       </div>
       <div class="content">
       <c:if test="${order==true}">
           <div class="alert alert-success alert-dismissable">
       <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Order placed successfully!!</strong>
</div>
       
       
       </c:if>
       
       
       <c:if test="${success==true}">
      
       <div class="alert alert-success alert-dismissable">
       <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Successfully SignedUp!!</strong>Please <a href="login">LogIn here.</a>
</div>
       
       </c:if>
       <c:if test="${home==true}">
        <%@include file="index.jsp" %>
        </c:if>
        
        <c:if test="${cartdetails==true}">
        <%@include file="customer/cartitems.jsp" %>
        </c:if>
        <c:if test="${aboutus==true}">
        <%@include file="aboutus.jsp" %>
        </c:if>
          <c:if test="${products==true}">
        <%@include file="products.jsp" %>
        </c:if>
          <c:if test="${contactus==true}">
        <%@include file="contactus.jsp" %>
        </c:if>
        <c:if test="${login==true}">
        <%@include file="loginpage.jsp" %>
        </c:if>
           <c:if test="${productPage==true}">
        <%@include file="productpage.jsp" %>
        </c:if>
       
        <c:if test="${admin==true}">
        <%@include file="admin/adminmenu.jsp" %>
        
        
        <%@include file="admin/adminproductdivisions.jsp" %>
        <%@include file="admin/categorydivisions.jsp" %>
       
        </c:if>
        </div>
        		<div class="footer">

		<%@include file="includes/footer.jsp"%>
		</div>

	</div>
</body>
</html>