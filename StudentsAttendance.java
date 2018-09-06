
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JFrame;
/**
 *
 * @author King
 */
public class StudentsAttendance {

    /**
     * @param args the command line arguments
     */
    public static Home app = null;
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static final Dimension appSize = new Dimension(1323, 696);
    private static final int appPosX = (screenSize.width / 2) - (appSize.width / 2);
    private static final int appPosY = (screenSize.height / 2) - (appSize.height / 2);
    private static Rectangle appBounds = new Rectangle(appPosX, appPosY, appSize.width, appSize.height);
    public static void main(String[] args) {
        // TODO code application logic here
        //com.jtattoo.plaf.bernstein.BernsteinLookAndFeel.setTheme("Default");
        //com.jtattoo.plaf.hifi.HiFiLookAndFeel.setTheme("Default");
        //com.jtattoo.plaf.luna.LunaLookAndFeel.setTheme("Default");
        com.jtattoo.plaf.mcwin.McWinLookAndFeel.setTheme("Default");
        //com.jtattoo.plaf.graphite.GraphiteLookAndFeel.setTheme("Default");
        JFrame.setDefaultLookAndFeelDecorated(false);
        app = new Home();
        app.setVisible(true);
        app.setBounds(appBounds);
    }
    
}
