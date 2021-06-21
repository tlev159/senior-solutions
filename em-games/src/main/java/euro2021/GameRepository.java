package euro2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GameRepository {

    private static final String SEPARATE = ";";
    private List<Game> games = new ArrayList<>();

    public void addGame(Game game) {
        if(game == null) {
            throw new IllegalArgumentException("Game can not be null!");
        }
        games.add(game);
    }

    public void addGameFromCsv(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)){
            String line;
            addGameFromLine(reader);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file!", ioe);
        }
    }

    private void addGameFromLine(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] temp = line.split(SEPARATE);
            addGame(new Game(temp[0], temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3])));
        }
    }

    public List<Game> getGames() {
        return new ArrayList<>(games);
    }
}
