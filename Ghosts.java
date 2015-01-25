import java.awt.*;
import java.awt.image.*;
import java.util.Random;
/**
 * The ghosts that are trying to eat pacman.
 * 
 * @author Hunter Wills 
 * @version 5/11/2013
 */
public class Ghosts
{
    public static final int UP = 1;//value depicting the upward motion of ghosts
    public static final int DOWN = -1;//value depicting the downward motion of ghosts opposite of upward
    public static final int LEFT = 2;//value depicting the leftward motion of ghosts
    public static final int RIGHT = -2;//value depicting the rightward motion of ghosts opposite of leftward
    private int speed;//the speed of the ghosts
    private int x, y;//the x and y pixel positions of the ghosts
    private Maze mazeIn;//the maze the ghost is in
    private Color color;//the color of the ghost
    private boolean edible;//whether or not the ghost is edible
    private boolean eaten;//whether or not the ghost has been eaten
    private Grid grid;//the grid for aid in drawing purposes
    private int diameter;//the diameter of the ghosts
    private boolean sideChange;//whether or not the number of walls the ghost is touching has changed checked every time the ghost moes
    private int lastDirection;//the last directon the ghost was moving in
    /**
     * Constructor for objects of class Ghosts
     */
    public Ghosts(Grid grid)
    {
        mazeIn = new Maze(grid);
        this.grid = grid;
        color = Color.BLACK;
        x = -100;//somewhere offscreen
        y = -100;//somewhere offscreen
        speed = grid.getGridSize()/2;
        eaten = false;//starts not eaten
        edible = false;//starts not edible
        diameter = 2*grid.getGridSize()-2;
        sideChange = false;
        lastDirection = 0;
    }
    /**
     * Method move moves the ghost in a purely random direction
     *
     *@param g the graphics that the ghost is drawn in
     */
    public void movePsychotically(Graphics g){
        Random random = new Random();
        int r = random.nextInt(24);
        if(r == 0 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 0 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 0 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 0 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 1 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 1 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 1 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 1 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 2 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 2 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 2 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 2 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 3 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 3 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 3 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 3 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 4 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 4 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 4 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 4 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 5 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 5 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 5 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 5 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 6 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 6 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 6 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 6 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 7 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 7 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 7 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 7 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 8 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 8 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 8 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 8 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 9 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 9 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 9 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 9 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 10 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 10 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 10 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 10 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 11 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 11 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 11 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 11 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 12 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 12 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 12 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 12 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 13 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 13 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 13 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 13 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 14 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 14 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 14 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 14 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 15 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 15 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 15 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 15 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 16 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 16 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 16 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 16 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 17 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 17 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 17 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 17 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 18 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 18 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 18 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 18 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 19 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 19 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 19 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 19 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 20 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 20 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 20 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 20 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 21 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 21 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 21 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 21 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 22 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 22 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 22 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
        else if(r == 22 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 23 && !mazeIn.touchesWallBelow(x,y) && lastDirection != UP){
            moveDown(g);
        }
        else if(r == 23 && !mazeIn.touchesWallRight(x,y) && lastDirection != LEFT){
            moveRight(g);
        }
        else if(r == 23 && !mazeIn.touchesWallAbove(x,y) && lastDirection != DOWN){
            moveUp(g);
        }
        else if(r == 23 && !mazeIn.touchesWallLeft(x,y) && lastDirection != RIGHT){
            moveLeft(g);
        }
    }
    /**
     * Method moveRandomSmoothly has pacman go in the same direction util he hits an intersection then he selects a purely random direction to move in
     *
     * @param g the graphics that the ghost is drawn in
     */
    public void moveRandomSmoothly(Graphics g){
        if(!sideChange && lastDirection == UP){
            moveUp(g);
        }
        else if(!sideChange && lastDirection == LEFT){
            moveLeft(g);
        }
        else if(!sideChange && lastDirection == RIGHT){
            moveRight(g);
        }
        else if(!sideChange && lastDirection == DOWN){
            moveDown(g);
        }
        else if(sideChange && lastDirection == UP){
            movePsychotically(g);
        }
        else if(sideChange && lastDirection == LEFT){
            movePsychotically(g);
        }
        else if(sideChange && lastDirection == RIGHT){
            movePsychotically(g);
        }
        else if(sideChange && lastDirection == DOWN){
            movePsychotically(g);
        }
    }
    /**
     * Method moveLeft moves the ghost left
     *
     * @param g the graphics the gost will be drawn in
     */
    public void moveLeft(Graphics g){
        boolean left1 = mazeIn.touchesWallLeft(x,y);//checks all the walls the ghost touches before it moves
        boolean right1 = mazeIn.touchesWallRight(x,y);
        boolean up1 = mazeIn.touchesWallAbove(x,y);
        boolean down1 = mazeIn.touchesWallBelow(x,y);
        int xOld = x;
        x = x-speed;
        if(!edible && !eaten){//draws alive edible or eaten
            drawAliveLeft(x,y,g);
        }
        else if(edible && !eaten){
            drawEdible(x,y,g);
        }
        else{
            drawEatenLeft(x,y,g);
        }
        if(((x < (mazeIn.getX()+(grid.getGridSize()/2)+1))) && (y == (mazeIn.getY()+(14*grid.getGridSize())+1))){//draws the ghost specially if it is moving from one side to the other
            g.fillRect(x+((grid.getBoardWidth()-1)*grid.getGridSize()),y,2*diameter,diameter+1);
            if(!edible && !eaten){
                drawAliveLeft(x+((grid.getBoardWidth()-1)*grid.getGridSize()),y,g);
            }
            else if(edible && !eaten){
                drawEdible(x+((grid.getBoardWidth()-1)*grid.getGridSize()),y,g);
            }
            else{
                drawEatenLeft(x+((grid.getBoardWidth()-1)*grid.getGridSize()),y,g);
            }
        }
        if((xOld > 1+mazeIn.getX()+((grid.getBoardWidth())*grid.getGridSize())-(grid.getGridSize()/2)-(2*grid.getGridSize())) && (y == (mazeIn.getY()+(14*grid.getGridSize())+1))){//draws the ghost specially if it is moving from one side to the other
            g.fillRect(x-((grid.getBoardWidth()-1)*grid.getGridSize()),y,2*diameter,diameter+1);
            if(!edible && !eaten){
                drawAliveLeft(x-((grid.getBoardWidth()-1)*grid.getGridSize()),y,g);
            }
            else if(edible && !eaten){
                drawEdible(x-((grid.getBoardWidth()-1)*grid.getGridSize()),y,g);
            }
            else{
                drawEatenLeft(x-((grid.getBoardWidth()-1)*grid.getGridSize()),y,g);
            }
        }
        if(x == (mazeIn.getX()-(diameter+1)+(grid.getGridSize()/2))){//gives the ghost a new position if it has moved from one side to the other
            x = 1+mazeIn.getX()+((grid.getBoardWidth())*grid.getGridSize())-(grid.getGridSize()/2)-(2*grid.getGridSize());
        }
        lastDirection = LEFT;
        boolean left2 = mazeIn.touchesWallLeft(x,y);//checks all the walls the ghost touches after it moves
        boolean right2 = mazeIn.touchesWallRight(x,y);
        boolean up2 = mazeIn.touchesWallAbove(x,y);
        boolean down2 = mazeIn.touchesWallBelow(x,y);
        if(left1 == left2 && right1 == right2 && up1 == up2 && down1 == down2){//checks if there has been any changes to the walls the ghost has touching
            sideChange = false;
        }
        else{
            sideChange = true;
        }
    }
    /**
     * Method moveRight moves the ghost right
     *
     * @param g the graphics the gost will be drawn in
     */
    public void moveRight(Graphics g){
        boolean left1 = mazeIn.touchesWallLeft(x,y);//checks all the walls the ghost touches before it moves
        boolean right1 = mazeIn.touchesWallRight(x,y);
        boolean up1 = mazeIn.touchesWallAbove(x,y);
        boolean down1 = mazeIn.touchesWallBelow(x,y);
        int xOld = x;
        x = x+speed;
        if(!edible && !eaten){//draws alive edible or eaten
            drawAliveRight(x,y,g);
        }
        else if(edible && !eaten){
            drawEdible(x,y,g);
        }
        else{
            drawEatenRight(x,y,g);
        }
        if(((xOld < (mazeIn.getX()+(grid.getGridSize()/2)+1))) && (y == (mazeIn.getY()+(14*grid.getGridSize())+1))){//draws the ghost specially if it is moving from one side to the other
            g.fillRect(x+((grid.getBoardWidth()-1)*grid.getGridSize())-speed,y,2*diameter,diameter+1);
            if(!edible && !eaten){
                drawAliveRight(x+((grid.getBoardWidth()-1)*grid.getGridSize()),y,g);
            }
            else if(edible && !eaten){
                drawEdible(x+((grid.getBoardWidth()-1)*grid.getGridSize()),y,g);
            }
            else{
                drawEatenRight(x+((grid.getBoardWidth()-1)*grid.getGridSize()),y,g);
            }
        }
        if((x > 1+mazeIn.getX()+((grid.getBoardWidth())*grid.getGridSize())-(grid.getGridSize()/2)-(2*grid.getGridSize())) && (y == (mazeIn.getY()+(14*grid.getGridSize())+1))){//draws the ghost specially if it is moving from one side to the other
            g.fillRect(x-((grid.getBoardWidth()-1)*grid.getGridSize()),y,2*diameter,diameter+1);
            if(!edible && !eaten){
                drawAliveRight(x-((grid.getBoardWidth()-1)*grid.getGridSize()),y,g);
            }
            else if(edible && !eaten){
                drawEdible(x-((grid.getBoardWidth()-1)*grid.getGridSize()),y,g);
            }
            else{
                drawEatenRight(x-((grid.getBoardWidth()-1)*grid.getGridSize()),y,g);
            }
        }
        if(x == (1+mazeIn.getX()+((grid.getBoardWidth())*grid.getGridSize())-(grid.getGridSize()/2))){//gives the ghost a new position if it has moved from one side to the other
            x = mazeIn.getX()-(diameter+1)+(grid.getGridSize()/2)+(2*grid.getGridSize());
            g.fillRect(mazeIn.getX()+grid.getGridSize()/2,y,1,2*grid.getGridSize());
        }
        lastDirection = RIGHT;
        boolean left2 = mazeIn.touchesWallLeft(x,y);//checks all the walls the ghost touches after it moves
        boolean right2 = mazeIn.touchesWallRight(x,y);
        boolean up2 = mazeIn.touchesWallAbove(x,y);
        boolean down2 = mazeIn.touchesWallBelow(x,y);
        if(left1 == left2 && right1 == right2 && up1 == up2 && down1 == down2){//checks if there has been any changes to the walls the ghost has touching
            sideChange = false;
        }
        else{
            sideChange = true;
        }
    }
    /**
     * Method moveDown moves the ghost down
     *
     * @param g the graphics the gost will be drawn in
     */
    public void moveDown(Graphics g){
        boolean left1 = mazeIn.touchesWallLeft(x,y);//checks all the walls the ghost touches before it moves
        boolean right1 = mazeIn.touchesWallRight(x,y);
        boolean up1 = mazeIn.touchesWallAbove(x,y);
        boolean down1 = mazeIn.touchesWallBelow(x,y);
        y = y+speed;
        if(!edible && !eaten){//draws alive edible or eaten
            drawAliveDown(g);
        }
        else if(edible && !eaten){
            drawEdible(x,y,g);
        }
        else{
            drawEatenDown(g);
        }
        lastDirection = DOWN;
        boolean left2 = mazeIn.touchesWallLeft(x,y);//checks all the walls the ghost touches after it moves
        boolean right2 = mazeIn.touchesWallRight(x,y);
        boolean up2 = mazeIn.touchesWallAbove(x,y);
        boolean down2 = mazeIn.touchesWallBelow(x,y);
        if(left1 == left2 && right1 == right2 && up1 == up2 && down1 == down2){//checks if there has been any changes to the walls the ghost has touching
            sideChange = false;
        }
        else{
            sideChange = true;
        }
    }
    /**
     * Method moveUp moves the ghost up
     *
     * @param g the graphics the gost will be drawn in
     */
    public void moveUp(Graphics g){
        boolean left1 = mazeIn.touchesWallLeft(x,y);//checks all the walls the ghost touches before it moves
        boolean right1 = mazeIn.touchesWallRight(x,y);
        boolean up1 = mazeIn.touchesWallAbove(x,y);
        boolean down1 = mazeIn.touchesWallBelow(x,y);
        y = y-speed;
        if(!edible && !eaten){//draws alive edible or eaten
            drawAliveUp(g);
        }
        else if(edible && !eaten){
            drawEdible(x,y,g);
        }
        else{
            drawEatenUp(g);
        }
        lastDirection = UP;
        boolean left2 = mazeIn.touchesWallLeft(x,y);//checks all the walls the ghost touches after it moves
        boolean right2 = mazeIn.touchesWallRight(x,y);
        boolean up2 = mazeIn.touchesWallAbove(x,y);
        boolean down2 = mazeIn.touchesWallBelow(x,y);
        if(left1 == left2 && right1 == right2 && up1 == up2 && down1 == down2){//checks if there has been any changes to the walls the ghost has touching
            sideChange = false;
        }
        else{
            sideChange = true;
        }
    }
    /**
     * Method drawEdible draws the ghosts in a representation that PacMan can eat
     *
     *@param x the x position of the ghost to be drawn at
     *@param y the y position of the ghost to be drawn at
     *@param g the graphics the ghost will be drawn on
     */
    public void drawEdible(int x, int y, Graphics g){
        g.setColor(Color.BLUE);
        g.fillArc(x,y,2*grid.getGridSize()-2,2*grid.getGridSize()-2,0,180);
        int[] xpoints = {x,x,x+grid.getGridSize()/4,x+2*grid.getGridSize()/4,x+3*grid.getGridSize()/4,x+4*grid.getGridSize()/4,x+5*grid.getGridSize()/4,x+6*grid.getGridSize()/4,x+7*grid.getGridSize()/4,x+8*grid.getGridSize()/4-2,x+8*grid.getGridSize()/4-2,x};
        int[] ypoints = {y+grid.getGridSize()-1,y+2*grid.getGridSize()-2,y+2*grid.getGridSize()-2-grid.getGridSize()/4,y+2*grid.getGridSize()-2,y+2*grid.getGridSize()-2-grid.getGridSize()/4,y+2*grid.getGridSize()-2,y+2*grid.getGridSize()-2-grid.getGridSize()/4,y+2*grid.getGridSize()-2,y+2*grid.getGridSize()-2-grid.getGridSize()/4,y+2*grid.getGridSize()-2,y+grid.getGridSize()-1,y+grid.getGridSize()-1};
        g.fillPolygon(xpoints,ypoints,12);
        g.setColor(Color.WHITE);
        g.fillOval(x+4*grid.getGridSize()/8,y+4*grid.getGridSize()/8,grid.getGridSize()/4,grid.getGridSize()/4);
        g.fillOval(x+10*grid.getGridSize()/8,y+4*grid.getGridSize()/8,grid.getGridSize()/4,grid.getGridSize()/4);
        int[] xpoints1 = {x+2*grid.getGridSize()/8,x+4*grid.getGridSize()/8,x+6*grid.getGridSize()/8,x+8*grid.getGridSize()/8,x+10*grid.getGridSize()/8,x+12*grid.getGridSize()/8,x+14*grid.getGridSize()/8};
        int[] ypoints1 = {y+10*grid.getGridSize()/8,y+9*grid.getGridSize()/8,y+10*grid.getGridSize()/8,y+9*grid.getGridSize()/8,y+10*grid.getGridSize()/8,y+9*grid.getGridSize()/8,y+10*grid.getGridSize()/8};
        g.drawPolygon(xpoints1,ypoints1,7);
        g.setColor(Color.BLUE);
        g.drawRect(x+2*grid.getGridSize()/8+1,y+10*grid.getGridSize()/8,4*grid.getGridSize()/8-3,0);
        g.drawRect(x+6*grid.getGridSize()/8+1,y+10*grid.getGridSize()/8,4*grid.getGridSize()/8-3,0);
        g.drawRect(x+10*grid.getGridSize()/8+1,y+10*grid.getGridSize()/8,4*grid.getGridSize()/8-3,0);
        g.drawRect(x+14*grid.getGridSize()/8,y+10*grid.getGridSize()/8,0,0);
        g.setColor(Color.BLACK);
    }
    /**
     * Method drawEatenDown draws the ghosts in a representation that shows they are eaten and is moving down
     *
     *@param g the graphics the ghost will be drawn on
     */
    public void drawEatenDown(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x+2*grid.getGridSize()/8,y+2*grid.getGridSize()/8,5*grid.getGridSize()/8,6*grid.getGridSize()/8);
        g.fillOval(x+8*grid.getGridSize()/8,y+2*grid.getGridSize()/8,5*grid.getGridSize()/8,6*grid.getGridSize()/8);
        g.setColor(Color.BLUE);
        g.fillOval(x+3*grid.getGridSize()/8,y+4*grid.getGridSize()/8,3*grid.getGridSize()/8,4*grid.getGridSize()/8);
        g.fillOval(x+9*grid.getGridSize()/8,y+4*grid.getGridSize()/8,3*grid.getGridSize()/8,4*grid.getGridSize()/8);
        g.setColor(Color.BLACK);
    }
    /**
     * Method drawEatenUp draws the ghosts in a representation that shows they are eaten and is moving up
     *
     *@param g the graphics the ghost will be drawn on
     */
    public void drawEatenUp(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x+2*grid.getGridSize()/8,y+2*grid.getGridSize()/8,5*grid.getGridSize()/8,6*grid.getGridSize()/8);
        g.fillOval(x+8*grid.getGridSize()/8,y+2*grid.getGridSize()/8,5*grid.getGridSize()/8,6*grid.getGridSize()/8);
        g.setColor(Color.BLUE);
        g.fillOval(x+3*grid.getGridSize()/8,y+2*grid.getGridSize()/8,3*grid.getGridSize()/8,4*grid.getGridSize()/8);
        g.fillOval(x+9*grid.getGridSize()/8,y+2*grid.getGridSize()/8,3*grid.getGridSize()/8,4*grid.getGridSize()/8);
        g.setColor(Color.BLACK);
    }
    /**
     * Method drawEatenLeft draws the ghosts in a representation that PacMan it has been eaten and is moving left
     *
     *@param x the x position of the ghost to be drawn at
     *@param y the y position of the ghost to be drawn at
     *@param g the graphics the ghost will be drawn on
     */
    public void drawEatenLeft(int x, int y, Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x+2*grid.getGridSize()/8,y+2*grid.getGridSize()/8,5*grid.getGridSize()/8,6*grid.getGridSize()/8);
        g.fillOval(x+8*grid.getGridSize()/8,y+2*grid.getGridSize()/8,5*grid.getGridSize()/8,6*grid.getGridSize()/8);
        g.setColor(Color.BLUE);
        g.fillOval(x+2*grid.getGridSize()/8,y+3*grid.getGridSize()/8,3*grid.getGridSize()/8,4*grid.getGridSize()/8);
        g.fillOval(x+8*grid.getGridSize()/8,y+3*grid.getGridSize()/8,3*grid.getGridSize()/8,4*grid.getGridSize()/8);
        g.setColor(Color.BLACK);
    }
    /**
     * Method drawEatenRight draws the ghosts in a representation that PacMan it has been eaten and is moving right
     *
     *@param x the x position of the ghost to be drawn at
     *@param y the y position of the ghost to be drawn at
     *@param g the graphics the ghost will be drawn on
     */
    public void drawEatenRight(int x, int y, Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x+2*grid.getGridSize()/8,y+2*grid.getGridSize()/8,5*grid.getGridSize()/8,6*grid.getGridSize()/8);
        g.fillOval(x+8*grid.getGridSize()/8,y+2*grid.getGridSize()/8,5*grid.getGridSize()/8,6*grid.getGridSize()/8);
        g.setColor(Color.BLUE);
        g.fillOval(x+4*grid.getGridSize()/8,y+3*grid.getGridSize()/8,3*grid.getGridSize()/8,4*grid.getGridSize()/8);
        g.fillOval(x+10*grid.getGridSize()/8,y+3*grid.getGridSize()/8,3*grid.getGridSize()/8,4*grid.getGridSize()/8);
        g.setColor(Color.BLACK);
    }
    /**
     * Method drawAliveDown draws the ghosts in a representation that can eat PacMan and is moving down
     *
     *@param g the graphics that the ghost will be drawn on
     */
    public void drawAliveDown(Graphics g){
        g.setColor(color);
        g.fillArc(x,y,2*grid.getGridSize()-2,2*grid.getGridSize()-2,0,180);
        int[] xpoints = {x,x,x+grid.getGridSize()/4,x+2*grid.getGridSize()/4,x+3*grid.getGridSize()/4,x+4*grid.getGridSize()/4,x+5*grid.getGridSize()/4,x+6*grid.getGridSize()/4,x+7*grid.getGridSize()/4,x+8*grid.getGridSize()/4-2,x+8*grid.getGridSize()/4-2,x};
        int[] ypoints = {y+grid.getGridSize()-1,y+2*grid.getGridSize()-2,y+2*grid.getGridSize()-2-grid.getGridSize()/4,y+2*grid.getGridSize()-2,y+2*grid.getGridSize()-2-grid.getGridSize()/4,y+2*grid.getGridSize()-2,y+2*grid.getGridSize()-2-grid.getGridSize()/4,y+2*grid.getGridSize()-2,y+2*grid.getGridSize()-2-grid.getGridSize()/4,y+2*grid.getGridSize()-2,y+grid.getGridSize()-1,y+grid.getGridSize()-1};
        g.fillPolygon(xpoints,ypoints,12);
        g.setColor(Color.WHITE);
        g.fillOval(x+2*grid.getGridSize()/8,y+2*grid.getGridSize()/8,5*grid.getGridSize()/8,6*grid.getGridSize()/8);
        g.fillOval(x+8*grid.getGridSize()/8,y+2*grid.getGridSize()/8,5*grid.getGridSize()/8,6*grid.getGridSize()/8);
        g.setColor(Color.BLUE);
        g.fillOval(x+3*grid.getGridSize()/8,y+4*grid.getGridSize()/8,3*grid.getGridSize()/8,4*grid.getGridSize()/8);
        g.fillOval(x+9*grid.getGridSize()/8,y+4*grid.getGridSize()/8,3*grid.getGridSize()/8,4*grid.getGridSize()/8);
        g.setColor(Color.BLACK);
    }
    /**
     * Method drawAliveUp draws the ghosts in a representation that can eat PacMan and is moving up
     *
     *@param g the graphics that the ghost will be drawn on
     */
    public void drawAliveUp(Graphics g){
        g.setColor(color);
        g.fillArc(x,y,2*grid.getGridSize()-2,2*grid.getGridSize()-2,0,180);
        int[] xpoints = {x,x,x+grid.getGridSize()/4,x+2*grid.getGridSize()/4,x+3*grid.getGridSize()/4,x+4*grid.getGridSize()/4,x+5*grid.getGridSize()/4,x+6*grid.getGridSize()/4,x+7*grid.getGridSize()/4,x+8*grid.getGridSize()/4-2,x+8*grid.getGridSize()/4-2,x};
        int[] ypoints = {y+grid.getGridSize()-1,y+2*grid.getGridSize()-2,y+2*grid.getGridSize()-2-grid.getGridSize()/4,y+2*grid.getGridSize()-2,y+2*grid.getGridSize()-2-grid.getGridSize()/4,y+2*grid.getGridSize()-2,y+2*grid.getGridSize()-2-grid.getGridSize()/4,y+2*grid.getGridSize()-2,y+2*grid.getGridSize()-2-grid.getGridSize()/4,y+2*grid.getGridSize()-2,y+grid.getGridSize()-1,y+grid.getGridSize()-1};
        g.fillPolygon(xpoints,ypoints,12);
        g.setColor(Color.WHITE);
        g.fillOval(x+2*grid.getGridSize()/8,y+2*grid.getGridSize()/8,5*grid.getGridSize()/8,6*grid.getGridSize()/8);
        g.fillOval(x+8*grid.getGridSize()/8,y+2*grid.getGridSize()/8,5*grid.getGridSize()/8,6*grid.getGridSize()/8);
        g.setColor(Color.BLUE);
        g.fillOval(x+3*grid.getGridSize()/8,y+2*grid.getGridSize()/8,3*grid.getGridSize()/8,4*grid.getGridSize()/8);
        g.fillOval(x+9*grid.getGridSize()/8,y+2*grid.getGridSize()/8,3*grid.getGridSize()/8,4*grid.getGridSize()/8);
        g.setColor(Color.BLACK);
    }
    /**
     * Method drawAliveLeft draws the ghosts in a representation that can eat PacMan and is moving left
     *
     *@param x the x position of the ghost to be drawn at
     *@param y the y position of the ghost to be drawn at
     *@param g the graphics that the ghost will be drawn on
     */
    public void drawAliveLeft(int x, int y, Graphics g){
        g.setColor(color);
        g.fillArc(x,y,2*grid.getGridSize()-2,2*grid.getGridSize()-2,0,180);
        int[] xpoints = {x,x,x+grid.getGridSize()/4,x+2*grid.getGridSize()/4,x+3*grid.getGridSize()/4,x+4*grid.getGridSize()/4,x+5*grid.getGridSize()/4,x+6*grid.getGridSize()/4,x+7*grid.getGridSize()/4,x+8*grid.getGridSize()/4-2,x+8*grid.getGridSize()/4-2,x};
        int[] ypoints = {y+grid.getGridSize()-1,y+2*grid.getGridSize()-2,y+2*grid.getGridSize()-2-grid.getGridSize()/4,y+2*grid.getGridSize()-2,y+2*grid.getGridSize()-2-grid.getGridSize()/4,y+2*grid.getGridSize()-2,y+2*grid.getGridSize()-2-grid.getGridSize()/4,y+2*grid.getGridSize()-2,y+2*grid.getGridSize()-2-grid.getGridSize()/4,y+2*grid.getGridSize()-2,y+grid.getGridSize()-1,y+grid.getGridSize()-1};
        g.fillPolygon(xpoints,ypoints,12);
        g.setColor(Color.WHITE);
        g.fillOval(x+2*grid.getGridSize()/8,y+2*grid.getGridSize()/8,5*grid.getGridSize()/8,6*grid.getGridSize()/8);
        g.fillOval(x+8*grid.getGridSize()/8,y+2*grid.getGridSize()/8,5*grid.getGridSize()/8,6*grid.getGridSize()/8);
        g.setColor(Color.BLUE);
        g.fillOval(x+2*grid.getGridSize()/8,y+3*grid.getGridSize()/8,3*grid.getGridSize()/8,4*grid.getGridSize()/8);
        g.fillOval(x+8*grid.getGridSize()/8,y+3*grid.getGridSize()/8,3*grid.getGridSize()/8,4*grid.getGridSize()/8);
        g.setColor(Color.BLACK);
    }
    /**
     * Method drawAliveRight draws the ghosts in a representation that can eat PacMan and is moving right
     *
     *@param x the x position of the ghost to be drawn at
     *@param y the y position of the ghost to be drawn at
     *@param g the graphics that the ghost will be drawn on
     */
    public void drawAliveRight(int x, int y, Graphics g){
        g.setColor(color);
        g.fillArc(x,y,2*grid.getGridSize()-2,2*grid.getGridSize()-2,0,180);
        int[] xpoints = {x,x,x+grid.getGridSize()/4,x+2*grid.getGridSize()/4,x+3*grid.getGridSize()/4,x+4*grid.getGridSize()/4,x+5*grid.getGridSize()/4,x+6*grid.getGridSize()/4,x+7*grid.getGridSize()/4,x+8*grid.getGridSize()/4-2,x+8*grid.getGridSize()/4-2,x};
        int[] ypoints = {y+grid.getGridSize()-1,y+2*grid.getGridSize()-2,y+2*grid.getGridSize()-2-grid.getGridSize()/4,y+2*grid.getGridSize()-2,y+2*grid.getGridSize()-2-grid.getGridSize()/4,y+2*grid.getGridSize()-2,y+2*grid.getGridSize()-2-grid.getGridSize()/4,y+2*grid.getGridSize()-2,y+2*grid.getGridSize()-2-grid.getGridSize()/4,y+2*grid.getGridSize()-2,y+grid.getGridSize()-1,y+grid.getGridSize()-1};
        g.fillPolygon(xpoints,ypoints,12);
        g.setColor(Color.WHITE);
        g.fillOval(x+2*grid.getGridSize()/8,y+2*grid.getGridSize()/8,5*grid.getGridSize()/8,6*grid.getGridSize()/8);
        g.fillOval(x+8*grid.getGridSize()/8,y+2*grid.getGridSize()/8,5*grid.getGridSize()/8,6*grid.getGridSize()/8);
        g.setColor(Color.BLUE);
        g.fillOval(x+4*grid.getGridSize()/8,y+3*grid.getGridSize()/8,3*grid.getGridSize()/8,4*grid.getGridSize()/8);
        g.fillOval(x+10*grid.getGridSize()/8,y+3*grid.getGridSize()/8,3*grid.getGridSize()/8,4*grid.getGridSize()/8);
        g.setColor(Color.BLACK);
    }
    /**
     * Method isEdible tells whether or not the ghosts are edible so we can know if pacman can eat it or not
     *
     * @return whether or not the ghost are edible
     */
    public boolean isEdible(){
        return edible;
    }
    /**
     * Method setEdible sets the ghost as being edible or not so we can change it when a ghost pellet is eaten
     *
     * @param e whether or not the ghost is now edible
     */
    public void setEdible(boolean e){
        edible = e;
    }
    /**
     * Method isEaten tells whether or not the ghost is eaten so we can know if pacman can walk through it
     *
     * @return whether or not the ghost is edible
     */
    public boolean isEaten(){
        return eaten;
    }
    /**
     * Method setEaten sets the ghost as having being eaten so if pacman eats them they will become eaten
     *
     * @param e whether or not the ghost is now eaten
     */
    public void setEaten(boolean e){
        edible = false;
        eaten = e;
    }
    /**
     * Method getX gives the x position of the ghost so we can know where it is
     *
     * @return the x position of the ghost
     */
    public int getX(){
        return x;
    }
    /**
     * Method getY gives the y position of the ghost so we can know where it is
     *
     * @return the y position of the ghost
     */
    public int getY(){
        return y;
    }
    /**
     * Method setX sets the x position of the ghost so we can draw them at an initial spot in our maze
     *
     * @param x the new x position of the ghost
     */
    public void setX(int x){
        this.x = x;
    }
    /**
     * Method setY sets the y position of the ghost so we can draw them at an initial spot in our maze
     *
     * @param y the new y position of the ghost
     */
    public void setY(int y){
        this.y = y;
    }
    /**
     * Method setColor allows us to se the color of the ghost so we can draw them differently in our maze
     *
     * @param c the new color of the ghost
     */
    public void setColor(Color c){
        color = c;
    }
    /**
     * Method touchesGhostLeft sees if a ghost touches another on the left
     *
     * @param x the x position of the other ghost we are checking
     * @param y the y position of the other ghost we are checking
     * @return whether or not the ghosts touch each other
     */
    public boolean touchesGhostLeft(int x,int y){
        if(x-2-diameter==this.x && y == this.y){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Method touchesGhostRight sees if a ghost touches another on the right
     *
     * @param x the x position of the other ghost we are checking
     * @param y the y position of the other ghost we are checking
     * @return whether or not the ghosts touch each other
     */
    public boolean touchesGhostRight(int x,int y){
        if(x+diameter+2==this.x && y == this.y){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Method touchesGhostUp sees if a ghost touches another above
     *
     * @param x the x position of the other ghost we are checking
     * @param y the y position of the other ghost we are checking
     * @return whether or not the ghosts touch each other
     */
    public boolean touchesGhostUp(int x,int y){
        if(x==this.x && y-2-diameter==this.y){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Method touchesGhostDown sees if a ghost touches another below
     *
     * @param x the x position of the other ghost we are checking
     * @param y the y position of the other ghost we are checking
     * @return whether or not the ghosts touch each other
     */
    public boolean touchesGhostDown(int x,int y){
        if(x==this.x && y+diameter+2==this.y){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Method pacmanTouchesAGhost sees if pacman touches the ghost
     *
     * @param x the x position of pacman
     * @param y the y position of pacman
     * @return whether or not pacman touches the ghost
     */
    public boolean pacmanTouchesAGhost(int x, int y){
        for(int i = this.x-(grid.getGridSize()/2)-2;i<=this.x+(grid.getGridSize()/2)+2;i++){
            for(int j = this.y-(grid.getGridSize()/2)-2;j<=this.y+(grid.getGridSize()/2)+2;j++){
                if(x == i && y == j){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Method ghostsTouchEachOther sees if ghosts touch each other at all
     *
     * @param x the x position of the other ghost
     * @param y the y position of the other ghost
     * @return whether or not the ghosts touch each other
     */
    public boolean ghostsTouchEachOther(int x, int y){
        for(int i = this.x-diameter-2;i<=this.x+diameter+2;i++){
            for(int j = this.y-diameter-2;j<=this.y+diameter+2;j++){
                if(x == i && y == j){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Method getSpeed tells the speed of the ghost
     *
     * @return the speed of the ghost
     */
    public int getSpeed(){
        return speed;
    }
    /**
     * Method getDiameter tells the diameter of the ghost
     *
     * @return the diameter of the ghost
     */
    public int getDiameter(){
        return diameter;
    }
    /**
     * Method reverseDirection reverses the direction of the ghost
     *
     */
    public void reverseDirection(){
        lastDirection = (-1)*lastDirection;
    }
    /**
     * Method redraw redraws the ghost
     *
     * @param g the graphics the ghost is drawn on
     */
    public void redraw(Graphics g){
        if(edible){
            drawEdible(x,y,g);
        }
        else if(eaten && lastDirection==UP){
            drawEatenUp(g);
        }
        else if(eaten && lastDirection==DOWN){
            drawEatenDown(g);
        }
        else if(eaten && lastDirection==RIGHT){
            drawEatenRight(x,y,g);
        }
        else if(eaten && lastDirection==LEFT){
            drawEatenLeft(x,y,g);
        }
        else if(!eaten && !edible && lastDirection==UP){
            drawAliveUp(g);
        }
        else if(!eaten && !edible && lastDirection==DOWN){
            drawAliveDown(g);
        }
        else if(!eaten && !edible && lastDirection==LEFT){
            drawAliveLeft(x,y,g);
        }
        else if(!eaten && !edible && lastDirection==RIGHT){
            drawAliveRight(x,y,g);
        }
    }
}
