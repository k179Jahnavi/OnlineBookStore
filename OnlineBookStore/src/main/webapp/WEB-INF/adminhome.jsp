<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Navbar</title>
<style>
  /* Navbar styles */
  .navbar {
    width: 100%; 
    margin: 0 auto; 
    display: flex;
    justify-content: space-between;
    background-color: #096b61;
    border-bottom: 1px solid #ccc;
    padding: 10px 0;
  }

  .navbar a {
    color: black;
    text-align: center;
    padding: 10px 20px;
    text-decoration: none;
  }
#b{
	
}
 body{
 	background-color: #f49e7f;
 }
 
</style>
</head>
<body>
<div id="b">
<div class="navbar">
  <a href="#home">Home</a>
  <a href="displaybooks">Books</a>
    <a href="addbooks">Add Books</a>
   <a href="addusers">Add Users</a>
  <a href="logout">Logout</a>
</div>
<div>
<h1 align="center">welocme user</h1>
	<table border="1" align="center" style="margin-top:50px; width:500px; "> 
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>email</th>
         <th>phone number</th>
         <th>password</th>
        <th colspan="2">actions</th>
    </tr>
   	<c:forEach items="${user}" var="user">
   	<tr>
    	<td>${user.id}</td>
        <td>${user.name}</td>
         <td>${user.email}</td>
          <td>${user.phno}</td>
           <td>${user.password}</td>
        <td><a href="up/?id=${user.id}">update</a></td>
        <td><a href="delete/?id=${user.id}">delete</a></td>
    </tr>
   	</c:forEach>
  </table>
  
  
  
  <table border="1" align="center" style="margin-top:100px; width:500px; ">
 
    <tr>
        <th>ID</th>
        <th>Book name</th>
        <th>author</th>
        <th>price</th>
        <th>description</th>
        <th colspan="2">actions</th>
    </tr>
   	<c:forEach items="${book}" var="book">
   	<tr>
    	<td>${book.id}</td>
        <td>${book.book_name}</td>
         <td>${book.price}</td>
         <td>${book.author}</td>
         <td>${book.description}</td>
        <td><a href="updatebook/?id=${book.id}">update</a></td>
        <td><a href="deletebook/?id=${book.id}">delete</a></td>
    </tr>
   	</c:forEach>
  </table>
  </div>
  </div>
</body>
</html>
