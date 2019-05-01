package froggerapp;

/**
 *
 * @author Anthony H
 */
/**
 * Constructor for chaser subclass
 * @author Anthony H
 */
public class Chaser extends Character{
    public Chaser(int isX, int isY){
        super(isX, isY);
        Marker = "C";
        visibleState = true;
    }
    /**
     * This is the overridden act method for chaser subclass.
     * @param playerX Used to determine current x coordinate for player.
     * @param playerY Used to determine current y coordinate for player.
     */
    @Override
    public void act(int playerX, int playerY){
       //do chaser things here 
       if(playerX > getX()){
           //player is further to the right
            upX();
            //Debugging tool
            //System.out.println("Chaser has moved right");
       }
       if(playerX < getX()){
           //player is further to the left
           downX();
           //Debugging tool
           //System.out.println("Chaser has moved left");
       }
       if(playerY > getY()){
           //player is above chaser
           upY();
           //Debugging tool
           //System.out.println("Chaser has moved up");
       }
       if(playerY < getY()){
           //player is below chaser
           downY();
           //Debugging tool
           //System.out.println("Chaser has moved down");
       }
       //Debugging tool
    //System.out.println("Chaser coordinates are x:" + getX() + " y:" + getY());
    }
}

