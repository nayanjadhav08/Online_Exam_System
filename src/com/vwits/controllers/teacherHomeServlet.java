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

 
@WebServlet("/teacherHomeServlet")
public class teacherHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public teacherHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpsession = request.getSession(false) ;
		//login to techer home
		//add new test
		//add,delete question
		
		PrintWriter out = response.getWriter() ;
		response.setContentType("text/html");
		if(httpsession !=null)
		{
			RequestDispatcher r = request.getRequestDispatcher("teacherHome.jsp");
//			request.setAttribute("user", );
			
		}else
		{
			
			response.sendRedirect("login.jsp");
			
		}
		
		
	}

}
