<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Menu</title>
<style type="text/css">
	a {
		text-decoration: none;
		color: black;
		cursor: pointer;
	}
</style>
</head>
<body>
	<h1>Member JPA #01</h1>
	
	<a href="insert?username=user3">데이터 추가</a> <br><br>
	<a href="select?id=1">상세 조회</a> <br><br>
	<a href="selectAll">전체 조회</a> <br><br>
	<a href="delete?id=1003">데이터 삭제</a> <br><br>
	<a href="update?id=1&username='더조은'">데이터 수정</a> <br><br>
	
</body>
</html>