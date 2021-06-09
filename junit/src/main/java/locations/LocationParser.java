package locations;

public class LocationParser {

    private static final String SEPARATE = ",";

    public Location parse(String text) {
        String[] temp = text.split(SEPARATE);
        return new Location(temp[0], Double.parseDouble(temp[1]), Double.parseDouble(temp[2]));
    }
}
