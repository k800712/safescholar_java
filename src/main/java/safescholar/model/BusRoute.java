package safescholar.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bus_routes")
public class BusRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String routeNumber;

    @Column
    private String description;

    @ManyToMany
    @JoinTable(
            name = "route_stops",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "stop_id")
    )
    private Set<BusStop> busStops = new HashSet<>();

    @OneToMany(mappedBy = "busRoute", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BusLocation> busLocations = new ArrayList<>();

    public BusRoute() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<BusStop> getBusStops() {
        return busStops;
    }

    public void setBusStops(Set<BusStop> busStops) {
        this.busStops = busStops;
    }

    public List<BusLocation> getBusLocations() {
        return busLocations;
    }

    public void setBusLocations(List<BusLocation> busLocations) {
        this.busLocations = busLocations;
    }

}
