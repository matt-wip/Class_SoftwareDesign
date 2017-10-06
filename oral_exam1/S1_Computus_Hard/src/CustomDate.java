/*
* Name: Matthew Wipfler
* Date: 8/23/17
* File: CustomDate.java
* Description: Basic class for storing dates
* */

/**
 * Class for storing a day, month, and year number
 * @author Matt Wipfler
 * note: Created due to constrains on homework (no standard date class)
 */
public class CustomDate {

    // Private members
    /** Member for storing day*/
    private double m_iDay;     // Day of date
    /** Member for storing month*/
    private double m_iMonth;   // Month of date
    /** Member for storing year*/
    private double m_iYear;    // Year of date

    // Accessors
    /** Accessor for obtaining instance's day*/
    public double getDay(){
        return m_iDay;
    }
    /** Accessor for obtaining instance's month*/
    public double getMonth(){
        return m_iMonth;
    }
    /** Accessor for obtaining instance's year*/
    public double getYear(){
        return m_iYear;
    }

    /** Constructor - default*/
    public CustomDate(){
        // Default values for date
        m_iDay = 1;
        m_iMonth = 1;
        m_iYear = 2017;
    }

    /**
     * Constructor
     * @param day Date's day
     * @param month Date's month
     * @param year Date's year
     */
    CustomDate(double day, double month, double year){
        //todo: put limit on or check for valid day, month, year. (is this required for the homework?)
        m_iDay = day;
        m_iMonth = month;
        m_iYear = year;
    }

    @Override
    /**
     * Returns Date as a String in month/day/year format
     */
    public String toString(){
        return (Double.toString(m_iMonth)+"/"+Double.toString(m_iDay)+"/"+Double.toString(m_iYear));
    }
}
