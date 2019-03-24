import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

public class Game {
    private final String gameId;
    private final List<Score> scores;
    private final SimpleDateFormat date;
    private final String setup;
    private final String winner;

    public Game(String gameId, List<Score> scores, SimpleDateFormat date, String setup, String winner) {
        this.gameId = gameId;
        this.scores = scores;
        this.date = date;
        this.setup = setup;
        this.winner = winner;
    }

    public String getGameId() {
        return gameId;
    }

    public List<Score> getScores() {
        return scores;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public String getSetup() {
        return setup;
    }

    public String getWinner() {
        return winner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(gameId, game.gameId) &&
                Objects.equals(scores, game.scores) &&
                Objects.equals(date, game.date) &&
                Objects.equals(setup, game.setup) &&
                Objects.equals(winner, game.winner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, scores, date, setup, winner);
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId='" + gameId + '\'' +
                ", scores=" + scores +
                ", date=" + date +
                ", setup='" + setup + '\'' +
                ", winner='" + winner + '\'' +
                '}';
    }
}