/*
* Name: Matthew Wipfler
* Date: 8/24/17
* File: EasterDateCounter.java
* Description: Contains code to satisfy S1_Computus_Medium.
* Takes an imported year (in arguments), calculates the date Easter is on for 5,700,000 years afterwards, and displays results
* */

public class EasterDateCounter {

    // Counts the number of times Easter falls on a certain date
    public static void main(String[] args){
        // Parse year from program arguments into a double
        // NOTE: a second param could be inputted as a range past the inputted year.
        double dYear = 2017;
        try{
            dYear = Double.parseDouble(args[0]);  // reference:https://stackoverflow.com/questions/23557842/converting-string-args-to-int-double-in-java
        }catch (Exception e){
            System.out.print("Invalid argument");
        }

        // Create structure for storing date counts
        double March[] = new double[31];
        double April[] = new double[30];

        // Go through loop, calculate date, add to structure
        double dEndYear = dYear + 5700000;
        for(double i = dYear; i < dEndYear; i++){
            // Calculate Easter date
            CustomDate kDate = EasterAlgorithm.GetEasterDate(i);

            // Add to structure
            if(kDate.getMonth() == 3){
                March[(int)kDate.getDay() - 1]++;
            }
            else if(kDate.getMonth() == 4){
                April[(int)kDate.getDay() - 1]++;
            }
        }

        // Display results
        for (int i = 0; i < 31; i++){
            System.out.println(("March " + (i+1) + ": " + March[i]));
        }
        for(int i = 0; i < 30; i++){
            System.out.println(("April " + i + ": " + April[i]));
        }

    }

}
