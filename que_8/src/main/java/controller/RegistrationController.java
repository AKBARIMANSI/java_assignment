package controller;

import java.io.IOException;

import dao.EmployeeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

@WebServlet("/reg")
public class RegistrationController extends HttpServlet
{
	@Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
		 String id = req.getParameter("id");
		 String fname = req.getParameter("fname");
		 String lname = req.getParameter("lname");
		 String email = req.getParameter("email");
		 String mobile = req.getParameter("mobile");
    	 
    	 Employee e =new Employee();
    	 e.setFname(fname);
    	 e.setLname(lname);
    	 e.setEmail(email);
    	 e.setMobile(mobile);
    	 
    	 EmployeeDao dao = new EmployeeDao();
    	 System.out.println("hello"+id);
    	 if(id.equals(null) || id.equals(""))
    	 {
    	 
    	    boolean b = dao.isEmailExist(e);
    	 
    	    if(b)
    	    {
    		    req.setAttribute("err", "Email already exist... !!");
    		    req.getRequestDispatcher("reg.jsp").forward(req, resp);
    		 
    	    }
    	    else
    	    {
	    		 int i = dao.registration(e);
	    		 if(i>0)
	    		 {
	    			 req.setAttribute("msg", "Registration successfull...!!!");
	    			 req.getRequestDispatcher("reg.jsp").forward(req, resp);
	    		 }
    	    }
    	 
    	 }
    	 else
 		{
 			int uid = Integer.parseInt(id);
 			e.setId(uid);
 			boolean b = dao.isEmailExist(e);
 			
 			if(b)
 			{
 				req.setAttribute("err", "Email already exist.....!!");
 				req.getRequestDispatcher("reg.jsp").forward(req, resp);
 			}
 			else
 			{
 				int i = dao.updateEmp(e);
 				if(i>0)
 				{
 					req.setAttribute("msg", "Update successfull....!!!");
 					req.getRequestDispatcher("reg.jsp").forward(req, resp);
 				}
 			}
 		 }
    }
}

