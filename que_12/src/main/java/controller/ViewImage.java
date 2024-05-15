package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

@WebServlet("/viewimg")
public class ViewImage extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    	try
    	{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
			
			PreparedStatement ps = cn.prepareStatement("select * from image");
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Employee> al = new ArrayList();
			System.out.println("Hello");
			while(rs.next())
			{
				Employee up = new Employee();
				up.setId(rs.getInt(1));
				up.setUname(rs.getString(2));
				up.setImage(rs.getString(3));
				
				al.add(up);
				
				
			}
			
			PrintWriter pw = resp.getWriter();
			Gson json = new Gson();
			
			pw.append(json.toJson(al));
			
		} 
    	catch (ClassNotFoundException | SQLException e) 
    	{
			
			e.printStackTrace();
		}
		
    }
}
