<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String message=(String) request.getAttribute("message"); 
if(message!=null) { %>
<h3><%= message %></h3>
<% }%>
<form action="login" method="post">
EMAIL:<input type="text" name= "email" placeholder="enter the email">
<br>
Password: <input type="text" name= "password" placeholder="enter the password">
<br>
<input type="submit">
</form>
</body>
</html>