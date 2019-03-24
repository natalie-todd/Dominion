import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GameBuilder {
    //primary key
    private String gameId;
    private List<Score> scores;
    private SimpleDateFormat date;
    private String setup;

    private static AtomicInteger defaultGameId = new AtomicInteger(0);

    private GameBuilder() {
        defaultGameId.incrementAndGet();
    }
    private static String atomicString = defaultGameId.toString();

    public static GameBuilder gameBuilder() {
        GameBuilder gameBuilder = new GameBuilder();
        gameBuilder.gameId(atomicString);

        return gameBuilder;
    }
    public GameBuilder gameId(String gameId) {
        this.gameId = gameId;
        return this;
    }

    public GameBuilder scores(List<Score> scores) {
        this.scores = scores;
        return this;
    }

    public GameBuilder date(SimpleDateFormat date) {
        this.date = date;
        return this;
    }


    public GameBuilder setup(String setup) {
        this.setup = setup;
        return this;
    }

    public Game build() {
        return new Game(
                gameId,
                scores,
                date,
                setup
        );
    }
}
