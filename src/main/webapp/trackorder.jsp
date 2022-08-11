<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Track order</title>
<link href="css/style.css" rel="stylesheet">
<link href="css/trackorder.css" rel="stylesheet">
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
	
	<main class="track-order-content">
		<h2>Track Order</h2>
		<c:choose>
			<c:when test="${book != null }">
				<div class="book-information">
					<h3 class="title">${ book.bookName}</h3>
					<p>${book.author }</p>
					<p>${book.isbn }</p>
				</div>
			</c:when>
			
			<c:otherwise>
				<div class="wholesale-book-information">
					<h3 class="title">${wholesale.wholesaleName }</h3>
					<p>${wholesale.wholesaleDescription }</p>
					<p>${wholesale.isbn}</p>
					<p>${wholesale.bookName }</p>
				</div>
			</c:otherwise>
		</c:choose>
				
		<div class="track-book-section">
			<div class="indicating-shape">
				<c:choose>
					<c:when test="${delivery >= 1 }">
						<div class="circle indicate-circle"></div>
						<p class="delivery-info indicate-info">Ordered</p>
					</c:when>
					<c:otherwise>
						<div class="circle"></div>
						<p class="delivery-info">Ordered</p>
					</c:otherwise>
				</c:choose>
			</div>
			
			<div class="indicating-shape">
				<c:choose>
					<c:when test="${delivery >= 2 }">
						<div class="circle indicate-circle"></div>
						<p class="delivery-info indicate-info">Packed</p>
					</c:when>
					<c:otherwise>
						<div class="circle"></div>
						<p class="delivery-info">Packed</p>
					</c:otherwise>
				</c:choose>
			</div>
			
			<div class="indicating-shape">
				<c:choose>
					<c:when test="${delivery >= 3 }">
						<div class="circle indicate-circle"></div>
						<p class="delivery-info indicate-info">Dispatched</p>
					</c:when>
					<c:otherwise>
						<div class="circle"></div>
						<p class="delivery-info">Dispatched</p>
					</c:otherwise>
				</c:choose>
			</div>
			
			<div class="indicating-shape">
				<c:choose>
					<c:when test="${delivery >= 4 }">
						<div class="circle indicate-circle"></div>
						<p class="delivery-info indicate-info">Out for delivery</p>
					</c:when>
					<c:otherwise>
						<div class="circle"></div>
						<p class="delivery-info">Out for delivery</p>
					</c:otherwise>
				</c:choose>
			</div>
			
			<div class="indicating-shape">
				<c:choose>
					<c:when test="${delivery >= 5 }">
						<div class="circle indicate-circle"></div>
						<p class="delivery-info indicate-info">Delivered</p>
					</c:when>
					<c:otherwise>
						<div class="circle"></div>
						<p class="delivery-info">Delivered</p>
					</c:otherwise>
				</c:choose>
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