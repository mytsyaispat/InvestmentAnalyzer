package org.example.mapper;

import org.example.analysis.PriceCalculator;
import org.example.api.MarketDataService;
import org.example.model.BondInfo;
import org.example.util.TBankUtils;
import ru.tinkoff.piapi.contract.v1.Bond;

import static org.example.util.TBankUtils.toDouble;

public class BondMapper {

    public static BondInfo toBondInfo(Bond bond) {
        BondInfo info = new BondInfo();
        //MarketDataService market = new MarketDataService()
        //double cleanPrice = PriceCalculator.calculateCleanPrice(price, toDouble(bond.getNominal()));

        info.setTicker(bond.getTicker());
        info.setFigi(bond.getFigi());
        info.setIsin(bond.getIsin());
        info.setName(bond.getName());
        info.setCurrency(bond.getCurrency());
        info.setNominal(toDouble(bond.getNominal()));

        info.setAccruedCoupon(toDouble(bond.getAciValue()));
        //info.setCleanPrice(cleanPrice);
        //info.setDirtyPrice(PriceCalculator.calculateDirtyPrice(cleanPrice, info.getAccruedCoupon()));
        info.setCouponsPerYear(bond.getCouponQuantityPerYear());
        info.setMaturityDate(TBankUtils.toLocalDate(bond.getMaturityDate()));
        info.setCountryOfRisk(bond.getCountryOfRiskName());
        info.setSector(bond.getSector());
        info.setRiskLevel(Integer.toString(bond.getRiskLevelValue()));

        return info;
    }
}
