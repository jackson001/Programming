/*
 * Attend.java
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
/**
 *
 * @author King
 */
public class Attend extends JFrame implements KeyListener,ItemListener,ActionListener
{

    JLabel att,regno,name,photo,sem,sub,lab,workhrs,preshrs,month,year;
    JTextField regnotxt,nametxt,workhrstxt,preshrstxt;
    JComboBox semtxt,sublist,lablist,monthlist,yearlist;
    JButton clear,insert,exit,monthdet;
    JPanel jp;

    /** Creates a new instance of Attend */
    public Attend() {
         Toolkit kit=Toolkit.getDefaultToolkit();
            Dimension screenSize= kit.getScreenSize();
            setSize(screenSize.width,screenSize.height);

                setLayout(null);
                jp=new JPanel(null);
            jp.setBounds(0,10,screenSize.width,screenSize.height);
            jp.setBackground(new Color(236,233,216));
             getContentPane().add(jp);


                att=new JLabel();
                att.setText("Attendence Details");
                att.setFont(new Font("Sans-Serif",Font.BOLD+Font.ITALIC,50));
                att.setForeground(Color.red);
                att.setBounds(20,20,500,50);
                jp.add(att);


                regno=new JLabel();
                regno.setText("RegNo");
                regno.setFont(new Font("Arial",Font.BOLD,20));
                regno.setBounds(30,135,100,30);
                jp.add(regno);

                regnotxt=new JTextField();
                regnotxt.setFont(new Font("Arial",Font.BOLD,16));
                regnotxt.setBounds(175,135,200,30);
                jp.add(regnotxt);
                regnotxt.addKeyListener(this);

                name=new JLabel();
                name.setText("Name");
                name.setFont(new Font("Arial",Font.BOLD,20));
                name.setBounds(30,170,100,30);
                jp.add(name);

                nametxt=new JTextField();
                nametxt.setFont(new Font("Arial",Font.BOLD,16));
                nametxt.setBounds(175,170,200,30);
                jp.add(nametxt);
                nametxt.setEditable(false);

                photo = new JLabel(new ImageIcon(""));
		        photo.setBounds(600, 20, 100, 100);
                photo.setBorder(new LineBorder(Color.black,2));
		        jp.add(photo);
                 photo.setIcon(new ImageIcon("photo\\default.jpg"));

                sem=new JLabel("Semester");
                sem.setFont(new Font("Arial",Font.BOLD,20));
                sem.setBounds(30,205,100,30);
                jp.add(sem);

                semtxt=new JComboBox();
                semtxt.addItem("------------");
                semtxt.addItem("First");
                semtxt.addItem("Second");
                semtxt.addItem("Third");
                semtxt.addItem("Fourth");
                semtxt.setBounds(170,205,200,30);
                jp.add(semtxt);
                semtxt.addItemListener(this);

                sub=new JLabel("Subject");
                sub.setBounds(30,240,100,30);
                sub.setFont(new Font("Arial",Font.BOLD,20));
                jp.add(sub);

                sublist=new JComboBox();
                sublist.addItem("------------------");
                sublist.setBounds(170,240,200,30);
                jp.add(sublist);
                sublist.addItemListener(this);

                lab=new JLabel("Lab");
                lab.setBounds(450,240,100,30);
                lab.setFont(new Font("Arial",Font.BOLD,20));
                jp.add(lab);

                lablist=new JComboBox();
                lablist.addItem("Lab1");
                lablist.addItem("Lab2");
                lablist.setBounds(500,240,200,30);
                jp.add(lablist);

                month=new JLabel("Month");
                month.setBounds(30,275,100,30);
                month.setFont(new Font("Arial",Font.BOLD,20));
                jp.add(month);

                monthlist=new JComboBox();
                monthlist.setBounds(170,275,200,30);
                monthlist.addItem("-----------");
                monthlist.addItem("January");
                monthlist.addItem("February");
                monthlist.addItem("March");
                monthlist.addItem("April");
                monthlist.addItem("May");
                monthlist.addItem("June");
                monthlist.addItem("July");
                monthlist.addItem("August");
                monthlist.addItem("September");
                monthlist.addItem("October");
                monthlist.addItem("November");
                monthlist.addItem("December");
                jp.add(monthlist);
                monthlist.setFont(new Font("Arial",Font.BOLD,16));

                year=new JLabel("Year");
                year.setBounds(450,275,100,30);
                year.setFont(new Font("Arial",Font.BOLD,20));
                jp.add(year);

                yearlist=new JComboBox();
                yearlist.setBounds(500,275,100,30);
                yearlist.addItem("------");
                yearlist.addItem("2017");
                yearlist.addItem("2018");
                yearlist.addItem("2019");
                yearlist.addItem("2020");
                yearlist.addItem("2021");
                yearlist.addItem("2022");
                jp.add(yearlist);
                yearlist.setFont(new Font("Arial",Font.BOLD,16));
                yearlist.addItemListener(this);


                workhrs=new JLabel("Total Working Hours");
                workhrs.setBounds(30,400,300,30);
                workhrs.setFont(new Font("Arial",Font.BOLD,20));
                jp.add(workhrs);

                workhrstxt=new JTextField();
                workhrstxt.setBounds(350,400,50,30);
                workhrstxt.setFont(new Font("Arial",Font.BOLD,20));
                jp.add(workhrstxt);
                workhrstxt.setEditable(false);

                preshrs=new JLabel("Number of Hours Attended");
                preshrs.setBounds(30,450,300,30);
                preshrs.setFont(new Font("Arial",Font.BOLD,20));
                jp.add(preshrs);

                preshrstxt=new JTextField();
                preshrstxt.setBounds(350,450,50,30);
                preshrstxt.setFont(new Font("Arial",Font.BOLD,20));
                jp.add(preshrstxt);

                monthdet=new JButton("Month Details");
                monthdet.setFont(new Font("Arial",Font.BOLD,20));
                monthdet.setBounds(40,600,200,30);
                jp.add(monthdet);
                monthdet.addActionListener(this);
                monthdet.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
                monthdet.setMnemonic('M');
               monthdet.setBackground(new Color(102,102,102));
               monthdet.setForeground(Color.white);

                insert=new JButton("Insert");
                insert.setFont(new Font("Arial",Font.BOLD,20));
                insert.setBounds(260,600,100,30);
                jp.add(insert);
                insert.addActionListener(this);
                insert.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
               insert.setMnemonic('I');
               insert.setBackground(new Color(102,102,102));
               insert.setForeground(Color.white);

                clear=new JButton("Clear");
                clear.setFont(new Font("Arial",Font.BOLD,20));
                clear.setBounds(380,600,100,30);
                jp.add(clear);
                clear.addActionListener(this);
                clear.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
               clear.setMnemonic('C');
               clear.setBackground(new Color(102,102,102));
               clear.setForeground(Color.white);

                exit=new JButton("Exit");
                exit.setFont(new Font("Arial",Font.BOLD,20));
                exit.setBounds(500,600,100,30);
                exit.addActionListener(this);
                jp.add(exit);
                exit.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
               exit.setMnemonic('E');
               exit.setBackground(new Color(102,102,102));
               exit.setForeground(Color.white);

                setVisible(true);
                ImageIcon image = new javax.swing.ImageIcon(getClass().getResource("/image/icon9.png"));
        Image im = image.getImage();
        setIconImage(im);
    }
   public void keyPressed(KeyEvent ke)
  {

  }

