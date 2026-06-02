package com.gdci.payroll;

public class PayrollService {
    
    /**
     * Calculates the bonus amount based on the given salary.
     *
     * Business rules:
     * - Salary below 500000 receives 2% bonus.
     * - Salary between 500000 and 1000000 receives 5% bonus.
     * - Salary between 1000000 and 2000000 receives 8% bonus.
     * - Salary above 2000000 receives 10% bonus.
     *
     * @param salary the salary amount to calculate the bonus for
     * @return the calculated bonus amount
     * @throws IllegalArgumentException if salary is negative
     */
    public double calculateBonus(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary must not be negative.");
        }

        double bonusRate;
        if (salary < 500000) {
            bonusRate = 0.02;
        } else if (salary <= 1000000) {
            bonusRate = 0.05;
        } else if (salary <= 2000000) {
            bonusRate = 0.08;
        } else {
            bonusRate = 0.10;
        }

        return salary * bonusRate;
    }
}