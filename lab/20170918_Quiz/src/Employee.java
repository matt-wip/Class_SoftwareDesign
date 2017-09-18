/*
    Name: Matthew Wipfler
    Date: 9/18/17
 */

public class Employee {
    protected final String firstName;
    protected final String lastName;
    protected final String socialSecurityNumber;
    protected double grossSales; // gross weekly sales
    protected double commissionRate; // commission percentage

    public Employee(String socialSecurityNumber, String firstName, double commissionRate, String lastName, double grossSales) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.firstName = firstName;
        this.commissionRate = commissionRate;
        this.lastName = lastName;
        this.grossSales = grossSales;
    }

    // return first name
    public String getFirstName() {
        return firstName;
    }

    // return last name
    public String getLastName() {
        return lastName;
    }

    // return social security number
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    // return gross sales amount
    public double getGrossSales() {
        return grossSales;
    }

    // set gross sales amount
    public void setGrossSales(double grossSales) {
        if (grossSales < 0.0)
            throw new IllegalArgumentException(
                    "Gross sales must be >= 0.0");

        this.grossSales = grossSales;
    }

    // return commission rate
    public double getCommissionRate() {
        return commissionRate;
    }

    // set commission rate
    public void setCommissionRate(double commissionRate) {
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException(
                    "Commission rate must be > 0.0 and < 1.0");

        this.commissionRate = commissionRate;
    }
}
