package controller;

import java.io.IOException;
import dao.EmployeeDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Employee;

@WebServlet("/login")
public class loginController extends HttpServlet
{
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
    	String email = req.getParameter("email");
    	String pass = req.getParameter("pass");
    	
    	Employee e = new Employee();
    	e.setEmail(email);
    	e.setPass(pass);
    	
        EmployeeDao dao = new EmployeeDao();
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
