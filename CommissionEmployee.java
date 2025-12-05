// Updated content for CommissionEmployee.java
public class CommissionEmployee {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private double grossSales; // Gross weekly sales
    private double commissionRate; // Commission percentage

    // Constructor
    public CommissionEmployee(String firstName, String lastName, String ssn, double sales, double rate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = ssn;
        this.grossSales = sales;
        this.commissionRate = rate;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    // Calculate earnings
    public double earnings() {
        return commissionRate * grossSales;
    }

    // String representation
    @Override
    public String toString() {
        return String.format("Commission Employee: %s %s\nSSN: %s\nGross Sales: %.2f\nCommission Rate: %.2f",
                firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
    }
}