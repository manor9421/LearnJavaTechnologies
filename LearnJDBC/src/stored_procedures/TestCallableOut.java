package stored_procedures;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;


import crud_operations.DBType;
import crud_operations.DBUtil;

/*
 * для начала регистрируем метод GetTotalEmployeesByDepartment в БД
Create or Replace Procedure GetTotalEmployeesByDepartment
(
deptno in Employees.Department_Id%Type,
totalEmployees out number
)
as
begin
select count(*) into totalEmployees from Employees
where Department_Id = deptno;
end;
*/
public class TestCallableOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(
				Connection conn = DBUtil.getConnection(DBType.ORADB);
				// вызываем метод из базы
				CallableStatement callableStatement = conn
						.prepareCall("{ call GetTotalEmployeesByDepartment(?,?) }");
				Scanner scanner = new Scanner(System.in);
				)
		{
			System.out.println("Enter Department ID: ");
			int deptno = Integer.parseInt(scanner.nextLine());
			
			callableStatement.setInt(1, deptno);
			
			callableStatement.registerOutParameter(2, Types.INTEGER);
			
			callableStatement.execute();
			
			int totalEmployees = callableStatement.getInt(2);
			
			System.out.println("Total Employees Working: " + totalEmployees);
			
			
			
		}catch (SQLException e) {
			DBUtil.showErrorMessage(e);
		}
		
	}

}
