package com.vwits.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.vwits.db.OESUersDAO;
import com.vwits.model.OESUser;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
//		out.println("on login validationn page ");
		
		//filter part is remaining for validation
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rememberme = request.getParameter("rememberme");

//		out.println(username + "  " + password + "   " + rememberme);

		OESUser user = new OESUser();
		user.setUsername(username);
		user.setPassword(password);

		// check for valid user, return user_Obj if there is valid username / password
		user = OESUersDAO.login(user);

		try {

			if (user != null) { // Successful login
				String role = user.getProfile().toLowerCase();
				
				HttpSession session = request.getSession(true); 
				session.setAttribute("currentSessionUser", user);
//				session.setAttribute("sessionUserId", user);
				out.println(user.getProfile());

				if (rememberme.equals("rememberMe")) {
					Cookie cookUserName = new Cookie("cookUserName", user.getUsername());
					Cookie cookPassword = new Cookie("cookPassword", user.getPassword());
					Cookie cookRemember = new Cookie("cookremember", rememberme);

					// cookies valid 2 days
					int duration = 60 * 60 * 24 * 2;
					cookUserName.setMaxAge(duration);
					cookPassword.setMaxAge(duration);
					cookRemember.setMaxAge(duration);

					response.addCookie(cookUserName);
					response.addCookie(cookPassword);
					response.addCookie(cookRemember);

					System.out.println("cookies set ");
				}
				
//				out.println(user.getProfile());
				
				if (role.equals("student")) {
					out.println(user.getProfile());
					RequestDispatcher r = request.getRequestDispatcher("studentHomeServlet");
					out.print("log in sucess");
					r.forward(request, response);
				} else if ((role.trim()).equals("teacher")) {
					out.print("tech in");
					RequestDispatcher r = request.getRequestDispatcher("teacherHome.jsp");
					r.forward(request, response);
				}
			} else { // wrong username / pass
				RequestDispatcher r = request.getRequestDispatcher("login.jsp");

				request.setAttribute("message", "UserName / Password is not Correct. ");
				request.setAttribute("tempUser", username);
				r.forward(request, response);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
