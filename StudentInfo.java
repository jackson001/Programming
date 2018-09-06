
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

/**
 *
 * @author King
 */

public class StudentInfo extends JFrame implements ActionListener,KeyListener
{
    java.sql.Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String iddd = null;
    JLabel  regno,name,photo,per,father,phone,status,permanent,town,dob,gender,admin,present,blood,doj,religion,castecode,castename;
     JTextField  regnotxt,nametxt,fathertxt,phonetxt,towntxt,dobtxt,admintxt,bloodtxt,castecodetxt,dojtxt,castenametxt;
    JButton insert,cancel,clear,modify,view,photoview;
    JComboBox statustxt,gendertxt,religiontxt;
    JTextArea permanenttxt,presenttxt;
    JPanel jp;

    /** Creates a new instance of StudentInfo */
    public StudentInfo()
    {
             Toolkit kit=Toolkit.getDefaultToolkit();
            Dimension screenSize= kit.getScreenSize();
            setSize(900,screenSize.height);
            setLocation(screenSize.width/6, 0);

                setLayout(null);
                jp=new JPanel(null);
                jp.setBounds(0,10,screenSize.width,screenSize.height);
                 jp.setBackground(new Color(255,255,255));
                 getContentPane().add(jp);

                per=new JLabel();
                per.setText("Personal Details");
                per.setFont(new Font("Sans-Serif",Font.BOLD+Font.ITALIC,50));
                per.setForeground(new Color(45,118,232));
                per.setBounds(20,20,500,50);
                jp.add(per);


                regno=new JLabel();
                regno.setText("Reg/Adm No");
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
                name.setText("Surname Name");
                name.setFont(new Font("Arial",Font.BOLD,20));
                name.setBounds(30,170,100,30);
                jp.add(name);

                nametxt=new JTextField();
                nametxt.setFont(new Font("Arial",Font.BOLD,16));
                nametxt.setBounds(175,170,200,30);
                jp.add(nametxt);


                father=new JLabel();
                father.setText("First Name");
                father.setBounds(30,205,100,30);
                father.setFont(new Font("Arial",Font.BOLD,16));
                jp.add(father);

               fathertxt=new JTextField();
                fathertxt.setFont(new Font("Arial",Font.BOLD,16));
                fathertxt.setBounds(175,205,200,30);
                jp.add(fathertxt);

                phone=new JLabel();
                phone.setText("Phone Number");
                phone.setBounds(30,240,130,30);
                phone.setFont(new Font("Arial",Font.BOLD,16));
                jp.add(phone);

               phonetxt=new JTextField();
                phonetxt.setFont(new Font("Arial",Font.BOLD,16));
                phonetxt.setBounds(175,240,200,30);
                jp.add(phonetxt);

               status=new JLabel();
                status.setText("Program");
                status.setBounds(30,275,100,30);
                status.setFont(new Font("Arial",Font.BOLD,16));
                jp.add(status);

                statustxt=new JComboBox();
                statustxt.addItem("Regular");
                statustxt.addItem("Self-Sponsored");
                statustxt.setBounds(175,275,200,30);
                statustxt.setBackground(Color.white);
                jp.add(statustxt);

                permanent=new JLabel();
                permanent.setText("Permanent Address");
                permanent.setBounds(30,310,130,30);
                permanent.setFont(new Font("Arial",Font.BOLD,16));
                jp.add(permanent);

                permanenttxt=new JTextArea(5,30);
                permanenttxt.setBounds(175,310,200,100);
                permanenttxt.setTabSize(0);
                // permanenttxt.add(new LineBorder(Color.black));
                jp.add(permanenttxt);

                town=new JLabel();
                town.setText("Original Town");
                town.setBounds(30,415,100,30);
                town.setFont(new Font("Arial",Font.BOLD,16));
                jp.add(town);

               towntxt=new JTextField();
                towntxt.setFont(new Font("Arial",Font.BOLD,16));
                towntxt.setBounds(175,415,200,30);
             //   towntxt.setTabStop(7);
                jp.add(towntxt);


                dob=new JLabel();
                dob.setText("Date of Birth");
                dob.setBounds(30,450,100,30);
                dob.setFont(new Font("Arial",Font.BOLD,16));
                jp.add(dob);

               dobtxt=new JTextField();
                dobtxt.setFont(new Font("Arial",Font.BOLD,16));
                dobtxt.setBounds(175,450,200,30);
                jp.add(dobtxt);

                gender=new JLabel();
                gender.setText("Gender");
                gender.setFont(new Font("Arial",Font.BOLD,16));
                gender.setBounds(450,135,100,30);
                jp.add(gender);

                gendertxt=new JComboBox();
                gendertxt.setFont(new Font("Arial",Font.BOLD,16));
                gendertxt.addItem("Male");
                gendertxt.addItem("Female");
                gendertxt.setBounds(595,135,200,30);
                jp.add(gendertxt);

                admin=new JLabel();
                admin.setText("Course Studied");
                admin.setFont(new Font("Arial",Font.BOLD,16));
                admin.setBounds(450,170,150,30);
                jp.add(admin);

                admintxt=new JTextField();
                admintxt.setFont(new Font("Arial",Font.BOLD,16));
                admintxt.setBounds(595,170,200,30);
                jp.add(admintxt);

                present=new JLabel();
                present.setText("Present Address");
                present.setBounds(450,205,100,30);
                present.setFont(new Font("Arial",Font.BOLD,16));
                jp.add(present);

                presenttxt=new JTextArea(5,30);
                presenttxt.setBounds(595,205,200,100);
                presenttxt.setTabSize(0);
                // permanenttxt.add(new LineBorder(Color.black));
                jp.add(presenttxt);

                blood=new JLabel();
                blood.setText("Blood Group");
                blood.setFont(new Font("Arial",Font.BOLD,16));
                blood.setBounds(450,310,150,30);
                jp.add(blood);

                bloodtxt=new JTextField();
                bloodtxt.setFont(new Font("Arial",Font.BOLD,16));
                bloodtxt.setBounds(595,310,200,30);
                jp.add(bloodtxt);

                doj=new JLabel();
                doj.setText("Date of Admission");
                doj.setFont(new Font("Arial",Font.BOLD,16));
                doj.setBounds(450,345,150,30);
                jp.add(doj);

                dojtxt=new JTextField();
                dojtxt.setFont(new Font("Arial",Font.BOLD,16));
                dojtxt.setBounds(595,345,200,30);
                jp.add(dojtxt);

                religion=new JLabel();
                religion.setText("Religion");
                religion.setBounds(450,380,100,30);
                religion.setFont(new Font("Arial",Font.BOLD,16));
                jp.add(religion);

                religiontxt=new JComboBox();
                religiontxt.addItem("Hindu");
                religiontxt.addItem("Muslim");
                religiontxt.addItem("Christian");
                religiontxt.addItem("Other");
                religiontxt.setBounds(595,380,200,30);
                religiontxt.setBackground(Color.white);
                jp.add(religiontxt);

                castecode=new JLabel();
                castecode.setText("Secret Code");
                castecode.setFont(new Font("Arial",Font.BOLD,16));
                castecode.setBounds(450,415,150,30);
                jp.add(castecode);

                castecodetxt=new JTextField();
                castecodetxt.setFont(new Font("Arial",Font.BOLD,16));
                castecodetxt.setBounds(595,415,200,30);
                jp.add(castecodetxt);

                castename=new JLabel();
                castename.setText("Nick Name");
                castename.setFont(new Font("Arial",Font.BOLD,16));
                castename.setBounds(450,450,150,30);
                jp.add(castename);

                castenametxt=new JTextField();
                castenametxt.setFont(new Font("Arial",Font.BOLD,16));
                castenametxt.setBounds(595,450,200,30);
                jp.add(castenametxt);
				photo = new JLabel(new ImageIcon(""));
				photo.setBounds(600, 20, 100, 100);
                photo.setBorder(new LineBorder(Color.black,2));
				jp.add(photo);
                photo.setIcon(new ImageIcon("photo\\default.jpg"));

               insert=new JButton("Insert");
               insert.setFont(new Font("Arial",Font.BOLD,16));
               insert.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
               insert.setMnemonic('I');
               insert.setBackground(new Color(102,102,255));
               insert.setForeground(Color.white);

               clear=new JButton("Clear");
               clear.setFont(new Font("Arial",Font.BOLD,16));
			   clear.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
			   clear.setMnemonic('C');
			   clear.setBackground(new Color(102,102,255));
               clear.setForeground(Color.white);

               cancel=new JButton("Exit");
               cancel.setFont(new Font("Arial",Font.BOLD,16));
               cancel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
               cancel.setMnemonic('E');
               cancel.setBackground(new Color(102,102,255));
                cancel.setForeground(Color.white);

               insert.setBounds(40,600,100,30);
               jp.add(insert);
               insert.addActionListener(this);
               clear.setBounds(160,600,100,30);
               jp.add(clear);
               clear.addActionListener(this);
               cancel.setBounds(280,600,100,30);
               jp.add(cancel);
               cancel.addActionListener(this);
               modify=new JButton("Modify");
               modify.setFont(new Font("Arial",Font.BOLD,16));
               modify.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
               modify.setBounds(400,600,100,30);
               modify.addActionListener(this);
               modify.setBackground(new Color(102,102,255));;
                modify.setForeground(Color.white);

               jp.add(modify);
               modify.setMnemonic('M');
               view=new JButton("View");
               view.setFont(new Font("Arial",Font.BOLD,16));
               view.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
               view.setBounds(520,600,100,30);
               view.addActionListener(this);
               view.setMnemonic('V');
               jp.add(view);
               view.setBackground(new Color(102,102,255));
           view.setForeground(Color.white);
                setVisible(true);
                ImageIcon image = new javax.swing.ImageIcon(getClass().getResource("/image/icon9.png"));
                Image im = image.getImage();
                setIconImage(im);
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
    public void actionPerformed(ActionEvent et)
    {
       try
       {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
                if (et.getActionCommand().equals("Insert"))
		{
                    if("".equals(nametxt.getText())||"".equals(fathertxt.getText())||"".equals(dobtxt.getText())||"".equals(phonetxt.getText())||"".equals(permanenttxt.getText())||"".equals(towntxt.getText())||"".equals(presenttxt.getText())||"".equals(bloodtxt.getText())||"".equals(dojtxt.getText())||"".equals(castecodetxt.getText())||"".equals(castenametxt.getText())){
			JOptionPane.showMessageDialog(null, "Please input all field");
                }else{try
			{
				Statement sta = conn.createStatement();
				Statement st = conn.createStatement();
				ResultSet rs = sta.executeQuery("SELECT *FROM studentdetails");
				while (rs.next())
				{
					if (regnotxt.getText().equals(rs.getString(1)))
						JOptionPane.showMessageDialog(null, "Record Already Exist");
				}

				st.execute("INSERT INTO studentdetails VALUES('" + regnotxt.getText() + "','" + nametxt.getText() +
						"','" + fathertxt.getText() + "','" + phonetxt.getText() + "','" + statustxt.getSelectedItem() +
						"','" + permanenttxt.getText() + "','" + towntxt.getText() + "','" + dobtxt.getText() +
						"','" + gendertxt.getSelectedItem() + "','" + admintxt.getText() + "','" + presenttxt.getText() +
						"','" + bloodtxt.getText() + "','" + dojtxt.getText() + "','" + religiontxt.getSelectedItem() +
						"','" + castecodetxt.getText() + "','" + castenametxt.getText() + "')");
				nametxt.setText("");
				fathertxt.setText("");
				dobtxt.setText("");
				admintxt.setText("");
				phonetxt.setText("");
				permanenttxt.setText("");
				towntxt.setText("");
				presenttxt.setText("");
				bloodtxt.setText("");
				dojtxt.setText("");
				castecodetxt.setText("");
				castenametxt.setText("");
                                photo.setIcon(new ImageIcon("photo\\default.jpg"));

				JOptionPane.showMessageDialog(null, "Inserted Successfully");
			}
			catch (Exception e) {
                        System.out.println("No");
                        JOptionPane.showMessageDialog(null, e);
                        }
                    }
		}

		else if (et.getActionCommand().equals("Clear"))
		{
			nametxt.setText("");
			fathertxt.setText("");
			dobtxt.setText("");
			admintxt.setText("");
			phonetxt.setText("");
			permanenttxt.setText("");
			towntxt.setText("");
			presenttxt.setText("");
			bloodtxt.setText("");
			dojtxt.setText("");
			castecodetxt.setText("");
			castenametxt.setText("");
			photo.setIcon(new ImageIcon("photo\\default.jpg"));

		}
		else if (et.getActionCommand().equals("Exit"))
		{
			int confirm = JOptionPane.showConfirmDialog(null, "Do you want to Exit", "Confirmation", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION)
			{
				this.dispose();
			}
			else
			{
				nametxt.setText("");
                                photo.setIcon(new ImageIcon("photo\\default.jpg"));

			}
		}
		else if (et.getActionCommand().equals("View"))
		{
			int i = 0;
			try
			{
				Statement stv = conn.createStatement();
				ResultSet r1 = stv.executeQuery("SELECT * FROM studentdetails");

				while (r1.next())
				{
					if (regnotxt.getText().equals(r1.getString(1)))
					{
						nametxt.setText(r1.getString(2));
						fathertxt.setText(r1.getString(3));
						dobtxt.setText(r1.getString(8));
						gendertxt.setSelectedItem(r1.getString(9));
						admintxt.setText(r1.getString(10));
						statustxt.setSelectedItem(r1.getString(5));
						phonetxt.setText(r1.getString(4));
						permanenttxt.setText(r1.getString(6));
						towntxt.setText(r1.getString(7));
						presenttxt.setText(r1.getString(11));
						bloodtxt.setText(r1.getString(12));
						dojtxt.setText(r1.getString(13));
						religiontxt.setSelectedItem(r1.getString(14));
						castecodetxt.setText(r1.getString(15));
						castenametxt.setText(r1.getString(16));
                        photo.setIcon(new ImageIcon("photo\\" + regnotxt.getText() + ".jpg"));
						modify.grabFocus();
						i++;
					}

				}
				if (i == 0)
				{
					JOptionPane.showMessageDialog(null, "No Record Found");
				}
			}
			catch (Exception er) {
                        System.out.println("No");
                        JOptionPane.showMessageDialog(null, er);
                        
                        }
		}
		else if (et.getActionCommand().equals("Modify"))
		{
                    if("".equals(nametxt.getText())||"".equals(fathertxt.getText())||"".equals(dobtxt.getText())||"".equals(phonetxt.getText())||"".equals(permanenttxt.getText())||"".equals(towntxt.getText())||"".equals(presenttxt.getText())||"".equals(bloodtxt.getText())||"".equals(dojtxt.getText())||"".equals(castecodetxt.getText())||"".equals(castenametxt.getText())){
			JOptionPane.showMessageDialog(null, "Please input all field");
                    }else{

			try
			{

                PreparedStatement st1 = conn.prepareStatement("UPDATE studentdetails SET Name=?,FName=?,Phno=?,Status=?,PerAdd=?,Town=?,DOB=?,Gender=?,AdmNo=?,PersAdd=?,Blood=?,DOJ=?,Religion=?,CasteCode=?,CasteName=? WHERE RegNo=?");
				st1.setString(16, regnotxt.getText());
				st1.setString(1, nametxt.getText());
				st1.setString(2, fathertxt.getText());
				st1.setString(3, phonetxt.getText());
				String str = statustxt.getSelectedItem().toString();
				st1.setString(4, str);
				st1.setString(5, permanenttxt.getText());
				st1.setString(6, towntxt.getText());
				st1.setString(7, dobtxt.getText());
				str = gendertxt.getSelectedItem().toString();
				st1.setString(8, str);
				st1.setString(9, admintxt.getText());
				st1.setString(10, presenttxt.getText());
				st1.setString(11, bloodtxt.getText());
				st1.setString(12, dojtxt.getText());
				str = religiontxt.getSelectedItem().toString();
				st1.setString(13, str);
				st1.setString(14, castecodetxt.getText());
				st1.setString(15, castenametxt.getText());
				int i = st1.executeUpdate();
				System.out.println("value of i" + i);
				if (i == 1)
				{

					JOptionPane.showMessageDialog(null, "Successfully Modified");
					nametxt.setText("");
					fathertxt.setText("");
					dobtxt.setText("");
					admintxt.setText("");
					phonetxt.setText("");
					permanenttxt.setText("");
					towntxt.setText("");
					presenttxt.setText("");
					bloodtxt.setText("");
					dojtxt.setText("");
					castecodetxt.setText("");
					castenametxt.setText("");
                                        photo.setIcon(new ImageIcon("photo\\default.jpg"));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Not Modified");
				}

			}
			catch (Exception et1) { 
                        JOptionPane.showMessageDialog(null, et1);
                        }
                    }
		}
		              /*  else if (et.getActionCommand().equals(regnotxt))
                {
                    System.out.println("reached photo section");
                    photo.setIcon(new ImageIcon("photo\\" + regnotxt.getText() + ".jpg"));
                }*/
                 }catch(HeadlessException | ClassNotFoundException | SQLException et2){
                 JOptionPane.showMessageDialog(null, et2);
                 }
    	}
  public void keyPressed(KeyEvent ke)
  {
       try
       {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
        Statement sta = conn.createStatement();
        ResultSet rs = sta.executeQuery("SELECT *FROM studentdetails");
	while (rs.next())
	{
		if (regnotxt.getText().equals(rs.getString(1)))
                {
		JOptionPane.showMessageDialog(null, "Record Already Exist");
                nametxt.setText(rs.getString(2));
		fathertxt.setText(rs.getString(3));
		dobtxt.setText(rs.getString(8));
		gendertxt.setSelectedItem(rs.getString(9));
		admintxt.setText(rs.getString(10));
		statustxt.setSelectedItem(rs.getString(5));
		phonetxt.setText(rs.getString(4));
		permanenttxt.setText(rs.getString(6));
		towntxt.setText(rs.getString(7));
		presenttxt.setText(rs.getString(11));
		bloodtxt.setText(rs.getString(12));
		dojtxt.setText(rs.getString(13));
		religiontxt.setSelectedItem(rs.getString(14));
		castecodetxt.setText(rs.getString(15));
		castenametxt.setText(rs.getString(16));
		photo.setIcon(new ImageIcon("photo\\" + regnotxt.getText() + ".jpg"));
		modify.grabFocus();
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
        StudentInfo si=new StudentInfo();

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