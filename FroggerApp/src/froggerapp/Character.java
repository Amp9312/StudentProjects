package froggerapp;

/**
 *
 * @author Anthony H
 */
public abstract class Character {
    private int x, y;
    protected boolean visibleState;
    protected String Marker;
    /**
     * This is the constructor for the abstract parent class, the super class.
     * @param isX Takes in values to initialize the object x value with
     * @param isY Takes in values to initialize the object y value with
     */
    public Character(int isX, int isY){
        visibleState = true;
        x = isX;
        y = isY;
    }
    /**
     * This is a getter method for the objects X value
     * @return x, the x coordinate for the object
     */
    protected int getX(){
        return x;
    }
    /**
     * This is a getter method for the objects Y value
     * @return y, the y coordinate for the object
     */
    protected int getY(){
        return y;
    }
    /**
     * This is the specialized setter method specifically used to increment x value by one.
     */
    protected void upX(){
        x = x + 1;
    }
    /**
     * This is the specialized setter method specifically use to increment y value by one.
     */
    protected void upY(){
        y = y + 1;
    }
    /**
     * This is the specialized setter method specifically used to decrement x value by one.
     */
    protected void downX(){
        x = x - 1;
    }
    /**
     * This is the specialized setter method specifically used to decrement y value by one.
     */
    protected void downY(){
        y = y - 1;
    }
    /**
     * isVisible is a getter method used to check if the npc is currently visible.
     * @return visibleState, which is a boolean used to tell if the npc is visible.
     */
    public boolean isVisible(){
        return visibleState == true;
    }
    /**
    * get Marker is a getter method used to obtain the character meant to represent the npc type
    * @return Marker, the string used to represent the npc
    */
    public String getMarker(){
        return Marker;
    }
    /**
     * Debugging tool used to troubleshoot troublesome Jumper object.
     * @param posX is where I wanted jumper to go
     */
    protected void updateX(int posX){
        x = posX;
    }
    /**
     * Abstract method used as a placeholder method, to be later overridden.
     * @param playerX Is where the player is currently on the x axis
     * @param playerY Is where the player is currently on the y axis
     */
    public abstract void act(int playerX, int playerY);
}
