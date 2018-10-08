package de.lindemann.osb_endpoint.service;

import de.lindemann.osb_endpoint.exception.OsbNotFoundException;
import de.lindemann.osb_endpoint.model.Binding;
import de.lindemann.osb_endpoint.model.OsbServiceInstance;
import org.springframework.stereotype.Service;

@Service
public interface BindingService {
    void saveBindig(Binding binding, String bindingId, String instanceId) throws OsbNotFoundException;
    void deleteBinding(String bindingId , String instanceId) throws OsbNotFoundException;
    Binding getBindingById(String bindingId, String instanceId) throws OsbNotFoundException;

}
