import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestStaticSQLStatement {

	
	
	
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// conn = DriverManager.getConnection(dbUrl,username,password);

			conn = DBUtil.getConnection(DBType.MYSQLDB);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * from potluck");
			rs.last();
			
			System.out.println("Total Rows: " + rs.getRow());
			
		} catch (SQLException e) {
			DBUtil.showErrorMessage(e);
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(stmt !=null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}
	}

}
