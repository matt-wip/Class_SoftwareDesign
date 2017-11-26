/**
 * Class for behavior of a computer player
 * @author Matt Wipfler
 */
public class ComputerPlayer extends Player {

    /**
     * Constructor
     * @param kMarker Individual symbol for player
     */
    public ComputerPlayer(Marker kMarker){
        super(kMarker);
    }


    @Override
    public void play(Marker[] board) {
        boolean flag = false;
        while(!flag) {
            int num = (int)(Math.random()*100) % 9;
            if (board[num] == Marker.None) {
                board[num] = getkMarker();
                flag = true;
            }
        }
    }

}
