package pe.upc.limapathsbackend.buses.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.limapathsbackend.buses.domain.model.entities.BusStop;

import java.util.List;

public interface BusStopRepository extends JpaRepository<BusStop, Long> {
    List<BusStop> findByBus_Id(Long busId);
}
