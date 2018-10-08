package de.lindemann.osb_endpoint.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Catalog {
    private List<OsbService> services;
}
