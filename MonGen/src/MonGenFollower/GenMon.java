package MonGenFollower;

import com.sun.xml.internal.bind.v2.schemagen.episode.SchemaBindings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//Author Anthony Hake

public class GenMon {
    String Color;
    String Skin;
    String EyeColor;
    String Hairy;
    String HairStyle;
    String HairColor;
    String Name;
    String Personality;
    String AdditionalDetail;
    Scanner scan;

    public void GenMon(String c, String s, String e, String h, String hs, String hc, String n, String p, String ad) {
        Color = c;
        Skin = s;
        EyeColor = e;
        Hairy = h;
        HairStyle = hs;
        HairColor = hc;
        Name = n;
        Personality = p;
        AdditionalDetail = ad;
    }

    public String ObtainQuality(int x) {
        String y;
        if (x == 1)
            y = Color;
        else if (x == 2)
            y = Skin;
        else if (x == 3)
            y = EyeColor;
        else if (x == 4)
            y = Hairy;
        else if (x == 5)
            y = HairStyle;
        else if (x == 6)
            y = HairColor;
        else if (x == 7)
            y = Name;
        else if (x == 8)
            y = Personality;
        else if (x == 9)
            y = AdditionalDetail;
        else
            y = " - Incorrect Parameter - ";

        return y;
    }

