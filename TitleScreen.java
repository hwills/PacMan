import java.awt.*;
import javax.swing.*;
/**
 * The title screen for our game
 * 
 * @author Hunter Wills 
 * @version 5/11/2013
 */
public class TitleScreen extends JPanel
{
    /**
     * Constructor for objects of class TitleScreen
     */
    public TitleScreen()
    {
        super();
        setPreferredSize(new Dimension(600,600));
        setLayout(null);
    }
    /**
     * Method paintComponent paints the Title Screen
     *
     */
    public void paintComponent(Graphics g){
        g.fillRect(0,0,600,600);
        g.setColor(Color.RED);
        g.fillRect(52,70,15,135);
        g.fillRect(532,70,15,135);
        g.fillRect(67,70,465,15);
        g.fillRect(67,190,465,15);
        g.setColor(Color.ORANGE);
        g.fillRect(67,85,465,105);
        g.setColor(Color.YELLOW);
        g.fillRect(82,100,15,75);
        g.fillRect(97,100,15,15);
        g.fillRect(97,130,15,15);
        g.fillRect(112,100,15,45);
        g.fillRect(142,100,15,75);
        g.fillRect(157,100,15,15);
        g.fillRect(157,145,15,15);
        g.fillRect(172,100,15,75);
        g.fillRect(202,100,15,75);//C
        g.fillRect(217,100,30,15);
        g.fillRect(217,160,30,15);
        g.fillRect(262,130,30,15);//dash
        g.fillRect(307,100,15,75);//M1
        g.fillRect(322,100,15,15);
        g.fillRect(337,100,15,45);
        g.fillRect(352,100,15,15);
        g.fillRect(367,100,15,75);//M2
        g.fillRect(397,100,15,75);//A1
        g.fillRect(412,100,15,15);
        g.fillRect(412,145,15,15);
        g.fillRect(427,100,15,75);//A2
        g.fillRect(457,100,15,75);//N1
        g.fillRect(472,115,15,30);
        g.fillRect(487,130,15,30);
        g.fillRect(502,100,15,75);//N2
        g.setColor(Color.BLACK);
    }
}
