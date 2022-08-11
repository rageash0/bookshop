<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link href="css/style.css" type="text/css" rel="stylesheet">
	<meta charset="ISO-8859-1">
	<title>Online book shop</title>
</head>
	<body>
		<header>
			<nav>
				<a class="project-title" href="/bookshop/Index">BookShop</a>
				<a href="/bookshop/AddBook">Sell book</a>
				<a href="/bookshop/Wholesale">Wholesale</a>
			</nav>
			
			<div class="profile">
				<fun:choose>
					<fun:when test="${username == null}">
						<a href="/bookshop/Login">Login</a>
					</fun:when>
					<fun:otherwise>
						<div class="dropdown">
							<a href="#">Account</a>
							
							<div class="dropdown-content">
								<a href="/bookshop/Profile">Profile</a>
								<a href="/bookshop/action-logout">Logout</a>
							</div>
						</div>
					</fun:otherwise>
				</fun:choose>
			</div>
			
		</header>
		
		<main>
			<div class="search-bar-section">		
				<a class="categories" href="/bookshop/Categories">Categories</a>
				
				<form class="search-bar" action="action-search">
						<input class="text" type="text" name="search" placeholder="Book / Author / ISBN">
						<input class="button" type="submit" value="Search">
				</form>
			</div>
			
			<div class="banner-section">
				<!-- <img class="banner" src="image/pexels-janko-ferlic-590493.jpg"> -->
			</div>
			
			<section>
				<h2>Fiction</h2>
				<div class="book-section">
					<fun:forEach items="${fiction }" var="book">
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
					</fun:forEach>
				</div>
			</section>
						
			<section>
				<h2>Mythology</h2>
				<div class="book-section">
					<fun:forEach items="${mythology }" var="book">
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
					</fun:forEach>
				</div>
			</section>
			
						
			<section>
				<h2>New</h2>
				<div class="book-section">
					<fun:forEach items="${newlist }" var="book">
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
					</fun:forEach>
				</div>
			</section>
			
						
			<section>
				<h2>Text Book</h2>
				<div class="book-section">
					<fun:forEach items="${textbook }" var="book">
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
					</fun:forEach>
				</div>
			</section>
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