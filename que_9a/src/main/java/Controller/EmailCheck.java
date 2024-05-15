package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;

import Dao.employee_dao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.employee;

@WebServlet("/emailcheck")
public class EmailCheck extends HttpServlet
{
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
      {
    	  PrintWriter pw = resp.getWriter();
    	  String value = req.getParameter("value");
    	  
    	  employee e = new employee();
    	  e.setEmail(value);
    	  
    	  employee_dao dao = new employee_dao();
    	  boolean b = dao.isEmailExist(e);
    	 
    	  pw.append(b+"");
    	 
      }
}
