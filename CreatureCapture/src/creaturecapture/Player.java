package creaturecapture;

/**
 *This is the player class object, which carries all the data and method essential for a player class
 * to interact with CreatureCapture game. 
 * @author Anthony Hake
 */
public class Player {
        public final int WEBCOST = 10;
        public final int FORCECOST = 20;
        private int StartingEnergy = 100;
        
        /**
         * This is the constructor for the player, which will always start with 100 energy until
         * initial variable is altered.
         * @param energyLevel is brought in from class variable StartingEnergy, used to track player's energy pool.
         */
        Player(int energyLevel)
        {
            StartingEnergy = energyLevel;
        }
        /**
         * CheckEnergy is a method used to return the current count of player's energy pool.
         * @return StartingEnergy which is just the variable for holding player's current energy.
         */
        int CheckEnergy(){
                return StartingEnergy;
        }
        /**
         * SubtractEnergy is a setter method used to alter the player's current energy pool negatively.
         * @param EnergySubtraction is a variable brought in from other calculations to determine how much to remove from player's current energy pool.
         */
        void SubtractEnergy(int EnergySubtraction){
            StartingEnergy = StartingEnergy - EnergySubtraction;
        }
        /**
         * AddEnergy is a setter method used to alter the player's current energy pool positively.
         * @param EnergyAdded is a variable brought in from other calculations to determine how much to add to player's current energy pool.
         */
        void AddEnergy(int EnergyAdded){
            StartingEnergy = StartingEnergy + EnergyAdded;
        }
        /**
         * WebCast is a method used to check if there's enough energy in energy pool to supply the cost of casting a web as an action
         * @return True or False depending on whether there's enough energy
         */
        boolean WebCast(){
            return CheckEnergy() >= WEBCOST;
        }
        /**
         * ForceBubble is a method used to check if there's enough energy in energy pool to supply the cost of casting force bubble as an action
         * @return True or False depending on whether there's enough energy.
         */
        boolean ForceBubble(){
            return CheckEnergy() >= FORCECOST;
        }
        /**
         * FreezeRay is a complex method containing error conditions, ways of verifying creature data and player data, and returning 
         * some value to use in the Creature's methods reaction to casting freeze ray as an action.
         * @param UserEnergyInput is how much energy the player decided to use for this cast
         * @param ChkSpeed is how much speed the creature is currently at
         * @param ChkStrength is how much strength the creature is currently at
         * @return A number referring to either an actual energy output or some error code.
         */
        int FreezeRay(int UserEnergyInput, int ChkSpeed, int ChkStrength){
            int Freezecost = UserEnergyInput;
            int Speed=ChkSpeed, Strength=ChkStrength;
            int EnergyOutput;
            int conOne = -199;
            int conTwo = -299;
            int conThree = -399;
            
            if(CheckEnergy() >= Freezecost){
                //There enough energy to put into Freezecost
                if(Speed != 0){
                    //The creatures speed isn't 0
                    if(Strength != 0){
                        //The Creatures strength isn't 0
                        SubtractEnergy(Freezecost);
                        EnergyOutput = Freezecost/2;
                        return EnergyOutput;
                    }
                    else
                        return conOne; //Strength too low.
                }
                else 
                    return conTwo; //Speed too low. 
            }
            else
            return conThree; //Not enough energy.
        }
    
            
}
