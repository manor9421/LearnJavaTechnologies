package stored_procedures;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import crud_operations.DBType;
import crud_operations.DBUtil;
import oracle.jdbc.internal.OracleTypes;
import oracle.jdbc.oracore.OracleType;
import oracle.jdbc.util.RepConversion;

/*

Create or Replace Procedure GetEmployeesByRefCursor
(
p_deptno in Employees.Department_ID%Type,
p_recordSet out SYS_REFCURSOR
)
as
Begin
OPEN p_recordSet FOR
Select Employee_ID, First_Name || Last_Name as Employee_Name,
Email,Salary From Employees
Where Department_Id = p_deptno
Order By Employee_ID;
End;
/

*/

public class TestCallableResultSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(
				Connection conn = DBUtil.getConnection(DBType.ORADB);
				// вызываем метод из базы
				CallableStatement callableStatement = conn
						.prepareCall("{ call GetEmployeesByRefCursor(?,?) }");
				Scanner scanner = new Scanner(System.in);
			){
			System.out.println("Enter Department ID: ");
			int deptno = Integer.parseInt(scanner.nextLine());
			
			callableStatement.setInt(1, deptno);
			
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);// for ORACLE DB
			callableStatement.execute();
			
			ResultSet resultSet = ((oracle.jdbc.OracleCallableStatement) callableStatement).getCursor(2);
			
			String format = "%-4s%-50s%-25s%-10f\n";
			
			while(resultSet.next()){
				System.out.format(format,resultSet.getString("Employee_ID"),resultSet.getString("Employee_Name"),
						resultSet.getString("Email"),resultSet.getFloat("Salary"));
			}
			
			
		}catch (SQLException e) {
			DBUtil.showErrorMessage(e);
		}
		
	}

}
