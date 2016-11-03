package demo;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScopedObjects
 */
@WebServlet("/ScopedObjects")
public class ScopedObjects extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ScopedObjects() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		//Request scope
		request.setAttribute("test", "Hello");
		String test = (String) request.getAttribute("test");
		
//		//Session scope
		HttpSession session = request.getSession();
		request.setAttribute("test", "Hello");
		String test1 = (String) request.getAttribute("test");
		
		// Application
		ServletContext context = getServletContext();
		request.setAttribute("test", "Hello");
		String test2 = (String) request.getAttribute("test");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
