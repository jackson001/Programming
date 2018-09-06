

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import javax.swing.border.*;
import java.sql.*;
public class Generate extends JFrame implements ActionListener
{
    JLabel sem,month,year,mon;
    JComboBox semlist,yearlist;
    JList monthlist;
    JButton show,exit,clear,print,exit1;
    String mt="";
    String header[]={"RegNo","TheoryW","TheoryP","LabW","LabP","Total","Prec","Remark"};
     int tot=0,i=0;;
    Object data[][];
     JTable table;
     JFrame frame;
     JPanel jp;
    Generate()
    {
        ImageIcon image = new javax.swing.ImageIcon(getClass().getResource("/image/icon9.png"));
        Image im = image.getImage();
        setIconImage(im);
              setTitle("Generate");
              setLayout(null);
              setBounds(100,300,800,300);
              setVisible(true);
              setResizable(false);

              jp=new JPanel();
              jp.setBounds(0,0,800,300);
              jp.setLayout(null);
              getContentPane().add(jp);
              jp.setBackground(new Color(236,233,216));

              sem=new JLabel();
              sem.setText("Semester");
              sem.setBounds(30,75,100,30);
              jp.add(sem);
              sem.setFont(new Font("Arial",Font.BOLD,16));

              semlist=new JComboBox();
              semlist.setBounds(150,75,100,30);
              jp.add(semlist);
              semlist.setFont(new Font("Arial",Font.BOLD,16));
              semlist.addItem("-------");
              semlist.addItem("First");
              semlist.addItem("Second");
              semlist.addItem("Third");
              semlist.addItem("Fourth");

              month=new JLabel();
              month.setText("Month");
              month.setBounds(300,75,160,30);
              jp.add(month);
              month.setFont(new Font("Arial",Font.BOLD,16));

              String[] mon={"January","February","March","April","May","June","July","August","September","October","November","December"};
              monthlist=new JList(mon);
              monthlist.setVisibleRowCount(3);
              monthlist.setFont(new Font("Arial",Font.BOLD,16));
              JScrollPane scrollPane=new JScrollPane(monthlist);
              scrollPane.createVerticalScrollBar();
              scrollPane.createHorizontalScrollBar().disable();
              jp.add(scrollPane);
              scrollPane.setBounds(390,50,120,100);

              year=new JLabel();
              year.setText("Year");
              year.setBounds(530,75,50,30);
              jp.add(year);
              year.setFont(new Font("Arial",Font.BOLD,16));

              yearlist=new JComboBox();
              yearlist.setFont(new Font("Arial",Font.BOLD,16));
              jp.add(yearlist);
                yearlist.addItem("------");
                yearlist.addItem("2017");
                yearlist.addItem("2018");
                yearlist.addItem("2019");
                yearlist.addItem("2020");
                yearlist.addItem("2021");
                yearlist.addItem("2022");
              yearlist.setBounds(600,75,70,30);

              clear=new JButton("Clear");
              clear.setFont(new Font("Arial",Font.BOLD,16));
              jp.add(clear);
              clear.setBounds(150,200,100,30);
              clear.addActionListener(this);
              clear.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
               clear.setMnemonic('C');
               clear.setBackground(new Color(102,102,102));
               clear.setForeground(Color.white);

              show=new JButton("Show");
              show.setFont(new Font("Arial",Font.BOLD,16));
              jp.add(show);
              show.setBounds(300,200,100,30);
              show.addActionListener(this);
              show.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
               show.setMnemonic('S');
               show.setBackground(new Color(102,102,102));
               show.setForeground(Color.white);

              exit=new JButton("Exit");
              exit.setFont(new Font("Arial",Font.BOLD,16));
              jp.add(exit);
              exit.setBounds(450,200,100,30);
              exit.addActionListener(this);
              exit.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
               exit.setMnemonic('E');
               exit.setBackground(new Color(102,102,102));
               exit.setForeground(Color.white);


    }
    public void actionPerformed(ActionEvent e)
    {
           if(e.getActionCommand().equals("Clear"))
           {
                  monthlist.clearSelection();
                  semlist.setSelectedIndex(0);
                  yearlist.setSelectedIndex(0);

           }
           else if(e.getActionCommand().equals("Show"))
           {
               mt="";
               frame=new JFrame();
               frame.setTitle("Table");
                try
                {
                    tot=0;
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
                    Object[] values=monthlist.getSelectedValues();
                    PreparedStatement st,st1,st2,st3;
                    ResultSet rs,rs1,rs2,rs3;
                     st3=conn.prepareStatement("select * from "+semlist.getSelectedItem()+" where Month = ?");
                     st3.setString(1,monthlist.getSelectedValue().toString());
                     rs3=st3.executeQuery();
                     while(rs3.next())
                     {
                        tot++;
                     }
                     data=new Object[tot][8];
                     for(int k=0;k<tot;k++)
                     for(int j=0;j<8;j++)
                     data[k][j]=0;

                    for(int v=0;v<values.length;v++)
                    {
                    i=0;
                    mt=mt+"  "+values[v].toString();
                    st=conn.prepareStatement("select * from "+semlist.getSelectedItem()+" where Month = ?");
                     st.setString(1,values[v].toString());
                     rs=st.executeQuery();
                     st1=conn.prepareStatement("select *from monthdetails where Sem= ? and Month= ? and Year= ?");
                     st1.setString(1,semlist.getSelectedItem().toString());
                     st1.setString(2,values[v].toString());
                     st1.setString(3,yearlist.getSelectedItem().toString());
                     rs1=st1.executeQuery();
                       st2=conn.prepareStatement("select * from "+semlist.getSelectedItem()+" where Month = ?");
                     st2.setString(1,values[v].toString());
                     rs2=st2.executeQuery();
                     rs1.next();
                    Integer t=rs1.getInt(4)+rs1.getInt(5)+rs1.getInt(6)+rs1.getInt(7)+rs1.getInt(8)+rs1.getInt(9);
                     Integer t1=rs1.getInt(10)+rs1.getInt(11);
                      while(rs2.next())
                     {
                              data[i][0]=rs2.getString(1);
                              data[i][1]=Integer.parseInt(data[i][1].toString())+t;
                              data[i][2]=Integer.parseInt(data[i][2].toString())+rs2.getInt(3)+rs2.getInt(4)+rs2.getInt(5)+rs2.getInt(6)+rs2.getInt(7)+rs2.getInt(8);
                              data[i][3]=Integer.parseInt(data[i][3].toString())+t1;
                              data[i][4]=Integer.parseInt(data[i][4].toString())+rs2.getInt(9)+rs2.getInt(10);
                              data[i][5]=Integer.parseInt(data[i][2].toString())+Integer.parseInt(data[i][4].toString());
                              Float f=(Float.parseFloat(data[i][5].toString())/(Integer.parseInt(data[i][1].toString())+Integer.parseInt(data[i][3].toString())))*100;
                              String ta=f.toString(f);
                              ta=ta.subSequence(0,5).toString();
                              f=Float.parseFloat(ta);
                              data[i][6]=f;
                              if(f>=75)
                              data[i][7]="Eligible";
                              else if(f>=62.5f)
                              data[i][7]="Condonation";
                              else
                              data[i][7]="Detain";
                              i++;

                      }
                    }
                 }
             catch(Exception et){ }

        frame.addWindowListener(new WindowAdapter()
        {
         public void windowClosing(WindowEvent we)
         {
                 frame.dispose();
         }
       });
       TableModel dataModel = new AbstractTableModel()
       {

         public int getColumnCount()
         {
           return header.length;
         }
        public int getRowCount()
         {
           try
           {
           return data.length;
           }
           catch(Exception e){ return 0; }

         }
        public Object getValueAt(int row, int col)
         {
        	return data[row][col];
         }
        public String getColumnName(int column)
         {
         	return header[column];
         }
       /* public Class getColumnClass(int col)
         {
                 try
                 {
                 return getValueAt(0,col).getClass();
                 }
                 catch(Exception e){ return ""; }

         } */
          public boolean isCellEditable(int row, int col)
         {
                return (col==1);
         }
        public void setValueAt(Object aValue, int row,int column)
         {
                data[row][column] = aValue;
         }
     };
     table = new JTable(dataModel);
      JScrollPane scrollpane = new JScrollPane(table);
      frame.getContentPane().setLayout(null);
      scrollpane.setBounds(50,60,900,500);
      scrollpane.setVisible(true);
      frame.getContentPane().add(scrollpane);
      mon=new JLabel();
      mon.setBounds(100,20,500,40);
      mon.setFont(new Font("Arial",Font.BOLD,16));
      mon.setText("Attendence for the Month of "+mt);
      frame.getContentPane().add(mon);
      print=new JButton("Print");
      print.setBounds(400,600,100,30);
      frame.getContentPane().add(print);
      print.addActionListener(new ActionListener()
      {
          public void actionPerformed(ActionEvent evt)
          {
              try
              {
                  table.print();

              }
              catch(Exception e)
              {

              }
          }
      });
      exit1=new JButton("Exit");
      exit1.setBounds(530,600,100,30);
      frame.getContentPane().add(exit1);
      exit1.addActionListener(new ActionListener()
      {
          public void actionPerformed(ActionEvent evt)
          {
              frame.dispose();
          }
      });

         Toolkit kit=Toolkit.getDefaultToolkit();
       Dimension screenSize= kit.getScreenSize();
        frame.setSize(screenSize.width,screenSize.height);
        frame.setVisible(true);

           }
           else if(e.getActionCommand().equals("Exit"))
           {
                this.dispose();
           }
     }
    public static void main(String args[])
    {
        Generate gn=new Generate();
        gn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}