package euro2021;

public class CountryResults {

    private String country;
    private int scores;

    public CountryResults(String country, int scores) {
        this.country = country;
        this.scores = scores;
    }

    public String getCountry() {
        return country;
    }

    public int getScores() {
        return scores;
    }

    @Override
    public String toString() {
        return "CountryResults{" +
                "country='" + country + '\'' +
                ", scores=" + scores +
                '}';
    }
}
