package com.example.techcorp;

import com.example.techcorp.domain.Project;
import com.example.techcorp.domain.ProjectStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectTest {

    @Test
    void projectStartsAsPlanned() {
        Project project = new Project("Mobile App", 50, 10000);

        assertEquals(ProjectStatus.PLANNED, project.getStatus());
    }

    @Test
    void projectCanBeCompleted() {
        Project project = new Project("Mobile App", 50, 10000);

        project.addProgress(60);

        assertTrue(project.isFinished());
        assertEquals(ProjectStatus.COMPLETED, project.getStatus());
    }

    @Test
    void projectNameCannotBeBlank() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Project("", 50, 10000);
        });
    }
}