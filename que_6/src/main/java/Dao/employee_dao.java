package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.employee;

public class employee_dao
{
	Connection cn = null;
    
    public employee_dao()
    {
   	 try
   	 {
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
	     }
   	 
   	 catch (ClassNotFoundException | SQLException e)
   	
   	 {
				
				e.printStackTrace();
		} 
     }	 
   	
    public int registration(employee e)
		
   	 {
			int i = 0;
			
			try
			{
				PreparedStatement ps = cn.prepareStatement("insert into data values(?,?,?,?,?)");
				ps.setInt(1, 0);
				ps.setString(2, e.getUname());
				ps.setString(3, e.getEmail());
				ps.setString(4, e.getPass ());
				ps.setString(5, e.getPhone());
				
				i = ps.executeUpdate();
				
				
			}
			
			catch (SQLException e1) 
			
			{
				
				e1.printStackTrace();
			}
			
			return i;
		  }
		
	public boolean isEmailExist(employee e)
		
		{
			boolean b = false;
			
			try
			 {
				PreparedStatement ps  =cn.prepareStatement("select * from data where email=?");
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

	 public String logincheck(employee e)
		{
			
			String uname = null;
			try
			 {
				PreparedStatement ps = cn.prepareStatement("select * from data where email=? and pass=?");
				ps.setString(1, e.getEmail());
				ps.setString(2, e.getPass());

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

	 public ArrayList<employee> getAllEmp()
		{
			ArrayList<employee> emp = new ArrayList<employee>();
			PreparedStatement ps;
			try
			{
				ps=cn.prepareStatement("select * from data");
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					employee e = new employee();
					e.setId(rs.getInt(1));
					e.setUname(rs.getString(2));
					e.setEmail(rs.getString(3));
					e.setPass(rs.getString(4));
					e.setPhone(rs.getString(5));

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
				PreparedStatement ps = cn.prepareStatement("delete from data where id=?");
				ps.setInt(1, uid);
				
				i=ps.executeUpdate();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			return i;
	    }

	public employee getEmpById(int uid)
		{
			employee e =new employee();
			try
			{
				PreparedStatement ps = cn.prepareStatement("select * from data where id=?");
				ps.setInt(1, uid);
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next())
				{
					e.setId(rs.getInt(1));
					e.setUname(rs.getString(2));
					e.setEmail(rs.getString(3));
					e.setPass(rs.getString(4));
					e.setPhone(rs.getString(5));
				}
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			return e;
		}
	public int updateEmp(employee e)
		{
			int i=0;
			try
			{
				PreparedStatement ps = cn.prepareStatement("update data set uname=?,email=?,pass=?,phone=? where id=?");
				ps.setInt(5, e.getId());
				ps.setString(1, e.getUname());
				ps.setString(2, e.getEmail());
				ps.setString(3, e.getPass());
				ps.setString(4, e.getPhone());

				i = ps.executeUpdate();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			return i;
		}

}
