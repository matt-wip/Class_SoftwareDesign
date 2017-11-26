import java.awt.*;

/**
 * Class used to setup and run application
 * @author Matt Wipfler
 */
public class TicTacToeDriver {

    /**
     * Main method to run
     * @param args not used
     */
    public static void main(String[] args){
        System.out.println("Welcome to Tic-Tac-Toe!\n");
        Board kBoard = new Board();
        kBoard.playGame();
    }

}
