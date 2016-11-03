package crud_operations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestMySQL {

	
	
	
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			// conn = DriverManager.getConnection(dbUrl,username,password);

			conn = DBUtil.getConnection(DBType.MYSQLDB);
			
			System.out.println("mySQL connection success");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			DBUtil.showErrorMessage(e);
		}
		finally{
			conn.close();
		}
		
	}

}
