import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.text.*;
import java.util.regex.*;
class Profile1 extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,head;
	JTextField cmb,t1,t2,t3,t5;
	JButton b1,b2,b3,b4;
	JComboBox t10;
	PreparedStatement ps;
	JPanel p;
	String msg="";
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String iddd = null;
	Profile1()
	{
		super("ADMIN'S PROFILE");
		
		setLayout(null);   	 			
		head=new JLabel("ADMIN'S PROFILE");
		head.setBounds(370,30,600,50);
		head.setFont(new Font("Courier",Font.BOLD,30));
		add(head);
			
		l1=new JLabel("ID Number:");
		l1.setBounds(300,110,100,30);
		add(l1);
	
		t1=new JTextField();
		t1.setHorizontalAlignment (JTextField.RIGHT);
		t1.setBounds(430,110,170,25);
                t1.setEditable(false);
		add(t1);


		l2=new JLabel("National ID:");
		l2.setBounds(300,180,100,30);
		add(l2);
		
		t2=new JTextField();
		t2.setHorizontalAlignment (JTextField.RIGHT);
		t2.setBounds(430,180,170,25);
		add(t2);
		
		l3=new JLabel("Name");
		l3.setBounds(300,250,100,30);
		add(l3);
		

		t3=new JTextField();
		t3.setHorizontalAlignment (JTextField.RIGHT);
		t3.setBounds(430,250,170,25);
                t3.setEditable(false);
		add(t3);

		l5=new JLabel("Rank");
		l5.setBounds(300,320,100,30);
		add(l5);
		
		t5=new JTextField();
		t5.setHorizontalAlignment (JTextField.RIGHT);
		t5.setBounds(430,320,170,25);
		add(t5);

		l6=new JLabel("Section");
		l6.setBounds(300,390,100,30);
		add(l6);

		cmb=new JTextField();
                cmb.setHorizontalAlignment (JTextField.RIGHT);
		cmb.setBounds(430,390,170,30);
		add(cmb); 
            
		b1=new JButton("Submit");
		b1.setBounds(80,460,150,50);
		add(b1);

		b2=new JButton("Clear");
		b2.setBounds(300,460,150,50);
		add(b2);

		b3=new JButton("Update");
		b3.setBounds(550,460,150,50);
		add(b3);
                
                b4=new JButton("Exit");
		b4.setBounds(790,460,150,50);
		add(b4);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
                b4.addActionListener(this);
		 	
		t1.addKeyListener (new KeyAdapter () {
			public void keyTyped (KeyEvent ke) {
				char c = ke.getKeyChar ();
				if (! ((Character.isDigit (c)) || (c == KeyEvent.VK_BACK_SPACE))) {
					getToolkit().beep ();
					ke.consume ();
				}
			}
		}
		);
		t2.addKeyListener (new KeyAdapter () {
			public void keyTyped (KeyEvent ke) {
				char c = ke.getKeyChar ();
				if (! ((Character.isDigit (c)) || (c == KeyEvent.VK_BACK_SPACE))) {
					getToolkit().beep ();
					ke.consume ();
				}
			}
		}
		);
	
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                ImageIcon image = new javax.swing.ImageIcon(getClass().getResource("/image/icon9.png"));
                Image im = image.getImage();
                setIconImage(im);
	}
	
	public void actionPerformed(ActionEvent ae)
	{

			if(ae.getSource()==b1)
			{
				if(!t1.getText().equals("")&!t2.getText().equals("")&!t3.getText().equals("")&!t5.getText().equals("")&!cmb.getText().equals("")) // if the JTextField is not empty then enable the button
            			{
					//b1.setEnabled(true);
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
                                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
						ps=con.prepareStatement("insert into profileadmin (Adminid,Nationalid,Adminname,rank,section) values(?,?,?,?,?)");
						ps.setInt(1,Integer.parseInt(t1.getText()));  
			    			ps.setInt(2,Integer.parseInt(t2.getText()));
			        		ps.setString(3,t3.getText());
			   			ps.setString(4,t5.getText());
			   			ps.setString(5,cmb.getText());

			        		ps.executeUpdate();
                                                
                                                
  			    				JOptionPane.showMessageDialog(this,"Record is saved",
        		    				"Message",JOptionPane.INFORMATION_MESSAGE);
							
						}
						catch(Exception e){
                                                    JOptionPane.showMessageDialog(this,e.getMessage());
                                                    e.printStackTrace();
                                                }
						
					}
					else
					{
					System.out.println("Enter Data Properly");
  			    		JOptionPane.showMessageDialog(this,"Please fillup all field",
        		    		"Error",JOptionPane.ERROR_MESSAGE);
					}

			}
			if(ae.getSource()==b2)
			{
				t2.setText("");
				t5.setText("");
				cmb.setText("");
			}if(ae.getSource()==b3)
			{if(!t1.getText().equals("")&!t2.getText().equals("")&!t3.getText().equals("")&!t5.getText().equals("")&!cmb.getText().equals("")) // if the JTextField is not empty then enable the button
            			{
					//b1.setEnabled(true);
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
                                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
						ps=con.prepareStatement("UPDATE profileadmin SET Nationalid=?,Adminname=?,rank=?,section=? WHERE Adminid=?");
						ps.setInt(5,Integer.parseInt(t1.getText()));  
			    			ps.setInt(1,Integer.parseInt(t2.getText()));
			        		ps.setString(2,t3.getText());
			   			ps.setString(3,t5.getText());
			        		ps.setString(4,cmb.getText());

			        		ps.executeUpdate();
                                                
                                                
  			    				JOptionPane.showMessageDialog(this,"Record is updated",
        		    				"Message",JOptionPane.INFORMATION_MESSAGE);
							
						}
						catch(Exception e){
                                                    JOptionPane.showMessageDialog(this,e.getMessage());
                                                    e.printStackTrace();
                                                }
						
					}
					else
					{
					System.out.println("Enter Data Properly");
  			    		JOptionPane.showMessageDialog(this,"Please fillup all field",
        		    		"Error",JOptionPane.ERROR_MESSAGE);
                                        }
				
			}
			if(ae.getSource()==b4)
			{
        int confirm = JOptionPane.showConfirmDialog(null, "Do you want to Exit?", "Confirmation", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION)
			{       
				this.dispose();

			}
			}
			
	}

	public static void main(String ar[])
	{
		Profile1 nw=new Profile1();
		nw.setBounds(0,0,1048,600);
		nw.setVisible(true);
		}
        void setit(String text) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
            String sql = "select * from login where username=?";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, text);
            rs = (ResultSet) pst.executeQuery();

            if (rs.next()) {
                String name = rs.getString("username");
                iddd = rs.getString("Adminid");
                t3.setText(name);
                t1.setText(iddd);
                System.out.println(""+iddd);
              
            } else {
                JOptionPane.showMessageDialog(null, "Cant identify you!");

            }
        } catch (Exception e) {
            System.out.println("no");
            JOptionPane.showMessageDialog(null, e);

        }  
    }

}
