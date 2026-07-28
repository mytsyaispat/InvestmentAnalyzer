package org.example.api;

import ru.tinkoff.piapi.contract.v1.GetAccountsRequest;
import ru.tinkoff.piapi.contract.v1.UsersServiceGrpc;
import ru.ttech.piapi.core.connector.ServiceStubFactory;

public class AccountService {
    private final ServiceStubFactory factory;

    public AccountService(ServiceStubFactory factory) {
        this.factory = factory;
    }

    public String getAccountId() {
        var service = factory.newSyncService(UsersServiceGrpc::newBlockingStub);
        var response = service.callSyncMethod(stub -> stub.getAccounts(GetAccountsRequest.getDefaultInstance()));
        return response.getAccounts(0).getId();
    }
}