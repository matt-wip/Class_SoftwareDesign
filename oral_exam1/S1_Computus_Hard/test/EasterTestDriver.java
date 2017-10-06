import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
    Driver class for testing Easter Algorithm
    Source: https://stackoverflow.com/questions/2543912/how-do-i-run-junit-tests-from-inside-my-java-application
 * @author Matt Wipfler
 */
public class EasterTestDriver {

    /**
     * Main method. Creates and runs a JUnit test and outputs results
     * @param args Not used
     */
    public static void main(String[] args){
        JUnitCore kJUnit = new JUnitCore();

        try{
            Result kResult = kJUnit.run(EasterDateTest.class);
            System.out.println("Test Error Count: " + kResult.getFailureCount());
            System.out.println("Test Run Count:" + kResult.getRunCount());
        }
        catch (Exception e){
            System.out.println("Error running test from EasterTestDriver: " + e.getMessage());
        }
    }
}
