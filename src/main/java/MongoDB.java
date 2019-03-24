import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.text.SimpleDateFormat;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoDB {
    public static void main(String[] args) {

    SimpleDateFormat firstDate = new SimpleDateFormat("2019-03-23");

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

        Game test = GameBuilder.gameBuilder().date(null).gameId("bye").scores(null).setup("hi").build();
        Player testPlayer = new Player("1", "me");
        System.out.println(testPlayer);
    }


}
