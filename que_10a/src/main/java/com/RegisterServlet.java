package com;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

public class RegisterServlet extends HttpServlet
{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
		{
			String firstName = req.getParameter("firstName");
	        String lastName = req.getParameter("lastName");
	        String email = req.getParameter("email");
	        String mobile = req.getParameter("mobile");
	        String password = req.getParameter("password");
	        String gender = req.getParameter("gender");
	        
	        User user = new User();
	        user.setFirstName(firstName);
	        user.setLastName(lastName);
	        user.setEmail(email);
	        user.setMobile(mobile);
	        user.setPassword(password);
	        user.setGender(gender);
	        
	        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory factory = cfg.buildSessionFactory();
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        
	        session.save(user);
	        
	        tx.commit();
	        session.close();
	        factory.close();
	        
	        resp.sendRedirect("login.jsp");
		}
}
