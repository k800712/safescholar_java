package safescholar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import safescholar.model.BusStop;
import safescholar.service.BusStopService;

import java.util.List;

@RestController
@RequestMapping("/api/bus-stops")
public class BusStopController {
    private final BusStopService busStopService;

    @Autowired
    public BusStopController(BusStopService busStopService) {
        this.busStopService = busStopService;
    }

    @GetMapping("/nearby")
    public List<BusStop> getNearbyBusStops(@RequestParam double lat, @RequestParam double lon, @RequestParam(defaultValue = "1000") double radius) {
        return busStopService.getNearbyBusStops(lat, lon, radius);
    }
}
