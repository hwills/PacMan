import java.awt.*;
import java.awt.image.*;
/**
 * A cherry fruit bonus.
 * 
 * @author Hunter Wills
 * @version 5/11/2013
 */
public class Cherry extends FruitBonus
{
    /**
     * Constructor for objects of class Cherry
     */
    public Cherry(Grid grid)
    {
        super();
        this.grid = grid;
    }
    /**
     * Method draw draws a cherry
     *
     */
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x,y+grid.getGridSize(),grid.getGridSize()/2,grid.getGridSize()/2);
        g.fillOval(x+grid.getGridSize()/2+grid.getGridSize()/8,y+grid.getGridSize()+grid.getGridSize()/8,grid.getGridSize()/2,grid.getGridSize()/2);
        g.setColor(Color.GREEN);
        g.drawArc(x+grid.getGridSize()/8-grid.getGridSize()/4,y+grid.getGridSize()+grid.getGridSize()/8-grid.getGridSize(),grid.getGridSize(),grid.getGridSize(),270,90);
        g.drawRect(x-1+grid.getGridSize(),y+5*grid.getGridSize()/8,0,grid.getGridSize()/2+grid.getGridSize()/8);
        g.setColor(Color.BLACK);
    }
}
