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

import com.vwits.db.ResultDataDAO;
import com.vwits.model.OESUser;
import com.vwits.model.Question;
import com.vwits.model.Result_Data;


@WebServlet("/submitTestServlet")
public class submitTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public submitTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

//    public boolean storeResult()
//    {
//    	return "" ;
//    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter() ;
		response.setContentType("text.html");
		
		//### Test
//		
//		out.println(request.getParameter("1_option"));
//		out.println(request.getParameter("2_option"));
//		out.println(request.getParameter("3_option"));
//		out.println(request.getParameter("4_option"));
		
		HttpSession httpsession = request.getSession(false) ;
		
		if(httpsession!= null)
		{	
			@SuppressWarnings("unchecked")
			List <Question> questionBank = (List<Question>)httpsession.getAttribute("currentQuestionBank") ;
			
			if(questionBank !=null)
			{	//out.println("bank size : "+ questionBank.size()); 
				int totalScore= 0 ;
				int maxMarks = 0 ;
				for(int i=1 ;i<=questionBank.size() ; i++)
				{	//out.println("in seesiion : "+ i );
					
					String tagOption =i+"_option" ;
					String selectedchoice = request.getParameter(tagOption) ;
					int intselectedChoice = 0 ; 
					if(selectedchoice!=null) {
					   intselectedChoice = Integer.valueOf(selectedchoice) ;
					}
					else
						intselectedChoice = 5 ; // not selected is wronge
					Question que = questionBank.get(i-1) ; 
					
					maxMarks += que.getMark() ;
					if(que.getCorrectOp() == intselectedChoice )
					{
//						out.println("Ueqstion :  "+i+"is correct");
						totalScore += que.getMark() ;		
					}
				}
				out.println("total marks scored : "+totalScore) ;
				
				
				//store result
				OESUser user = (OESUser)httpsession.getAttribute("currentSessionUser") ;
				int examCode = questionBank.get(0).getExamcode() ;
				Result_Data result = new Result_Data(user.getId(), totalScore , maxMarks , examCode );
				
				ResultDataDAO.addResult(result) ;
				String finalResult = totalScore + "/" + maxMarks ;
				
				RequestDispatcher r = request.getRequestDispatcher("showResult.jsp") ;
				
				request.setAttribute("totalScore", finalResult );
				
				r.forward(request, response);
			}
			else
			{
				response.setContentType("text/html");
				out.println("Something went Wrong, Please Contact Admin and Re-Login <a href='login.jsp'>Click Here</a><h5>");
				
			}
		
			
		}
		else
		{
			out.println("<h5>Session Expired, Please Re-Login <a href='login.jsp'>Click Here</a><h5>");			
//				response.sendRedirect("login.jsp");
							 
		}


		
		
	}

}
