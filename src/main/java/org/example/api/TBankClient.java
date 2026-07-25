package org.example.api;

import ru.ttech.piapi.core.connector.ConnectorConfiguration;
import ru.ttech.piapi.core.connector.ServiceStubFactory;

public class TBankClient {
    private final ServiceStubFactory serviceFactory;


    public TBankClient(String tokenFile) {

        var configuration =
                ConnectorConfiguration.loadPropertiesFromFile(
                        tokenFile
                );

        this.serviceFactory =
                ServiceStubFactory.create(configuration);
    }


    public ServiceStubFactory getServiceFactory() {
        return serviceFactory;
    }

}
