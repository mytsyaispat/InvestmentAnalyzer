package org.example.mapper;

import org.example.model.BondInfo;
import org.example.util.TBankUtils;
import ru.tinkoff.piapi.contract.v1.Bond;
import ru.tinkoff.piapi.contract.v1.LastPrice;

public class BondMapper {

    public static BondInfo map(
            Bond bond,
            LastPrice price
    ) {

        BondInfo info = new BondInfo();

        info.setTicker(bond.getTicker());
        info.setFigi(bond.getFigi());
        info.setIsin(bond.getIsin());
        info.setName(bond.getName());

        info.setCurrency(
                bond.getCurrency()
        );

        info.setNominal(
                TBankUtils.toDouble(
                        bond.getNominal()
                )
        );

        info.setAccruedCoupon(
                TBankUtils.toDouble(
                        bond.getAciValue()
                )
        );


        double cleanPrice =
                TBankUtils.cleanPrice(
                        price.getPrice(),
                        bond.getNominal()
                );

        info.setCleanPrice(cleanPrice);


        info.setDirtyPrice(
                cleanPrice +
                        info.getAccruedCoupon()
        );


        info.setCouponsPerYear(
                bond.getCouponQuantityPerYear()
        );


        info.setMaturityDate(
                TBankUtils.toLocalDate(
                        bond.getMaturityDate()
                )
        );


        info.setCountryOfRisk(
                bond.getCountryOfRiskName()
        );

        info.setSector(
                bond.getSector()
        );

        info.setRiskLevel(
                Integer.toString(bond.getRiskLevelValue())
        );


        return info;
    }
}
