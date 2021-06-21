package euro2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameTest {

    List<Game> games;

    @BeforeEach
    public void init() {
        games = List.of(new Game("Magyarország", "Portugália", 0, 2),
                new Game("Anglia", "Horvátrszág", 1, 0),
                new Game("Németország", "Franciaország", 2, 2));
    }

    @Test
    public void testGetWinnerCountryForWinner() {
        Game game = games.get(0);
        assertThat(game.getWinnerCountry())
        .isEqualTo("Portugália");
    }


    @Test
    public void testGetWinnerCountryForDraw() {
        Game game = games.get(2);
        assertThat(game.getWinnerCountry())
                .isEqualTo("Draw");
    }
}