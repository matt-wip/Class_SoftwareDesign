/*
* Name: Matthew Wipfler
* Date: 8/23/17
* File: EasterDayCalculator.java
* Description: Contains code to satisfy S1_Computus_Easy.
* Takes an imported year (in arguments), calculates the date Easter is on, and outputs results.
* */

public class EasterDayCalculator {

    public static void main(String[] args) {
        // Parse year from program arguments into a double
        // reference:https://stackoverflow.com/questions/23557842/converting-string-args-to-int-double-in-java
        double dYear = 2017;
        try{
            dYear = Double.parseDouble(args[0]);
        }catch (Exception e){
            System.out.print("Invalid argument");
        }

        // Calculate Easter date
        CustomDate kDate = EasterAlgorithm.GetEasterDate(dYear);

        // Display results
        System.out.print("Easter date is: " + kDate.ToString());
    }
}
