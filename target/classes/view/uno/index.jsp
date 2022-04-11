<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/src/view/uno/resources/components.css" rel="stylesheet" />
<link href="/YeonCheon/src/view/uno/resources/components.css" rel="stylesheet" />
<link href="./resources/components.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<div class="inputArea">
		<h1>Uno's Page</h1>
		<form method="get" action="save">
			<h3>이름</h3>
			<input type="text" name="name" style="height: 50px; width: 150px;">
			</br> </br>
			<h3>내용</h3>
			<textarea name="contents" style="height: 200px; width: 400px;"></textarea>
			</br>
			<button type="submit">전송</button>
		</form>
		<form method="post" action="save">
			<h3>이름</h3>
			<input type="text" name="name" style="height: 50px; width: 150px;">
			</br> </br>
			<h3>내용</h3>
			<textarea name="contents" style="height: 200px; width: 400px;"></textarea>
			</br>
			<button type="submit">전송</button>
		</form>
	</div>
</body>
</html>