package pe.upc.limapathsbackend.buses.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.limapathsbackend.buses.domain.model.aggregates.Bus;

public interface BusRepository extends JpaRepository<Bus, Long> {
}
