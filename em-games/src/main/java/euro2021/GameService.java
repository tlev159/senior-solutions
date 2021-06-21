package euro2021;

import java.util.*;

public class GameService {

    private GameRepository gameRepository;
    private List<CountryResults> countryResults = new ArrayList<>();

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Optional<Game> getGameWithTheBiggestDifference() {
        return Optional.ofNullable(gameRepository.getGames()
                .stream()
                .max(Comparator.comparing(g -> Math.abs(g.getSecondCountryScore() - g.getFirstCountryScore()))).orElse(null));
    }

    public int getScoredGoalsOfCountry(String countryName) {
        return getFirstCountryScores(countryName) + getSecondCountryScores(countryName);

    }

    private int getFirstCountryScores(String countryName) {
        return (int) gameRepository.getGames()
                .stream()
                .filter(g -> g.getFirstCountry().equals(countryName))
                .reduce(0, (g1, g2) ->  g1 + g2.getFirstCountryScore(), (s1, s2) -> s1 + s2);

    }

    private int getSecondCountryScores(String countryName) {
        return (int) gameRepository.getGames()
                .stream()
                .filter(g -> g.getSecondCountry().equals(countryName))
                .reduce(0, (g1, g2) ->  g1 + g2.getSecondCountryScore(), (s1, s2) -> s1 + s2);

    }

    public String getCountryWithTheMostOfScores() {
        addScoresToCountryResults();
        return countryResults.stream()
                .max(Comparator.comparing(CountryResults::getScores)).toString();
    }

    private TreeSet<String> getCountries() {
        TreeSet<String> countries = new TreeSet<>();
        for (Game game:gameRepository.getGames()) {
            countries.add(game.getFirstCountry());
            countries.add(game.getSecondCountry());
        }
        return countries;
    }

    private void addScoresToCountryResults() {
        TreeSet<String> temp = getCountries();
        for (String str:temp) {
            countryResults.add(new CountryResults(str,getScoredGoalsOfCountry(str)));
        }
    }

}
