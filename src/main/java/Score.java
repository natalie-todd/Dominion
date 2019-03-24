import java.util.Objects;

public class Score {
    private final String playerId;
    private final int score;

    public Score(String playerId, int score) {
        this.playerId = playerId;
        this.score = score;
    }

    public String getPlayerId() {
        return playerId;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score1 = (Score) o;
        return score == score1.score &&
                Objects.equals(playerId, score1.playerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, score);
    }

    @Override
    public String toString() {
        return "Score{" +
                "playerId='" + playerId + '\'' +
                ", score=" + score +
                '}';
    }
}
