import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementRemove {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		
		Connection conn = DBUtil.getConnection(DBType.ORADB);
		
		String sql = "DELETE FROM NewEmployees WHERE Employee_id = ?";
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Employee id: ");
		int empno = scanner.nextInt();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setDouble(1, empno);
		int result = pstmt.executeUpdate();
		if(result == 1){
			System.out.println("Delete Successfully!");
		}else{
			System.out.println("Error while deleting");
		}
		scanner.close();
		pstmt.close();
		conn.close();
	}

}
