package inventarioapp.core;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

import io.github.cbartosiak.bson.codecs.jsr310.duration.DurationAsDecimal128Codec;

public class DatabaseManager {
	private static DatabaseManager instance = null;
	private MongoClient client;
	private MongoDatabase database;
	
	private DatabaseManager() {
		client = MongoClients.create("mongodb://localhost:27017");
		
		CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
	        MongoClientSettings.getDefaultCodecRegistry(),
	        CodecRegistries.fromCodecs(new DurationAsDecimal128Codec())
		);
		
		database = client.getDatabase("inventarioapp").withCodecRegistry(codecRegistry);
	}
	
	public static DatabaseManager getInstance() {
		if (instance == null) {
			instance = new DatabaseManager();
		}
		
		return instance;
	}
	
	public MongoDatabase getDatabase() {
		return database;
	}
	
	public MongoCollection<Document> getCollection(String name) {
		return database.getCollection(name);
	}
}
