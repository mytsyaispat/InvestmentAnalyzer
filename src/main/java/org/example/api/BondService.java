package org.example.api;

import org.example.mapper.BondMapper;
import org.example.model.BondInfo;
import ru.tinkoff.piapi.contract.v1.InstrumentsRequest;
import ru.tinkoff.piapi.contract.v1.InstrumentsServiceGrpc;
import ru.ttech.piapi.core.connector.ServiceStubFactory;

import java.util.List;

public class BondService {
    private final InstrumentsServiceGrpc.InstrumentsServiceBlockingStub service;

    public BondService(ServiceStubFactory factory) {
        this.service = factory.newSyncService(InstrumentsServiceGrpc::newBlockingStub).getStub();
    }

    public List<BondInfo> getAllBonds() {
        var response = service.bonds(InstrumentsRequest.getDefaultInstance());

        return response.getInstrumentsList()
                .stream()
                .map(BondMapper::toBondInfo)
                .toList();
    }

    public List<BondInfo> getMyBonds() {
        return null; //TODO 123
    }
}