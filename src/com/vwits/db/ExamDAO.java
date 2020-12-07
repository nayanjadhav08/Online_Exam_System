package com.vwits.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

import com.vwits.model.Exam;

public class ExamDAO {

	MyDbConnection db ;
	
	public ExamDAO() {
		
		db = new MyDbConnection() ;
	}
	
	public void addExam(Exam exam)
	{
		String sqlQuery = "INSERT INTO EXAMS values(?, ?, ?, ?)" ;
		PreparedStatement pt = db.getPreparedStatement(sqlQuery) ;
		
		int maxId = 0 ; 
		try {
			Statement st = db.getStatement() ;
			ResultSet res = st.executeQuery("select max(id) from EXAMS") ;
			res.next() ;
			maxId = res.getInt(1) ;
//			System.out.println("maxid : "+ maxId);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			pt.setInt(1, maxId+1);
			pt.setString(2, exam.getExamname());
			pt.setInt(3, exam.getTotalmarks());
			pt.setInt(4, maxId+1);
			
			pt.execute() ;
			
			db.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	public List<Exam> getAllExams()
	{
		List<Exam>list = new ArrayList<Exam>() ;
		
		Statement st = db.getStatement() ;
		
		String sqlQuery = "SELECT * FROM EXAMS" ;
		
		try {
			
			ResultSet result = st.executeQuery(sqlQuery) ;
			
			while(result.next())
			{
				list.add(new Exam(result.getInt(1), result.getString("examname"), result.getInt(3), result.getInt(4))) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list ;
	}
}
