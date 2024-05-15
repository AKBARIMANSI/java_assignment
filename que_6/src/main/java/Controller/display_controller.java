package Controller;

import java.io.IOException;
import java.util.ArrayList;

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
    	  
    	  req.setAttribute("data", emp);
    	  req.getRequestDispatcher("display.jsp").forward(req, resp);
      }
}
