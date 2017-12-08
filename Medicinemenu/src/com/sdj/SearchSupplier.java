package com.sdj;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.font.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.sdj.DataBaseDemo;


public class SearchSupplier extends JFrame implements ActionListener {

	JLabel nsd,sid,sn,sadd,spno,seid;
	JTextField tid,tsn,tsadd,tspno,teid;
	JButton ser,all;
    Font f = new Font("Dialog",Font.BOLD,26);
	Font f1 = new Font("Dialog",Font.BOLD,13);
	  
	public SearchSupplier(){
		 setLayout(null);
		 nsd  =new JLabel("Search Supplier");
		 nsd.setFont(f);
		 sn =new JLabel("Search by name");
		/* sadd =new JLabel("Supplier Address");
		 spno =new JLabel("Supplier phone no");
		 seid =new JLabel("Supplier Email id");
		*/
		 sn.setFont(f1);
		 /*sadd.setFont(f1);
		 spno.setFont(f1);
		 seid.setFont(f1);
		 */
		 tsn  =new JTextField(30);
		 /*tsadd  =new JTextField(30);
		 tspno =new JTextField(30);
		 teid  =new JTextField(30);
		 */
		 nsd.setBounds(320, 20, 3000, 35);
		 add(nsd);
		 nsd.setForeground(Color.BLUE);
		 sn.setBounds(200, 120, 110, 20);
		 add(sn);
		 tsn.setBounds(370, 120, 250, 20);
	     add(tsn);
	     ser  =new JButton("Search");
		 all  =new JButton("All");
		 ser.setBounds(350,150, 80, 30);
		 add(ser);
		 all.setBounds(500, 150, 80, 30);
		 add(all);
		 ser.addActionListener(this); 
		 all.addActionListener(this);
	
	  }
	
	public void actionPerformed(ActionEvent e) {
	
		
		
		
		if(e.getSource()==ser)
		  {
			   System.out.println("Search");      
			   String mn  =  tsn.getText();
			   System.out.println(mn); 
			   Connection con=null;
			   Statement stmt =null;
		       ResultSet rs = null;
			   DefaultTableModel dtm =null;
			   JTable table=null;
	 		   String sql  = "select *from supplier where sname='" + mn + "' ";
	          try{
	        	  con  = DataBaseDemo.getConnect();
	 			  stmt  = con.createStatement();
	 			  rs  = stmt.executeQuery(sql);
	 		      dtm  =new DefaultTableModel();
	 		      table  =new JTable(dtm);
 				  table.setBounds(15,170,600,100);
 				  dtm.addColumn("S_NAME");
 				  dtm.addColumn("S_ADDRESS");
 				  dtm.addColumn("S_PHONENO");
 				  dtm.addColumn("S_EMAILID");
 				  int count=0;
 				  //int n=0;
 				  while(rs.next())
 				 {     
 					   
 						 
 				           dtm.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
 						   count++; 					  
  				}
 					if(count == 0){
 						
 						 JOptionPane.showConfirmDialog(null, "Name not found ", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);	
 					}
 					    
 				if(count == 1){
 					
 					 JOptionPane.showConfirmDialog(null, "Name found ", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
 				}
 				else
 				{
 					 JOptionPane.showConfirmDialog(null, "Name found ", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
 				}
 				 
 		       
 				
 				 
 				 
 				JScrollPane jsp  =new JScrollPane(table);
 			    jsp.setBounds(50, 370, 1000,700);
 				/* JPanel jp =new JPanel();
 				 jp.setBounds(150, 350, 300, 150);
 				 jp.add(jsp);
 				 add(jp);*/
 				 add(jsp); 
 				
	          
	          }
		   
	           catch(Exception ex)
			   {
				   ex.printStackTrace();
				   JOptionPane.showConfirmDialog(null, "Problem in DataBase Connectivity ", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);   		   
		 	       
			   }
			   finally
			   {
				   DataBaseDemo.closeResource(con, stmt);
			   }
		  }

          if(e.getSource()== all){
        	  
        	 System.out.println("all");
 			 Connection con  =null;
 			 Statement stmt =null;
 			 JTable table=null;
 			 DefaultTableModel dtm =null;
 			 String sql  = "select *from supplier";
 			 ResultSet rs  =null;//virtual table inside java
 			 try
 			 {
 				 con  = DataBaseDemo.getConnect();
 				 stmt  = con.createStatement();
 				 rs  = stmt.executeQuery(sql);
 				 
 				 dtm  =new DefaultTableModel();
 				 table  =new JTable(dtm);
 				 table.setBounds(15,200,600,400);
 				 dtm.addColumn("S_NAME");
 				 dtm.addColumn("S_ADDRESS");
 				 dtm.addColumn("S_PHONENO");
 				 dtm.addColumn("S_EMAILID");
 				 int count=0;
 				 while(rs.next())
 				 {
 					 dtm.insertRow(count,new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
 					 count++;
 				 }
 				 JScrollPane jsp  =new JScrollPane(table);
 				 jsp.setBounds(50, 370, 1000,700);
 				/* JPanel jp =new JPanel();
 				 jp.setBounds(150, 350, 300, 150);
 				 jp.add(jsp);
 				 add(jp);*/
 				 add(jsp);
 					 
 				 
 			 }
 			 catch(Exception ex)
 			 {
 				 ex.printStackTrace();
 			 
 			 
 			 }

        	  
        	  
        	  
        	  
        	  
          }
	
	
	
	
	
	
	}

	
}