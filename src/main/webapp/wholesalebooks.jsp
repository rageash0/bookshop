<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wholesale</title>
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<header>
			<nav>
				<a class="project-title" href="/bookshop/Index">BookShop</a>
				<a href="/bookshop/AddBook">Sell book</a>
				<a href="/bookshop/Wholesale">Wholesale</a>
			</nav>
			
			<div class="profile">
				<c:choose>
					<c:when test="${username == null}">
						<a href="/bookshop/Login">Login</a>
					</c:when>
					<c:otherwise>
						<div class="dropdown">
							<a href="#">Account</a>
							
							<div class="dropdown-content">
								<a href="/bookshop/Profile">Profile</a>
								<a href="/bookshop/action-logout">Logout</a>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			
		</header>
		
	<main>
		<div class="wholesale-item-section">
							<h2>Wholesale</h2>
							<div class="book-section">
								<c:forEach items="${wholesalelist }" var="row">
									<a class="book-product" href="/bookshop/ViewWholesaleBook?id=${row.id }&noofbooks=${row.noOfBooks}&price=${row.price}&sellerid=${row.sellerId}">
										<p class="title">${row.name }</p>
										<hr>
										<p>${ row.description}</p>
										<p class="title">books : ${row.noOfBooks }</p>
										<p class="price">Rs.${row.price }</p>
									</a>
								</c:forEach>
							</div>
						</div>
	</main>
	
	<footer>
			<div class="about-us-section">
				<h2>About us</h2>
				<p>
					Ever you wanted to buy book but could not because of too expensive. 
					Don't worry! because of this website you guys can buy books for cheap 
					price from seller who already used it. You can sell the book once you 
					done reading. You can buy and sell book from your comfort zone.
				</p>
			</div>
			
			<div class="link-section">
				<h2>Links</h2>
				<a href="/bookshop/AddBook">Sell Book</a>
				<a href="/bookshop/Wholesale">Wholesale</a>
				<a href="/bookshop/WholesaleBooks">Wholesale Books</a>
				<a href="/bookshop/RequestBook">Request book</a>
				<a href="/bookshop/RequestedBooks">Requested books</a>
			</div>
			
			<div class="contact-us-section">
				<h2>Contact us</h2>
				<p>
					#123, Street, <br>
					City, <br>
					State - Pincode	<br>
					<em>bookshop@gmail.com</em> <br>
				</p>
			</div>
			
		</footer>
</body>
</html>