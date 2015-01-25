import java.awt.*;
/**
 * This abstract class is used to outline all types of fruit bonuses that pacman can eat.
 * 
 * @author Hunter Wills
 * @version 5/11/2013
 */
public abstract class FruitBonus
{
    protected int x, y;//x,y pixel position of fruit bonus drawn from top left corner
    protected boolean taken;//whether or not pacman has taken the bonus
    protected Grid grid;//a grid used for aid in drawing
    /**
     * Constructor for objects of class FruitBonus
     */
    public FruitBonus()
    {
        x=-100;//somewhere off screen
        y=-100;//somewhere off screen
        taken = true;//starts off taken
    }
    /**
     * Method draw draws the fruit required for all extending this class
     * 
     * @param g is the graphics component that the bonus wil be drawn on
     *
     */
    public abstract void draw(Graphics g);
    /**
     * Method isTaken tells if the fruit has already been eaten by pacman. This method will be used to let the game system know whether the user should get points for the fruit and if the fruit shoud be drawn.
     *
     * @return whether or not the fruit has been taken
     */
    public boolean isTaken(){
        return taken;
    }
    /**
     * Method setTaken allows the game system to set the fruit as taken. It will be used to set the fruit as taken when pacman eats it, and set the fruit as not taken when the timer says to.
     *
     * @param t A parameter of whether the fruit is taken or not
     */
    public void setTaken(boolean t){
        taken = t;
    }
    /**
     * Method getX gives the x position of the fruit. Used so we can know when pacman eats it.
     *
     * @return The x position of the fruit
     */
    public int getX(){
        return x;
    }
    /**
     * Method getY gives the y position of the fruit. Used so we can know when pacman eats it.
     *
     * @return The y position of the fruit
     */
    public int getY(){
        return y;
    }
    /**
     * Method setX sets the x position of the fruit. Used to pace the fruit where we want it
     *
     * @param x the new x position of the fruit
     */
    public void setX(int x){
        this.x = x;
    }
    /**
     * Method setY sets the y position of the fruit. Used to pace the fruit where we want it
     *
     * @param y the new y position of the fruit
     */
    public void setY(int y){
        this.y = y;
    }
}
