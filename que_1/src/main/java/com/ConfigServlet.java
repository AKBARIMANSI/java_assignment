package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ConfigServlet")
public class ConfigServlet extends HttpServlet
{
	 private static final long serialVersionUID = 1L;
	 
	 private String message;

	    public void init() throws ServletException 
	    {
	        message = getServletConfig().getInitParameter("message");
	    }
	    
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
		{
			resp.setContentType("text/html");
	        PrintWriter out = resp.getWriter();
	        out.println("<html><head><title>Servlet Config Example</title></head><body>");
	        out.println("<h1>" + message + "</h1>");
	        out.println("</body></html>");
		}
		
		 public void destroy()
		 {

		 }
}
