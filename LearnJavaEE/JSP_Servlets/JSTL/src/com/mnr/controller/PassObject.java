package com.mnr.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mnr.beans.User;

/**
 * Servlet implementation class PassObject
 */
@WebServlet("/PassObject")
public class PassObject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassObject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user1 = new User("Bob", 1);
		User user2 = new User("Mike", 2);
		User user3 = new User("Sue", 3);
		
		request.setAttribute("user1", user1);// будет видно только при реквесте

		HttpSession session = request.getSession();
		session.setAttribute("user2", user2);
		
		ServletContext context = getServletContext();
		context.setAttribute("user3", user3);
		
		Map<String, String> map = new HashMap<>();
		map.put("fruit","Apple");
		request.setAttribute("map1", map);
		

		request.setAttribute("link", "<a href='something.com'>Click</a>");
		
		
		
		request.getRequestDispatcher("/receiveObject.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
