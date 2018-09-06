
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class MonthDetails extends JFrame implements ItemListener,ActionListener
{
	JComboBox monthlist,yearlist,semlist;
	JTextField sub1txt,sub2txt,sub3txt,sub4txt,sub5txt,sub6txt,lab1txt,lab2txt;
	JLabel month,year,sem,sub1,sub2,sub3,sub4,sub5,sub6,mon,lab1,lab2;
	JButton insert,clear,exit,modify;

	MonthDetails()
	{
	    //setSize(600,600);
        setLayout(null);
        setBounds(200,100,550,600);
        setTitle("MonthDetails");

        mon=new JLabel("Enter Month Details");
        mon.setFont(new Font("Sans-Serif",Font.BOLD+Font.ITALIC,25));
        mon.setForeground(Color.red);
        mon.setBounds(20,20,300,30);
        getContentPane().add(mon);

        sem=new JLabel("Semester");
        sem.setBounds(30,60,100,25);
        getContentPane().add(sem);

        semlist=new JComboBox();
        semlist.addItem("---------");
        semlist.addItem("First");
        semlist.addItem("Second");
        semlist.addItem("Third");
        semlist.addItem("Fourth");
        getContentPane().add(semlist);
        semlist.setBounds(150,60,100,25);
        semlist.addItemListener(this);

        month=new JLabel("Month");
        month.setBounds(30,105,100,25);
        getContentPane().add(month);

        monthlist=new JComboBox();
        monthlist.addItem("--------");
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
        getContentPane().add(monthlist);
        monthlist.setBounds(150,105,100,25);
        monthlist.addItemListener(this);

        year=new JLabel("Year");
        year.setBounds(30,150,100,25);
        getContentPane().add(year);

        yearlist=new JComboBox();
        yearlist.addItem("------");
        yearlist.addItem("2017");
        yearlist.addItem("2018");
        yearlist.addItem("2019");
        yearlist.addItem("2020");
        yearlist.addItem("2021");
        yearlist.addItem("2022");
        getContentPane().add(yearlist);
        yearlist.setBounds(150,150,100,25);
        yearlist.addItemListener(this);

        sub1=new JLabel("Subject1");
        sub1.setBounds(30,195,150,25);
        getContentPane().add(sub1);

        sub1txt=new JTextField();
        sub1txt.setBounds(200,195,50,25);
        getContentPane().add(sub1txt);

        sub2=new JLabel("Subject2");
        sub2.setBounds(270,195,150,25);
        getContentPane().add(sub2);

        sub2txt=new JTextField();
        sub2txt.setBounds(440,195,50,25);
        getContentPane().add(sub2txt);

        sub3=new JLabel("Subject3");
        sub3.setBounds(30,240,150,25);
        getContentPane().add(sub3);

        sub3txt=new JTextField();
        sub3txt.setBounds(200,240,50,25);
        getContentPane().add(sub3txt);

        sub4=new JLabel("Subject4");
        sub4.setBounds(270,240,150,25);
        getContentPane().add(sub4);

        sub4txt=new JTextField();
        sub4txt.setBounds(440,240,50,25);
        getContentPane().add(sub4txt);

        sub5=new JLabel("Subject5");
        sub5.setBounds(30,285,150,25);
        getContentPane().add(sub5);

        sub5txt=new JTextField();
        sub5txt.setBounds(200,285,50,25);
        getContentPane().add(sub5txt);

        sub6=new JLabel("Subject 6");
        sub6.setBounds(270,285,150,25);
        getContentPane().add(sub6);

        sub6txt=new JTextField();
        sub6txt.setBounds(440,285,50,25);
        getContentPane().add(sub6txt);

        lab1=new JLabel("Lab1");
        lab1.setBounds(30,330,150,25);
        getContentPane().add(lab1);

        lab1txt=new JTextField();
        lab1txt.setBounds(200,330,50,25);
        getContentPane().add(lab1txt);

        lab2=new JLabel("Lab2");
        lab2.setBounds(270,330,150,25);
        getContentPane().add(lab2);

        lab2txt=new JTextField();
        lab2txt.setBounds(440,330,50,25);
        getContentPane().add(lab2txt);

        insert=new JButton("Insert");
        insert.setBounds(50,500,100,30);
        getContentPane().add(insert);
        insert.addActionListener(this);

        clear=new JButton("Clear");
        clear.setBounds(170,500,100,30);
        getContentPane().add(clear);
        clear.addActionListener(this);

        modify=new JButton("Modify");
        modify.setBounds(290,500,100,30);
        getContentPane().add(modify);
        modify.addActionListener(this);

        exit=new JButton("Exit");
        exit.setBounds(410,500,100,30);
        getContentPane().add(exit);
        exit.addActionListener(this);

        ImageIcon image = new javax.swing.ImageIcon(getClass().getResource("/image/icon9.png"));
        Image im = image.getImage();
        setIconImage(im);
        setVisible(true);

    }
    public void itemStateChanged(ItemEvent ie)
    {
    	sub1txt.setText("");
		sub2txt.setText("");
		sub3txt.setText("");
		sub4txt.setText("");
		sub5txt.setText("");
		sub6txt.setText("");
		lab1txt.setText("");
		lab2txt.setText("");

        if(ie.getItem().equals("First"))
    	{
    		monthlist.setSelectedIndex(0);
            yearlist.setSelectedIndex(0);
            sub1.setText("Elementary Mathematics");
    		sub2.setText("Probability and Statistics");
    		sub3.setText("Introductory Programming");
    		sub4.setText("Computer Organization");
    		sub5.setText("Principles of Project Management");
    		sub6.setText("Entrepreneurship");
    		lab1.setText("Phyc Lab");
    		lab2.setText("IT Lab");
    	}
    	else if(ie.getItem().equals("Second"))
    	{
    		monthlist.setSelectedIndex(0);
            yearlist.setSelectedIndex(0);
            sub1.setText("Discrete Mathematics");
    		sub2.setText("Computer Networks");
    		sub3.setText("Data Structure");
    		sub4.setText("Assembly Language");
    		sub5.setText("Marketing Management");
    		sub6.setText("Computer Ethics");
    		lab1.setText("Data Structure Lab");
    		lab2.setText("Software Tools Lab");
    	}
    	else if(ie.getItem().equals("Third"))
    	{
    		monthlist.setSelectedIndex(0);
            yearlist.setSelectedIndex(0);
    		sub1.setText("File Structure");
    		sub2.setText("Database Management Systems");
    		sub3.setText("Principles of Prolog");
    		sub4.setText("Operating Systems");
    		sub5.setText("Decision Support Systems");
    		sub6.setText("Computer Graphics");
    		lab1.setText("File Structure Lab");
    		lab2.setText("DBMS Lab");
    	}
    	else if(ie.getItem().equals("Fourth"))
    	{
    		monthlist.setSelectedIndex(0);
            yearlist.setSelectedIndex(0);
    		sub1.setText("Object Oriented Programming");
    		sub2.setText("Design and Analysis of Algorithms");
    		sub3.setText("Software Engineering");
    		sub4.setText("Web Programming");
    		sub5.setText("User Interface Design");
    		sub6.setText("Network Security");
    		lab1.setText("Advance DBMS Lab");
    		lab2.setText("Software Tools Lab1");
    	}
    	else if(ie.getItem().equals(yearlist.getSelectedItem()))
    	{

    	try
    		{
    		Class.forName("com.mysql.jdbc.Driver");
        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
        	Statement st=conn.createStatement();
        	ResultSet rs=st.executeQuery("select * from monthdetails");
        	while(rs.next())
        	{
        		if(semlist.getSelectedItem().equals(rs.getString(1)) && monthlist.getSelectedItem().equals(rs.getString(2)) && yearlist.getSelectedItem().equals(rs.getString(3)))
        		{

        			sub1txt.setText(rs.getString(4));
    			sub2txt.setText(rs.getString(5));
    			sub3txt.setText(rs.getString(6));
    			sub4txt.setText(rs.getString(7));
    			sub5txt.setText(rs.getString(8));
    			sub6txt.setText(rs.getString(9));
    			lab1txt.setText(rs.getString(10));
    			lab2txt.setText(rs.getString(11));
        		JOptionPane.showMessageDialog(null,"Record Aleardy Exist");
        		}

        	}
        	}
        	catch(Exception e){}
        }
        	else if(ie.getItem().equals(monthlist.getSelectedItem()))
        	{
        		sub1txt.setText("");
				sub2txt.setText("");
				sub3txt.setText("");
				sub4txt.setText("");
				sub5txt.setText("");
				sub6txt.setText("");
				lab1txt.setText("");
				lab2txt.setText("");
				yearlist.setSelectedIndex(0);
		}
  }
public void actionPerformed(ActionEvent ae)
{
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");

	if(ae.getActionCommand().equals("Insert"))
	{
		PreparedStatement st=conn.prepareStatement("insert into monthdetails values (?,?,?,?,?,?,?,?,?,?,?)");
		st.setString(1,semlist.getSelectedItem().toString());
		st.setString(2,monthlist.getSelectedItem().toString());
		st.setString(3,yearlist.getSelectedItem().toString());
		st.setInt(4,Integer.parseInt(sub1txt.getText()));
		st.setInt(5,Integer.parseInt(sub2txt.getText()));
		st.setInt(6,Integer.parseInt(sub3txt.getText()));
		st.setInt(7,Integer.parseInt(sub4txt.getText()));
		st.setInt(8,Integer.parseInt(sub5txt.getText()));
		st.setInt(9,Integer.parseInt(sub6txt.getText()));
		st.setInt(10,Integer.parseInt(lab1txt.getText()));
		st.setInt(11,Integer.parseInt(lab2txt.getText()));
		st.execute();
		JOptionPane.showMessageDialog(null,"Inserted Successfully");
		sub1txt.setText("");
		sub2txt.setText("");
		sub3txt.setText("");
		sub4txt.setText("");
		sub5txt.setText("");
		sub6txt.setText("");
		lab1txt.setText("");
		lab2txt.setText("");

	}
	else if(ae.getActionCommand().equals("Clear"))
	{
		semlist.setSelectedIndex(0);
		monthlist.setSelectedIndex(0);
		yearlist.setSelectedIndex(0);
		sub1txt.setText("");
		sub2txt.setText("");
		sub3txt.setText("");
		sub4txt.setText("");
		sub5txt.setText("");
		sub6txt.setText("");
		lab1txt.setText("");
		lab2txt.setText("");
	}
	else if(ae.getActionCommand().equals("Modify"))
	{


		PreparedStatement st=conn.prepareStatement("update monthdetails set Sub1=?,Sub2=?,Sub3=?,Sub4=?,Sub5=?,Sub6=?,Lab1=?,Lab2=? where Sem=? and Month=? and Year=?");
		st.setInt(1,Integer.parseInt(sub1txt.getText()));
		st.setInt(2,Integer.parseInt(sub2txt.getText()));
		st.setInt(3,Integer.parseInt(sub3txt.getText()));
		st.setInt(4,Integer.parseInt(sub4txt.getText()));
		st.setInt(5,Integer.parseInt(sub5txt.getText()));
		st.setInt(6,Integer.parseInt(sub6txt.getText()));
		st.setInt(7,Integer.parseInt(lab1txt.getText()));
		st.setInt(8,Integer.parseInt(lab2txt.getText()));
		st.setString(9,semlist.getSelectedItem().toString());
		st.setString(10,monthlist.getSelectedItem().toString());
		st.setInt(11,Integer.parseInt(yearlist.getSelectedItem().toString()));
		st.execute();
		JOptionPane.showMessageDialog(null,"Modified Successfully");
		sub1txt.setText("");
		sub2txt.setText("");
		sub3txt.setText("");
		sub4txt.setText("");
		sub5txt.setText("");
		sub6txt.setText("");
		lab1txt.setText("");
		lab2txt.setText("");

	}
	else if(ae.getActionCommand().equals("Exit"))
	{
		int confirm = JOptionPane.showConfirmDialog(null, "Do you want to Exit", "Confirmation", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION)
			{
				this.dispose();

			}
	}
	}
	catch(Exception er){
        JOptionPane.showConfirmDialog(null,er);
        }
}
    public static void main(String arg[])
    {
    	MonthDetails md=new MonthDetails();
	}
}