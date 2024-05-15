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

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet
{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
		{
				resp.setContentType("text/html");  
		        PrintWriter out=resp.getWriter();  
		          
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
		          
		        int status=EmpDao.save(e);  
		        if(status>0)
		        {  
		            out.print("<p>Record saved successfully!</p>");  
		            req.getRequestDispatcher("index.html").include(req, resp);  
		        }
		        else
		        {  
		            out.println("Sorry! unable to save record");  
		        }  
		          
		        out.close();  
		}
}
