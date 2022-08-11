<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online book shop</title>
<link href="css/style.css" rel="stylesheet">
</head>
<body>

	<header>
		<div>
			<h1>Admin</h1>
			<a href="/bookshop/Adminhome">User List</a>
			<a href="/bookshop/Adminhome?view=transaction">Orders</a>
			<a href="/bookshop/Adminhome?view=wholesale">Wholesale orders</a>
			<a href="/bookshop/Adminhome?view=requestedbook">Requested book</a>
			<a href="/bookshop/Adminhome?view=category">Category</a>
			<a href="/bookshop/Adminhome?view=language">Language</a>
			<a href="/bookshop/Categories">Books</a>
		</div>
		<nav>
			<a href="/bookshop/action-logout">Logout</a>
		</nav>
	</header>
	
	<main>
		<c:choose>
			<c:when test="${userlist != null }">
				<div>
					<h2>User</h2>
					<table>
						<tr>
							<th>Id</th>
							<th>First name</th>
							<th>Last name</th>
							<th>Username</th>
							<th>Email</th>
							<th>Mobile number</th>
						</tr>
						<c:forEach items="${userlist }" var="row">
							<tr>
								<td>${row.id }</td>
								<td>${row.firstName }</td>
								<td>${row.lastName }</td>
								<td>${row.username }</td>
								<td>${row.email }</td>
								<td>${row.mobileNumber }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:when>
			<c:when test="${transactionlist != null }">
				<div>
					<h2>Orders</h2>
					<table>
						<tr>
							<th>Id</th>
							<th>ISBN</th>
							<th>Book name</th>
							<th>Author</th>
							<th>Edition</th>
							<th>Publisher</th>
							<th>Price</th>
							<th>Seller name</th>
							<th>Buyer name</th>
							<th>House No</th>
							<th>Street</th>
							<th>City</th>
							<th>State</th>
							<th>Country</th>
							<th>Date and time</th>
							<th>Payment</th>
							<th>Delivery status</th>
							<th>set Delivery status</th>
						</tr>
						<c:forEach items="${transactionlist }" var="row">
							<tr>
								<td>${row.id }</td>
								<td>${row.isbn }</td>
								<td>${row.bookName }</td>
								<td>${row.author }</td>
								<td>${row.edition }</td>
								<td>${row.publisher }</td>
								<td>${row.price }</td>
								<td>${row.sellerName }</td>
								<td>${row.buyerName }</td>
								<td>${row.houseNo }</td>
								<td>${row.street }</td>
								<td>${row.city }</td>
								<td>${row.state }</td>
								<td>${row.country }</td>
								<td>${row.date }</td>
								<td>${row.payment }</td>
								<td>${row.delivery }</td>
								<td>
									<c:choose>
										<c:when test="${row.delivery == 'Ordered'}">
											<a class="button button-margin" href="action-setdeliverystatus?a=1&id=${row.id }">Pack</a>
										</c:when>
										<c:when test="${row.delivery == 'Packed'}">
											<a class="button button-margin" href="action-setdeliverystatus?a=2&id=${row.id }">Dispatch</a>
										</c:when>
										<c:when test="${row.delivery == 'Dispatched'}">
											<a class="button button-margin" href="action-setdeliverystatus?a=3&id=${row.id }">Out-for-order</a>
										</c:when>
										<c:when test="${row.delivery == 'Out for order'}">
											<a class="button button-margin" href="action-setdeliverystatus?a=4&id=${row.id }">Set-Delivered</a>
										</c:when>
									</c:choose>
								</td>
							</tr>
						</c:forEach>
					</table>
					
					<button class="button button-margin" onClick="location.href='/bookshop/Report'">Print</button>
				</div>
			</c:when>
			
			<c:when test="${wholesalelist != null }">
				<div>
					<h2>Wholesale Orders</h2>
					<table>
						<tr>
							<th>Id</th>
							<th>Wholesale name</th>
							<th>ISBN</th>
							<th>Book name</th>
							<th>Price</th>
							<th>Seller</th>
							<th>Buyer</th>
							<th>House No</th>
							<th>Street</th>
							<th>City</th>
							<th>State</th>
							<th>Country</th>
							<th>Date and time</th>
							<th>Payment</th>
							<th>Delivery status</th>
							<th>set Delivery status</th>
						</tr>
						<c:forEach items="${wholesalelist }" var="row">
							<tr>
								<td>${row.id }</td>
								<td>${row.wholesaleName }</td>
								<td>${row.isbn }</td>
								<td>${row.bookName }</td>
								<td>${row.price }</td>
								<td>${row.sellerName }</td>
								<td>${row.buyerName }</td>
								<td>${row.houseNo }</td>
								<td>${row.street }</td>
								<td>${row.city }</td>
								<td>${row.state }</td>
								<td>${row.country }</td>
								<td>${row.date }</td>
								<td>${row.payment }</td>
								<td>${row.delivery }</td>
								<td>
									<c:choose>
										<c:when test="${row.delivery == 'Ordered'}">
											<a class="button button-margin" href="action-setdeliverystatus?a=1&wid=${row.id }">Pack</a>
										</c:when>
										<c:when test="${row.delivery == 'Packed'}">
											<a class="button button-margin" href="action-setdeliverystatus?a=2&wid=${row.id }">Dispatch</a>
										</c:when>
										<c:when test="${row.delivery == 'Dispatched'}">
											<a class="button button-margin" href="action-setdeliverystatus?a=3&wid=${row.id }">Out-for-order</a>
										</c:when>
										<c:when test="${row.delivery == 'Out for order'}">
											<a class="button button-margin" href="action-setdeliverystatus?a=4&wid=${row.id }">Set-Delivered</a>
										</c:when>
									</c:choose>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:when>
			
			<c:when test="${requestedbooklist != null}">
				<div>
					<h2>Requested book</h2>
					<table>
						<tr>
							<th>Id</th>
							<th>ISBN</th>
							<th>Book name</th>
							<th>Author</th>
							<th>Edition</th>
							<th>Applicant</th>
						</tr>
						<c:forEach items="${requestedbooklist }" var="row">
							<tr>
								<td>${row.id }</td>
								<td>${row.isbn }</td>
								<td>${row.bookName }</td>
								<td>${row.author }</td>
								<td>${row.edition }</td>
								<td>${row.applicantName }</td>
							</tr>
						</c:forEach>
					</table>
				</div>	
			</c:when>
			
			<c:when test="${categorylist != null }">
				<div>
					<h2>Category</h2>
					<c:forEach items="${categorylist }" var="category">
						<p>${category }</p>
					</c:forEach>
				</div>
				
					<div class="form-section">
						<div class="register-form">
							<h2>Add Category</h2>
							<form action="action-addcategory">
								<input class="text text-margin" type="text" name="category" placeholder="Category" required>
								
								<p class="message">${message }</p>
								<input class="button button-margin" type="submit" value="Add Category">
							</form>
						</div>
					</div>
			</c:when>
			<c:otherwise>
				<div>
					<h2>Language</h2>
					<c:forEach items="${languagelist }" var="language">
						<p>${language }</p>
					</c:forEach>
				</div>
				
				<div class="form-section">
						<div class="register-form">
							<h2>Add Language</h2>
							<form action="action-addlanguage">
								<input class="text text-margin" type="text" name="language" placeholder="Language" required>
								
								<p class="message">${message }</p>
								<input class="button button-margin" type="submit" value="Add Language">
							</form>
						</div>
					</div>
			</c:otherwise>
		</c:choose>
	</main>
</body>
</html>