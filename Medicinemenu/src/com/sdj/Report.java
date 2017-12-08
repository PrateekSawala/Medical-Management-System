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



public class Report  extends JFrame  implements ActionListener {

	
	  JLabel rep,rd;
	  JTextField trd;
	  JButton Submit,Clear;
	  Font f = new Font("Dialog",Font.BOLD,26);
	  Font f1 = new Font("Dialog",Font.BOLD,13);
	  JTable table;
	
	   public Report(){
	    	 
		      setLayout(null);
			  rep  =new JLabel("Daily purchase report");
			  rep.setFont(f);
			  rd  =new JLabel("Enter purchase report date:");
			  rd.setFont(f1);
			  trd  =new JTextField(20);
			  rep.setBounds(320,20,2000,40);
		      add(rep);
			  rep.setForeground(Color.BLUE);
			  rd.setBounds(200,120,300,30);
			  add(rd);
			  trd.setBounds(400,125,150,20);
		      add(trd);
		      Submit  =new JButton("SUBMIT");
			  Clear  =new JButton("CLEAR");
			  Submit.setBounds(400,170, 80, 30);
			  add(Submit);
			  Clear.setBounds(550, 170, 80, 30);
			  add(Clear);
			  Submit.addActionListener(this); 
			  Clear.addActionListener(this);
		  }
	
	  public void actionPerformed(ActionEvent e) {
		
		  
		  
		  if(e.getSource()==Submit)
		  {
		
		   Connection con=null;
		   Statement stmt =null;
		   System.out.println("SUBMIT"); 
	       String mn  =  trd.getText();
		   System.out.println(mn);
		   //JTable table=null;
		   DefaultTableModel dtm =null;
		   ResultSet rs  =null;	 
		   String sql =" select supplier.sname,medicine.mbno,medicine.mname,medicine.mexpdate,medicine.mqty,medicine.mpurprice,medicine.msaleprice from supplier,medicine where medicine.mpurdate = '"+mn+"' and medicine.sname = supplier.sname";
		  try
		   {
	        con  = DataBaseDemo.getConnect();
		    stmt  = con.createStatement();
		    System.out.println("medicine,supplier");
		    rs= stmt.executeQuery(sql);
		    dtm  =new DefaultTableModel();
			table  =new JTable(dtm);
			table.setBounds(100,400,1000,600);
			 dtm.addColumn("S_NAME");
			 dtm.addColumn("M_BATCHNO");
			 dtm.addColumn("M_NAME");
			 dtm.addColumn("M_EXPDATE");
			 dtm.addColumn("M_QUANTITY");
			 dtm.addColumn("M_PURPRICE");
			 dtm.addColumn("M_SALEPRICE");
		     int count=0;	 
			 while(rs.next())
			 {
				 dtm.addRow(new Object[]{rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getFloat(6),rs.getFloat(7)});
				 count++;
			 }
			 
			 if(count == 0){
					
					 JOptionPane.showConfirmDialog(null, "Data report not found ", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);	
				}
				    
			if(count == 1){
				
				 JOptionPane.showConfirmDialog(null, "Data Report found ", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				 JOptionPane.showConfirmDialog(null, "Data Report found ", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
			}
			 	
			 
			 
			 JScrollPane jsp  =new JScrollPane(table);
			 jsp.setBounds(50,370,1000,700);
			/* JPanel jp =new JPanel();
			 jp.setBounds(150, 350, 300, 150);
			 jp.add(jsp);
			 add(jp);
			*/ 
			 add(jsp);
	       }
		   
		  catch(Exception ex)
		   {
			   ex.printStackTrace();
			   JOptionPane.showConfirmDialog(null, "Problem in Database connectivity or Data", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);   		   
	 	       
		   }
		   finally
		   {
			   DataBaseDemo.closeResource(con, stmt);
		   }

	       }

 
		   if (e.getSource() == Clear ){
	           
			   //new DefaultTableModel().rowsRemoved(null);
			  
			    JOptionPane.showConfirmDialog(null, "Data has been removed", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                DefaultTableModel dm  = (DefaultTableModel)this.table.getModel();
			    dm.setRowCount(0); 
			    
			    
               
		   }
 
	  
	  
	  
	  }




}	  
	  