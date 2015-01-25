import java.awt.*;
import java.awt.image.*;
/**
 * A pellet that can be eaten by pacman. No special properties.
 * 
 * @author Hunter Wills 
 * @version 5/11/2013
 */
public class NormalPellet extends Pellet
{
    /**
     * Constructor for objects of class NormalPellet
     */
    public NormalPellet(Grid grid)
    {
        super();
        diameter = grid.getGridSize()/4;//the size of a normal pellet's diameter
        x = -100;//initially somewhere off screen
        y = -100;//initially somewhere off screen
        this.grid = grid;
    }
    /**
     * Method draw draws a normal pellet
     *
     */
    public void draw(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillOval(x,y,diameter,diameter);
        g.setColor(Color.BLACK);
    }
}
