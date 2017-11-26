/**
 * Parent class of Human/Computer Player. Contains behavior and members of a generic player
 * @author Matt Wipfler
 */
public abstract class Player {

    //private members
    /** Personal marker for gameplay*/
    private Marker kMarker;

    /**
     * Accessor to individual marker
     * @return personal marker
     */
    public Marker getkMarker() {
        return kMarker;
    }

    /**
     * Constructor
     * @param personalMarker Individual symbol for player
     */
    public Player(Marker personalMarker){
        this.kMarker = personalMarker;
    }

    /**
     * Turn in tic-tac-toe. Select a valid position
     * @param board Reference to board array. Assumes length of 9
     */
    public abstract void play(Marker[] board);
}
