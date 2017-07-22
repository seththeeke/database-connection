package dummyPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import database.DatabaseException;
import database.DatabaseObject;
import database.IDatabaseConnection;
import mysql.MySqlColumnType;
import mysql.MySqlDatabaseConnection;
import postgres.PostgresDatabaseConnection;

public class DummyTestClass {

	public static void main(String[] args) throws IOException, DatabaseException, ClassNotFoundException {
		IDatabaseConnection mySqlConnection = getMySqlDatabaseConnection();
		IDatabaseConnection postgresConnection = getPostgresDatabaseConnection();
		
		Map<String, MySqlColumnType> peopleColumns = new HashMap<>();
		peopleColumns.put("first_name", MySqlColumnType.STRING);
		peopleColumns.put("last_name", MySqlColumnType.STRING);
		peopleColumns.put("age", MySqlColumnType.INTEGER);
		
		Map<String, MySqlColumnType> petColumns = new HashMap<>();
		petColumns.put("name", MySqlColumnType.STRING);
		petColumns.put("animal", MySqlColumnType.STRING);
		petColumns.put("birth_date", MySqlColumnType.TIMESTAMP);
		
		mySqlConnection.createTable("people", peopleColumns);
		mySqlConnection.createTable("pets", petColumns);
		
		Map<String, Object> personProperties = new HashMap<>();
		personProperties.put("first_name", "Seth");
		personProperties.put("last_name", "Theeke");
		personProperties.put("age", 23);
		
		mySqlConnection.persistObject("people", new DatabaseObject(personProperties));
		
		Map<String, Object> petProperties = new HashMap<>();
		petProperties.put("name", "Arsene");
		petProperties.put("animal", "Dog");
		petProperties.put("birth_date", new Date());
		
		Map<String, Object> petProperties2 = new HashMap<>();
		petProperties2.put("name", "Wenger");
		
		mySqlConnection.persistObject("pets", new DatabaseObject(petProperties));
		mySqlConnection.persistObject("pets", new DatabaseObject(petProperties2));
		
		List<DatabaseObject> objects = mySqlConnection.query("select * from pets");
		for (DatabaseObject object: objects){
			System.out.println(object.toString());
		}
		
		objects = mySqlConnection.query("select * from people");
		for (DatabaseObject object: objects){
			System.out.println(object.toString());
		}

		objects = mySqlConnection.query("select name from pets order by name");
		for (DatabaseObject object: objects){
			System.out.println(object.toString());
		}
	}

	private static IDatabaseConnection getMySqlDatabaseConnection() throws IOException {
		Properties properties = new Properties();
		
		InputStream input = new FileInputStream("resources/mysql.properties");
		properties.load(input);
		
		final String dbProtocol = properties.getProperty("databaseProtocol");
		final String dbHost = properties.getProperty("databaseHost");
		final String dbPort = properties.getProperty("databasePort");
		final String dbName = properties.getProperty("databaseName");
		final String dbConnection = dbProtocol + "://" + dbHost + ":" + dbPort + "/" + dbName;
		
		final String dbUsername = properties.getProperty("databaseUsername");
		final String dbPassword = properties.getProperty("databasePassword");
			
		return new MySqlDatabaseConnection(dbConnection, dbUsername, dbPassword);
	}
	
	private static IDatabaseConnection getPostgresDatabaseConnection() throws IOException {
		Properties properties = new Properties();
		
		InputStream input = new FileInputStream("resources/postgres.properties");
		properties.load(input);
		
		final String dbProtocol = properties.getProperty("databaseProtocol");
		final String dbHost = properties.getProperty("databaseHost");
		final String dbPort = properties.getProperty("databasePort");
		final String dbName = properties.getProperty("databaseName");
		final String dbConnection = dbProtocol + "://" + dbHost + ":" + dbPort + "/" + dbName;
		
		final String dbUsername = properties.getProperty("databaseUsername");
		final String dbPassword = properties.getProperty("databasePassword");
			
		return new PostgresDatabaseConnection(dbConnection, dbUsername, dbPassword);
	}

}
