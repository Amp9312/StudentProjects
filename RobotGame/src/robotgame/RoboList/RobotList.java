package robotgame;
import java.util.ArrayList;
import java.util.Random;

/**
 * ArrayList class specifically for Robot objects
 * @author Anthony Hake
 */

public class RobotList {
    
    ArrayList<Robot> RoboList = new ArrayList<Robot>();
    //Used in method for 20% (changeable) chance of spawn
    public static final int SpawnChance = 5;
    //Used to give all robots a standard amount of fuel
    public static final int RandFuel = 10;
    
    //Params used to create RoboList ArrayList
    private int w;
    private int h;
    private Player p;
    public RobotList(Player player, int width, int height){
        this.w = width;
        this.h = height;
        this.p = player;
        
        randomGenerate();
    }
    
    /**
     * moveAll iterates through the entire ArrayList in order to execute the move method of each Robot in RoboList
     */
    public void moveAll(){
        for(int i=0; i<RoboList.size();i++)
            RoboList.get(i).move();
    }
    
    /**
     * randomGenerate uses a Spawn chance variable to determine whether or not a new robot will spawn
     * Consider the following: 1 / SpawnChance = % of spawning
     */
    public void randomGenerate(){
        Random rand = new Random();
        
        //Randomly generated value to compare to SpawnChance
        int checkValue = rand.nextInt(SpawnChance)+1;
        //If checkValue (randomly generated from 1 - SpawnChance) is SpawnChance
        if(checkValue == SpawnChance){
            //Then Assign a random area on x axis for new robot x position
            int x = rand.nextInt(w) + 1;
            //Create new robot
            Robot Bot = new Robot(x, 1, RandFuel, p);
            //Add to robolist
            RoboList.add(Bot);
        }
    }
    
    /**
     * isRobot validates the robot object's existence in the RoboList by comparing it with 
     * other robot objects (temporary ones)
     * @param checkX
     * @param checkY
     * @return 
     */
    public boolean isRobot(int checkX, int checkY){
        //Validation switches to make sure the generated robot object is in RoboList
        int x = checkX;
        int y = checkY;
        boolean checkResult = false;

        //Create "temp"
        Robot tempRobot = new Robot(x, y, RandFuel, p);
        
        //Is temp in list?
        for(int i=0; i<RoboList.size();i++){
            if(RoboList.get(i).equals(tempRobot) == true){
                checkResult = true;
            }
        }
        return checkResult;
    }
}
