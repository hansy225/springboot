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
	
	<a href="insert?username=user3">������ �߰�</a> <br><br>
	<a href="select?id=1">�� ��ȸ</a> <br><br>
	<a href="selectAll">��ü ��ȸ</a> <br><br>
	<a href="delete?id=1003">������ ����</a> <br><br>
	<a href="update?id=1&username='������'">������ ����</a> <br><br>
	
</body>
</html>