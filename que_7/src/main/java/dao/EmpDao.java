package dao;

import java.sql.*;
import java.util.*;

import model.Emp;

public class EmpDao 
{
		 public static Connection getConnection()
		 {  
		        Connection cn = null; 
		        
		        try
		        {  
		        	Class.forName("com.mysql.cj.jdbc.Driver");
					cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");  
		        }
		        catch(Exception e)
		        {
		        	System.out.println(e);
		        }  
		        return cn;  
		 } 
	 
	    public static int save(Emp e)
	    {  
	        int status=0; 
	        
	        try
	        {  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("insert into student values (?,?,?,?,?,?,?)");  
	            ps.setString(1,e.getFname()); 
	            ps.setString(2,e.getLname()); 
	            ps.setString(3,e.getEmail());
	            ps.setString(4,e.getMobile());
	            ps.setString(5,e.getGender());
	            ps.setString(6,e.getPass());  
	        
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }
	        catch(Exception ex)
	        {
	        	ex.printStackTrace();
	        }  
	          
	        return status;  
	    } 
	    
	    public static int update(Emp e)
	    {  
	        int status=0;  
	        try
	        {  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("update student set (?,?,?,?,?,?,?)");  
	           
	            ps.setString(1,e.getFname()); 
	            ps.setString(2,e.getLname()); 
	            ps.setString(3,e.getEmail());
	            ps.setString(4,e.getMobile());
	            ps.setString(5,e.getGender());
	            ps.setString(6,e.getPass());   
	            ps.setInt(7,e.getId());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }
	        catch(Exception ex)
	        {
	        	ex.printStackTrace();
	        }  
	          
	        return status;  
	    } 
	    
	    public static int delete(int id)
	    {  
	        int status=0;  
	        try
	        {  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from student where id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }  
	          
	        return status;  
	    } 
	    
	    public static Emp getEmployeeById(int id)
	    {  
	        Emp e=new Emp();  
	          
	        try
	        {  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from student where id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();
	            
	            if(rs.next())
	            {  
	                e.setId(rs.getInt(1));  
	                e.setFname(rs.getString(2));
	                e.setLname(rs.getString(3));
	                e.setEmail(rs.getString(4));
	                e.setMobile(rs.getString(5));
	                e.setGender(rs.getString(6));
	                e.setPass(rs.getString(7));  
	                  
	            }  
	            con.close();  
	        }
	        	catch(Exception ex)
	        	{
	        		ex.printStackTrace();
	        	}  
	          
	        return e;  
	    } 
	    
	    public static List<Emp> getAllEmployees()
	    {  
	        List<Emp> list=new ArrayList<Emp>();  
	          
	        try
	        {  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from student");  
	            ResultSet rs=ps.executeQuery(); 
	            
	            while(rs.next())
	            {  
	                Emp e=new Emp();  
	                e.setId(rs.getInt(1));  
	                e.setFname(rs.getString(2));
	                e.setLname(rs.getString(3));
	                e.setEmail(rs.getString(4));
	                e.setMobile(rs.getString(5));
	                e.setGender(rs.getString(6));
	                e.setPass(rs.getString(7));   
	                list.add(e);  
	            }  
	            con.close();  
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }  
	          
	        return list;  
	    }  
}  
