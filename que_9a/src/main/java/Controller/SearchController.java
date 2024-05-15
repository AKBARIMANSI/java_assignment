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

@WebServlet("/search")
public class SearchController extends HttpServlet
{
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
      {
    	  String value = req.getParameter("value");
    	  
    	  employee_dao dao = new employee_dao();
    	  ArrayList<employee> emp = dao.searchemp(value);
    	  
    	  PrintWriter pw = resp.getWriter();
    	  Gson json = new Gson();
    	  String data = json.toJson(emp);
    	  
    	  pw.append(data);
    	 
      }
}
