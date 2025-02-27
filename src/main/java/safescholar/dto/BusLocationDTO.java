package safescholar.dto;

import java.time.LocalDateTime;

public class BusLocationDTO {

    private Long id;
    private Long busRouteId;
    private String routeNumber;
    private double latitude;
    private double longitude;
    private LocalDateTime timestamp;


    public BusLocationDTO() {
    }


    public BusLocationDTO(Long id, Long busRouteId, String routeNumber, double latitude, double longitude, LocalDateTime timestamp) {
        this.id = id;
        this.busRouteId = busRouteId;
        this.routeNumber = routeNumber;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBusRouteId() {
        return busRouteId;
    }

    public void setBusRouteId(Long busRouteId) {
        this.busRouteId = busRouteId;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
