package mysql;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		
		String statement = "create table if not exists" + tableName + " (";
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
	public void query(String query) throws DatabaseException {
		Connection databaseConnection = connectToDatabase();
		Statement statement;
		try {
			statement = databaseConnection.createStatement();
			ResultSet results = statement.executeQuery(query);
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}
	
	@Override
	public void persistObject(String tableName, DatabaseObject object) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}

	private Connection connectToDatabase() throws DatabaseException {
		try {
			return DriverManager.getConnection(this.databasePath, this.databaseUsername, this.databasePassword);
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}
}