    public void getMonQualities() {
        File txt, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9;
        //skin color, skin type, eye color, hair, hair color,
        //hair style, name, personality, additional detail
        String cType = ".\\lib\\skincolor.txt";
        String sType = ".\\lib\\skintype.txt";
        String ecType = ".\\lib\\skincolor.txt";
        String hType = ".\\lib\\hair.txt";
        String hcType = ".\\lib\\skincolor.txt";
        String hsType = ".\\lib\\hairtype.txt";
        String nType = ".\\lib\\name.txt";
        String pType = ".\\lib\\personality.txt";
        String aType = ".\\lib\\additionaldetail.txt";

        if (Color == null) {
            txt = new File(cType);
            try {
                scan = new Scanner(txt);
            } catch (FileNotFoundException ex) {
                System.out.println("Color file not found");
            }
            ArrayList<String> data = new ArrayList<String>();
            while (scan.hasNextLine()) {
                data.add(scan.nextLine());
            }
            String[] simpleArray = data.toArray(new String[]{});
            Random r = new Random();
            int randomNumber = r.nextInt(simpleArray.length);
            Color = simpleArray[randomNumber];
        }

        if (Skin == null) {
            txt2 = new File(sType);
            try {
                scan = new Scanner(txt2);
            } catch (FileNotFoundException ex) {
                System.out.println("Skin type file not found");
            }
            ArrayList<String> data = new ArrayList<String>();
            while (scan.hasNextLine()) {
                data.add(scan.nextLine());
            }
            String[] simpleArray = data.toArray(new String[]{});
            Random r = new Random();
            int randomNumber = r.nextInt(simpleArray.length);
            Skin = simpleArray[randomNumber];
        }

        if (EyeColor == null) {
            txt3 = new File(ecType);
            try {
                scan = new Scanner(txt3);
            } catch (FileNotFoundException ex) {
                System.out.println("Eye color file not found");
            }
            ArrayList<String> data = new ArrayList<String>();
            while (scan.hasNextLine()) {
                data.add(scan.nextLine());
            }
            String[] simpleArray = data.toArray(new String[]{});
            Random r = new Random();
            int randomNumber = r.nextInt(simpleArray.length);
            EyeColor = simpleArray[randomNumber];
        }
        if (Hairy == null) {
            txt4 = new File(hType);
            try {
                scan = new Scanner(txt4);
            } catch (FileNotFoundException ex) {
                System.out.println("Hair file not found");
            }
            ArrayList<String> data = new ArrayList<String>();
            while (scan.hasNextLine()) {
                data.add(scan.nextLine());
            }
            String[] simpleArray = data.toArray(new String[]{});
            Random r = new Random();
            int randomNumber = r.nextInt(simpleArray.length);
            Hairy = simpleArray[randomNumber];
        }

        if (ObtainQuality(4).equals("yes")) {
            if (HairStyle == null) {
                txt6 = new File(hsType);
                try {
                    scan = new Scanner(txt6);
                } catch (FileNotFoundException ex) {
                    System.out.println("Hair style file not found.");
                }
                ArrayList<String> data = new ArrayList<String>();
                while (scan.hasNextLine()) {
                    data.add(scan.nextLine());
                }
                String[] simpleArray = data.toArray(new String[]{});
                Random r = new Random();
                int randomNumber = r.nextInt(simpleArray.length);
                HairStyle = simpleArray[randomNumber];
            }


        }
        if (ObtainQuality(4).equals("yes")) {
            if (HairColor == null) {
                txt5 = new File(hcType);
                try {
                    scan = new Scanner(txt5);
                } catch (FileNotFoundException ex) {
                    System.out.println("Hair Color File Not Found");
                }
                ArrayList<String> data = new ArrayList<String>();
                while (scan.hasNextLine()) {
                    data.add(scan.nextLine());
                }
                String[] simpleArray = data.toArray(new String[]{});
                Random r = new Random();
                int randomNumber = r.nextInt(simpleArray.length);
                HairColor = simpleArray[randomNumber];
            }
        } else if (ObtainQuality(4).equals("no")) {
            HairColor = "none";
            HairStyle = "none";
        }


        if (Name == null) {
            txt7 = new File(nType);
            try {
                scan = new Scanner(txt7);
            } catch (FileNotFoundException ex) {
                System.out.println("Name File Not Found");
            }
            ArrayList<String> data = new ArrayList<String>();
            while (scan.hasNextLine()) {
                data.add(scan.nextLine());
            }
            String[] simpleArray = data.toArray(new String[]{});
            Random r = new Random();
            int randomNumber = r.nextInt(simpleArray.length);
            Name = simpleArray[randomNumber];
        }

        if (Personality == null) {
            txt8 = new File(pType);
            try {
                scan = new Scanner(txt8);
            } catch (FileNotFoundException ex) {
                System.out.println("Personality file not found");
            }
            ArrayList<String> data = new ArrayList<String>();
            while (scan.hasNextLine()) {
                data.add(scan.nextLine());
            }
            String[] simpleArray = data.toArray(new String[]{});
            Random r = new Random();
            int randomNumber = r.nextInt(simpleArray.length);
            Personality = simpleArray[randomNumber];
        }

        if (AdditionalDetail == null) {
            txt9 = new File(aType);
            try {
                scan = new Scanner(txt9);
            } catch (FileNotFoundException ex) {
                System.out.println("Additional detail file not found");
            }
            ArrayList<String> data = new ArrayList<String>();
            while (scan.hasNextLine()) {
                data.add(scan.nextLine());
            }
            String[] simpleArray = data.toArray(new String[]{});
            Random r = new Random();
            int randomNumber = r.nextInt(simpleArray.length);
            AdditionalDetail = simpleArray[randomNumber];


        }
    }

    public void generateTest() {
        System.out.println("You spot a monster! It hast the following qualities.\n"
                + "Color: " + Color
                + "\nSkin: " + Skin
                + "\nEye Color: " + EyeColor
                + "\nHairy: " + Hairy
                + "\nHair Style: " + HairStyle
                + "\nHair Color: " + HairColor
                + "\nName: " + Name
                + "\nPersonality: " + Personality
                + "\nAdditional Detail: " + AdditionalDetail);
    }

    public void obtainQualityTest() {
        System.out.println("You notice it is a: " + ObtainQuality(5));
    }


    /**
     * This is where the emotional FSM begins
     */

    static abstract class State {
        protected Scanner input = new Scanner(System.in);
        protected Random random = new Random();

        public State() {
        }

        public abstract void enter();

        public abstract void exit();

        public abstract int check();
    }
    //Start 0
    static class Start extends State {
        public Start() {
            super();
        }

