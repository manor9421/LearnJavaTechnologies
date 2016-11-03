package transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import crud_operations.DBType;
import crud_operations.DBUtil;

public class TestTransactionManagement {

	public static void main(String[] args) throws SQLException{
		
		try{
			
			Connection connection = DBUtil.getConnection(DBType.ORADB);
			connection.setAutoCommit(false);//чтобы точно не ушли данные до подтверждения всех операций
			
			PreparedStatement pstmt = null;
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("PSBank Transactions");
			System.out.println("-----------------");
			System.out.print("Enter From Account # : ");
			int fromAcno = Integer.parseInt(scanner.nextLine());
			System.out.print("Enter To Account # : ");
			int toAcno = Integer.parseInt(scanner.nextLine());
			System.out.print("Enter Amount to Transfer: ");
			double amount = Double.parseDouble(scanner.nextLine());
			
			String withdrawSQL = "Update PSBank set Amount = Amount - ? WHERE Acno = ?";
			pstmt = connection.prepareStatement(withdrawSQL);
			pstmt.setDouble(1, amount);
			pstmt.setInt(2, fromAcno);
			pstmt.executeUpdate();
			
			String depositSQL = "Update PSBank set Amount = Amount + ? WHERE Acno = ?";
			pstmt = connection.prepareStatement(depositSQL);
			pstmt.setDouble(1, amount);
			pstmt.setInt(2, toAcno);
			pstmt.executeUpdate();
			
			String sql = "Select Amount FROM PSBank WHERE Acno = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, fromAcno);
			ResultSet resultSet = pstmt.executeQuery();
			double balanceAmount = 0;
			if(resultSet.next()){
				balanceAmount = resultSet.getDouble("Amount");
			}
			
			if(balanceAmount >= 5000){
				connection.commit();
				System.out.println("Amount Transferred Successfully...");
			}else{
				connection.rollback();
				System.out.println("Insufficient Funds: " + balanceAmount + " Transaction Rollbacked...");
			}
			
			scanner.close();
			pstmt.close();
			connection.close();
			
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

}
