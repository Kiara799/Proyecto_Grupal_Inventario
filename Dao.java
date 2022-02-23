package inventarioapp.core;

import com.mongodb.client.MongoDatabase;

public abstract class Dao {
	private DatabaseManager databaseManager = DatabaseManager.getInstance();
	
	public final MongoDatabase getDatabase() {
		return databaseManager.getDatabase();
	}
}
