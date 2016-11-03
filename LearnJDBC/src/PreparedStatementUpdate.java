import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementUpdate {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn = DBUtil.getConnection(DBType.ORADB);
		
		String sql = "UPDATE NewEmployees SET Salary = ? WHERE Employee_id = ?";
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Employee id: ");
		int empno = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Enter new salary: ");
		double salary = scanner.nextDouble();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setDouble(1, salary);
		pstmt.setInt(2, empno);
		
		int result = pstmt.executeUpdate();
		if(result == 1){
			System.out.println("Salary Updated Successfully!");
		}else{
			System.out.println("Error while updating the salary");
		}
		scanner.close();
		pstmt.close();
		conn.close();

	}

}
