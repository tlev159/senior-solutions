package euro2021;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameServiceTest {

    GameRepository gameRepository = new GameRepository();
    GameService gameService = new GameService(gameRepository);

    @Test
    void testGetGameWithTheBiggestDifferenceWithNull() {
        assertThat(gameService.getGameWithTheBiggestDifference())
                .isNotPresent();
    }

    @Test
    void testGetGameWithTheBiggestDifference() {

        gameRepository.addGameFromCsv(Path.of("src/main/resources/results.csv"));

        Game game = gameService.getGameWithTheBiggestDifference().get();

        assertThat(game.getWinnerCountry())
                .isEqualTo("Italy");

        assertThat(game.getFirstCountry())
                .isEqualTo("Turkey");

    }

    @Test
    void testGetGameWithTheBiggestDifferenceFromResults2() {

        gameRepository.addGameFromCsv(Path.of("src/main/resources/results2.csv"));

        Game game = gameService.getGameWithTheBiggestDifference().get();

        assertThat(game.getWinnerCountry())
                .isEqualTo("Belgium");
        assertThat(game.getFirstCountry())
                .isEqualTo("Belgium");

    }

    @Test
    void testGetScoredGoalsOfCountry() {

        gameRepository.addGameFromCsv(Path.of("src/main/resources/results2.csv"));

        assertThat(gameService.getScoredGoalsOfCountry("Italy"))
                .isEqualTo(5);
    }

    private Object[][] values = {{"Turkey", 1}, {"Italy", 5}, {"England", 1}, {"Croatia", 0}, {"Sweden", 0}};

    @RepeatedTest(value = 5, name = "Get country from: {currentRepetition}/{totalRepetition}")
    void testGetScoredGoalsOfCountryWithParams(RepetitionInfo repetitionInfo) {

        gameRepository.addGameFromCsv(Path.of("src/main/resources/results2.csv"));

        assertEquals(values[repetitionInfo.getCurrentRepetition() - 1][1],
                gameService.getScoredGoalsOfCountry((String) values[repetitionInfo.getCurrentRepetition() - 1][0]));
    }

    @Test
    void testGetCountryWithTheMostOfScores() {

        gameRepository.addGameFromCsv(Path.of("src/main/resources/results2.csv"));

        assertThat(gameService.getCountryWithTheMostOfScores())
                .isEqualTo("Italy");

    }
}