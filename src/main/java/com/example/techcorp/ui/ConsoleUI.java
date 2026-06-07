package com.example.techcorp.ui;

import com.example.techcorp.domain.Company;
import com.example.techcorp.domain.Employee;
import com.example.techcorp.domain.Project;

import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);

    public void showTitle() {
        System.out.println("==================================");
        System.out.println("      TECHCORP DECISION GAME      ");
        System.out.println("==================================");
    }

    public void showTurn(int turn) {
        System.out.println();
        System.out.println("------------ TURN " + turn + " ------------");
    }

    public void showMenu() {
        System.out.println();
        System.out.println("Choose an action:");
        System.out.println("1. Work on projects");
        System.out.println("2. Hire Developer  (-7000)");
        System.out.println("3. Hire Tester     (-5500)");
        System.out.println("4. Hire Manager    (-8000)");
        System.out.println("5. View company status");
        System.out.println("6. View projects");
        System.out.println("7. View employees");
        System.out.println("0. Exit game");
        System.out.print("Your choice: ");
    }

    public int readChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void showCompanyStatus(Company company) {
        System.out.println(company);
        System.out.println("Company value: " + String.format("%.2f", company.getCompanyValue()));
    }

    public void showProjects(Company company) {
        System.out.println();
        System.out.println("Projects of " + company.getName() + ":");

        for (Project project : company.getProjects()) {
            System.out.println("- " + project);
        }
    }

    public void showEmployees(Company company) {
        System.out.println();
        System.out.println("Employees of " + company.getName() + ":");

        for (Employee employee : company.getEmployees()) {
            System.out.println("- " + employee);
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}