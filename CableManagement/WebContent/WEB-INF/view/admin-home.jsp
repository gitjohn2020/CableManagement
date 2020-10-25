<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Form</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/style.css">
<style>
	.error {color : red}
</style>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

<div class="overflowDiv">
<table id="viewTable">
  <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
    <th>Activated On</th>
    <th>Deactivated On</th>
    <th>Status</th>
    <th>User Type</th>
    <th>Edit</th>
    <th>Delete</th>
  </tr>
  <c:if test="${not empty subscribers}">
  	<c:forEach var="subscriber" items="${subscribers}">
	  <tr>
	    <td>${subscriber.firstName}</td>
	    <td>${subscriber.lastName}</td>
	    <td>${subscriber.email}</td>
	    <td>${subscriber.activatedOn}</td>
	    <td>${subscriber.deactivatedOn}</td>
	    <td>
	    	<c:if test="${subscriber.active == true}">
	    		<font color='green' style="font-weight:bold">Active</font>
	    	</c:if>
	    	<c:if test="${not subscriber.active}">
	    		<font color='red' style="font-weight:bold">Inactive</font>
	    	</c:if>
	    </td>
	    <td>${subscriber.userType }</td>
	    <td><input class="editbtn" onclick="openEdit(${subscriber.id})" type="button" value="Edit"></td>
	    <td><input class="cancelbtn" onclick="openDelete(${subscriber.id})" type="button" value="Delete"></td>
	  </tr>
	  </c:forEach>
  </c:if>
  
</table>
</div>
<script>
	function openEdit(subId) {
		document.getElementById("sub_id").value = subId;
		document.getElementById("openEditForm").submit();
	}
	
	function openDelete(subId) {
		document.getElementById("delete_sub_id").value = subId;
		document.getElementById("deleteForm").submit();
	}
</script>	
<form:form id="openEditForm" action="${pageContext.request.contextPath}/cbiz/openeditsubscriber" modelAttribute="subscriber">
	<form:hidden id="sub_id" path="id" />
</form:form>

<form:form id="deleteForm" action="${pageContext.request.contextPath}/cbiz/deletesubscriber" modelAttribute="subscriber">
	<form:hidden id="delete_sub_id" path="id" />
</form:form>

</body>
</html>