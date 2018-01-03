<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add new User</title>
	</head>
	<body>
		<jsp:include page="Header.jsp" />
		<form action='ExerciseAdd' method='POST'>
			<label> Title <input type='text' name='title'></label>
			<br/> 
			<label> Description <input type='text' name='description'></label>
			<br/> 
			<input type='submit'> <input type="reset">
		</form>
		<jsp:include page="Footer.jsp" />
	</body>
</html>