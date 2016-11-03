package metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import crud_operations.DBType;
import crud_operations.DBUtil;

public class DatabaseMetadataDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection conn = DBUtil.getConnection(DBType.MYSQLDB);){
			
			DatabaseMetaData dbmd = conn.getMetaData();
			
			System.out.println("Driver Name: " + dbmd.getDriverName());
			System.out.println("Driver Version: " + dbmd.getDriverVersion());
			System.out.println("Logged In User: " + dbmd.getUserName());
			System.out.println("DB Product name: " + dbmd.getDatabaseProductName());
			System.out.println("DB Product Version: " + dbmd.getDatabaseProductVersion());
			
			String catalog = null;
			String schemaPattern = null;
			String tableNamePattern = null;
			String schemaTypes[] = { "TABLE" };
			ResultSet rs = dbmd.getTables(catalog, schemaPattern, tableNamePattern, schemaTypes);
			System.out.println("Tables");
			System.out.println("=================");
			while(rs.next()){
				System.out.println( rs.getString("TABLE_NAME") );
			}
			
			String columnNamePattern = null;
			rs = dbmd.getColumns(catalog, schemaPattern, "COUNTRIES", columnNamePattern);// писать только в верхнем регистре, потому что не ко всем БД подходит
			System.out.println("Column Details");
			System.out.println("=================");
			while(rs.next()){
				System.out.println( rs.getString("COLUMN_NAME"));
			}
			
			rs.close();
			
		}catch (SQLException e) {
			DBUtil.showErrorMessage(e);
		}

	}

}
