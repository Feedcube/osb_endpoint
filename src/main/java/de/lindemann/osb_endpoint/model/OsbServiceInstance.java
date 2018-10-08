package de.lindemann.osb_endpoint.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.*;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"context","parameters"})
public class OsbServiceInstance {
    @NotNull
    private String service_id;
    @NotNull
    private String plan_id;
    @NotNull
    private String organization_guid;
    @NotNull
    private String space_guid;


    private Map<String, Object> context;
    private Map<String, Object> parameters;
    @JsonIgnore
    private Set<Binding> bindings = new HashSet<>();
}
