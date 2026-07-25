package org.example.mapper;

import org.example.model.BondCashFlow;
import org.example.util.TBankUtils;
import ru.tinkoff.piapi.contract.v1.Coupon;

import java.util.List;

public class CouponMapper {
    public static List<BondCashFlow> map(
            List<Coupon> coupons
    ) {

        return coupons.stream()
                .map(coupon ->
                        new BondCashFlow(
                                TBankUtils.toLocalDate(
                                        coupon.getCouponDate()
                                ),

                                TBankUtils.toDouble(
                                        coupon.getPayOneBond()
                                )
                        )
                )
                .toList();
    }
}
