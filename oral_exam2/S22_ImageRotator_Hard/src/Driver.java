/**
 * Driver class for module. Sets up view and connects to model/controller
 * @author Matt Wipfler
 */
public class Driver {

    /** Main method of application. Creates controller/model and view for displaying the window
     * @param args not used*/
    public static void main(String[] args){
        RotatorControllerModel app = new RotatorControllerModel(new RotatorView());
    }
}



