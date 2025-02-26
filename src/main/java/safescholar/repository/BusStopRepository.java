package safescholar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import safescholar.model.BusStop;

import java.util.List;

public interface BusStopRepository extends JpaRepository<BusStop, Long> {
    List<BusStop> findByLatitudeBetweenAndLongitudeBetween(double minLat, double maxLat, double minLon, double maxLon);
}
