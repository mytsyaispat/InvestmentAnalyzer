package org.example;

import org.example.api.*;
import org.example.excel.BondExcelExporter;
import org.example.mapper.BondMapper;
import org.example.model.BondInfo;
import ru.tinkoff.piapi.contract.v1.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        new TBankClient();
        PortfolioService portfolioService = new PortfolioService(TBankClient.getServiceFactory());
        System.out.println(portfolioService.getPortfolio(new AccountService(TBankClient.getServiceFactory()).getAccountId()));
//        BondService bondService = new BondService(TBankClient.getServiceFactory());
//        MarketDataService marketDataService = new MarketDataService(TBankClient.getServiceFactory());
//        List<BondInfo> bonds = bondService.getAllBonds();
//        Map<String, LastPrice> prices = marketDataService.getPrices(bonds);
//        List<BondInfo> result = new ArrayList<>();

//        for (Bond bond : bonds) {
//            LastPrice price = prices.get(bond.getFigi());
//
//            if (price != null) {
//                result.add(BondMapper.toBondInfo(bond, price));
//            }
//        }

        //BondExcelExporter.export(result, "bonds.xlsx");
        //System.out.println("Выгрузка завершена");

//        CouponService couponService = new CouponService(TBankClient.getServiceFactory());
//
//
//        var coupons = couponService.getCoupons("BBG00XH4W3N3");
//
//        for (Coupon coupon : coupons) {
//            System.out.println(coupon);
//        }
    }
}