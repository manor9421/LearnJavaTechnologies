package com.mnr.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookies
 */
@WebServlet("/Cookies")
public class Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Cookies() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		
		Cookie[] cookies = request.getCookies();// получить все куки
		
		if(cookies == null){
			out.println("no cookies found(((");
		}else{
			for(Cookie retrievedCookie: cookies){
				String name = retrievedCookie.getName();
				String value = retrievedCookie.getValue();
				
				out.println("Name: " + name + ". Value: " + value);
			}	
		}
		
		/*
			не как в PHP, что куку НЕЛЬЗЯ создавать ПОСЛЕ начала печати на страницу
		*/
		Cookie cookie = new Cookie("user", "Vicky");
		
		// По дефолту у куки длина жизни '-1', так что после закрытия браузера она пропадет
		cookie.setMaxAge(300);// задаем время жизни куки
		response.addCookie(cookie);// добавляем куку
		
		out.println("Cookie set.<br/>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
