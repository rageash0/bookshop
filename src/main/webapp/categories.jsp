<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/style.css" rel="stylesheet">
<title>Categories</title>
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

	
	<div class="main-content">
		<section class="category-section">
		<h2>Categories</h2>
		
		<a href="/bookshop/Categories?name=all">All</a>
		<hr>
		<div>
			<c:forEach items="${categories }" var="name">
				<div class="category-box">
					<a href="/bookshop/Categories?name=${name }">${name }</a>
				</div>
				<hr>
			</c:forEach>
			<div class="category-box">
				<a href="/bookshop/WholesaleBooks">Wholesale Books</a>
			</div>
			<hr>
		</div>	
	</section>
	
	<section>
		<h2>${categoryname }</h2>
		 <div class="book-section">
			<c:forEach items="${booklist }" var="book">
				<a href="/bookshop/Viewbook?id=${book.bookId }">
					<div class="book-product">
						<div>
		 					<img class="book" src="${pageContext.servletContext.contextPath }/picture?id=${book.bookId}">
						</div>
						<p class="title">${book.title }</p>
						<p class="author"> by ${book.author }</p>
						<p class="price">Rs.${book.price }</p>
							
					</div>
				</a>
			</c:forEach>
		</div>
	</section>
	</div>
	
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