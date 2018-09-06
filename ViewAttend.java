
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

public class ViewAttend extends JFrame implements ItemListener,ActionListener,KeyListener
{
	JLabel att,regno,name,photo,sub1,sub2,sub3,sub4,sub5,sub6,lab1,lab2,sem,month,year,work,pres,twork,tpres,tworklab,tpreslab,tot,prec;
	JTextField regnotxt,nametxt,sub1txt,sub2txt,sub3txt,sub4txt,sub5txt,sub6txt,lab1txt,lab2txt;
	JTextField wsub1txt,wsub2txt,wsub3txt,wsub4txt,wsub5txt,wsub6txt,wlab1txt,wlab2txt;
	JTextField tworktxt,tprestxt,tworklabtxt,tpreslabtxt,tottxt,prectxt;
	JButton view,clear,modify,exit,next,previous,generate;
	JComboBox semtxt,yearlist,monthlist;
	JList monthtxt;
	JPanel jp;


	ViewAttend()
	{
		Toolkit kit=Toolkit.getDefaultToolkit();
            Dimension screenSize= kit.getScreenSize();
            setSize(screenSize.width,screenSize.height);

                setLayout(null);
                jp=new JPanel(null);
            jp.setBounds(0,10,screenSize.width,screenSize.height);
            jp.setBackground(new Color(236,233,216));
             getContentPane().add(jp);


                att=new JLabel();
                att.setText("View Attendence Details");
                att.setFont(new Font("Sans-Serif",Font.BOLD+Font.ITALIC,40));
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

                month=new JLabel("Month");
                month.setBounds(400,205,70,30);
                month.setFont(new Font("Arial",Font.BOLD,20));
                jp.add(month);


               // String[] mon={"------","January","February","March","April","May","June","July","August","September","October","November","December"};

                monthlist=new JComboBox();
                monthlist.setBounds(490,205,130,30);
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
                year.setBounds(640,205,70,30);
                year.setFont(new Font("Arial",Font.BOLD,20));
                jp.add(year);

                yearlist=new JComboBox();
                yearlist.setBounds(730,205,100,30);
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

                work=new JLabel("Working Hours");
                work.setFont(new Font("Arial",Font.BOLD,16));
                work.setBounds(275,240,150,30);
                jp.add(work);

                pres=new JLabel("Present Hours");
                pres.setFont(new Font("Arial",Font.BOLD,16));
                pres.setBounds(425,240,150,30);
                jp.add(pres);


                sub1=new JLabel("Subject 1");
                sub1.setFont(new Font("Arial",Font.BOLD,16));
                sub1.setBounds(30,275,250,30);
                jp.add(sub1);

                wsub1txt=new JTextField();
                wsub1txt.setFont(new Font("Arial",Font.BOLD,16));
                wsub1txt.setBounds(300,275,50,30);
                jp.add(wsub1txt);
                wsub1txt.setEditable(false);

                sub1txt=new JTextField();
                sub1txt.setFont(new Font("Arial",Font.BOLD,16));
                sub1txt.setBounds(450,275,50,30);
                jp.add(sub1txt);

                sub2=new JLabel("Subject 2");
                sub2.setFont(new Font("Arial",Font.BOLD,16));
                sub2.setBounds(30,310,250,30);
                jp.add(sub2);

                wsub2txt=new JTextField();
                wsub2txt.setFont(new Font("Arial",Font.BOLD,16));
                wsub2txt.setBounds(300,310,50,30);
                jp.add(wsub2txt);
                wsub2txt.setEditable(false);


                sub2txt=new JTextField();
                sub2txt.setFont(new Font("Arial",Font.BOLD,16));
                sub2txt.setBounds(450,310,50,30);
                jp.add(sub2txt);

                sub3=new JLabel("Subject 3");
                sub3.setFont(new Font("Arial",Font.BOLD,16));
                sub3.setBounds(30,345,250,30);
                jp.add(sub3);

                wsub3txt=new JTextField();
                wsub3txt.setFont(new Font("Arial",Font.BOLD,16));
                wsub3txt.setBounds(300,345,50,30);
                jp.add(wsub3txt);
                wsub3txt.setEditable(false);

                sub3txt=new JTextField();
                sub3txt.setFont(new Font("Arial",Font.BOLD,16));
                sub3txt.setBounds(450,345,50,30);
                jp.add(sub3txt);

                twork=new JLabel("Total Working Hours");
                twork.setFont(new Font("Arial",Font.BOLD,16));
                twork.setBounds(600,345,200,30);
                jp.add(twork);

                tworktxt=new JTextField();
                tworktxt.setFont(new Font("Arial",Font.BOLD,16));
                tworktxt.setBounds(820,345,50,30);
                jp.add(tworktxt);
                tworktxt.setEditable(false);

                sub4=new JLabel("Subject 4");
                sub4.setFont(new Font("Arial",Font.BOLD,16));
                sub4.setBounds(30,380,250,30);
                jp.add(sub4);

                wsub4txt=new JTextField();
                wsub4txt.setFont(new Font("Arial",Font.BOLD,16));
                wsub4txt.setBounds(300,380,50,30);
                jp.add(wsub4txt);
                wsub4txt.setEditable(false);

                sub4txt=new JTextField();
                sub4txt.setFont(new Font("Arial",Font.BOLD,16));
                sub4txt.setBounds(450,380,50,30);
                jp.add(sub4txt);

                tpres=new JLabel("Present Working Hours");
                tpres.setFont(new Font("Arial",Font.BOLD,16));
                tpres.setBounds(600,380,200,30);
                jp.add(tpres);

                tprestxt=new JTextField();
                tprestxt.setFont(new Font("Arial",Font.BOLD,16));
                tprestxt.setBounds(820,380,50,30);
                jp.add(tprestxt);
                tprestxt.setEditable(false);

                sub5=new JLabel("Subject 5");
                sub5.setFont(new Font("Arial",Font.BOLD,16));
                sub5.setBounds(30,415,250,30);
                jp.add(sub5);

                wsub5txt=new JTextField();
                wsub5txt.setFont(new Font("Arial",Font.BOLD,16));
                wsub5txt.setBounds(300,415,50,30);
                jp.add(wsub5txt);
                wsub5txt.setEditable(false);

                sub5txt=new JTextField();
                sub5txt.setFont(new Font("Arial",Font.BOLD,16));
                sub5txt.setBounds(450,415,50,30);
                jp.add(sub5txt);

                tworklab=new JLabel("Lab Working Hours");
                tworklab.setFont(new Font("Arial",Font.BOLD,16));
                tworklab.setBounds(600,415,200,30);
                jp.add(tworklab);

                tworklabtxt=new JTextField();
                tworklabtxt.setFont(new Font("Arial",Font.BOLD,16));
                tworklabtxt.setBounds(820,415,50,30);
                jp.add(tworklabtxt);
                tworklabtxt.setEditable(false);

                sub6=new JLabel("Subject 6");
                sub6.setFont(new Font("Arial",Font.BOLD,16));
                sub6.setBounds(30,450,250,30);
                jp.add(sub6);

                wsub6txt=new JTextField();
                wsub6txt.setFont(new Font("Arial",Font.BOLD,16));
                wsub6txt.setBounds(300,450,50,30);
                jp.add(wsub6txt);
                wsub6txt.setEditable(false);

                sub6txt=new JTextField();
                sub6txt.setFont(new Font("Arial",Font.BOLD,16));
                sub6txt.setBounds(450,450,50,30);
                jp.add(sub6txt);

                tworklab=new JLabel("Lab Present Hours");
                tworklab.setFont(new Font("Arial",Font.BOLD,16));
                tworklab.setBounds(600,450,200,30);
                jp.add(tworklab);

                tpreslabtxt=new JTextField();
                tpreslabtxt.setFont(new Font("Arial",Font.BOLD,16));
                tpreslabtxt.setBounds(820,450,50,30);
                jp.add(tpreslabtxt);
                tpreslabtxt.setEditable(false);

                lab1=new JLabel("Lab 1");
                lab1.setFont(new Font("Arial",Font.BOLD,16));
                lab1.setBounds(30,485,250,30);
                jp.add(lab1);

                wlab1txt=new JTextField();
                wlab1txt.setFont(new Font("Arial",Font.BOLD,16));
                wlab1txt.setBounds(300,485,50,30);
                jp.add(wlab1txt);
                wlab1txt.setEditable(false);

                lab1txt=new JTextField();
                lab1txt.setFont(new Font("Arial",Font.BOLD,16));
                lab1txt.setBounds(450,485,50,30);
                jp.add(lab1txt);

                tot=new JLabel("Total Present Hours");
                tot.setFont(new Font("Arial",Font.BOLD,16));
                tot.setBounds(600,485,200,30);
                jp.add(tot);

                tottxt=new JTextField();
                tottxt.setFont(new Font("Arial",Font.BOLD,16));
                tottxt.setBounds(820,485,50,30);
                jp.add(tottxt);
                tottxt.setEditable(false);

                lab2=new JLabel("Lab 2");
                lab2.setFont(new Font("Arial",Font.BOLD,16));
                lab2.setBounds(30,520,250,30);
                jp.add(lab2);

                wlab2txt=new JTextField();
                wlab2txt.setFont(new Font("Arial",Font.BOLD,16));
                wlab2txt.setBounds(300,520,50,30);
                jp.add(wlab2txt);
                wlab2txt.setEditable(false);

                lab2txt=new JTextField();
                lab2txt.setFont(new Font("Arial",Font.BOLD,16));
                lab2txt.setBounds(450,520,50,30);
                jp.add(lab2txt);

                prec=new JLabel("Percentage");
                prec.setFont(new Font("Arial",Font.BOLD,16));
                prec.setBounds(600,520,200,30);
                jp.add(prec);

                prectxt=new JTextField();
                prectxt.setFont(new Font("Arial",Font.BOLD,16));
                prectxt.setBounds(820,520,50,30);
                jp.add(prectxt);
                prectxt.setEditable(false);

                clear=new JButton("Clear");
                clear.setFont(new Font("Arial",Font.BOLD,16));
                clear.setBounds(30,600,100,30);
                jp.add(clear);
                clear.addActionListener(this);
                clear.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
               clear.setMnemonic('C');
               clear.setBackground(new Color(102,102,102));
               clear.setForeground(Color.white);

                previous=new JButton("Previous");
                previous.setFont(new Font("Arial",Font.BOLD,16));
                previous.setBounds(150,600,110,30);
                jp.add(previous);
                previous.addActionListener(this);
                previous.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
               previous.setMnemonic('P');
               previous.setBackground(new Color(102,102,102));
               previous.setForeground(Color.white);

                view=new JButton("View");
                view.setFont(new Font("Arial",Font.BOLD,16));
                view.setBounds(270,600,100,30);
                jp.add(view);
                view.addActionListener(this);
                view.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
               view.setMnemonic('V');
               view.setBackground(new Color(102,102,102));
               view.setForeground(Color.white);

                next=new JButton("Next");
                next.setFont(new Font("Arial",Font.BOLD,16));
                next.setBounds(390,600,100,30);
                jp.add(next);
                next.addActionListener(this);
                next.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
               next.setMnemonic('N');
               next.setBackground(new Color(102,102,102));
               next.setForeground(Color.white);

                modify=new JButton("Modify");
                modify.setFont(new Font("Arial",Font.BOLD,16));
                modify.setBounds(510,600,100,30);
                jp.add(modify);
                modify.addActionListener(this);
                modify.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
               modify.setMnemonic('M');
               modify.setBackground(new Color(102,102,102));
               modify.setForeground(Color.white);

                exit=new JButton("Exit");
                exit.setFont(new Font("Arial",Font.BOLD,16));
                exit.setBounds(620,600,100,30);
                jp.add(exit);
                exit.addActionListener(this);
                exit.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
               exit.setMnemonic('E');
               exit.setBackground(new Color(102,102,102));
               exit.setForeground(Color.white);

                generate=new JButton("Generate");
                generate.setFont(new Font("Arial",Font.BOLD,16));
                generate.setBounds(740,600,120,30);
                jp.add(generate);
                generate.addActionListener(this);
                generate.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
               generate.setMnemonic('G');
               generate.setBackground(new Color(102,102,102));
               generate.setForeground(Color.white);

                setVisible(true);
                ImageIcon image = new javax.swing.ImageIcon(getClass().getResource("/image/icon9.png"));
                Image im = image.getImage();
                setIconImage(im);
                addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            int confirm = JOptionPane.showConfirmDialog(null, "Do you want to Exit?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION)
        {
            dispose();
        }
            }
        });

    }
    public void itemStateChanged(ItemEvent ie)
    {

    	try
    	{
    	Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
        if(ie.getItem().equals("First"))
    	{
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
    		int t=0;
    		Statement st=conn.createStatement();
    		Statement st1=conn.createStatement();
    		ResultSet rs1=st1.executeQuery("select *from MonthDetails");
    		ResultSet rs=st.executeQuery("select *from "+semtxt.getSelectedItem().toString());

    				while(rs1.next())
    				{

    					if(semtxt.getSelectedItem().equals(rs1.getString(1)) && monthlist.getSelectedItem().equals(rs1.getString(2)) && yearlist.getSelectedItem().equals(rs1.getString(3)))
    					{

    					wsub1txt.setText(rs1.getString(4));
    					wsub2txt.setText(rs1.getString(5));
    					wsub3txt.setText(rs1.getString(6));
						wsub4txt.setText(rs1.getString(7));
    					wsub5txt.setText(rs1.getString(8));
	    				wsub6txt.setText(rs1.getString(9));
	    				wlab1txt.setText(rs1.getString(10));
	    				wlab2txt.setText(rs1.getString(11));
	    				while(rs.next())
    					{
    					if(regnotxt.getText().equals(rs.getString(1)) && monthlist.getSelectedItem().equals(rs.getString(2)))
    						{
	    		  				sub1txt.setText(rs.getString(3));
	    		  				sub2txt.setText(rs.getString(4));
	    		  				sub3txt.setText(rs.getString(5));
	    		  				sub4txt.setText(rs.getString(6));
	    		  				sub5txt.setText(rs.getString(7));
	    		  				sub6txt.setText(rs.getString(8));
	    		  				lab1txt.setText(rs.getString(9));
	    		  				lab2txt.setText(rs.getString(10));
	    		  			Integer twh,tph,lwh,lph,tw,tp;
	    		  			Float pre;
	    		  			twh=Integer.parseInt(wsub1txt.getText())+Integer.parseInt(wsub2txt.getText())+Integer.parseInt(wsub3txt.getText())+Integer.parseInt(wsub4txt.getText())+Integer.parseInt(wsub5txt.getText())+Integer.parseInt(wsub6txt.getText());
	    		  			tph=Integer.parseInt(sub1txt.getText())+Integer.parseInt(sub2txt.getText())+Integer.parseInt(sub3txt.getText())+Integer.parseInt(sub4txt.getText())+Integer.parseInt(sub5txt.getText())+Integer.parseInt(sub6txt.getText());
	    		  			lwh=Integer.parseInt(wlab1txt.getText())+Integer.parseInt(wlab2txt.getText());
	    		  			lph=Integer.parseInt(lab1txt.getText())+Integer.parseInt(lab2txt.getText());
	    		  			tw=twh+lwh;
	    		  			tp=tph+lph;
	    		  			pre=(tp.floatValue()/tw)*100;
	  						System.out.println(pre);
	    		  			tprestxt.setText(tph.toString());
	    		  			tworktxt.setText(twh.toString());
	    		  			tworklabtxt.setText(lwh.toString());
	    		  			tpreslabtxt.setText(lph.toString());
	    		  			tottxt.setText(tp.toString());
	    		  			prectxt.setText(pre.toString().subSequence(0,5).toString());
	    		  			t++;

	    		  			}
	  			 		}

	  	    		}
				}
				if(t==0)
				{
					JOptionPane.showMessageDialog(null,"Record Not Entered");
				}
		}
	}
	catch(Exception exc){}
}

