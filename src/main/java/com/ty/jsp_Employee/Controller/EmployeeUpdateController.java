package com.ty.jsp_Employee.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.jsp_Employee.dao.EmployeeDao;
import com.ty.jsp_Employee.dto.Employee;

@WebServlet("/update")
public class EmployeeUpdateController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id= Integer.parseInt(req.getParameter("id"));
		
		EmployeeDao dao= new EmployeeDao();
		Employee employee= dao.getEmployeeById(id);
		if(employee!=null) {
			HttpSession session= req.getSession();
			String name=(String)session.getAttribute("name");
			if(name!=null) {
				req.setAttribute("employee", employee);
				RequestDispatcher dispatcher= req.getRequestDispatcher("edit.jsp");
				dispatcher.forward(req, resp);
			}else {
				req.setAttribute("message", "First Login to update Employee");
				RequestDispatcher dispatcher= req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, resp);
			}
				
			
			
		}
		
		
		
		
	}
}
