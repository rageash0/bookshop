<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ViewBook</title>
<link href="css/style.css" rel="stylesheet">
<link href="css/viewbook.css" rel="stylesheet">
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
		<div class="main">
			<div class="main-content">
				<div class="image">
					<fun:choose>
						<fun:when test="${iswholesale == true }">
							<img src="${pageContext.servletContext.contextPath }/picture?wid=${book.bookId}"><br>
						</fun:when>
						<fun:otherwise>
							<img src="${pageContext.servletContext.contextPath }/picture?id=${book.bookId}"><br>
						</fun:otherwise>
					</fun:choose>
							
				</div>
				<div class="title-and-description">
					<h2>${book.title }</h2>
					<hr>
					<p>${book.description }</p>
				</div>
				<div class="price-details">
					<p class="price">Price : ${book.price }</p>
					
					<fun:if test="${userid != book.sellerId && !iswholesale}">
						<fun:choose>
							<fun:when test="${addedtocart == true }">
								<a class="button cartadded" href="/bookshop/action-removefromcart?bookid=${book.bookId }">Added</a>
							</fun:when>
							<fun:otherwise>
								<a class="button" href="/bookshop/action-addtocart?bookid=${book.bookId }">Add to cart</a>
							</fun:otherwise>
						</fun:choose>
						<a class="button" href="/bookshop/BuyBooks?bookid=${book.bookId }">Buy</a>
					</fun:if>
				</div>
			</div>
			
			<div class="details">
				<h2>Details</h2>
				<p>ISBN : ${book.isbn }</p>
				<p>Title : ${book.title }</p>
				<p>Author : ${book.author }</p>
				<p>Publisher: ${book.publisher }</p>
				<p>Edition : ${book.edition }</p>
				<p>Pages : ${book.pages }</p>
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