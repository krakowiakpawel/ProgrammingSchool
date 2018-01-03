<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Groups</title>
	</head>
	<body>
		<jsp:include page="Header.jsp" />
		<a href='<c:url value="GroupAdd"/>' class="button">Add New</a>
		<br/>
		<br/>
		<br/>
			<table>
					<tr>
						<th>Id</th>
						<th>Username</th>
						<th>Members</th>
						<th>Actions</th>
					</tr>
				<c:forEach items="${groupList}" var="group">
					<tr>
						<td>${group.id}</td>
						<td>${group.name}</td>
						<td><a href='<c:url value="/UsersBy?id=${group.id}"/>'>${group.number}</a></td>
						<td><a href='<c:url value="/GroupDelete?id=${group.id}"/>'>DELETE</a></td>
						<td><a href='<c:url value="/GroupUpdate?id=${group.id}"/>'>EDIT</a></td>
					</tr>
				</c:forEach>
			</table>
		<jsp:include page="Footer.jsp" />
	</body>
</html>