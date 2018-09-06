

/*
 * ViewStudent.java
 *
 * Created on September 23, 2007, 11:17 AM
 *
 */
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

/**
 *
 * @author king
 */
public class ViewStudent extends JFrame implements ActionListener,KeyListener
{

    /** Creates a new instance of ViewStudent */
java.sql.Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String iddd = null;
         JLabel  regno,name,photo,per,father,phone,status,permanent,town,dob,gender,admin,present,blood,doj,religion,castecode,castename;
     JTextField  regnotxt,nametxt,fathertxt,phonetxt,towntxt,dobtxt,admintxt,bloodtxt,castecodetxt,dojtxt,castenametxt;
    JButton view,clear,exit;
    JTextField statustxt,gendertxt,religiontxt;
    JTextArea permanenttxt,presenttxt;
    JPanel jp;


     public ViewStudent() {


    /** Creates a new instance of StudentInfo */

             Toolkit kit=Toolkit.getDefaultToolkit();
            Dimension screenSize= kit.getScreenSize();
            setSize(900,screenSize.height);
            setLocation(screenSize.width/6, 0);
            jp=new JPanel(null);
            jp.setBounds(0,10,screenSize.width,screenSize.height);
            jp.setBackground(new Color(255,255,255));
             getContentPane().add(jp);

                setLayout(null);
                per=new JLabel();
                per.setText("View Personal Details");
                per.setFont(new Font("Sans-Serif",Font.BOLD+Font.ITALIC,30));
                per.setForeground(new Color(45,118,232));
                per.setBounds(20,20,500,50);
                jp.add(per);


                regno=new JLabel();
                regno.setText("RegNo");
                regno.setFont(new Font("Arial",Font.BOLD,20));
                regno.setBounds(30,135,100,30);
                jp.add(regno);

                regnotxt=new JTextField();
                regnotxt.setFont(new Font("Arial",Font.BOLD,16));
                regnotxt.setBounds(175,135,200,30);
                regnotxt.setEditable(false);
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

                father=new JLabel();
                father.setText("Fatehr Name");
                father.setBounds(30,205,100,30);
                father.setFont(new Font("Arial",Font.BOLD,16));
                jp.add(father);

                fathertxt=new JTextField();
                fathertxt.setFont(new Font("Arial",Font.BOLD,16));
                fathertxt.setBounds(175,205,200,30);
                jp.add(fathertxt);
                fathertxt.setEditable(false);

                phone=new JLabel();
                phone.setText("Phone Number");
                phone.setBounds(30,240,130,30);
                phone.setFont(new Font("Arial",Font.BOLD,16));
                jp.add(phone);

                phonetxt=new JTextField();
                phonetxt.setFont(new Font("Arial",Font.BOLD,16));
                phonetxt.setBounds(175,240,200,30);
                jp.add(phonetxt);
                phonetxt.setEditable(false);

                status=new JLabel();
                status.setText("Status");
                status.setBounds(30,275,100,30);
                status.setFont(new Font("Arial",Font.BOLD,16));
                jp.add(status);

                statustxt=new JTextField();
                statustxt.setBounds(175,275,200,30);
                statustxt.setBackground(Color.white);
                jp.add(statustxt);
                statustxt.setEditable(false);

                permanent=new JLabel();
                permanent.setText("Permanent Add");
                permanent.setBounds(30,310,130,30);
                permanent.setFont(new Font("Arial",Font.BOLD,16));
                jp.add(permanent);

                permanenttxt=new JTextArea(5,30);
                permanenttxt.setBounds(175,310,200,100);
                permanenttxt.setTabSize(0);
                // permanenttxt.add(new LineBorder(Color.black));
                jp.add(permanenttxt);
                permanenttxt.setEditable(false);

                town=new JLabel();
                town.setText("Town");
                town.setBounds(30,415,100,30);
                town.setFont(new Font("Arial",Font.BOLD,16));
                jp.add(town);

               towntxt=new JTextField();
                towntxt.setFont(new Font("Arial",Font.BOLD,16));
                towntxt.setBounds(175,415,200,30);
             //   towntxt.setTabStop(7);
                jp.add(towntxt);
                towntxt.setEditable(false);


                dob=new JLabel();
                dob.setText("Date of Birth");
                dob.setBounds(30,450,100,30);
                dob.setFont(new Font("Arial",Font.BOLD,16));
                jp.add(dob);

               dobtxt=new JTextField();
                dobtxt.setFont(new Font("Arial",Font.BOLD,16));
                dobtxt.setBounds(175,450,200,30);
                jp.add(dobtxt);
                dobtxt.setEditable(false);

                gender=new JLabel();
                gender.setText("Gender");
                gender.setFont(new Font("Arial",Font.BOLD,16));
                gender.setBounds(450,135,100,30);
                jp.add(gender);

                gendertxt=new JTextField();
                gendertxt.setFont(new Font("Arial",Font.BOLD,16));
               gendertxt.setBounds(595,135,200,30);
                jp.add(gendertxt);
                gendertxt.setEditable(false);

                admin=new JLabel();
                admin.setText("Adminssion No");
                admin.setFont(new Font("Arial",Font.BOLD,16));
                admin.setBounds(450,170,150,30);
                jp.add(admin);

                admintxt=new JTextField();
                admintxt.setFont(new Font("Arial",Font.BOLD,16));
                admintxt.setBounds(595,170,200,30);
                jp.add(admintxt);
                admintxt.setEditable(false);

                present=new JLabel();
                present.setText("Present Add");
                present.setBounds(450,205,100,30);
                present.setFont(new Font("Arial",Font.BOLD,16));
                jp.add(present);

                presenttxt=new JTextArea(5,30);
                presenttxt.setBounds(595,205,200,100);
                presenttxt.setTabSize(0);
                // permanenttxt.add(new LineBorder(Color.black));
                jp.add(presenttxt);
                presenttxt.setEditable(false);

                blood=new JLabel();
                blood.setText("Blood Group");
                blood.setFont(new Font("Arial",Font.BOLD,16));
                blood.setBounds(450,310,150,30);
                jp.add(blood);

                bloodtxt=new JTextField();
                bloodtxt.setFont(new Font("Arial",Font.BOLD,16));
                bloodtxt.setBounds(595,310,200,30);
                jp.add(bloodtxt);
                bloodtxt.setEditable(false);

                doj=new JLabel();
                doj.setText("Date of Join");
                doj.setFont(new Font("Arial",Font.BOLD,16));
                doj.setBounds(450,345,150,30);
                jp.add(doj);

                dojtxt=new JTextField();
                dojtxt.setFont(new Font("Arial",Font.BOLD,16));
                dojtxt.setBounds(595,345,200,30);
                jp.add(dojtxt);
                dojtxt.setEditable(false);

                religion=new JLabel();
                religion.setText("Religion");
                religion.setBounds(450,380,100,30);
                religion.setFont(new Font("Arial",Font.BOLD,16));
                jp.add(religion);

                religiontxt=new JTextField();
                religiontxt.setBounds(595,380,200,30);
                religiontxt.setBackground(Color.white);
                jp.add(religiontxt);
                religiontxt.setEditable(false);

                castecode=new JLabel();
                castecode.setText("Caste Code");
                castecode.setFont(new Font("Arial",Font.BOLD,16));
                castecode.setBounds(450,415,150,30);
                jp.add(castecode);

                castecodetxt=new JTextField();
                castecodetxt.setFont(new Font("Arial",Font.BOLD,16));
                castecodetxt.setBounds(595,415,200,30);
                jp.add(castecodetxt);
                castecodetxt.setEditable(false);

                castename=new JLabel();
                castename.setText("Caste Name");
                castename.setFont(new Font("Arial",Font.BOLD,16));
                castename.setBounds(450,450,150,30);
                jp.add(castename);

                castenametxt=new JTextField();
                castenametxt.setFont(new Font("Arial",Font.BOLD,16));
                castenametxt.setBounds(595,450,200,30);
                jp.add(castenametxt);
                castenametxt.setEditable(false);
				photo = new JLabel(new ImageIcon("\\photo\\default.jpg"));
				photo.setBounds(600, 20, 100, 100);
				jp.add(photo);

               view=new JButton("View");
               view.setFont(new Font("Arial",Font.BOLD,16));
               view.setBounds(280,600,100,30);
               jp.add(view);
               view.addActionListener(this);
               view.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
               view.setMnemonic('V');
               view.setBackground(new Color(102,102,255));
               view.setForeground(Color.white);
               
               clear=new JButton("Clear");
              clear.setFont(new Font("Arial",Font.BOLD,16));
               clear.setBounds(450,600,100,30);
               clear.addActionListener(this);
               jp.add(clear);
               clear.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
               clear.setMnemonic('C');
               clear.setBackground(new Color(102,102,255));
               clear.setForeground(Color.white);

               exit=new JButton("Exit");
               exit.setFont(new Font("Arial",Font.BOLD,16));
               exit.setBounds(640,600,100,30);
               exit.addActionListener(this);
               jp.add(exit);
               exit.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
               exit.setMnemonic('E');
               exit.setBackground(new Color(102,102,255));
               exit.setForeground(Color.white);
               setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
            addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
    }
     private void formWindowOpened(java.awt.event.WindowEvent evt) {
         try
    {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
        Statement st=conn.createStatement();

					 ResultSet r1 = st.executeQuery("SELECT *FROM studentdetails");
                    while(r1.next())
                  {
						if(regnotxt.getText().equals(r1.getString(1)))
						{


                    nametxt.setText(r1.getString(2));
                    fathertxt.setText(r1.getString(3));
                     phonetxt.setText(r1.getString(4));
                     statustxt.setText(r1.getString(5));
                     permanenttxt.setText(r1.getString(6));
                      towntxt.setText(r1.getString(7));
                     dobtxt.setText(r1.getString(8));
                     gendertxt.setText(r1.getString(9));
                    admintxt.setText(r1.getString(10));
                    presenttxt.setText(r1.getString(11));
                    bloodtxt.setText(r1.getString(12));
                    dojtxt.setText(r1.getString(13));
                    religiontxt.setText(r1.getString(14));
                    castecodetxt.setText(r1.getString(15));
                    castenametxt.setText(r1.getString(16));
					String pst = regnotxt.getText();
					photo.setIcon(new ImageIcon("photo\\"+pst+".jpg"));

                       }
                    }
         }catch(ClassNotFoundException | SQLException e){
         JOptionPane.showMessageDialog(null, e);
         }  
                }
     public void actionPerformed(ActionEvent et)
     {
         try
    {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
        Statement st=conn.createStatement();

                         if(et.getActionCommand().equals("View"))
				 {
					 ResultSet r1 = st.executeQuery("SELECT *FROM studentdetails");
                    while(r1.next())
                  {
						if(regnotxt.getText().equals(r1.getString(1)))
						{


                    nametxt.setText(r1.getString(2));
                    fathertxt.setText(r1.getString(3));
                     phonetxt.setText(r1.getString(4));
                     statustxt.setText(r1.getString(5));
                     permanenttxt.setText(r1.getString(6));
                      towntxt.setText(r1.getString(7));
                     dobtxt.setText(r1.getString(8));
                     gendertxt.setText(r1.getString(9));
                    admintxt.setText(r1.getString(10));
                    presenttxt.setText(r1.getString(11));
                    bloodtxt.setText(r1.getString(12));
                    dojtxt.setText(r1.getString(13));
                    religiontxt.setText(r1.getString(14));
                    castecodetxt.setText(r1.getString(15));
                    castenametxt.setText(r1.getString(16));
					String pst = regnotxt.getText();
					photo.setIcon(new ImageIcon("photo\\"+pst+".jpg"));

                       }
                    }
         }
         
         else if(et.getActionCommand().equals("Clear"))
         {
             		nametxt.setText("");
                    fathertxt.setText("");
                     phonetxt.setText("");
                     statustxt.setText("");
                     permanenttxt.setText("");
                      towntxt.setText("");
                     dobtxt.setText("");
                     gendertxt.setText("");
                    admintxt.setText("");
                    presenttxt.setText("");
                    bloodtxt.setText("");
                    dojtxt.setText("");
                    religiontxt.setText("");
                    castecodetxt.setText("");
                    castenametxt.setText("");
                    photo.setIcon(new ImageIcon("photo\\default.jpg"));
         }
        else if(et.getActionCommand().equals("Exit"))
         {

                int confirm = JOptionPane.showConfirmDialog(null, "Do you want to Exit", "Confirmation", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION)
			{
				this.dispose();
			}
			else
			{
			}


         }

     }
         catch(Exception eve){
         
                        System.out.println("No");
                        JOptionPane.showMessageDialog(null, eve);
         }
     }
     public void keyPressed(KeyEvent ke)
  {
        try
    {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
        Statement st=conn.createStatement();
					 ResultSet r1 = st.executeQuery("SELECT *FROM studentdetails WHERE Regno="+regnotxt.getText());
                    while(r1.next())
                  {
						if(regnotxt.getText().equals(r1.getString(1)))
						{


                    nametxt.setText(r1.getString(2));
                    fathertxt.setText(r1.getString(3));
                     phonetxt.setText(r1.getString(4));
                     statustxt.setText(r1.getString(5));
                     permanenttxt.setText(r1.getString(6));
                      towntxt.setText(r1.getString(7));
                     dobtxt.setText(r1.getString(8));
                     gendertxt.setText(r1.getString(9));
                    admintxt.setText(r1.getString(10));
                    presenttxt.setText(r1.getString(11));
                    bloodtxt.setText(r1.getString(12));
                    dojtxt.setText(r1.getString(13));
                    religiontxt.setText(r1.getString(14));
                    castecodetxt.setText(r1.getString(15));
                    castenametxt.setText(r1.getString(16));
					String pst=regnotxt.getText();
					photo.setIcon(new ImageIcon("photo\\"+pst+".jpg"));
                      }
                    }
            }
           catch(Exception e){}
  }

  public void keyReleased(KeyEvent ke1)
  {
      if(ke1.getKeyCode()==KeyEvent.VK_ENTER)
      {


          photo.setIcon(new ImageIcon("photo\\" + regnotxt.getText() + ".jpg"));
      }
  }
  public void keyTyped(KeyEvent ke2)
  {

  }

     public static void main(String args[])
     {
         ViewStudent ob=new ViewStudent();
     }
     void setit(String text) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
            String sql = "select * from studentlogin where RegNo=?";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, text);
            rs = (ResultSet) pst.executeQuery();

            if (rs.next()) {
                
                String name = rs.getString("RegNo");
                regnotxt.setText(name);
                iddd = rs.getString("password");
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

