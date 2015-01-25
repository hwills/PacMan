import java.awt.*;
import java.awt.image.*;
/**
 * A ghost pellet for pacman to eat. It will turn the ghosts edible if it is eaten *this property is done in the game's main system
 * 
 * @author Hunter Wills 
 * @version 5/11/2013
 */
public class GhostPellet extends Pellet
{
    /**
     * Constructor for objects of class GhostPellet
     */
    public GhostPellet(Grid grid)
    {
        super();
        diameter = grid.getGridSize()/2 + grid.getGridSize()/4;//size of a ghost pellet's diameter
        x = -100;//initially somewhere off screen
        y = -100;//initially somewhere off screen
        this.grid = grid;
    }
    /**
     * Method draw draws a ghost pellet
     *
     */
    public void draw(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillOval(x,y,grid.getGridSize(),grid.getGridSize());
        g.setColor(Color.BLACK);
    }
}
