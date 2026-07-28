package org.example.analysis;

import org.example.model.BondCashFlow;
import org.example.model.CashFlowType;
import ru.tinkoff.piapi.contract.v1.Coupon;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CashFlowBuilder {

    public static List<BondCashFlow> build(List<Coupon> coupons, LocalDate maturityDate, double nominal) {
        List<BondCashFlow> flows = new ArrayList<>();

        for (Coupon coupon : coupons) {
            LocalDate date = Instant.ofEpochSecond(coupon.getCouponDate().getSeconds())
                    .atZone(ZoneOffset.UTC)
                    .toLocalDate();
            double amount = coupon.getPayOneBond().getUnits() + coupon.getPayOneBond().getNano() / 1_000_000_000.0;
            flows.add(new BondCashFlow(date, amount, CashFlowType.COUPON));
        }

        flows.add(new BondCashFlow(maturityDate, nominal, CashFlowType.PRINCIPAL));
        flows.sort(Comparator.comparing(BondCashFlow::date));
        return flows;
    }
}