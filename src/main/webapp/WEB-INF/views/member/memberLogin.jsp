<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
	<div id="login_form">
		<form action="./memberLogin" method="post" id="form">
			<input type="text" name="id" id="id" placeholder="아이디">
			 <input
				type="password" name="pw" id="pw" placeholder="비밀번호">

		</form>
		<button id="login">로그인</button>
	</div>
	<div id="app">
	{{message}}
	</div>
	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script>
      new Vue({
        el: "#app",
        data: {
          message: "Hello Vue.js!"
        }
      });
    </script>
</body>
</html>