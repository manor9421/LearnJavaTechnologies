import java.sql.Connection;

import com.mnr.beans.Book;
import com.mnr.database.DBConnection;

public class M1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DBConnection dbConnection = new DBConnection();
		
		Connection connection = dbConnection.getConnection();
		if(connection == null){
			System.out.println("fail1");
		}
		Book b1 = dbConnection.findBook(connection, "TheBook13");
		if(b1==null){
			System.out.println("fail...");
		}else{
			System.out.println(b1.getName());
		}
		
		Book[] b2 = dbConnection.findBooks(connection);
		if(b2==null){
			System.out.println("fail");
		}else{
			for(Book b: b2){
				System.out.println(b.getName() + " " + b.getAuthor() + " " + 
						b.getPrice() + ",id: " + b.getId());
			}
			
		}
		
		/*boolean res = dbConnection.addNewBook(connection, "Good life", 17.42, "Bill");
		if(res){
			System.out.println("OK");
		}else{
			System.out.println("No");
		}*/
		
		
	}

}
