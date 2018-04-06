package com.valuelabs.FBIntegration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceRequest;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceResponse;
import org.springframework.cloud.servicebroker.model.DeleteServiceInstanceRequest;
import org.springframework.cloud.servicebroker.model.DeleteServiceInstanceResponse;
import org.springframework.cloud.servicebroker.model.GetLastServiceOperationRequest;
import org.springframework.cloud.servicebroker.model.GetLastServiceOperationResponse;
import org.springframework.cloud.servicebroker.model.UpdateServiceInstanceRequest;
import org.springframework.cloud.servicebroker.model.UpdateServiceInstanceResponse;
import org.springframework.cloud.servicebroker.service.ServiceInstanceService;
import org.springframework.stereotype.Service;

/**
 * Mongo impl to manage service instances.  Creating a service does the following:
 * creates a new database,
 * saves the ServiceInstance info to the Mongo repository.
 *  
 * @author sgreenberg@pivotal.io
 */
@Service
public class FacebookServiceInstanceService implements ServiceInstanceService {

	Logger log = LoggerFactory.getLogger("FacebookServiceInstanceService");

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