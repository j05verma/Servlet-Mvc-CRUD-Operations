package com.studentapp1.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentapp1.model.DAOService;
import com.studentapp1.model.DAOServiceImpl;

@WebServlet("/update")
public class UpdateRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateRegistration() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// read the parameter
		String email = request.getParameter("emailid");
		String mobile = request.getParameter("mobile");
		
		request.setAttribute("email", email);
		request.setAttribute("mobile", mobile);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/update_registration.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// read the parameter
				String email = request.getParameter("email");
				String mobile = request.getParameter("mobile");
				
				DAOService service=new DAOServiceImpl();
				service.connectDB();
				service.updateRegistration(email, mobile);
				
				//after updating
				ResultSet result = service.listAllReg();
				request.setAttribute("res", result);
				// page moving same page
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
				dispatcher.forward(request, response);
	}

}
