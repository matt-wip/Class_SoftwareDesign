import java.util.Scanner;

/**
 * Class for human player behavior and interaction
 * @author Matt Wipfler
 */
public class HumanPlayer extends Player {

    /** Scanner to handle user input*/
    private Scanner kScanner;

    /**
     * Constructor
     * @param kMarker Individual symbol for player
     */
    public HumanPlayer(Marker kMarker){
        super(kMarker);
        kScanner = new Scanner(System.in);
    }

    @Override
    public void play(Marker[] board) {
        boolean flag = false;

        while(!flag) {
            System.out.println(("Player " + getkMarker().toString() + " enter the number you want to play on"));
            int num = kScanner.nextInt() % 9;
            if (board[num] == Marker.None) {
                board[num] = getkMarker();
                flag = true;
            }
        }
    }
}
