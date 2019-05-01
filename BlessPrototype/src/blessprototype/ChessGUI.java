package blessprototype;

//.javax.swing provides a lightweight set of components that are used in the application
import javax.swing.*;
//.java.awt is responsible for all the classes in which create UI. Also responsible for graphics
import java.awt.*;
//.java.net.URL is used to pull resources from the internet
import java.net.URL;
//.image.BufferedImage describes an image using an accessible buffer of image data
import java.awt.image.BufferedImage;
//.javax.imageio.ImageIO is a class that utilizes ImageReaders and ImageWriters, as well as performing simple encoding and decoding
import javax.imageio.ImageIO;
//.javax.swing.border provides the classes and interface for drawing specialized borders around a swing component
import javax.swing.border.*;
//.java.awt.event Provides interfaces and classes for dealing with different types of events fired by AWT components
import java.awt.event.*;


public class ChessGUI {
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    
    //array of buttons for each available space
    public JButton[][] chessBoardSquares= new JButton[8][8]; //Define button array
    /*for(int i = 0; i < 8; i++)
        for(int j = 0; j < 8; j++){
            chessBoardSquares.addActionListener(this);
}*/
    //Possible images stored in an array of 2x6 in accordinance to the image used
    private Image[][] chessPieceImages = new Image[2][6];
    private JPanel chessBoard;
    //Initilizate status message
    private final JLabel message = new JLabel("Welcome to Bless!");
    private static final String COLS = "ABCDEFGH";
    public static final int QUEEN = 0, KING = 1,
            ROOK = 2, KNIGHT = 3, BISHOP = 4, PAWN = 5;
    public static final int[] STARTING_ROW = 
    {
        ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK
    };

    public static final int BLACK = 0, WHITE = 1;
    
    ChessGUI()
    {
        initializeGUI();
        //End of ChessGUI
    }
    
    public final void initializeGUI()
    {       
        /*Create Button Array
        for (int x = 0; x < 8; x++)
            for(int y = 0; y < 8; y++)
                chessBoardSquares[x][y] = new JButton();
                
        for(int x=0; x < 8; x++)
            for(int y=0; y<8;y++)
            {
                final int ROW = x;
                final int COLUMN = y;
                chessBoardSquares[x][y].addActionListener;
                {
                    new ActionListener()
                    {
                        public void actionPerformed(ActionEvent AE)
                        {
                            //Chess Logic Here
                           
                        }
                    }
                }
            }*/
        
        // Summon image for pieces from the spooky internet
        createImages();
        
        //set up main user interface
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        // Set up JFrames Toolbar
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        
        //Set up "New Game" button Functionality
        Action newGameAction = new AbstractAction("New")
        {            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setupNewGame();
            }
        };

        //Add buttons to toolbar
        tools.add(newGameAction);
        tools.add(new JButton("Save"));
        tools.add(new JButton("Restore"));
        tools.addSeparator();
        tools.add(message);
        
        //This is just reserving space for "Captured pieces" or some sort of point system
        gui.add(new JLabel("TEST"), BorderLayout.LINE_START);
        
        //Establish dimensions for UI
        chessBoard = new JPanel(new GridLayout(0, 9)){
            // Here I override the preferred size to return the largest it can
            // Must be added to a GridBagLayout as the only component, with no
            // constraint so it is centered
            @Override
            public final Dimension getPreferredSize()
            {
                Dimension d = super.getPreferredSize();
                Dimension prefSize = null;
                Component c = getParent();
                
                if(c == null)
                {
                    prefSize = new Dimension((int)d.getWidth(), (int)d.getHeight());
                }
                else if(c!=null && c.getWidth()> d.getWidth() && c.getHeight() > d.getHeight())
                {
                    prefSize = c.getSize();
                }
                else
                {
                    prefSize = d;
                }
                //maintain square shape
                int w = (int) prefSize.getWidth();
                int h = (int) prefSize.getHeight();
                //"Which is the smaller of the two?"
                int s = (w>h ? h : w);
                return new Dimension(s,s);
            }
        };
        
        //Visual border frame for visual organization
        chessBoard.setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8), new LineBorder(Color.BLACK)));
        //Background of board
        chessBoard.setBackground(Color.gray);
        JPanel boardConstrain = new JPanel(new GridBagLayout());
        //Background of frame
        boardConstrain.setBackground(Color.red);
        boardConstrain.add(chessBoard);
        gui.add(boardConstrain);
        
        // Create the chess board tiles
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for(int ii = 0; ii < chessBoardSquares.length; ii++)
        {
            for(int jj = 0; jj < chessBoardSquares[ii].length; jj++)
            {
            JButton b = new JButton();
            b.setMargin(buttonMargin);
            // These chess pieces are 64x64. Transparent icons fill this space. 
            ImageIcon icon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
            b.setIcon(icon);
            // This conditional recreates the board in a series of black/white checkers
            if((jj % 2 == 1 && ii % 2 == 1) || (jj % 2 == 0 && ii % 2 == 0))
            {
                b.setBackground(Color.white);
            }
            else{
                b.setBackground(Color.black);
                }    
            chessBoardSquares[ii][jj] = b;
            }
        }
        
            // fill chessboard
            chessBoard.add(new JLabel(""));
            //fill top row
            for(int ii = 0; ii < 8; ii++){
                chessBoard.add(new JLabel(COLS.substring(ii, ii + 1), SwingConstants.CENTER));
            }
            // fill the black special pieces
            for(int ii = 0; ii < 8; ii++)
            {
                for(int jj = 0; jj < 8; jj++)
                {
                    switch(jj)
                    {
                        case 0:
                            chessBoard.add(new JLabel("" + (9-(ii + 1)), SwingConstants.CENTER));
                        default:
                            chessBoard.add(chessBoardSquares[jj][ii]);
                    }
                }
            }
            //end of initializeGUI
        }
    public final JComponent getGui()
    {
        return gui;
        //end of getGui
    }
    private final void createImages()
    {
        try{
            URL url = new URL("http://i.stack.imgur.com/memI0.png");
            BufferedImage bi = ImageIO.read(url);
            for (int ii = 0; ii < 2; ii++)
            {
                for (int jj = 0; jj < 6; jj++)
                {
                    chessPieceImages[ii][jj] = bi.getSubimage(jj * 64, ii * 64, 64, 64);
                }
            }
        }
            catch(Exception e)
            {
                    e.printStackTrace();
                    System.exit(1);
            }
        //end of createImages
    }
    
    private final void setupNewGame()
    {
        message.setText("Player Ready Up!");
        //set up black pieces
        for(int ii = 0; ii < STARTING_ROW.length; ii++)
        {
            //enable special piece images
            chessBoardSquares[ii][0].setIcon(new ImageIcon(chessPieceImages[BLACK][STARTING_ROW[ii]]));
        }
        for (int ii = 0; ii < STARTING_ROW.length; ii++)
        {
            //enable pawn images
            chessBoardSquares[ii][1].setIcon(new ImageIcon(chessPieceImages[BLACK][PAWN]));
        }
        // set up the white pieces
        for(int ii = 0; ii < STARTING_ROW.length; ii++)
        {
            //enable pawn images for white
            chessBoardSquares[ii][6].setIcon(new ImageIcon(chessPieceImages[WHITE][PAWN]));
        }
        for(int ii = 0; ii < STARTING_ROW.length; ii++)
        {
            //enable special piece images
            chessBoardSquares[ii][7].setIcon(new ImageIcon(chessPieceImages[WHITE][STARTING_ROW[ii]]));
        }
  
    }
    
}
