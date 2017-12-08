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

public class AddNewMedicine  extends JFrame  implements ActionListener 
{
      JLabel nmd,mbn,mtype,mn,mpp,mc,msp,mq,mrn,med,msn,mpd;
	  JTextField tnmd,tmn,tmpp,tmc,tmsp,tmq,tmrn,tmed,tmpd;
	  JComboBox cmtype,csn;
	  JButton save,all,clear;
	  JPanel b;
	  JFrame jf;
	  Connection con=null;
	  Statement stmt =null;
	  Font f = new Font("Dialog",Font.BOLD,26);
	  Font f1 = new Font("Dialog",Font.BOLD,13);
	  public AddNewMedicine() 
	  {
		  setLayout(null);
		  nmd  =new JLabel("New Medicine Details");
		  nmd.setFont(f);
		  mbn  =new JLabel("Medicine Batch No");
		  mtype =new JLabel("Medicine Type");
		  mn =new JLabel("Medicine name");
		  mpp =new JLabel("Medicine purchase price");
		  mc =new JLabel("Medicine company");
		  msp =new JLabel("Medicine sale price");
		  mq =new JLabel("Medicine quantity");
		  mrn =new JLabel("Medicine rack no");
		  med =new JLabel("Med expiry date");
		  msn =new JLabel("supplier name");
		  mpd =new JLabel("Med purchase date");
		  mbn.setFont(f1);
		  mtype.setFont(f1);
		  mn.setFont(f1);
		  mpp.setFont(f1);
		  mc.setFont(f1);
		  msp.setFont(f1);
		  mq.setFont(f1);
		  mrn.setFont(f1);
		  med.setFont(f1);
		  msn.setFont(f1);
		  mpd.setFont(f1);
		  tnmd  =new JTextField(40);
		  tmn  =new JTextField(40);
		  tmpp =new JTextField(40);
		  tmc  =new JTextField(40);
		  tmsp  =new JTextField(40);
		  tmq  =new JTextField(40);
		  tmrn  =new JTextField(40);
		  tmed  =new JTextField(40);
		  tmpd  =new JTextField(40);
		  cmtype =new  JComboBox();
		  cmtype.addItem("Tablet");
		  cmtype.addItem("Balm");
		  csn =  new JComboBox();
		  csn.addItem("Prateek Sawala");
		  csn.addItem("vinay jain");
		  nmd.setBounds(320, 20, 2000, 20);
		  add(nmd);
		  nmd.setForeground(Color.BLUE);
		  mbn.setBounds(30, 120, 120, 20);
		  add(mbn);
		  mtype.setBounds(500, 120, 100, 20);
		  add(mtype);
		  mn.setBounds(30, 155, 110, 20);
		  add(mn);
		  mpp.setBounds(500, 155, 200, 20);
		  add(mpp);
		  mc.setBounds(30, 190, 120, 20);
		  add(mc);
		  msp.setBounds(500, 190, 150, 20);
		  add(msp);
		  mq.setBounds(30, 225, 120, 20);
		  add(mq);
		  mrn.setBounds(500, 225, 150, 20);
		  add(mrn);
		  med.setBounds(30, 260, 110, 20);
		  add(med);
		  msn.setBounds(500, 260, 100, 20);
		  add(msn);
		  mpd.setBounds(30, 295, 150, 20);
		  add(mpd);
		  
		  tnmd.setBounds(200, 120, 90, 20);
	      add(tnmd);
	      tmn.setBounds(200, 155, 150, 20);
	      add(tmn);
		  tmpp.setBounds(700, 155, 90, 20);
	      add(tmpp);
		  tmc.setBounds(200, 190, 150, 20);
	      add(tmc);
		  tmsp.setBounds(700, 190, 90, 20);
	      add(tmsp);
		  tmq.setBounds(200, 225, 90, 20);
	      add(tmq);
		  tmrn.setBounds(700, 225, 90, 20);
	      add(tmrn);
		  tmed.setBounds(200, 260, 90, 20);
	      add(tmed);
		  tmpd.setBounds(200, 295, 90, 20);
	      add(tmpd);
		  cmtype.setBounds(700,120, 110, 20);
		  add(cmtype);
		  csn.setBounds(700, 260, 140, 20);
		  add(csn);
	      save  =new JButton("Save");
		  all  =new JButton("All");
		  save.setBounds(350, 320, 80, 30);
		  add(save);
		  all.setBounds(500, 320, 80, 30);
		  add(all);
		  save.addActionListener(this); 
		  all.addActionListener(this);
	   }
	  
	  public void actionPerformed(ActionEvent e) 
	  {
		  if(e.getSource()==save)
		  {
		
     	   System.out.println("Save");
	       int mb      =  Integer.parseInt(tnmd.getText()); 
	       String min  =  tmn.getText();
		   String mic  =  tmc.getText();   
		   int miq  =  Integer.parseInt(tmq.getText());
		   String mexp =  tmed.getText();
		   String mpur =  tmpd.getText();
		   String mt   =  cmtype.getSelectedItem().toString();
		   float mip   =  Float.parseFloat(tmpp.getText());
     	   float mis   =  Float.parseFloat(tmsp.getText());
		   String mir  =  tmrn.getText();
		   String ms   =  csn.getSelectedItem().toString();
		   System.out.println(mb+":"+min+":"+mic+":"+miq+":"+mexp+":"+mpur+":"+mt+":"+mip+":"+mis+":"+mir+":"+ms);
		  try
		   {
	       con  = DataBaseDemo.getConnect();
		   stmt  = con.createStatement();
		   String sql ="insert into medicine values("+mb+",'"+min+"','"+mic+"','"+miq+"','"+mexp+"','"+mpur+"','"+mt+"',"+mip+","+mis+",'"+mir+"','"+ms+"')";
		   System.out.println(sql);
		   stmt.executeUpdate(sql);
		   JOptionPane.showConfirmDialog(null, "Your Data Has been Inserted", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
		   
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
		 if(e.getSource()==all)
		 {
			System.out.println("all");
			 Connection con  =null;
			 Statement stmt =null;
			 JTable table=null;
			 DefaultTableModel dtm =null;
			 String sql  = "select *from medicine";
			 ResultSet rs  =null;//virtual table inside java
			 try
			 {
				 con  = DataBaseDemo.getConnect();
				 stmt  = con.createStatement();
				 rs  = stmt.executeQuery(sql);
				 dtm  =new DefaultTableModel();
				 table  =new JTable(dtm);
				 table.setBounds(15,400,500,600);
				 dtm.addColumn("M_BATCHNO");
				 dtm.addColumn("M_NAME");
				 dtm.addColumn("M_COMPANY");
				 dtm.addColumn("M_QUANTITY");
				 dtm.addColumn("M_EXPDATE");
				 dtm.addColumn("M_PURDATE");
				 dtm.addColumn("M_TYPE");
				 dtm.addColumn("M_SALEPRICE");
				 dtm.addColumn("M_PURPRICE");
				 dtm.addColumn("M_RACKNO");
				 dtm.addColumn("M_SNAME");
				int count=0;
				 while(rs.next())
				 {
					 dtm.insertRow(count,new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getFloat(8),rs.getFloat(9),rs.getString(10),rs.getString(11)});
					 count++;
				 }
				 JScrollPane jsp  =new JScrollPane(table);
				 jsp.setBounds(15,400, 500,600);
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
			 }
		 } 
	  
	
}

}

