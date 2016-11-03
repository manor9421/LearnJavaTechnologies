package BLOB_CLOB;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import crud_operations.DBType;
import crud_operations.DBUtil;

public class RetrieveCLOBDataFromDB {

	public static void main(String[] args) throws SQLException, IOException{
		// TODO Auto-generated method stub

		Connection conn = DBUtil.getConnection(DBType.ORADB);
		String sql = "Select Resume From NewEmployees WHERE Employee_ID = 500";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			Clob resume = rs.getClob("Resume");
			Reader data = resume.getCharacterStream();
			
			int i;
			String resumeDetails = "";
			while( (i=data.read()) != -1 ){
				resumeDetails += ((char) i);
			}
			System.out.println("Resume Details from Employee 500");
			System.out.println(resumeDetails);
		}else{
			System.err.println("No Record Found For Employee With The ID 500.");
		}
		
		rs.close();
		pstmt.close();
		conn.close();
	}

}
