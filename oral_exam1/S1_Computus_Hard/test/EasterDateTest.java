
import org.junit.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Class for running JUnit test. Reads in file of 500 Easter dates and compares them to the algorithm results.
 * note: Source for Easter Dates: https://www.census.gov/srd/www/genhol/easter500.html
 * @author Matt Wipfler
 */
public class EasterDateTest {

    @Test
    /**
     * Compares file of dates to algorithm results
     * Prints out the results
     */
    public void CompareAlgorithmToKnownDates() throws Exception {

        // Source for past Easter dates: https://www.census.gov/srd/www/genhol/easter500.html
        // Txt of dates:                 https://www.census.gov/srd/www/genhol/easter500.txt

        // local variables
        CustomDate kCalculatedEasterDate;
        int iFilesCounted = 0;

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
                Assert.assertEquals(kCalculatedEasterDate.getMonth(), dKnownMonth, 0.0001);
                Assert.assertEquals(kCalculatedEasterDate.getDay(), dKnownDay, 0.0001);

                iFilesCounted++;
            }
        }catch (Exception e){
            System.out.println("Failure in reading Easter file: " + e.getMessage());
        }

        System.out.println("Total number of Easter dates checked: " + iFilesCounted);
    }
}