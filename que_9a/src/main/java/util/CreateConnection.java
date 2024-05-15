package util;

import java.lang.module.ResolutionException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection
{
       public static Connection mkconn()
       {
    	   Connection cn = null;
    	   try
    	    {
    		   Class.forName("com.mysql.cj.jdbc.Driver");
    		   cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava","root","");
    	    }
    	    catch ( ClassNotFoundException | SQLException e)
    		 {
    	    	 e.printStackTrace();
    		 }
    	   return cn;
       }
}
