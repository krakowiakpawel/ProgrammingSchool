<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Exercise Update</title>
	</head>
	<body>
		<jsp:include page="Header.jsp" />
		<form action='ExerciseAdd' method='POST'>
			<label> Id <input type='text' name='id'  value='${Exercise.id}' readonly> </label>
			<br/>
			<label> Title <input type='text' name='title' value='${Exercise.title}'> </label> 
			<br/>
			<label> Description <input type='text'name='description' value='${Exercise.description}' > </label> 
			<br/> 
			<input type='submit'> <input type="reset">
		</form>
		<jsp:include page="Footer.jsp" />
	</body>
</html>