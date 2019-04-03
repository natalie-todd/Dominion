import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import static com.mongodb.client.model.Filters.eq;
import static java.util.Arrays.asList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * The POJO QuickTour code example
 */
public class MongoDB {
    /**
     * Run this main method to see the output of this quick example.
     *
     * @param args takes an optional single argument for the connection string
     */
    public static void main(final String[] args) {
        MongoClient mongoClient;

        if (args.length == 0) {
            // connect to the local database server
            mongoClient = MongoClients.create();
        } else {
            mongoClient = MongoClients.create(args[0]);
        }

        // create codec registry for POJOs
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        // get handle to "mydb" database
        MongoDatabase database = mongoClient.getDatabase("mydb").withCodecRegistry(pojoCodecRegistry);

        // get a handle to the "people" collection
        MongoCollection<Game> collection = database.getCollection("game", Game.class);

        // drop all the data in it
        collection.drop();

        Setup firstSetup = new Setup("1", asList("Lurker", "Village", "Swindler", "Diplomat", "Throne Room", "Remodel",
                        "Replace", "Bandit", "Mine", "Harem"), 4);

        Score natalieFirstScore = new Score("Natalie", 33);
        Score adaFirstScore = new Score("Ada", 33);

        // make a document and insert it
        Game firstGame = GameBuilder.gameBuilder().gameId("1").scores(asList(natalieFirstScore, adaFirstScore))
                .date(LocalDate.of(2019, 03, 23)).setup(firstSetup.getSetupId())
                .winner("Natalie").build();

        System.out.println("Original Game Model: " + firstGame);
        collection.insertOne(firstGame);

        // Game will now have an ObjectId
        System.out.println("Mutated Game Model: " + firstGame);

        // get it (since it's the only one in there since we dropped the rest earlier on)
        Game somebody = collection.find().first();
        System.out.println(somebody);

        // now, lets add some more people so we can explore queries and cursors
//        List<Game> people = asList(
//                new Game("Charles Babbage", 45, new Address("5 Devonshire Street", "London", "W11")),
//                new Game("Alan Turing", 28, new Address("Bletchley Hall", "Bletchley Park", "MK12")),
//                new Game("Timothy Berners-Lee", 61, new Address("Colehill", "Wimborne", null))
//        );
//
//        collection.insertMany(people);
//        System.out.println("total # of people " + collection.countDocuments());
//
//        System.out.println("");
        // lets get all the documents in the collection and print them out
//        Block<Game> printBlock = new Block<Game>() {
//            @Override
//            public void apply(final Game person) {
//                System.out.println(person);
//            }
//        };
//
//        collection.find().forEach(printBlock);
//
//        System.out.println("");
        // now use a query to get 1 document out
        somebody = collection.find(eq("Natalie", "1")).first();
        System.out.println(somebody);

//        System.out.println("");
        // now lets find every over 30
//        collection.find(gt("age", 30)).forEach(printBlock);

//        System.out.println("");
        // Update One
//        collection.updateOne(eq("name", "Ada Byron"), combine(set("age", 23), set("name", "Ada Lovelace")));

//        System.out.println("");
        // Update Many
//        UpdateResult updateResult = collection.updateMany(not(eq("zip", null)), set("zip", null));
//        System.out.println(updateResult.getModifiedCount());

//        System.out.println("");
        // Replace One
//        updateResult = collection.replaceOne(eq("name", "Ada Lovelace"), firstGame);
//        System.out.println(updateResult.getModifiedCount());

        // Delete One
//        collection.deleteOne(eq("address.city", "Wimborne"));

        // Delete Many
//        DeleteResult deleteResult = collection.deleteMany(eq("address.city", "London"));
//        System.out.println(deleteResult.getDeletedCount());

        // Clean up
        database.drop();

        // release resources
        mongoClient.close();
    }
}


//import com.mongodb.Block;
//import com.mongodb.MongoClientSettings;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import org.bson.codecs.configuration.CodecRegistry;
//import org.bson.codecs.pojo.PojoCodecProvider;
//
//import java.time.LocalDate;
//
//import static java.util.Arrays.asList;
//import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
//import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
//
//public class MongoDB {
//    public static void main(String[] args) {
//
//        MongoClient mongoClient = MongoClients.create();
//
//        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings
//                .getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
//
//        MongoDatabase database = mongoClient.getDatabase("dominionDB").withCodecRegistry(pojoCodecRegistry);
//
//        MongoCollection<Game> gameCollection = database.getCollection("game", Game.class);
//        MongoCollection<Setup> setupCollection = database.getCollection("setup", Setup.class);
//        MongoCollection<Player> playerCollection = database.getCollection("player", Player.class);
//
//        gameCollection.drop();
//        setupCollection.drop();
//        playerCollection.drop();
//
//        Score natScore1 = new Score("1", 33);
//        Score naluScore1 = new Score("2", 23);
//        Setup firstSetup =
//                new Setup("1", asList("Lurker", "Village", "Swindler", "Diplomat", "Throne Room", "Remodel",
//                        "Replace", "Bandit", "Mine", "Harem"), 4);
//
//        Game first = GameBuilder.gameBuilder().date(LocalDate.of(2019, 03, 23))
//                .gameId("1")
//                .scores(asList(natScore1, naluScore1))
//                .setup("1").winner("Natalie").build();
//
//        gameCollection.insertOne(first);
//
//        Block<Game> printBlock = new Block<Game>() {
//            @Override
//            public void apply(final Game game) {
//                System.out.println(game);
//            }
//        };
//
//        gameCollection.find().forEach(printBlock);
//    }
//
//
//}
