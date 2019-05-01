/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsm_bartender;
import java.util.*;
/**
 *
 * @author User
 */
public class FSM_Bartender {
    //values to check the validity of a end game state
    public static boolean EndGame = false;
    public static boolean happyEnd = false;
    
    /**
     * State is an abstract class in which all other states in this FSM derive from
     */
    public static abstract class State{
        protected Scanner input = new Scanner(System.in);
        protected Random random = new Random();
        public State(){}
        public abstract void enter();
        public abstract void exit();
        public abstract int check();
    }
    /**
     * Neutral is the state you go to when your response isn't remarkably positive or negative. It's also where you start.
     */
    public static class Neutral extends State{
    public Neutral(){super();}
    public void enter(){
        System.out.println("The bartender waits patiently, washing his glass.");
    }
    public void exit(){
        System.out.println("He adjusts his stance.");
    }
    public int check(){
        int moodINT = 0;
        System.out.println("Despite your lack of sobriety, you still want that drink. Approach?\n"
                + " 1 - Compliment his unform\n"
                + " 2 - Tell him he's the finest brewer in the state\n"
                + " 3 - Remind him his bar is a business and needs your monetary contributionn\n"
                + " 4 - Tell him to get you a drink before you kick his ###");
                moodINT = input.nextInt();
                if(moodINT == 1){
                    System.out.println("He smirks, and tells you you've clearly been drinking too much.\n"
                            + "However his mood is noticibly improved.");
                    return 2; //go to interested state
                }    
                if(moodINT == 2){
                    System.out.println("He gives a bawdy guffaw, and slaps his robust stomach. \n"
                            + "His mood is improved greatly");
                    return 1; //go to chummy state
                }
                if(moodINT == 3){
                    System.out.println("Frowning, he furrows his brows and reminds you that you're not the only business he receives. \n"
                            + "His mood declines.");
                    return 3; 
                }
                if(moodINT == 4){
                    System.out.println("He stomps off to angrily serve another customer, not saying a word to you.\n"
                            + "His mood is noticibly worse");
                    return 4;
                }
                else{
                    System.out.println("Your response is beligerent and unintelligble. Better try again.");
                    return 0;
                }
            }
    }
    
    /**
     * Chummy is the positive state you enter before Friendly. 
     */
    public static class Chummy extends State{
    public Chummy(){super();}
    public void enter(){
        System.out.println("He's still happy about what you said about him. He asks what your favorite brew is.");
    }
    public void exit(){
        System.out.println("He gestures to you, getting your attention.");
    }
    public int check(){
        int chummy_moodINT = 0;
        System.out.println("Almost being able to feel the crisp hoppy taste on your tongue, you respond with: \n"
                + "1 - 'A locally brewed IPA is always the best choice!'\n"
                + "2 - 'Who cares? Beer is beer!'\n");
                chummy_moodINT = input.nextInt();
                if(chummy_moodINT == 1){
                    System.out.println("Slapping you on the shoulder, he tells you that you're a good lad and slides you a mug.");
                    happyEnd = true;
                    return 6; //go to friendly
                }
                if(chummy_moodINT == 2){
                    System.out.println("Noticing your blatant lack of tact, he pulls away suddenly.\n"
                            + "His Mood is noticably worse.");
                    return 2; //go to interested
                }
                else{
                    System.out.println("Your response is beligerent and unintelligble. Better try again.");
                    return 0;
                }
    }
    }
    
    /**
     * Interested is the positive/neutral state you enter when recovering from Annoyed state, or choosing a negative respond in Interested state.
     * Also a possible option while in Neutral State
     */
    public static class Interested extends State{
        public Interested(){super();}
        public void enter(){
            System.out.println("He shows interest, but picks up his glass and continues to clean it.\n");
        }
        public void exit(){
            System.out.println("Putting the glass back down, he turns to face you fully.");
        }
        public int check(){
            int interested_moodINT = 0;
            System.out.println("You've grabbed his interest. What exactly do you like about his uniform\n"
                    + "1 - 'I uhhhhhh like the shiny buttons'\n"
                    + "2 - You make note how his apron makes him look more professional");
                    interested_moodINT = input.nextInt();
                    if(interested_moodINT == 1){
                        System.out.println("He looks a little annoyed, he thinks you're just trying to trick him./n"
                                + "His Mood noticably worsens");
                        return 3; //go to annoyed
                    }
                    if(interested_moodINT == 2){
                        System.out.println("Looking down at his apron, he nods and agrees with you.\n"
                                + "The interaction was remarkably wholesome given the circumstances.\n"
                                + "His mood noticably improves.");
                        return 1; //go to interested
                    }
                    else{
                        System.out.println("Your response is beligerent and unintelligble. Better try again.");
                        return 0;
                    }
        }
    }
    
