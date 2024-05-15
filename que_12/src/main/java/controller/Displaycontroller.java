package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.EmployeeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

@WebServlet("/display")
public class Displaycontroller extends HttpServlet
{
       @Override
       protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
       {
    	    EmployeeDao dao = new EmployeeDao();
    	    ArrayList<Employee>emp = dao.getAllEmp();
    	   
    		req.setAttribute("data", emp);
    		req.getRequestDispatcher("display.jsp").forward(req, resp);
       }
}
