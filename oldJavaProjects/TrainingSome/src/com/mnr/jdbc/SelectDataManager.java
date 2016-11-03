package com.mnr.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Class consists static methods for Selecting data from databases
 * 
 * @author gdx
 * @version 1.0
 */
public class SelectDataManager {

	/**
	 * Select data of user from MySQL database by name
	 * and write every user's email and age to console.
	 * Then write total count of found users to console
	 * 
	 * @param name - name of selecting user
	 * @return true if all data selected successfully
	 */
	public static boolean selectMySqlData(String name){
		
		// if email is bad
		if( name.isEmpty() ){
			return false;
		}
		
		String sql = "SELECT * FROM users WHERE user_name=?";
		
		ResultSet rSet = null;
		try(
			Connection conn = DBUtil.getConnection(DBType.MYSQL);
			PreparedStatement stmt = conn.prepareStatement(sql);
		){
			stmt.setString(1, name);
			
			rSet = stmt.executeQuery();
			
			while(rSet.next()){
				String userInfo = rSet.getRow() + " user is: " + rSet.getString("user_name")
					+ ", email: " + rSet.getString("user_email")
					+ ", age: " + rSet.getString("user_age");
				System.out.println(userInfo);
			}
			
			rSet.last();
			System.out.println("Total names: " + rSet.getRow());
			
			return true;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	/**
	 * Select data of user from SQLite database by name
	 * and write every user's email and age to console.
	 * Then write total count of found users to console
	 * 
	 * @param name - name of selecting user
	 * @return true if all data selected successfully
	 */
	public static boolean selectSqliteData(String name){
		
		String sql = "SELECT * FROM users WHERE user_name=?";
		
		ResultSet rSet = null;
		try(
			Connection connection = DBUtil.getConnection(DBType.SQLITE);
			PreparedStatement stmt = connection.prepareStatement(sql);
		){
			
			stmt.setString(1, name);
			
			rSet = stmt.executeQuery();
			int num = 0;
			
			while(rSet.next()){
				num++;
				String userInfo = num + " user is: " + rSet.getString("user_name")
					+ ", email: " + rSet.getString("user_email")
					+ ", age: " + rSet.getString("user_age");
				System.out.println(userInfo);
			}
			
			System.out.println("Total names: " + num);
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
}
