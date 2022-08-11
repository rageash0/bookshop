<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
<link href="css/style.css" rel="stylesheet">
</head>
<body>

	<div class="form-section">
		<div class="register-form">
			<h2>Add Address line</h2>
			<form action="action-add-address" method="post">
				<input class="text text-margin" type="text" name="houseno" placeholder="House No" pattern="[0-9]+" required>
				<input class="text text-margin" type="text" name="street" placeholder="Street" required>
				<input class="text text-margin" type="text" name="city" placeholder="City" required>
				<input class="text text-margin" type="text" name="state" placeholder="State" required>
				<input class="text text-margin" type="text" name="country" placeholder="Country" required>
				
				<input class="button button-margin" type="submit" value="Add">
			</form>
		</div>
	
		<div class="register-form">
			<h2>Payment</h2>
			<form action="action-payment" method="post">
				
				<div class="text-margin">
					<label for="address">Address Line</label><br>
					<select name="address" id="address" required>
						<c:forEach items="${addresslist }" var="row">
							<option value="${row.id }">${row.houseNo }, ${row.street }, ${row.city }, ${row.state }, ${row.country }</option>
						</c:forEach>
					</select>
				</div>
			
				<input class="text text-margin" type="text" name="cardnumber" placeholder="CardNumber" pattern="[0-9]{12}" required>
				<input class="text text-margin" type="text" name="ccv" placeholder="CCV" pattern="[0-9]{3}" required>
				<input class="text text-margin" type="text" name="monthyear" placeholder="MM/YYYY" required>
				<input class="text text-margin" type="password" name="pin" placeholder="Pin" pattern="[0-9]{4}" required>
				
				<p class="message">${message }</p>
				
				<input class="button button-margin" type="submit" value="Proceed">
			</form>
			
			<hr>
			
			<form action="action-cashondelivery" method="post">
				<div class="text-margin">
					<label for="address">Address Line</label><br>
					<select name="address" id="address" required>
						<c:forEach items="${addresslist }" var="row">
							<option value="${row.id }">${row.houseNo }, ${row.street }, ${row.city }, ${row.state }, ${row.country }</option>
						</c:forEach>
					</select>
				</div>
				
				<input class="button button-margin" type="submit" value="Cash On Delivery">
			</form>
		</div>	
	</div>
	
	
</body>
</html>