package com.vwits.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vwits.db.ExamDAO;
import com.vwits.model.Exam;

/**
 * Servlet implementation class addExamServlet
 */
@WebServlet("/addExamServlet")
public class addExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addExamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		examName=exam1&totalMark=20
		String examName = request.getParameter("examName");
		String totalMark = request.getParameter("totalMark");
		
		PrintWriter out = response.getWriter() ;
//		out.println(examName + "   "+ totalMark);
		
		ExamDAO exams = new ExamDAO() ;
		exams.addExam(new Exam(0, examName , Integer.valueOf(totalMark), 0));
		
		
		out.println("<h3>Exam Added successfuly</h3>");
		out.println("<a href='teacherHome.jsp'>For Home Page click here ...</a>");
//		RequestDispatcher r = request.getRequestDispatcher("teacherHome.jsp") ;
//		r.forward(request, response);
		
	}

}
