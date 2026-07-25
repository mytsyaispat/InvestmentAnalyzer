package org.example.analysis;

import org.example.model.BondCashFlow;
import ru.tinkoff.piapi.contract.v1.Coupon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CashFlowBuilder {

    public static List<BondCashFlow> build(List<Coupon> coupons, LocalDate maturityDate, double nominal) {

        List<BondCashFlow> flows = new ArrayList<>();

        for (Coupon coupon : coupons) {

            LocalDate date = LocalDate.ofEpochDay(
                    coupon.getCouponDate().getSeconds() / 86400
            );

            double amount =
                    coupon.getPayOneBond().getUnits()
                            +
                            coupon.getPayOneBond().getNano() / 1_000_000_000.0;


            flows.add(
                    new BondCashFlow(
                            date,
                            amount,
                            false
                    )
            );
        }


        flows.add(
                new BondCashFlow(
                        maturityDate,
                        nominal,
                        true
                )
        );


        return flows;
    }
}