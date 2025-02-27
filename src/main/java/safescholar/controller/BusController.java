package safescholar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import safescholar.model.BusStop;
import safescholar.service.BusService;

import java.util.List;

@RestController
@RequestMapping("/api/bus")
public class BusController {
    private final BusService busService;

    @Autowired
    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping("/stops/nearby")
    public List<BusStop> getNearbyBusStops(
            @RequestParam double lat,
            @RequestParam double lon,
            @RequestParam(defaultValue = "1000") double radius) {
        return busService.getNearbyBusStops(lat, lon, radius);
    }

    // 추가 버스 관련 엔드포인트들을 여기에 구현할 수 있습니다.
}
