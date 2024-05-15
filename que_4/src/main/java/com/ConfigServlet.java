package com;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConfigServlet extends HttpServlet
{
	private String message;

    public void init(ServletConfig config) throws ServletException
    {
        message = config.getInitParameter("message");
    }
    
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
		{
			req.setAttribute("message", message);
			 
			RequestDispatcher dispatcher = req.getRequestDispatcher("/showMessage.jsp");
	        dispatcher.forward(req, resp);
		}
}
