import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Profile extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,head;
	JTextField t1,t2,t3,t5,t6,t8,t9,t13,t14,t15;
	JButton b1,b2,b3,b4;
	JComboBox cmb,t10;
	PreparedStatement ps;
	JPanel p;
	String msg="";
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String iddd = null;
	Profile()
	{
		super("LECTURER'S PROFILE");
		
		setLayout(null);   	 			
		head=new JLabel("LECTURER'S PROFILE");
		head.setBounds(350,30,600,50);
		head.setFont(new Font("Courier",Font.BOLD,30));
		add(head);
	
		l1=new JLabel("ID Number:");
		l1.setBounds(150,110,100,30);
		add(l1);
	
		t1=new JTextField();
		t1.setHorizontalAlignment (JTextField.RIGHT);
		t1.setBounds(280,110,170,25);
                t1.setEditable(false);
		add(t1);


		l2=new JLabel("National ID:");
		l2.setBounds(150,180,100,30);
		add(l2);
		
		t2=new JTextField();
		t2.setHorizontalAlignment (JTextField.RIGHT);
		t2.setBounds(280,180,170,25);
		add(t2);
		
		l3=new JLabel("Name");
		l3.setBounds(150,250,100,30);
		add(l3);
		
		t3=new JTextField();
		t3.setHorizontalAlignment (JTextField.RIGHT);
		t3.setBounds(280,250,170,25);
                t3.setEditable(false);
		add(t3);

		l5=new JLabel("Birth Date");
		l5.setBounds(150,320,100,30);
		add(l5);
		
		t5=new JTextField();
		t5.setHorizontalAlignment (JTextField.RIGHT);
		t5.setBounds(280,320,170,25);
		add(t5);

		l6=new JLabel("Gender");
		l6.setBounds(150,390,100,30);
		add(l6);

		cmb=new JComboBox();
		cmb.addItem("Male");	
		cmb.addItem("Female");
		cmb.setBounds(280,390,170,30);
		add(cmb); 
                
                l10=new JLabel("Marital Status");
		l10.setBounds(150,460,100,30);
		add(l10);
		
		t10=new JComboBox();
		t10.addItem("Single");
                t10.addItem("Married");
		t10.addItem("Divorced");
                t10.addItem("Window");
                t10.addItem("Windower");
		t10.setBounds(280,460,170,25);
		add(t10);

		l8=new JLabel("Address");
		l8.setBounds(650,110,100,30);
		add(l8);
		
		t8=new JTextField();
		t8.setHorizontalAlignment (JTextField.RIGHT);
		t8.setBounds(780,110,170,25);
		add(t8);
		
		l9=new JLabel("City");
		l9.setBounds(650,180,100,30);
		add(l9);
		
		t9=new JTextField();
		t9.setHorizontalAlignment (JTextField.RIGHT);		
		t9.setBounds(780,180,170,25);
		add(t9);

		l13=new JLabel("Mobile phone");
		l13.setBounds(650,250,100,30);
		add(l13); 
		
		t13=new JTextField();
		t13.setHorizontalAlignment (JTextField.RIGHT);
		t13.setBounds(780,250,170,25);
		add(t13);   
	
		l14=new JLabel("EMail Address");
		l14.setBounds(650,320,100,30);
		add(l14);

		t14=new JTextField();
		t14.setHorizontalAlignment (JTextField.RIGHT);
		t14.setBounds(780,320,170,25);
		add(t14);   
		
		l15=new JLabel("Department");
		l15.setBounds(650,390,100,30);
		add(l15);

		t15=new JTextField();
		t15.setHorizontalAlignment (JTextField.RIGHT);
		t15.setBounds(780,390,170,25);
		add(t15);   

		b1=new JButton("Submit");
		b1.setBounds(280,525,100,30);
		add(b1);

		b2=new JButton("Clear");
		b2.setBounds(440,525,100,30);
		add(b2);

		b3=new JButton("Update");
		b3.setBounds(600,525,100,30);
		add(b3);
                
                b4=new JButton("Exit");
		b4.setBounds(750,525,100,30);
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
		t13.addKeyListener (new KeyAdapter () {
			public void keyTyped (KeyEvent ke) {
				char c = ke.getKeyChar ();
				if (! ((Character.isDigit (c)) || (c == KeyEvent.VK_BACK_SPACE))) {
					getToolkit().beep ();
					ke.consume ();
				}
			}
		}
		);
		
		ImageIcon image = new javax.swing.ImageIcon(getClass().getResource("/image/icon9.png"));
                Image im = image.getImage();
                setIconImage(im);
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
			String cmbitem=(String)cmb.getSelectedItem();
                        String cmbitem1=(String)t10.getSelectedItem();
			if(ae.getSource()==b1)
			{
				if(!t1.getText().equals("")&!t2.getText().equals("")&!t3.getText().equals("")&!t5.getText().equals("")&!t8.getText().equals("")&!t9.getText().equals("")&!t13.getText().equals("")&!t14.getText().equals("")&!t15.getText().equals("")) // if the JTextField is not empty then enable the button
            			{
					//b1.setEnabled(true);
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
                                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
						ps=con.prepareStatement("insert into profile (Lecturerid,Nationalid,Lecturername,DOB,gender,status,address,city,phone,email,dept) values(?,?,?,?,?,?,?,?,?,?,?)");
						ps.setInt(1,Integer.parseInt(t1.getText()));  
			    			ps.setInt(2,Integer.parseInt(t2.getText()));
			        		ps.setString(3,t3.getText());
			   			ps.setString(4,t5.getText());
			        		ps.setString(5,cmbitem);
                                                ps.setString(6,cmbitem1);
			   			ps.setString(7,t8.getText());
			       		        ps.setString(8,t9.getText());
			        		ps.setString(9,t13.getText());
			        		ps.setString(10,t14.getText());
			   			ps.setString(11,t15.getText());
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
				t8.setText("");
				t9.setText("");
				t13.setText("");
				t14.setText("");
				t15.setText("");
			}if(ae.getSource()==b3)
			{if(!t1.getText().equals("")&!t2.getText().equals("")&!t3.getText().equals("")&!t5.getText().equals("")&!t8.getText().equals("")&!t9.getText().equals("")&!t13.getText().equals("")&!t14.getText().equals("")&!t15.getText().equals("")) // if the JTextField is not empty then enable the button
            			{
					//b1.setEnabled(true);
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
                                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
						ps=con.prepareStatement("UPDATE profile SET Nationalid=?,Lecturername=?,DOB=?,gender=?,status=?,address=?,city=?,phone=?,email=?,dept=? WHERE Lecturerid=?");
						ps.setInt(11,Integer.parseInt(t1.getText()));  
			    			ps.setInt(1,Integer.parseInt(t2.getText()));
			        		ps.setString(2,t3.getText());
			   			ps.setString(3,t5.getText());
			        		ps.setString(4,cmbitem);
                                                ps.setString(5,cmbitem1);
			   			ps.setString(6,t8.getText());
			       		        ps.setString(7,t9.getText());
			        		ps.setString(8,t13.getText());
			        		ps.setString(9,t14.getText());
			   			ps.setString(10,t15.getText());

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
		Profile nw=new Profile();
		nw.setBounds(0,0,1048,620);
		nw.setVisible(true);
		}
            void setit(String text) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
            String sql = "select * from Lecturer where Lecturername=?";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, text);
            rs = (ResultSet) pst.executeQuery();

            if (rs.next()) {
                String name = rs.getString("Lecturername");
                iddd = rs.getString("Lecturerid");
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
