package org.example.analysis;

import org.example.model.BondCashFlow;

import java.time.LocalDate;
import java.util.List;
import java.time.temporal.ChronoUnit;

public class YieldCalculator {
    public static double calculate(
            double dirtyPrice,
            List<BondCashFlow> flows,
            LocalDate settlementDate,
            int couponsPerYear
    ) {


        double low = 0;
        double high = 1;


        for (int i = 0; i < 200; i++) {


            double rate =
                    (low + high) / 2;


            double pv =
                    calculatePv(
                            flows,
                            rate,
                            settlementDate,
                            couponsPerYear
                    );


            if (pv > dirtyPrice) {

                low = rate;

            } else {

                high = rate;
            }
        }


        return (low + high) / 2;
    }



    private static double calculatePv(
            List<BondCashFlow> flows,
            double annualRate,
            LocalDate settlementDate,
            int couponsPerYear
    ) {


        double result = 0;


        for (BondCashFlow flow : flows) {


            long days =
                    ChronoUnit.DAYS.between(
                            settlementDate,
                            flow.getDate()
                    );


            double periods =
                    days / 365.0
                            *
                            couponsPerYear;


            result +=
                    flow.getAmount()
                            /
                            Math.pow(
                                    1 + annualRate / couponsPerYear,
                                    periods
                            );
        }


        return result;
    }
}