        public void enter() {
            System.out.println("You found a monster! (Or did it find you?");
        }

        public void exit() {
            System.out.println("It shifts it's stance");
        }

        public int check() {
            String Start_moodINT = "";
            System.out.println("You proclaim your name in front of it, hoping it understands english.\n");
            Start_moodINT = input.nextLine();
            System.out.println("You tell it your name is: " + Start_moodINT + ".");
            //return to Interested later
            return 1;
        }
    }

    //Interested 1
    class Interested extends State {
        public Interested() {
            super();
        }

        public void enter() {
            System.out.println("This monster is showing interest!");
        }

        public void exit() {
            System.out.println("It scratches it's ear");
        }

        public int check() {
            int Interested_moodINT = 0;
            System.out.println("After the initial prompt, it isn't sure where to go from here. So you: \n" +
                    "1 - You show it your adventuring gear, peaking it's interest.\n" +
                    "2 - You make faces at it, hoping to entertain it.\n" +
                    "3 - Noticing it's a " + ObtainQuality(8) + "you imitate it!");
            Interested_moodINT = input.nextInt();
            if (Interested_moodINT == 1) {
                System.out.println("It indeed curious about what gear you brought along on your adventure!");
                //Return to Curious
                return 3;
            } else if (Interested_moodINT == 2) {
                System.out.println("Not quite sure what is happening, it looks the other direction.");
                //Return to Unsure
                return 2;
            } else if (Interested_moodINT == 3) {
                System.out.println("Amused by your imitation, it is flattered immensely!");
                //Return to Flattered
                return 6;
            } else {
                System.out.println("It has no idea what you're on about");
                return 1;
            }
        }
    }

    //Unsure 2
    class Unsure extends State {
        public Unsure() {
            super();
        }

        public void enter() {
            System.out.println("This monster seems very unsure.");
        }

        public void exit() {
            System.out.println("It is no longer unsure!");
        }

        public int check() {
            int Unsure_moodINT = 0;
            System.out.println("Sitting there it waits for you to respond or do something\n" +
                    "1 - You tell it of all the beasts you've slain\n" +
                    "2 - You tell it the story of the highest mountain you've climbed\n" +
                    "3 - You ask it if it has any friends that it goes on adventures with?\n");
            Unsure_moodINT = input.nextInt();
            if (Unsure_moodINT == 1) {
                System.out.println("It did not care for that very much");
                //Return to indifferent
                return 5;
            } else if (Unsure_moodINT == 2) {
                System.out.println("It sits in awe as you proclaim the heights you've seen");
                //Return to amazed
                return 4;
            } else if (Unsure_moodINT == 3) {
                System.out.println("It nods excitedly, jabbering on about all the fun it's had with others");
                //Return to excited
                return 14;
            } else {
                System.out.println("It has no clue what you're on about");
                return 1;
            }
        }
    }

    //Curious 3
    class Curious extends State {
        public Curious() {
            super();
        }

        public void enter() {
            System.out.println("You're not sure what you did, but it is definitely curious!");
        }

        public void exit() {
            System.out.println("Curiousity fading, it notices a leaf blowing in the wind");
        }

        public int check() {
            int Curious_moodINT = 0;
            System.out.println("While you have it's attention you: \n" +
                    "1 - Show off your favorite weapon!\n" +
                    "2 - Ask it how it hunts?\n");
            Curious_moodINT = input.nextInt();
            if (Curious_moodINT == 1) {
                System.out.println("In awe of it's magnificence, how exactly you may have used it for goes ignored");
                //return to Amazed
                return 4;
            } else if (Curious_moodINT == 2) {
                System.out.println("It demonstrates how it sneaks up on it's prey, which amuses you");
                //return to Talkative
                return 11;
            } else {
                System.out.println("It has no idea what you're on about");
                return 3;
            }
        }
    }

    //Amazed 4
    class Amazed extends State {
        public Amazed() {
            super();
        }

