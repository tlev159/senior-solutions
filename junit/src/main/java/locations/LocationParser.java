package locations;

public class LocationParser {

    private static final String SEPARATE = ",";

    public Location parse(String text) {
        String[] temp = text.split(SEPARATE);
        return new Location(temp[0], Double.parseDouble(temp[1]), Double.parseDouble(temp[2]));
    }

    public boolean isOnEquator(String text) {
        return parse(text).getLat() == 0;
    }

    public boolean isOnPrime(String text) {
        return parse(text).getLon() == 0;
    }

}
