<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add book</title>
<link href="css/style.css" rel="stylesheet">
</head>
<body>

	<div class="form-section">
		<div class="register-form">
			<h2>Add book</h2>
			<form action="/bookshop/action-addbook" method="post" enctype="multipart/form-data">
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
				<a class="text text-margin" href="/bookshop/Wholesale">Wholesale</a>	
			</form>
			
		</div>
	</div>
	
	
</body>
</html>