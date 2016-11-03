package com.mnr.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.swing.OverlayLayout;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;

/**
 * Servlet implementation class ConnectMySQL
 */
@WebServlet("/ConnectMySQL")
public class DatasourceDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DataSource ds;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatasourceDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	try {
			InitialContext initialContext = new InitialContext();
			
			Context env = (Context) initialContext.lookup("java:comp/env");
			
			env.lookup("jdbc/webshop");
			
			ds = (DataSource) env.lookup("jdbc/webshop");
			/*
			Метод lookup собственно ищет объект с определенным именем. Если такого обьекта не будет - выбросит исключение
			*/
		} catch (NamingException e) {
			throw new ServletException();
		}
    	
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection = null;
		
		try {
			connection = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//use connection
		PrintWriter out = response.getWriter();
		
		out.println("Connected to db");
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
/*
Желательно настроить (jndi) файл context.xml и web.xml файл

https://tomcat.apache.org/tomcat-9.0-doc/jndi-resources-howto.html#context.xml_configuration
*/