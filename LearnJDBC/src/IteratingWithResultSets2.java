import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IteratingWithResultSets2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// если создавать ресурсы в try, то можно не закрывать потом в файнэли. они сами
		try{
			Connection conn = DBUtil.getConnection(DBType.ORADB);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Employees");
			
			String format = "%-4s%-20s%-25s%-10f\n";
			while(rs.next()){
				System.out.format(format, rs.getString("Employee_ID"),rs.getString("First_Name"),rs.getString("Last_Name"),rs.getString("Salary"));
				
			}
			
		}catch(SQLException e){
			DBUtil.showErrorMessage(e);
		}
	}

}