        public void enter() {
            String checkAttrib = ObtainQuality(9);
            if (checkAttrib.equals("Playful")) {
                System.out.println("It wants to imitate what you did, and makes a fool of itself by doing so");
            } else if (checkAttrib.equals("Careful")) {
                System.out.println("Despite being amazed, it still has a very timid approach");
            } else if (checkAttrib.equals("Jumpy")) {
                System.out.println("In shock of your recent performance it jumps nearly a foot high!");
            } else {
                System.out.println("It's clearly amazed by whatever that just was.");
            }
        }

        public void exit() {
            System.out.println("It is no longer amazed, probably not your fault");
        }

        public int check() {
            int Amazed_moodINT;
            System.out.println("While you have it's attention, you have an opportunity to: \n" +
                    "1 - Tell it how it reminds you of a dragon you once slayed\n" +
                    "2 - Play a game of tag!\n" +
                    "3 - Give it your favorite cloak.\n");
            Amazed_moodINT = input.nextInt();
            if (Amazed_moodINT == 1) {
                System.out.println("It doesn't seem very amused by your story.");
                //Return to Unsure
                return 2;
            }
            if (Amazed_moodINT == 2) {
                System.out.println("Smiling and laughing, it gives chase as a game of tag commences!");
                //Return to Infatuated
                return 7;
            }
            if (Amazed_moodINT == 3) {
                System.out.println("At a complete loss for reaction, it does nothing but look at you.");
                //Return to head over heels
                return 8;
            } else {
                System.out.println("It has no idea what you're on about");
                return 4;
            }
        }
    }

    //Indifferent 5
    class Indifferent extends State {
        public Indifferent() {
            super();
        }

        public void enter() {
            System.out.println("It doesn't seem to be paying attention");
        }

        public void exit() {
            System.out.println("It's no longer indifferent.");
        }

        public int check() {
            int Indifferent_moodINT = 0;
            System.out.println("You notice it's indifference, so you: \n" +
                    "1 - Call it stinky and plug your nose\n" +
                    "2 - Compliment how " + ObtainQuality(2) + " it's skin is\n" +
                    "3 - Brag about how easily you could beat it in a battle!\n");
            Indifferent_moodINT = input.nextInt();
            if (Indifferent_moodINT == 1) {
                System.out.println("It thinks you're being mean, and scowls at you.");
                //Return to Annoyed
                return 9;
            } else if (Indifferent_moodINT == 2) {
                System.out.println("Suprised by the nice comment, it is clearly flattered!");
                //Return to Flattered
                return 6;
            } else if (Indifferent_moodINT == 3) {
                System.out.println("It doesn't like that all too much.");
                //Return to Unsure
                return 2;
            } else {
                System.out.println("It has no idea what you're on about");
                return 5;
            }
        }
    }

    //Flattered 6
    class Flattered extends State {
        public Flattered() {
            super();
        }

        public void enter() {
            System.out.println("It darts it's eyes, clearly flattered by what you said.");
        }

        public void exit() {
            System.out.println("They're done being flattered");
        }

        public int check() {
            int Flattered_moodINT = 0;
            System.out.println("It sits in a daze, so you follow up your blatant flattery by:\n" +
                    "1 - Striking a cool pose!\n" +
                    "2 - Ask if they'd change their hair from " + ObtainQuality(6) + " to any other color?");
            Flattered_moodINT = input.nextInt();
            if (Flattered_moodINT == 1) {
                System.out.print("Your pose, while kinda cool, didn't impress it too much. It is intrigued how you bent your leg that way though?");
                return 1;
            }
            if (Flattered_moodINT == 2) {
                if (ObtainQuality(4).equals("no")) {
                    System.out.println("It doesnt have any hair, so it thinks you're mocking it.");
                    //Return to annoyed
                    return 9;
                } else {
                    System.out.println("It thinks you don't like it's hair color, and that you're making fun of it.");
                    //return to Embarrased
                    return 10;
                }
            } else {
                System.out.println("It has no idea what you're on about");
                return 6;
            }
        }
    }

