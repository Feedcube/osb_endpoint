package de.lindemann.osb_endpoint.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Getter
@Setter
public class Binding {
    @NotNull
    protected String service_id;
    @NotNull
    private String plan_id;

    private String binding_id;
    private String app_guid;
    private BindResource bind_resource;
    private Map<String, Object> context;
    private Map<String, Object> parameters;

}
