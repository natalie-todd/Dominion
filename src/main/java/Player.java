import org.bson.types.ObjectId;

public class Player {
    private final ObjectId playerForeignKey;
    private final String name;

    private Player(PlayerBuilder playerBuilder) {
        this.playerForeignKey = playerBuilder.playerForeignKey;
        this.name = playerBuilder.name;
    }

    public ObjectId getPlayerForeignKey() {
        return playerForeignKey;
    }

    public String getName() {
        return name;
    }

    private static class PlayerBuilder {
        private ObjectId playerForeignKey;
        private String name;

        public Player.PlayerBuilder playerForeignKey(ObjectId playerForeignKey) {
            this.playerForeignKey = playerForeignKey;
            return this;
        }
        public Player.PlayerBuilder name(String name) {
            this.name = name;
            return this;
        }
        public Player build() {
//            Player player = new Player(this);
            return new Player(this);
        }
    }
}
