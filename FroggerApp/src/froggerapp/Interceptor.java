package froggerapp;

/**
 *Constructor for interceptor child class
 * @author User
 */
public class Interceptor extends Chaser{
    public Interceptor(int isX, int isY){
        super(isX, isY);
        Marker = "I";
        visibleState = true;
    }
 /**
  * This is the overridden act method for interceptor class
  * @param playerX Current X coordinate for player
  * @param playerY Current Y coordinate for player
  */
    @Override
    public void act(int playerX, int playerY){       
        if(playerX < getX())
        {
            //decrement interceptor's X
            downX();
            //Debugging tool
            //System.out.println("Interceptor has moved");
        }
        if(playerX > getX()){
            //increment interceptor's x
            upX();
            //Debugging tool
            //System.out.println("Interceptor has moved");
        }
        //Debugging tool
        //System.out.println("Interceptor coordinates are x:" + getX() + " y:" + getY());
    }
}
