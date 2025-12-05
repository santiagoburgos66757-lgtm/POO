// Implementation of BasePlusCommissionEmployee
public class BasePlusCommissionEmployee {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private double grossSales;
    private double commissionRate;
    private double baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                                       double grossSales, double commissionRate, double baseSalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
        this.baseSalary = baseSalary;
    }

    public double earnings() {
        return baseSalary + (commissionRate * grossSales);
    }

    @Override
    public String toString() {
        return String.format("%s %s\nSocial Security Number: %s\nGross Sales: %.2f\nCommission Rate: %.2f\nBase Salary: %.2f",
                firstName, lastName, socialSecurityNumber, grossSales, commissionRate, baseSalary);
    }
}