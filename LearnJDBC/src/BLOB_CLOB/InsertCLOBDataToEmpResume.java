package BLOB_CLOB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import crud_operations.DBType;
import crud_operations.DBUtil;

/*
В MySQL вместо CLOB - LongText
*/
public class InsertCLOBDataToEmpResume {

	public static void main(String[] args) throws SQLException, FileNotFoundException{
		// TODO Auto-generated method stub

		Connection conn = DBUtil.getConnection(DBType.ORADB);
		PreparedStatement pstmt = null;
		
		String sql = "Update NewEmployees set Resume = ? WHERE Employee_ID = 500";
		pstmt = conn.prepareStatement(sql);
		
		String resumeFile = "d:/Abc/file.txt";
		File file = new File(resumeFile);
		FileReader reader = new FileReader(file);
		
		pstmt.setCharacterStream(1, reader, (int)file.length());
		
		pstmt.executeUpdate();
		
		System.out.println("Resume Updated Successfully...");
		pstmt.close();
		conn.close();
	}

}
