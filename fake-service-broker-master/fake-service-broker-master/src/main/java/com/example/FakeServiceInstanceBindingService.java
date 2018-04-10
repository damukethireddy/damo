package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceAppBindingResponse;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceBindingResponse;
import org.springframework.cloud.servicebroker.model.DeleteServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.service.ServiceInstanceBindingService;
import org.springframework.stereotype.Component;

@Component

public class FakeServiceInstanceBindingService implements ServiceInstanceBindingService {

	Logger log = LoggerFactory.getLogger("FakeServiceInstanceBindingService");
	
    @Override
    public CreateServiceInstanceBindingResponse createServiceInstanceBinding(CreateServiceInstanceBindingRequest req) {
        String serviceInstanceId = req.getServiceInstanceId();
        String bindingId = req.getBindingId();
        log.info("Create Service Binding({}) for Service({})", bindingId, serviceInstanceId);
        Map<String, Object> credentials = new HashMap<String, Object>() {{
            put("url", "http://example.com/" + UUID.randomUUID());
            put("username", UUID.randomUUID());
            put("password", UUID.randomUUID());
        }};
        return new CreateServiceInstanceAppBindingResponse().withCredentials(credentials);
    }

    @Override
    public void deleteServiceInstanceBinding(DeleteServiceInstanceBindingRequest req) {
        String serviceInstanceId = req.getServiceInstanceId();
        String bindingId = req.getBindingId();
        log.info("Delete Service Binding({}) for Service({})", bindingId, serviceInstanceId);
    }
}
