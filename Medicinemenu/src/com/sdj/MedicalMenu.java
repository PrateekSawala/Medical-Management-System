package com.sdj;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class MedicalMenu extends JFrame implements ActionListener
{
     
	 JMenuBar menu;
     JMenu su,me,ab,ex,re;
     JMenuItem anm,sm,um,dm,som,ans,ss,us,ds,los,dpr,exi;
     JLabel wtm;
     Font f = new Font("Dialog",Font.BOLD,26);

public MedicalMenu()
{
	
	wtm= new JLabel("               WELCOME TO MEDICAL STOCK MANAGEMENT SYSTEM");
    wtm.setFont(f);
	wtm.setBounds(2000,5000,2000,2000);
	add(wtm);
	wtm.setForeground(Color.black);
	menu  = new JMenuBar();
	su = new JMenu("Supplier");
	me=new JMenu("Medicine");
	re=new JMenu("Report");
	ab=new JMenu("About");
	ex=new JMenu("Exit");
	menu.add(su);
	menu.add(me);
	menu.add(re);
	menu.add(ab);
	menu.add(ex);
	anm=new JMenuItem("Add New Medicine");
	sm=new JMenuItem("Search Medicine");
	um	=new JMenuItem("update Medicine");
	dm =new JMenuItem("Delete in Medicine");
	som=new JMenuItem("Stock of Medicine");
	ans=new JMenuItem("Add New Supplier");
	ss=new JMenuItem("search supplier");
	us=new JMenuItem("update supplier");
	ds=new JMenuItem("delete supplier");
	los=new JMenuItem("list of supplier");
	dpr=new JMenuItem("Daily purchase report");
	exi=new JMenuItem("Exit");
    me.add(anm);
    me.add(sm);
    me.add(um);
    me.add(dm);
    me.add(som);
    su.add(ans);
    su.add(ss);
    su.add(us);
    su.add(ds);
    su.add(los);
    re.add(dpr);
    ex.add(exi);
	add(menu,BorderLayout.NORTH);
	anm.addActionListener(this);
    ans.addActionListener(this); 	
    ss.addActionListener(this);
    dpr.addActionListener(this);  
    exi.addActionListener(this);
    ds.addActionListener(this);
    us.addActionListener(this);
}

public void actionPerformed(ActionEvent e)
     {
        	   
    	 
    	    if(e.getSource()== anm){
             AddNewMedicine nm = new AddNewMedicine();
        	 nm.setVisible(true);
        	 nm.setSize(1200,700);
        	 nm.setTitle("New Medicine");
             }
                 
              if(e.getSource() == ans){
            	 AddNewSupplier ns = new AddNewSupplier();
             	 ns.setVisible(true);
             	 ns.setSize(1200,700);
             	 ns.setTitle("Add New Supplier");
                  
               }
             if(e.getSource() == ss ){
            	 SearchSupplier ss = new SearchSupplier();
             	 ss.setVisible(true);
             	 ss.setSize(1200,700);
             	 ss.setTitle("Add New Supplier");
                          }
 
             if(e.getSource() == dpr ){
                 Report re = new Report();
             	 re.setVisible(true);
             	 re.setSize(1200,700);
             	 re.setTitle(" REPORT ");
                         
                  }	

             if(e.getSource() == us){
            	 UpdateSupplier use = new UpdateSupplier();
             	 use.setVisible(true);
             	 use.setSize(1200,700);
             	 use.setTitle("UpdateSupplier");
             
              }
             
             if(e.getSource() == ds ){
                 DeleteSupplier dse = new DeleteSupplier();
             	 dse.setVisible(true);
             	 dse.setSize(1200,700);
             	 dse.setTitle("DeleteSupplier");
                         
                  }	
  
             if(e.getSource()==exi){
          	   System.exit(0);
          	 }
              
             
             
             
             
             
              
             

}	
	
}	
	
	
	
	
	
















