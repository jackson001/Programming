
import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.File;
import java.io.FileInputStream;
import java.io.*;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * @author King
 */
public class Takeattendence1 extends javax.swing.JFrame {

    /**
     * Creates new form Take attendance 1
     */
    JPanel panel = new JPanel();
    JTable table;
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    PreparedStatement pst1 = null;
    ResultSet rs1 = null;
    String filePath=null;
    String iddd = null;
    public Takeattendence1() {
        initComponents();
        panel.setBounds(300,170,600,800);
        panel.setPreferredSize(new Dimension(600,600));
        add(panel);
        ImageIcon image = new javax.swing.ImageIcon(getClass().getResource("/image/icon9.png"));Image im = image.getImage();
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
    public void retriveImage() throws SQLException, ClassNotFoundException
    {
    try{
    JFileChooser chooser=new JFileChooser(new File(""));
    chooser.setMultiSelectionEnabled(false);
    chooser.setVisible(true);
    chooser.showOpenDialog(this);
    File file=chooser.getSelectedFile();
    if(file!=null){filePath=file.getPath();}
    if(filePath!=null){
    FileInputStream fileInputStream=new FileInputStream(filePath);
    ImageIcon myImage = new ImageIcon(filePath);
    Image img = myImage.getImage();
    Image newImage = img.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), java.awt.Image.SCALE_SMOOTH);
    ImageIcon Image = new ImageIcon(newImage);
    jLabel3.setIcon(Image);
    System.out.println(Image.getIconHeight());
    System.out.println(Image.getIconWidth());
    
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
            String sql = "select * from student where image=? ";
            pst = conn.prepareStatement(sql);
            pst.setBinaryStream(1,(InputStream)fileInputStream,(int)file.length());
            rs = pst.executeQuery();
            //byte[] img = null;
            if (rs.next()) {
            String fullname = rs.getString("studentname");
            String id = rs.getString("idstudent");
            jTextField1.setText(id);
            jTextField2.setText(fullname);
            //img = rs.getBytes("image");
            //ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage());
            //jLabel3.setIcon(imageIcon);
            //System.out.println(imageIcon.getIconHeight());
            //System.out.println(imageIcon.getIconWidth());
            }else{
            JOptionPane.showMessageDialog(this, "Student not recognized!");
            }
/*
		BufferedImage imgA = null;
		BufferedImage imgB = null;

    File fileA = new File(filePath);
    File fileB = new File("C:\\Users\\J King Kong\\Desktop\\.PNG");
    FileOutputStream outputStream = new FileOutputStream(fileB); // it will create new file (same location of class)
    outputStream.write(img); // image write in file
    outputStream.close(); // close the output stream

    imgA = ImageIO.read(fileA);
    imgB = ImageIO.read(fileB);

		int width1 = imgA.getWidth();
		int width2 = imgB.getWidth();
		int height1 = imgA.getHeight();
		int height2 = imgB.getHeight();

		if ((width1 != width2) || (height1 != height2)){
			System.out.println("Error: Images dimensions "+" mismatch");
                        JOptionPane.showMessageDialog(null, "Fingerprints do not match!");
    }
		else
		{
			long difference = 0;
			for (int y = 0; y < height1; y++)
			{
				for (int x = 0; x < width1; x++)
				{
					int rgbA = imgA.getRGB(x, y);
					int rgbB = imgB.getRGB(x, y);
					int redA = (rgbA >> 16) & 0xff;
					int greenA = (rgbA >> 8) & 0xff;
					int blueA = (rgbA) & 0xff;
					int redB = (rgbB >> 16) & 0xff;
					int greenB = (rgbB >> 8) & 0xff;
					int blueB = (rgbB) & 0xff;
					difference += Math.abs(redA - redB);
					difference += Math.abs(greenA - greenB);
					difference += Math.abs(blueA - blueB);
				}
			}

			// Total number of red pixels = width * height
			// Total number of blue pixels = width * height
			// Total number of green pixels = width * height
			// So total number of pixels = width * height * 3
			double total_pixels = width1 * height1 * 3;

			// Normalizing the value of different pixels
			// for accuracy(average pixels per color
			// component)
			double avg_different_pixels = difference / total_pixels;

			// There are 255 values of pixels in total
			double percentage = (avg_different_pixels / 255) * 100;

			System.out.println("Difference Percentage--> " + percentage);
                        JOptionPane.showMessageDialog(null, "Fingerprints match! Difference in Percentage--> " + percentage);
                        
                        //jTable2.changeSelection(val, ICONIFIED, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
                        //jTextField1.setText(jTable2.getModel().getValueAt(val, 0).toString());
                        //jLabel6.setIcon(new ImageIcon (Toolkit.getDefaultToolkit().createImage(b)));


		}*/

    }else
    {
    JOptionPane.showMessageDialog(this,"Please enter a file..." );
    }
    }catch(HeadlessException | IOException e)
    {

    JOptionPane.showMessageDialog(this, e.getMessage());
    }
    }
    public void UpdateJTable1(String a){
    //String sql = "SELECT student_idstudent, count(CASE WHEN  status = 'Present'  then 1 END)/count(*)*100 as percentage FROM attendence where student_subject_subjectid = 102 group by student_idstudent";
    try {
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
    
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    jLabel1.setText(a);
    jLabel1.setVisible(true);
    jLabel2.setVisible(true);
    try{
        String sub = null;
        String year = null;
    String sql = "select * from teaches where subjectid=? ";
    pst  = (PreparedStatement) conn.prepareStatement(sql);
    pst.setString(1,a);
    rs = (ResultSet) pst.executeQuery();
    while(rs.next())
            {
                sub = rs.getString("semester");
                System.out.println(sub);
                year = rs.getString("Year");
                System.out.println(year);
            }

Vector columnNames = new Vector();
Vector data = new Vector();
try {
String sql1 = "select idstudent, studentname from student where semester=? and Year=?";
pst  = (PreparedStatement) conn.prepareStatement(sql1);
pst.setString(1,sub);
pst.setString(2,year);
ResultSet resultSet;
            resultSet = (ResultSet) pst.executeQuery();
ResultSetMetaData metaData = resultSet.getMetaData();
int columns = metaData.getColumnCount();
for (int i = 1; i <= columns; i++) {
columnNames.addElement(metaData.getColumnName(i));
}
columnNames.addElement("Attendance");
while (resultSet.next()) {
Vector row = new Vector(columns);
for (int i = 1; i <= columns; i++) {
row.addElement(resultSet.getObject(i));
}
row.addElement(false);
data.addElement(row);
}
resultSet.close();
pst.close();
} catch (SQLException e) {
System.out.println(e);
}
    DefaultTableModel model = new DefaultTableModel(data, columnNames);
    table = new JTable(model);
    table.getModel().addTableModelListener(new TableModelListener() {
    @Override
    public void tableChanged(TableModelEvent e) {
    /*
    for (int i = 0; i < table.getRowCount(); i++) {
    Boolean chked = Boolean.valueOf(table.getValueAt(i, 2).toString());
    String dataCol1 = table.getValueAt(i, 2).toString();
    if (chked) {
    JOptionPane.showMessageDialog(null, dataCol1);
    }
    }
    */
    int row = e.getFirstRow();
    int column = e.getColumn();
    if (column == 2) {
        TableModel model = (TableModel) e.getSource();
        String columnName = model.getColumnName(column);
        Boolean checked = (Boolean) model.getValueAt(row, column);
        if (checked) {
            try {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime());
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
            String sql = "update attendence set status=? where idstudent=? and studentName=? and Date1=? and subjectid=?";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1,"Present");
            pst.setString(2,table.getModel().getValueAt(row, 0).toString());
            pst.setString(3,table.getModel().getValueAt(row, 1).toString());
            pst.setString(4,timeStamp);
            pst.setString(5,jLabel1.getText());
            pst.execute();
             JOptionPane.showMessageDialog(null, table.getModel().getValueAt(row, 0).toString() + " is Present!");
        } catch (HeadlessException | ClassNotFoundException | SQLException ex ) {
            System.out.println("yes");
            JOptionPane.showMessageDialog(null, ex);
        }
        } else {
            try {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime());
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
            String sql = "update attendence set status=? where idstudent=? and studentName=? and Date1=? and subjectid=?";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1,"Absent");
            pst.setString(2,table.getModel().getValueAt(row, 0).toString());
            pst.setString(3,table.getModel().getValueAt(row, 1).toString());
            pst.setString(4,timeStamp);
            pst.setString(5,jLabel1.getText());
            pst.execute();
             JOptionPane.showMessageDialog(null, table.getModel().getValueAt(row, 0).toString() + " is Absent!");
        } catch (HeadlessException | ClassNotFoundException | SQLException ex ) {
            System.out.println("no");
            JOptionPane.showMessageDialog(null, ex);
        }
        }
    }
    /*
        int selectedBundles= 0;
        //Count all checked boxes
        for(int i=0; i<table.getRowCount(); i++){
             if(table.getValueAt(i, 2).equals(Boolean.TRUE)){
                 selectedBundles++;
             }
        }
    System.out.println("Selected Bundles: " + selectedBundles);
    for (int i = 0; i < table.getRowCount(); i++) {
    Boolean chked = Boolean.valueOf(table.getValueAt(i, 2).toString());
    String dataCol1 = table.getValueAt(i, 2).toString();
    if (chked) {
    JOptionPane.showMessageDialog(null, dataCol1);
    }
    }*/    
    }
    });
            
            table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) { 
            System.out.println("Clicked");
            int row = table.getSelectedRow();
            jTextField1.setText(table.getModel().getValueAt(row, 0).toString());
            jTextField2.setText(table.getModel().getValueAt(row, 1).toString());
            }
            });/*{
            private static final long serialVersionUID = 1L;
            @Override
            public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
            }
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        }; */
            TableColumn tc;
            tc = table.getColumnModel().getColumn(2);
            tc.setCellEditor(table.getDefaultEditor(Boolean.class));   
            tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));   
            tc.setHeaderRenderer(new CheckBoxHeader(new MyItemListener()));
            tc.setWidth(300);
            tc.setResizable(true);
    //tc.setCellRenderer(cellRenderer);
    /*TableColumn column;
    for (int i = 0; i < table.getColumnCount(); i++) {
    column = table.getColumnModel().getColumn(i);
    column.setMaxWidth(250);
    }*/
    JScrollPane scrollPane = new JScrollPane(table);
    panel.add(scrollPane);
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }  
    public void UpdateJTable(String a){
    //String sql = "SELECT student_idstudent, count(CASE WHEN  status = 'Present'  then 1 END)/count(*)*100 as percentage FROM attendence where student_subject_subjectid = 102 group by student_idstudent";
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime());
    try {
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    jLabel1.setText(a);
    jLabel1.setVisible(true);
    jLabel2.setVisible(true);
    try{
        String sub = null;
        String year = null;
    String sql = "select * from teaches where subjectid=? ";
    pst  = (PreparedStatement) conn.prepareStatement(sql);
    pst.setString(1,a);
    rs = (ResultSet) pst.executeQuery();
    while(rs.next())
            {
                sub = rs.getString("semester");
                System.out.println(sub);
                year = rs.getString("Year");
                System.out.println(year);
            }
    String id = null;
    String name = null;
    String sql1 = "select idstudent,studentname from student where semester=? and Year=?";
    pst1  = (PreparedStatement) conn.prepareStatement(sql1);
    pst1.setString(1,sub);
    pst1.setString(2,year);
    ResultSet rs2 = (ResultSet) pst1.executeQuery();
    String sql2 = "insert into attendence (idstudent,studentName,Date1,status,subjectid) values (?,?,?,?,?)";
    PreparedStatement pst2  = (PreparedStatement) conn.prepareStatement(sql2);
    while(rs2.next())
            {
                id = rs2.getString("idstudent");
                System.out.println(id);
                pst2.setString(1,id);
                name = rs2.getString("studentname");
                System.out.println(name);
                pst2.setString(2,name);
                pst2.setString(3,timeStamp);
                pst2.setString(4,"Absent");
                pst2.setString(5,a);
                pst2.execute();
    }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null, e.getMessage());
    }
        
    /*try{
            String sql111;
            sql111 = "select TO_DATE(sysdate, 'yyyy-mm-dd')as aa from dual";
            pst = (PreparedStatement) conn.prepareStatement(sql111);
            rs = (ResultSet) pst.executeQuery();
            if(rs.next())
            {
                String id = rs.getString("aa");
                jLabel2.setText(id);
                System.out.println(id);
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }*/
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Egerton Students Attendance System");
        setBackground(new java.awt.Color(204, 204, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setEnabled(false);

        jLabel2.setEnabled(false);

        jLabel3.setForeground(new java.awt.Color(45, 118, 232));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Fingerprint image goes here");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(45, 118, 232));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Search or Load Fingerprint");

        jButton4.setBackground(new java.awt.Color(102, 102, 255));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Load/Scan Fingerprint");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(45, 118, 232));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("LECTURER");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(45, 118, 232));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("TAKE ATTENDANCE:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(45, 118, 232));
        jLabel7.setText("Registration No:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(45, 118, 232));
        jLabel8.setText("Student Name:");

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Present");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Absent");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addGap(87, 87, 87)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addGap(139, 139, 139))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(45, 118, 232));
        jLabel9.setText("UNIT CODE:");

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(45, 118, 232));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/qwerty.PNG"))); // NOI18N
        jLabel10.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        jTextField3.setText(jLabel1.getText());
        try {
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
    
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if("".equals(jTextField1.getText())||"".equals(jTextField2.getText())){
            JOptionPane.showMessageDialog(null, "Input student Registration!");
        }else{
         try {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime());
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
            String sql = "update attendence set status=? where idstudent=? and studentName=? and Date1=? and subjectid=?";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1,"Present");
            pst.setString(2,jTextField1.getText());
            pst.setString(3,jTextField2.getText());
            pst.setString(4,timeStamp);
            pst.setString(5,jLabel1.getText());
            pst.execute();
            table.getModel().setValueAt(true,table.getSelectedRow(), 2);
            JOptionPane.showMessageDialog(null, jTextField1.getText() + " is Present!");

            
        } catch (HeadlessException | ClassNotFoundException | SQLException e ) {
            System.out.println("no");
            JOptionPane.showMessageDialog(null, e);

        }}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime());
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
            String sql = "update attendence set status=? where idstudent=? and studentName=? and Date1=? and subjectid=?";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1,"Absent");
            pst.setString(2,jTextField1.getText());
            pst.setString(3,jTextField2.getText());
            pst.setString(4,timeStamp);
            pst.setString(5,jLabel1.getText());
            pst.execute();
            table.getModel().setValueAt(false,table.getSelectedRow(), 2);
            JOptionPane.showMessageDialog(null, jTextField1.getText() + " is Absent!");
            
        } catch (HeadlessException | ClassNotFoundException | SQLException e ) {
            System.out.println("no");
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(null, "Do you want to Exit?", "Confirmation", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION)
			{       
                              
				this.dispose();

			}
                        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
            retriveImage();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Takeattendence1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        // TODO add your handling code here:
                if("".equals(jTextField1.getText())){
            table.setVisible(true);
        }else{
            table.setVisible(true);
        try{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
        String sql = "select idstudent, studentname from attendence where Date1 = ? and subjectid = ? and idstudent like ? or studentsName like ?";
        pst1 = (PreparedStatement) conn.prepareStatement(sql);
        Vector columnNames = new Vector();
        Vector data = new Vector();
        String name = jTextField4.getText();
        String id = jTextField4.getText();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime());
        pst1.setString(1,timeStamp);
        pst1.setString(2,jLabel1.getText());
        pst1.setString(3,"%"+name+"%");
        pst1.setString(4,"%"+id+"%");
        ResultSet resultSet = (ResultSet) pst1.executeQuery();
ResultSetMetaData metaData = resultSet.getMetaData();
int columns = metaData.getColumnCount();
for (int i = 1; i <= columns; i++) {
columnNames.addElement(metaData.getColumnName(i));
}
columnNames.addElement("Attendance");
while (resultSet.next()) {
Vector row = new Vector(columns);
for (int i = 1; i <= columns; i++) {
row.addElement(resultSet.getObject(i));
}
row.addElement(false);
data.addElement(row);
}
resultSet.close();
pst.close();
    DefaultTableModel model = new DefaultTableModel(data, columnNames);
    table = new JTable(model);
        }catch(ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(rootPane, "XAMPP Database threw an Error: "+e.getMessage());
        }
        }
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
         try
    {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
        String sql = "select * from student";
        PreparedStatement st=conn.prepareStatement(sql);
        //st.setString(1,jTextField1.getText());
	ResultSet r1 = st.executeQuery(sql);
                    while(r1.next())
                  {
                      if(jTextField1.getText().equals(r1.getString(1)))
			{
                    jTextField2.setText(r1.getString(2));
                    JOptionPane.showMessageDialog(null, "Please select" + jTextField1.getText() + "on the table below");
                        }else{
                      }
                    }
            }
           catch(ClassNotFoundException | SQLException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
           }
    }//GEN-LAST:event_jTextField1KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Takeattendence1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Takeattendence1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Takeattendence1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Takeattendence1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Takeattendence1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    void setit(String text) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
            String sql = "select * from Lecturer where Lecturername=?";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, text);
            rs = (ResultSet) pst.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Cant identify you!");
                
            } else {
                String name = rs.getString("Lecturername");
                
                jLabel5.setText(name);
                iddd = rs.getString("Lecturerid");
                System.out.println(""+iddd);

            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println("no");
            JOptionPane.showMessageDialog(null, e);

        }  
    }
