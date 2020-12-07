package com.vwits.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDbConnection {

	Connection con ;
	PreparedStatement ps;
	Statement st ;
		public MyDbConnection()
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
//				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","nayan","1234");
				
			} catch (ClassNotFoundException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		public Connection openConnection() {
			try {
				
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","nayan","1234");
				System.out.println("DB Connected..");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
		}
		
//		public Connection getConnection()
//		{
//			if(con!=null)
//			{
//				return con ;
//			}
//			else
//				return this.openConnection() ;	
//		}
//		
		
		
		public PreparedStatement getPreparedStatement(String sqlQuery) {
			
			try {
				ps=this.openConnection().prepareStatement(sqlQuery);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return ps;
		}
		
		public Statement getStatement() {
			try {
				st = this.openConnection().createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return st;

		}
		
		
		
		public void closeConnection() {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
