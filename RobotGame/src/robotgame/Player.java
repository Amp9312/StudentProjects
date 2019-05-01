/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotgame;

/**
 *Initializes and declares the data necessary to compute the players location, movement, and times hit
 * @author lvlup
 */
public class Player 
{
    private int x;
    private int y;
    private int width;
    private int height;
    int timesHit = 0;
    public Player(int x, int y, int width, int height)
    {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        timesHit = 0;
    }
    /**
     * getX returns player's X coordinate to whatever called the method
     * @return x coordinate value
     */
    public int getX()
    {
        return x;
    }
    /**
     * getY returns player's y coordinate to whatever called the method
     * @return y coordinate value
     */
    public int getY()
    {
        return y;
    }
    /**
     * getHits returns how many times a robot has had the same coordinates as player object
     * @return getHits which represents how many times player and robot objects collided
     */
    public int getHits()
    {
        return timesHit;
    }
    /**
     * toString is a debugging method for the sole use of returning all object member variable data
     * @return x, y, width, height, timesHit to whatever bit of internal code called this method
     */
    public String toString()
    {
        return "X Coordinate: " + x + 
                " Y Coordinate: " + y + 
                " Map Width: " + width + 
                " Map height: " + height + 
                " Times Hit: " + timesHit; 
    }
    /**
     * move method reads in the directional button that was pressed within the UI
     * After reading the data pertaining to directional data it adjusts the players x and y coordinates
     * accordingly to adjust their icon on the canvas
     * @param direction This is the string that contains the string data spit out when a button is pressed
     */
    public void move(String direction)
    {
            if(direction == "north")
            {
                //can't run off board northward because you win the game before you can try
                if (y!=height-1)
                {
                y = y + 1;
                }
            }
            if(direction == "south")
            {
                if(y!=0)
                {
                y = y - 1;
                }
            }
            if(direction == "west")
            {
                if(x!=0)
                {
                x = x - 1;
                }
            }
            if(direction == "east" )
            {
                if(x!=width-1)
                {
                x = x + 1;
                }
            }
    }
    /**
     * Simple method that's called whenever the player collides with another object. 
     * Increments number of collisions for later events to reference. 
     */
    public void hit()
    {
        timesHit = timesHit + 1;
    }
    
}
