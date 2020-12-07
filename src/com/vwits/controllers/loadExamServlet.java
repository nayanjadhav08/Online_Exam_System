package com.vwits.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vwits.db.QuestionDAO;
import com.vwits.model.Exam;
import com.vwits.model.OESUser;
import com.vwits.model.Question;

 
@WebServlet("/loadExamServlet")
public class loadExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public loadExamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter() ;
//		if(request == null )
//		{
//			response.sendRedirect("login.jsp");
//		}
		
		HttpSession httpsession = request.getSession(false) ;
		
		if( (httpsession == null))
		{	//if no session then login first
			response.sendRedirect("login.jsp");
			
		}
		
		
		
		int examId = 0 ;
		int totalMarks = 0 ;
		String examName = "" ;
		
		if(request.getParameter("examId") !=null) 
		{
		 examId = Integer.valueOf(request.getParameter("examId"));
		 totalMarks = Integer.valueOf( request.getParameter("totMark"));
		 examName =  request.getParameter("examName") ;
		}
		 
		//do not create session only access
//		HttpSession httpsession = request.getSession(false) ;
		
		
//		out.println(examID + "   "+ userId + "  " + totalMarks);
		
		if(examName.length() !=0)
		{//session available load Questions
			
			OESUser user = (OESUser)httpsession.getAttribute("currentSessionUser") ; 
			
			if(user != null) {
			int userId = user.getId() ;
			}
//			out.println("session availanle " + userId );
			
			//get questionsBank of that exam  
			List<Question> questionBank = QuestionDAO.getQuestionBank(examId);
			httpsession.setAttribute("currentQuestionBank", questionBank);
			
			
			RequestDispatcher r = request.getRequestDispatcher("examPage.jsp") ;
			request.setAttribute("questionBank", questionBank );
			request.setAttribute("examName", examName );
			request.setAttribute("totalMarks", totalMarks );
			r.forward(request, response);
			
		}
		else
		{ // redirect to login page 
			response.sendRedirect("login.jsp");
		}
		
		
		
	}

}
