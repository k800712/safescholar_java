package safescholar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import safescholar.model.BusRoute;
import safescholar.repository.BusRouteRepository;

import java.util.List;

@Service
public class BusRouteService {
    private final BusRouteRepository busRouteRepository;

    @Autowired
    public BusRouteService(BusRouteRepository busRouteRepository) {
        this.busRouteRepository = busRouteRepository;
    }

    public List<BusRoute> searchBusRoutes(String query) {
        return busRouteRepository.findByRouteNumberContaining(query);
    }
}
