/*
Dev: Anthony Hake
Last Modified: 3.18.19
Project: Undergraduate Research
*/

/*
TODO:
-Save, Restore, Quit Buttons
    >Save should stream out current board state to a text file local to the application
        ~Do this after moving pieces is accomplished
    >Restore should stream in old board state from text file
        ~Do this after moving pieces is accomplished
-Button Grid: When a button is clicked
    >Check Color
        ~If it is white turn, white pieces can be moved. If it it black turn, black pieces can be moved. 
        ~If it is not that players turn, return piece back to where it was. 
    >Check Piece
        ~Identify spots for that piece to legally move. 
        ~E.G If pawn, it can move once forward, or twice if it's the first move. Or diagonal if there's an enemy. 
    >Check where piece is being moved to
        ~Is your piece already there? Is your opponents piece there? Does it upgrade your pawn? Is it a legal move??
*/
package blessprototype;

//Java.awt.event provides interfaces and classes for dealing with different types of events fired by AWT components
import javax.swing.*;



/**
 *
 * @author User
 */
public class BlessPrototype {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Runnable r = new Runnable()
        {            
            @Override
            public void run()
            {
                ChessGUI cg = new ChessGUI();
                JFrame f = new JFrame("Bless");
                f.add(cg.getGui());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);
                f.pack();
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        //Swing GUIs should be created and updated to maintain concurrency (appear alive)
        SwingUtilities.invokeLater(r);
    }
    
}
