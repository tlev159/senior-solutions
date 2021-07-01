package movies;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private AtomicLong id = new AtomicLong();

    private List<Movie> movies = new ArrayList<>(List.of(
            new Movie(id.getAndIncrement(), "Titanic", 120),
            new Movie(id.getAndIncrement(), "Batman", 110),
            new Movie(id.getAndIncrement(), "Avengers", 190)
    ));

    private ModelMapper modelMapper;

    public MovieService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<MovieDto> listMovies(Optional<String> title) {
        List<Movie> filteredMovies = movies.stream()
                .filter(m -> m.getName().equalsIgnoreCase(title.get()))
                .collect(Collectors.toList());
        Type targetListType = new TypeToken<List<MovieDto>>() {
        }.getType();
        return modelMapper.map(filteredMovies, targetListType);
    }

    public MovieDto editMovieLength(long id, EditLengthCommand command) {
        Movie movie = movies.stream()
                .filter(m -> m.getId() == id)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Movie not found: " + id));
        movie.setLength(command.getLength());
        return modelMapper.map(movie, MovieDto.class);
    }

    public MovieDto findMovieById(long id) {
        Movie movie = movies.stream()
                .filter(m -> m.getId() == id)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Movie not found: " + id));
        return modelMapper.map(movie, MovieDto.class);
    }

    public void deleteMovieById(long id) {
        Movie movie = movies.stream()
                .filter(m -> m.getId() == id)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Movie not found: " + id));
        movies.remove(movie);
    }

    public MovieDto createMovie(CreateMovieCommand command) {
        Movie movie = new Movie(id.getAndIncrement(), command.getName(), command.getLength());
        movies.add(movie);
        return modelMapper.map(movie, MovieDto.class);
    }

//    public List<MovieDto> listMovies(Optional<String> title) {
//        Type targetListType = new TypeToken<List<MovieDto>>(){}.getType();
//        return modelMapper.map(targetListType, MovieDto.class);
//    }
}