public void actionPerformed(ActionEvent ae)
{
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
	if(ae.getActionCommand().equals("Clear"))
	{

		lab1txt.setText("");

		lab2.setText("");
		monthlist.setSelectedIndex(0);
		nametxt.setText("");
		photo.setIcon(new ImageIcon("photo\\default.jpg"));
		prectxt.setText("");
		regnotxt.setText("");
		semtxt.setSelectedIndex(0);
		wsub1txt.setText("");
		sub1txt.setText("");
		wsub2txt.setText("");
		sub2txt.setText("");
		wsub3txt.setText("");
		sub3txt.setText("");
		wsub4txt.setText("");
		sub4txt.setText("");
		wsub5txt.setText("");
		sub5txt.setText("");
		wsub6txt.setText("");
		sub6txt.setText("");
		wlab1txt.setText("");
		lab1txt.setText("");
		wlab2txt.setText("");
		lab2txt.setText("");
		tprestxt.setText("");
	    tworktxt.setText("");
	    tworklabtxt.setText("");
	    tpreslabtxt.setText("");
	    tottxt.setText("");
	    prectxt.setText("");

	}
	else if(ae.getActionCommand().equals("View"))
	{
    		int t=0;
    		Statement st=conn.createStatement();
    		Statement st1=conn.createStatement();
    		ResultSet rs1=st1.executeQuery("select *from MonthDetails");
    		ResultSet rs=st.executeQuery("select *from "+semtxt.getSelectedItem().toString());

    		while(rs.next())
    		{
    			if(regnotxt.getText().equals(rs.getString(1)) && monthlist.getSelectedItem().equals(rs.getString(2)))
    			{
    				while(rs1.next())
    				{
    					if(semtxt.getSelectedItem().equals(rs1.getString(1)) && monthlist.getSelectedItem().equals(rs1.getString(2)) && yearlist.getSelectedItem().equals(rs1.getString(3)))
    					{
    					wsub1txt.setText(rs1.getString(4));
    					sub1txt.setText(rs.getString(3));
    					wsub2txt.setText(rs1.getString(5));
    					sub2txt.setText(rs.getString(4));
    					wsub3txt.setText(rs1.getString(6));
						sub3txt.setText(rs.getString(5));
						wsub4txt.setText(rs1.getString(7));
    					sub4txt.setText(rs.getString(6));
    					wsub5txt.setText(rs1.getString(8));
	    				sub5txt.setText(rs.getString(7));
	    				wsub6txt.setText(rs1.getString(9));
	    				sub6txt.setText(rs.getString(8));
	    				wlab1txt.setText(rs1.getString(10));
	    				lab1txt.setText(rs.getString(9));
	    				wlab2txt.setText(rs1.getString(11));
	    				lab2txt.setText(rs.getString(10));
	    				t++;

	    		  	Integer twh,tph,lwh,lph,tw,tp;
	    		  	Float pre;
	    		  	twh=Integer.parseInt(wsub1txt.getText())+Integer.parseInt(wsub2txt.getText())+Integer.parseInt(wsub3txt.getText())+Integer.parseInt(wsub4txt.getText())+Integer.parseInt(wsub5txt.getText())+Integer.parseInt(wsub6txt.getText());
	    		  	tph=Integer.parseInt(sub1txt.getText())+Integer.parseInt(sub2txt.getText())+Integer.parseInt(sub3txt.getText())+Integer.parseInt(sub4txt.getText())+Integer.parseInt(sub5txt.getText())+Integer.parseInt(sub6txt.getText());
	    		  	lwh=Integer.parseInt(wlab1txt.getText())+Integer.parseInt(wlab2txt.getText());
	    		  	lph=Integer.parseInt(lab1txt.getText())+Integer.parseInt(lab2txt.getText());
	    		  	tw=twh+lwh;
	    		  	tp=tph+lph;
	    		  	pre=(tp.floatValue()/tw)*100;
	  				System.out.println(pre);
	    		  	tprestxt.setText(tph.toString());
	    		  	tworktxt.setText(twh.toString());
	    		  	tworklabtxt.setText(lwh.toString());
	    		  	tpreslabtxt.setText(lph.toString());
	    		  	tottxt.setText(tp.toString());
	    		  	prectxt.setText(pre.toString().subSequence(0,5).toString());
	    		  		int pst = Integer.parseInt(regnotxt.getText());
	    		  	photo.setIcon(new ImageIcon("photo\\" + pst + ".jpg"));
	    		  }
	  			 }

	  	    	}
			}
			if(t==0)
	    	{
	    		JOptionPane.showMessageDialog(null,"Record Not Found");
	   		}
	}
	else if(ae.getActionCommand().equals("Previous"))
	{
		   int t=0;
    		Statement st=conn.createStatement();
    		Statement st1=conn.createStatement();
    		Statement st2=conn.createStatement();
    		ResultSet rs1=st1.executeQuery("select *from MonthDetails");
    		ResultSet rs=st.executeQuery("select *from "+semtxt.getSelectedItem().toString());
    		Integer tt=Integer.parseInt(regnotxt.getText())-1;
      		regnotxt.setText(tt.toString());
    		while(rs.next())
    		{
    			if(regnotxt.getText().equals(rs.getString(1)) && monthlist.getSelectedItem().equals(rs.getString(2)))
    			{
    				while(rs1.next())
    				{
    					if(semtxt.getSelectedItem().equals(rs1.getString(1)) && monthlist.getSelectedItem().equals(rs1.getString(2)) && yearlist.getSelectedItem().equals(rs1.getString(3)))
    					{
    					ResultSet rs2=st2.executeQuery("select *from personal");
                        while(rs2.next())
                        {
                            if(rs2.getString(1).equals(regnotxt.getText()))
                            nametxt.setText(rs2.getString(2));
                        }
                        wsub1txt.setText(rs1.getString(4));
    					sub1txt.setText(rs.getString(3));
    					wsub2txt.setText(rs1.getString(5));
    					sub2txt.setText(rs.getString(4));
    					wsub3txt.setText(rs1.getString(6));
						sub3txt.setText(rs.getString(5));
						wsub4txt.setText(rs1.getString(7));
    					sub4txt.setText(rs.getString(6));
    					wsub5txt.setText(rs1.getString(8));
	    				sub5txt.setText(rs.getString(7));
	    				wsub6txt.setText(rs1.getString(9));
	    				sub6txt.setText(rs.getString(8));
	    				wlab1txt.setText(rs1.getString(10));
	    				lab1txt.setText(rs.getString(9));
	    				wlab2txt.setText(rs1.getString(11));
	    				lab2txt.setText(rs.getString(10));
	    				t++;

	    		  	Integer twh,tph,lwh,lph,tw,tp;
	    		  	Float pre;
	    		  	twh=Integer.parseInt(wsub1txt.getText())+Integer.parseInt(wsub2txt.getText())+Integer.parseInt(wsub3txt.getText())+Integer.parseInt(wsub4txt.getText())+Integer.parseInt(wsub5txt.getText())+Integer.parseInt(wsub6txt.getText());
	    		  	tph=Integer.parseInt(sub1txt.getText())+Integer.parseInt(sub2txt.getText())+Integer.parseInt(sub3txt.getText())+Integer.parseInt(sub4txt.getText())+Integer.parseInt(sub5txt.getText())+Integer.parseInt(sub6txt.getText());
	    		  	lwh=Integer.parseInt(wlab1txt.getText())+Integer.parseInt(wlab2txt.getText());
	    		  	lph=Integer.parseInt(lab1txt.getText())+Integer.parseInt(lab2txt.getText());
	    		  	tw=twh+lwh;
	    		  	tp=tph+lph;
	    		  	pre=(tp.floatValue()/tw)*100;
	  				System.out.println(pre);
	    		  	tprestxt.setText(tph.toString());
	    		  	tworktxt.setText(twh.toString());
	    		  	tworklabtxt.setText(lwh.toString());
	    		  	tpreslabtxt.setText(lph.toString());
	    		  	tottxt.setText(tp.toString());
	    		  	prectxt.setText(pre.toString().subSequence(0,5).toString());
	    		  		int pst = Integer.parseInt(regnotxt.getText());
	    		  	photo.setIcon(new ImageIcon("photo\\" + pst + ".jpg"));
	    		  }
	  			 }

	  	    	}
			}
			if(t==0)
            {
            	JOptionPane.showMessageDialog(null,"Record Not Found");
        	}
	}
	else if(ae.getActionCommand().equals("Next"))
	{
	     int t=0;
    		Statement st=conn.createStatement();
    		Statement st1=conn.createStatement();
    		Statement st2=conn.createStatement();

    		ResultSet rs1=st1.executeQuery("select *from MonthDetails");
    		ResultSet rs=st.executeQuery("select *from "+semtxt.getSelectedItem().toString());
    		Integer tt=Integer.parseInt(regnotxt.getText())+1;
      		regnotxt.setText(tt.toString());
    		while(rs.next())
    		{
    			if(regnotxt.getText().equals(rs.getString(1)) && monthlist.getSelectedItem().equals(rs.getString(2)))
    			{
    				while(rs1.next())
    				{
    					if(semtxt.getSelectedItem().equals(rs1.getString(1)) && monthlist.getSelectedItem().equals(rs1.getString(2)) && yearlist.getSelectedItem().equals(rs1.getString(3)))
    					{
    					ResultSet rs2=st2.executeQuery("select *from personal");
                        while(rs2.next())
                        {
                            if(rs2.getString(1).equals(regnotxt.getText()))
                            nametxt.setText(rs2.getString(2));
                        }
                        wsub1txt.setText(rs1.getString(4));
    					sub1txt.setText(rs.getString(3));
    					wsub2txt.setText(rs1.getString(5));
    					sub2txt.setText(rs.getString(4));
    					wsub3txt.setText(rs1.getString(6));
						sub3txt.setText(rs.getString(5));
						wsub4txt.setText(rs1.getString(7));
    					sub4txt.setText(rs.getString(6));
    					wsub5txt.setText(rs1.getString(8));
	    				sub5txt.setText(rs.getString(7));
	    				wsub6txt.setText(rs1.getString(9));
	    				sub6txt.setText(rs.getString(8));
	    				wlab1txt.setText(rs1.getString(10));
	    				lab1txt.setText(rs.getString(9));
	    				wlab2txt.setText(rs1.getString(11));
	    				lab2txt.setText(rs.getString(10));
	    				t++;

	    		  	Integer twh,tph,lwh,lph,tw,tp;
	    		  	Float pre;
	    		  	twh=Integer.parseInt(wsub1txt.getText())+Integer.parseInt(wsub2txt.getText())+Integer.parseInt(wsub3txt.getText())+Integer.parseInt(wsub4txt.getText())+Integer.parseInt(wsub5txt.getText())+Integer.parseInt(wsub6txt.getText());
	    		  	tph=Integer.parseInt(sub1txt.getText())+Integer.parseInt(sub2txt.getText())+Integer.parseInt(sub3txt.getText())+Integer.parseInt(sub4txt.getText())+Integer.parseInt(sub5txt.getText())+Integer.parseInt(sub6txt.getText());
	    		  	lwh=Integer.parseInt(wlab1txt.getText())+Integer.parseInt(wlab2txt.getText());
	    		  	lph=Integer.parseInt(lab1txt.getText())+Integer.parseInt(lab2txt.getText());
	    		  	tw=twh+lwh;
	    		  	tp=tph+lph;
	    		  	pre=(tp.floatValue()/tw)*100;
	  				System.out.println(pre);
	    		  	tprestxt.setText(tph.toString());
	    		  	tworktxt.setText(twh.toString());
	    		  	tworklabtxt.setText(lwh.toString());
	    		  	tpreslabtxt.setText(lph.toString());
	    		  	tottxt.setText(tp.toString());
	    		  	prectxt.setText(pre.toString().subSequence(0,5).toString());
	    		  		int pst = Integer.parseInt(regnotxt.getText());
	    		  	photo.setIcon(new ImageIcon("photo\\" + pst + ".jpg"));
	    		  }
	  			 }

	  	    	}
			}
			if(t==0)
            {
            	JOptionPane.showMessageDialog(null,"Record Not Found");
        	}

	}
	else if(ae.getActionCommand().equals("Exit"))
	{
		int confirm = JOptionPane.showConfirmDialog(null, "Do you want to Exit", "Confirmation", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION)
			{
				this.dispose();
			}
			else
			{
				regnotxt.setText("");
			}
	}
	else if(ae.getActionCommand().equals("Modify"))
	{
		PreparedStatement ps=conn.prepareStatement("update "+semtxt.getSelectedItem().toString()+" set sub1=?,sub2=?,sub3=?,sub4=?,sub5=?,sub6=?,lab1=?,lab2=? where Regno=? and Month=?");

		ps.setInt(1,Integer.parseInt(sub1txt.getText()));
		ps.setInt(2,Integer.parseInt(sub2txt.getText()));
		ps.setInt(3,Integer.parseInt(sub3txt.getText()));
		ps.setInt(4,Integer.parseInt(sub4txt.getText()));
		ps.setInt(5,Integer.parseInt(sub5txt.getText()));
		ps.setInt(6,Integer.parseInt(sub6txt.getText()));
		ps.setInt(7,Integer.parseInt(lab1txt.getText()));
		ps.setInt(8,Integer.parseInt(lab2txt.getText()));
		ps.setString(9,regnotxt.getText());
		ps.setString(10,monthlist.getSelectedItem().toString());
		ps.executeUpdate();
		Integer twh,tph,lwh,lph,tw,tp=0;
	    Float pre;
	    twh=Integer.parseInt(wsub1txt.getText())+Integer.parseInt(wsub2txt.getText())+Integer.parseInt(wsub3txt.getText())+Integer.parseInt(wsub4txt.getText())+Integer.parseInt(wsub5txt.getText())+Integer.parseInt(wsub6txt.getText());
	    tph=Integer.parseInt(sub1txt.getText())+Integer.parseInt(sub2txt.getText())+Integer.parseInt(sub3txt.getText())+Integer.parseInt(sub4txt.getText())+Integer.parseInt(sub5txt.getText())+Integer.parseInt(sub6txt.getText());
	    lwh=Integer.parseInt(wlab1txt.getText())+Integer.parseInt(wlab2txt.getText());
	    lph=Integer.parseInt(lab1txt.getText())+Integer.parseInt(lab2txt.getText());
	    tw=twh+lwh;
	    tp=tph+lph;
	    if(tp==0)
	    {
	    	pre=000.00000f;
	    	prectxt.setText("0");

	 	}
	 	else
	 	{
	    pre=(tp.floatValue()/tw)*100;
	    prectxt.setText(pre.toString().subSequence(0,5).toString());
		 }

	    tprestxt.setText(tph.toString());
	    tworktxt.setText(twh.toString());
	    tworklabtxt.setText(lwh.toString());
	    tpreslabtxt.setText(lph.toString());
	    tottxt.setText(tp.toString());

		JOptionPane.showMessageDialog(null,"Modified Successfully");


	}
	else if(ae.getActionCommand().equals("Generate"))
	{
	Generate gn=new Generate();

	} }
	catch(Exception e){}
}
public void keyPressed(KeyEvent ke)
  {

  }

  public void keyReleased(KeyEvent ke1)
  {
      if(ke1.getKeyCode()==KeyEvent.VK_ENTER)
      {
         wsub1txt.setText("");
		sub1txt.setText("");
		wsub2txt.setText("");
		sub2txt.setText("");
		wsub3txt.setText("");
		sub3txt.setText("");
		wsub4txt.setText("");
		sub4txt.setText("");
		wsub5txt.setText("");
		sub5txt.setText("");
		wsub6txt.setText("");
		sub6txt.setText("");
		wlab1txt.setText("");
		lab1txt.setText("");
		wlab2txt.setText("");
		lab2txt.setText("");
		tprestxt.setText("");
	    tworktxt.setText("");
	    tworklabtxt.setText("");
	    tpreslabtxt.setText("");
	    tottxt.setText("");
	    prectxt.setText("");
          photo.setIcon(new ImageIcon("photo\\" + regnotxt.getText() + ".jpg"));
          try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
                Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT *FROM personal");

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
            monthlist.setSelectedIndex(0);
            yearlist.setSelectedIndex(0);
            }
          catch(Exception eee){}
    }
  }
  public void keyTyped(KeyEvent ke2)
  {

  }


    public static void main(String args[])
    {
    	ViewAttend va=new ViewAttend();
    	va.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}