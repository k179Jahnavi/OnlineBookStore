<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <table  border="1">
            <form:form action="adminacc" modelAttribute="admin" align="center">
                <tr>
                    <td>id</td>
                    <td><form:input path="id" readonly="true"/></td>
                </tr>
                <tr>
                    <td>name</td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td>email</td>
                    <td><form:input path="email" /></td>
                </tr>
                <tr>
                    <td>phone number</td>
                    <td><form:input path="phno"/></td>
                </tr>
                <tr>
                    <td>password</td>
                    <td><form:input path="password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="submit"></td>
                </tr>
            </form:form>
        </table>
</body>
</html>
