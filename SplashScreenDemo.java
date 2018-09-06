/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author J King Kong
 */
import java.awt.*;
import javax.swing.*;
public class SplashScreenDemo {
    JFrame frame;
    JLabel image=new JLabel(new javax.swing.ImageIcon(getClass().getResource("/image/fp.PNG")));
    JLabel text=new JLabel("STUDENT'S ATTENDANCE SYSTEM");
    JProgressBar progressBar=new JProgressBar();
    JLabel message=new JLabel();//Crating a JLabel for displaying the message
    SplashScreenDemo()
    {
        createGUI();
        addImage();
        addText();
        addProgressBar();
        addMessage();
        runningPBar();
        ImageIcon image = new javax.swing.ImageIcon(getClass().getResource("/image/icon9.png"));
        Image im = image.getImage();
        frame.setIconImage(im);

    }
    public void createGUI(){
        frame=new JFrame();
        ImageIcon image = new javax.swing.ImageIcon(getClass().getResource("/image/icon9.png"));
        Image im = image.getImage();
        frame.setIconImage(im);
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getContentPane().setForeground(new Color(45,118,232));
        frame.getContentPane().setBackground(new Color(255,255,255));
 
    }
    public void addImage(){
        image.setSize(600,200);
        frame.add(image);
    }
    public void addText()
    {
        text.setFont(new Font("arial",Font.BOLD,30));
        text.setBounds(50,220,600,40);
        text.setForeground(new Color(45,118,232));
        frame.add(text);
    }
    public void addMessage()
    {
        message.setBounds(250,320,200,40);//Setting the size and location of the label
        message.setForeground(new Color(45,118,232));//Setting foreground Color
        message.setFont(new Font("arial",Font.BOLD,15));//Setting font properties
        frame.add(message);//adding label to the frame
    }
    public void addProgressBar(){
        progressBar.setBounds(100,280,400,30);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(new Color(45,118,232));
        progressBar.setValue(0);
        frame.add(progressBar);
    }
    public void runningPBar(){
        int i=0;//Creating an integer variable and intializing it to 0
 
        while( i<=100)
        {
            try{
                Thread.sleep(50);//Pausing execution for 50 milliseconds
                progressBar.setValue(i);//Setting value of Progress Bar
                message.setText("LOADING "+Integer.toString(i)+"%");//Setting text of the message JLabel
                i++;
                if(i==100)
                    frame.dispose();
            }catch(Exception e){
                e.printStackTrace();
            }
 
 
 
        }
    }
    /*public static void main(String args[]) {
        new SplashScreenDemo();
            
    }*/
}
