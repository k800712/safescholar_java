package safescholar.service;

import org.springframework.stereotype.Service;
import safescholar.model.BusStop;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusService {
    public List<BusStop> getNearbyBusStops(double lat, double lon) {
        // Implementation to get nearby bus stops
        return new ArrayList<>();
    }
}
