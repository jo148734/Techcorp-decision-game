package com.example.techcorp.domain;

public abstract class Employee implements Workable {
    private final String name;
    private final int skill;
    private final double salary;

    public Employee(String name, int skill, double salary) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Employee name cannot be blank.");
        }
        if (skill <= 0) {
            throw new IllegalArgumentException("Skill must be positive.");
        }
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative.");
        }

        this.name = name;
        this.skill = skill;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSkill() {
        return skill;
    }

    public double getSalary() {
        return salary;
    }

    public abstract String getRole();

    @Override
    public String toString() {
        return getRole() + " " + name + " | skill: " + skill + " | salary: " + salary;
    }
}