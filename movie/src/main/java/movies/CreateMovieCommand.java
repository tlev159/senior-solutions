package movies;

import lombok.Data;

@Data
public class CreateMovieCommand {

    private String name;
    private int length;

}
