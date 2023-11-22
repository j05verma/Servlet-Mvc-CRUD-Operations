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

@WebServlet("/delete")
public class DeleteRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteRegistration() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// read the parameter
		String email = request.getParameter("emailid");
		
		DAOService service=new DAOServiceImpl();
		//database connecting
		service.connectDB();
		service.deleteRegistration(email);
		
		//after deleting record fatch data base
		ResultSet result = service.listAllReg();
		request.setAttribute("res", result);
		// page moving same page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
