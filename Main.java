

/*
 * Main.java
 *
 * Created on September 19, 2007, 4:51 PM
 *
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 *
 * @author King
 */
public class Main extends JFrame
{
    
    /** Creates a new instance of Main */
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int screenHeight=screenSize.height;
        int screenWidth=screenSize.width;
        System.out.println("Screen Height"+screenHeight+"ScreenWidth"+screenWidth);
    }
    
}
