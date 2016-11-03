import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestOracle {


	static final String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	static final String username = "hr";
	static final String pass = "hr";
	
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		System.out.println("Hello");
		System.out.println();
		
		Connection conn = DriverManager.getConnection(dbUrl,username,pass);
		System.out.println("OK");
		
	}

}
