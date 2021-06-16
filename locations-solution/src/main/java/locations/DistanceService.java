package locations;

import java.util.Optional;

public class DistanceService {

    private LocationRepository locationRepository;
    private LocationParser locationParser;

    public Optional<Double> calculateDistance(String name1, String name2) {
        boolean firstIsEmpty = locationRepository.findByName(name1).isEmpty();
        boolean secondIsEmpty = locationRepository.findByName(name2).isEmpty();
        if (firstIsEmpty || secondIsEmpty) {
            return Optional.empty();
        } else {
//            return .distance(locationParser.parse(name2));
        }
        return Optional.empty();
    }
}
