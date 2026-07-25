package org.example;

import org.example.api.BondService;
import org.example.api.CouponService;
import org.example.api.MarketDataService;
import org.example.api.TBankClient;
import org.example.excel.BondExcelExporter;
import org.example.mapper.BondMapper;
import org.example.model.BondInfo;
import ru.tinkoff.piapi.contract.v1.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {

        TBankClient client = new TBankClient("invest.properties");
        BondService bondService = new BondService(client.getServiceFactory());
        MarketDataService marketDataService = new MarketDataService(client.getServiceFactory());
        List<Bond> bonds = bondService.getBonds();
        Map<String, LastPrice> prices = marketDataService.getPrices(bonds);
        List<BondInfo> result = new ArrayList<>();

        for (Bond bond : bonds) {
            LastPrice price = prices.get(bond.getFigi());

            if (price != null) {
                result.add(BondMapper.map(bond, price));
            }
        }

        //BondExcelExporter.export(result, "bonds.xlsx");
        //System.out.println("Выгрузка завершена");

        CouponService couponService =
                new CouponService(
                        client.getServiceFactory()
                );


        var coupons =
                couponService.getCoupons(
                        "BBG00XH4W3N3"
                );


        for (Coupon coupon : coupons) {
            System.out.println(coupon);
        }
    }
}