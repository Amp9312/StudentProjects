/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotgame;
/**
 *
 * @author lvlup
 */
public class Robot {
    private boolean hasCollided=false;
    private int x;
    private int y;
    private int fuel;
    private Player player;
    /**
     * Robot object constructs an opponent for player to avoid in RobotGame
     * @param x this variable tells where on the x coordinate in the canvas robot object is
     * @param y this variable tells where on the y coordinate in the canvas robot object is
     * @param fuel this variable tells the robot how many spaces they have left to move until they explode.
     * @param player This is a reference to Player Class object and it's methods
     */
public Robot(int x, int y, int fuel, Player player)
{
    this.x=x;
    this.y=y;
    this.player=player;
    this.fuel=fuel;
}

/**
 * getX method is a getter to obtain the x value of robot
 * @return x coordinate for robot
 * Commented out due to being a part of the older Robot project. Kept for reference.
 */
/*public int getX()
{
    return x;
}
*/
/**
 * getY is a getter method to obtain the y value of robot
 * @return 
 * Commented out due to being a part of the older Robot project. Kept for reference.
 */
/*public int getY()
{
    return y;
}
*/
/**
 * isExploded is a getter method to obtain whether or not a robot has exploded.
 * @return hasCollided which is a member variable that gets switched to true if the correct parameters are met
 * Commented out due to being a part of the older Robot project. Kept for reference.
 */
/*public boolean isExploded()
{
    return hasCollided;
}
*/
/**
 * toSting is a debugging method for the programmer to check if any values are off.
 * @return x value, y value, fuel value, and whether or not the robot has collided.
 */
public String toString()
{
    return "X value for robot was:" + x +
            "Y value for robot was:" + y +
            "Fuel Level for robot was:" + fuel + 
            "This robot has collided with player (t/f): " + hasCollided;
}

/**
 * This method moves the robot's with an AI intent on running into the player to increase their "hit" count. 
 */
public void move()
{
    //We good on fuel?
    if(fuel==0)
    {
        hasCollided = true;
        //isExploded();
    }
    //Am I Dead?
    if(hasCollided)
    {
        return;
    }
    //Is the player to my left?
    if(x > player.getX())
    {
        //Move to the left!
        x=x-1;
        fuel=fuel-1;
    }
    //Is the player to my right?
    if(x < player.getX())
    {
        //Move to the right!
        x=x+1;
        fuel=fuel-1;
    }
    //Is the player above me?
    if(y < player.getY())
    {
        //take it back now y'all!
        y=y+1;
        fuel=fuel-1;
    }
    //Is the player below me?
    if(y > player.getY())
    {
        //Everybot catch that man
        y=y-1;
        fuel=fuel-1;
    }
    //Target Acquired
    if(y == player.getY() && x == player.getX())
    {
        //Detonate, hit, repeat
        hasCollided=true;
        //isExploded();
        player.hit();           
    }
}
/**
 * equals is an override method of .equals for Robot class, similar in functionality but altered to fit
 * validation purposes
 * @param obj is the robot object passed to .equals for validation
 * @return It returns the two individual checks done for validation. If one is false then all validation is false.
 */
    @Override
    public boolean equals(Object obj){
        boolean check1 = false;
        boolean check2 = false;
        //Cast param into Robot class (just in case it's not)
        Robot CastBot = (Robot)obj;
        //Has it exploded?
        if(hasCollided == false)
            check1 = true;
        //Is it there?
        if(CastBot.x == this.x && CastBot.y == this.y){
            check2 = true;
    }
        //Everything check out okay?
        return check1 && check2;
}
}


