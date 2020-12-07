package com.vwits.db;

import com.vwits.model.Exam;
import com.vwits.model.Result_Data;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		QuestionDAO questions = new QuestionDAO() ;
//		OESUersDAO users = new OESUersDAO() ;
//		ExamDAO exam = new ExamDAO() ; 
////		System.out.println(users.getAll());
//		Exam exam2 = new Exam(2, "Test_2", 20 , 2 ) ;
//		
//		exam.addExam(exam2);
//		System.out.println(exam.getAllExams());
		
		ResultDataDAO res = new ResultDataDAO() ;
		
		Result_Data result = new Result_Data(1 , 1 , 30 , 50 , 1 ) ; 
		
		res.addResult(result) ;
		System.out.println(res.getAllResults()); 
	}

}
