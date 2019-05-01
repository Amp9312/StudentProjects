package froggerapp;

/**
 * Constructor for Hider child class
 * @author Anthony H
 */
public class Hider extends Unfocused{
    public Hider(int intX, int intY){
        super(intX, intY);
        Marker = "H";
        visibleState = true;
    }
    public void setVisible(){
        if(visibleState == true){
            visibleState = false;
        }
        else
            visibleState = true;
    }
    /**
     * Overridden act method for Hider subclass. 
     * @param intX Used to tell hider where player currently is on the x axis
     * @param intY Used to tell hider where player currently is on the y axis
     */
    @Override
    public void act(int intX, int intY){
    int distanceX, distanceY;
        distanceX = Math.abs(getX() - intX);
        distanceY = Math.abs(getY() - intY);
        //Is player in range of hider?
        if(distanceX == 2 || distanceY == 2){
            //debugging tool
            //System.out.println("Hider is activated!");
            actSwitch();
        }
        if(checkSwitch()){
           //Hiders gonna start hiding
           setVisible();   
           }
        //Debugging tool
        //System.out.println("Hider coordinates are x:" + getX() + " y:" + getY());
        }
        }
