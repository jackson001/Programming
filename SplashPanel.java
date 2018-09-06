
import image.ImageHelper;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author King
 */
public class SplashPanel extends JPanel {
    private ImageIcon splashImage = ImageHelper.loadImage("fp.PNG");
    private Dimension size = new Dimension(splashImage.getIconWidth(), splashImage.getIconHeight());

    public SplashPanel() {
        super();
        setForeground(new Color(45,118,232));
        setBackground(new Color(255,255,255));
        setFont(new Font("Serif", Font.PLAIN, 28));
        
    }

    public Dimension getPreferredSize() {
        return size;
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D)g;
        splashImage.paintIcon(this, g, 0, 0);
        int x = 10;
        int y = 10;
        Object rh = g2D.getRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING);
        g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(getFont());
        g.setColor(new Color(45,118,232));
        g.setFont(new Font("TimesRoman", Font.BOLD, 14));
        g.drawString("STUDENT AUTOMATED ATTENDANCE SYSTEM", x , y +10);
        g.setColor(new Color(45,118,232));
        g.setFont(new Font("TimesRoman", Font.BOLD, 13));
        g.drawString("(USING FINGERPRINT RECOGNITION)", x + 40, y + 25);
        g.setColor(new Color(45,118,232));
        g.setFont(new Font("TimesRoman", Font.BOLD, 12));
        g.drawString("STUDENT ATTENDANCE SYSTEM COPYRIGHT @2018", x + 10, y +280);
        g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, rh);
    }

}
