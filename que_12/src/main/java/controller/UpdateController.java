package controller;

import java.io.IOException;

import dao.EmployeeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

@WebServlet("/update")
public class UpdateController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
    {
    	String action = req.getParameter("action");
    	int uid = Integer.parseInt(req.getParameter("uid"));
    	EmployeeDao dao = new EmployeeDao();
    	
    	if(action.equals("edit"))
    	{
    		Employee e = dao.getEmpById(uid);
    		req.setAttribute("edata", e);
    		req.getRequestDispatcher("reg.jsp").forward(req, resp);
    	}
    	else if(action.equals("delete"))
    	{
    		int i = dao.deleteEmp(uid);
    		
    		if(i>0)
    		{
    			req.getRequestDispatcher("display").forward(req, resp);
    		}
    	}
    }
}
