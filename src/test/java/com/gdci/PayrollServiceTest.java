package com.gdci;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PayrollServiceTest {

    private final PayrollService payrollService = new PayrollService();

    @Test
    @DisplayName("calculateBonus returns 2% for salary below 500000")
    void calculateBonus_below500000_returnsTwoPercent() {
        double salary = 400000;
        double expectedBonus = salary * 0.02;

        double actualBonus = payrollService.calculateBonus(salary);

        assertEquals(expectedBonus, actualBonus, 0.0001);
    }

    @Test
    @DisplayName("calculateBonus returns 5% for salary between 500000 and 1000000")
    void calculateBonus_between500000And1000000_returnsFivePercent() {
        double salary = 750000;
        double expectedBonus = salary * 0.05;

        double actualBonus = payrollService.calculateBonus(salary);

        assertEquals(expectedBonus, actualBonus, 0.0001);
    }

    @Test
    @DisplayName("calculateBonus returns 8% for salary above 1000000")
    void calculateBonus_above1000000_returnsEightPercent() {
        double salary = 1500000;
        double expectedBonus = salary * 0.08;

        double actualBonus = payrollService.calculateBonus(salary);

        assertEquals(expectedBonus, actualBonus, 0.0001);
    }

    @Test
    @DisplayName("calculateBonus throws IllegalArgumentException for negative salary")
    void calculateBonus_negativeSalary_throwsIllegalArgumentException() {
        double salary = -1000;

        assertThrows(IllegalArgumentException.class,
                () -> payrollService.calculateBonus(salary));
    }
}
