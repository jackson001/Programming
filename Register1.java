/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author King
 */
public class Register1 extends javax.swing.JFrame {

    ResultSet rs = null;
    PreparedStatement pst = null;
    Connection conn = null;
    PreparedStatement pst1 = null;

    /**
     * Creates new form Register
     */
    public Register1() {
        initComponents();
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
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox12 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(45, 118, 232));
        jLabel1.setText("Lecturer ID");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(45, 118, 232));
        jLabel2.setText("Full Name");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(45, 118, 232));
        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(45, 118, 232));
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(45, 118, 232));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LECTURER REGISTRATION");

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyTyped(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(45, 118, 232));
        jLabel4.setText("Password");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(45, 118, 232));
        jLabel5.setText("Department");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(45, 118, 232));
        jLabel6.setText("User Name");

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(45, 118, 232));
        jLabel7.setText("Confirm Password");

        jPasswordField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordField2KeyReleased(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N
        jLabel8.setText("jLabel8");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N
        jLabel9.setText("jLabel9");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N
        jLabel10.setText("jLabel8");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N
        jLabel12.setText("jLabel8");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N
        jLabel13.setText("jLabel8");

        jComboBox12.setToolTipText("Choose Department");
        jComboBox12.setMinimumSize(new java.awt.Dimension(30, 20));
        jComboBox12.setPreferredSize(new java.awt.Dimension(30, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(18, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(jTextField4)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(jPasswordField2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(jComboBox12, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void fillcombobox(){
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null,"connection to the database is null!");
        }
        String sql = "select * from department where faculty = 'Science'";
        
        try{
            
            pst = (PreparedStatement) conn.prepareStatement(sql);
            rs = (ResultSet) pst.executeQuery();
            while(rs.next())
            {
                String sub = rs.getString("Name");
                jComboBox12.addItem(sub);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PreparedStatement stmt = null;
        if("".equals(jTextField1.getText())||"".equals(jTextField2.getText())||"".equals(jComboBox12.getSelectedItem().toString())||"".equals(jTextField4.getText())||"".equals(jPasswordField1.getText())){
            JOptionPane.showMessageDialog(null, "Please Input All The Fields");
            }else{
            if(jPasswordField1.getText().equals(jPasswordField2.getText())){
                try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
                String sql2 = "Select username from login where username= ?";
            stmt = (PreparedStatement) conn.prepareStatement(sql2);
            stmt.setString(1,jTextField4.getText());
            rs = (ResultSet) stmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Lecturer name already exists", "Error", JOptionPane.ERROR_MESSAGE);
                jTextField4.setText("");
                jTextField4.requestDefaultFocus();
                return;
            } else {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendant", "root", "");
        String sql = "insert into lecturer (Lecturerid,Lecturername,Login_username,Password,Department) values(?,?,?,?,?)";
        String sql1 = "insert into login (username,password,usertype) values(?,?,?)";
        pst = (PreparedStatement) conn.prepareStatement(sql);
        pst1 = (PreparedStatement) conn.prepareStatement(sql1);
        String id = jTextField1.getText();
        String name = jTextField2.getText();
        String user = jTextField4.getText();
        String pass = jPasswordField1.getText();
        String dept = jComboBox12.getSelectedItem().toString();
        String user1 = jTextField4.getText();
        String pass1 = jPasswordField1.getText();
        String type  = "Lecturer";
        pst.setString(1,id);
        pst.setString(2,name);
        pst.setString(3,user);
        pst.setString(4,pass);
        pst.setString(5,dept);
        pst1.setString(1,user1);
        pst1.setString(2,pass1);
        pst1.setString(3,type);
        pst.execute();
        pst1.execute();
        JOptionPane.showMessageDialog(rootPane, "Registration for "+name+" was successfully!\n"
                + "Please login. Choose role as lecturer");
        dispose();
        }}catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
}}else{
                JOptionPane.showMessageDialog(rootPane, "Password do not match");
            }
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        System.out.println(evt.getKeyChar());
        if ((Character.isDigit(c)) || (Character.isLetter(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_PERIOD) || (c == KeyEvent.SHIFT_DOWN_MASK)) {	
        if(jPasswordField1.getText().length()<7){
        ImageIcon myImage = new javax.swing.ImageIcon(getClass().getResource("/image/Wrong.PNG"));
        Image mg = myImage.getImage();
        Image newImage = mg.getScaledInstance(jLabel8.getWidth(), jLabel8.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon ge = new ImageIcon(newImage);
        jLabel8.setIcon(ge);
        }else{
        ImageIcon myImage = new javax.swing.ImageIcon(getClass().getResource("/image/right.PNG"));
        Image mg = myImage.getImage();
        Image newImage = mg.getScaledInstance(jLabel8.getWidth(), jLabel8.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon ge = new ImageIcon(newImage);
        jLabel8.setIcon(ge);
        }  
        }else{
        getToolkit().beep();
	evt.consume();
        JOptionPane.showMessageDialog(this, "Use Letters and Digits only!");
        jPasswordField1.setText("");
        }
    }//GEN-LAST:event_jPasswordField1KeyTyped

    private void jPasswordField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField2KeyReleased
        // TODO add your handling code here:
        if(jPasswordField2.getText().equals(jPasswordField1.getText())){
        ImageIcon myImage = new javax.swing.ImageIcon(getClass().getResource("/image/right.PNG"));
        Image mg = myImage.getImage();
        Image newImage = mg.getScaledInstance(jLabel9.getWidth(), jLabel9.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon ge = new ImageIcon(newImage);
        jLabel9.setIcon(ge);
        }else{
        ImageIcon myImage = new javax.swing.ImageIcon(getClass().getResource("/image/Wrong.PNG"));
        Image mg = myImage.getImage();
        Image newImage = mg.getScaledInstance(jLabel9.getWidth(), jLabel9.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon ge = new ImageIcon(newImage);
        jLabel9.setIcon(ge);
        }
    }//GEN-LAST:event_jPasswordField2KeyReleased

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        System.out.println(evt.getKeyChar());
        if ((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE)) {
        ImageIcon myImage = new javax.swing.ImageIcon(getClass().getResource("/image/right.PNG"));
        Image mg = myImage.getImage();
        Image newImage = mg.getScaledInstance(jLabel13.getWidth(), jLabel13.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon ge = new ImageIcon(newImage);
        jLabel13.setIcon(ge);
        }else{
        ImageIcon myImage = new javax.swing.ImageIcon(getClass().getResource("/image/Wrong.PNG"));
        Image mg = myImage.getImage();
        Image newImage = mg.getScaledInstance(jLabel13.getWidth(), jLabel13.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon ge = new ImageIcon(newImage);
        jLabel13.setIcon(ge);
        getToolkit().beep();
	evt.consume();
        JOptionPane.showMessageDialog(this, "Use Digits only!");
        jTextField1.setText("");
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        System.out.println(evt.getKeyChar());
        if (!((Character.isLetter(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_PERIOD))) {	  
        ImageIcon myImage = new javax.swing.ImageIcon(getClass().getResource("/image/Wrong.PNG"));
        Image mg = myImage.getImage();
        Image newImage = mg.getScaledInstance(jLabel10.getWidth(), jLabel10.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon ge = new ImageIcon(newImage);
        jLabel10.setIcon(ge);            
            getToolkit().beep();
            jTextField2.setText("");
            JOptionPane.showMessageDialog(this, "Use Letters only!");
            evt.consume();
        }else{
        ImageIcon myImage = new javax.swing.ImageIcon(getClass().getResource("/image/right.PNG"));
        Image mg = myImage.getImage();
        Image newImage = mg.getScaledInstance(jLabel10.getWidth(), jLabel10.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon ge = new ImageIcon(newImage);
        jLabel10.setIcon(ge);
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        fillcombobox();
    }//GEN-LAST:event_formWindowOpened

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        System.out.println(evt.getKeyChar());
        if (!((Character.isLetter(c)) || (Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_PERIOD) || (c == KeyEvent.SHIFT_DOWN_MASK))) {	  
        ImageIcon myImage = new javax.swing.ImageIcon(getClass().getResource("/image/Wrong.PNG"));
        Image mg = myImage.getImage();
        Image newImage = mg.getScaledInstance(jLabel12.getWidth(), jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon ge = new ImageIcon(newImage);
        jLabel12.setIcon(ge);            
            getToolkit().beep();
            jTextField2.setText("");
            JOptionPane.showMessageDialog(this, "Use Allowable Combinations!");
            evt.consume();
        }else{
        ImageIcon myImage = new javax.swing.ImageIcon(getClass().getResource("/image/right.PNG"));
        Image mg = myImage.getImage();
        Image newImage = mg.getScaledInstance(jLabel12.getWidth(), jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon ge = new ImageIcon(newImage);
        jLabel12.setIcon(ge);
        }
    }//GEN-LAST:event_jTextField4KeyTyped

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
            java.util.logging.Logger.getLogger(Register.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox12;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
