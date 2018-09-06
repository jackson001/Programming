import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

 public class PasswordChange1 extends JFrame implements ActionListener
{
 JFrame jf;
 JLabel title,l1,l2,l3;
 JTextField t1;
 JPasswordField t2,t3; 
 JButton d;
 String s1,s2,s3;
 
 public PasswordChange1(String s)
 {

  jf=new JFrame("Egerton Students Attendance System");

  jf.getContentPane().setLayout(null);

   ImageIcon image = new javax.swing.ImageIcon(getClass().getResource("/image/icon9.png"));
   Image im = image.getImage();
   jf.setIconImage(im);
  
  title=new JLabel("AUTHENTICATION FORM");
  title.setFont(new Font("comicsansms",Font.BOLD,25));
  title.setBounds(250,0,1024,100);
  jf.getContentPane().add(title);
  
    l1=new JLabel("UR USER-ID");
    l1.setBounds(100,200,250,30);

    l1.setFont(new Font("verdana",Font.BOLD,15));

   t1=new JTextField(50);
   t1.setBounds(450,200,250,30);
   t1.setFont(new Font("areal",Font.BOLD,15));
   jf.getContentPane().add(t1);
   jf.getContentPane().add(l1);
   t1.setText(s);
   t1.setEditable(false);


    l2=new JLabel("ENTER UR PASSWORD");
    l2.setBounds(100,250,300,30);

    l2.setFont(new Font("verdana",Font.BOLD,15));

   t2=new JPasswordField(50);
  
   t2.setBounds(450,250,250,30);
   t2.setFont(new Font("areal",Font.BOLD,15));
   jf.getContentPane().add(t2);
   jf.getContentPane().add(l2);
   
   l3=new JLabel("RE ENTER UR PASSWORD");
   l3.setBounds(100,300,300,30);

    l3.setFont(new Font("verdana",Font.BOLD,15));

   t3=new JPasswordField(50);
   t3.setBounds(450,300,250,30);
   t3.setFont(new Font("areal",Font.BOLD,15));
   jf.getContentPane().add(t3);
   jf.getContentPane().add(l3);

   d=new JButton("ok");
   d.setBounds(300,450,100,30);
   d.addActionListener(this);
   jf.getContentPane().add(d);
   jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   jf.setBackground(new Color(255,255,255));
  jf.setBounds(0,0,1048,620);
  jf.setVisible(true);
 }
 public void actionPerformed(ActionEvent ae)
	{
	  
		 
		if(ae.getActionCommand().equals("ok"))
          {       
			s1=t2.getText();

			s2=t3.getText();
			s3=t1.getText();
			if((s1.equals(s2)) && !(s1.equals("")))

	         {
				 try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");

                 PreparedStatement st=conn.prepareStatement("update login set password =? where username=?");
	
                 

                  
				  st.setString(1,s2);
				  st.setString(2,s3);

				  st.executeUpdate();

 
	
    int conf=JOptionPane.showConfirmDialog(null,"your password has been changed successfully","Confirmation",JOptionPane.YES_NO_OPTION);
    if(conf==JOptionPane.YES_OPTION)
    {
   
			 
            conn.close();
            
		jf.dispose();
		           
		  }

	}	

       catch(Exception ex)
      {

      System.out.println(ex);
	  }  
         	
                     
	          }
           
	   }
   }
		
 public static void main(String args[])
 {
	 String k=" ";
  PasswordChange jf=new PasswordChange(k);
 }
}
