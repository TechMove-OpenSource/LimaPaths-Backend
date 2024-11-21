package pe.upc.limapathsbackend.buses.application.services;

import org.springframework.stereotype.Service;
import pe.upc.limapathsbackend.buses.domain.model.aggregates.Bus;
import pe.upc.limapathsbackend.buses.domain.model.queries.GetAllBusesQuery;
import pe.upc.limapathsbackend.buses.domain.model.queries.GetBusByIdQuery;
import pe.upc.limapathsbackend.buses.domain.services.BusesQueryService;
import pe.upc.limapathsbackend.buses.infrastructure.persistence.jpa.repositories.BusRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BusesQueryServiceImpl implements BusesQueryService {
    private final BusRepository busRepository;

    public BusesQueryServiceImpl(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public Optional<Bus> handle(GetBusByIdQuery query) {
        return busRepository.findById(query.id());
    }

    @Override
    public List<Bus> handle(GetAllBusesQuery query) {
        return busRepository.findAll();
    }
}
