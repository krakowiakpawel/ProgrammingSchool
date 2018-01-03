<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Load User</title>
	</head>
	<body>
		<table>
				<tr>
					<th>Id</th>
					<th>Title</th>
					<th>Description</th>
				</tr>
			<c:forEach items="${ExerciseList}" var="exercise">
				<tr>
					<td>${exercise.id}</td>
					<td>${exercise.title}</td>
					<td>${exercise.description}</td>
					<td><a href='<c:url value="/ExerciseDelete?id=${exercise.id}"/>'>DELETE</a></td>
					<td><a href='<c:url value="/ExerciseUpdate?id=${exercise.id}"/>'>EDIT</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>