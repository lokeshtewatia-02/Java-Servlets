package com.hidden;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class servlet1
 */
@WebServlet(name = "hidden1", urlPatterns = { "/hidden1" })
public class hidden1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hidden1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		String name =request.getParameter("user_name");
		out.println("<h1> your name is :"+name+"</h1>");
		//out.println("<a href='hidden2?user="+name+"'>Go to Servlet2</a>");
		//hidden form field
		
		out.println(""
				+ "<form action='hidden2'>"
				+ "<input type='hidden' name='user_name' value='"+name+"' />"
				+ "<button>Go to second servlet</button>"
				+ ""
				+ ""
				+ "</form>");
		                       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
