package pe.upc.limapathsbackend.buses.domain.services;

import org.springframework.stereotype.Service;
import pe.upc.limapathsbackend.buses.domain.model.aggregates.Bus;
import pe.upc.limapathsbackend.buses.domain.model.queries.GetAllBusesQuery;
import pe.upc.limapathsbackend.buses.domain.model.queries.GetBusByIdQuery;

import java.util.List;
import java.util.Optional;

@Service
public interface BusesQueryService {
    Optional<Bus> handle(GetBusByIdQuery query);
    List<Bus> handle(GetAllBusesQuery query);
}
