/*
* Name: Matthew Wipfler
* Date: 8/23/17
* File: EasterAlgorithm.java
* Description: Contains behavior methods for determining when
* Easter occur in a given year.
* */

package S1_Computus_Easy;

 class EasterAlgorithm {

     static CustomDate GetEasterDate(double dYear){
        // Based on Anonymous Meeus'/Jones/Butcher algorithm at: https://en.wikipedia.org/wiki/Computus#Anonymous_Gregorian_algorithm
        // Assumes Year is a valid year (past 1877)

        double a = dYear % 19;
        double b = Math.floor(dYear/100);
        double c = dYear % 100;
        double d = Math.floor(b/4);
        double e = b % 4;
        double f = Math.floor((b+8)/25);
        double g = Math.floor((b-f+1)/3);
        double h = (19*a + b - d - g + 15) % 30;
        double i = Math.floor(c/4);
        double k = c % 4;
        double l = (32 + 2*e + 2*i - h - k) % 7;
        double m = Math.floor((a + 11*h + 22*l)/451);
        double month = Math.floor((h + l - 7*m + 144) / 31);
        double day = ((h + l - 7*m + 114) % 31) + 1;

        return new CustomDate(day,month,dYear);
    }
}

