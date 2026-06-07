package com.example.techcorp.domain;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private final String name;
    private double cash;
    private int reputation;

    private final List<Employee> employees;
    private final List<Project> projects;

    public Company(String name, double cash) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Company name cannot be blank.");
        }

        if (cash < 0) {
            throw new IllegalArgumentException("Cash cannot be negative.");
        }

        this.name = name;
        this.cash = cash;
        this.reputation = 0;

        this.employees = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    public void hire(Employee employee) {

        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null.");
        }

        employees.add(employee);
    }

    public void addProject(Project project) {

        if (project == null) {
            throw new IllegalArgumentException("Project cannot be null.");
        }

        projects.add(project);
    }

    public void workOnProjects() {

        int totalWork = employees.stream()
                .mapToInt(Employee::work)
                .sum();

        for (Project project : projects) {

            if (!project.isFinished()) {
                project.addProgress(totalWork);
                break;
            }
        }
    }

    public void paySalaries() {

        for (Employee employee : employees) {
            cash -= employee.getSalary();
        }
    }

    public void collectRevenue() {

        for (Project project : projects) {

            if (project.isFinished() && !project.isPaid()) {

                cash += project.getReward();
                reputation += 10;

                project.markAsPaid();
            }
        }
    }

    public boolean isBankrupt() {
        return cash < 0;
    }

    public double getCompanyValue() {

        return cash
                + reputation * 1000
                + projects.stream()
                .filter(Project::isFinished)
                .count() * 10000;
    }

    public String getName() {
        return name;
    }

    public double getCash() {
        return cash;
    }

    public int getReputation() {
        return reputation;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void addCash(double amount) {
        cash += amount;
    }

    public void removeCash(double amount) {
        cash -= amount;
    }

    @Override
    public String toString() {
        return name +
                " | Cash: " + String.format("%.2f", cash) +
                " | Reputation: " + reputation +
                " | Employees: " + employees.size();
    }
}