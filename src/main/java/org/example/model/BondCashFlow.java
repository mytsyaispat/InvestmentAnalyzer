package org.example.model;

import java.time.LocalDate;

public class BondCashFlow {
    private final LocalDate date;
    private final double amount;
    private final boolean principal;


    public BondCashFlow(
            LocalDate date,
            double amount,
            boolean principal
    ) {
        this.date = date;
        this.amount = amount;
        this.principal = principal;
    }


    public LocalDate getDate() {
        return date;
    }


    public double getAmount() {
        return amount;
    }


    public boolean isPrincipal() {
        return principal;
    }
}
