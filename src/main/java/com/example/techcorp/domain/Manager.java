package com.example.techcorp.domain;

public class Manager extends Employee {
    public Manager(String name, int skill, double salary) {
        super(name, skill, salary);
    }

    @Override
    public int work() {
        return getSkill() + 5;
    }

    @Override
    public String getRole() {
        return "Manager";
    }
}