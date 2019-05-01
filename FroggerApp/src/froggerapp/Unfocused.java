package froggerapp;

/**
 * This is the constructor for the abstract unfocused class, parent to Jumper and Hider due to it's activated ability
 * @author User
 */
public abstract class Unfocused extends Character{
        private boolean activated;
        private int focX, focY;
        public Unfocused(int inX, int inY){
            super(inX, inY);
            activated = false;
            visibleState = true;
            focX = inX;
            focY = inY;
        }
        /**
         * Overridden act method, because java told me to 
         * @param playerX
         * @param charY 
         */
        @Override
        public void act(int playerX, int charY){
            //left blank I guess
        }
        /**
         * Setter method for activated property for jumper and hider
         */
        protected void actSwitch(){
            activated = true;
        }
        /**
         * Getter method for activated property
         * @return activated, which tells jumper or hider that they can start moving
         */
        protected boolean checkSwitch(){
            return activated;
        }
}
