/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictictactoe;
import java.util.*;
/**
 *
 * @author jrsullins
 */
public class TicTicTacToe {

    /********************** YOUR CODE GOES HERE **********************/

    /**
    * Computes the heuristic value of the board for a given player.
    * @param board A 4x4 array of characters, either 'X', 'O', or ' '.
    * @param who Either 'X' or 'O'.
    * @return A positive integer giving the value of the board
    */
    public static float evaluate(char[][] board, char who) {
        float returnVal = 0;
        int winCon = 1000;
        int loseCon = 0;
        int threeRow = 500;
        int twoRow = 300;
        int recValue = 800;
        char player = 0;
        if(who == 'O'){
            player = 'X';
        }
        else if(who == 'X'){
            player = 'O';
        }
                
            //FOUR IN ROW
        if(winner(board, who) == true){
                returnVal = winCon;
        }
        //Lose conditions
        else if(board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player &&
                board[3][3] == player)
                    returnVal = loseCon;
        else if(board[0][0] == player &&
                board[0][1] == player &&
                board[0][2] == player &&
                board[0][3] == player)
                    returnVal = loseCon;
        else if(board[1][0] == player &&
                board[1][1] == player &&
                board[1][2] == player &&
                board[1][3] == player)
                    returnVal = loseCon;
        else if(board[2][0] == player &&
                board[2][1] == player &&
                board[2][2] == player &&
                board[2][3] == player)
                    returnVal = loseCon;
        else if(board[3][0] == player &&
                board[3][1] == player &&
                board[3][2] == player &&
                board[3][3] == player)
                    returnVal = loseCon;
        else if(board[0][0] == player &&
                board[1][0] == player &&
                board[2][0] == player &&
                board[3][0] == player)
                    returnVal = loseCon;
        else if(board[0][1] == player &&
                board[1][1] == player &&
                board[2][1] == player &&
                board[3][1] == player)
                    returnVal = loseCon;
        else if(board[0][2] == player &&
                board[1][2] == player &&
                board[2][2] == player &&
                board[3][2] == player)
                    returnVal = loseCon;
        else if(board[0][3] == player &&
                board[1][3] == player &&
                board[2][3] == player &&
                board[3][3] == player)
                    returnVal = loseCon;
        else if(board[3][0] == player &&
                board[2][1] == player &&
                board[1][2] == player &&
                board[0][4] == player)
                    returnVal = loseCon;
        //THREE IN ROW
        //horizontal 1/2
        else if(board[0][0] == who &&
                board[0][1] == who &&
                board[0][2] == who)
                    returnVal = threeRow;
        else if(board[1][0] == who &&
                board[1][1] == who &&
                board[1][2] == who)
                    returnVal = threeRow;
        else if(board[2][0] == who &&
                board[2][1] == who &&
                board[2][2] == who)
                    returnVal = threeRow;
        else if(board[3][0] == who &&
                board[3][1] == who &&
                board[3][2] == who)
                    returnVal = threeRow;
        //horizontal 2/2
        else if(board[0][1] == who &&
                board[0][2] == who &&
                board[0][3] == who)
                    returnVal = threeRow;
        else if(board[1][1] == who &&
                board[1][2] == who &&
                board[1][3] == who)
                    returnVal = threeRow;
        else if(board[2][1] == who &&
                board[2][2] == who &&
                board[2][3] == who)
                    returnVal = threeRow;
        else if(board[3][1] == who &&
                board[3][2] == who &&
                board[3][3] == who)
                    returnVal = threeRow;
        //vertical 1/2  
        else if(board[0][0] == who &&
                board[1][0] == who &&
                board[2][0] == who)
                    returnVal = threeRow;
        else if(board[0][1] == who &&
                board[1][1] == who &&
                board[2][1] == who)
                    returnVal = threeRow;     
        else if(board[0][2] == who &&
                board[1][2] == who &&
                board[2][2] == who)
                    returnVal = threeRow;
        else if(board[0][3] == who &&
                board[1][3] == who &&
                board[2][3] == who)
                    returnVal = threeRow;
        //vertical 2/2
        else if(board[1][0] == who &&
                board[2][0] == who &&
                board[3][0] == who)
                    returnVal = threeRow;
        else if(board[1][1] == who &&
                board[2][1] == who &&
                board[3][1] == who)
                    returnVal = threeRow;
        else if(board[1][2] == who &&
                board[2][2] == who &&
                board[3][2] == who)
                    returnVal = threeRow;
        else if(board[1][3] == who &&
                board[2][3] == who &&
                board[3][3] == who)
                    returnVal = threeRow;
        //Diagonal
        else if(board[0][1] == who &&
                board[1][2] == who &&
                board[2][3] == who)
                  returnVal = threeRow;
        else if(board[0][0] == who &&
                board[1][1] == who &&
                board[2][2] == who)
                    returnVal = threeRow;
        else if(board[1][1] == who &&
                board[2][2] == who &&
                board[3][3] == who)
                    returnVal = threeRow;
        else if(board[0][1] == who &&
                board[1][2] == who &&
                board[2][3] == who)
                    returnVal = threeRow;
        //TWO IN A ROW
        //Column 1/3
        else if(board[0][0] == who &&
                board[0][1] == who)
                    returnVal = twoRow;
        else if(board[1][0] == who &&
                board[1][1] == who)
                    returnVal = twoRow;
        else if(board[2][0] == who &&
                board[2][1] == who)
                    returnVal = twoRow;
        else if(board[3][0] == who &&
                board[3][1] == who)
                    returnVal = twoRow;
        //Column 2/3
        else if(board[0][1] == who &&
                board[0][2] == who)
                    returnVal = twoRow;
        else if(board[1][1] == who &&
                board[1][2] == who)
                    returnVal = twoRow;
        else if(board[2][1] == who &&
                board[2][2] == who)
                    returnVal = twoRow;
        else if(board[3][1] == who &&
                board[3][2] == who)
                    returnVal = twoRow;
        //Column 3/3
        else if(board[0][2] == who &&
                board[0][3] == who)
                    returnVal = twoRow;
        else if(board[1][2] == who &&
                board[1][3] == who)
                    returnVal = twoRow;
        else if(board[2][2] == who &&
                board[2][3] == who)
                    returnVal = twoRow;
        else if(board[3][2] == who &&
                board[3][3] == who)
                    returnVal = twoRow;
        //Row 1/3
        else if(board[0][0] == who &&
                board[1][0] == who)
                    returnVal = twoRow;
        else if(board[0][1] == who &&
                board[1][1] == who)
                    returnVal = twoRow;
        else if(board[0][2] == who &&
                board[1][2] == who)
                    returnVal = twoRow;
        else if(board[0][3] == who &&
                board[1][3] == who)
                    returnVal = twoRow;
        //Row 2/3
        else if(board[1][0] == who &&
                board[2][0] == who)
                    returnVal = twoRow;
        else if(board[1][1] == who &&
                board[2][1] == who)
                    returnVal = twoRow;
        else if(board[1][2] == who &&
                board[2][2] == who)
                    returnVal = twoRow;
        else if(board[1][3] == who &&
                board[2][3] == who)
                    returnVal = twoRow;
        //Row 3/3
        else if(board[2][0] == who &&
                board[3][0] == who)
                    returnVal = twoRow;
        else if(board[2][1] == who &&
                board[3][1] == who)
                    returnVal = twoRow;
        else if(board[2][2] == who &&
                board[3][2] == who)
                    returnVal = twoRow;
        else if(board[2][3] == who &&
                board[3][3] == who)
                    returnVal = twoRow;
        //DIAGONAL 1/5
        else if(board[0][2] == who &&
                board[1][3] == who)
                    returnVal = twoRow;
        //DIAGONAL 2/5
        else if(board[0][1] == who &&
                board[1][2] == who)
                    returnVal = twoRow;
        else if(board[1][2] == who &&
                board[2][3] == who)
                    returnVal = twoRow;
        //DIAGONAL 3/5
        else if(board[0][0] == who &&
                board[1][1] == who)
                    returnVal = twoRow;
        else if(board[1][1] == who &&
                board[2][2] == who)
                    returnVal = twoRow;
        else if(board[2][2] == who &&
                board[3][3] == who)
                    returnVal = twoRow;
        //DIAGONAL 4/5
        else if(board[1][1] == who &&
                board[2][1] == who)
                    returnVal = twoRow;
        else if(board[2][1] == who &&
                board[3][2] == who)
                    returnVal = twoRow;
        //DIAGONAL 5/5
        else if(board[2][0] == who &&
                board[3][1] == who)
                    returnVal = twoRow;
        //Recovery Mode
        //Corner 1/4
        //top-left corner to top-right
        else if(board[0][0] == player &&
                board[0][1] == player &&
                board[0][2] == player &&
                board[0][3] == who)
                    returnVal = recValue;
        //bottom-left corner to top-right
        else if(board[0][3] == player &&
                board[1][2] == player &&
                board[2][1] == player &&
                board[3][0] == who)
                    returnVal = recValue;
        //bottom-right corner to top-right
        else if(board[3][3] == player &&
                board[3][2] == player &&
                board[3][1] == player &&
                board[3][0] == who)
                    returnVal = recValue;
        //corner 2/4
        //top left to top right
        else if(board[0][0] == who &&
                board[1][0] == player &&
                board[2][0] == player &&
                board[3][0] == player)
                    returnVal = recValue;
        //top left to bottom right
        else if(board[0][0] == who &&
                board[1][1] == player &&
                board[2][2] == player &&
                board[3][3] == player)
                    returnVal = recValue;
        //top left to bottom left
        else if(board[0][0] == who &&
                board[0][1] == player &&
                board[0][2] == player &&
                board[0][3] == player)
                    returnVal = recValue;
        //corner 3/4
        //top left to bottom left
        else if(board[0][0] == player &&
                board[0][1] == player &&
                board[0][2] == player &&
                board[0][3] == who)
                    returnVal = recValue;
        //bottom left to top right
        else if(board[0][3] == who &&
                board[1][2] == player &&
                board[2][1] == player &&
                board[3][0] == player)
                    returnVal = recValue;
        //bottom left to bottom right
        else if(board[0][3] == who &&
                board[1][3] == player &&
                board[2][3] == player &&
                board[3][3] == player)
                    returnVal = recValue;
        //corner 4/4
        //top left to bottom right
        else if(board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player &&
                board[3][3] == who)
                    returnVal = recValue;
        //bottom left to bottom right
        else if(board[0][3] == player &&
                board[1][3] == player &&
                board[2][3] == player &&
                board[3][3] == who)
                    returnVal = recValue;
        //top right to bottom right
        else if(board[3][0] == player &&
                board[3][1] == player &&
                board[3][2] == player &&
                board[3][3] == who)
                    returnVal = recValue;
        
        //Blocking 1/8
        //Row 0, block on 2 column
        else if(board[0][0] == player &&
                board[1][0] == player &&
                board[2][0] == who &&
                board[3][0] == player)
                    returnVal = recValue;
        else if(board[2][0] == who &&
                board[2][1] == player &&
                board[2][2] == player &&
                board [2][3] == player)
                    returnVal = recValue;
        //Blocking 2/8
        //Row 0, block on 1 column
        else if(board[0][0] == player &&
                board[1][0] == who &&
                board[2][0] == player &&
                board[3][0] == player)
                    returnVal = recValue;
        else if(board[1][0] == who &&
                board[1][1] == player &&
                board[1][2] == player &&
                board[1][3] == player)
                    returnVal = recValue;
        //Blocking 3/8
        //Column 0, block on 1 row
        else if(board[0][0] == player &&
                board[0][1] == who &&
                board[0][2] == player &&
                board[0][3] == player)
                    returnVal = recValue;
        else if(board[0][1] == who &&
                board[1][1] == player &&
                board[2][1] == player &&
                board[3][1] == player)
                    returnVal = recValue;
        //Blocking 4/8
        //Column 0, block on 2 row
        else if(board[0][0] == player &&
                board[0][1] == player &&
                board[0][2] == who &&
                board[0][3] == player)
                    returnVal = recValue;
        else if(board[0][2] == who &&
                board[1][2] == player &&
                board[2][2] == player &&
                board[2][3] == player)
                    returnVal = recValue;
        
        //Blocking 5/8
        //Row 3 block on 1 column
        else if(board[1][0] == player &&
                board[1][1] == player &&
                board[1][2] == player &&
                board[1][3] == who)
                    returnVal = recValue;
        else if(board[0][3] == player &&
                board[1][3] == who &&
                board[2][3] == player &&
                board[3][3] == player)
                    returnVal = recValue;
        
        //Blocking 6/8
        //Row 3 block on 2 column
        else if(board[2][0] == player &&
                board[2][1] == player &&
                board[2][2] == player &&
                board[2][3] == who)
                    returnVal = recValue;
        else if(board[0][3] == player &&
                board[1][3] == player &&
                board[2][3] == who &&
                board[3][3] == player)
                    returnVal = recValue;
        
        //Blocking 7/8
        //Row 1 block on 3
        else if(board[3][0] == player &&
                board[3][1] == who &&
                board[3][2] == player &&
                board[3][3] == player)
                    returnVal = recValue;
        else if(board[0][1] == player &&
                board[1][1] == player &&
                board[2][1] == player &&
                board[3][1] == who)
                    returnVal = recValue;
        
        //Blocking 8/8
        //Row 2 block on col 3
        else if(board[0][2] == player &&
                board[1][2] == player &&
                board[2][2] == player &&
                board[3][2] == who)
                    returnVal = recValue;
        else if(board[3][0] == player &&
                board[3][1] == player &&
                board[3][2] == who &&
                board[3][3] == player)
                    returnVal = recValue;
        
        //Midblocking 1/4
        //Mid top-left
        else if(board[0][0] == player &&
                board[1][1] == who &&
                board[2][2] == player &&
                board[3][3] == player)
                    returnVal = recValue;
        //mid bottom-right
        else if(board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == who &&
                board[3][3] == player)
                    returnVal = recValue;
        //mid top-right
        else if(board[3][0] == player &&
                board[2][1] == who &&
                board[1][2] == player &&
                board[0][3] == player)
                    returnVal = recValue;
        //mid bottom-left
        else if(board[3][0] == player &&
                board[2][1] == player &&
                board[1][2] == who &&
                board[0][3] == player)
                    returnVal = recValue;
        else
            returnVal = 200;
        return returnVal;
    }
        






/***************** END OF YOUR CODE ********************************/

    


