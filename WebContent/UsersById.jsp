<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
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
		<h2>${groupName} Members</h2>
		<jsp:include page="UsersLoad.jsp" />
		<br>
		<a href='<c:url value="Groups"/>' class="button">Back to Groups</a>
		<jsp:include page="Footer.jsp" />
	</body>
</html>