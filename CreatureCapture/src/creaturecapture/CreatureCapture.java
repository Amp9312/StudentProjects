package creaturecapture;
import java.util.*;
/**
 * This application runs the Creature Capture game.
 * @author John Sullins
 */
public class CreatureCapture {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player player;
        Creature creature;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to creature capture!");
        final int WEBCOST = 10;
        final int FORCECOST = 20;
        
        // Construct the player object.
        player = new Player(100);
        
        
        // Main loop, that spawns new creatures and starts capture.
        // Continue until the player has run out of energy.
        while (player.CheckEnergy() > 0) {
            System.out.println("\n\nA new creature has appeared!");
            
            // Set creature to a new instance of your creature class.
            creature = new Creature(false);
            
            
            // Inner loop to capture individual creature.
            // Loop while creature not captured and player has energy left.
            while(creature.GetCaughtOrNot() == false && player.CheckEnergy() > 0) {
                
                // Tell the player how much energy they have left.
                System.out.println("You have exactly: " + player.CheckEnergy() + " energy remaining.");
                
                // Prompt for player action
                System.out.println("You can \nf) Fire a freeze ray\nw) Cast a web \nb) Throw a force bubble");
                System.out.print("What is your choice: ");
                String reply = scanner.nextLine();
                switch (reply) {
                    case "f":
                        // Prompt for the amount to freeze
                        System.out.print("How much energy do you want to use: ");
                        int amount = Integer.parseInt(scanner.nextLine());
                        int cSPD = creature.GetSpeed();
                        int cSTR = creature.GetStrength();

                        //This takes result. Sets it equal to either the energy of the blast, or one of three error conditions
                        int result = player.FreezeRay(amount, cSPD, cSTR);
                        if(creature.freezeRaySuccess(result)){ //Takes energy level, checks that its not negative. Executes.
                            System.out.println("Energy Subtracted. Current Energy Level: " + player.CheckEnergy());
                            System.out.println("The creature appears slower and weaker!");
                            creature.setDecrease(result);
                        }
                        if(result == -199){ //Error condition 1: Creature's strength has fallen below zero.
                            System.out.println("The creature has been frozen!");
                        }
                        if(result == -299){ //Error condition 2: Creature's speed has fallen below zero.
                            System.out.println("The creature has been frozen!");
                        }
                        if(result == -399){ //Error condition 3: Player's energy wasn't high enough.
                            System.out.println("Attempt failed. Player doesn't have enough enegry.");
                        }
                        break;
                        
                    case "w":
                        if(player.WebCast()){ //if player energy greater than cost
                            player.SubtractEnergy(WEBCOST); //subtract that cost from player energy
                            System.out.println("Energy Subtracted. Current Energy Level: " + player.CheckEnergy());
                            if(creature.webCastReact()){ //if creature speed is lower than 5
                                System.out.println("The creature is captured in the web!");
                                creature.setCaughtOrNot(); //set caught to true
                            }
                            else
                                System.out.println("The creature is too fast for your web!"); //creature speed not lower than five
                        }
                        else
                            System.out.println("You don't have enough energy. Casting a web has cost " + WEBCOST); //player energy not high enough

                        break;
                        
                    case "b":
                        if(player.ForceBubble()){
                            player.SubtractEnergy(FORCECOST);
                            System.out.println("Energy Subtracted. Current Energy Level: " + player.CheckEnergy());
                            if(creature.forceBubbleReact()){
                                System.out.println("The creature is trapped in the bubble!");
                                creature.setCaughtOrNot();
                            }
                            else{
                                System.out.println("The creature breaks free of the bubble!");
                            }
                        }
                        else{
                            System.out.println("Yobu don't have enough energy. Casting force bubble has cost: "+ FORCECOST);
                        }                  
                    }  
                        break;                
                }                
                if(creature.GetCaughtOrNot()){
                    int OrgSPD = creature.GetOrgSpeed();
                    int OrgSTR = creature.GetOrgStrength();
                    int BonEnergy = creature.CalcBonusEnergy(OrgSPD, OrgSTR);
                    int CurEng = player.CheckEnergy() + BonEnergy;
                    player.AddEnergy(BonEnergy);
                    System.out.println("Congratz! You've caught it, and earned: " + BonEnergy +" energy!");
                    System.out.println("Current Energy Level: " + CurEng);
                }
                else{
                    System.out.println("The battle goes on!");
                }
            }
        System.out.println("You ran out of energy! Game over!");
    }
}
