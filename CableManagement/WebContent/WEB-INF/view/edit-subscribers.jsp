<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Subscriber</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/style.css">
<style>
	.error {color : red}
</style>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	
	<h3>Edit Subscriber</h3>
<p>Edit New Subscriber:</p>

<div class="container">
<form:form action="${pageContext.request.contextPath}/cbiz/editsubscriber" modelAttribute="subscriber">

    <label for="fname">First Name</label>
    <form:input  id="fname" path="firstName" placeholder="First Name" />

    <label for="lname">Last Name</label>
    <form:input type="text" id="lname" path="lastName" placeholder="Last Name.." />
    
    <label for="email">Email</label>
    <form:input id="email" path="email" placeholder="Your Email..." />
    
    <%-- <label for="password">Password</label>
    <form:password id="password" path="password" placeholder="Your Password...." /> --%>

	<label>Subscriber Status</label>
	<form:radiobutton path="active" value="1"/>Active
	<form:radiobutton path="active" value="0"/>Inactive
	
	<form:select path= "userType">
		<form:option value="User Type">---------------------------------Select User Type-----------------------------</form:option>
		<form:options items="${userTypes}" />
	</form:select>
	
    <form:hidden path="id" />
    <input type="submit" value="Edit Subscriber">
  </form:form>
</div>
	
</body>
</html>