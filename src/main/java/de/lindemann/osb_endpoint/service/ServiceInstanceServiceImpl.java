package de.lindemann.osb_endpoint.service;

import de.lindemann.osb_endpoint.exception.BadRequestException;
import de.lindemann.osb_endpoint.exception.OsbNotFoundException;
import de.lindemann.osb_endpoint.model.OsbServiceInstance;
import de.lindemann.osb_endpoint.cache.ServiceInstanceCache;
import de.lindemann.osb_endpoint.util.DashboardUrlGenerator;
import de.lindemann.osb_endpoint.validator.ServiceInstanceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceInstanceServiceImpl implements ServiceInstanceService {

    @Autowired
    private ServiceInstanceCache serviceInstanceCache;

    @Autowired
    private DashboardUrlGenerator dashboardUrlGenerator;

    @Autowired
    private ServiceInstanceValidator serviceInstanceValidator;

    @Override
    public String saveServiceInstance(OsbServiceInstance serviceInstance, String serviceInstanceId) throws BadRequestException {
        serviceInstanceValidator.validateServiceInstance(serviceInstance);
        serviceInstanceCache.put(serviceInstanceId,serviceInstance);
        return dashboardUrlGenerator.generateDashboardUrl();
    }



    @Override
    public void deleteServiceInstance(String serviceInstanceId) {
        serviceInstanceCache.delete(serviceInstanceId);
    }

    @Override
    public OsbServiceInstance getInstanceById(String id) throws OsbNotFoundException {
        return serviceInstanceCache.get(id).orElseThrow(OsbNotFoundException::new);
    }
}
