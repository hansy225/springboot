<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="login_check" method="post">
		<c:if test="${ param.error != null }">
			<p>
				Login Error! :( <br>
				${ error_message }
			</p>
		</c:if>
		ID : <input name="username"> <br><br>
		PW : <input type="password" name="pwd"> <br><br>
		<input type="submit" value="LOGIN">
	</form>
	
</body>
</html>