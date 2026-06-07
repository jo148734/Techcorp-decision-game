package com.example.techcorp;

import com.example.techcorp.domain.Company;
import com.example.techcorp.domain.Developer;
import com.example.techcorp.domain.Project;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompanyTest {

    @Test
    void companyCanHireEmployee() {
        Company company = new Company("Test Company", 10000);
        company.hire(new Developer("Anna", 5, 1000));

        assertEquals(1, company.getEmployees().size());
    }

    @Test
    void companyCanCompleteProjectAndCollectRevenue() {
        Company company = new Company("Test Company", 10000);
        company.hire(new Developer("Anna", 10, 1000));

        Project project = new Project("App", 10, 5000);
        company.addProject(project);

        company.workOnProjects();
        company.collectRevenue();

        assertTrue(project.isFinished());
        assertEquals(15000, company.getCash());
    }

    @Test
    void companyNameCannotBeBlank() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Company("", 10000);
        });
    }
}