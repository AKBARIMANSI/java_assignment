package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fetchData")
public class FetchDataServlet extends HttpServlet
{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
		{
			 Connection cn = null;
			 List<Map<String,Object>> dataList = new ArrayList<>();

		        try
		        {
		           
		            Class.forName("com.mysql.cj.jdbc.Driver");
					cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");

		           
		            Statement statement = cn.createStatement();

		            ResultSet rs = statement.executeQuery("select * form data");

		            while (rs.next())
		            {
		                Map<String, Object> row = new HashMap<>();
		                row.put("id", rs.getInt("id"));
		                row.put("name", rs.getString("name"));
		                row.put("age", rs.getInt("age"));
		                dataList.add(row);
		            }

		        }
		        catch (Exception e)
		        {
		            e.printStackTrace();
		        }

		        req.setAttribute("dataList", dataList);

		        RequestDispatcher dispatcher = req.getRequestDispatcher("/display.jsp");
		        dispatcher.forward(req, resp);
		}
}

