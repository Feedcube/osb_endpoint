package de.lindemann.osb_endpoint.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OsbService {
    private String name;
    private String id;
    private String description;
    private boolean bindable;
    private List<Plan> plans = new ArrayList<>();
}
