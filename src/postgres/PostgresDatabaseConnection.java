package postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import main.DatabaseException;
import main.IDatabaseConnection;
import main.DatabaseObject;
import mysql.MySqlColumnType;

public class PostgresDatabaseConnection implements IDatabaseConnection{
	
	private String databasePath;
	private String databaseUsername;
	private String databasePassword;
	
	public PostgresDatabaseConnection(final String databasePath, final String databaseUsername, final String databasePassword) {
		this.databasePath = databasePath;
		this.databaseUsername = databaseUsername;
		this.databasePassword = databasePassword;
	}

	@Override
	public void createTable(String tableName, Map<String, MySqlColumnType> tableColumns) throws DatabaseException {
		Connection databaseConnection = connectToDatabase();
	}

	@Override
	public List<DatabaseObject> query(String query) throws DatabaseException {
		Connection databaseConnection = connectToDatabase();
		return null;
	}

	@Override
	public void persistObject(String tableName, DatabaseObject object) throws DatabaseException {
		Connection databaseConnection = connectToDatabase();
	}
	
	private Connection connectToDatabase() throws DatabaseException {
		try {
			return DriverManager.getConnection(this.databasePath, this.databaseUsername, this.databasePassword);
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}

}
