<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="save" method="post">
	<table>
		<tr>
			<td>Name: </td><td><input type="text" name="name"
				placeholder="enter your name"></td>
		</tr>
		<tr>
			<td>Email: </td><td><input type="email" name="email"
				placeholder="enter your email"></td>
		</tr>
		<tr>
			<td>Password: </td><td><input type="text" name="pwd"
				placeholder="enter your password"></td>
		</tr>
		<tr>
			<td>Address: </td><td><input type="text" name="address"
				placeholder="enter your address"></td>
		</tr>
		<tr>
			<td>Phone: </td><td><input type="tel" name="phone"
				placeholder="enter your phone"></td>
		</tr>

		<tr>
			<td><input type="submit" ></td>
		</tr>



	</table>
	</form>
</body>
</html>