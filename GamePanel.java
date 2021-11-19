/**
 * Game Panel / Setup class
 * @author Jacob Stout
 * @version 11/19/21
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener
{
    private Ball ball; //ball object to be Initialized
    private Paddle leftPaddle; // left paddle object to be Initialized
    private Paddle rightPaddle; //right paddle object to be Initialized
    private int leftUp = 0; // W key to be Initialized
    private int leftDown = 1; // S key to be Initialized
    private int rightUp = 2; // Up Arrow key to be Initialized
    private int rightDown = 3; // Down Arrow key to be Initialized
    private boolean inputs[]; // an Array of user inputs for true or false to be Initialized
    private Timer timer; //timer to be Initialized
    private int wait = 8; // delay/wait amount to be Initialized
    private JLabel gameInstructions; //User input instructions to be Initialized
    private int leftScoreNum = 0; // left user score to be Initialized
    private int rightScoreNum = 0; // right user score to be Initialized
    
	/**
	 * Constructor for GamePanel
	 */
    public GamePanel()
    {
    	setBackground(Color.BLACK); //Sets background of the panel to black
    	setFocusable(true);
    	addKeyListener(this);
    	setDoubleBuffered(true);
    	ball = new Ball(); //Creates new Ball object
    	leftPaddle = new Paddle ("LEFT"); //Creates new left paddle with string attached
    	rightPaddle = new Paddle ("RIGHT"); //Creates new right paddle with string attached 
    	inputs = new boolean[] {false, false, false, false}; //Sets ArrayList with all initialized at false
    	timer = new Timer(wait, this); //Creates timer with wait integer(8) and attributing to the panel
    	timer.start(); //Starts the timer
    	gameInstructions = new JLabel("      " + "Use W/S for left" +"      "  +"Up/Down for right"); //Instructions to be displayed at top of the panel, centered at game line
    	gameInstructions.setForeground(Color.GREEN); //Sets instructions to green
    	this.add(gameInstructions); //Adds instructions to the panel
    	
    	
    }
    
    /**
     * Increases the score of the left paddle
     */
    public void increaseLeftScore()
    {
    	leftScoreNum++;
    }
    
    /**
     * Increases the score of the right paddle
     */
    public void increaseRightScore()
    {
    	rightScoreNum++;
    }
    
    /**
     * Shows the score of the left paddle
     * @param graphics -- Graphics to be drawn
     */
    private void showScoreLeft(Graphics graphics)
    {

    	graphics.drawString("Score: ",20, 20);
    	graphics.drawString(""+leftScoreNum, 20, 40);
        graphics.setColor(Color.WHITE);
    	
    }
    
    /**
     * Shows the score of the right paddle
     * @param graphics -- Graphics to be drawn
     */
    private void showScoreRight(Graphics graphics)
    {
    	graphics.drawString("Score: ",945, 20);
    	graphics.drawString(""+rightScoreNum, 965, 40);
    	graphics.setColor(Color.WHITE);
    }
    
    /**
     * Checks if ball collides out of bounds or with paddle
     * If out of bounds on right side, resets to center and increases left paddle score
     * If out of bounds on left side, resets to center and increases right paddle score
     */
    private void CheckForCollisions()
    {
        if(ball.getXPosition() < (leftPaddle.getXPosition() + leftPaddle.getWidth()))
        {
            if((ball.getYPosition() > leftPaddle.getYPosition()) && (ball.getYPosition() < (leftPaddle.getYPosition() + leftPaddle.getHeight())))
            {
                ball.reverseVelocityOnX();
            }
            else {
                ball.setXPosition(GameBoardFrame.WIDTH / 2);
                ball.setYPosition(GameBoardFrame.HEIGHT / 2);
                increaseRightScore();

            }
        }
        if(ball.getXPosition() > (rightPaddle.getXPosition() - rightPaddle.getWidth()))
        {
            if((ball.getYPosition() > rightPaddle.getYPosition()) && (ball.getYPosition() < (rightPaddle.getYPosition() + rightPaddle.getHeight())))
            {
            	ball.reverseVelocityOnX();
            }
            else {
            	 ball.setXPosition(GameBoardFrame.WIDTH / 2);
                 ball.setYPosition(GameBoardFrame.HEIGHT / 2);
                 increaseLeftScore();
            }

        }
        else if(ball.getYPosition()<0 || ball.getYPosition()>GameBoardFrame.HEIGHT){
        	ball.reverseVelocityOnY();
        }

    }
    
    /**
     * Paints the given game objects
     * @param graphics -- Graphics to be drawn in total
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        drawBall(graphics);
        drawPaddles(graphics);
        showScoreLeft(graphics);
        showScoreRight(graphics);
    	graphics.drawLine(GameBoardFrame.WIDTH / 2, 0, GameBoardFrame.WIDTH /2, GameBoardFrame.HEIGHT);

    }
    
    /**
     * Draws the paddles
     * @param graphics -- Graphics to be drawn
     */
    private void drawPaddles(Graphics graphics) 
    {
    	graphics.setColor(Color.WHITE);
    	graphics.fillRect(leftPaddle.getXPosition(),leftPaddle.getYPosition(),leftPaddle.getWidth(),leftPaddle.getHeight());
    	graphics.fillRect(rightPaddle.getXPosition(),rightPaddle.getYPosition(),rightPaddle.getWidth(),rightPaddle.getHeight());
    }

    /**
     * Draws the ball on the screen
     * @param graphics -- Graphics to be drawn
     */
    private void drawBall(Graphics graphics) 
    {
    	graphics.setColor(Color.RED);
    	graphics.fillOval(ball.getXPosition(),ball.getYPosition(),ball.getDiameter(),ball.getDiameter());
    }
    
    /**
     * No keys are typed, method stays empty
     * @param e -- When a key is triggered in certain action, typed in this situation
     */
	@Override
	public void keyTyped(KeyEvent e) 
	{
		// Leave empty
		
	}

	/**
	 * What happens when keys are pressed
	 * Sets specific key to true in ArrayList inputs
	 * @param e -- When a key is triggered in certain action, press in this method
	 */
	@Override
	public void keyPressed(KeyEvent e)
	{
		
		if (e.getKeyCode() == KeyEvent.VK_W)
		{
			inputs[leftUp] = true;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_S)
		{
			inputs[leftDown] = true;
		}
		
		
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			inputs[rightUp] = true;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			inputs[rightDown] = true;
		}
	
	}

	/**
	 *  What happens when keys are released
	 *  Sets specific key to false in ArrayList inputs
	 *  @param e -- When a key is triggered in certain action, release of key in this method
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W)
		{
			inputs[leftUp] = false;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_S)
		{
			inputs[leftDown] = false;
		}
		
		
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			inputs[rightUp] = false;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			inputs[rightDown] = false;
		}
		
		
	}

	/**
	 * Action to be performed after KeyEvent
	 * In this case, if arrayList element is true for one of the inputs, allows user to move paddles in up/down directions.
	 * @param e -- Event to occur after noting which element is listed as true.
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		ball.move();
		CheckForCollisions();
		if(inputs[leftUp])
		{
			leftPaddle.moveUp();
		}
		if(inputs[leftDown])
		{
			leftPaddle.moveDown();
		}
		if(inputs[rightUp])
		{
			rightPaddle.moveUp();
		}
		if (inputs[rightDown])
		{
			rightPaddle.moveDown();
		}
		
		repaint();
		

	}

}
