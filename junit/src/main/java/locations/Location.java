package locations;

public class Location {

    private String name;
    private double lat;
    private double lon;

    public Location() {
    }

    public Location(String name, double lat, double lon) {
        if (lat < -90 || lat > 90) {
            throw new IllegalArgumentException("Latitude parameter is not correct!");
        }
        if (lon < -180 || lon > 180) {
            throw new IllegalArgumentException("Longitude parameter is not correct!");
        }
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    public double distance(Location loc) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(loc.getLat() - this.getLat());
        double lonDistance = Math.toRadians(loc.getLon() - this.getLon());
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(this.getLat())) * Math.cos(Math.toRadians(loc.getLat()))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
//        double distance = R * c * 1000; // convert to meters
        double distance = R * c; // distance in km

        double height = 0.0;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return name + "," + lat + "," + lon;
    }
}
