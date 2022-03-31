<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Uno's Page</h1>
	/YeonCheon/DB/page
	<form method="get" action="save">
		<h3>이름</h3>
		<input type="text" name="name" style="height: 50px; width: 150px;">
		</br> </br>
		<h3>내용</h3>
		<textarea name="contents" style="height: 200px; width: 400px;"></textarea>
		</br>
		<button type="submit">전송</button>
	</form>
</body>
</html>