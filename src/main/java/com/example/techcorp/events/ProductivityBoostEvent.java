package com.example.techcorp.events;

import com.example.techcorp.domain.Company;

public class ProductivityBoostEvent implements GameEvent {

    @Override
    public String getName() {
        return "Productivity Boost";
    }

    @Override
    public void apply(Company company) {
        company.addCash(4_000);
    }
}