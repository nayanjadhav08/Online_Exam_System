package com.vwits.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.vwits.model.OESUser;
import com.vwits.model.*;

public class OESUersDAO {

	MyDbConnection db = new MyDbConnection();
//	Connection con = db.getConnection() ;

	public static OESUser login(OESUser user)
	{
		try {
			
			MyDbConnection db = new MyDbConnection() ;
			
			String sqlQuery = "select * from OESUSER where username=? and password=?"; 
			PreparedStatement pt = db.getPreparedStatement(sqlQuery) ;
			
			pt.setString(1, user.getUsername());
			pt.setString(2, user.getPassword());
			
			ResultSet result = pt.executeQuery() ;
			
			if(result.next())
			{ //Successful login 
				user.setId(result.getInt(1));
				user.setFirstname(result.getString(2));
				user.setLastname(result.getString(3));
				user.setUsername(result.getString(4));
				user.setPassword(result.getString(5));
				user.setProfile(result.getString(6));
				user.setReg_date(result.getString(7));
				
				System.out.println(user.getUsername()+"   "+user.getProfile());
				
				return user ;
			}
			else
			{
				return null ; 
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	
	public static boolean saveUser(OESUser user) {
		
		MyDbConnection db = new MyDbConnection() ;
		//id is autoincrement
		String sql = "INSERT INTO OESUser( firstName ,lastName , userName , password , profile ) values( ?, ?, ?, ?, ?)" ;
		PreparedStatement ps = db.getPreparedStatement(sql);
//		boolean status = false ;
		try {
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getProfile());
			
			ps.execute();
			
			db.closeConnection();
			return true ;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return false ;
	}
	
	
	public List<OESUser> getAll() {
		List<OESUser> list = new ArrayList<OESUser>();
		Statement st = db.getStatement();

		try {
			ResultSet rs = st.executeQuery("Select * from OESuser");
			while (rs.next()) {
				list.add(new OESUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7) ));
			}
			db.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
}
