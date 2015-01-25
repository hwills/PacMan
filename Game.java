import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * The overall frame for the pacman game.
 * 
 * @author Hunter Wills
 * @version 5/11/2013
 */
public class Game extends JFrame implements ActionListener, KeyListener
{
    private JButton controlsButton;//the button to go to the controls menu
    private JButton playButton;//the putton to begin playing the game
    private JButton backButton;//the button to go back to the title screen
    private TitleScreen title;//the title screen
    private ControlsMenu controls;//the contrls menu
    private GameScreen game;//the game
    private boolean newKeyPressed;//boolean if a key has been pressed
    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        super("Pac-Man");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        title = new TitleScreen();
        controlsButton = new JButton("Controls");
        playButton = new JButton("Play Game");
        controlsButton.addActionListener(this);
        playButton.addActionListener(this);
        title.add(controlsButton);
        title.add(playButton);
        playButton.setBounds(240,270,120,40);
        controlsButton.setBounds(240,330,120,40);
        controls = new ControlsMenu();
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        controls.add(backButton);
        backButton.setBounds(240,520,120,40);
        game = new GameScreen();
        addKeyListener(this);
        setFocusable(true);
        add(title);
        pack();
    }
    /**
     * Method actionPerformed the event for the play game or controls button being clicked
     *
     * @param e the event
     */
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == controlsButton){
            remove(title);
            add(controls);
            controls.repaint();
            pack();
        }
        else if(e.getSource() == playButton){
            remove(title);
            add(game);
            game.repaint();
            pack();
            game.startTimer();
        }
        else if(e.getSource() == backButton){
            remove(controls);
            add(title);
            title.repaint();
        }
    }
    /**
     * Method paintComponent paints the game
     *
     */
    public void paintComponent(Graphics g){
        g.fillRect(0,0,800,600);
    }
    /**
     * Method keyPressed code for what will happen when the key is pressed
     *
     */
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            game.movePacManRight();
            game.repaint();
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            game.movePacManLeft();
            game.repaint();
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP){
            game.movePacManUp();
            game.repaint();
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            game.movePacManDown();
            game.repaint();
        }
        else if(e.getKeyCode() == KeyEvent.VK_Y && game.getGameOver()){
            game.newGame();
            game.repaint();
            game.startTimer();
        }
        else if(e.getKeyCode() == KeyEvent.VK_N && game.getGameOver()){
            game.newGame();
            remove(game);
            add(title);
            title.repaint();
        }
    }
    /**
     * Method keyReleased code for what will happen when the key is released
     *
     */
    public void keyReleased(KeyEvent e){
        
    }
    /**
     * Method keyTyped will not be used but must exist to implement KeyListener
     *
     */
    public void keyTyped(KeyEvent e){
        
    }
    public static void main(String[] args){
        Game game = new Game();
    }
}
