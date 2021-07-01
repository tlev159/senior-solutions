package movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private Long id;
    private String name;
    private int length;
    private List<Integer> ratings = new ArrayList<>();
    private double ratingsAverage;

    public Movie(Long id, String name, int length) {
        this.id = id;
        this.name = name;
        this.length = length;
    }

    public void addRating(int rating) {
        ratings.add(rating);
        ratingsAverage = ratings.stream()
                .collect(Collectors.summarizingInt(Integer::intValue))
                .getAverage();
    }
}
