import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;

import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

public class MongoDB {
    public static void main(String[] args) {

    SimpleDateFormat firstDate = new SimpleDateFormat("2019-03-23");

    MongoClient mongoClient = MongoClients.create();

    MongoDatabase database = mongoClient.getDatabase("dominionDB");

    MongoCollection<Document> gameCollection = database.getCollection("game");
    MongoCollection<Document> setupCollection = database.getCollection("setup");
    MongoCollection<Document> playerCollection = database.getCollection("player");

    Document firstGame = new Document("playerForeignKey", 1)
            .append("date", firstDate)
            .append("id", 1)
            .append("gameForeignKey", 1);

    gameCollection.insertOne(firstGame);
    }
}
