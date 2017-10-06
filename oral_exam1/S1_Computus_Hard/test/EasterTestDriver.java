import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/*
    Driver class for testing
    Source: https://stackoverflow.com/questions/2543912/how-do-i-run-junit-tests-from-inside-my-java-application
 */
public class EasterTestDriver {

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
