
package safescholar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import safescholar.model.BusRoute;

import java.util.List;

public interface BusRouteRepository extends JpaRepository<BusRoute, Long> {
    List<BusRoute> findByRouteNumberContaining(String routeNumber);
}
