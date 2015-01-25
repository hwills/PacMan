import java.awt.*;
import java.awt.image.*;
/**
 * This is a pacman who can run around the screen collecting pellets, eating ghosts, and playing the game.
 * 
 * @author Hunter Wills
 * @version 5/11/2013
 */
public class PacMan
{
    private int speed;//pacman's speed
    private int diameter;//pacman's diameter
    private Grid grid;//a grid for drawing purposes
    private int x, y;//the x, and y pixel position of pacman 
    private Maze mazeIn;//the maze pacman is in for drawing purposes
    private boolean mouthOpen;//whether or not pacman's mout is open
    /**
     * Constructor for objects of class PacMan
     */
    public PacMan(Grid grid, Graphics g)
    {
        mazeIn = new Maze(grid);
        this.grid = grid;
        diameter = 2*grid.getGridSize()-2;//pacman's diemeter based on grid size
        speed = grid.getGridSize()/2;//pacman's speed based on grids he covers
        x = mazeIn.getX()+(13*grid.getGridSize())+(grid.getGridSize()/2)+1;//pacman's initial position in the maze
        y = mazeIn.getY()+(23*grid.getGridSize())+1;//pacman's initial position in the maze
        drawOpen(x, y, 210, 300, g);//pacman begins with his mouth drawn open
        mouthOpen = true;//pacman's mout begins open
    }
    /**
     * Method moveLeft moves PacMan to the left if he is not touching a wall. used to move pacman left
     *
     *@param g the graphics pacman will be drawn on
     */
    public void moveLeft(Graphics g){
        if(speed > 0){//pacman only moves if his speed is not zero used so pacman will still be drawn in the same spot if he has no speed
            int xOld = x;//saves pacmans position before moving so we can contiue to use it
            x = x - speed;//pacman's new x positon is a reduction of his old since he is moving left
            if(mouthOpen){//if his mouth is open he is switched to closed
                drawClosed(x, y, 190, 340, g);
                mouthOpen = false;
            }
            else{//if his mouth is closed he is switched to open
                drawOpen(x, y, 210, 300, g);
                mouthOpen = true;
            }
            if(((x < (mazeIn.getX()+(grid.getGridSize()/2)+1))) && (y == (mazeIn.getY()+(14*grid.getGridSize())+1))){//pacman is drawn specially if he is moved at an edge
                g.fillRect(x+((grid.getBoardWidth()-1)*grid.getGridSize()),y,2*diameter,diameter+1);
                if(!mouthOpen){
                    drawClosed(x+((grid.getBoardWidth()-1)*grid.getGridSize()), y, 190, 340, g);
                }
                else{
                    drawOpen(x+((grid.getBoardWidth()-1)*grid.getGridSize()), y, 210, 300, g);
                }
            }
            if((xOld > 1+mazeIn.getX()+((grid.getBoardWidth())*grid.getGridSize())-(grid.getGridSize()/2)-(2*grid.getGridSize())) && (y == (mazeIn.getY()+(14*grid.getGridSize())+1))){//pacman is drawn specially if he is moved at an edge
                g.fillRect(x-((grid.getBoardWidth()-1)*grid.getGridSize()),y,2*diameter,diameter+1);
                if(!mouthOpen){
                    drawClosed(x-((grid.getBoardWidth()-1)*grid.getGridSize()), y, 190, 340, g);
                }
                else{
                    drawOpen(x-((grid.getBoardWidth()-1)*grid.getGridSize()), y, 210, 300, g);
                }
            }
            if(x == (mazeIn.getX()-(diameter+1)+(grid.getGridSize()/2))){//pacman is given the position on the other side of the map if he has moved from one side to the other
                x = 1+mazeIn.getX()+((grid.getBoardWidth())*grid.getGridSize())-(grid.getGridSize()/2)-(2*grid.getGridSize());
            }
        }
        else{
            if(mouthOpen){//if his mouth is open it stays open when he doesn't move
                drawOpen(x, y, 210, 300, g);
            }
            else{//if his mouth is closed it stays closed when he doesn't move
                drawClosed(x, y, 190, 340, g);
            }
        }
    }
    /**
     * Method moveRight moves PacMan to the right if he is not touching a wall.used to move pacman right
     *
     *@param g the graphics pacman will be drawn on
     */
    public void moveRight(Graphics g){
        if(speed>0){//pacman only moves if his speed is not zero used so pacman will still be drawn in the same spot if he has no speed
            int xOld = x;//saves pacmans position before moving so we can contiue to use it
            x = x + speed;//pacman's new x positon is an addition to his old since he is moving right
            if(mouthOpen){//if his mouth is open he is switched to closed
                drawClosed(x, y, 10, 340, g);
                mouthOpen = false;
            }
            else{//if his mouth is closed he is switched to open
                drawOpen(x, y, 30, 300, g);
                mouthOpen = true;
            }
            if(((xOld < (mazeIn.getX()+(grid.getGridSize()/2)+1))) && (y == (mazeIn.getY()+(14*grid.getGridSize())+1))){//pacman is drawn specially if he is moved at an edge
                g.fillRect(x+((grid.getBoardWidth()-1)*grid.getGridSize())-speed,y,2*diameter,diameter+1);
                if(!mouthOpen){
                    drawClosed(x+((grid.getBoardWidth()-1)*grid.getGridSize()), y, 10, 340, g);
                }
                else{
                    drawOpen(x+((grid.getBoardWidth()-1)*grid.getGridSize()), y, 30, 300, g);
                }
            }
            if((x > 1+mazeIn.getX()+((grid.getBoardWidth())*grid.getGridSize())-(grid.getGridSize()/2)-(2*grid.getGridSize())) && (y == (mazeIn.getY()+(14*grid.getGridSize())+1))){//pacman is drawn specially if he is moved at an edge
                g.fillRect(x-((grid.getBoardWidth()-1)*grid.getGridSize()),y,2*diameter,diameter+1);
                if(!mouthOpen){
                    drawClosed(x-((grid.getBoardWidth()-1)*grid.getGridSize()), y, 10, 340, g);
                }
                else{
                    drawOpen(x-((grid.getBoardWidth()-1)*grid.getGridSize()), y, 30, 300, g);
                }
            }
            if(x == (1+mazeIn.getX()+((grid.getBoardWidth())*grid.getGridSize())-(grid.getGridSize()/2))){//pacman is given the position on the other side of the map if he has moved from one side to the other
                x = mazeIn.getX()-(diameter+1)+(grid.getGridSize()/2)+(2*grid.getGridSize());
                g.fillRect(mazeIn.getX()+grid.getGridSize()/2,y,1,2*grid.getGridSize());
            }
        }
        else{
            if(mouthOpen){//if his mouth is open it stays open when he doesn't move
                drawOpen(x, y, 30, 300, g);
            }
            else{//if his mouth is closed it stays closed when he doesn't move
                drawClosed(x, y, 10, 340, g);
            }
        }
    }
    /**
     * Method moveUp moves PacMan up if he is not touching a wall.used to move pacman up
     *
     *@param g the graphics pacman will be drawn on
     */
    public void moveUp(Graphics g){
        if(speed>0){//pacman only moves if his speed is not zero used so pacman will still be drawn in the same spot if he has no speed
            y = y - speed;//pacman's new y positon is a deduction to his old since he is moving up
            if(mouthOpen){//if his mouth is open he is switched to closed
                drawClosed(x, y, 100, 340, g);
                mouthOpen = false;
            }
            else{//if his mouth is closed he is switched to open
                drawOpen(x, y, 120, 300, g);
                mouthOpen = true;
            }
        }
        else{
            if(mouthOpen){//if his mouth is open it stays open when he doesn't move
                drawOpen(x, y, 120, 300, g);
            }
            else{//if his mouth is closed it stays closed when he doesn't move
                drawClosed(x, y, 100, 340, g);
            }
        }
    }
    /**
     * Method moveDown moves PacMan down if he is not touching a wall.used to move pacman down
     *
     *@param g the graphics pacman will be drawn on
     */
    public void moveDown(Graphics g){
        if(speed>0){//pacman only moves if his speed is not zero used so pacman will still be drawn in the same spot if he has no speed
            y = y + speed;//pacman's new y positon is an addition to his old since he is moving down
            if(mouthOpen){//if his mouth is open he is switched to closed
                drawClosed(x, y, 280, 340, g);
                mouthOpen = false;
            }
            else{//if his mouth is closed he is switched to open
                drawOpen(x, y, 300, 300, g);
                mouthOpen = true;
            }
        }
        else{
            if(mouthOpen){//if his mouth is open it stays open when he doesn't move
                drawOpen(x, y, 300, 300, g);
            }
            else{//if his mouth is closed it stays closed when he doesn't move
                drawClosed(x, y, 280, 340, g);
            }
        }
    }
    /**
     * Method getX gives the x position of PacMan used to know where pacman is
     *
     * @return the x position of PacMan
     */
    public int getX(){
        return x;
    }
    /**
     * Method getY gives the y position of PacMan used to know where pacman is
     *
     * @return the y position of PacMan
     */
    public int getY(){
        return y;
    }
    /**
     * Method getDiameter gives pacman's diameter so we can know what is on the right of him since he is drawn from his left
     *
     * @return pacman's diameter
     */
    public int getDiameter(){
        return diameter;
    }
    /**
     * Method getOpen tells us if pacman's mouth is open so we can toggle between open and closed
     *
     * @return whether or not the mouth is open
     */
    public boolean getOpen(){
        return mouthOpen;
    }
    /**
     * Method getSpeed tells us pacman's speed so we can know how fast he is moving especially useful to store his speed when we are going to set it to zero so we can change it back after
     *
     * @return pacman's speed
     */
    public int getSpeed(){
        return speed;
    }
    /**
     * Method setSpeed sets pacman's speed so we can set him to zero when he is not moving
     *
     * @param s ne speed for pacman
     */
    public void setSpeed(int s){
        speed = s;
    }
    /**
     * Method setX sets pacman's x position so we can move him from other methods
     *
     * @param x pacman's new x position
     */
    public void setX(int x){
        this.x = x;
    }
    /**
     * Method setY sets pacman's y position so we can move him from other methods
     *
     * @param y pacman's new y position
     */
    public void setY(int y){
        this.y = y;
    }
    /**
     * Method setOpen sets pacman's mouth to be open or not
     *
     * @param b whether or not pacman's mouth will be open
     */
    public void setOpen(boolean b){
        mouthOpen = b;
    }
    /**
     * Method drawOpen draws's PacMan with is mouth open.
     *
     * @param x the x position pacman will be drawn at
     * @param y the y position pacman will be drawn at
     * @param angleStart the initial angle pacman is drawn with needs to be variable so pacman can eat himself when he dies
     * @param angleChange the size of the angle pacman is drawn with needs to be variable so pacman can eat himself when he dies
     * @param g the graphics pacman is drawn with
     */
    public void drawOpen(int x, int y, int angleStart, int angleChange, Graphics g){
        g.setColor(Color.YELLOW);
        g.fillArc(x,y,diameter+1,diameter+1,angleStart,angleChange);
        g.setColor(Color.BLACK);
    }
    /**
     * Method drawClosed draws PacMan with his mouth closed.
     *
     * @param x the x position pacman will be drawn at
     * @param y the y position pacman will be drawn at
     * @param angleStart the initial angle pacman is drawn with needs to be variable so pacman can eat himself when he dies
     * @param angleChange the size of the angle pacman is drawn with needs to be variable so pacman can eat himself when he dies
     * @param g the graphics pacman is drawn with
     */
    private void drawClosed(int x, int y, int angleStart, int angleChange, Graphics g){
        g.setColor(Color.YELLOW);
        g.fillArc(x,y,diameter+1,diameter+1,angleStart,angleChange);
        g.setColor(Color.BLACK);
    }
}
