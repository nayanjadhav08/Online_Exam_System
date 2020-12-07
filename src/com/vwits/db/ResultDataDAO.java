package com.vwits.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vwits.model.Exam;
import com.vwits.model.Result_Data;

public class ResultDataDAO {
	
	public static boolean addResult(Result_Data resulData)
	{
		MyDbConnection db = new MyDbConnection() ;
		
		//get max id 
		Statement st = db.getStatement() ; 
		int maxId = 0 ; 
		try {
			ResultSet res = st.executeQuery("select max(id) from result_data") ;
			res.next() ;
			maxId = res.getInt(1) ;
//			System.out.println("maxid : "+ maxId);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sqlQuery = "INSERT INTO result_data values(?, ?, ?, ? , ? )" ;
		PreparedStatement pt = db.getPreparedStatement(sqlQuery) ;
		
		try {
			pt.setInt(1, maxId+1 );
			pt.setInt(2, resulData.getUserId());
			pt.setInt(3, resulData.getObtainedMarks());
			pt.setInt(4, resulData.getTotalMarks());
			pt.setInt(5, resulData.getExamId());
			
			pt.execute() ;
			
			db.closeConnection();
			
			return true ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false ;
	}
	
	public static List<Result_Data> getAllResults()
	{
		MyDbConnection db = new MyDbConnection() ;
		
		List<Result_Data>list = new ArrayList<Result_Data>() ;
		
		Statement st = db.getStatement() ;
		
		String sqlQuery = "SELECT * FROM  result_data" ;
		
		try {
			
			ResultSet result = st.executeQuery(sqlQuery) ;
			
			while(result.next())
			{  // int id, int userId, int obtainedMarks, int totalMarks, int examId) {
				list.add(new Result_Data(result.getInt(1), result.getInt(2), result.getInt(3), result.getInt(4), result.getInt(5))) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list ;
	}
}
