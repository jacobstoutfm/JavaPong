
/**
 * This class represents the ball in Pong

 *
 * @author Jacob Stout
 * @version 11/19/21
 */
import java.awt.*;
import java.awt.geom.*;

public class Ball
{
   private int xPosition; // X-Value for Ball
   private int yPosition; // Y-Value for Ball
   private int diameter; //Diameter for Ball
   private int xVelocity; //Velocity for Ball on X-Axis
   private int yVelocity; //Velocity for Ball on Y- Axis
   
   /**
    * Constructor for Ball
    */
   Ball()
   {
	   xVelocity = 4; // Initializes velocity for X at 4
	   yVelocity = 4; // Initializes velocity for Y at 4
	   diameter = 15; //Initializes diameter at 15
	   xPosition = GameBoardFrame.WIDTH/2; //Puts X position in center
	   yPosition = GameBoardFrame.HEIGHT/2; //Puts Y position in center
	   
   }
   
   /**
    * Move method for ball
    */
   void move()
   {
	   xPosition += xVelocity;
	   yPosition += yVelocity;
   }
   
   /**
    * Gets position of X-axis
    * @return xPosition -- X-axis location of ball
    */
   
   public int getXPosition()
   {
	   return xPosition;
   }
   
   /**
    * Gets position of Y-axis
    * @return yPosition -- Y-axis location of ball
    */
   public int getYPosition()
   {
	   return yPosition;
   }
   
/**
 * Gets diameter
 * @return diameter -- Diameter
 */
   public int getDiameter()
   {
	   return diameter;
   }
   
   /**
    * Reverses the velocity on X-axis
    */
   public void reverseVelocityOnX()
   {
	   xVelocity = -xVelocity;
   }
   
   /**
    * Reverses the velocity on Y-axis
    */
   public void reverseVelocityOnY()
   {
	 yVelocity = -yVelocity;   
   }
   
   /**
    * Sets the X-axis position
    * @param xPosition -- Position of X-axis to be set
    */
   public void setXPosition(int xPosition)
   {
	   this.xPosition = xPosition;
   }
   
   /**
    * Sets the Y-axis position
    * @param yPosition -- Position of the Y-axis to be set
    */
   public void setYPosition(int yPosition)
   {
	   this.yPosition = yPosition;
   }




}