    static final int MAXLEVEL = 2;

/* This is the main function for playing the game. It alternatively
   prompts the user for a move, and uses the minmax algorithm in 
   conjunction with the given evaluation function to determine the
   opposing move. This continues until the board is full. It returns
   the number scored by X minus the number scored by O. */

    public static boolean run(int[] scores, char who) { 
        int i, j;
        char current, other;
        int playerrow, playercol;
        int[] location = new int[2];  // Allows us to pass row, col by reference
        int move = 1;

        /* Initialize the board */
        char[][] board = new char[4][4];
        for (i = 0; i < 4; i++) { 
            for (j = 0; j < 4; j++) {
                board[i][j] = ' ';
            }
        }

        if (who == 'O') display(board);

        while (move <= 16) {
            if (move % 2 == 1) {
                current = 'X';
                other = 'O';
            }
            else {                
                current = 'O';
                other = 'X';
            }

            if (current == who) {        /* The computer's move */
                choose(location, board, who);  /* Call function to compute move */
                System.out.println("Computer chooses " + (location[0]+1) + ", " + (location[1]+1));
                if (board[location[0]][location[1]] == ' ') 
                    board[location[0]][location[1]] = current;
                else {
                    System.out.println("BUG! " + (location[0]+1) + ", " + (location[1]+1) + " OCCUPIED!!!");
                    System.exit(0);
                }
                if (winner(board, who)) {
                    System.out.println("Computer has 4 in a row! Computer wins!");
                    display(board);
                    return true;
                }
            }

            else {                       /* Ask for player's move */
                Scanner in = new Scanner(System.in);
                System.out.print("Player " + current + ", enter row: ");
                playerrow = in.nextInt();
                System.out.print("Player " + current + ", enter column: ");
                playercol = in.nextInt();
                while (board[playerrow-1][playercol-1] != ' ' ||
                    playerrow < 1 || playerrow > 4 ||
                    playercol < 1 || playercol > 4) {
                        System.out.println("Illegal move! You cannot use that square!");
                
                        System.out.print("Player " + current + ", enter row: ");
                        playerrow = in.nextInt();
                        System.out.print("Player " + current + ", enter column: ");
                        playercol = in.nextInt();
                }
                playercol--; playerrow--;
                board[playerrow][playercol] = current;
                if (winner(board, current)) {
                    System.out.println("Player has 4 in a row! Player wins!");
                    display(board);
                    return true;            
                }
            }
 
            display(board);    /* Redisplay board to show the move */

            move++; /* Increment the move number and do next move. */
        }
        scores[0] = getScore(board, 'X');
        scores[1] = getScore(board, 'O');
        return false;
    }

