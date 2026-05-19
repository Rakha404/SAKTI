package util;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class MongoManager {
    private static MongoClient mongoClient;
    private static final String DATABASE_NAME = "SAKTI";

    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            // 1. Buat PojoCodecProvider yang otomatis mendeteksi class
            CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(
                PojoCodecProvider.builder().automatic(true).build()
            );

            // 2. Gabungkan dengan registry default MongoDB
            CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(), 
                pojoCodecRegistry
            );

            // 3. Masukkan registry ke dalam pengaturan Client sebelum koneksi dibuat
            MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new com.mongodb.ConnectionString("mongodb://localhost:27017/"))
                .codecRegistry(codecRegistry) // <--- REGISTRASI DI SINI
                .build();

            mongoClient = MongoClients.create(settings);
        }
        return mongoClient.getDatabase(DATABASE_NAME);
    }
}