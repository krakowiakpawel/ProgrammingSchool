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
		<form action='SolutionAdd' method='POST'>
			<label> Id <input type='text' name='id' value='${Solution.id}'readonly> </label>
			<br /> 
			<br /> 
			<label> Description <input type='text'name='description' value='${Solution.description}'></label> 
			<label> Exercise 
				<select name='Exercise'>
					<c:forEach items="${exerciseList}" var="ex">
						<option value="${ex.id}"
						<c:if test="${ex.id==Solution.exercise_id}" >selected</c:if>
						>${ex.id}-${ex.title}</option>
					</c:forEach>
				</select>
			</label>
			<label> User 
				<select name='UserId'>
					<c:forEach items="${userList}" var="user">
						<option value="${user.id}" <c:if test="${user.id==Solution.user_id}" >selected</c:if>>${user.id}-${user.username}</option>
					</c:forEach>
				</select>
			</label>
			<br /> <input type='submit'> <input type="reset">
		</form>
		<jsp:include page="Footer.jsp" />
	</body>
</html>