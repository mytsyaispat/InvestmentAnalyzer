package org.example.api;

import ru.tinkoff.piapi.contract.v1.Bond;
import ru.tinkoff.piapi.contract.v1.GetLastPricesRequest;
import ru.tinkoff.piapi.contract.v1.LastPrice;
import ru.tinkoff.piapi.contract.v1.MarketDataServiceGrpc;
import ru.ttech.piapi.core.connector.ServiceStubFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketDataService {

    private final ServiceStubFactory factory;


    public MarketDataService(ServiceStubFactory factory) {
        this.factory = factory;
    }


    public Map<String, LastPrice> getPrices(List<Bond> bonds) {

        var service =
                factory.newSyncService(
                        MarketDataServiceGrpc::newBlockingStub
                );


        var request =
                GetLastPricesRequest.newBuilder();


        for (Bond bond : bonds) {

            request.addInstrumentId(
                    bond.getFigi()
            );
        }


        var response =
                service.callSyncMethod(
                        stub -> stub.getLastPrices(
                                request.build()
                        )
                );


        Map<String, LastPrice> result =
                new HashMap<>();


        for (LastPrice price : response.getLastPricesList()) {

            result.put(
                    price.getFigi(),
                    price
            );
        }


        return result;
    }
}