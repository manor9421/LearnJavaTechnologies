import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatementRetrieveDemo {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		
		Connection conn = null;
		
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		try{
			conn = DBUtil.getConnection(DBType.MYSQLDB);
			
			String sql = "SELECT * FROM potluck WHERE id > ? AND NAME = ?";
			
			stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			

			stmt.setInt(1,2);// вместо ? номер 1
			stmt.setString(2,"Billy");// вместо ? номер 2
			rs = stmt.executeQuery();
			String format = "%-4s\n";
			while(rs.next()){
				System.out.format(format, rs.getString("name"));
			}
			//узнаем кол-во строк
			rs.last();
			System.out.println("Total names: "+rs.getRow());
			
		}catch(SQLException e){
			DBUtil.showErrorMessage(e);
		}

	}

}
