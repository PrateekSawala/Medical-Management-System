package com.sdj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection 
{   

	
	public static Connection getConnection()
    {
    	String driver="com.mysql.jdbc.Driver"; //1
    	String url ="jdbc:mysql://localhost:3306/pf";
    	String user="root";
    	String pass="root";
    	Connection con =null;
    	try
    	{		Class.forName(driver);//2
    		con  = DriverManager.getConnection(url,user,pass);//3
    	}
    	catch(ClassNotFoundException ex)
    	{    		ex.printStackTrace();
    		
    	}
    	catch(SQLException ex)
    	{    		ex.printStackTrace();
    	}
    	return con;
    }

}