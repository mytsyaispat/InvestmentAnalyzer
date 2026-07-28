package org.example.model;

import java.time.LocalDate;

public record BondCashFlow(LocalDate date, double amount, CashFlowType type) {

    public BondCashFlow {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }

        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }

}
