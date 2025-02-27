package safescholar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import safescholar.model.BusStop;
import safescholar.repository.BusStopRepository;

import java.util.List;

@Service
public class BusService {
    private final BusStopRepository busStopRepository;

    @Autowired
    public BusService(BusStopRepository busStopRepository) {
        this.busStopRepository = busStopRepository;
    }

    public List<BusStop> getNearbyBusStops(double lat, double lon, double radius) {
        double earthRadius = 6371; // 지구의 반경 (km)
        double latDelta = radius / earthRadius * (180 / Math.PI);
        double lonDelta = radius / (earthRadius * Math.cos(Math.toRadians(lat))) * (180 / Math.PI);

        double minLat = lat - latDelta;
        double maxLat = lat + latDelta;
        double minLon = lon - lonDelta;
        double maxLon = lon + lonDelta;

        return busStopRepository.findByLatitudeBetweenAndLongitudeBetween(minLat, maxLat, minLon, maxLon);
    }

    // 추가 버스 관련 메서드들을 여기에 구현할 수 있습니다.
}
