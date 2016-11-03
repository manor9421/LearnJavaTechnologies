package com.mnr.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDataManager {

	/**
	 * Insert new user data to MySQL database through transaction.
	 * It inform us in console about start of executing and commit.
	 * 
	 * @param name - name of new user
	 * @param email - email of new user
	 * @param age - age of new user
	 * @return true if user adeed succesfully to database
	 */
	public static boolean inserMySqlData(String name, String email, int age){
		
		// if email is bad
		if(ValidateParams.validEmail(email)==false && name.isEmpty() && age <= 0){
			return false;
		}
		
		String sql = "INSERT INTO `users`(`user_name`,`user_email`,`user_age`) VALUES(?,?,?)";
		
		try(
			Connection conn = DBUtil.getConnection(DBType.MYSQL);
			PreparedStatement stmt = conn.prepareStatement(sql);	
		){

			conn.setAutoCommit(false);
			
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setInt(3, age);
			
			int result = stmt.executeUpdate();
			
			if(result == 1){
				System.out.println("Wait for commit...");
			}
			
			conn.commit();

			System.out.println("Commit. Added to MySql");
			
			return true;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Insert new user data to SQLite database through transaction.
	 * It inform us in console about start of executing and commit.
	 * 
	 * @param name - name of new user
	 * @param email - email of new user
	 * @param age - age of new user
	 * @return true if user adeed succesfully to database
	 */
	public static boolean inserSqliteData(String name, String email, int age){
		
		// if email is bad
		if(ValidateParams.validEmail(email)==false && name.isEmpty() && age <= 0){
			return false;
		}
		
		String sql = "INSERT INTO `users`(`user_name`,`user_email`,`user_age`) VALUES(?,?,?)";
		
		try(
			Connection connection = DBUtil.getConnection(DBType.SQLITE);
			PreparedStatement stmt = connection.prepareStatement(sql);
		){
			connection.setAutoCommit(false);
			
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setInt(3, age);
			
			int result = stmt.executeUpdate();
			
			if(result == 1){
				System.out.println("Wait for commit...");
			}
			
			connection.commit();
			
			System.out.println("Commit. Added to Sqlite");

			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}
	
}
