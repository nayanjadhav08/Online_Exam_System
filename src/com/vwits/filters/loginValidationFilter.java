package com.vwits.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class loginValidationFilter
 */
@WebFilter("/UserLoginServlet")
public class loginValidationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public loginValidationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.length() == 0 || password.length() ==0)
		{//error 
			request.setAttribute("message", "Field are empty, Enter valid data");
			
			RequestDispatcher r = request.getRequestDispatcher("login.jsp") ;
			
			r.forward(request, response);
			
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
