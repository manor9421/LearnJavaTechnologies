package com.mnr.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mnr.beans.Book;

public class DBConnection {

	//private Connection connection;
	
	public DBConnection(/*Connection connection*/){
		//this.connection = connection;
	}
	
	public Connection getConnection(){
		String mySqlUser = "root";
		String mySqlPwd = "111";
		String mySqlUrl = "jdbc:mysql://localhost:3306/workers";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			return DriverManager.getConnection(mySqlUrl,mySqlUser,mySqlPwd);
		}catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			return null;
		}
	}
	
	public Book[] findBooks(Connection connection){

		String sql = "SELECT `id`,`name`,`price`,`author` FROM `books`";
		
		try(
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
			){
			
			rs.last();
			Book[] books = new Book[rs.getRow()];
			
			rs.beforeFirst();
			int i = 0;
			while(rs.next()){
				books[i] = new Book(rs.getInt("id"),rs.getString("name"),
						rs.getString("author"), rs.getDouble("price"));
				i++;
			}
			
			return books;
			
		}catch (SQLException e) {
			// TODO: handle exception
			return null;
		}
		
		
	}
	
	public Book findBook(Connection connection, String name){
		
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		try{
			String sql = "SELECT `id`,`name`,`price`,`author` FROM `books` WHERE `name`=?";
			
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, name);
			
			rs = stmt.executeQuery();
			Book book = null;
			rs.first();
			//while(rs.next()){
				book = new Book(rs.getInt("id"),rs.getString("name"),
						rs.getString("author"), rs.getDouble("price"));
			//}
			return book;
		}catch (SQLException e) {
			return null;
		}
		
	}
	
	public boolean addNewBook(Connection connection, String name, double price, String author){
		
		String sql = "INSERT INTO books(`name`,`price`,`author`) VALUES(?,?,?)";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
		
			pstmt.setString(1, name);
			pstmt.setDouble(2, price);
			pstmt.setString(3, author);
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			
			if(result == 1){
				return true;
			}else{
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean checkUserData(Connection connection, String username, String password){
		
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		try{
			String sql = "SELECT `login`,`password` FROM `users` WHERE `login`=? AND `password`=?";
			
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			rs = stmt.executeQuery();
			
			rs.first();
			
			if(rs.getString("login").equals(username) && rs.getString("password").equals(password)){
				return true;
			}
			
			return false;
		}catch (SQLException e) {
			return false;
		}
		
	}
	
	
	public boolean addNewUser(Connection connection, String username, String password){
		
		String query = "INSERT INTO users(`login`,`password`) VALUES(?,?)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, username);
			statement.setString(2, password);
			
			int result = statement.executeUpdate();
			if(result == 1){
				return true;
			}else{
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean checkUserExist(Connection connection, String name){
		
		String sql = "SELECT `id` FROM `users` WHERE `login`=?";
		
		try {
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, name);
			
			ResultSet resultSet = statement.executeQuery();
			
			resultSet.first();
			if(resultSet.getRow() > 0){
				return true;
			}else{
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	
	
	
}

/*
CREATE TABLE books(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
price DECIMAL(10) NOT NULL,
author VARCHAR(100) DEFAULT '',
PRIMARY KEY ( id )
);

INSERT INTO books (`name`,`price`,`author`) VALUES ('TheBook13',100,'John');
*/
