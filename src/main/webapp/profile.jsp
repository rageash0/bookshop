<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "bookshop.bookmanagement.book.Book" %>
<%@ page import = "java.io.InputStream" %>
    
<%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<link href="css/style.css" rel="stylesheet">
<link href="css/profilestyle.css" rel="stylesheet">
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
		<div class="profile-content">
			<div class="profile-details">
					<h2 class="name">${firstname } ${lastname }</h2>
					<p class="username">@${username }</p>
			</div>
			
			<div class="navigation">
				<div>
					<a href="/bookshop/Profile">MyBooks</a>
					<a href="/bookshop/Profile?view=buyers">View Buyers</a>
					<a href="/bookshop/Profile?view=cart">My Cart</a>
					<a href="/bookshop/Profile?view=orders">My Orders</a>
					<a href="/bookshop/Profile?view=wholesale">Wholesale books</a>
				</div>
				<div>
					<a href="/bookshop/AddBook">Add book</a>
				</div>
			</div>
			
			<!--user content -->
			<div>
				<fun:choose>
				
					<fun:when test="${buyers != null }">
						<div>
							<h2>Buyers</h2>
							<div class="transaction-section">
								<fun:forEach items="${buyers }" var="row">
									<div class="details-block">
										<p class="title">Trans id: ${row.id }</p>
										<p class="title">${row.isbn }</p>
										<p class="title">${row.bookName }</p>
										<p class="price">Rs.${row.price }</p>
										<p class="title">buyer Id: ${row.buyerId }</p>
										<p class="author">Buyer name: ${row.buyerName }</p>
									</div>
								</fun:forEach>
							</div>
						</div>
						<div>
							<h2>Wholesale book buyers</h2>
							<div class="transaction-section">
								<fun:forEach items="${wholesalebuyers }" var="row">
									<div class="details-block">
										<p class="title">${row.wholesaleName }</p>
										<p>${row.wholesaleDescription }</p>
										<p>Books : ${row.bookName }</p>
										<p class="price">Rs.${row.price }</p>
										<p>Buyer : ${row.buyerName }</p>
										<p style="color:green; font-weight:bold">${row.payment }</p>
									</div>
								</fun:forEach>
							</div>
						</div>
					</fun:when>
					
					<fun:when test="${books != null }">
						<div>
							<h2>My Cart</h2>
							<div class="book-section">
								<fun:forEach items="${books }" var="book">
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
							
							<button class="button" onClick="location.href='/bookshop/BuyBooks'">Check out</button>
						</div>
					</fun:when>
					
					<fun:when test="${orders != null }">
						<div>
							<h2>My Orders</h2>
							<div class="transaction-section">
								<fun:forEach items="${orders }" var="order">
									<div class="details-block">
										<p class="title">Trans id: ${order.id }</p>
										<p class="title">${order.isbn }</p>
										<p class="title">${order.bookName }</p>
										<p class="author">by ${order.author }</p>
										<p class="price">Rs.${order.price }</p>
										<p class="title">Seller Id: ${order.sellerId }</p>
										<p class="author">Seller name: ${order.sellerName }</p>
										<a class="button button-margin" href="/bookshop/TrackOrder?id=${order.id }">TrackOrder</a>
									</div>
								</fun:forEach>
							</div>
						</div>
						<div>
							<h2>Wholesale Orders</h2>
							<div class="transaction-section">
								<fun:forEach items="${wholesaleorders }" var="worder">
									<div class="details-block">
										<p class="title">${worder.wholesaleName }</p>
										<p>${worder.wholesaleDescription }</p>
										<p>Books : ${worder.bookName }</p>
										<p class="price">Rs.${worder.price }</p>
										<p>Seller : ${worder.sellerName }</p>
										<p style="color:green; font-weight:bold">${worder.payment }</p>
										
										<a class="button button-margin" href="/bookshop/TrackOrder?wid=${worder.id }">TrackOrder</a>
									</div>
								</fun:forEach>
							</div>
							
						</div>
					</fun:when>
					
					<fun:when test="${wholesalelist != null }">
						<div class="wholesale-item-section">
							<h2>Wholesale</h2>
							<div class="book-section">
								<fun:forEach items="${wholesalelist }" var="row">
									<a class="book-product" href="/bookshop/ViewWholesaleBook?id=${row.id }&noofbooks=${row.noOfBooks }&price=${row.price }&sellerid=${row.sellerId}">
										<p class="title">${row.name }</p>
										<hr>
										<p>${ row.description}</p>
										<p>${ row.noOfBooks }</p>
										<p class="price">Rs.${row.price }</p>
									</a>
								</fun:forEach>
							</div>
						</div>
					</fun:when>
					
					<fun:otherwise>
						<div class="added-book-list">
							<h2>My Books</h2>
							<div class="book-section">
								<fun:forEach items="${mybook }" var="book">
									<a href="/bookshop/Viewbook?id=${book.bookId }">
										<div class="book-product">
											<div>
												<img class="book" src="${pageContext.servletContext.contextPath }/picture?id=${book.bookId}">
											</div>
											<p class="title">${book.title }</p>
											<p class="author"> by ${book.author }</p>
									
										</div>
									</a>
								</fun:forEach>
							</div>
						</div>
					</fun:otherwise>
				</fun:choose>	
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