package com.ty.jsp_Employee.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.jsp_Employee.dao.EmployeeDao;
import com.ty.jsp_Employee.dto.Employee;

@WebServlet("/edit")
public class EmployeeEditController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id= Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("pwd");
		String address = req.getParameter("address");
		Long phone = Long.parseLong(req.getParameter("phone"));

		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setEmail(email);
		employee.setAddress(address);
		employee.setPassword(password);
		employee.setPhone(phone);
		
		EmployeeDao dao= new EmployeeDao();
		Employee employee2= dao.updateEmployee(employee);
		if(employee2!=null) {
			List<Employee> list= dao.getAllEmployee();
			req.setAttribute("list", list);
			Cookie[] cookies= req.getCookies();
			String value=null;
			for(Cookie cookie: cookies) {
				if(cookie.getName().equals("name")) {
					value=cookie.getValue();
				}
			}
			req.setAttribute("name", value);
			RequestDispatcher dispatcher= req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
		}else {
			RequestDispatcher dispatcher= req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);

		}

	}
}
