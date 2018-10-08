package de.lindemann.osb_endpoint.validator;

import de.lindemann.osb_endpoint.exception.BadRequestException;
import de.lindemann.osb_endpoint.model.OsbServiceInstance;
import de.lindemann.osb_endpoint.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceInstanceValidator {

    @Autowired
    private CatalogService catalogService;

    public void validateServiceInstance(OsbServiceInstance serviceInstance) throws BadRequestException {
        if(!catalogService.isServiceAvailable(serviceInstance.getService_id(),serviceInstance.getPlan_id())){
            throw new BadRequestException();
        }
    }
}
