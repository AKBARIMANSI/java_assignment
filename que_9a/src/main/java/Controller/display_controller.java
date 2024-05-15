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

@WebServlet("/display")
public class display_controller extends HttpServlet
{
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
      {
    	  employee_dao dao = new employee_dao();
    	  ArrayList<employee> emp = dao.getAllEmp();
    	  
    	  PrintWriter pw = resp.getWriter();
    	  Gson json = new Gson();
    	  String data = json.toJson(emp);
    	  
    	  pw.append(data);
    	 
      }
}
