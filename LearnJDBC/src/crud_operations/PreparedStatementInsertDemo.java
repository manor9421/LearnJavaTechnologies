package crud_operations;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementInsertDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn = DBUtil.getConnection(DBType.ORADB);
		
		int empno;
		String ename,email;
		java.sql.Date hiredate;
		double salary;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter id: ");
		empno = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Enter name: ");
		ename = scanner.nextLine();
		
		System.out.println("Enter email: ");
		email = scanner.nextLine();
		

		System.out.println("Enter date: ");
		hiredate = java.sql.Date.valueOf(scanner.nextLine());

		System.out.println("Enter salary: ");
		salary = scanner.nextDouble();
		
		String sql = "INSERT INTO NewEmployees VALUES(?,?,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, empno);
		pstmt.setString(2, ename);
		pstmt.setString(3, email);
		pstmt.setDate(4, hiredate);
		pstmt.setDouble(5, salary);
		
		int result = pstmt.executeUpdate();
		if(result == 1){
			System.out.println("Record Inserted Successfully!");
		}else{
			System.out.println("Error while adding the record");
			
		}
		
		scanner.close();
		pstmt.close();
		conn.close();
	}

}
