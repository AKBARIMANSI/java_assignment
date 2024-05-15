
package Controller;

import java.io.IOException;

import Dao.employee_dao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.employee;

@WebServlet("/reg")
public class reg_controller extends HttpServlet
{
      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException
      {
    	  String id=req.getParameter("id");
    	  String name=req.getParameter("uname");
    	  String email=req.getParameter("email");
    	  String pass=req.getParameter("pass");
    	  String phone=req.getParameter("phone");
    	  
    	  employee e = new employee();
    	  e.setUname(name);
    	  e.setEmail(email);
    	  e.setPass(pass);
    	  e.setPhone(phone);
    	  
    	  employee_dao dao = new employee_dao();
    	  System.out.println("hello"+id);
    	  
    	  if(id.equals(null) || id.equals(""))
    	  {
    		  boolean b = dao.isEmailExist(e);
    		  
    		  if(b)
    		  {
    			  req.setAttribute("err","email alredy exist...!!");
    			  req.getRequestDispatcher("reg.jsp").forward(req, resp);
    		  }
    		  else
    		  {
    			  int i = dao.registration(e);
    			  if(i>0)
    			  {
    				  req.setAttribute("msg","Registration successfull...!!");
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
    			  req.setAttribute("err","Email alredy exist...!!");
    			  req.getRequestDispatcher("reg.jsp").forward(req, resp);
    		  }
    		  else
    		  {
    			  int i = dao.updateEmp(e);
    			  if(i>0)
    			  {
    				  req.setAttribute("msg","Update successfull...!!");
    				  req.getRequestDispatcher("reg.jsp").forward(req, resp);
    			  }
    			  
    		  }
    	  }
      }
}
