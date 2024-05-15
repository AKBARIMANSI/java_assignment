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
    	String mobile = req.getParameter("mobile");
    	
    	Employee e = new Employee();
    	e.setEmail(email);
    	e.setMobile(mobile);
    	
        EmployeeDao dao = new EmployeeDao();
    	String fname = dao.logincheck(e);
    	
    	if(fname==null)
    	{
    		req.setAttribute("err", "Invalid credentials !!!");
    		req.getRequestDispatcher("login.jsp").forward(req, resp);
    	}
    	else
    	{
    		HttpSession session = req.getSession();
    		session.setAttribute("fname",fname);
    		
    		req.getRequestDispatcher("home.jsp").forward(req, resp);
    		
    	}
    }
}
