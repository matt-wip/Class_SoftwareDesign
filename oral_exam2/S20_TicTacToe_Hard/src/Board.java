import java.util.Scanner;

/**
 * Class for storing and analyzing board
 * @author Matt Wipfler
 */
public class Board {

    // private members
    /** Field for player1- either computer or human*/
    private Player player1;
    /** Field for player2- either computer or human*/
    private Player player2;
    /** Array for board status- start with 0 as the top left corner*/
    private Marker[] board;
    /** Scanner for reading in user input*/
    private static Scanner kScanner = new Scanner(System.in);

    /** Constructor- clear board and ask for players*/
    public Board(){
        board = new Marker[9];
    }

    /**
     * Method to call to reset the board and play a new game
     */
    public void playGame(){
        clear();

        // Create players
        System.out.println("Select player 1:");
        player1 = selectPlayer(Marker.X);
        System.out.println("Select player 2:");
        player2 = selectPlayer(Marker.O);

        printBoard();
        for(int round = 1; round <= 9; round++){
            if(round%2==1)
                player1.play(board);
            else
                player2.play(board);

            printBoard();
            if(checkBoard()){
                System.out.println("Player " + (2-(round%2)) + " won the game!" );
                return;
            }
        }
        System.out.println("\nCat game :(");
    }

    /**
     * Checks board to see if a player won
     * @return True if there is a winning position
     */
    private boolean checkBoard(){
        //check rows
        for(int i = 0; i<9;i+=3){
            if(board[i]!=Marker.None && board[i]==board[i+1] && board[i]==board[i+2]) return true;
        }

        //check columns
        for(int i = 0; i<3; i++){
            if(board[i] != Marker.None && board[i] == board[i+3] && board[i]== board[i+6]) return true;
        }

        //check diagonals, special case
        if(board[4]!=Marker.None && board[0]==board[4] && board[0]==board[8]) return true;
        if(board[4]!=Marker.None && board[0]==board[2] && board[0]==board[6]) return true;

        return false;
    }

    /**
     * Prints the board through the terminal
     */
    private void printBoard(){
        for(int i = 0; i < 9; i++){
            if((i)%3==0) System.out.println("\n\n");

            if(board[i].equals(Marker.None))
                System.out.print(i + "  ");
            else
                System.out.print(board[i].toString() + "  ");
        }
        System.out.println("\n");
    }

    /** Returns board status to all None*/
    private void clear(){
        // clear board positions
        for(int i = 0; i < 9; i++){
            board[i] = Marker.None;
        }

        player1 = null;
        player2 = null;
    }

    /**
     * Class for determining if player is human or computer
     * @param marka Personal identifier
     * @return new Player object -polymorphism
     */
    private static Player selectPlayer(Marker marka){
        System.out.println("Enter 'c' for computer player, or 'h' for human. Default will be human!");
        if(kScanner.nextLine().toLowerCase().trim().equals("c"))
            return new ComputerPlayer(marka);
        else
           return new HumanPlayer(marka);
    }
}
