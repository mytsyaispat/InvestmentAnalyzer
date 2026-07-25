package org.example.analysis;

import org.example.api.CouponService;
import org.example.model.BondCashFlow;
import org.example.model.BondInfo;
import ru.tinkoff.piapi.contract.v1.Coupon;

import java.time.LocalDate;
import java.util.List;

public class BondCalculationService {

    private final CouponService couponService;


    public BondCalculationService(CouponService couponService) {
        this.couponService = couponService;
    }


    public void calculate(BondInfo bond) {

        List<Coupon> coupons =
                couponService.getCoupons(
                        bond.getFigi()
                );


        List<BondCashFlow> flows =
                CashFlowBuilder.build(
                        coupons,
                        bond.getMaturityDate(),
                        bond.getNominal()
                );


        double ytm =
                YieldCalculator.calculateYtm(
                        bond.getDirtyPrice(),
                        flows,
                        LocalDate.now()
                );


        bond.setYtm(
                ytm * 100
        );
    }
}