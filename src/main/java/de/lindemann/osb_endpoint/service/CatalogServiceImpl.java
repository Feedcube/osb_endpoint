package de.lindemann.osb_endpoint.service;

import de.lindemann.osb_endpoint.model.Catalog;
import de.lindemann.osb_endpoint.cache.ServiceCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CatalogServiceImpl implements CatalogService{

    @Autowired
    private ServiceCache serviceCache;

    @Override
    public Catalog getCatalog() {
        return new Catalog(serviceCache.getAll());
    }

    @Override
    public boolean isServiceAvailable(String serviceId, String planId) {
        return serviceCache.getAll().stream().anyMatch(osbService -> osbService.getId().equals(serviceId) && osbService.getPlans().stream().anyMatch(plan -> plan.getId().equals(planId)));
    }
}
