package creaturecapture;
import java.util.*;
/**
 *This is the Creature class object, which contains all the data and methods required to
 * interact with CreatureCapture game.
 * @author Anthony Hake
 */
public class Creature {
    //Constants To be Used in creature Class
        Random rand = new Random();
        public final int CREATURESTRENGTH = rand.nextInt(24) + 1;
        public final int CREATURESPEED = rand.nextInt(24)+1;
        private int CurrentStrength, CurrentSpeed;
        private boolean caughtOrNot;
        
        /**
         * Constructor that pulls information from preset constants (randomly generated) 
         * and sets them equal to member variables. Also the creature's state of "caught" is 
         * initialized.
         * @param caught -- When initializing I used this to set the creature to caught by default to test segments of code
         */
        Creature(boolean caught){
            CurrentStrength = CREATURESTRENGTH;
            CurrentSpeed = CREATURESPEED;
            caughtOrNot = caught;
        }
        /**
         * GetStength is a getter method with the sole purpose of retrieving and returning a creatures strength. 
         * @return -- Returns CurrentStrength, a member variable containing the creatures strength value
         */
        int GetStrength(){
            return CurrentStrength;
        }
        /**
         * GetSpeed is a getter method with the sole purpose of retrieving and returning a creatures speed. 
         * @return -- Returns Speed, a member variable containing the creature's speed value. 
         */
        int GetSpeed(){
            return CurrentSpeed;
        }
        /**
         * GetOrgStrength is a getter method that obtains the constant in which the strength member variable was originally based on
         * @return -- Returns CREATURESTRENGH, constant that contains randomized original data for strength member variable. 
         */
        int GetOrgStrength(){
            return CREATURESTRENGTH;
        }
        /**
         * GetOrgSpeed is a getter method that obtains the constant in which the speed member variable was originally based on
         * @return -- Returns CREATURESPEED, constant that contains randomized original data for strength member variable.
         */
        int GetOrgSpeed(){
            return CREATURESPEED;
        }
        /**
         * GetCaughtOrNot is a getter method that returns the current "capture" state of creature object.
         * @return -- Returns caughtOrNot, a member variable that holds the current "capture" state of creature object.
         */
        boolean GetCaughtOrNot(){
            return caughtOrNot;
        }
        /**
         * setCaughtOrNot is a setter method that flips the conditional switch of whether a creature is "caught"
         */
        void setCaughtOrNot(){
            this.caughtOrNot = true;
        }
        /**
         * LowerCreaturePower is a setter method that alters the current strength and speed by a calculated parameter
         * @param DecreaseValue is a variable calculated from another method whose intent is to be subtracted from creature's current strength and speed.
         */
        void LowerCreaturePower(int DecreaseValue){
            CurrentStrength = CurrentStrength - DecreaseValue;
            CurrentSpeed = CurrentSpeed - DecreaseValue;
        }
        /**
         * CalcBonusEnergy is a method used to calculate how much energy is to be added to players energy pool
         * @return BonusEnergy which is used in a player method to modify their own energy pool
         */
        int CalcBonusEnergy(){
            int BonusEnergy = CREATURESPEED + CREATURESTRENGTH;
            return BonusEnergy;
        }

        /**
         * setDecrease is a setter method that decreases the creatures strength and speed when freeze ray is cast
         * @param DecreaseValue is a parameter brought in after player method calculations
         */
        void setDecrease(int DecreaseValue){
            CurrentStrength = CurrentStrength - DecreaseValue;
            CurrentSpeed = CurrentSpeed - DecreaseValue;
        }
        /**
         * WebCastReact is a method used to check if a creature's speed is optimal for capture. 
         * @return True or False depending on whether it's low enough
         */
        boolean webCastReact(){
            return GetSpeed() > 5;
        }
        /**
         * forceBubbleReact is a method used to check if a creature's strength is optimal for capture.
         * @return True or False depending on whether it's high enough.
         */
        boolean forceBubbleReact(){
            return GetStrength() < 10;
        }
        /**
         * This method is essential for utilizing the error conditions set in player freezer class. 
         * @param EnergyInput is carried in after player method calculations, and verifies that the number is positive.
         * @return A true or False depending on whether or not the error conditions are met. 
         */
        boolean freezeRaySuccess(int EnergyInput){
            int DecreaseValue = EnergyInput;
            return DecreaseValue > 0;
        }
        /**
         * CalcBonusEnergy is used to pull in the original speed and strength of that creature via other creature
         * methods, and add them together. This data is then outputted for use by another player method.
         * @param OrigSpd Is the Creature's original speed.
         * @param OrigStr Is the Creature's original strength.
         * @return BonusEnergy which is the result of the addition of the included parameters. 
         */
        int CalcBonusEnergy(int OrigSpd, int OrigStr){
            int BonusEnergy = OrigSpd + OrigStr;
            return BonusEnergy;
        }

        }

