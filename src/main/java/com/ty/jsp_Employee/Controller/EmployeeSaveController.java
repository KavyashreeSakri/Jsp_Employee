package com.ty.jsp_Employee.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.jsp_Employee.dao.EmployeeDao;
import com.ty.jsp_Employee.dto.Employee;

@WebServlet("/save")
public class EmployeeSaveController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("pwd");
		String address = req.getParameter("address");
		Long phone = Long.parseLong(req.getParameter("phone"));

		Employee employee = new Employee();
		employee.setName(name);
		employee.setEmail(email);
		employee.setAddress(address);
		employee.setPassword(password);
		employee.setPhone(phone);

		EmployeeDao dao = new EmployeeDao();
		Employee saveEmployee = dao.saveEmployee(employee);
		if (saveEmployee != null) {
			
			req.setAttribute("message", "Signed up successfully");
			RequestDispatcher dispatcher= req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
