import java.awt.*;
import java.awt.image.*;
/**
 * The abstract class for various types of pellets.
 * 
 * @author Hunter Wills
 * @version 5/11/2013
 */
public abstract class Pellet
{
    protected int x, y; //the x,y pixel position of the pellet drawn from the top left corner
    protected boolean eaten; //whether or not the pellet has been eaten by pacman
    protected Grid grid; //the grid for aid in drawing the pellets
    protected int diameter; //the diameter of a pellet
    /**
     * Constructor for objects of class Pellets
     */
    public Pellet()
    {
        eaten = false;//the pellet begins the game having not been eaten by pacman
    }
    /**
     * Method isEaten tells whether or not the pellet has been eaten. Used for knowing whether or not to draw the pellet and if the score should be increased for pacman being at the pellets position.
     *
     * @return whether or not the pellet has been eaten
     */
    public boolean isEaten(){
        return eaten;
    }
    /**
     * Method setEaten allows the pellet to be set as being eaten or not. Used to set the pellet as eaten when pacman reaches it and to reset the pellet as not eaten when the board is reset
     *
     * @param b a value for if the pellet is eaten or not
     */
    public void setEaten(boolean b){
        eaten = b;
    }
    /**
     * Method getX gives the x position of the pellet
     *
     * @return the x position of the pellet
     */
    public int getX(){
        return x;
    }
    /**
     * Method getY gives the y position of the pellet
     *
     * @return the y position of the pellet
     */
    public int getY(){
        return y;
    }
    /**
     * Method setX sets the x position of the pellet. used to initialize the positon of all the various pellets
     *
     * @param x the new x position of the pellet
     */
    public void setX(int x){
        this.x = x;
    }
    /**
     * Method setY sets the y position of the pellet. used to initialize the positon of all the various pellets
     *
     * @param y the new y position of the pellet
     */
    public void setY(int y){
        this.y = y;
    }
    /**
     * Method getDiameter gives the diameter of the pellet for use when finding if pacman is at it's positon
     *
     * @return the diameter of the pellet
     */
    public int getDiameter(){
        return diameter;
    }
    /**
     * Method draw draws the pellet required for all who inherit this class
     *
     *@param g the graphics the pellet will be drawn on
     */
    public abstract void draw(Graphics g);
}
