package com.example.techcorp.events;

import com.example.techcorp.domain.Company;

public class MarketSlowdownEvent implements GameEvent {

    @Override
    public String getName() {
        return "Market Slowdown";
    }

    @Override
    public void apply(Company company) {
        company.removeCash(5_000);
    }
}