    //Infatuated 7
    class Infatuated extends State {
        public Infatuated() {
            super();
        }

        public void enter() {
            System.out.println("Given it's current posture, it's clearly infatuated.");
        }

        public void exit() {
            System.out.println("It is no longer infatuated");
        }

        public int check() {
            int Infatuated_MoodINT = 0;
            System.out.println("While it stands and admires you, you have the chance to do one of the following: \n" +
                    "1 - Ask if any of it's friends go on adventures?\n" +
                    "2 - Tell it you think it'd make a great companion!\n");
            Infatuated_MoodINT = input.nextInt();
            if (Infatuated_MoodINT == 1) {
                System.out.println("Excited to tell you about it's adventures, it starts listing off all the times it adventured with friends.");
                //Return to Excited
                return 14;
            } else if (Infatuated_MoodINT == 2) {
                System.out.println("It's amazed that you think it's worthy of being your companion!");
                //return to H.O.H
                return 8;
            } else {
                System.out.println("It has no idea what you're on about");
                return 7;
            }
        }
    }

    //HeadOverHeels 8
    class HeadOverHeels extends State {
        public HeadOverHeels() {
            super();
        }

        public void enter() {
            System.out.println("It's completely head over heels about you!");
        }

        public void exit() {
            //no exit message
        }

        public int check() {
            int HeadOverHeels_moodINT = 0;
            System.out.println("It bounces excitedly, ready to take off at any point. What do you do?\n" +
                    "1 - Pat it on the head, ruffling it's " + ObtainQuality(2) + " skin, telling it to come along.\n" +
                    "2 - You say you knew all along it'd join you! \n" +
                    "3 - Strike yet another nonsensical hero pose\n");
            HeadOverHeels_moodINT = input.nextInt();
            if (HeadOverHeels_moodINT == 1) {
                System.out.println("It pushes against your hand, ready to go!");
                //Return to Win State
                return 15;
            } else if (HeadOverHeels_moodINT == 2) {
                System.out.println("It thinks you're a little conceited, and isn't so sure.");
                //return to Unsure
                return 2;
            } else if (HeadOverHeels_moodINT == 3) {
                System.out.println("It's not sure what you're doing, but it is amazed anyways!");
                //return to amazed
                return 4;
            } else {
                System.out.println("It has no idea what you're on about");
                return 8;
            }
        }
    }

    //Annoyed 9
    class Annoyed extends State {
        public Annoyed() {
            super();
        }

        public void enter() {
            System.out.println("Annoyed, it makes a mean face at you");
        }

        public void exit() {
            System.out.println("It is no longer annoyed");
        }

        public int check() {
            int Annoyed_moodINT = 0;
            System.out.println("Perturbed by the face it makes, how have the following options: \n" +
                    "1 - Noting the face it makes, you flick it on the nose\n" +
                    "2 - Seeing the face it makes, you make a face back\n");

            Annoyed_moodINT = input.nextInt();
            if (Annoyed_moodINT == 1) {
                System.out.println("It did not like that at all");
                //Return to Angry
                return 12;
            } else if (Annoyed_moodINT == 2) {
                System.out.println("Noticing you mimicking it, it is quite amused");
                //Return to Sassy
                return 13;
            } else {
                System.out.println("It has no idea what you're on ahout");
                return 8;
            }
        }
    }

    //Embarrassed 10
    class Embarrassed extends State {
        public Embarrassed() {
            super();
        }

        public void enter() {
            System.out.println("Since it is " + ObtainQuality(8) + " it: ");
            if (ObtainQuality(8).equals("Sassy")) {
                System.out.println("Immediately jumps to being sassy!");
                //return Sassy
            } else if (ObtainQuality(8).equals("Brave")) {
                System.out.println("Scowls defiantly!");
            } else if (ObtainQuality(8).equals("Secretive")) {
                System.out.println("Attempts to hide it's face");
            } else if (ObtainQuality(8).equals("Timid")) {
                System.out.println("It jumps back, trying to hide");
            } else if (ObtainQuality(8).equals("Wild")) {
                System.out.println("It jumps forward, trying to hit you!");
            } else {
                System.out.println("It is quite embarassed");
            }
        }

