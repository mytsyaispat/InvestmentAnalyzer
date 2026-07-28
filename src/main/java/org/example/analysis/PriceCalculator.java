package org.example.analysis;

import ru.tinkoff.piapi.contract.v1.LastPrice;

public class PriceCalculator {

    public static double calculateCleanPrice(LastPrice price, double nominal) {
        double percent = price.getPrice().getUnits() + price.getPrice().getNano() / 1_000_000_000.0;
        return percent / 100 * nominal;
    }

    public static double calculateDirtyPrice(double cleanPrice, double accruedCoupon) {
        return cleanPrice + accruedCoupon;
    }
}