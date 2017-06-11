package mysql;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.DatabaseException;
import main.DatabaseObject;
import main.IDatabaseConnection;

import java.sql.Connection;

public class MySqlDatabaseConnection implements IDatabaseConnection{
	
	private String databasePath;
	private String databaseUsername;
	private String databasePassword;
	
	public MySqlDatabaseConnection(final String databasePath, final String databaseUsername, final String databasePassword) {
		this.databasePath = databasePath;
		this.databaseUsername = databaseUsername;
		this.databasePassword = databasePassword;
	}

	@Override
	public void createTable(final String tableName, final Map<String, MySqlColumnType> tableColumns) throws DatabaseException {
		Connection databaseConnection = connectToDatabase();
		int numberOfKeys = tableColumns.size();
		int i = 0;
		
		String statement = "create table if not exists " + tableName + " (";
		for (String columnTitle: tableColumns.keySet()){
			statement += columnTitle + " " + tableColumns.get(columnTitle).getColumnType();
			if (i != numberOfKeys - 1){
				statement += ", ";
			}
			i++;
		}
		statement += ")";

		try {
			PreparedStatement preparedStmt = databaseConnection.prepareStatement(statement);
			preparedStmt.execute();
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}

	@Override
	public List<DatabaseObject> query(String query) throws DatabaseException {
		Connection databaseConnection = connectToDatabase();
		List<DatabaseObject> databaseObjects = new ArrayList<>();
		
		try {
			Statement statement = databaseConnection.createStatement();
			// Get results from query
			ResultSet results = statement.executeQuery(query);
			// Get metadata to determine columns
			ResultSetMetaData metadata = results.getMetaData();
			// Compile a list of column names from query
			List<String> columnNames = new ArrayList<>();
			for (int i = 1; i < metadata.getColumnCount() + 1; i++){
				columnNames.add(metadata.getColumnName(i));
			}
			// Compile the query objects into database objects to return
			while (results.next()){
				Map<String, Object> rowProperties = new HashMap<>();
				for (String columnName: columnNames){
					rowProperties.put(columnName, results.getObject(columnName));
				}
				databaseObjects.add(new DatabaseObject(rowProperties));
			}
			
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
		
		return databaseObjects;
	}
	
	@Override
	public void persistObject(String tableName, DatabaseObject object) throws DatabaseException {		Connection databaseConnection = connectToDatabase();
		String statement = " insert into " + tableName + " (";
		String values = " values (";
		Map<String, Object> properties = object.getProperties();
		int numberOfKeys = properties.size();
		int i = 0;
		
		for (String column: properties.keySet()){
			statement += column;
			if (i != numberOfKeys - 1){
				statement += ", ";
				values += "?, ";
			}
			i++;
		}
		statement += ")";
		values += "?)";

		PreparedStatement preparedStmt;
		try {
			preparedStmt = databaseConnection.prepareStatement(statement + values);
			int j = 1;
			for (String column: properties.keySet()){
				preparedStmt.setObject(j, properties.get(column));
				j++;
			}
	        
			preparedStmt.execute();	
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}

	private Connection connectToDatabase() throws DatabaseException {
		try {
			return DriverManager.getConnection(this.databasePath, this.databaseUsername, this.databasePassword);
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}
}
