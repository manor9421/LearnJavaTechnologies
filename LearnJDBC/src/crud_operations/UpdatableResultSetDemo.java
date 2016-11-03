package crud_operations;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatableResultSetDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		try(
				Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
				
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				
				ResultSet rs = stmt.executeQuery("SELECT id, name, food, confirmed, signup_date from potluck")
				)
		{
			rs.absolute(2);
			
			rs.updateString("name", "Barbara");// изменяем строку
			rs.updateRow();// применяем изменения к БД
			
			System.out.println("Record Updated Successfully");
			
			// добавляем поле
			rs.moveToInsertRow();
			rs.updateString("name", "Rob");
			rs.updateString("food", "chicken");
			rs.updateString("confirmed", "N");
			rs.updateDate("signup_date", null);
			rs.insertRow();// добавляем
			System.out.println("Insert Successfully");
		}
				
		
		
		
	}

}
