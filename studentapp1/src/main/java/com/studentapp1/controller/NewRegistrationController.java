package com.studentapp1.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentapp1.model.DAOService;
import com.studentapp1.model.DAOServiceImpl;

@WebServlet("/saveReg")
public class NewRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewRegistrationController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/create_registration.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session = request.getSession(false);
		//till 10second once you login till 10 second if you don't interact with the applications the app gone logout
		session.setMaxInactiveInterval(10); //null 
		if(session.getAttribute("email")!=null) {//NullPointerException
		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		DAOService service=new DAOServiceImpl();
		service.connectDB();
		service.saveRegistration(name, city, email, mobile);
		
		request.setAttribute("msg", "Record is saved!!");
		
		// page moving same page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/create_registration.jsp");
		dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		}catch(Exception e) {
			request.setAttribute("error", "Session time out. please login again");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

}
