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
	
	<main class="wholesale-section">
		<div class="addbooks-section">
		
			<div class="form-section">
				<div class="register-form">
					<h2>Add book</h2>
					<form action="/bookshop/action-addwholesalebook" method="post" enctype="multipart/form-data">
						<input class="text text-margin" type="text" name="isbn" placeholder="ISBN" pattern="[0-9]{13}" required>
						<input class="text text-margin" type="text" name="bookname" placeholder="Book name" required>
						<input class="text text-margin" type="text" name="author" placeholder="Author" required>
						<input class="text text-margin" type="text" name="publisher" placeholder="Publisher">
						<input class="text text-margin" type="text" name="edition" placeholder="Edition">
						<input class="text text-margin" type="number" name="pages" placeholder="Pages">
						<input class="text text-margin" type="text" name="price" placeholder="Price" required>
						<textarea class="text text-margin" row="20" name="description" placeholder="Description" maxlength="2000"></textarea>
						
						<div class="text-margin">
							<label for="category">Category</label>
							<select name="category" id="category">
								<c:forEach items="${categories }" var="categoryvalue">
									<option value="${categoryvalue }">${categoryvalue }</option>
								</c:forEach>
							</select>
						</div>
						
						<div class="text-margin">
							<label for="language">Language</label>
							<select name="language" id="language">
								<c:forEach items="${languages }" var="languagevalue">
									<option value="${languagevalue }">${languagevalue }</option>
								</c:forEach>
							</select>
						</div>
						
						<input class="text text-margin" type="file" name="cover" required><br>
						
						<label class="message">${message}</label>
						
						<input class="button button-margin" type="submit" value="Add book">
						
					</form>
				</div>
			</div>
			
		</div>
		<div class="proceed-wholesale-section">
			<h2>Wholesale</h2>
			
			<c:forEach items="${wholesalebooks }" var="row">
				<div class="view-book-description">
					<p class="title">${row.book.title }</p>
					<p class="author">${row.book.author }</p>
					<p>${row.book.edition }</p>
					<p class="price">${row.book.price }</p>
				</div>
			</c:forEach>
			
			<form action="action-addwholesale">
				<input class="text text-margin" type="text" name="name" placeholder="Wholesale name">
				<textarea class="text text-margin" name="description" placeholder="Description"></textarea>
				
				<label class="message">${wholesalemessage }</label>
				<input class="button button-margin" type="submit" value="Proceed">
			</form> 
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