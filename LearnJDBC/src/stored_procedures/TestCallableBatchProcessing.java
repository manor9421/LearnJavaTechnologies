package stored_procedures;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import crud_operations.DBType;
import crud_operations.DBUtil;


// сразу несколько записей(естественно, что это более затратно, чем одна)
public class TestCallableBatchProcessing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(
				Connection connection = DBUtil.getConnection(DBType.ORADB);
				CallableStatement callableStatement = connection.prepareCall("{call AddNewEmployee(?,?,?,?,?)}");
				
				)
		{
			String option;
			do{
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
				
				callableStatement.addBatch();
				
				System.out.println("Do you want to add Another Record(yes/no)? ");
				option = scanner.nextLine();
			}while( option.equals("yes"));
			
			int[] updateCounts = callableStatement.executeBatch();
			callableStatement.execute();
			
			System.out.println("Total records inserted are: " + updateCounts.length);
			
		}
		catch (SQLException e) {
			DBUtil.showErrorMessage(e);
		}
		
	}

}
