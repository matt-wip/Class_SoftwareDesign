
import org.junit.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
    Driver class for testing Easter Algorithm
    Source: https://stackoverflow.com/questions/2543912/how-do-i-run-junit-tests-from-inside-my-java-application
 * @author Matt Wipfler
 */
public class EasterTestDriver {

    /**
     * Main method. Runs a method to determine if the date algorithm is correct
     * @param args Not used
     */
    public static void main(String[] args) {
        CheckerClass checker = new CheckerClass();
        checker.checkAlgorithWithFile();
    }
}

/**
 * Class for running algorithm checks
 * @author Matt Wipfler
 */
class CheckerClass{

    /**
     * Opens a file containing previous Easter dates and compares the results to the algorithm output
     */
    public void checkAlgorithWithFile(){
        // Source for past Easter dates: https://www.census.gov/srd/www/genhol/easter500.html
        // Txt of dates:                 https://www.census.gov/srd/www/genhol/easter500.txt

        // local variables
        CustomDate kCalculatedEasterDate;
        int iFilesCounted = 0;
        int iWrongDates = 0;

        // Open file, read in dates line by line and compare to algorithm results
        File kPastEasterDates = new File((getClass().getResource("easter500.txt")).getPath());
        try{
            FileReader kFileReader = new FileReader(kPastEasterDates);
            BufferedReader kReader = new BufferedReader(kFileReader);
            String sLineRead;

            //https://stackoverflow.com/questions/13927326/reading-input-till-eof-in-java
            // Go through easter file and compare every known date
            while((sLineRead = kReader.readLine()) != null){
                String[] sLine = sLineRead.trim().split("\\s+");
                double dKnownMonth = Double.parseDouble(sLine[0]);
                double dKnownDay = Double.parseDouble(sLine[1]);
                double dKnownYear = Double.parseDouble(sLine[2]);

                kCalculatedEasterDate = EasterAlgorithm.GetEasterDate(dKnownYear);
                if(kCalculatedEasterDate.getDay()!= dKnownDay || kCalculatedEasterDate.getMonth()!= dKnownMonth){
                    iWrongDates++;
                }

                iFilesCounted++;
            }
        }catch (Exception e){
            System.out.println("Failure in reading Easter file: " + e.getMessage());
        }

        System.out.println("Total number of Easter dates checked: " + iFilesCounted);
        System.out.println("Number of wrong algorithm outputs: "+ iWrongDates);
    }
}
