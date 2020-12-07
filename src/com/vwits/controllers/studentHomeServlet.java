package com.vwits.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vwits.db.ExamDAO;
import com.vwits.model.Exam;
import com.vwits.model.OESUser;

 
@WebServlet("/studentHomeServlet")
public class studentHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public studentHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//send all available exam data
		HttpSession httpsession = request.getSession(false) ;
		
		
		
		if( (httpsession == null))
		{	
			RequestDispatcher r = request.getRequestDispatcher("login.jsp") ;
			r.forward(request, response);
		}
		 
		//need arrenge the code littel 
		
		if( httpsession != null )
		{	
			try {
				if (httpsession.getAttribute("currentSessionUser") == null )
				{
//					response.sendRedirect("login.jsp");
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("error handeled");
				RequestDispatcher r = request.getRequestDispatcher("login.jsp") ;
				r.forward(request, response);
			} 
			
			
		}
		
		PrintWriter out= response.getWriter() ;
//		out.println("UserID  : "+ request.getParameter("username"));
		
		OESUser user =(OESUser)httpsession.getAttribute("currentSessionUser") ;
		
//		if( user.getUsername() == null )
//		{
//			response.sendRedirect("login.jsp");
//		}
		
		System.out.println(user);
		String sessionUser = user.getUsername() ;
		
		RequestDispatcher r = request.getRequestDispatcher("StuHome.jsp") ;
		//set user-name
//		request.setAttribute("username", request.getParameter("username").toUpperCase());
		request.setAttribute("username", sessionUser.toUpperCase());
		
		//send all available exam data
		ExamDAO Exams = new ExamDAO() ;
		
		List<Exam> allExams = new ArrayList<Exam>() ;
		allExams = Exams.getAllExams() ; 
		
		request.setAttribute("allExams", allExams );
		
		r.forward(request, response);
	}

}
