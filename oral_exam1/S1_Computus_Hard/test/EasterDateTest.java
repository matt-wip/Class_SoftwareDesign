import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class EasterDateTest {
    @Test
    public void CompareAlgorithmToKnownDates() throws Exception {

        // Source for past Easter dates: https://www.census.gov/srd/www/genhol/easter500.html
        // Txt of dates:                 https://www.census.gov/srd/www/genhol/easter500.txt

        CustomDate kCalculatedEasterDate;
        File kPastEasterDates = new File((getClass().getResource("easter500.txt")).getPath());
        try{
            FileReader kFileReader = new FileReader(kPastEasterDates);
            BufferedReader kReader = new BufferedReader(kFileReader);
            String sLineRead;

            //https://stackoverflow.com/questions/13927326/reading-input-till-eof-in-java
            while((sLineRead = kReader.readLine()) != null){
                String[] sLine = sLineRead.trim().split("\\s+");
                double dKnownMonth = Double.parseDouble(sLine[0]);
                double dKnownDay = Double.parseDouble(sLine[1]);
                double dKnownYear = Double.parseDouble(sLine[2]);

                kCalculatedEasterDate = EasterAlgorithm.GetEasterDate(dKnownYear);
                Assert.assertEquals(kCalculatedEasterDate.getMonth(), dKnownMonth, 0.0001);
                Assert.assertEquals(kCalculatedEasterDate.getDay(), dKnownDay, 0.0001);
            }

        }catch (Exception e){
            System.out.println("Failure in reading Easter file: " + e.getMessage());
        }
    }
}