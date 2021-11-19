/**
 * Paddle class for Pong
 * @author Jacob Stout
 * @version 11/19/21
 */
public class Paddle 
{
	private int height; //height to be Initialized
	private int width; //width to be Initialized
	private int xPosition; //x-Value to be Initialized
	private int yPosition; //y-Value to be Initialized
	private int velocity; //velocity to be Initialized
	
	/**
	 * Gets the x-axis value
	 * @return xPosition -- position of the paddle on x-Axis
	 */
	public int getXPosition()
	{
		return xPosition;
	}
	
	/**
	 * Gets the y-axis value
	 * @return yPosition -- position of the paddle on y-Axis
	 */
	public int getYPosition()
	{
		return yPosition;
	}
	
	/**
	 * Gets the height of the paddle
	 * @return height -- Height of the paddle
	 */
	public int getHeight()
	{
		return height;
	}
	
	/**
	 * Gets the width of the paddle
	 * @return width -- Width of the paddle
	 */
	public int getWidth()
	{
		return width;
	}
	
	/**
	 * Paddle constructor 
	 * @param location -- The location string allows for knowing which paddle is being created, and placing in proper X-axis location.
	 */
	Paddle(String location)
	{
		velocity = 10;
		height = 150;
		width = 10;
		yPosition = (GameBoardFrame.HEIGHT / 2) - (height /2);
		if (location.equals("LEFT"))
		{
			xPosition = 10;
		}
		
		if (location.equals("RIGHT"))
		{
			xPosition = (GameBoardFrame.WIDTH - 30);
		}
	}
	
	/**
	 * Moves the paddle upwards
	 */
	void moveUp()
	{
		if(yPosition >0)
		{
			yPosition-=velocity;
		}
	}
	
	/**
	 * Moves the paddle downwards
	 */
	void moveDown()
	{
		if(yPosition < (GameBoardFrame.HEIGHT - height))
		{
			yPosition += velocity;
		}
	}

}
