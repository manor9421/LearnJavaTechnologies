package metadata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import crud_operations.DBType;
import crud_operations.DBUtil;

public class ResultSetMetadataDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(
			Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * FROM Employees");
		){
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int columnCount = rsmd.getColumnCount();
			
			String format = "%-50s%-25s%-20s%-20s\n";
			System.out.format(format, "Column Name","Column Type","Is Nullable","Is AutoIncrement");
			System.out.format(format, "-----------","-----------","-----------","----------------");
			for(int i=1;i<=columnCount;i++){
				System.out.format(format,rsmd.getColumnName(i),rsmd.getColumnType(i),rsmd.isNullable(i),rsmd.isAutoIncrement(i));	
			}
			
			System.out.println("Total Columns: " + columnCount);
		}catch (SQLException e) {
			DBUtil.showErrorMessage(e);
		}

	}

}
