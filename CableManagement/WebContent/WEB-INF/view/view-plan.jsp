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
    <th>Plan Name</th>
    <th>Plan Price</th> 
    <th>Detail</th>  
    <th>Edit</th>
    <th>Delete</th>
  </tr>
  <c:if test="${not empty plans}">
  	<c:forEach var="plan" items="${plans}">
	  <tr>
	    <td>${plan.planName}</td>
	    <td>${plan.planPrice}</td>
	    <td><input type="checkbox" onclick="detailShow(${plan.id});" value="click"/></td>
	   
	    <td><input class="editbtn" onclick="openEdit(${plan.id})" type="button" value="Edit"></td>
	    <td><input class="cancelbtn" onclick="openDelete(${plan.id})" type="button" value="Delete"></td>
	  </tr>
	  </c:forEach>
  </c:if>
  
</table>

    <div style="display:none;" id="dtl">
   <select name="roles" multiple>
    <c:forEach items="${channels}" var="channel">
        <option value="${channel.id}">${channel.channelName}</option>
    </c:forEach> 
  </select>   
  </div> 
   
</div>

<script>
	function detailShow(x)
	{
	 // alert(x);
	  dtl.style.display = "block";
	}
	
	function openEdit(plId) {
		document.getElementById("pl_id").value = plId;
		document.getElementById("openEditForm").submit();
	}
	
	function openDelete(plId) {
		document.getElementById("delete_pl_id").value = plId;
		document.getElementById("deleteForm").submit();
	}
</script>
<form:form id="openEditForm" action="${pageContext.request.contextPath}/cbiz/openeditplan" modelAttribute="plan">
	<form:hidden id="pl_id" path="id" />
</form:form>

<form:form id="deleteForm" action="${pageContext.request.contextPath}/cbiz/deleteplan" modelAttribute="plan">
	<form:hidden id="delete_pl_id" path="id" />
</form:form>

<form:form id="detailForm" action="${pageContext.request.contextPath}/cbiz/detailplan" modelAttribute="plan">

</form:form>
</body>
</html>