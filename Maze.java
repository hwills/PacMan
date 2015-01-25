import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.image.*;
/**
 * The maze that pacman will be navigating through.
 * 
 * @author Hunter Wills
 * @version 5/11/2013
 */
public class Maze
{
    private BufferedImage mazeImage;//maze's image used by pacman and the ghosts.
    private Graphics2D mazeGraphics;//graphics for maze's image
    private Grid grid;//the grid for drawing purposes
    private int pacmanDiameter;//pacman's diameter
    private int g,w,h;//grid scale
    private int x,y;//x,y pixel position of the maze drawn from top left corner
    /**
     * Constructor for objects of class Maze
     */
    public Maze(Grid grid)
    {
        this.grid = grid;
        g = grid.getGridSize();
        w = grid.getBoardWidth();
        h = grid.getBoardHeight();
        pacmanDiameter = 2*grid.getGridSize()-2;
        mazeImage = new BufferedImage(w*g+1,h*g+1,BufferedImage.TYPE_INT_RGB);
        mazeGraphics = mazeImage.createGraphics();
        drawMaze(mazeGraphics);//maze is drawn with mazeGraphics so pacman and the ghosts can know where they are
        x = 50;
        y = 50;
    }
    /**
     * Method getX gives the x position of the maze. Used often to show where things are on the screen
     *
     * @return the x position of the maze
     */
    public int getX(){
        return x;
    }
    /**
     * Method getY gives the y position of the maze. Used often to show where things are on the screen
     *
     * @return the y position of the maze
     */
    public int getY(){
        return y;
    }
    /**
     * Method touchesWallAbove determines if pacman is touching a wall above him. so we can stop him from moving through walls
     *
     * @param x, y the location of PacMan
     * 
     * @return whether or not PacMan is touching a wall.
     */
    public boolean touchesWallAbove(int x, int y){
        if(this.x<=x && (((x-this.x)-1)+pacmanDiameter+2)<=(w*g+1)){
            if((mazeImage.getRGB(x-this.x,(y-this.y)-1)==(Color.BLUE).getRGB()) || (mazeImage.getRGB((x-this.x)+pacmanDiameter,(y-this.y)-1)==(Color.BLUE).getRGB()) || (mazeImage.getRGB((x-this.x)+(pacmanDiameter/2),(y-this.y)-1)==(Color.BLUE).getRGB())){
                return true;
            }
            else{
                return false;
            }
        }
        return true;
    }
    /**
     * Method touchesWallBelow determines if pacman is touching a wall below him. so we can stop him from moving through walls
     *
     * @param x, y the location of PacMan
     * 
     * @return whether or not PacMan is touching a wall.
     */
    public boolean touchesWallBelow(int x, int y){
        if(this.x<=x && (((x-this.x)-1)+pacmanDiameter+2)<=(w*g+1)){
            if((mazeImage.getRGB(x-this.x,((y-this.y)-1)+pacmanDiameter+2)==(Color.BLUE).getRGB()) || (mazeImage.getRGB((x-this.x)+pacmanDiameter,((y-this.y)-1)+pacmanDiameter+2)==(Color.BLUE).getRGB()) || (mazeImage.getRGB((x-this.x)+(pacmanDiameter/2),((y-this.y)-1)+pacmanDiameter+2)==(Color.BLUE).getRGB()) || (mazeImage.getRGB((x-this.x)+(pacmanDiameter/2),((y-this.y)-1)+pacmanDiameter+3)==(Color.WHITE).getRGB())){
                return true;
            }
            else{
                return false;
            }
        }
        return true;
    }
    /**
     * Method touchesWallLeft determines if pacman is touching a wall to the left of him. so we can stop him from moving through walls
     *
     * @param x, y the location of PacMan
     * 
     * @return whether or not PacMan is touching a wall.
     */
    public boolean touchesWallLeft(int x, int y){
        if(this.x<=x && (((x-this.x)-1)+pacmanDiameter+2)<=(w*g+1)){
            if((mazeImage.getRGB((x-this.x)-1,y-this.y)==(Color.BLUE).getRGB()) || (mazeImage.getRGB((x-this.x)-1,(y-this.y)+pacmanDiameter)==(Color.BLUE).getRGB()) || (mazeImage.getRGB((x-this.x)-1,(y-this.y)+(pacmanDiameter/2))==(Color.BLUE).getRGB())){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    /**
     * Method touchesWallRight determines if pacman is touching a wall to the right of him. so we can stop him from moving through walls
     *
     * @param x, y the location of PacMan
     * 
     * @return whether or not PacMan is touching a wall.
     */
    public boolean touchesWallRight(int x, int y){
        if(this.x<=x && (((x-this.x)-1)+pacmanDiameter+2)<=(w*g+1)){
            if((mazeImage.getRGB(((x-this.x)-1)+pacmanDiameter+2,y-this.y)==(Color.BLUE).getRGB()) || (mazeImage.getRGB(((x-this.x)-1)+pacmanDiameter+2,(y-this.y)+pacmanDiameter)==(Color.BLUE).getRGB()) || (mazeImage.getRGB(((x-this.x)-1)+pacmanDiameter+2,(y-this.y)+(pacmanDiameter/2))==(Color.BLUE).getRGB())){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    /**
     * Method drawMaze draws the maze representation of the walls inside the maze
     *
     *@param mazeGraphics the graphics that the maze will be drawn on
     */
    public void drawMaze(Graphics mazeGraphics){
        if(false){//grid should be galse for playing the game but when drawing is set to true so we can see what is going on with a visual aid
            mazeGraphics.drawImage(grid.getImage(),x,y,null);
        }
        mazeGraphics.setColor(Color.BLUE);
        mazeGraphics.drawRect(x+g/2,y+g/2,(w-1)*g,(h-1)*g);//boarder not pacman side overall
        mazeGraphics.drawRect(x+g,y+g,(w-2)*g,(h-2)*g);//boarder pacman side overall
        mazeGraphics.drawRect(x+3*g,y+3*g,3*g,2*g);//r1
        mazeGraphics.drawRect(x+8*g,y+3*g,4*g,2*g);//r2
        mazeGraphics.drawRect(x+3*g,y+7*g,3*g,g);//r3
        mazeGraphics.drawRect(x+8*g,y+7*g,g,7*g);//r4 high
        mazeGraphics.drawRect(x+9*g,y+10*g,3*g,g);//r4 long
        mazeGraphics.drawRect(x+11*g,y+7*g,7*g,g);//r5 long
        mazeGraphics.drawRect(x+14*g,y+8*g,g,3*g);//r5 high
        mazeGraphics.drawRect(x+17*g,y+3*g,4*g,2*g);//r6
        mazeGraphics.drawRect(x+23*g,y+3*g,3*g,2*g);//r7
        mazeGraphics.drawRect(x+23*g,y+7*g,3*g,g);//r8
        mazeGraphics.drawRect(x+20*g,y+7*g,g,7*g);//r9 high
        mazeGraphics.drawRect(x+17*g,y+10*g,3*g,g);//r9 long
        mazeGraphics.drawRect(x+8*g,y+16*g,g,4*g);//r10
        mazeGraphics.drawRect(x+20*g,y+16*g,g,4*g);//r11
        mazeGraphics.drawRect(x+11*g,y+19*g,7*g,g);//r12 long
        mazeGraphics.drawRect(x+14*g,y+20*g,g,3*g);//r12 high
        mazeGraphics.drawRect(x+5*g,y+22*g,g,4*g);//r13 high
        mazeGraphics.drawRect(x+3*g,y+22*g,2*g,g);//r13 long
        mazeGraphics.drawRect(x+8*g,y+22*g,4*g,g);//r14
        mazeGraphics.drawRect(x+8*g,y+25*g,g,3*g);//r15 high
        mazeGraphics.drawRect(x+3*g,y+28*g,9*g,g);//r15 long
        mazeGraphics.drawRect(x+11*g,y+25*g,7*g,g);//r16 long
        mazeGraphics.drawRect(x+14*g,y+26*g,g,3*g);//r16 high
        mazeGraphics.drawRect(x+17*g,y+22*g,4*g,g);//r17
        mazeGraphics.drawRect(x+23*g,y+22*g,g,4*g);//r18 high
        mazeGraphics.drawRect(x+24*g,y+22*g,2*g,g);//r18 long
        mazeGraphics.drawRect(x+20*g,y+25*g,g,3*g);//r19 high
        mazeGraphics.drawRect(x+17*g,y+28*g,9*g,g);//r19 long
        mazeGraphics.drawRect(x+14*g,y+g,g,4*g);//BD1
        mazeGraphics.drawRect(x+g,y+25*g,2*g,g);//BD2
        mazeGraphics.drawRect(x+26*g,y+25*g,2*g,g);//BD3
        mazeGraphics.drawRect(x+g,y+10*g,5*g,4*g);//SD1 pacman side
        mazeGraphics.drawRect(x+g,y+16*g,5*g,4*g);//SD2 pacman side
        mazeGraphics.drawRect(x+23*g,y+10*g,5*g,4*g);//SD3 pacman side
        mazeGraphics.drawRect(x+23*g,y+16*g,5*g,4*g);//SD4 pacman side
        mazeGraphics.drawRect(x+g/2,y+(10*g)+(g/2),5*g,3*g);//SD1 not pacman side
        mazeGraphics.drawRect(x+g/2,y+(16*g)+(g/2),5*g,3*g);//SD2 not pacman side
        mazeGraphics.drawRect(x+(23*g)+(g/2),y+(10*g)+(g/2),5*g,3*g);//SD3 not pacman side
        mazeGraphics.drawRect(x+(23*g)+(g/2),y+(16*g)+(g/2),5*g,3*g);//SD4 not pacman side
        mazeGraphics.drawRect(x+11*g,y+13*g,7*g,4*g);//cage pacman side
        mazeGraphics.drawRect(x+(11*g)+(g/2),y+(13*g)+(g/2),6*g,3*g);//cage not pacman side
        mazeGraphics.setColor(Color.BLACK);
        mazeGraphics.drawRect(x+9*g,y+10*g,0,g);//r4 remove intersection
        mazeGraphics.drawRect(x+14*g,y+8*g,g,0);//r5 remove intersection
        mazeGraphics.drawRect(x+20*g,y+10*g,0,g);//r9 remove intersection
        mazeGraphics.drawRect(x+14*g,y+20*g,g,0);//r12 remove intersection
        mazeGraphics.drawRect(x+5*g,y+(22*g)+1,0,g-2);//r13 remove intersection
        mazeGraphics.drawRect(x+8*g,y+28*g,g,0);//r15 remove intersection
        mazeGraphics.drawRect(x+14*g,y+26*g,g,0);//r16 remove intersection
        mazeGraphics.drawRect(x+24*g,y+(22*g)+1,0,g-2);//r18 remove intersection
        mazeGraphics.drawRect(x+20*g,y+28*g,g,0);//r19 remove intersection
        mazeGraphics.drawRect(x+14*g,y+g,g,0);//BD1 remove intersection
        mazeGraphics.drawRect(x+g,y+25*g,0,g);//BD2 remove intersection
        mazeGraphics.drawRect(x+28*g,y+25*g,0,g);//BD3 remove intersection
        mazeGraphics.drawRect(x+g,y+(10*g)+(g/2)+1,0,(3*g)-2);//SD1 pacman side remove intersection
        mazeGraphics.drawRect(x+g,y+(16*g)+(g/2)+1,0,(3*g)-2);//SD2 pacman side remove intersection
        mazeGraphics.drawRect(x+28*g,y+(10*g)+(g/2)+1,0,(3*g)-2);//SD3 pacman side remove intersection
        mazeGraphics.drawRect(x+28*g,y+(16*g)+(g/2)+1,0,(3*g)-2);//SD4 pacman side remove intersection
        mazeGraphics.drawRect(x+g/2,y+(10*g)+(g/2)+1,0,(3*g)-2);//SD1 not pacman side remove intersection
        mazeGraphics.drawRect(x+g/2,y+(16*g)+(g/2)+1,0,(3*g)-2);//SD2 not pacman side remove intersection
        mazeGraphics.drawRect(x+(28*g)+(g/2),y+(10*g)+(g/2)+1,0,(3*g)-2);//SD3 not pacman side remove intersection
        mazeGraphics.drawRect(x+(28*g)+(g/2),y+(16*g)+(g/2)+1,0,(3*g)-2);//SD4 not pacman side remove intersection
        mazeGraphics.drawRect(x+(13*g)+(g/2),y+13*g,2*g,0);//cage pacman side remove intersection
        mazeGraphics.drawRect(x+(13*g)+(g/2),y+(13*g)+(g/2),2*g,0);//cage not pacman side remove intersection
        mazeGraphics.drawRect(x+g,y+14*g,0,2*g);//border pacman side remove intersection left
        mazeGraphics.drawRect(x+28*g,y+14*g,0,2*g);//border pacman side remove intersection right
        mazeGraphics.drawRect(x+g/2,y+14*g,0,2*g);//border not pacman side remove intersection left
        mazeGraphics.drawRect(x+(28*g)+(g/2),y+14*g,0,2*g);//border not pacman side remove intersection right
        mazeGraphics.drawRect(x+g,y+(10*g)+1,0,(g/2)-2);//remove SD1 final pieces top
        mazeGraphics.drawRect(x+g,y+(13*g)+(g/2)+1,0,(g/2)-2);//remove SD1 final pieces bottom1
        mazeGraphics.drawRect(x+g/2,y+(13*g)+(g/2)+1,0,(g/2)-2);//remove SD1 final pieces bottom2
        mazeGraphics.drawRect(x+g,y+(16*g)+1,0,(g/2)-2);//remove SD2 final pieces top
        mazeGraphics.drawRect(x+g,y+(19*g)+(g/2)+1,0,(g/2)-2);//remove SD2 final pieces bottom1
        mazeGraphics.drawRect(x+g/2,y+(16*g)+1,0,(g/2)-2);//remove SD2 final pieces bottom2
        mazeGraphics.drawRect(x+28*g,y+(10*g)+1,0,(g/2)-2);//remove SD3 final pieces top
        mazeGraphics.drawRect(x+28*g,y+(13*g)+(g/2)+1,0,(g/2)-2);//remove SD3 final pieces bottom1
        mazeGraphics.drawRect(x+(28*g)+(g/2),y+(13*g)+(g/2)+1,0,(g/2)-2);//remove SD3 final pieces bottom2
        mazeGraphics.drawRect(x+28*g,y+(16*g)+1,0,(g/2)-2);//remove SD4 final pieces top
        mazeGraphics.drawRect(x+28*g,y+(19*g)+(g/2)+1,0,(g/2)-2);//remove SD4 final pieces bottom1
        mazeGraphics.drawRect(x+(28*g)+(g/2),y+(16*g)+1,0,(g/2)-2);//remove SD4 final pieces bottom2
        mazeGraphics.setColor(Color.BLUE);
        mazeGraphics.drawRect(x+g/2,y+14*g,g/2,0);//SD1 draw last line
        mazeGraphics.drawRect(x+g/2,y+16*g,g/2,0);//SD2 draw last line
        mazeGraphics.drawRect(x+28*g,y+14*g,g/2,0);//SD3 draw last line
        mazeGraphics.drawRect(x+28*g,y+16*g,g/2,0);//SD4 draw last line
        mazeGraphics.setColor(Color.WHITE);
        mazeGraphics.fillRect(x+(13*g)+(g/2),y+(13*g)+1,2*g,(g/2)-2);//draws cage door
    }
    /**
     * Method getImage the image of the maze so pacman and ghosts can know where they are.
     *
     * @return the image of the maze
     */
    public BufferedImage getImage(){
        return mazeImage;
    }
}
