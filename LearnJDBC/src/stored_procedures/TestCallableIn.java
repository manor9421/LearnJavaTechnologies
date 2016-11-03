package stored_procedures;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import crud_operations.DBType;
import crud_operations.DBUtil;

//подготавливаем запрос
public class TestCallableIn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(
				Connection connection = DBUtil.getConnection(DBType.ORADB);
				CallableStatement callableStatement = connection.prepareCall("{call AddNewEmployee(?,?,?,?,?)}");
				
				)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter id: ");
			int empno = Integer.parseInt(scanner.nextLine());
			System.out.println("Enter name: ");
			String ename = scanner.nextLine();
			System.out.println("Enter email: ");
			String email = scanner.nextLine();
			System.out.println("Enter date: ");
			Date odj = java.sql.Date.valueOf(scanner.nextLine());
			System.out.println("Enter salary: ");
			double salary = scanner.nextDouble();
			
			callableStatement.setInt(1, empno);
			callableStatement.setString(2, ename);
			callableStatement.setString(3, email);
			callableStatement.setDate(4, odj);
			callableStatement.setDouble(5, salary);
			
			callableStatement.execute();
			
			System.out.println("Employee Record Added Successfully.");
			
		}
		catch (SQLException e) {
			DBUtil.showErrorMessage(e);
		}
	}

}
