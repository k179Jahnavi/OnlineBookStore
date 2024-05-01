<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	body{
		background-color: #e7c27a;
	}
	th{
		color: #0a9d4c;
	}
	th, td {
		border: 1px solid #de1036; /* Set default border color */
		padding: 8px;
		text-align: left;
		font-size: 20px;
	}
</style>
</head>
<body>
		<h1 align="center" style="margin-top: 100px;color: #ef22eb;font-weight: bolder;font-family: cursive;">open a book and open your mind</h1>
	
	<table border="1" align="center" rules="all" cellpadding="5" cellspacing="0">
 
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>email</th>
        <th>phone number</th>
        <th>Description</th>
        <th colspan="2">actions</th>
    </tr>
   	<c:forEach items="${book}" var="book">
   	<tr>
    	<td>${book.id}</td>
        <td>${book.book_name}</td>
         <td>${book.author}</td>
          <td>${book.price}</td>
           <td>${book.description}</td>
         <td><a href="updatebook/?id=${book.id}">update</a></td>
        <td><a href="deletebook/?id=${book.id}">delete</a></td>
    </tr>
   	</c:forEach>
  </table>
		<h1 align="center"><a href="backhome" style="text-decoration: none;background-color: #ec5e36;color: white;border-radius:5px; margin-right: 100px;padding: 5px 20px;font-weight: bolder;font-family:cursive;">Back</a></h1>
  
</body>
</html>