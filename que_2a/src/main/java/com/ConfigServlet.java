package com;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/configServlet")
public class ConfigServlet extends HttpServlet
{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
		{
			 ServletContext context = getServletContext();
		        
		        String appName = context.getInitParameter("appName");
		        String appVersion = context.getInitParameter("appVersion");
		        
		        resp.setContentType("text/html");
		        resp.getWriter().println("<html><body>");
		        resp.getWriter().println("<h1>Application Information</h1>");
		        resp.getWriter().println("<p>Application Name: " + appName + "</p>");
		        resp.getWriter().println("<p>Application Version: " + appVersion + "</p>");
		        resp.getWriter().println("</body></html>");
		}
}
