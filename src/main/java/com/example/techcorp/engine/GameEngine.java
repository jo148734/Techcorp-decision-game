package com.example.techcorp.engine;

import com.example.techcorp.domain.Company;
import com.example.techcorp.domain.Developer;
import com.example.techcorp.domain.GameResult;
import com.example.techcorp.domain.Manager;
import com.example.techcorp.domain.Tester;
import com.example.techcorp.events.GameEvent;
import com.example.techcorp.events.MarketSlowdownEvent;
import com.example.techcorp.events.ProductivityBoostEvent;
import com.example.techcorp.ui.ConsoleUI;

import java.util.List;
import java.util.Random;

public class GameEngine {
    private static final int MAX_TURNS = 12;

    private final Company playerCompany;
    private final Company aiCompany;
    private final ConsoleUI ui;
    private final Random random;

    private int turn;
    private boolean running;

    private final List<GameEvent> events;

    public GameEngine(Company playerCompany, Company aiCompany, ConsoleUI ui) {
        if (playerCompany == null) {
            throw new IllegalArgumentException("Player company cannot be null.");
        }
        if (aiCompany == null) {
            throw new IllegalArgumentException("AI company cannot be null.");
        }
        if (ui == null) {
            throw new IllegalArgumentException("ConsoleUI cannot be null.");
        }

        this.playerCompany = playerCompany;
        this.aiCompany = aiCompany;
        this.ui = ui;
        this.random = new Random();

        this.turn = 1;
        this.running = true;

        this.events = List.of(
                new MarketSlowdownEvent(),
                new ProductivityBoostEvent()
        );
    }

    public void run() {
        ui.showTitle();

        while (running && evaluateResult() == GameResult.IN_PROGRESS) {
            ui.showTurn(turn);
            ui.showCompanyStatus(playerCompany);

            ui.showMenu();
            int choice = ui.readChoice();

            handlePlayerChoice(choice);

            if (!running) {
                break;
            }

            if (choice >= 1 && choice <= 4) {
                aiTurn();
                finishTurn();
                turn++;
            }
        }

        showFinalResult();
    }

    private void handlePlayerChoice(int choice) {
        switch (choice) {
            case 1 -> {
                playerCompany.workOnProjects();
                ui.showMessage("Your employees worked on the current project.");
            }
            case 2 -> hireDeveloper();
            case 3 -> hireTester();
            case 4 -> hireManager();
            case 5 -> ui.showCompanyStatus(playerCompany);
            case 6 -> ui.showProjects(playerCompany);
            case 7 -> ui.showEmployees(playerCompany);
            case 0 -> {
                running = false;
                ui.showMessage("Game exited.");
            }
            default -> ui.showMessage("Invalid option.");
        }
    }

    private void hireDeveloper() {
        double cost = 7000;

        if (playerCompany.getCash() < cost) {
            ui.showMessage("Not enough cash to hire a Developer.");
            return;
        }

        playerCompany.removeCash(cost);
        playerCompany.hire(new Developer("New Developer " + turn, 7, 7000));
        ui.showMessage("You hired a Developer.");
    }

    private void hireTester() {
        double cost = 5500;

        if (playerCompany.getCash() < cost) {
            ui.showMessage("Not enough cash to hire a Tester.");
            return;
        }

        playerCompany.removeCash(cost);
        playerCompany.hire(new Tester("New Tester " + turn, 6, 5500));
        ui.showMessage("You hired a Tester.");
    }

    private void hireManager() {
        double cost = 8000;

        if (playerCompany.getCash() < cost) {
            ui.showMessage("Not enough cash to hire a Manager.");
            return;
        }

        playerCompany.removeCash(cost);
        playerCompany.hire(new Manager("New Manager " + turn, 7, 8000));
        ui.showMessage("You hired a Manager.");
    }

    private void aiTurn() {
        int decision = random.nextInt(100);

        if (decision < 60) {
            aiCompany.workOnProjects();
        } else if (aiCompany.getCash() > 20000) {
            aiCompany.removeCash(7000);
            aiCompany.hire(new Developer("AI Developer " + turn, 6, 6000));
        }
    }

    private void finishTurn() {
        playerCompany.paySalaries();
        aiCompany.paySalaries();

        playerCompany.collectRevenue();
        aiCompany.collectRevenue();

        maybeApplyRandomEvent(playerCompany);

        ui.showMessage("End of turn.");
    }

    private void maybeApplyRandomEvent(Company company) {
        int chance = random.nextInt(100);

        if (chance < 30) {
            GameEvent event = events.get(random.nextInt(events.size()));
            event.apply(company);
            ui.showMessage("Random event: " + event.getName());
        }
    }

    private GameResult evaluateResult() {
        if (playerCompany.isBankrupt()) {
            return GameResult.AI_WINS;
        }

        if (aiCompany.isBankrupt()) {
            return GameResult.PLAYER_WINS;
        }

        if (turn > MAX_TURNS) {
            double playerValue = playerCompany.getCompanyValue();
            double aiValue = aiCompany.getCompanyValue();

            if (playerValue > aiValue) {
                return GameResult.PLAYER_WINS;
            }

            if (aiValue > playerValue) {
                return GameResult.AI_WINS;
            }

            return GameResult.DRAW;
        }

        return GameResult.IN_PROGRESS;
    }

    private void showFinalResult() {
        GameResult result = evaluateResult();

        ui.showMessage("");
        ui.showMessage("========== FINAL RESULT ==========");
        ui.showMessage("Player company:");
        ui.showCompanyStatus(playerCompany);
        ui.showMessage("AI company:");
        ui.showCompanyStatus(aiCompany);

        if (result == GameResult.PLAYER_WINS) {
            ui.showMessage("You win!");
        } else if (result == GameResult.AI_WINS) {
            ui.showMessage("AI wins.");
        } else if (result == GameResult.DRAW) {
            ui.showMessage("The game is a draw.");
        } else {
            ui.showMessage("Game ended before a final result.");
        }
    }
}