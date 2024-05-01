<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	table{
		width: 500px;
		height: 400px;
	}
	body{
		background-color:#7ac4ba;
	}
	td{
		font-size: 20px;
		font-weight: bolder;
	}
</style>
</head>
<body>
	<h1 align="center" style="margin-top: 100px;color: #ec5e36;font-weight: bolder;font-family: cursive;">Books may well be the only true magic</h1>
	<table align="center" >
		<form:form action="${book.id != null ? 'updateb' : 'addbook'}" modelAttribute="book">
			<tr>
				<td>id</td><td>:</td>
				<td><form:input path="id" readonly="true" style="padding:10px;"/></td>
			</tr>
			<tr>
				<td>book_name</td><td>:</td>
				<td><form:input path="book_name" style="padding:10px;"/></td>
			</tr>
			<tr>
				<td>author</td><td>:</td>
				<td><form:input path="author" style="padding:10px;"/></td>
			</tr>
			<tr>
				<td>price</td><td>:</td>
				<td><form:input path="price" style="padding:10px;"/></td>
			</tr>
			<tr>
				<td>description</td>
				<td>:</td>
				<td><form:input path="description" style="padding:10px;"/></td>
			</tr>
				<td colspan="3" align="center" ><input id="s" type="submit" value="Add Book" style="padding: 10px 20px; color: black; font-weight:bold;font-size: 20px;border: none;margin-right: 100px;"></td>
		</form:form>
	</table>
		<h1 align="center"><a href="backhome" style="text-decoration: none;background-color: #ec5e36;color: white;border-radius:5px; margin-right: 100px;padding: 10px 20px;font-weight: bolder;font-family:cursive;">Back</a></h1>
</body>
</html>