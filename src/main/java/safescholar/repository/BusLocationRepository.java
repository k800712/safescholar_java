package safescholar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import safescholar.model.BusLocation;
import safescholar.model.BusRoute;

import java.util.List;

@Repository
public interface BusLocationRepository extends JpaRepository<BusLocation, Long> {
    List<BusLocation> findByBusRoute(BusRoute busRoute);
    BusLocation findTopByBusRouteOrderByTimestampDesc(BusRoute busRoute);
}
