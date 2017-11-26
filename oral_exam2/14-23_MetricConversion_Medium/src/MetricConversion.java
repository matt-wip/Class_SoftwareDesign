import java.util.Scanner;

/**
 * Class to provide user interaction with
 * @author Matt Wipfler
 */
public class MetricConversion {

    // private members
    /** Message to print additional information about program*/
    private final String messageHelp;
    /** Message to prompt after each question*/
    private final String messagePrompt;
    /** Flag for exiting program*/
    private boolean exitFlag;
    /** Scanner object for reading from terminal*/
    private final Scanner kScanner;

    /** Constructor*/
    public MetricConversion(){
        messagePrompt =
                "Please type your conversion phrase:\n" +
                "\t-Type 'help' for more information\n"+
                "\t-Type 'exit' to leave program";
        messageHelp =
                "*** UNIT CONVERSION v1.0 ***\n" +
                "Enter your query as 'How to convert ___ [metric/standard unit] to [standard/metric unit]?'\n"+
                "Supported unit conversions include: feet,meter,mile,kilometer,pound,ounce,gram,kilogram,gallon,quart,liter" +
                        "celsius,fahrenheit \n"+
                "Case insensitive. Units can be shortened to abbreviations (ft/m, c/f, lb/kg, ...)\n";
        exitFlag = false;
        kScanner = new Scanner(System.in);
    }

    /**
     * Method to tie everything together and run the program
     */
    public void runTerminal(){

        // Print initial help
        System.out.println(messageHelp);
        while(!exitFlag){
            // Print prompt
            System.out.println(messagePrompt);

            // Get user input sentence
            String sInput = kScanner.nextLine().toLowerCase().trim();

            // Check if help or exit
            if(sInput.equals("help")){ System.out.println(messageHelp);}
            else if(sInput.equals("exit")){exitFlag = true; continue;}

            // Check for valid format
            if(MessageChecker.checkSentence(sInput)){
                // Get units and value from sentence
                MessageChecker.results results = MessageChecker.extractInfo(sInput);

                // Check units
                if(UnitConverter.checkUnits(results)){
                    // Output conversion
                    System.out.println("Converted value: " + UnitConverter.convert(results) + " " +results.to.toString());
                }
            }
            else{
                System.out.println("Please check your format and units");
            }
        }
    }
}
