package org.example.analysis;

import org.example.model.BondCashFlow;
import org.example.model.BondInfo;

import java.time.LocalDate;
import java.util.List;

public class BondCalculationService {
    public void calculate(
            BondInfo bond,
            List<BondCashFlow> flows
    ) {

        double ytm =
                YieldCalculator.calculateYtm(
                        bond.getDirtyPrice(),
                        flows,
                        LocalDate.now()
                );


        bond.setYtm(ytm * 100);
    }
}
