package de.lindemann.osb_endpoint.cache;

import de.lindemann.osb_endpoint.model.Binding;
import de.lindemann.osb_endpoint.model.Plan;
import de.lindemann.osb_endpoint.model.OsbService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ServiceCache  extends AbstractCache<OsbService> {

    @PostConstruct
    private void init(){
        OsbService osbService = new OsbService();
        osbService.setName("mysql-prod");
        osbService.setId("1");
        osbService.setBindable(true);
        osbService.setDescription("The MySQL database for the production environment");

        Plan plan = new Plan();
        plan.setName("default-plan");
        plan.setDescription("The default plan");
        plan.setId("1");
        osbService.getPlans().add(plan);
        plan = new Plan();
        plan.setName("another-plan");
        plan.setDescription("another plan");
        plan.setId("2");
        osbService.getPlans().add(plan);
        this.put("1", osbService);
    }
}
