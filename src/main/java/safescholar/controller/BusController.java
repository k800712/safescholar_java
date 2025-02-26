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

    @GetMapping("/stops")
    public List<BusStop> getNearbyBusStops(@RequestParam double lat, @RequestParam double lon) {
        return busService.getNearbyBusStops(lat, lon);
    }
}
