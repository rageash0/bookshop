<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online book shop - login</title>
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<div class="form-section">
	
		<div class="login-form">
			<h2>Login</h2>
			<form action="/bookshop/action-login" method="post">
				<input class="text text-margin" type="text" name="username" placeholder="Username">
				<input class="text text-margin" type="password" name="password" placeholder="Password">
				<label class="message">${message }</label>
				<input class="button login-button-margin" type="submit" value="Login">
				<a class="text-margin" href="/bookshop/Register">Register</a>
			</form>
		</div>
	</div>
</body>
</html>