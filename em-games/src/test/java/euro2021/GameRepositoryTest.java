package euro2021;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class GameRepositoryTest {

    GameRepository gameRepository = new GameRepository();

    @Test
    void testAddGameAtTheBeginning() {
        assertThat(gameRepository.getGames())
                .hasSize(0);
    }

    @Test
    void addGame() {
        gameRepository.addGame(new Game("Németország", "Portugália", 2, 1));

        assertThat(gameRepository.getGames())
                .hasSize(1)
                .extracting(Game::getWinnerCountry)
                .contains("Németország");
    }

    @Test
    void addGameFromCsv() {

        gameRepository.addGameFromCsv(Path.of("src/main/resources/results.csv"));

        assertThat(gameRepository.getGames())
                .hasSize(15)
                .extracting(Game::getWinnerCountry, Game::getFirstCountry)
                .contains(tuple("Slovakia", "Poland"),
                        tuple("Draw", "Spain"));
    }
}