    /* This function determines if there is a winner (based on 4 in a row) */
    public static boolean winner(char[][] board, char who) {
        for (int i = 0; i < 4; i++) {
            if (board[i][0] == who && 
                board[i][1] == who &&
                board[i][2] == who &&
                board[i][3] == who) {
                //cout << "Win in row " << i << "\n";
                return true;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (board[0][i] == who && 
                board[1][i] == who &&
                board[2][i] == who &&
                board[3][i] == who) {            
                //cout << "Win in row " << i << "\n";
                return true;
            }   
        }
        if (board[0][0] == who && 
            board[1][1] == who &&
            board[2][2] == who &&
            board[3][3] == who) {
            // cout << "Win along main diagonal\n";
            return true;
            }
        
        if (board[0][3] == who && 
            board[1][2] == who &&
            board[2][1] == who &&
            board[3][0] == who) {
            // cout << "Win along other diagonal\n";
            return true;
            }
        return false;
    }


/* This function exhaustively searches the current board to count the
   sets of 3 each player has in a row. */

    public static int getScore(char[][] board, char who) {
      int row, col;
      int X, O;
      int score = 0;

      /* check all rows */
      for (row = 0; row < 4; row++)
        for (col = 0; col < 2; col++)
          if (board[row][col] == who &&
              board[row][col+1] == who &&
              board[row][col+2] == who) score++;

      /* check all columns */
      for (row = 0; row < 2; row++)
        for (col = 0; col < 4; col++)
          if (board[row][col] == who &&
              board[row+1][col] == who &&
              board[row+2][col] == who) score++;

      /* check all diagonals */
      for (row = 0; row < 2; row++)
        for (col = 0; col < 2; col++)
          if (board[row][col] == who &&
              board[row+1][col+1] == who &&
              board[row+2][col+2] == who) score++;
      for (row = 0; row < 2; row++)
        for (col = 2; col < 4; col++)
          if (board[row][col] == who &&
              board[row+1][col-1] == who &&
              board[row+2][col-2] == who) score++;
      return score;
      }

    
/* This displays the current configuration of the board. */

    public static void display(char[][] board) {
        int row, col;  
        int scores[] = new int[2];
        System.out.print("\n");
        for (row = 3; row >= 0; row--) {
            System.out.print("  +-+-+-+-+\n");
            System.out.print((row+1) + " ");
            for (col = 0; col < 4; col++) {
            if (board[row][col] == 'X')  /* if contents are 0, print space */
                System.out.print("|X");
            else if (board[row][col] == 'O')
                System.out.print("|0");
            else System.out.print("| ");
            }
            System.out.print("|\n");
        }
        System.out.print("  +-+-+-+-+\n");  /* print base, and indices */
        System.out.print("   1 2 3 4\n");
        scores[0] = getScore(board, 'X');
        scores[1] = getScore(board, 'O');
        System.out.println("X: " + scores[0]);
        System.out.println("O: " + scores[1]);
    }
   
/* Basic function for choosing the computer's move. It essentially
   initiates the first level of the MINMAX algorithm, and returns
   the column number it chooses. */

    public static void choose(int[] location, char[][] board, char who) {
        int move; 
        float value;
        getmax(location, board, 1, who);
    }


/* This handles any MAX level of a MINMAX tree. Using a pointer to move
   is a hack to deal with not being able to return both the chosen move
   and its evaluation number. 

   This essentially handles moves for the computer. */

    public static float getmax(int[] location, char[][] board, int level, char who) {
        char[][] tempboard = new char[4][4];
        int r,c = 0;
        float max = -1;
        float val;
        char other;
        int[] tempLocation = new int[2];
        for (r = 0; r < 4; r++)
            for (c = 0; c < 4; c++) {  /* Try each row and column in board */
                if (board[r][c] == ' ') {     /* Make sure square not full */

                /* To avoid changing original board  during tests, make a copy */
                copy(tempboard, board); 

                /* Find out what would happen if we chose this column */
                tempboard[r][c] = who;

                /* If this is the bottom of the search tree (that is, a leaf) we need
                    to use the evaluation function to decide how good the move is */
                if (level == MAXLEVEL) 
                    val = evaluate(tempboard, who);

                /* Otherwise, this move is only as good as the worst thing our
                    opponent can do to us. */
                else
                    val = getmin(tempLocation, tempboard, level+1, who);

                /* Return the highest evaluation, and set call by ref. parameter
                    "move" to the corresponding column */
                if (val > max) {
                    max = val;
                    if (level==1) {location[0] = r; location[1] = c;}
                 }

            }
        }
        return max;
    }

/* This handles any MIN level of a MINMAX tree. Using a pointer to move
   is a hack to deal with not being able to return both the chosen move
   and its evaluation number. 

   This essentially handles moves for the opponent. */

    public static float getmin(int[] location, char[][] board, int level, char who) {
        char[][] tempboard = new char[4][4];
        int r,c = 0;   
        int[] tempLocation = new int[2];
        float min = 10001;
        float val;

        /* Since this is opponent's move, we need to figure out which they are */
        char other;
        if (who == 'X') other = 'O'; else other = 'X'; 

        for (r = 0; r < 4; r++)
            for (c = 0; c < 4; c++) {  /* Try each row and column in board */
                if (board[r][c] == ' ') {     /* Make sure square not full */

                    /* To avoid changing original board  during tests, make a copy */
                    copy(tempboard, board);

                    /* Find out what would happen if opponent chose this column */
                    tempboard[r][c] = other;

                    /* If this is the bottom of the search tree (that is, a leaf) we need
                    to use the evaluation function to decide how good the move is */
                    if (level == MAXLEVEL)  
                        val = evaluate(tempboard, who);

                    /* Otherwise, find the best thing that we can do if opponent
                        chooses this move. */
                    else
                        val = getmax(tempLocation, tempboard, level+1, who);

                    /* Return the lowest evaluation (which we will assume will be 
                        chosen by opponent, and set call by ref. parameter
                        "move" to the corresponding column */
                    if (val < min) {
                        min = val;
                        //*move = col;
                    }
                }
            }
        return min;
   }


/* This function makes a copy of a given board. This is necessary to be
   able to "try out" the effects of different moves without messing up
   the actual current board. */

    public static void copy(char[][] a, char[][] b) {
        int i, j;
        for (i = 0; i < 4; i++) { 
            for (j = 0; j < 4; j++) {
                a[i][j] = b[i][j];  
            }
        }
    }
     


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        char player, computer;
        int[] scores = new int[2];
        /* Decide who goes first */
        System.out.print("Do you want to play X or O: ");
        Scanner in = new Scanner(System.in);
        player = in.nextLine().charAt(0);
        if (player == 'X') computer = 'O';
        else computer = 'X';
        boolean win = false;
        win = run(scores, computer);
        if (!win)
            System.out.println("\nFinal score: \nX: " + scores[0] + "\nO: " + scores[1] + "\n");
        }
}
