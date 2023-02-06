package com.ty.jsp_Employee.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.jsp_Employee.dao.EmployeeDao;
import com.ty.jsp_Employee.dto.Employee;

@WebServlet("/delete")
public class EmployeeDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id= Integer.parseInt(req.getParameter("id"));
	
	EmployeeDao dao= new EmployeeDao();
	boolean result=dao.deleteEmployee(id);
	if(result) {
		List<Employee> list= dao.getAllEmployee();
		req.setAttribute("list", list);
		RequestDispatcher dispatcher= req.getRequestDispatcher("display.jsp");
		dispatcher.forward(req, resp);
	}
	
	}
}
