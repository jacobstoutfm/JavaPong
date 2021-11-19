
/**
 * A frame to hold and display the Pong game
 *
 * @author Jacob Stout
 * @version 11/19/21
 */
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class GameBoardFrame extends JFrame
{
	public static final int WIDTH = 1000; //Width of the frame
	public static final int HEIGHT = (int) (WIDTH * 0.5555555); //Height of the frame
	static final Dimension SCREEN_SIZE = new Dimension(WIDTH, HEIGHT); //Variable to set frame resolution
    private GamePanel panel; //GamePanel object to be Initialized
	
    GameBoardFrame()
    {
    	JFrame frame = new JFrame("PONG by Jacob Stout"); //Sets title to Pong
    	frame.setSize(SCREEN_SIZE); //Sets frame resolution
    	panel = new GamePanel(); //Initializes GamePanel object
    	frame.add(panel); //Adds panel to frame
    	frame.setResizable(false); //Doesn't allow resizing of resolution/frame
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Gives closing function
    	frame.setVisible(true); //Frame is set to visible
    	frame.setLocationRelativeTo(null); //Puts frame in the middle of user screen
    	
    }
    


   
    
}
