package com.example.techcorp.events;

import com.example.techcorp.domain.Company;

public interface GameEvent {
    String getName();

    void apply(Company company);
}