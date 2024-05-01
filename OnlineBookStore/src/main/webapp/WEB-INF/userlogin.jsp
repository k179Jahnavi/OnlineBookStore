<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<style>
  /* Center content */
  body, html {
    height: 100%;
    margin: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    font-family: Arial, sans-serif; /* Set font */
 }

  /* Center form */
  .form-container {
    text-align: center;
    border: 1px solid #ccc; /* Border around the content */
    padding: 60px; /* Add some padding */
    border-radius: 10px; /* Rounded corners */
    background-color: #fff; /* Background color */
    box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1); /* Box shadow for depth */
    max-width: 400px; /* Set maximum width of the container */
    width: 90%; /* Set width of the container */
   background-color: #f5f5f5; /* Background color */
  }

  /* Style h1 */
  h1 {
    color: #333; /* Dark text color */
    margin-bottom: 20px; /* Add margin below the message */
  }

  /* Style form input */
 	.in{
    padding: 10px;
    margin: 10px 0; /* Add vertical margin */
    border-radius: 5px;
    border: 1px solid #ccc;
    width: calc(100% - 22px); /* Set width to fill the container minus padding and border */
    box-sizing: border-box; /* Include padding and border in the element's total width and height */
  }

  /* Style error message */
  .error-message {
    color: red;
    margin-top: 10px; 
  }
</style>
</head>
<body><div>
<div class="form-container">
  <h1>User Login</h1>
  <form:form action="loginuser" modelAttribute="user">
    <form:input  path="email" placeholder="Email" class="in"/>
    <br>
    <form:input  path="password" placeholder="password" class="in"/>
    <br>
    <div class="error-message">${msg}</div>
    <input type="submit" value="Login"class="in">
  </form:form>
</div>
		<h1 align="center"><a href=backl style="text-decoration: none;background-color: #ec5e36;color: white;border-radius:5px; margin-left: 100px;padding: 10px 20px;font-weight: bolder;font-family:cursive;">Back</a></h1>
</div>
</body>
</html>
