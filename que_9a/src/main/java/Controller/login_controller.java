package Controller;

import java.io.IOException;

import Dao.employee_dao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.employee;

@WebServlet("/login")
public class login_controller extends HttpServlet 
{
      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
      {
    	  String email=req.getParameter("email");
    	  String pass=req.getParameter("pass");
    	  
    	  employee e = new employee();
    	  e.setEmail(email);
    	  e.setPass(pass);
    	  
    	  employee_dao dao = new employee_dao();
      	  String uname = dao.logincheck(e);
      	
	      if(uname==null)
	      	{
	      		req.setAttribute("err", "Invalid credentials !!!");
	      		req.getRequestDispatcher("login.jsp").forward(req, resp);
	      	}
	      else
	      	{
	      		HttpSession session = req.getSession();
	      		session.setAttribute("uname", uname);
	      		
	      		req.getRequestDispatcher("home.jsp").forward(req, resp);
      		
	      	}
      }
}
