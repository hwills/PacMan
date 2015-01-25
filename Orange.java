import java.awt.*;
import java.awt.image.*;
/**
 * A orange fruit bonus.
 * 
 * @author Hunter Wills 
 * @version 5/11/2013
 */
public class Orange extends FruitBonus
{
    /**
     * Constructor for objects of class Orange
     */
    public Orange(Grid grid)
    {
        super();
        this.grid = grid;
    }
    /**
     * Method draw draws an orange
     *
     */
    public void draw(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillOval(x,y+grid.getGridSize()/2,5*grid.getGridSize()/4-2,grid.getGridSize());
        g.setColor(Color.GREEN);
        g.fillRect(x+5*grid.getGridSize()/8,y+grid.getGridSize()/2,grid.getGridSize()/4,grid.getGridSize()/4);
        g.fillRect(x+4*grid.getGridSize()/8,y+2*grid.getGridSize()/8+grid.getGridSize()/2,grid.getGridSize()/8,grid.getGridSize()/8);
        g.fillRect(x+4*grid.getGridSize()/8,y+1*grid.getGridSize()/8+grid.getGridSize()/2,grid.getGridSize()/8,grid.getGridSize()/8);
        g.fillRect(x+5*grid.getGridSize()/8,y+2*grid.getGridSize()/8+grid.getGridSize()/2,grid.getGridSize()/8,grid.getGridSize()/8);
        g.setColor(Color.BLACK);
    }
}