class MyItemListener implements ItemListener   
  {   
    @Override
    public void itemStateChanged(ItemEvent e) {   
      Object source = e.getSource();   
      if (source instanceof AbstractButton == false) return;   
      boolean checked = e.getStateChange() == ItemEvent.SELECTED;   
      for(int x = 0, y = table.getRowCount(); x < y; x++)   
      {   
        table.setValueAt(checked,x,2);   
      }   
    }   
  }      
class CheckBoxHeader extends JCheckBox implements TableCellRenderer, MouseListener {   
  protected CheckBoxHeader rendererComponent;   
  protected int column;   
  protected boolean mousePressed = false;   
  private int BOOLEAN_COLUMN;
  public CheckBoxHeader(ItemListener itemListener) {   
    rendererComponent = this;   
    rendererComponent.addItemListener(itemListener);   
  }   
  @Override
  public Component getTableCellRendererComponent(   
      JTable table, Object value,   
      boolean isSelected, boolean hasFocus, int row, int column) {   
    if (table != null) {   
      JTableHeader header = table.getTableHeader();   
      if (header != null) {   
        rendererComponent.setForeground(header.getForeground());   
        rendererComponent.setBackground(header.getBackground());   
        rendererComponent.setFont(header.getFont());   
        header.addMouseListener(rendererComponent);   
      }   
    }   
    setColumn(column); 
    rendererComponent.setText("[Check All] Attendance:"); 
    setBorder(UIManager.getBorder("TableHeader.cellBorder"));   
    return rendererComponent;   
  }   
  protected void setColumn(int column) {   
    this.column = column;   
  }   
  public int getColumn() {   
    return column;   
  }   
  protected void handleClickEvent(MouseEvent e) {   
    if (mousePressed) {   
      mousePressed=false;   
      JTableHeader header = (JTableHeader)(e.getSource());   
      JTable tableView = header.getTable();   
      TableColumnModel columnModel = tableView.getColumnModel();   
      int viewColumn = columnModel.getColumnIndexAtX(e.getX());   
      int column1 = tableView.convertColumnIndexToModel(viewColumn);   
     
      if (viewColumn == this.column && e.getClickCount() == 1 && column1 != -1) {   
        doClick();   
      }   
    }   
  }   
  @Override
  public void mouseClicked(MouseEvent e) {   
    handleClickEvent(e);   
    ((JTableHeader)e.getSource()).repaint();   
  }   
  @Override
  public void mousePressed(MouseEvent e) {   
    mousePressed = true;   
  }   
  @Override
  public void mouseReleased(MouseEvent e) {   
  }   
  @Override
  public void mouseEntered(MouseEvent e) {   
  }   
  @Override
  public void mouseExited(MouseEvent e) {   
  }
}
}
