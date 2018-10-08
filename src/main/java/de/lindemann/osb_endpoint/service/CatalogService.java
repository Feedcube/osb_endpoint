package de.lindemann.osb_endpoint.service;

import de.lindemann.osb_endpoint.model.Catalog;
import org.springframework.stereotype.Service;

@Service
public interface CatalogService {
    Catalog getCatalog();
    boolean isServiceAvailable(String serviceId, String planId);
}
