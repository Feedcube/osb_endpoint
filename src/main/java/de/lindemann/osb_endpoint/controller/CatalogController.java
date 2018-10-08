package de.lindemann.osb_endpoint.controller;

import de.lindemann.osb_endpoint.model.Catalog;
import de.lindemann.osb_endpoint.model.OsbService;
import de.lindemann.osb_endpoint.service.CatalogService;
import de.lindemann.osb_endpoint.service.ServiceInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatalogController  {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/v2/catalog")
    public Catalog getAllServices(){
        return catalogService.getCatalog();
    }
}
