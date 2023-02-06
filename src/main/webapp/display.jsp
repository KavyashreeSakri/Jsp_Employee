<%@page import="com.ty.jsp_Employee.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String name = (String) request.getAttribute("name");
	%>
	<%
	List<Employee> list = (List) request.getAttribute("list");
	%>
	<%
	if (name != null) {
	%>
	<h3>
		Changed By: <%=name%>
	</h3>
	<%
	}
	%>
	<table border="2px solid"
		style="text-align: center; background-color: aqua;">
		<tr style="background-color: pink;">
			<th>Id</th>
			<th>Name</th>
			<th>Address</th>
			<th>Phone</th>
			<th>Email</th>
			<th>Password</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<%
		for (Employee employee : list) {
		%>
		<tr>
			<td><%=employee.getId()%></td>
			<td><%=employee.getName()%></td>
			<td><%=employee.getAddress()%></td>
			<td><%=employee.getPhone()%></td>
			<td><%=employee.getEmail()%></td>
			<td><%=employee.getPassword()%></td>
			<td><a href="delete?id=<%=employee.getId()%>"><button>DELETE</button></a>
			<td><a href="update?id=<%=employee.getId()%>"><button>UPDATE</button></a>
		</tr>

		<%
		}
		%>

	</table>
</body>
</html>