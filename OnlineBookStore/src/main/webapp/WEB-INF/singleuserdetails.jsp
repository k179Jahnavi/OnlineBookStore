<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	body{
		background-color: #e7c27a;
	}
</style>
</head>
<body>
	<h1 align="center">Welcome user</h1>
	<table border="1" align="center" style="margin-top:50px; width:500px; "> 
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>email</th>
         <th>phone number</th>
         <th>password</th>
    </tr>
   	
   	<tr>
    	<td>${user.id}</td>
        <td>${user.name}</td>
         <td>${user.email}</td>
          <td>${user.phno}</td>
           <td>${user.password}</td>
    </tr>
    </table>
    		<h1 align="center"><a href="userh" style="text-decoration: none;background-color: #ec5e36;color: white;border-radius:5px; margin-right: 100px;padding: 5px 20px;font-weight: bolder;font-family:cursive;">Back</a></h1>
    
</body>
</html>