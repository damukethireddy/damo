package com.example;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.servicebroker.model.*;
import org.springframework.cloud.servicebroker.service.ServiceInstanceService;
import org.springframework.stereotype.Component;

@Component

public class FakeServiceInstanceService implements ServiceInstanceService {
	
	Logger log = LoggerFactory.getLogger("FakeServiceInstanceService");
	
    @Override
    public CreateServiceInstanceResponse createServiceInstance(CreateServiceInstanceRequest req) {
        String serviceInstanceId = req.getServiceInstanceId();
        log.info("Create Service Instance({})", serviceInstanceId);
        return new CreateServiceInstanceResponse();
    }

    @Override
    public GetLastServiceOperationResponse getLastOperation(GetLastServiceOperationRequest req) {
        String serviceInstanceId = req.getServiceInstanceId();
        log.info("Get Last Service Operation({})", serviceInstanceId);
        return new GetLastServiceOperationResponse();
    }

    @Override
    public DeleteServiceInstanceResponse deleteServiceInstance(DeleteServiceInstanceRequest req) {
        String serviceInstanceId = req.getServiceInstanceId();
        log.info("Delete Service Instance({})", serviceInstanceId);
        return new DeleteServiceInstanceResponse();
    }

    @Override
    public UpdateServiceInstanceResponse updateServiceInstance(UpdateServiceInstanceRequest req) {
        String serviceInstanceId = req.getServiceInstanceId();
        log.info("Update Service Instance({})", serviceInstanceId);
        return new UpdateServiceInstanceResponse();
    }
}
