package pe.upc.limapathsbackend.trip.application.services;

import org.springframework.stereotype.Service;
import pe.upc.limapathsbackend.trip.domain.model.aggregates.Trip;
import pe.upc.limapathsbackend.trip.domain.model.commands.CreateTripCommand;
import pe.upc.limapathsbackend.trip.domain.services.TripCommandService;
import pe.upc.limapathsbackend.trip.infrastructure.persistence.jpa.repositories.TripRepository;

import java.util.Optional;

@Service
public class TripCommandServiceImpl implements TripCommandService {

    private final TripRepository tripRepository;

    public TripCommandServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public Optional<Trip> handle(CreateTripCommand command) {

        var trip = new Trip(command);
        tripRepository.save(trip);

        return Optional.of(trip);
    }
}
