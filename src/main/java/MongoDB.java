import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.text.SimpleDateFormat;

import static java.util.Arrays.asList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoDB {
    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create();

        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings
                .getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoDatabase database = mongoClient.getDatabase("dominionDB").withCodecRegistry(pojoCodecRegistry);

        MongoCollection<Game> gameCollection = database.getCollection("game", Game.class);
        MongoCollection<Setup> setupCollection = database.getCollection("setup", Setup.class);
        MongoCollection<Player> playerCollection = database.getCollection("player", Player.class);

        gameCollection.drop();
        setupCollection.drop();
        playerCollection.drop();

        Score natScore1 = new Score("1", 33);
        Score naluScore1 = new Score("2", 23);
        Setup firstSetup =
                new Setup("1", asList("Lurker", "Village", "Swindler", "Diplomat", "Throne Room", "Remodel",
                        "Replace", "Bandit", "Mine", "Harem"), 4);

        Game first = GameBuilder.gameBuilder().date(new SimpleDateFormat("2019-03-23")).gameId("1")
                .scores(asList(natScore1, naluScore1))
                .setup("1").winner("Natalie").build();

        gameCollection.insertOne(first);
    }


}
