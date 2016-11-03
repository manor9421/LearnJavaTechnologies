package com.mnr.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDataManager {

	/**
	 * Update user age of user in MySQL database
	 * 
	 * @param name - name of user which needs to update
	 * @param newAge - new age of user
	 * @return true if data changed successfully
	 */
	public static boolean updateMySqlUserAge(String name, int newAge){
		
		String sql = "Update users SET user_age=? WHERE user_name=?" ;
		try(
			Connection conn = DBUtil.getConnection(DBType.MYSQL);
			PreparedStatement stmt = conn.prepareStatement(sql);
		){
			conn.setAutoCommit(false);
			stmt.setInt(1, newAge);
			stmt.setString(2, name);
			stmt.executeUpdate();
			
			conn.commit();
			
			return true;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	/**
	 * Update user age of user in SQLite database
	 * 
	 * @param name - name of user which needs to update
	 * @param newAge - new age of user
	 * @return true if data changed successfully
	 */
	public static boolean updateSqliteUserAge(String name, int newAge){
		
		String sql = "Update users SET user_age=? WHERE user_name=?" ;
		try(
			Connection conn = DBUtil.getConnection(DBType.SQLITE);
			PreparedStatement stmt = conn.prepareStatement(sql);
		){
			conn.setAutoCommit(false);
			stmt.setInt(1, newAge);
			stmt.setString(2, name);
			stmt.executeUpdate();
			
			conn.commit();
			
			return true;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
}
