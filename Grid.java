import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
/**
 * A grid to make it easier to draw almost everything else in this pacman game.
 * 
 * @author Hunter Wills
 * @version 5/11/2013
 */
public class Grid
{
    private int g;//temporaty to create grid scale
    private int w;//the width of the grid
    private int h;//the height of the grid
    private BufferedImage gridImage;//an image for the drawn grid
    private Graphics2D gridGraphics;//the graphics relating to the grid's image
    /**
     * Constructor for objects of class Grid
     */
    public Grid()
    {
        g = 2*8;//grid scale writen as product involving 8 to emphisize that it must be a multiple of 8 (normal pellets divide grid size by 4 and is divided by 2 again in game screen for a total of 8)
        w = 29;//this is the proper width for a pacman board
        h = 32;//this is the proper height for a pacman board
        gridImage = new BufferedImage(w*g+1,h*g+1,BufferedImage.TYPE_INT_RGB);//must add one to fit grid inside this image
        gridGraphics = gridImage.createGraphics();
        drawGrid();
    }
    /**
     * Method drawGrid draws the grid to visualize when we need to place things in certain spots within it. It is a visual aid.
     *
     */
    private void drawGrid(){
        gridGraphics.setColor(Color.ORANGE);//the gird is drawn in orange for no particular reason. I just like orange :)
        for(int i = 0; i <= w; i++){
            gridGraphics.drawRect(i*g,0,0,h*g);
        }
        for(int j = 0; j <= h; j++){
            gridGraphics.drawRect(0,j*g,w*g,0);
        }
    }
    /**
     * Method getGridSize gives the size of a grid square. Very important for drawing other objects.
     *
     * @return the size of a grid square
     */
    public int getGridSize(){
        return g;
    }
    /**
     * Method getBoardWidth the width of the board
     *
     * @return the width of the board.
     */
    public int getBoardWidth(){
        return w;
    }
    /**
     * Method getBoardHeight the height of the board.
     *
     * @return the height of the board.
     */
    public int getBoardHeight(){
        return h;
    }
    /**
     * Method getImage gives the image of the grid so it can be drawn later in the maze so we can see it for use when drawing other objects.
     *
     * @return the grid's image
     */
    public BufferedImage getImage(){
        return gridImage;
    }
}
