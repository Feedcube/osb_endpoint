package de.lindemann.osb_endpoint.service;

import de.lindemann.osb_endpoint.exception.BadRequestException;
import de.lindemann.osb_endpoint.exception.OsbNotFoundException;
import de.lindemann.osb_endpoint.model.OsbServiceInstance;
import org.springframework.stereotype.Service;

@Service
public interface ServiceInstanceService {
    String saveServiceInstance(OsbServiceInstance osbServiceInstance, String serviceInstanceId) throws BadRequestException;
    void deleteServiceInstance(String serviceInstanceId);
    OsbServiceInstance getInstanceById(String id) throws OsbNotFoundException;
}
