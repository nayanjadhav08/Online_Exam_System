package com.vwits.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vwits.model.Question;

public class QuestionDAO {

	MyDbConnection db ;
	
	public QuestionDAO() {
	  db = new MyDbConnection();
	}
	
	public static void saveQuestion(Question question)
	{
		String sqlQuery = "INSERT INTO Question_Bank values(?,?,?,?,?,?,?,?,? )" ;
		
		MyDbConnection db = new MyDbConnection() ;
		
		//get max id 
		int maxId = 0 ; 
		try {
			Statement st = db.getStatement() ;
			ResultSet res = st.executeQuery("select max(id) from Question_Bank") ;
			res.next() ;
			maxId = res.getInt(1) ;
//			System.out.println("maxid : "+ maxId);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		PreparedStatement pt = db.getPreparedStatement(sqlQuery) ;
		
		try {
			pt.setInt(1, maxId+1);
			pt.setString(2, question.getQuestion());
			pt.setString(3, question.getOption1());
			pt.setString(4, question.getOption2());
			pt.setString(5, question.getOption3());
			pt.setString(6, question.getOption4());
			pt.setInt(7, question.getCorrectOp());
			pt.setInt(8, question.getMark());
			pt.setInt(9, question.getExamcode()); 
			
			pt.execute() ;
			
			db.closeConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static List<Question> getQuestionBank(int examid)
	{
		List<Question> list = new ArrayList<Question>() ;
	
		MyDbConnection db = new MyDbConnection() ;
		Statement st = db.getStatement() ;
		
		String sqlQuery = "SELECT * FROM question_bank where examcode ="+examid ; 
		
		try {
			ResultSet result = st.executeQuery(sqlQuery) ;
			
			while(result.next())
			{	
				list.add(new Question(result.getInt(1), result.getString(2),  result.getString(3),  result.getString(4),  result.getString(5),  result.getString(6), result.getInt(7), result.getInt(8), result.getInt(9))) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		db.closeConnection();
		
		return list;
	}
	
	public static List<Question> getAllQuestionBank()
	{
		List<Question> list = new ArrayList<Question>() ;
	
		MyDbConnection db = new MyDbConnection() ;
		Statement st = db.getStatement() ;
		
		String sqlQuery = "SELECT * FROM question_bank" ; 
		
		try {
			ResultSet result = st.executeQuery(sqlQuery) ;
			
			while(result.next())
			{	
				list.add(new Question(result.getInt(1), result.getString(2),  result.getString(3),  result.getString(4),  result.getString(5),  result.getString(6), result.getInt(7), result.getInt(8), result.getInt(9))) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		db.closeConnection();
		
		return list;
	}
	
	
}
