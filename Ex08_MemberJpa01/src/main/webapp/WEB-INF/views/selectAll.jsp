<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Select All</title>
</head>
<body>
	<h1>Member JPA #01 - Select All</h1>
	
	<c:forEach var="m" items="${ members }">
		���̵� : ${ m.id } <br>
		�̸� : ${ m.username } <br>
		��¥ : ${ m.createDate } <hr>
	</c:forEach>
	
</body>
</html>