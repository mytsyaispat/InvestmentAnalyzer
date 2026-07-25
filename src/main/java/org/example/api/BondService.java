package org.example.api;

import ru.tinkoff.piapi.contract.v1.Bond;
import ru.tinkoff.piapi.contract.v1.InstrumentsRequest;
import ru.tinkoff.piapi.contract.v1.InstrumentsServiceGrpc;
import ru.ttech.piapi.core.connector.ServiceStubFactory;

import java.util.List;

public class BondService {
    private final ServiceStubFactory factory;


    public BondService(ServiceStubFactory factory) {
        this.factory = factory;
    }


    public List<Bond> getBonds() {

        var service =
                factory.newSyncService(
                        InstrumentsServiceGrpc::newBlockingStub
                );


        var response =
                service.callSyncMethod(
                        stub -> stub.bonds(
                                InstrumentsRequest
                                        .getDefaultInstance()
                        )
                );


        return response.getInstrumentsList();
    }
}
