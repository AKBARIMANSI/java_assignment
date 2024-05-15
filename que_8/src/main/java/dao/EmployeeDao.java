package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Employee;

public class EmployeeDao 
{
     Connection cn = null;
     
     public EmployeeDao()
     {
    	 try
    	 {
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/deemo","root","");
	     }
    	 
    	 catch (ClassNotFoundException | SQLException e)
    	
    	 {
				
				e.printStackTrace();
		 } 
      }	 
    	
     public int registration(Employee e)
 		
    	 {
 			int i = 0;
 			
 			try
 			{
 				PreparedStatement ps = cn.prepareStatement("insert into user values(?,?,?,?,?)");
 				ps.setInt(1, 0);
 				ps.setString(2, e.getFname());
 				ps.setString(3, e.getLname());
 				ps.setString(4, e.getEmail());
 				ps.setString(5, e.getMobile());
 				
 				i = ps.executeUpdate();
 				
 				
 			}
 			
 			catch (SQLException e1) 
 			
 			{
 				
 				e1.printStackTrace();
 			}
 			
 			return i;
 		  }
 		
 	public boolean isEmailExist(Employee e)
 		
 		{
 			boolean b = false;
 			
 			try
 			 {
 				PreparedStatement ps  =cn.prepareStatement("select * from user where email=?");
 				ps.setString(1, e.getEmail());
 				
 				ResultSet rs = ps.executeQuery();
 				
 				if(rs.next())
 				{
 					b = true;
 				}
 				
 				
 			 }
 			catch (SQLException e1)
 			 {
 				
 				e1.printStackTrace();
 			 }
 			
 			return b;
 		}

 	 public String logincheck(Employee e)
 		{
 			
 			String uname = null;
 			try
 			 {
 				PreparedStatement ps = cn.prepareStatement("select * from user where email=? and pass=?");
 				ps.setString(1, e.getEmail());
 				ps.setString(2, e.getMobile());

 				ResultSet rs = ps.executeQuery();
 				
 				if(rs.next())
 				 {
 					uname = rs.getString(2);
 				 }
 				
 				
 			 }
 			catch (SQLException e1) 
 			 {
 				
 				e1.printStackTrace();
 			 }
 			return uname;
        }

	 public ArrayList<Employee> getAllEmp()
		{
			ArrayList<Employee> emp = new ArrayList<Employee>();
			PreparedStatement ps;
			try
			{
				ps=cn.prepareStatement("select * from user");
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					Employee e = new Employee();
					e.setId(rs.getInt(1));
					e.setFname(rs.getString(2));
					e.setLname(rs.getString(2));
					e.setEmail(rs.getString(3));
					e.setMobile(rs.getString(5));

					emp.add(e);
				}
			}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				return emp;
		  }
	
		
	  public int deleteEmp(int uid)
	    {
			int i=0;
			try
			{
				PreparedStatement ps = cn.prepareStatement("delete from user where id=?");
				ps.setInt(1, uid);
				
				i=ps.executeUpdate();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			return i;
	    }

	public Employee getEmpById(int uid)
		{
			Employee e =new Employee();
			try
			{
				PreparedStatement ps = cn.prepareStatement("select * from user where id=?");
				ps.setInt(1, uid);
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next())
				{
					e.setId(rs.getInt(1));
					e.setFname(rs.getString(2));
					e.setLname(rs.getString(2));
					e.setEmail(rs.getString(3));
					e.setMobile(rs.getString(5));
				}
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			return e;
		}
	public int updateEmp(Employee e)
		{
			int i=0;
			try
			{
				PreparedStatement ps = cn.prepareStatement("update user set uname=?,email=?,pass=?,phone=? where id=?");
				ps.setInt(5, e.getId());
				ps.setString(1, e.getFname());
				ps.setString(1, e.getLname());
				ps.setString(2, e.getEmail());
				ps.setString(4, e.getMobile());

				i = ps.executeUpdate();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			return i;
		}
}