    /**
     * Annoyed is the negative/neutral state you enter when recovering from Aggravated state, or choosing a negative response in Interested state. 
     * Also a possible option while in the Neutral state.
     */
    public static class Annoyed extends State{
        public Annoyed(){super();}
        public void enter(){
            System.out.println("Whatever it was you just did, he didn't like that one bit.\n");
        }
        public void exit(){
            System.out.println("He doesn't seem as annoyed anymore.");
        }
        public int check(){
            int annoyed_moodINT = 0;
            System.out.println("He crackes his knuckles a couple of times, not menancing enough but enough to send a message. What do you do?\n"
                    + "1 - Pester him further. Maybe if you annoy him enough he'll give in.\n"
                    + "2 - Leave him alone for a bit, you've bothered him enough.\n"
                    + "3 - Apologize for your ignorance, say his fine brew is going to your head.");
               annoyed_moodINT = input.nextInt();
               if(annoyed_moodINT == 1){
                   System.out.println("At this point, he's gritting his teeth and clenching and unclenching his fists.\n"
                           + "Consider any trace of a good mood gone.");
                   return 4; //Aggravated
               }
               if(annoyed_moodINT == 2){
                   System.out.println("By leaving him alone, he's forgotten about you and returned to his usual self.\n"
                           + "His mood is unreadable, an almost absolute state of neutrality.");
                   return 0; //go to neutral
               }
               if(annoyed_moodINT == 3){
                   System.out.println("He takes your apology swiftly, enjoying the compliment about the beer. He still doesn't give you one, however.\n"
                           + "His mood is moderately improved.");
                   return 2; // go to interested
               }
               else{
                   System.out.println("Your response is beligerent and unintelligble. Better try again.");
                    return 0;
               }
        }
    }
    
    /**
     * Aggravated is the negative state you enter before EndGame
     */
    public static class Aggravated extends State{
        public Aggravated(){super();}
        public void enter(){
            System.out.println("Whatever you've done or said has truly and royally ticked him off. One more wrong move and you just might be outta here.");
        }
        public void exit(){
            System.out.println("...");
        }
        public int check(){
            int Aggravated_moodINT = 0;
            System.out.println("You've pushed him to nearly his breaking point. Despite your best efforts, that last bottle seems to be getting farther and farther away.\n"
                    + "1 - In one last attempt to plead your case, you tell him you'll pay double what he usually charges!\n"
                    + "2 - You've about had it with waiting around with him, you tell him either he slides you a cold one or you walk.");
                Aggravated_moodINT = input.nextInt();
                if(Aggravated_moodINT == 1){
                    System.out.println("He tells you that won't be necessary, considering he won't sell for more than it's worth.\n"
                            + "His temper seems to have settled slightly.");
                    return 3; //go to annoyed
                }
                if(Aggravated_moodINT == 2){
                    System.out.println("He tells you to leave his bar, and don't come back until you sober up.");
                    EndGame = true;
                    return 5; //go to end game
                }
                else{
                   System.out.println("Your response is beligerent and unintelligble. Better try again.");
                    return 0;
               }
        }
    }
    
    /**
     * EndGame is the negative ending, resulting in a GameOver.
     */
    public static class EndGame extends State{
        public EndGame(){super();}
        public void enter(){
            System.out.println("You've failed to get another drink, and all the other bars are closed at this hour.\n"
                    + "Game Over");
        }
        public void exit(){
            System.out.println("Maybe you'll get that drink next time!");
    }
        public int check(){
            if(EndGame == true || happyEnd == false){return 0;}
            else
            {
                System.out.println("How did you get here?");
                return 0;
        }
        }
        
}   /**
    * Friendly is the positive ending, resulting in a Game Win!
    */
    public static class Friendly extends State{
        public Friendly(){super();}
        public void enter(){
            System.out.println("With a large grin on his face, he pours a cold one straight from the pitcher!");
        }
        public void exit(){
            System.out.println("Accepting the mug of his finest IPA, you grin back and drink.\n"
                    + "Mission Complete!");
        }

        public int check(){
            if(happyEnd == true || EndGame == false)
                return 0;
            else{
                System.out.println("How did you get here?");
                return 0;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int stateNum = 7;
        State[] states = new State[stateNum];
        
        states[0] = new Neutral();
        states[1] = new Chummy();
        states[2] = new Interested();
        states[3] = new Annoyed();
        states[4] = new Aggravated();
        states[5] = new EndGame();
        states[6] = new Friendly();
    
        int currentState = 0;
        int nextState;
    
        states[0].enter();
        while(true){
            nextState = states[currentState].check();
            if(nextState!=currentState){
                states[currentState].exit();
                currentState = nextState;
                states[currentState].enter();
                
            }
        }   
    }
}
