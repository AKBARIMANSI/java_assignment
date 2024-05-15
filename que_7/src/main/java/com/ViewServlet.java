package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.EmpDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Emp;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		    resp.setContentType("text/html");  
	        PrintWriter out=resp.getWriter();  
	        out.println("<a href='index.html'>submit</a>");  
	        out.println("<h1>Employees List</h1>");  
	          
	        List<Emp> list=EmpDao.getAllEmployees();  
	          
	        out.print("<table border='1' width='100%'");  
	        out.print("<tr><th>Id</th><th>FName</th><th>LName</th><th>Email</th><th>mobile</th><th>gender</th><th>Pass</th><th>Edit</th><th>Delete</th></tr>");  
	        for(Emp e:list)
	        {  
	         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getFname()+"</td><td>"+e.getLname()+"</td><td>"+e.getEmail()+"</td><td>"+e.getMobile()+"</td><td>"+e.getGender()+"</td><td>"+e.getPass()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");  
	        }  
	        out.print("</table>");  
	          
	        out.close();  
	}
}
