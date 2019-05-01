package froggerapp;

import java.util.Random;

/**
 *
 * @author User
 */

public class Jumper extends Unfocused{
    public Jumper(int intX, int intY){
        super(intX, intY);
        Marker = "J";
        visibleState = true;
    }
    protected void Jump(){
        Random rand = new Random();
        int posX = rand.nextInt(8);
        updateX(posX);
        }
    /**
     * Overridden act method for jumper class
     * @param intX Tells jumper where the player is currently on the x axis
     * @param intY Tells jumper where the player is currently on the y axis
     */
    @Override
    public void act(int intX, int intY){
        //Used to calculate if player is close enough
   int distanceX, distanceY;
    distanceX = Math.abs(getX() - intX);
    distanceY = Math.abs(getY() - intY);
        //is player in range of jumper?
        if(distanceX == 2 || distanceY == 2){
            actSwitch();
            if(checkSwitch()){
                //start moving
                Jump();
                //debugging tool
                //System.out.println("Jumper has jumped!");
            }
            else{
                //debugging tool
                //System.out.println("Jumper is unactivated!");
            }
        }  
                //Debugging tool
                //System.out.println("Jumper coordinates are x:" + getX() + " y:" + getY());
    }
}
