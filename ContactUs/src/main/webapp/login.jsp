<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="login.css">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="loginContainer">
    <div>
        <h1>Admin Login</h1>
		<form action="login" method="post">
			<label>User Name</label><br>
			<input type="text" name="uname"><br>
			<label>Password</label><br>
			<input type="password" name="password"><br><br>
			<input type="submit">
		</form>
	</div>
</div>
</body>
</html>