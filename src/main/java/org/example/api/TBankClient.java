package org.example.api;

import ru.ttech.piapi.core.connector.ConnectorConfiguration;
import ru.ttech.piapi.core.connector.ServiceStubFactory;

public class TBankClient {
    private static ServiceStubFactory serviceFactory;

    public TBankClient(String tokenFile) {
        var configuration = ConnectorConfiguration.loadPropertiesFromFile(tokenFile);
        serviceFactory = ServiceStubFactory.create(configuration);
    }

    public TBankClient() {
        var configuration = ConnectorConfiguration.loadPropertiesFromFile("invest.properties");
        serviceFactory = ServiceStubFactory.create(configuration);
    }

    public static ServiceStubFactory getServiceFactory() {
        return serviceFactory;
    }

}
