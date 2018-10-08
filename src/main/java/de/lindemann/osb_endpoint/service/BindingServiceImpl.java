package de.lindemann.osb_endpoint.service;

import de.lindemann.osb_endpoint.cache.ServiceInstanceCache;
import de.lindemann.osb_endpoint.exception.OsbNotFoundException;
import de.lindemann.osb_endpoint.model.Binding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BindingServiceImpl implements BindingService {

    @Autowired
    private ServiceInstanceCache instanceCache;


    @Override
    public void saveBindig(Binding binding, String bindingId, String instanceId) throws OsbNotFoundException {
        binding.setBinding_id(bindingId);
        instanceCache.get(instanceId).orElseThrow(OsbNotFoundException::new).getBindings().add(binding);
    }

    @Override
    public void deleteBinding(String bindingId, String instanceId) throws OsbNotFoundException {
        instanceCache.get(instanceId).orElseThrow(OsbNotFoundException::new).getBindings().removeIf(binding -> binding.getBinding_id().equals(bindingId));
    }

    @Override
    public Binding getBindingById(String bindingId, String instanceId) throws OsbNotFoundException {
        return instanceCache.get(instanceId).orElseThrow(OsbNotFoundException::new).getBindings().stream().filter(binding -> binding.getBinding_id().equals(bindingId)).findFirst().orElseThrow(OsbNotFoundException::new);
    }
}
