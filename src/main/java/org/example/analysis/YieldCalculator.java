package org.example.analysis;

import org.example.model.BondCashFlow;

import java.time.LocalDate;
import java.util.List;

public class YieldCalculator {
    private static final double DAYS_IN_YEAR = 365.0;

    public static double calculateYtm(double dirtyPrice, List<BondCashFlow> flows, LocalDate settlementDate) {
        double low = 0;
        double high = 2;
        for (int i = 0; i < 200; i++) {
            double rate = (low + high) / 2;

            double pv = calculatePv(flows, rate, settlementDate);
            if (pv > dirtyPrice) {
                low = rate;
            } else {
                high = rate;
            }
        }
        return (low + high) / 2;
    }

    private static double calculatePv(List<BondCashFlow> flows, double annualRate, LocalDate settlementDate) {
        double result = 0;
        for (BondCashFlow flow : flows) {
            long days = flow.date().toEpochDay() - settlementDate.toEpochDay();
            if (days <= 0) {
                continue;
            }
            double years = days / DAYS_IN_YEAR;
            result += flow.amount() / Math.pow(1 + annualRate, years);
        }
        return result;
    }
}