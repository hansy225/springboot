<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	welcome : Member <br><br>
	
	<!-- 
	<c:if test="${ !empty pageContext.request.userPrincipal.name }">
		<p>LOG - IN
	</c:if>
	-->
	USER ID : ${ pageContext.request.userPrincipal.name } <br><br>
	
	<!-- userPrincipal : 기본적인 모든 정보들이 들어옴 -->
	user info : ${ pageContext.request.userPrincipal } <br><br>

	<a href="/logout">로그아웃</a>
	
</body>
</html>