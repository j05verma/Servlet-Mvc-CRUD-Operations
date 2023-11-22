package com.studentapp1.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentapp1.model.DAOService;
import com.studentapp1.model.DAOServiceImpl;

@WebServlet("/listAll")
public class ReadRegistrations extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadRegistrations() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("email") != null) {

			DAOService service = new DAOServiceImpl();
			service.connectDB();
			ResultSet result = service.listAllReg();
			request.setAttribute("res", result);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