        public void exit() {
            System.out.println("It is no longer embarassed");
        }

        public int check() {
            int Embarassed_moodINT = 0;
            System.out.println("You notice it is hurt and embarassed, so you: \n" +
                    "1 - You apologize and begin to tell it a story!\n" +
                    "2 - Say it deserved it.\n" +
                    "3 - Tell it it'd look a lot better if it had your hair color!\n");
            Embarassed_moodINT = input.nextInt();
            if (Embarassed_moodINT == 1) {
                System.out.println("It accepts your apology, and it listens attentively to your story");
                //return to talkative
                return 11;
            } else if (Embarassed_moodINT == 2) {
                System.out.println("It disagrees, and implies no one deserves that kind of treatment");
                //return to Annoyed
                return 10;
            } else if (Embarassed_moodINT == 3) {
                System.out.println("It tells you that your hair color is stupid!");
                //return to Sassy
                return 13;
            } else {
                System.out.println("It has no idea what you're on about");
                return 10;
            }
        }
    }

    //Talkative 11
    class Talkative extends State {
        public Talkative() {
            super();
        }

        boolean infat, unsure, excited, talkative;

        public void enter() {

            int UserInput;
            System.out.println("It asks you what your hair color is!\n" +
                    "1 - Red\n" +
                    "2 - Brown\n" +
                    "3 - Black\n" +
                    "4 - Gray\n" +
                    "5 - Other\n");
            UserInput = input.nextInt();
            if (UserInput == 1 || UserInput == 2 || UserInput == 3 || UserInput == 4) {
                System.out.println("It's excited that you have the same hair color!");
                excited = true;
            } else if (UserInput == 5) {
                String UserInput2;
                System.out.println("Doesn't quite understand, so it asks you if you like it's name: " +
                        ObtainQuality(7) + " (y/n)?");
                UserInput2 = input.nextLine();
                if (UserInput2.equals("y")) {
                    System.out.println("It's super happy that you like it's name!");
                    infat = true;
                } else if (UserInput2.equals("n")) {
                    System.out.println("Its not sure why you would say something like that");
                    unsure = true;
                }
            } else {
                System.out.println("It didn't understand you one bit!");
                talkative = true;
            }
        }

        public void exit() {
            //nothing here
        }

        public int check() {
            if (infat == true) {
                //return infatuated
                return 7;
            } else if (talkative == true) {
                //return talkative
                return 11;
            } else if (unsure == true) {
                //return unsure
                return 2;
            } else if (excited == true) {
                //return excited
                return 14;
            } else {
                //return talkative
                infat = false;
                talkative = false;
                unsure = false;
                excited = false;
            }

            return 11;
        }


    }

    //Angry 12
    class Angry extends State {
        public Angry() {
            super();
        }

        public void enter() {
            System.out.println("The monster tries to bite you!");
        }

        public void exit() {
            System.out.println("It is no longer angry");
        }

        public int check() {
            int Angry_moodINT = 0;
            System.out.println("Before it bites you, you have enough time to make a decision. So you: \n" +
                    "1 - Smack it aside \n" +
                    "2 - Dodge the bite \n" +
                    "3 - Snarl back, attempting to spook it\n");
            Angry_moodINT = input.nextInt();
            if (Angry_moodINT == 1) {
                System.out.println("You've made a grave mistake.");
                //return to lose
                return 16;
            } else if (Angry_moodINT == 2) {
                System.out.println("Successfully dodging it, you find it a little ticked off.");
                //return to annoyed
                return 9;
            } else if (Angry_moodINT == 3) {
                System.out.println("It's impressed with your snarl, and backs up some.");
                //return to sassy
                return 13;
            } else {
                System.out.println("It has no idea what you're on about");
                return 12;
            }
        }
    }

