package com;

import java.io.IOException;
import java.io.PrintWriter;

import dao.EmpDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Emp;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		    resp.setContentType("text/html");  
	        PrintWriter out=resp.getWriter();  
	          
	        String sid=req.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	        String Fname=req.getParameter("Fname");
	        String Lname=req.getParameter("Lname");
	        String email=req.getParameter("email");
	        String mobile=req.getParameter("mobile");
	        String gender=req.getParameter("gender");
	        String pass=req.getParameter("pass");   
	          
	        Emp e=new Emp();  
	        e.setFname(Fname); 
	        e.setLname(Lname);
	        e.setEmail(email);
	        e.setMobile(mobile);
	        e.setGender(gender);
	        e.setPass(pass);    
	          
	        int status=EmpDao.update(e);  
	        if(status>0)
	        {  
	            resp.sendRedirect("ViewServlet");  
	        }else
	        {  
	            out.println("Sorry! unable to update record");  
	        }  
          
        out.close();  
	}
}