  public void keyReleased(KeyEvent ke1)
  {
      if(ke1.getKeyCode()==KeyEvent.VK_ENTER)
      {

          photo.setIcon(new ImageIcon("photo\\" + regnotxt.getText() + ".jpg"));
          try
            {
                Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
                Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT *FROM studentdetails");

            int n=0;
            while(rs.next())
            {
                if(regnotxt.getText().equals(rs.getString(1)))
                {
                    nametxt.setText(rs.getString(2));
                    n++;
                }
            }
            if(n==0)
            {
                JOptionPane.showMessageDialog(null,"Record Not Found");
                regnotxt.setText("");
            }

            semtxt.setSelectedIndex(0);
            }
          catch(Exception eee){}
    }
  }
  public void keyTyped(KeyEvent ke2)
  {

  }
  public void itemStateChanged(ItemEvent evt)
  {

       try
            {
                Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
      if(evt.getItem().equals("First"))
      {
		sublist.removeAllItems();
		sublist.addItem("------------");
		sublist.addItem("Elementary Mathematics");
    		sublist.addItem("Probability and Statistics");
    		sublist.addItem("Introductory Programming");
    		sublist.addItem("Computer Organization");
    		sublist.addItem("Principles of Project Management");
    		sublist.addItem("Entrepreneurship");
		lablist.removeAllItems();
		  lablist.addItem("---------------");
		  lablist.addItem("Phyc Lab");
		  lablist.addItem("IT Lab");



      }
      else if(evt.getItem().equals("Second"))
      {
        sublist.removeAllItems();
        sublist.addItem("------------");
        sublist.addItem("Discrete Mathematics");
    	sublist.addItem("Computer Networks");
    	sublist.addItem("Data Structure");
    	sublist.addItem("Assembly Language");
    	sublist.addItem("Marketing Management");
    	sublist.addItem("Computer Ethics");
        lablist.removeAllItems();
        lablist.addItem("---------------");
        lablist.addItem("Data Structure Lab");
    	lablist.addItem("Software Tools Lab");

      }
      else if(evt.getItem().equals("Third"))
    	{
    		sublist.removeAllItems();
                sublist.addItem("------------");
    		sublist.addItem("File Structure");
    		sublist.addItem("Database Management Systems");
    		sublist.addItem("Principles of Prolog");
    		sublist.addItem("Operating System");
    		sublist.addItem("Decision Support Systems");
    		sublist.addItem("Computer Graphics");
    		lablist.removeAllItems();
    		lablist.addItem("---------------");
    		lablist.addItem("File Structure Lab");
    		lablist.addItem("DBMS Lab");
    	}
    	else if(evt.getItem().equals("Fourth"))
    	{
    		sublist.removeAllItems();
                sublist.addItem("------------");
    		sublist.addItem("Object Oriented Programming");
    		sublist.addItem("Design and Analysis of Algorithms");
    		sublist.addItem("Software Engineering");
    		sublist.addItem("Web Programming");
    		sublist.addItem("User Interface Design");
    		sublist.addItem("Network Security");
    		lablist.removeAllItems();
    		lablist.addItem("---------------");
    		lablist.addItem("Advance DBMS Lab");
    		lablist.addItem("Software Tools Lab1");
    	}
      else if(evt.getItem().equals(yearlist.getSelectedItem()))
      {

           String str=yearlist.getSelectedItem().toString();

           Statement st=con.createStatement();
           Statement st1=con.createStatement();
           String sti=monthlist.getSelectedItem().toString();
		  ResultSet rs3 = st.executeQuery("select *from " + semtxt.getSelectedItem().toString());
		  ResultSet rs4=st1.executeQuery("select *from MonthDetails");
		  System.out.println("Hello");
		  int n=0,m=0,j=0;;
		  while (rs3.next())
		  {

			  if ((regnotxt.getText().equals(rs3.getString(1))) && (sti.equals(rs3.getString(2))))

			{
				n++;
				if(sublist.getSelectedIndex()>0)
				{
					if(rs3.getInt(sublist.getSelectedIndex()*2+1)!=0)
					{
						m++;
					}
				}
				else
				{
					if(rs3.getInt(lablist.getSelectedIndex()*2+13)!=0)
					{
						m++;
					}
				}
			}


		 }

		  if (n == 0)
		  {
			  st.execute("INSERT INTO " + semtxt.getSelectedItem().toString() + " ( RegNo,Month ) VALUES(" + Integer.parseInt(regnotxt.getText()) + ",'"+monthlist.getSelectedItem().toString()+"')");
		  }

          if(m!=0)
          {
            JOptionPane.showMessageDialog(null,"Record Alread Exist");
            regnotxt.setText("");
          nametxt.setText("");
          lablist.setSelectedIndex(0);
          monthlist.setSelectedIndex(0);
          preshrstxt.setText("");
          semtxt.setSelectedIndex(0);
          workhrstxt.setText("");
          yearlist.setSelectedIndex(0);
          photo.setIcon(new ImageIcon("photo\\default.jpg"));
           }
          while(rs4.next())
          {
          	if(semtxt.getSelectedItem().equals(rs4.getString(1)) && monthlist.getSelectedItem().equals(rs4.getString(2)) && yearlist.getSelectedItem().equals(rs4.getString(3)))
     	     {
        	  workhrstxt.setText(rs4.getString(3+sublist.getSelectedIndex()));
          	j++;
  	       	}
    	}
    	if(j==0 && yearlist.getSelectedIndex()!=0)
    	{
    		JOptionPane.showMessageDialog(null,"Month Details Not Entered");
    		regnotxt.setText("");
          nametxt.setText("");
          lablist.setSelectedIndex(0);
          monthlist.setSelectedIndex(0);
          preshrstxt.setText("");
          semtxt.setSelectedIndex(0);
          workhrstxt.setText("");
          yearlist.setSelectedIndex(0);
          photo.setIcon(new ImageIcon("photo\\default.jpg"));

    	}
      }

    }
       catch(Exception tt){}

  }
  public void actionPerformed(ActionEvent ett)
  {
      try
            {
                Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");

            if(ett.getActionCommand().equals("Clear"))
            {
                 regnotxt.setText("");
                nametxt.setText("");
                semtxt.setSelectedIndex(0);
                sublist.setSelectedIndex(0);
                lablist.setSelectedIndex(0);
                monthlist.setSelectedIndex(0);
                yearlist.setSelectedIndex(0);
                 photo.setIcon(new ImageIcon("photo\\default.jpg"));


            }
        else if(ett.getActionCommand().equals("Insert"))
        {

		  if(Integer.parseInt(workhrstxt.getText())>=Integer.parseInt(preshrstxt.getText()))
		  {
		  String str=yearlist.getSelectedItem().toString();
		  String st1="",st2="";
		  if(sublist.getSelectedIndex()>0 && lablist.getSelectedIndex()==0)
		  {

          st2 = "sub"+sublist.getSelectedIndex();
        	}
        else if(lablist.getSelectedIndex()>0 && sublist.getSelectedIndex()==0)
        {

           st2 = "lab"+lablist.getSelectedIndex();
      	}
      else
      {
      	JOptionPane.showMessageDialog(this,"Incorrect Data");
      }

          Statement st=con.createStatement();
		  ResultSet rs4 = st.executeQuery("select *from " + semtxt.getSelectedItem().toString());
		  String strr=monthlist.getSelectedItem().toString();
		  while (rs4.next())
		  {
			  if ((regnotxt.getText().equals(rs4.getString(1))) && (monthlist.getSelectedItem().equals(rs4.getString(2))))
			  {

					  PreparedStatement st4 = con.prepareStatement("update " + semtxt.getSelectedItem().toString() + " set "+st2+ "=? where RegNo=? AND Month=?");
					  st4.setInt(2,Integer.parseInt(regnotxt.getText()));
					  st4.setString(3, strr);
					  st4.setInt(1, Integer.parseInt(preshrstxt.getText()));
					  st4.executeUpdate();

				  	JOptionPane.showMessageDialog(null, "Successfully Inserted");
				  	regnotxt.setText("");
          			nametxt.setText("");
          			lablist.setSelectedIndex(0);
          			monthlist.setSelectedIndex(0);
          			preshrstxt.setText("");
          			semtxt.setSelectedIndex(0);
          			workhrstxt.setText("");
          			yearlist.setSelectedIndex(0);

		  			}
	  	}
	  		}
	  		else
	  		{
	  			JOptionPane.showMessageDialog(null,"Present Hours should be less than working hours");
            }
 	}
 	else if(ett.getActionCommand().equals("Month Details"))
 	{
 		MonthDetails md=new MonthDetails();
 	}
 	else if(ett.getActionCommand().equals("Exit"))
 	{
 		int confirm = JOptionPane.showConfirmDialog(null, "Do you want to Exit", "Confirmation", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION)
			{
				this.dispose();
				Lecturer1 st = new Lecturer1();
			}

		}
 	}
      catch(Exception te){}
  }

    public static void main(String args[])
    {
        Attend adn=new Attend();
        adn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}