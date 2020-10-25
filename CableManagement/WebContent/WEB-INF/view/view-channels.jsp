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
    <th>Channel Name</th>
    <th>Channel Type</th>
    <th>Channel Language</th>
    <th>Channel Price</th>   
    <th>Edit</th>
    <th>Delete</th>
  </tr>
  <c:if test="${not empty channels}">
  	<c:forEach var="channel" items="${channels}">
	  <tr>
	    <td>${channel.channelName}</td>
	    <td>${channel.channelType}</td>
	    <td>${channel.channelLanguage}</td>
	    <td>${channel.channelPrice}</td>	  
	   
	    
	    <td><input class="editbtn" onclick="openEdit(${channel.id})" type="button" value="Edit"></td>
	    <td><input class="cancelbtn" onclick="openDelete(${channel.id})" type="button" value="Delete"></td>
	  </tr>
	  </c:forEach>
  </c:if>
  
</table>
</div>
<script>
	function openEdit(chId) {
		//alert(chId);
		document.getElementById("ch_id").value = chId;
		document.getElementById("openEditForm").submit();
	}
	
	function openDelete(chId) {
		document.getElementById("delete_ch_id").value = chId;
		document.getElementById("deleteForm").submit();
	}
</script>	
<form:form id="openEditForm" action="${pageContext.request.contextPath}/cbiz/openeditchannel" modelAttribute="channel">
	<form:hidden id="ch_id" path="id" />
</form:form>

<form:form id="deleteForm" action="${pageContext.request.contextPath}/cbiz/deletechannel" modelAttribute="channel">
	<form:hidden id="delete_ch_id" path="id" />
</form:form>

</body>
</html>