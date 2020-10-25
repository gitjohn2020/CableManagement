<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Channel</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/style.css">
<style>
	.error {color : red}
</style>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	
	<h3>Edit Channel</h3>
<p>Edit New Channel:</p>

<div class="container">
<form:form action="${pageContext.request.contextPath}/cbiz/editchannel" modelAttribute="channel">

    <label for="chname">Channel Name</label>
    <form:input id="chname" path="channelName" placeholder="Channel Name" />

    <label for="chType">Channel Type</label>
    <form:select id="chType" name="channelType" path="channelType">
     <form:option value="">--select a channel--</form:option>
    <form:option value="sports">Sports</form:option>
    <form:option value="news">News</form:option>
    <form:option value="cinema">Cinema</form:option>
     <form:option value="serial">Serial</form:option>
    </form:select>
    
     <label for="chLanguage">Channel Language</label>
    <form:select id="chLanguage" name="channelLanguage" path="channelLanguage">
     <form:option value="">--select a channel--</form:option>
    <form:option value="english">English</form:option>
    <form:option value="hindi">Hindi</form:option>
    <form:option value="bengali">Bengali</form:option>   
    </form:select>
    
    <label for="chPrice">Channel Price</label>
    <form:input id="chPrice" path="channelPrice" placeholder="channelPrice...." />
    
     <form:hidden path="id" />
    <input type="submit" value="Edit Channel">
  </form:form>
</div>
	
</body>
</html>