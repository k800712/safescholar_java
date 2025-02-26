package safescholar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import safescholar.model.BusRoute;
import safescholar.service.BusRouteService;

import java.util.List;

@RestController
@RequestMapping("/api/bus-routes")
public class BusRouteController {
    private final BusRouteService busRouteService;

    @Autowired
    public BusRouteController(BusRouteService busRouteService) {
        this.busRouteService = busRouteService;
    }

    @GetMapping("/search")
    public List<BusRoute> searchBusRoutes(@RequestParam String query) {
        return busRouteService.searchBusRoutes(query);
    }
}
