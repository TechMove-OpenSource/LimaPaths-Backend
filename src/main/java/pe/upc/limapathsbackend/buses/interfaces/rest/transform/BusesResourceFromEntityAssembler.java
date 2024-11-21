package pe.upc.limapathsbackend.buses.interfaces.rest.transform;

import pe.upc.limapathsbackend.buses.domain.model.aggregates.Bus;
import pe.upc.limapathsbackend.buses.interfaces.rest.resources.BusesResource;

public class BusesResourceFromEntityAssembler {
    public static BusesResource toResourceFromEntity(Bus entity){
        return new BusesResource(
                entity.getId(),
                entity.getBusName(),
                entity.getBusStops()
        );
    }
}
