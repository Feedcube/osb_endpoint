package de.lindemann.osb_endpoint.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.lindemann.osb_endpoint.exception.BadRequestException;
import de.lindemann.osb_endpoint.exception.OsbNotFoundException;
import de.lindemann.osb_endpoint.model.Binding;
import de.lindemann.osb_endpoint.model.OsbServiceInstance;
import de.lindemann.osb_endpoint.service.BindingService;
import de.lindemann.osb_endpoint.service.ServiceInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ServiceInstanceController {


    @Autowired
    private ServiceInstanceService instanceService;


    @Autowired
    private BindingService bindingService;

    @PutMapping("/v2/service_instances/{instance_id}")
    public String saveServiceInstance(@Validated @RequestBody OsbServiceInstance serviceInstance,
                                      @PathVariable("instance_id") String instanceId,
                                      HttpServletResponse response) throws BadRequestException {
        String dashboardUrl = instanceService.saveServiceInstance(serviceInstance, instanceId);
        response.setStatus(201);

        return dashboardUrl;
    }
    @DeleteMapping("/v2/service_instances/{instance_id}")
    public void deleteServiceInstance( @PathVariable("instance_id") String instanceId,
                                       @RequestParam("service_id") String serviceId,
                                       @RequestParam("plan_id") String planId){
        instanceService.deleteServiceInstance(instanceId);
    }

    @GetMapping("/v2/service_instances/{instance_id}")
    public OsbServiceInstance getServiceInstance(@PathVariable("instance_id") String instanceId) throws OsbNotFoundException {
        return instanceService.getInstanceById(instanceId);
    }

    @PutMapping("/v2/service_instances/{instance_id}/service_bindings/{binding_id}")
    public void saveBinding(@Validated @RequestBody Binding binding,
                            @PathVariable("instance_id") String instanceId,
                            @PathVariable("binding_id") String bindingId,
                            HttpServletResponse response) throws OsbNotFoundException {
        bindingService.saveBindig(binding,bindingId,instanceId);
        response.setStatus(201);
    }

    @DeleteMapping("/v2/service_instances/{instance_id}/service_bindings/{binding_id}")
    public void deleteBinding(@PathVariable("instance_id") String instanceId,
                              @PathVariable("binding_id") String bindingId,
                              @RequestParam("service_id") String serviceId,
                              @RequestParam("plan_id") String planId) throws OsbNotFoundException {
        bindingService.deleteBinding(bindingId,instanceId);
    }

    @GetMapping("/v2/service_instances/{instance_id}/service_bindings/{binding_id}")
    public Binding getServiceInstance(@PathVariable("instance_id") String instanceId,
                                      @PathVariable("binding_id") String bindingId) throws OsbNotFoundException {
        return bindingService.getBindingById(bindingId,instanceId);
    }

}
