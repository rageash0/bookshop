<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Books</title>
<link href="css/style.css" rel="stylesheet">
<link href="css/checkout.css" rel="stylesheet">
</head>
<body>
	
	<main>
		<div class="checkout-content">
			<h1>Check Out</h1>
		
			<div class="checkout-session">
				<c:choose>
					<c:when test="${wholesalelist != null }">
						<h2>${wholesalename }</h2>
						<p style="max-width: 500px">${wholesaledescription }</p>
						
						<c:forEach items="${wholesalelist }" var="row">
							<div class="checkout-book-block">
								<img class="book" src="${pageContext.servletContext.contextPath }/picture?wid=${row.book.bookId }">
								<div class="checkout-book-details">
									<p class="title">${row.book.title }</p>
									<p class="author">${row.book.author }</p>
									<p class="price">${row.book.price }</p>
								</div>
							</div>
						</c:forEach>								
					</c:when>
					
					<c:otherwise>
						<c:forEach items="${buyingbooks }" var="row">
							<div class="checkout-book-block">
								<img class="book" src="${pageContext.servletContext.contextPath }/picture?id=${row.bookId}">
								<div class="checkout-book-details">
									<p class="title">${row.title }</p>
									<p class="author">${row.author }</p>
									<p class="price">${row.price }</p>
								</div>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				
				<p>Total : <span class="price">${total }</span></p>
			</div>
			
			<div class="checkout-button">
				<button class="button" onClick="location.href='/bookshop/Payment?amount=${total}'">Make Payment</button>
			</div>
		</div>
		
	</main>
	
</body>
</html>