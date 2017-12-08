package com.sdj;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.sdj.DataBaseDemo;

public class Login  extends JFrame implements ActionListener  {


	    JLabel admin,uname,psswrd;
		JTextField uid,pwd;
		JButton login,exit;
		Font f = new Font("Dialog",Font.BOLD,30);
		Font f1 = new Font("Dialog",Font.BOLD,13);
		
		public boolean move; 		
		
		public Login(){
		
		 setLayout(null);
		 admin  =new JLabel("Administrator");
		 admin.setFont(f);
		 uname = new JLabel("User Name:");
		 psswrd =new JLabel("Password:");
		 uname.setFont(f1);
		 psswrd.setFont(f1);
		 uid = new JTextField(30);
		 pwd  =new JTextField(30);
		 admin.setBounds(320, 20, 3000, 35);
		 add(admin);
		 uname.setBounds(150, 120, 120, 20);
		 add(uname);
		 psswrd.setBounds(150, 155, 110, 20);
		 add(psswrd);
		 uid.setBounds(300, 120, 150, 20);
	     add(uid);
	     pwd.setBounds(300, 155, 150, 20);
	     add(pwd);
	     login  =new JButton("LOGIN");
		 login.setBounds(300,200,80,30);
		 add(login);
		 login.addActionListener(this);
		 exit  =new JButton("EXIT");
		 exit.setBounds(400,200, 80, 30);
		 add(exit);
		 exit.addActionListener(this);
		 
		 
	} 
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==login)
			{
				   Connection con=null;
				   Statement stmt =null;
				   ResultSet rs  =null;
				  
				
				try
				{         con  = DataBaseDemo.getConnect();
					      stmt  = con.createStatement(); 
					      rs=stmt.executeQuery("select * from login where user_name = '"+uid.getText()+"';");
					      if(!rs.next())
					      {
					    	  JOptionPane.showMessageDialog(null,"Sorry!!!you are not a valid user...!!!","WARNING",JOptionPane.ERROR_MESSAGE);
					      }
					
					      else
					      {
					    	       String s=pwd.getText();
					    	       if(s.equals(rs.getString("psswrd"))){
					    	    	   
					    	    	   JOptionPane.showMessageDialog(null,"Welcome!!!you are valid user...!!!","Welcome",JOptionPane.INFORMATION_MESSAGE);					    	    	   
		                               
					    	    	   move=true; 			                     
					    	       
					    }
					    
					    	       
					 }
				}			      
			     	catch(Exception ex)
				   {
					 ex.printStackTrace();
				    }
			  
			
		if(move == true)
		{		
		MedicalMenu mm = new MedicalMenu();
        mm.setVisible(true);
        mm.setTitle("MedicalMenu");
        mm.setSize(1200,700);
        mm.setBackground(Color.BLUE);
	    } 
		     
	}		
		
		if(e.getSource()==exit){
				
				System.exit(0);
				
			}
			
			
}			    	       
					    	       
public static void main(String args[])
     {
       Login log = new Login();
       log.setVisible(true);
       log.setTitle("Login");
       log.setSize(700,500);
     }

}
					     
					

				
				
			
		        	
		 
		
		
		
		
		
		
	







