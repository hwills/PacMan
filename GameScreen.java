import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.image.*;
/**
 * The panel that the game is being drawn in. Handels the main coding for the pacman game.
 * 
 * @author Hunter Wills 
 * @version 5/11/2013
 */
public class GameScreen extends JPanel implements ActionListener
{
    public static final int UP_PRESSED = 1;//value to represent up being pressed
    public static final int DOWN_PRESSED = 2;//value to represent down being pressed
    public static final int LEFT_PRESSED = 3;//value to represent left being pressed
    public static final int RIGHT_PRESSED = 4;//value to represent right being pressed
    private Ghosts[] ghosts;
    private NormalPellet[] normalPellets;
    private GhostPellet[] ghostPellets;
    private PacMan pacman;
    private FruitBonus strawberry;
    private FruitBonus cherry;
    private FruitBonus orange;
    private Maze maze;
    private int score;
    private int lives;
    private Grid grid;
    private int pacmanDiameter;
    private BufferedImage image;
    private Graphics2D graphics;
    private boolean gameStart;//whether or not the game has started
    private int lastPressed;//the last key pressed
    private Timer t;//a timer for the game
    private int currentPressed;//the current direction going
    private int timeCounter;//counter for the interval the timer will increase by
    private int time;//the time for fruit appearing
    private int ghostTime;//the time for the ghosts beginning motion
    private boolean gameOver;//whether or not the game is over
    private int edibleTime;//the time a ghost has been edible
    private int ghostMod;//the score modifier for when ghost's score when eaten
    private int gameTime;//the total game time
    private boolean lifeDecrease;//if lives have decreased
    private int lifeDecreaseTime;//the counter for the life decrease animation
    private int scoreCount;//counter to increase life when a certain score is reached
    private int[] eatenTime;//amount of time each ghost has been eaten for
    /**
     * Constructor for objects of class GameScreen
     */
    public GameScreen()
    {
        super();
        grid = new Grid();
        maze = new Maze(grid);
        setPreferredSize(new Dimension(600,600));
        setLayout(null);
        ghostPellets = new GhostPellet[4];
        normalPellets = new NormalPellet[240];
        ghosts = new Ghosts[4];
        for(int k = 0;k<ghosts.length;k++){//initiallizes all ghosts
            ghosts[k] = new Ghosts(grid);
            if(k == 0){
               ghosts[k].setColor(Color.RED);
               ghosts[k].setX(maze.getX()+27*grid.getGridSize()/2+1);
               ghosts[k].setY(maze.getY()+22*grid.getGridSize()/2+1);
            }
            if(k == 1){
               ghosts[k].setColor(Color.PINK);
               ghosts[k].setX(maze.getX()+23*grid.getGridSize()/2+1);
               ghosts[k].setY(maze.getY()+28*grid.getGridSize()/2+1);
            }
            if(k == 2){
               ghosts[k].setColor(Color.ORANGE);
               ghosts[k].setX(maze.getX()+27*grid.getGridSize()/2+1);
               ghosts[k].setY(maze.getY()+28*grid.getGridSize()/2+1);
            }
            if(k == 3){
               ghosts[k].setColor(Color.CYAN);
               ghosts[k].setX(maze.getX()+31*grid.getGridSize()/2+1);
               ghosts[k].setY(maze.getY()+28*grid.getGridSize()/2+1);
            }
        }
        image = new BufferedImage(600,600,BufferedImage.TYPE_INT_RGB);
        graphics = image.createGraphics();
        pacman = new PacMan(grid, graphics);
        strawberry = new Strawberry(grid);
        cherry = new Cherry(grid);
        orange = new Orange(grid);
        score = 0;
        lives = 3;
        timeCounter = 75;
        t = new Timer(timeCounter,this);
        time = 0;
        ghostTime = 0;
        for(int i = 0; i<normalPellets.length; i++){//initiallizes the normal pellets
            normalPellets[i] = new NormalPellet(grid);
            if(i < 12){
                normalPellets[i].setX(maze.getX()+(i+2)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(2)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i < 24){
                normalPellets[i].setX(maze.getX()+(i+4)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(2)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 24){
                normalPellets[i].setX(maze.getX()+(2)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(3)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 25){
                normalPellets[i].setX(maze.getX()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(3)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 26){
                normalPellets[i].setX(maze.getX()+(13)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(3)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 27){
                normalPellets[i].setX(maze.getX()+(16)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(3)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 28){
                normalPellets[i].setX(maze.getX()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(3)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 29){
                normalPellets[i].setX(maze.getX()+(27)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(3)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 30){
                normalPellets[i].setX(maze.getX()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(4)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 31){
                normalPellets[i].setX(maze.getX()+(13)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(4)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 32){
                normalPellets[i].setX(maze.getX()+(16)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(4)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 33){
                normalPellets[i].setX(maze.getX()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(4)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 34){
                normalPellets[i].setX(maze.getX()+(2)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(5)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 35){
                normalPellets[i].setX(maze.getX()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(5)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 36){
                normalPellets[i].setX(maze.getX()+(13)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(5)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 37){
                normalPellets[i].setX(maze.getX()+(16)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(5)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 38){
                normalPellets[i].setX(maze.getX()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(5)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 39){
                normalPellets[i].setX(maze.getX()+(27)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(5)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(39 < i && i < 66){
                normalPellets[i].setX(maze.getX()+(i-38)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(6)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 66){
                normalPellets[i].setX(maze.getX()+(2)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 67){
                normalPellets[i].setX(maze.getX()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 68){
                normalPellets[i].setX(maze.getX()+(10)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 69){
                normalPellets[i].setX(maze.getX()+(19)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 70){
                normalPellets[i].setX(maze.getX()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 71){
                normalPellets[i].setX(maze.getX()+(27)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 72){
                normalPellets[i].setX(maze.getX()+(2)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(8)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 73){
                normalPellets[i].setX(maze.getX()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(8)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 74){
                normalPellets[i].setX(maze.getX()+(10)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(8)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 75){
                normalPellets[i].setX(maze.getX()+(19)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(8)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 76){
                normalPellets[i].setX(maze.getX()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(8)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 77){
                normalPellets[i].setX(maze.getX()+(27)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(8)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(77 < i && i < 84){
                normalPellets[i].setX(maze.getX()+(i-76)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(9)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(83 < i && i < 88){
                normalPellets[i].setX(maze.getX()+(i-74)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(9)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(87 < i && i < 92){
                normalPellets[i].setX(maze.getX()+(i-72)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(9)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(91 < i && i < 98){
                normalPellets[i].setX(maze.getX()+(i-70)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(9)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 98){
                normalPellets[i].setX(maze.getX()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(10)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 99){
                normalPellets[i].setX(maze.getX()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(10)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 100){
                normalPellets[i].setX(maze.getX()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(11)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 101){
                normalPellets[i].setX(maze.getX()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(11)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 102){
                normalPellets[i].setX(maze.getX()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(12)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 103){
                normalPellets[i].setX(maze.getX()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(12)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 104){
                normalPellets[i].setX(maze.getX()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(13)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 105){
                normalPellets[i].setX(maze.getX()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(13)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 106){
                normalPellets[i].setX(maze.getX()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(14)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 107){
                normalPellets[i].setX(maze.getX()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(14)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 108){
                normalPellets[i].setX(maze.getX()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(15)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 109){
                normalPellets[i].setX(maze.getX()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(15)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 110){
                normalPellets[i].setX(maze.getX()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(16)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 111){
                normalPellets[i].setX(maze.getX()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(16)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 112){
                normalPellets[i].setX(maze.getX()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(17)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 113){
                normalPellets[i].setX(maze.getX()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(17)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 114){
                normalPellets[i].setX(maze.getX()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(18)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 115){
                normalPellets[i].setX(maze.getX()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(18)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 116){
                normalPellets[i].setX(maze.getX()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(19)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 117){
                normalPellets[i].setX(maze.getX()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(19)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 118){
                normalPellets[i].setX(maze.getX()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(20)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 119){
                normalPellets[i].setX(maze.getX()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(20)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(119 < i && i < 132){
                normalPellets[i].setX(maze.getX()+(i-118)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(21)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(131 < i && i < 144){
                normalPellets[i].setX(maze.getX()+(i-116)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(21)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 144){
                normalPellets[i].setX(maze.getX()+(2)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 145){
                normalPellets[i].setX(maze.getX()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 146){
                normalPellets[i].setX(maze.getX()+(13)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 147){
                normalPellets[i].setX(maze.getX()+(16)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 148){
                normalPellets[i].setX(maze.getX()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 149){
                normalPellets[i].setX(maze.getX()+(27)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 150){
                normalPellets[i].setX(maze.getX()+(2)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(23)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 151){
                normalPellets[i].setX(maze.getX()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(23)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 152){
                normalPellets[i].setX(maze.getX()+(13)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(23)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 153){
                normalPellets[i].setX(maze.getX()+(16)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(23)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 154){
                normalPellets[i].setX(maze.getX()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(23)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 155){
                normalPellets[i].setX(maze.getX()+(27)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(23)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(155 < i && i < 158){
                normalPellets[i].setX(maze.getX()+(i-153)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(24)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(157 < i && i < 165){
                normalPellets[i].setX(maze.getX()+(i-151)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(24)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(164 < i && i < 172){
                normalPellets[i].setX(maze.getX()+(i-149)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(24)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(171 < i && i < 174){
                normalPellets[i].setX(maze.getX()+(i-147)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(24)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 174){
                normalPellets[i].setX(maze.getX()+(4)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(25)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 175){
                normalPellets[i].setX(maze.getX()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(25)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 176){
                normalPellets[i].setX(maze.getX()+(10)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(25)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 177){
                normalPellets[i].setX(maze.getX()+(19)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(25)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 178){
                normalPellets[i].setX(maze.getX()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(25)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 179){
                normalPellets[i].setX(maze.getX()+(25)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(25)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 180){
                normalPellets[i].setX(maze.getX()+(4)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(26)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 181){
                normalPellets[i].setX(maze.getX()+(7)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(26)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 182){
                normalPellets[i].setX(maze.getX()+(10)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(26)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 183){
                normalPellets[i].setX(maze.getX()+(19)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(26)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 184){
                normalPellets[i].setX(maze.getX()+(22)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(26)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 185){
                normalPellets[i].setX(maze.getX()+(25)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(26)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(185 < i && i < 192){
                normalPellets[i].setX(maze.getX()+(i-184)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(27)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(191 < i && i < 196){
                normalPellets[i].setX(maze.getX()+(i-182)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(27)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(195 < i && i < 200){
                normalPellets[i].setX(maze.getX()+(i-180)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(27)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(199 < i && i < 206){
                normalPellets[i].setX(maze.getX()+(i-178)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(27)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 206){
                normalPellets[i].setX(maze.getX()+(2)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(28)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 207){
                normalPellets[i].setX(maze.getX()+(13)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(28)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 208){
                normalPellets[i].setX(maze.getX()+(16)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(28)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 209){
                normalPellets[i].setX(maze.getX()+(27)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(28)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 210){
                normalPellets[i].setX(maze.getX()+(2)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(29)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 211){
                normalPellets[i].setX(maze.getX()+(13)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(29)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 212){
                normalPellets[i].setX(maze.getX()+(16)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(29)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(i == 213){
                normalPellets[i].setX(maze.getX()+(27)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(29)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
            else if(213 < i && i < 240){
                normalPellets[i].setX(maze.getX()+(i-212)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
                normalPellets[i].setY(maze.getY()+(30)*grid.getGridSize()-normalPellets[i].getDiameter()/2);
            }
        }
        for(int j = 0; j < ghostPellets.length; j++){//initializes the ghost pellets
            ghostPellets[j] = new GhostPellet(grid);
            if(j == 0){
                ghostPellets[j].setX(maze.getX()+(2)*grid.getGridSize()-ghostPellets[j].getDiameter()/2);
                ghostPellets[j].setY(maze.getY()+(4)*grid.getGridSize()-ghostPellets[j].getDiameter()/2);
            }
            else if(j == 1){
                ghostPellets[j].setX(maze.getX()+(27)*grid.getGridSize()-ghostPellets[j].getDiameter()/2);
                ghostPellets[j].setY(maze.getY()+(4)*grid.getGridSize()-ghostPellets[j].getDiameter()/2);
            }
            else if(j == 2){
                ghostPellets[j].setX(maze.getX()+(2)*grid.getGridSize()-ghostPellets[j].getDiameter()/2);
                ghostPellets[j].setY(maze.getY()+(24)*grid.getGridSize()-ghostPellets[j].getDiameter()/2);
            }
            else if(j == 3){
                ghostPellets[j].setX(maze.getX()+(27)*grid.getGridSize()-ghostPellets[j].getDiameter()/2);
                ghostPellets[j].setY(maze.getY()+(24)*grid.getGridSize()-ghostPellets[j].getDiameter()/2);
            }
        }
        pacmanDiameter = 2*grid.getGridSize()-2;
        graphics.fillRect(0,0,600,600);
        maze.drawMaze(graphics);
        gameStart = true;
        lastPressed = LEFT_PRESSED;
        currentPressed = LEFT_PRESSED;
        gameOver = false;
        edibleTime = 200*timeCounter;
        ghostMod = 1;
        gameTime = 0;
        lifeDecrease = false;
        lifeDecreaseTime = 0;
        scoreCount = 1;
        eatenTime = new int[4];
        for(int r=0;r<eatenTime.length;r++){
            eatenTime[r] = 200*timeCounter;
        }
    }
    /**
     * Method paintComponent paints the Game Screen
     *
     */
    public void paintComponent(Graphics g){
        if(!gameOver){//only works if the game is not over
            graphics.setColor(Color.BLACK);
            graphics.fillRect(1+maze.getX()+((grid.getBoardWidth())*grid.getGridSize())-(grid.getGridSize()/2),(maze.getY()+(14*grid.getGridSize())+1),pacmanDiameter+1,pacmanDiameter+1);
            graphics.fillRect(maze.getX()-(pacmanDiameter+1)+(grid.getGridSize()/2),(maze.getY()+(14*grid.getGridSize())+1),pacmanDiameter+1,pacmanDiameter+1);
            for(int i = 0; i<normalPellets.length; i++){
                if(!normalPellets[i].isEaten()){
                    normalPellets[i].draw(graphics);
                }
            }
            for(int j = 0; j<ghostPellets.length; j++){
                if(!ghostPellets[j].isEaten()){
                    ghostPellets[j].draw(graphics);
                }
            }
            if(gameStart){
                pacman.drawOpen(pacman.getX(),pacman.getY(),210,300,graphics);
                gameStart = false;
                for(int k = 0;k<ghosts.length;k++){
                    ghosts[k].drawAliveUp(graphics);
                }
            }
            graphics.setColor(Color.BLACK);
            graphics.fillRect(maze.getX()+grid.getGridSize()/2,maze.getY()-11,400,12);
            graphics.setColor(Color.WHITE);
            graphics.drawString("Score: " + score,maze.getX()+grid.getGridSize()/2,maze.getY());
            graphics.drawString("Lives: " + lives,maze.getX()+24*grid.getGridSize()/2,maze.getY());
            graphics.setColor(Color.BLACK);
            cherry.draw(graphics);
            orange.draw(graphics);
            strawberry.draw(graphics);
        }
        g.drawImage(image,0,0,null);
    }
    /**
     * Method movePacManRight sets the last pressed button to right
     *
     */
    public void movePacManRight(){
        lastPressed = RIGHT_PRESSED;
    }
    /**
     * Method movePacManLeft sets the last pressed button to left
     *
     */
    public void movePacManLeft(){
        lastPressed = LEFT_PRESSED;
    }
    /**
     * Method movePacManUp sets the last pressed button to up
     *
     */
    public void movePacManUp(){
        lastPressed = UP_PRESSED;
    }
    /**
     * Method movePacManDown sets the last pressed button to down
     *
     */
    public void movePacManDown(){
        lastPressed = DOWN_PRESSED;
    }
    /**
     * Method actionPerformed what occurs when the timer increases
     *
     */
    public void actionPerformed(ActionEvent e){
        gameTime = gameTime + timeCounter;
        if(!gameOver && gameTime>12*timeCounter && !lifeDecrease){
        time = time + timeCounter;
        edibleTime = edibleTime + timeCounter;
        ghostTime = ghostTime + timeCounter;
        for(int r=0;r<eatenTime.length;r++){
            eatenTime[r] = eatenTime[r] + timeCounter;
        }
        graphics.fillRect(pacman.getX(),pacman.getY(),pacman.getDiameter()+1,pacman.getDiameter()+1); //black box deleting the old spot pacman occupied
        for(int l=0;l<ghosts.length;l++){//black box deleting the old spot each ghost occupied
            graphics.fillRect(ghosts[l].getX(),ghosts[l].getY(),pacman.getDiameter()+1,pacman.getDiameter()+1);
        }
        if(ghostTime <= (3*grid.getGridSize()/ghosts[0].getSpeed())*timeCounter){//first few moves of each ghost hard coded
            ghosts[0].moveLeft(graphics);
            graphics.setColor(Color.WHITE);
            graphics.fillRect(maze.getX()+(13*grid.getGridSize())+(grid.getGridSize()/2),maze.getY()+(13*grid.getGridSize())+1,2*grid.getGridSize(),(grid.getGridSize()/2)-2);
            graphics.setColor(Color.BLACK);
            ghosts[2].moveUp(graphics);
            if(!maze.touchesWallAbove(ghosts[3].getX(),ghosts[3].getY())){
                ghosts[3].moveUp(graphics);
            }
            else{
                ghosts[3].moveDown(graphics);
            }
            if(!maze.touchesWallAbove(ghosts[1].getX(),ghosts[1].getY())){
                ghosts[1].moveUp(graphics);
            }
            else{
                ghosts[1].moveDown(graphics);
            }
            repaint();
        }
        if((ghostTime > (3*grid.getGridSize()/ghosts[0].getSpeed())*timeCounter) && ghostTime <= (5*grid.getGridSize()/ghosts[0].getSpeed()*timeCounter)){//next few moves of each ghost hard coded
            if(ghosts[0].getX() != maze.getX()+9*grid.getGridSize()+1){
                ghosts[0].moveLeft(graphics);
            }
            else{
                ghosts[0].moveDown(graphics);
            }
            graphics.setColor(Color.WHITE);
            graphics.fillRect(maze.getX()+(13*grid.getGridSize())+(grid.getGridSize()/2),maze.getY()+(13*grid.getGridSize())+1,2*grid.getGridSize(),(grid.getGridSize()/2)-2);
            graphics.setColor(Color.BLACK);
            if(ghosts[2].getX() != maze.getX()+12*grid.getGridSize()+1){
                ghosts[2].moveLeft(graphics);
            }
            else{
                ghosts[2].moveUp(graphics);
            }
            ghosts[3].moveLeft(graphics);
            if(!maze.touchesWallAbove(ghosts[1].getX(),ghosts[1].getY())){
                ghosts[1].moveUp(graphics);
            }
            else{
                ghosts[1].moveDown(graphics);
            }
            repaint();
        }
        if((ghostTime > (5*grid.getGridSize()/ghosts[0].getSpeed())*timeCounter) && ghostTime <= (8*grid.getGridSize()/ghosts[0].getSpeed()*timeCounter)){//next few moves of each ghost hard coded
            ghosts[0].moveDown(graphics);
            graphics.setColor(Color.WHITE);
            graphics.fillRect(maze.getX()+(13*grid.getGridSize())+(grid.getGridSize()/2),maze.getY()+(13*grid.getGridSize())+1,2*grid.getGridSize(),(grid.getGridSize()/2)-2);
            graphics.setColor(Color.BLACK);
            if(ghosts[2].getY() > maze.getY()+8*grid.getGridSize()+1){
                ghosts[2].moveUp(graphics);
            }
            else{
                ghosts[2].moveLeft(graphics);
            }
            ghosts[3].moveUp(graphics);
            if(!maze.touchesWallAbove(ghosts[1].getX(),ghosts[1].getY())){
                ghosts[1].moveUp(graphics);
            }
            else{
                ghosts[1].moveDown(graphics);
            }
            repaint();
        }
        if((ghostTime > (8*grid.getGridSize()/ghosts[0].getSpeed())*timeCounter) && ghostTime <= (10*grid.getGridSize()/ghosts[0].getSpeed()*timeCounter)){//next few moves of each ghost hard coded
            ghosts[0].moveDown(graphics);
            graphics.setColor(Color.WHITE);
            graphics.fillRect(maze.getX()+(13*grid.getGridSize())+(grid.getGridSize()/2),maze.getY()+(13*grid.getGridSize())+1,2*grid.getGridSize(),(grid.getGridSize()/2)-2);
            graphics.setColor(Color.BLACK);
            ghosts[2].moveLeft(graphics);
            ghosts[3].moveRight(graphics);
            ghosts[1].moveRight(graphics);
            repaint();
        }
        if((ghostTime > (10*grid.getGridSize()/ghosts[0].getSpeed())*timeCounter) && ghostTime <= (13*grid.getGridSize()/ghosts[0].getSpeed()*timeCounter)){//next few moves of each ghost hard coded
            ghosts[0].moveDown(graphics);
            graphics.setColor(Color.WHITE);
            graphics.fillRect(maze.getX()+(13*grid.getGridSize())+(grid.getGridSize()/2),maze.getY()+(13*grid.getGridSize())+1,2*grid.getGridSize(),(grid.getGridSize()/2)-2);
            graphics.setColor(Color.BLACK);
            if(ghosts[2].getX() > maze.getX()+9*grid.getGridSize()+1){
                ghosts[2].moveLeft(graphics);
            }
            else{
                ghosts[2].moveUp(graphics);
            }
            if(ghosts[3].getX() < maze.getX()+18*grid.getGridSize()+1){
                ghosts[3].moveRight(graphics);
            }
            else{
                ghosts[3].moveDown(graphics);
            }
            ghosts[1].moveUp(graphics);
            repaint();
        }
        if(ghostTime > (13*grid.getGridSize()/ghosts[0].getSpeed())*timeCounter){//ghosts begin moving randomly
            for(int k=0;k<ghosts.length;k++){
                ghosts[k].moveRandomSmoothly(graphics);
                for(int m = 0; m<ghosts.length;m++){
                    if(ghosts[m].ghostsTouchEachOther(ghosts[k].getX(),ghosts[k].getY()) && m!=k){
                        if((ghosts[k].getY() != (maze.getY() + 11*grid.getGridSize() + 1)) && (ghosts[k].getX()>(maze.getX() + 2*grid.getGridSize() + 1) && ghosts[k].getX()<(maze.getX() + 27*grid.getGridSize() + 1))){
                            ghosts[k].reverseDirection();
                        }
                    }
                }
                repaint();
            }
        }
        if(lastPressed == DOWN_PRESSED && !maze.touchesWallBelow(pacman.getX(),pacman.getY())){//moving pacman code
            pacman.moveDown(graphics);
            repaint();
            currentPressed = DOWN_PRESSED;
        }
        else if(lastPressed == UP_PRESSED && !maze.touchesWallAbove(pacman.getX(),pacman.getY())){//moving pacman code
            pacman.moveUp(graphics);
            repaint();
            currentPressed = UP_PRESSED;
        }
        else if(lastPressed == LEFT_PRESSED && !maze.touchesWallLeft(pacman.getX(),pacman.getY())){//moving pacman code
            pacman.moveLeft(graphics);
            repaint();
            currentPressed = LEFT_PRESSED;
        }
        else if(lastPressed == RIGHT_PRESSED && !maze.touchesWallRight(pacman.getX(),pacman.getY())){//moving pacman code
            pacman.moveRight(graphics);
            repaint();
            currentPressed = RIGHT_PRESSED;
        }
        else if(currentPressed == DOWN_PRESSED && !maze.touchesWallBelow(pacman.getX(),pacman.getY())){//moving pacman code
            pacman.moveDown(graphics);
            repaint();
        }
        else if(currentPressed == UP_PRESSED && !maze.touchesWallAbove(pacman.getX(),pacman.getY())){//moving pacman code
            pacman.moveUp(graphics);
            repaint();
        }
        else if(currentPressed == LEFT_PRESSED && !maze.touchesWallLeft(pacman.getX(),pacman.getY())){//moving pacman code
            pacman.moveLeft(graphics);
            repaint();
        }
        else if(currentPressed == RIGHT_PRESSED && !maze.touchesWallRight(pacman.getX(),pacman.getY())){//moving pacman code
            pacman.moveRight(graphics);
            repaint();
        }
        else if(lastPressed==LEFT_PRESSED){//moving pacman code if pacman has hit a wall
            int pacSpeed = pacman.getSpeed();
            pacman.setSpeed(0);
            pacman.moveLeft(graphics);
            pacman.setSpeed(pacSpeed);
            repaint();
        }
        else if(lastPressed==RIGHT_PRESSED){//moving pacman code if pacman has hit a wall
            int pacSpeed = pacman.getSpeed();
            pacman.setSpeed(0);
            pacman.moveRight(graphics);
            pacman.setSpeed(pacSpeed);
            repaint();
        }
        else if(lastPressed==UP_PRESSED){//moving pacman code if pacman has hit a wall
            int pacSpeed = pacman.getSpeed();
            pacman.setSpeed(0);
            pacman.moveUp(graphics);
            pacman.setSpeed(pacSpeed);
            repaint();
        }
        else if(lastPressed==DOWN_PRESSED){//moving pacman code if pacman has hit a wall
            int pacSpeed = pacman.getSpeed();
            pacman.setSpeed(0);
            pacman.moveDown(graphics);
            pacman.setSpeed(pacSpeed);
            repaint();
        }
        if(time == 20000 && orange.isTaken() && cherry.isTaken() && strawberry.isTaken()){//drawing a cherry fruit bonus
            cherry.setX(maze.getX()+14*grid.getGridSize()+1);
            cherry.setY(maze.getY()+17*grid.getGridSize()+1);
            repaint();
            cherry.setTaken(false);
        }
        if(time == 40000 && orange.isTaken() && cherry.isTaken() && strawberry.isTaken()){//drawing a orange fruit bonus
            orange.setX(maze.getX()+14*grid.getGridSize()+1);
            orange.setY(maze.getY()+17*grid.getGridSize()+1);
            repaint();
            orange.setTaken(false);
        }
        if(time == 60000 && orange.isTaken() && cherry.isTaken() && strawberry.isTaken()){//drawing a strawberry fruit bonus
            strawberry.setX(maze.getX()+14*grid.getGridSize()+1);
            strawberry.setY(maze.getY()+17*grid.getGridSize()+1);
            repaint();
            strawberry.setTaken(false);
            time=0;
        }
        if(pacman.getX()==cherry.getX() && pacman.getY()==cherry.getY() && (!cherry.isTaken() || !orange.isTaken() || !strawberry.isTaken())){//pacman has eaten a chery
            score = score+100;
            cherry.setTaken(true);
            cherry.setX(-100);
            cherry.setY(-100);
        }
        if(pacman.getX()==orange.getX() && pacman.getY()==orange.getY() && (!cherry.isTaken() || !orange.isTaken() || !strawberry.isTaken())){//pacman has eaten an orange
            score = score+100;
            orange.setTaken(true);
            orange.setX(-100);
            orange.setY(-100);
        }
        if(pacman.getX()==strawberry.getX() && pacman.getY()==strawberry.getY() && (!cherry.isTaken() || !orange.isTaken() || !strawberry.isTaken())){//pacman has eaten a strawberry
            score = score+100;
            strawberry.setTaken(true);
            strawberry.setX(-100);
            strawberry.setY(-100);
        }
        for(int i = 0; i < normalPellets.length;i++){//pacman eats a normal pellet
            if((pacman.getX()-1-normalPellets[i].getDiameter()/2)==(normalPellets[i].getX()-grid.getGridSize()) && (pacman.getY()-1-normalPellets[i].getDiameter()/2)==(normalPellets[i].getY()-grid.getGridSize()) && !normalPellets[i].isEaten()){
                normalPellets[i].setEaten(true);
                score = score+10;
            }
        }
        for(int j = 0; j < ghostPellets.length;j++){//pacman eats a ghost pellet
            if((pacman.getX()-1-ghostPellets[j].getDiameter()/2)==(ghostPellets[j].getX()-grid.getGridSize()) && (pacman.getY()-1-ghostPellets[j].getDiameter()/2)==(ghostPellets[j].getY()-grid.getGridSize()) && !ghostPellets[j].isEaten()){
                ghostPellets[j].setEaten(true);
                score = score+50;
                edibleTime = 0;
                for(int n = 0;n<ghosts.length;n++){
                    ghosts[n].setEdible(true);
                }
            }
        }
        for(int p = 0; p<ghosts.length;p++){//pacman gets eaten
            if(ghosts[p].pacmanTouchesAGhost(pacman.getX(),pacman.getY()) && !ghosts[p].isEdible() && !ghosts[p].isEaten()){
                lives = lives - 1;
                lifeDecrease = true;
            }
            else if(ghosts[p].pacmanTouchesAGhost(pacman.getX(),pacman.getY()) && ghosts[p].isEdible() && !ghosts[p].isEaten()){
                ghosts[p].setEaten(true);
                eatenTime[p] = 0;
                score = score + 600*ghostMod;
                ghostMod = ghostMod + 1;
            }
        }
        if(edibleTime > 100*timeCounter){//a ghost has been edible long enough to come back to life
            for(int o = 0; o<ghosts.length;o++){
                ghosts[o].setEdible(false);
                ghostMod = 1;
            }
        }
        for(int q = 0; q<ghosts.length;q++){//a ghost has been eaten long enough to come back to life
            if(eatenTime[q] > 100*timeCounter && ghosts[q].isEaten()){
                ghosts[q].setEaten(false);
            }
        }
        if(allPelletsEaten()){//a new level begins when all pellets have been eaten
            nextLevel();
        }
        if(score >= scoreCount*10000 && score < (scoreCount+1)*10000){//lifes increase!!!
            lives = lives + 1;
            scoreCount = scoreCount + 1;
        }
    }
    else if(lifeDecrease){//animation of a life decrease
        int l = 0;
        int rate = 15;//must divide into 150
        int lFinal = (150/rate);
        if(!pacman.getOpen()){
            rate = 17; //must divide into 170
            lFinal = (170/rate);
        }
        graphics.fillRect(pacman.getX(),pacman.getY(),pacman.getDiameter()+1,pacman.getDiameter()+1);//black box drawn to overite old pacman
        for(int i=0;i<ghosts.length;i++){//draws all the ghosts again so the one pacman is on top of will remain there
            ghosts[i].redraw(graphics);
        }
        while(l<=lFinal){
            if(lifeDecreaseTime == l && lifeDecreaseTime != lFinal){
                if(currentPressed == LEFT_PRESSED){
                    if(pacman.getOpen()){//draws pacman smaller and smaller as he eats himself
                        pacman.drawOpen(pacman.getX(),pacman.getY(),210+((lifeDecreaseTime+1)*rate),300-(2*(lifeDecreaseTime+1)*rate),graphics);
                    }
                    else{
                        pacman.drawOpen(pacman.getX(),pacman.getY(),190+((lifeDecreaseTime+1)*rate),340-(2*(lifeDecreaseTime+1)*rate),graphics);
                    }
                }
                else if(currentPressed == RIGHT_PRESSED){
                    if(pacman.getOpen()){
                        pacman.drawOpen(pacman.getX(),pacman.getY(),30+((lifeDecreaseTime+1)*rate),300-(2*(lifeDecreaseTime+1)*rate),graphics);
                    }
                    else{
                        pacman.drawOpen(pacman.getX(),pacman.getY(),10+((lifeDecreaseTime+1)*rate),340-(2*(lifeDecreaseTime+1)*rate),graphics);
                    }
                }
                else if(currentPressed == UP_PRESSED){
                    if(pacman.getOpen()){
                        pacman.drawOpen(pacman.getX(),pacman.getY(),120+((lifeDecreaseTime+1)*rate),300-(2*(lifeDecreaseTime+1)*rate),graphics);
                    }
                    else{
                        pacman.drawOpen(pacman.getX(),pacman.getY(),100+((lifeDecreaseTime+1)*rate),340-(2*(lifeDecreaseTime+1)*rate),graphics);
                    }
                }
                else if(currentPressed == DOWN_PRESSED){
                    if(pacman.getOpen()){
                        pacman.drawOpen(pacman.getX(),pacman.getY(),300+((lifeDecreaseTime+1)*rate),300-(2*(lifeDecreaseTime+1)*rate),graphics);
                    }
                    else{
                        pacman.drawOpen(pacman.getX(),pacman.getY(),280+((lifeDecreaseTime+1)*rate),340-(2*(lifeDecreaseTime+1)*rate),graphics);
                    }
                }
                repaint();
            }
            else if(lifeDecreaseTime == lFinal){
                lifeDecrease = false;
                lifeDecreaseTime = 0;
                if(lives != 0){//resets the board if lives havent run out
                    resetBoard();
                }
                else{
                    gameOver = true;
                }
            }
            l = l + 1;
        }
        if(lifeDecreaseTime != lFinal){
            lifeDecreaseTime = lifeDecreaseTime + 1;
        }
    }
    if(gameOver){//draws a game over screen
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,600,600);
        graphics.setColor(Color.RED);
        graphics.fillRect(maze.getX()+7*grid.getGridSize(),maze.getY()+4*grid.getGridSize(),3*grid.getGridSize(),grid.getGridSize());
        graphics.fillRect(maze.getX()+8*grid.getGridSize(),maze.getY()+5*grid.getGridSize(),grid.getGridSize(),2*grid.getGridSize());
        graphics.fillRect(maze.getX()+6*grid.getGridSize(),maze.getY()+6*grid.getGridSize(),2*grid.getGridSize(),grid.getGridSize());
        graphics.fillRect(maze.getX()+5*grid.getGridSize(),maze.getY()+2*grid.getGridSize(),grid.getGridSize(),4*grid.getGridSize());
        graphics.fillRect(maze.getX()+6*grid.getGridSize(),maze.getY()+1*grid.getGridSize(),3*grid.getGridSize(),grid.getGridSize());
        graphics.fillRect(maze.getX()+11*grid.getGridSize(),maze.getY()+3*grid.getGridSize(),grid.getGridSize(),4*grid.getGridSize());
        graphics.fillRect(maze.getX()+14*grid.getGridSize(),maze.getY()+3*grid.getGridSize(),grid.getGridSize(),4*grid.getGridSize());
        graphics.fillRect(maze.getX()+12*grid.getGridSize(),maze.getY()+2*grid.getGridSize(),2*grid.getGridSize(),grid.getGridSize());
        graphics.fillRect(maze.getX()+12*grid.getGridSize(),maze.getY()+5*grid.getGridSize(),2*grid.getGridSize(),grid.getGridSize());
        graphics.fillRect(maze.getX()+16*grid.getGridSize(),maze.getY()+3*grid.getGridSize(),grid.getGridSize(),4*grid.getGridSize());
        graphics.fillRect(maze.getX()+17*grid.getGridSize(),maze.getY()+2*grid.getGridSize(),grid.getGridSize(),grid.getGridSize());
        graphics.fillRect(maze.getX()+18*grid.getGridSize(),maze.getY()+3*grid.getGridSize(),grid.getGridSize(),2*grid.getGridSize());
        graphics.fillRect(maze.getX()+19*grid.getGridSize(),maze.getY()+2*grid.getGridSize(),grid.getGridSize(),grid.getGridSize());
        graphics.fillRect(maze.getX()+20*grid.getGridSize(),maze.getY()+3*grid.getGridSize(),grid.getGridSize(),4*grid.getGridSize());
        graphics.fillRect(maze.getX()+22*grid.getGridSize(),maze.getY()+3*grid.getGridSize(),grid.getGridSize(),3*grid.getGridSize());
        graphics.fillRect(maze.getX()+23*grid.getGridSize(),maze.getY()+2*grid.getGridSize(),2*grid.getGridSize(),grid.getGridSize());
        graphics.fillRect(maze.getX()+23*grid.getGridSize(),maze.getY()+6*grid.getGridSize(),2*grid.getGridSize(),grid.getGridSize());
        graphics.fillRect(maze.getX()+24*grid.getGridSize(),maze.getY()+4*grid.getGridSize(),2*grid.getGridSize(),grid.getGridSize());
        graphics.fillRect(maze.getX()+25*grid.getGridSize(),maze.getY()+3*grid.getGridSize(),grid.getGridSize(),grid.getGridSize());
        graphics.fillRect(maze.getX()+5*grid.getGridSize(),maze.getY()+9*grid.getGridSize(),grid.getGridSize(),4*grid.getGridSize());
        graphics.fillRect(maze.getX()+9*grid.getGridSize(),maze.getY()+9*grid.getGridSize(),grid.getGridSize(),4*grid.getGridSize());
        graphics.fillRect(maze.getX()+6*grid.getGridSize(),maze.getY()+8*grid.getGridSize(),3*grid.getGridSize(),grid.getGridSize());
        graphics.fillRect(maze.getX()+6*grid.getGridSize(),maze.getY()+13*grid.getGridSize(),3*grid.getGridSize(),grid.getGridSize());
        graphics.fillRect(maze.getX()+11*grid.getGridSize(),maze.getY()+9*grid.getGridSize(),grid.getGridSize(),2*grid.getGridSize());
        graphics.fillRect(maze.getX()+12*grid.getGridSize(),maze.getY()+11*grid.getGridSize(),grid.getGridSize(),2*grid.getGridSize());
        graphics.fillRect(maze.getX()+13*grid.getGridSize(),maze.getY()+13*grid.getGridSize(),grid.getGridSize(),grid.getGridSize());
        graphics.fillRect(maze.getX()+14*grid.getGridSize(),maze.getY()+11*grid.getGridSize(),grid.getGridSize(),2*grid.getGridSize());
        graphics.fillRect(maze.getX()+15*grid.getGridSize(),maze.getY()+9*grid.getGridSize(),grid.getGridSize(),2*grid.getGridSize());
        graphics.fillRect(maze.getX()+17*grid.getGridSize(),maze.getY()+10*grid.getGridSize(),grid.getGridSize(),3*grid.getGridSize());
        graphics.fillRect(maze.getX()+18*grid.getGridSize(),maze.getY()+9*grid.getGridSize(),2*grid.getGridSize(),grid.getGridSize());
        graphics.fillRect(maze.getX()+18*grid.getGridSize(),maze.getY()+13*grid.getGridSize(),2*grid.getGridSize(),grid.getGridSize());
        graphics.fillRect(maze.getX()+19*grid.getGridSize(),maze.getY()+11*grid.getGridSize(),2*grid.getGridSize(),grid.getGridSize());
        graphics.fillRect(maze.getX()+20*grid.getGridSize(),maze.getY()+10*grid.getGridSize(),grid.getGridSize(),grid.getGridSize());
        graphics.fillRect(maze.getX()+22*grid.getGridSize(),maze.getY()+10*grid.getGridSize(),grid.getGridSize(),4*grid.getGridSize());
        graphics.fillRect(maze.getX()+23*grid.getGridSize(),maze.getY()+9*grid.getGridSize(),2*grid.getGridSize(),grid.getGridSize());
        graphics.fillRect(maze.getX()+25*grid.getGridSize(),maze.getY()+10*grid.getGridSize(),grid.getGridSize(),grid.getGridSize());
        graphics.drawString("Your score was: " + score,maze.getX()+12*grid.getGridSize(),maze.getY()+16*grid.getGridSize());
        graphics.drawString("Continue?  Y/N",maze.getX()+12*grid.getGridSize(),maze.getY()+18*grid.getGridSize());
        graphics.setColor(Color.BLACK);
        repaint();
        t.stop();
    }
    }
    /**
     * Method startTimer starts the timer of this class from another
     *
     */
    public void startTimer(){
        t.start();
    }
    /**
     * Method stopTimer stops the timer of this class from another
     *
     */
    public void stopTimer(){
        t.stop();
    }
    /**
     * Method allPelletsEaten checks if all the pellets have been eaten used to see if we should progress to the next level
     *
     * @return returns true if all the pellets have been eaten
     */
    private boolean allPelletsEaten(){
        boolean ghostPelletsEaten = true;
        boolean normalPelletsEaten = true;
        for(int j = 0; j<ghostPellets.length;j++){
            if(!ghostPellets[j].isEaten()){
                ghostPelletsEaten = false;
            }
        }
        if(ghostPelletsEaten){
            for(int i = 0; i<normalPellets.length;i++){
                if(!normalPellets[i].isEaten()){
                    normalPelletsEaten = false;
                }
            }
        }
        if(normalPelletsEaten && ghostPelletsEaten){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Method nextLevel resets everyting as it should be for the next level used to go to the next level
     *
     */
    private void nextLevel(){
        for(int k = 0;k<ghosts.length;k++){
            ghosts[k] = new Ghosts(grid);
            if(k == 0){
               ghosts[k].setColor(Color.RED);
               ghosts[k].setX(maze.getX()+27*grid.getGridSize()/2+1);
               ghosts[k].setY(maze.getY()+22*grid.getGridSize()/2+1);
            }
            if(k == 1){
               ghosts[k].setColor(Color.PINK);
               ghosts[k].setX(maze.getX()+23*grid.getGridSize()/2+1);
               ghosts[k].setY(maze.getY()+28*grid.getGridSize()/2+1);
            }
            if(k == 2){
               ghosts[k].setColor(Color.ORANGE);
               ghosts[k].setX(maze.getX()+27*grid.getGridSize()/2+1);
               ghosts[k].setY(maze.getY()+28*grid.getGridSize()/2+1);
            }
            if(k == 3){
               ghosts[k].setColor(Color.CYAN);
               ghosts[k].setX(maze.getX()+31*grid.getGridSize()/2+1);
               ghosts[k].setY(maze.getY()+28*grid.getGridSize()/2+1);
            }
        }
        pacman.setX(maze.getX()+(13*grid.getGridSize())+(grid.getGridSize()/2)+1);
        pacman.setY(maze.getY()+(23*grid.getGridSize())+1);
        pacman.setOpen(true);
        timeCounter = 50;
        time = 0;
        ghostTime = 0;
        for(int i = 0; i<normalPellets.length;i++){
            normalPellets[i].setEaten(false);
        }
        for(int j = 0; j<ghostPellets.length;j++){
            ghostPellets[j].setEaten(false);
        }
        strawberry.setTaken(false);
        cherry.setTaken(false);
        orange.setTaken(false);
        gameStart = true;
        lastPressed = LEFT_PRESSED;
        currentPressed = LEFT_PRESSED;
        gameOver = false;
        edibleTime = 200*timeCounter;
        ghostMod = 1;
        gameTime = 0;
        graphics.fillRect(0,0,600,600);
        maze.drawMaze(graphics);
        repaint();
    }
    /**
     * Method resetBoard resets the board used for starting the next level, starting a new game, or if pacman dies
     *
     */
    private void resetBoard(){
        for(int k = 0;k<ghosts.length;k++){
            ghosts[k] = new Ghosts(grid);
            if(k == 0){
               ghosts[k].setColor(Color.RED);
               ghosts[k].setX(maze.getX()+27*grid.getGridSize()/2+1);
               ghosts[k].setY(maze.getY()+22*grid.getGridSize()/2+1);
            }
            if(k == 1){
               ghosts[k].setColor(Color.PINK);
               ghosts[k].setX(maze.getX()+23*grid.getGridSize()/2+1);
               ghosts[k].setY(maze.getY()+28*grid.getGridSize()/2+1);
            }
            if(k == 2){
               ghosts[k].setColor(Color.ORANGE);
               ghosts[k].setX(maze.getX()+27*grid.getGridSize()/2+1);
               ghosts[k].setY(maze.getY()+28*grid.getGridSize()/2+1);
            }
            if(k == 3){
               ghosts[k].setColor(Color.CYAN);
               ghosts[k].setX(maze.getX()+31*grid.getGridSize()/2+1);
               ghosts[k].setY(maze.getY()+28*grid.getGridSize()/2+1);
            }
        }
        pacman.setX(maze.getX()+(13*grid.getGridSize())+(grid.getGridSize()/2)+1);
        pacman.setY(maze.getY()+(23*grid.getGridSize())+1);
        pacman.setOpen(true);
        timeCounter = 75;
        time = 0;
        ghostTime = 0;
        strawberry.setTaken(false);
        cherry.setTaken(false);
        orange.setTaken(false);
        gameStart = true;
        lastPressed = LEFT_PRESSED;
        currentPressed = LEFT_PRESSED;
        gameOver = false;
        edibleTime = 200*timeCounter;
        ghostMod = 1;
        gameTime = 0;
        graphics.fillRect(0,0,600,600);
        maze.drawMaze(graphics);
        repaint();
        lifeDecrease = false;
        lifeDecreaseTime = 0;
    }
    /**
     * Method getGameOver allows another class to check if the game is over
     *
     * @return whether or not the game is over
     */
    public boolean getGameOver(){
        return gameOver;
    }
    /**
     * Method newGame starts a new game used when gameover occurs but we still want to keep playing
     *
     */
    public void newGame(){
        for(int j = 0; j<ghostPellets.length;j++){
            ghostPellets[j].setEaten(false);
        }
        for(int i = 0; i<normalPellets.length;i++){
            normalPellets[i].setEaten(false);
        }
        resetBoard();
        score = 0;
        lives = 3;
        scoreCount = 1;
    }
}
