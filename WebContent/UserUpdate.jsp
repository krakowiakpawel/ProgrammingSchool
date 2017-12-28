<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="Header.jsp" />
	<form action='UserAdd' method='POST'>
		<label> UserName <input type='text' name='id'
			value='${user.id}' readonly>
		</label> <br /> <label> UserName <input type='text' name='UserName'
			value='${user.username}'>
		</label> <br /> <label> Email <input type="email" name='Email'
			value='${user.email}'>
		</label> <br /> <label> Group <select name='Group'>
				<c:forEach items="${groupList}" var="gr">

					<option value="${gr.id}"
						<c:if test="${userGroup==gr.id}">selected</c:if>>${gr.id}
						- ${gr.name}</option>

				</c:forEach>


		</select>

		</label> <br /> <input type='submit'> <input type="reset">

	</form>

	<jsp:include page="Footer.jsp" />



</body>
</html>