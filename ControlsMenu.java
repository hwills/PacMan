import java.awt.*;
import javax.swing.*;
/**
 * The controls menu for the game.
 * 
 * @author Hunter Wills 
 * @version 5/11/2013
 */
public class ControlsMenu extends JPanel
{
    /**
     * Constructor for objects of class ControlsMenu
     */
    public ControlsMenu()
    {
        super();
        setPreferredSize(new Dimension(600,600));
        setLayout(null);
    }
    /**
     * Method paintComponent paints the Controls Screen with the pacman title and list of controls
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
        g.setColor(Color.GREEN);
        g.fillRect(248,250,8,40);//U
        g.fillRect(256,282,8,8);
        g.fillRect(264,250,8,40);
        g.fillRect(280,266,8,40);//p
        g.fillRect(288,266,8,8);
        g.fillRect(288,282,8,8);
        g.fillRect(296,274,8,8);
        g.fillRect(328,274,8,8);//up arrow
        g.fillRect(336,266,8,8);
        g.fillRect(344,258,8,32);
        g.fillRect(352,266,8,8);
        g.fillRect(360,274,8,8);
        g.drawString("Up arrow key",376,282);//string up arrow
        g.fillRect(174,314,8,40);//D
        g.fillRect(182,314,8,8);
        g.fillRect(182,346,8,8);
        g.fillRect(190,322,8,24);
        g.fillRect(206,330,8,24);//o
        g.fillRect(214,330,8,8);
        g.fillRect(214,346,8,8);
        g.fillRect(222,330,8,24);
        g.fillRect(240,330,8,16);//w
        g.fillRect(248,346,8,8);
        g.fillRect(256,338,8,8);
        g.fillRect(264,346,8,8);
        g.fillRect(272,330,8,16);
        g.fillRect(288,330,8,24);//n
        g.fillRect(296,338,16,8);
        g.fillRect(304,346,8,8);
        g.fillRect(328,330,8,8);//down arrow
        g.fillRect(336,338,8,8);
        g.fillRect(344,322,8,32);
        g.fillRect(352,338,8,8);
        g.fillRect(360,330,8,8);
        g.drawString("Down arrow key",376,346);//string down arrow
        g.fillRect(176,386,8,40);//L
        g.fillRect(184,418,24,8);
        g.fillRect(216,394,8,24);//e
        g.fillRect(224,386,16,8);
        g.fillRect(224,418,16,8);
        g.fillRect(232,402,8,8);
        g.fillRect(240,394,8,16);
        g.fillRect(256,386,8,40);//f
        g.fillRect(264,386,8,8);
        g.fillRect(264,410,8,8);
        g.fillRect(272,386,8,16);
        g.fillRect(288,402,8,8);//t
        g.fillRect(296,386,8,40);
        g.fillRect(304,402,8,8);
        g.fillRect(344,386,8,8);//left arrow
        g.fillRect(336,394,8,8);
        g.fillRect(328,402,32,8);
        g.fillRect(336,410,8,8);
        g.fillRect(344,418,8,8);
        g.drawString("Left arrow key",376,410);//string left arrow
        g.fillRect(176,450,8,40);//R
        g.fillRect(184,450,8,8);
        g.fillRect(184,466,8,8);
        g.fillRect(192,458,8,8);
        g.fillRect(192,474,8,16);
        g.fillRect(208,450,8,8);//i
        g.fillRect(208,466,8,24);
        g.fillRect(224,466,8,24);//g
        g.fillRect(224,498,16,8);
        g.fillRect(232,466,8,8);
        g.fillRect(232,482,8,8);
        g.fillRect(240,466,8,40);
        g.fillRect(256,450,8,40);//h
        g.fillRect(264,466,8,8);
        g.fillRect(272,466,8,24);
        g.fillRect(288,466,8,8);//t
        g.fillRect(296,450,8,40);
        g.fillRect(304,466,8,8);
        g.fillRect(336,450,8,8);//right arrow
        g.fillRect(344,458,8,8);
        g.fillRect(328,466,32,8);
        g.fillRect(344,474,8,8);
        g.fillRect(336,482,8,8);
        g.drawString("Right arrow key",376,474);//string right arrow
        g.setColor(Color.BLACK);
    }
}
