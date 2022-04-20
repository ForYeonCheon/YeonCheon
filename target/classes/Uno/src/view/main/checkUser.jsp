<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8" charset="UTF-8">
<title>환영합니다.</title>
</head>
<!-- 	<h1>유저체크하는곳</h1> -->
<body>
	<%
	String name = request.getParameter("name");
	String str1 = "<h2>이름 : " + name + "</h2>";
	%>
	<%=str1%>
</body>
</html>