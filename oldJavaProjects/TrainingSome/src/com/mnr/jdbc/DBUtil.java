package com.mnr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	static final String mySqlUser = "jdbc_user";
	static final String mySqlPwd = "1234";
	static final String mySqlUrl = "jdbc:mysql://localhost:3306";
	static final String mySqlDB = "/jdbc_work";
	
	static final String sqLiteUrl = "jdbc:sqlite:trythat.db";// in resources folder
	
	
	public static Connection getConnection(DBType dbType) throws SQLException{
		
		switch (dbType) {
		case MYSQL:
			return DriverManager.getConnection(mySqlUrl+mySqlDB,mySqlUser,mySqlPwd);
		case SQLITE:
			try{
				
				Class.forName("org.sqlite.JDBC");
				return DriverManager.getConnection("jdbc:sqlite::resource:trythat.db");
				
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
		default:
			return null;
		}
		
	}
	

}
