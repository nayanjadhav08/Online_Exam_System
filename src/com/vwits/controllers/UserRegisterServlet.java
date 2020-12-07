package com.vwits.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vwits.db.OESUersDAO;
import com.vwits.model.OESUser;

 
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
    public UserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String firstName = request.getParameter("firstName") ;
		String lastName = request.getParameter("lastName") ;
		String userName = request.getParameter("userName") ;
		String password = request.getParameter("password") ;
		String profile = request.getParameter("profile");
		
		PrintWriter out = response.getWriter() ;
		out.println(firstName + " "+ lastName + " "+ userName + " " + password + " " + profile) ;
		
		boolean status=OESUersDAO.saveUser(new OESUser(firstName, lastName, userName, password, profile));
			
		out.println("stats : "+ status);
		System.out.println("user innserted  : "+ status);
//		RequestDispatcher r = request.getRequestDispatcher("login.jsp" ) ;		
//		r.forward(request, response);
		response.sendRedirect("login.jsp");
	}

}
