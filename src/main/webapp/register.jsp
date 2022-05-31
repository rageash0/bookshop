<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online book shop</title>
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<div class="form-section">
		<div class="register-form">
			<h2>Register</h2>
			<form action="/bookshop/action-register" method="post">
				<input class="text text-margin" type="text" name="firstname" pattern="[A-Za-z]+" placeholder="First name" required>
				<input class="text text-margin" type="text" name="lastname" pattern="[A-Za-z]+" placeholder="Last name">
				<input class="text text-margin" type="date" name="dob" placeholder="Date of Birth" required>
				<input class="text text-margin" type="text" name="username" pattern="[a-z0-9]+" placeholder="Username" required>
				<input class="text text-margin" type="password" name="password" pattern="[a-zA-z0-9!@#$%&]{8,}" placeholder="Password(8 digit)" required>
				<input class="text text-margin" type="text" name="email" pattern="[a-z0-9]+@gmail.com" placeholder="Email" required>
				<input class="text text-margin" type="text" name="mobilenumber" pattern="[0-9]+" placeholder="Mobile Number" required>
				
				<label class="message">${message}</label>
				
				<input class="button register-button-margin" type="submit" value="Register">
				<a class="text-margin" href="/bookshop/Login">Login</a>
			</form>
		</div>
	</div>
</body>
</html>