package de.lindemann.osb_endpoint.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DashboardUrlGenerator {

    public String generateDashboardUrl(){
        return "myservice-dashboard.example.com/" + UUID.randomUUID().toString();
    }
}
