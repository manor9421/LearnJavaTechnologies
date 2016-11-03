package com.mnr.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnr.database.DBConnection;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.sun.media.sound.DLSSoundbank;

/**
 * Servlet implementation class Connector
 */
@WebServlet("/Connector")
public class Connector extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Connector() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String action = request.getParameter("action");
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		
		if(action == null){
			
		}else if(action.equals("logout")){
			Cookie[] cookies = null;
			cookies = request.getCookies();
			if(cookies!= null){
				for(int i=0;i<cookies.length;i++){
					Cookie cookie = cookies[i];
					if(cookie.getName().equals("user")){
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
			}
		}
		request.getRequestDispatcher("/bookpage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		
		if(action == null){
			request.getRequestDispatcher("/bookpage.jsp").forward(request, response);
		}else if(action.equals("addbook")){
			
			
			String name = request.getParameter("book_name");
			String author = request.getParameter("book_author");
			String price = request.getParameter("book_price");
			
			if(checkField(name) && checkField(author) && checkField(price)){
				
				double priceValue = checkPrice(price);
				
				if(priceValue>0){
					boolean result = dbConnection.addNewBook(connection, name, priceValue, author);
					closeConnection(connection);
					if(result){
						makeBookManagingResultRequest("Book '"+name+"' successfully Added", request, response);
					}else{
						makeBookManagingResultRequest("Book adding error", request, response);
					}
				}else{
					closeConnection(connection);
					makeBookManagingResultRequest("Incorrect price", request, response);
				}
			}else{
				closeConnection(connection);
				makeBookManagingResultRequest("Fill all fields", request, response);
			}
			
		}else if(action.equals("login_user")){
			
			String username = request.getParameter("login");
			String password = request.getParameter("password");
			
			// check user
			if(dbConnection.checkUserData(connection, username, password)){

				// make cookie
				Cookie cookie = new Cookie("user", username);
				cookie.setMaxAge(300);// задаем время жизни куки
				
				response.addCookie(cookie);
				// request to bookpage;
				request.getRequestDispatcher("/bookpage.jsp").forward(request, response);
				
			}else{
				request.setAttribute("result", "Check all data");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
		}else if(action.equals("user_registration")){
			String username = request.getParameter("login");
			String password = request.getParameter("password");
			
			if(dbConnection.checkUserExist(connection, username)){
				request.setAttribute("result", "User exist");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}else{
				dbConnection.addNewUser(connection, username, password);
				request.setAttribute("result", "User created");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
			
		}
	}
	
	private void closeConnection(Connection connection){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void makeBookManagingResultRequest(String message,HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("result", message);
		request.getRequestDispatcher("/addbook.jsp").forward(request, response);
	}
	
	private static boolean checkField(String field){
		if(field == null || field.isEmpty()){
			return false;
		}else{
			return true;
		}
	}
	
	private static double checkPrice(String value){
			try{
				return Double.parseDouble(value);
			}catch(NumberFormatException e){
				e.printStackTrace();
				return 0;
			}
	}

}
