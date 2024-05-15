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
		 String uname = req.getParameter("uname");
		 String email = req.getParameter("email");
		 String pass  = req.getParameter("pass");
		 String phone = req.getParameter("phone");
    	 
    	 Employee e =new Employee();
    	 e.setUname(uname);
    	 e.setEmail(email);
    	 e.setPass(pass);
    	 e.setPhone(phone);
    	 
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

