package bikerrents;

import java.time.LocalDateTime;

public class BikeRent {

    private String bikeId;
    private String userId;
    private LocalDateTime dateTime;
    private double km;

    public BikeRent(String bikeId, String userId, LocalDateTime dateTime, double km) {
        this.bikeId = bikeId;
        this.userId = userId;
        this.dateTime = dateTime;
        this.km = km;
    }

    public String getBikeId() {
        return bikeId;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public double getKm() {
        return km;
    }
}
