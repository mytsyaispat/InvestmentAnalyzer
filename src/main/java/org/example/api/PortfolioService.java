package org.example.api;

import ru.tinkoff.piapi.contract.v1.OperationsServiceGrpc;
import ru.tinkoff.piapi.contract.v1.PortfolioPosition;
import ru.tinkoff.piapi.contract.v1.PortfolioRequest;
import ru.tinkoff.piapi.contract.v1.PortfolioResponse;
import ru.ttech.piapi.core.connector.ServiceStubFactory;

import java.util.List;

public class PortfolioService {
    private final ServiceStubFactory factory;

    public PortfolioService(ServiceStubFactory factory) {
        this.factory = factory;
    }
    
    public List<PortfolioPosition> getPortfolio(String accountId) {
        var service = factory.newSyncService(OperationsServiceGrpc::newBlockingStub);
        PortfolioRequest request = PortfolioRequest.newBuilder().setAccountId(accountId).build();
        PortfolioResponse response = service.callSyncMethod(stub -> stub.getPortfolio(request));
        return response.getPositionsList();
    }
}