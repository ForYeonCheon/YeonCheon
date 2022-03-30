<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.js"></script>
<html>
<head>
<meta charset="UTF-8">
<title>환영합니다.</title>
</head>
<body>
	<form action="main/checkUser.jsp" method="get">
		<div style="left: 40%; top: 5%; position: relative;">
			<h1>Hello world!!</h1>
			<h5>this server is uno's private server</h5>
			<input type="text" name='name' id='inputText' style='height: 40px; width: 200px; font-size: 25px; color: #d30101'>
<!-- 			<button id='bntNext'>이동(고장)</button> -->
						<button type="submit" >이동(고장)</button>
			</br>
			<a href='/cmh/index.jsp' style='font-size: 25px'>최민호</a>
			</br>
			<a href='/kjm/index.jsp' style='font-size: 25px'>김종민</a>
			</br>
			<a href='/hhj/index.jsp' style='font-size: 25px'>한형진</a>
			</br>
			<a href='/uno/index.jsp' style='font-size: 25px'>김은호</a>
			</br>
		</div>
	</form>
</body>
</html>
<script>
	document.getElementById('bntNext').addEventListener(
			'click',
			function() {
				$.ajax({
					type : "GET",
					url : "main/checkUser.jsp?name="
							+ document.getElementById('inputText').value,
					dataType : 'JSON',
					async : false,
					contentType : 'application/json; charset=utf-8',
					success : function(data) {
						alert('통신성공!!');
					},
					error : function() {
						alert('통신실패!!');
					}
				});
			});
</script>