<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/files/css/style.css" />
</head>
<body>
	<h4>Home Page : List of users in the project</h4>
	<hr />
	<table border="1" align="left">
		<tr>
			<th>User ID</th>
			<th>Name</th>
			<th>Email</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.userID} </td>
				<td>${user.name} </td>
				<td>${user.email} </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>













