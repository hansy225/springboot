<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	welcome : Admin<br><br>
	
	USER ID : ${pageContext.request.userPrincipal.name}<br><br>
	
	<!-- userPrincipal : 기본적인 모든 정보들이 들어옴 --> 
	user info : ${pageContext.request.userPrincipal}<br><br>
	
	<a href="/logout">Log out</a>
</body>
</html>