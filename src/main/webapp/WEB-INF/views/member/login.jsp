<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MJHSOFT</title>
</head>
<body>
	<div id="login_form">
		<form action="./auth" method="post" id="form">
			<input type="text" name="id" id="id" placeholder="아이디">
			 <input
				type="password" name="pw" id="pw" placeholder="비밀번호">

		<button id="login">로그인</button>
		</form>
	</div>

</body>
</html>