package bikerrents;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BikeService {

    private List<BikeRent> bikeRents = new ArrayList<>();

    public List<BikeRent> getBikeRents() {
        if (bikeRents.isEmpty()) {
            readDatasFromCsv();
        }
        return new ArrayList<>(bikeRents);
    }

    public List<String> getUserList() {
        return bikeRents.stream()
                .map(BikeRent::getUserId)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    private void readDatasFromCsv() {
        List<BikeRent> result = new ArrayList<>();
        Path file = Path.of("src/main/resources/bikes.csv");
        try(BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                addBikeRent(line.split(";"));
            }
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file!", ioe);
        }
    }

    private void addBikeRent(String[] rental) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(rental[2], formatter);
        bikeRents.add(new BikeRent(rental[0], rental[1], dateTime, Double.parseDouble(rental[3])));
    }

    public List<BikeRent> getBikeRent() {
        return bikeRents;
    }
}
