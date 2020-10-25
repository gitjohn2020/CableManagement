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
	
	<h3>New Plan</h3>
<p>Add New Plan:</p>

<div class="container">
<form:form action="${pageContext.request.contextPath}/cbiz/addplan" modelAttribute="plan">

    <label for="plname">Plan Name</label>
    <form:input id="plname" path="planName" placeholder="Plan Name" />
   
    
    <label for="chPrice">Plan Price</label>
    <form:input id="plPrice" path="planPrice" placeholder="Plan Price" />
    
  <div style="" id="dtl">
   <select name="channelId" multiple>
    <c:forEach items="${channels}" var="channel"> 
        <option value="${channel.id}">${channel.channelName}</option> 
    </c:forEach> 
  </select>   
  </div>
    
    <input type="submit" value="Add Plan">
  </form:form>
</div>
	
</body>
</html>