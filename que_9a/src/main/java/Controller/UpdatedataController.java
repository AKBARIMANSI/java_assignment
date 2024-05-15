
package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import Dao.employee_dao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.employee;

@WebServlet("/updatadata")
public class UpdatedataController extends HttpServlet
{
      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException
      {
    	  PrintWriter pw = resp.getWriter();
    	  
    	  int id = Integer.parseInt(req.getParameter("id"));
    	  String name=req.getParameter("uname");
    	  String email=req.getParameter("email");
    	  String pass=req.getParameter("pass");
    	  String phone=req.getParameter("phone");
    	  
    	  employee e = new employee();
    	  e.setId(id);
    	  e.setUname(name);
    	  e.setEmail(email);
    	  e.setPass(pass);
    	  e.setPhone(phone);
    	  
    	  employee_dao dao = new employee_dao();
    	 
    	  int i = dao.updateEmp(e);
   		  if(i>0)
  			  {
   				  pw.append("Update successfully...!!!");
    		  }
       }
}