    //Sassy 13
    class Sassy extends State {
        public Sassy() {
            super();
        }

        public void enter() {
            String personCheck = ObtainQuality(8);
            if (personCheck.equals("Sassy")) {
                System.out.println("It makes rude remarks about your ruined adventuring clothes, noting the scorch marks");
            } else if (personCheck.equals("Gentle")) {
                System.out.println("It apologizes for it's rude remarks, but you aren't sure if it means it.");
            } else if (personCheck.equals("Lonely")) {
                System.out.println("It points out that quite like itself, you too are very lonely.");
            } else if (personCheck.equals("Mild")) {
                System.out.println("It insults you once, and then twice, but the second insult isn't as good.");
            } else {
                System.out.println("It becomes very sassy!");
            }
        }

        public void exit() {
            System.out.println("It has seemingly worked all of the sassyness out of it's system.");
        }

        public int check() {
            int Sassy_moodINT = 0;
            System.out.println("Standing in defiance, it cocks it's head in bewilderment at you as it taunts. You: \n" +
                    "1 - Mock it for acting so prissy\n" +
                    "2 - Laugh in a jaunty manner, and dance around amusingly\n");
            Sassy_moodINT = input.nextInt();
            if (Sassy_moodINT == 1) {
                System.out.println("Noting your mockery, you notice it isn't very happy with you");
                return 9;
            } else if (Sassy_moodINT == 2) {
                System.out.println("Seeing joyful and playful you are, it decides to drop whatever made it so moody!");
                return 14;
            } else {
                System.out.println("It has no idea what you're on about");
                return 13;
            }
        }

    }

    //Excited 14
    class Excited extends State {
        public Excited() {
            super();
        }

        public void enter() {
            System.out.println("You notice the monster is very excited");
        }

        public void exit() {
            System.out.println("The monster is no longer excited");
        }

        public int check() {
            int Excited_moodINT = 0;
            System.out.println("Seeing it so excited makes you wanna: \n" +
                    "1 - Make fun of it for bouncing around so childishly\n" +
                    "2 - Ask it why it looks so weird \n" +
                    "3 - Make a joe at your own expense\n");
            Excited_moodINT = input.nextInt();
            if (Excited_moodINT == 1) {
                System.out.println("It notices you making fun of it, and it gets grumpy");
                //return to sassy
                return 13;
            } else if (Excited_moodINT == 2) {
                System.out.println("It doesn't think it looks weird. It thinks you look weird!");
                //return to unsure
                return 2;
            } else if (Excited_moodINT == 3) {
                System.out.println("It laughs mirthfully at the joke, not understanding the background behind it");
                //return to infatuated
                return 7;
            } else {
                System.out.println("It has no idea what you're on about");
                return 14;
            }
        }
    }

    //Win 15
    class Win extends State {
        public Win() {
            super();
        }

        public void enter() {
            System.out.println("Congrats! It has decided to follow you on your quest");
        }

        public void exit() {
            System.out.println("That is all folks, thats the game!");
        }

        public int check() {
            return 0;
        }
    }

    //Lose 16
    class lose extends State {
        public lose() {
            super();
        }

        public void enter() {
            System.out.println("After barely surviving a fight with it, you decide you don't want a monster companion.");

        }

        public void exit() {
            System.out.println("You've lost the game");
        }

        public int check() {
            return 0;
        }
    }

    public void runGame(){
        int stateNum = 17;
        State[] states = new State[stateNum];

        states[0] = new Start();
        states[1] = new Interested();
        states[2] = new Unsure();
        states[3] = new Curious();
        states[4] = new Amazed();
        states[5] = new Indifferent();
        states[6] = new Flattered();
        states[7] = new Infatuated();
        states[8] = new HeadOverHeels();
        states[9] = new Annoyed();
        states[10] = new Embarrassed();
        states[11] = new Talkative();
        states[12] = new Angry();
        states[13] = new Sassy();
        states[14] = new Excited();
        states[15] = new Win();
        states[16] = new lose();

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
