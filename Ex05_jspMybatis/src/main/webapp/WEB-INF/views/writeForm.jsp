<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<br><br>
	<h1>�Խ��� �� �ۼ��ϱ�</h1>
	<form action="write" method="post">
		<table class="table">
			<tr>
				<th>�ۼ���</th>
				<td><input name="writer"></td>
			</tr>
			<tr>
				<th>����</th>
				<td><input name="title"></td>
			</tr>
			<tr>
				<th>����</th>
				<td><textarea cols="100" rows="5" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit" class="btn btn-outline-success">�۾���</button>
					<a href="list"><button type="button" class="btn btn-outline-primary">���</button></a>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>