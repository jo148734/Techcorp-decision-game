package com.example.techcorp;

import com.example.techcorp.domain.Developer;
import com.example.techcorp.domain.Manager;
import com.example.techcorp.domain.Tester;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    void developerProducesWork() {
        Developer developer = new Developer("Anna", 5, 1000);

        assertEquals(15, developer.work());
    }

    @Test
    void testerProducesWork() {
        Tester tester = new Tester("Piotr", 5, 1000);

        assertEquals(10, tester.work());
    }

    @Test
    void managerProducesWork() {
        Manager manager = new Manager("Ewa", 5, 1000);

        assertEquals(10, manager.work());
    }

    @Test
    void employeeSkillMustBePositive() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Developer("Bad Employee", 0, 1000);
        });
    }
}