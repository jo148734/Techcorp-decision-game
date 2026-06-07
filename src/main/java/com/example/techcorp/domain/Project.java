package com.example.techcorp.domain;

public class Project {

    private final String name;
    private final int requiredWork;
    private final double reward;

    private int progress;
    private boolean paid;

    private ProjectStatus status;

    public Project(String name,
                   int requiredWork,
                   double reward) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Project name cannot be blank.");
        }

        if (requiredWork <= 0) {
            throw new IllegalArgumentException("Required work must be positive.");
        }

        if (reward < 0) {
            throw new IllegalArgumentException("Reward cannot be negative.");
        }

        this.name = name;
        this.requiredWork = requiredWork;
        this.reward = reward;

        this.progress = 0;
        this.paid = false;
        this.status = ProjectStatus.PLANNED;
    }

    public void addProgress(int work) {

        if (status == ProjectStatus.COMPLETED) {
            return;
        }

        progress += work;

        if (progress > 0) {
            status = ProjectStatus.IN_PROGRESS;
        }

        if (progress >= requiredWork) {

            progress = requiredWork;
            status = ProjectStatus.COMPLETED;
        }
    }

    public boolean isFinished() {
        return status == ProjectStatus.COMPLETED;
    }

    public String getName() {
        return name;
    }

    public int getRequiredWork() {
        return requiredWork;
    }

    public int getProgress() {
        return progress;
    }

    public double getReward() {
        return reward;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public boolean isPaid() {
        return paid;
    }

    public void markAsPaid() {
        paid = true;
    }

    @Override
    public String toString() {
        return name +
                " | " + progress + "/" + requiredWork +
                " | " + status;
    }
}