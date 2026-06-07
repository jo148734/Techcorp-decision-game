package com.example.techcorp;

import com.example.techcorp.domain.Company;
import com.example.techcorp.domain.Developer;
import com.example.techcorp.domain.Manager;
import com.example.techcorp.domain.Project;
import com.example.techcorp.domain.Tester;
import com.example.techcorp.engine.GameEngine;
import com.example.techcorp.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        Company player = new Company("Student TechCorp", 80_000);

        player.hire(new Developer("Anna", 8, 7_000));
        player.hire(new Tester("Piotr", 6, 5_500));
        player.hire(new Manager("Ewa", 7, 8_000));

        player.addProject(new Project("Mobile App", 45, 35_000));
        player.addProject(new Project("E-commerce Platform", 70, 55_000));
        player.addProject(new Project("AI Dashboard", 95, 80_000));

        Company ai = new Company("RivalSoft", 80_000);

        ai.hire(new Developer("AI Developer", 7, 6_000));
        ai.hire(new Tester("AI Tester", 5, 4_500));
        ai.hire(new Manager("AI Manager", 6, 7_000));

        ai.addProject(new Project("Rival Strategic System", 100, 90_000));

        ConsoleUI ui = new ConsoleUI();
        GameEngine engine = new GameEngine(player, ai, ui);

        engine.run();
    }
}