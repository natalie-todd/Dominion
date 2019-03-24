//
//@RunWith(MockitoJUnitRunner.class)
//public class MongoDBTest {
//
//    @Mock
//    MongoClient mongoClient = MongoClients.create();
//
//    @Mock
//    MongoDatabase database = mongoClient.getDatabase("dominionDB");

//    @Test
//    public void gameCollectionExists() {
//        MongoCollection<Document> gameCollection = database.getCollection("game");
//        SimpleDateFormat firstDate = new SimpleDateFormat("2019-03-23");
//        Document firstGame = new Document("playerForeignKey", 1)
//                .append("date", firstDate)
//                .append("id", 1)
//                .append("gameForeignKey", 1);
//
//        when(gameCollection.insertOne(firstGame)).thenReturn(gameCollection.countDocuments())
//        gameCollection.insertOne(firstGame);
//
//        assertEquals(1, gameCollection.countDocuments());
//    }

//}