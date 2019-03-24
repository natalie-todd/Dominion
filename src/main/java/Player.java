import java.util.Objects;

public class Player {
    private final String playerId;
    private final String name;

    public Player(String playerId, String name) {
        this.playerId = playerId;
        this.name = name;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(playerId, player.playerId) &&
                Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId='" + playerId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}