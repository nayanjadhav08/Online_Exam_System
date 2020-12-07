package com.vwits.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vwits.db.MyDbConnection;
import com.vwits.model.OESUser;

/**
 * Servlet implementation class updateProfileServlet
 */
@WebServlet("/updateProfileServlet")
public class updateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateProfileServlet() {
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
		
		HttpSession httpSession = request.getSession(false) ;
		OESUser user = (OESUser)httpSession.getAttribute("currentSessionUser") ;
		
		if(httpSession != null && user!=null)
		{
			//valid user_requestn now update data 
			String firstName = request.getParameter("firstName") ;
			String lastName = request.getParameter("lastName") ;
			String userName = request.getParameter("userName") ;
			String password = request.getParameter("password") ;
			String userId = request.getParameter("userId") ;
			int intUserId = Integer.valueOf(userId) ;
			int status ;
			//userId=23&firstName=Swap&lastName=J&userName=swap&password=12349
			MyDbConnection db = new MyDbConnection() ;
			                                                                                                                                                                                             
//			 FIRSTNAME, LASTNAME, USERNAME, PASSWORD, PROFILE   
			 
			String sqlQuery ="update OESUSER SET FIRSTNAME =?, LASTNAME =?, USERNAME =?, PASSWORD =? where id=?" ;
			PreparedStatement pt = db.getPreparedStatement(sqlQuery) ;
		
			try {
				pt.setString(1, firstName);
				pt.setString(2, lastName);
				pt.setString(3, userName);
				pt.setString(4, password);
				pt.setInt(5, intUserId );
				
				status = pt.executeUpdate()  ;
				PrintWriter out = response.getWriter() ;
				if(status == 1)
				{ //sucess 
					out.println("status : " + status );
					request.setAttribute("msg", "Profile Updated Sucsessfuly !!");
					request.setAttribute("status", "block");
					RequestDispatcher r = request.getRequestDispatcher("updateProfile.jsp");
					
					r.forward(request, response);
				}
				else
				{
					out.println("Something Went Wrong... ");
					out.println("status : " + status );
					
					request.setAttribute("msg", "Profile Not Updated ");
					request.setAttribute("status", "block");
					RequestDispatcher r = request.getRequestDispatcher("updateProfile.jsp");
					
					r.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			RequestDispatcher r = request.getRequestDispatcher("login.jsp"); 
			r.forward(request, response);
		}
	}

}
