// BasePlusCommissionEmployee.java code
public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary; // Base salary per week

    // Constructor
    public BasePlusCommissionEmployee(String firstName, String lastName, String ssn,
                                       double sales, double rate, double salary) {
        super(firstName, lastName, ssn, sales, rate);
        this.baseSalary = salary;
    }

    // Getters and setters
    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Calculate earnings with base salary
    @Override
    public double earnings() {
        return baseSalary + super.earnings();
    }

    // String representation
    @Override
    public String toString() {
        return String.format("%s %s; %s: %.2f", "Base-salaried", super.toString(),
                "Base Salary", baseSalary);
    }
}
