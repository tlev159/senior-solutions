package movies;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieDto> listMovies(@RequestParam Optional<String> title) {
        return movieService.listMovies(title);
    }

    @GetMapping("/{id}")
    public MovieDto findMovieById(@PathVariable("id") long id) {
        return movieService.findMovieById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDto createMovie(@RequestBody CreateMovieCommand command) {
        return movieService.createMovie(command);
    }

    @PutMapping("/{id}")
    public MovieDto editMovieLength(@PathVariable("id") long id, @RequestBody EditLengthCommand command) {
        return movieService.editMovieLength(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable("id") long id) {
        movieService.deleteMovieById(id);
    }
//
//    @PostMapping
//    public MovieDto createMovie(@RequestBody AddMovieCommand command) {
//        return movieService.addMovie();
//    }

}
