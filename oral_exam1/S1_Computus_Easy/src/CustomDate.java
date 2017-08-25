/*
* Name: Matthew Wipfler
* Date: 8/23/17
* File: CustomDate.java
* Description: Basic class for storing dates
* */

public class CustomDate {

    // Private members
    private double m_iDay;     // Day of date
    private double m_iMonth;   // Month of date
    private double m_iYear;    // Year of date

    // Accessors
    public double getDay(){
        return m_iDay;
    }
    public double getMonth(){
        return m_iMonth;
    }
    public double getYear(){
        return m_iYear;
    }

    // Constructor
    public CustomDate(){
        // Default values for date
        m_iDay = 1;
        m_iMonth = 1;
        m_iYear = 2017;
    }

    // Constructor
    CustomDate(double Day, double Month, double Year){
        //todo: put limit on or check for valid day, month, year. (is this required for the homework?)
        m_iDay = Day;
        m_iMonth = Month;
        m_iYear = Year;
    }

    String ToString(){
        return (Double.toString(m_iMonth)+"/"+Double.toString(m_iDay)+"/"+Double.toString(m_iYear));
    }
}
