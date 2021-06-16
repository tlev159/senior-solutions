package locations;

import javax.crypto.SealedObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LocationServices {

    public static final String SEPARATE = ",";

    List<Location> locations = new ArrayList<>();

    public List<Location> readLocationsFromCsv(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(SEPARATE);
                locations.add(new Location(temp[0], Double.parseDouble(temp[1]), Double.parseDouble(temp[2])));
            }
            return locations;
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file!", ioe);
        }
    }
}
