<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:include page="Header.jsp" />
		<a href='<c:url value="SolutionAdd"/>' class="button">Add New</a>
		<table>
				<tr>
					<th>Id</th>
					<th>created</th>
					<th>updated</th>
					<th>description</th>
					<th>exercise_id</th>
					<th>user_id</th>
					<th>Actions</th>
				</tr>
			<c:forEach items="${solList}" var="sol">
				<tr>
					<td>${sol.id}</td>
					<td>${sol.created}</td>
					<td>${sol.updated}</td>
					<td>${sol.description}</td>
					<td>${sol.exercise_id}</td>
					<td>${sol.user_id}</td>
					<td><a href='<c:url value="/SolutionDelete?id=${sol.id}"/>'>DELETE</a></td>
					<td><a href='<c:url value="/SolutionUpdate?id=${sol.id}"/>'>EDIT</a></td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="Footer.jsp" />
	</body>
</html>