package pe.upc.limapathsbackend.buses.interfaces.rest.resources;

import pe.upc.limapathsbackend.buses.domain.model.entities.BusStop;

import java.util.List;

public record BusesResource(Long id, String busName, List<BusStop> stops) {
}
