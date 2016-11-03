package crud_operations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static final String oraUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	static final String oraUser = "hr";
	static final String oraPwd = "hr";
	
	private static String mySqlUser = "root";
	private static String mySqlPwd = "199421ab";
	private static String mySqlUrl = "jdbc:mysql://localhost:3306/world";
	//potluck (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,  name VARCHAR(20), food VARCHAR(30), confirmed CHAR(1),  signup_date DATE);
	
	public static Connection getConnection(DBType dbType) throws SQLException{
		switch(dbType){
		case ORADB:
			return DriverManager.getConnection(oraUrl,oraUser,oraPwd);
		case MYSQLDB:
			return DriverManager.getConnection(mySqlUrl,mySqlUser,mySqlPwd);
			
		default:
			return null;
		
		}
	}
	
	public static void showErrorMessage(SQLException e){
		System.err.println("Error: " + e.getMessage());
		System.err.println("Error Code: " + e.getErrorCode());
	}
}
