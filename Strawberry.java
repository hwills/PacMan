import java.awt.*;
/**
 * A strawberry fruit bonus
 * 
 * @author Hunter Wills 
 * @version 5/11/2013
 */
public class Strawberry extends FruitBonus
{
    /**
     * Constructor for objects of class Strawberry
     */
    public Strawberry(Grid grid)
    {
        super();
        this.grid = grid;
    }
    /**
     * Method draw draws a strawberry
     *
     */
    public void draw(Graphics g){
        g.setColor(Color.RED);
        int[] xpoints = {x+grid.getGridSize()/8,x,x,x+3*grid.getGridSize()/8,x+4*grid.getGridSize()/8,x+5*grid.getGridSize()/8,x+6*grid.getGridSize()/8,x+7*grid.getGridSize()/8,x+8*grid.getGridSize()/8};
        int[] ypoints = {y+grid.getGridSize()/2,y+5*grid.getGridSize()/8,y+9*grid.getGridSize()/8,y+10*grid.getGridSize()/8,y+12*grid.getGridSize()/8,y+10*grid.getGridSize()/8,y+9*grid.getGridSize()/8,y+5*grid.getGridSize()/8,y+grid.getGridSize()/2};
        g.fillPolygon(xpoints,ypoints,9);
        g.setColor(Color.GREEN);
        g.fillRect(x+grid.getGridSize()/8,y+grid.getGridSize()/2,6*grid.getGridSize()/8,grid.getGridSize()/8);
        g.fillRect(x+4*grid.getGridSize()/8,y+3*grid.getGridSize()/8,grid.getGridSize()/8,grid.getGridSize()/8);
        g.setColor(Color.BLACK);
    }
}
