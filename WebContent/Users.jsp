<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="Header.jsp" />
	<a href='<c:url value="UserAdd"/>' class="button">Add New</a>
<br/>
<br/>
<br/>
	<table>
		<tr>
			<th>Id</th>
			<th>Username</th>
			<th>Email</th>
			<th>User_group_id</th>
			<th>Actions</th>

		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.email}</td>
				<td>${user.user_group_id}</td>
				<td><a href='<c:url value="/UserDelete?id=${user.id}"/>'>DELETE</a></td>

				<td><a href='<c:url value="/UserUpdate?id=${user.id}"/>'>EDIT</a></td>

			</tr>
		</c:forEach>

	</table>
	<jsp:include page="Footer.jsp" />
</body>
</html>