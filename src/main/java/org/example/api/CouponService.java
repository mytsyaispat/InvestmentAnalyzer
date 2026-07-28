package org.example.api;

import ru.tinkoff.piapi.contract.v1.Coupon;
import ru.tinkoff.piapi.contract.v1.GetBondCouponsRequest;
import ru.tinkoff.piapi.contract.v1.InstrumentsServiceGrpc;
import ru.ttech.piapi.core.connector.ServiceStubFactory;

import java.util.List;

public class CouponService {
    private final ServiceStubFactory serviceFactory;

    public CouponService(ServiceStubFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    public List<Coupon> getCoupons(String figi) {
        var instrumentsService = serviceFactory.newSyncService(InstrumentsServiceGrpc::newBlockingStub);
        var request = GetBondCouponsRequest.newBuilder().setFigi(figi).build();
        var response = instrumentsService.callSyncMethod(stub -> stub.getBondCoupons(request));

        return response.getEventsList();
    }
}
