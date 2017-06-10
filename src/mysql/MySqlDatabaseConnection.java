package mysql;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

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
	public void createTable(final Map<String, ColumnType> tableColumns) throws SQLException {
		Connection databaseConnection = connectToDatabase();
		int numberOfKeys = tableColumns.size();
		int i = 0;
		
		String statement = "create table if not exists scores (";
		for (String columnTitle: tableColumns.keySet()){
			statement += columnTitle + " " + tableColumns.get(columnTitle).getColumnType();
			if (i != numberOfKeys - 1){
				statement += ", ";
			}
			i++;
		}
		statement += ")";

	    PreparedStatement preparedStmt = databaseConnection.prepareStatement(statement);
		preparedStmt.execute();
	}

	private Connection connectToDatabase() throws SQLException {
		return DriverManager.getConnection(this.databasePath, this.databaseUsername, this.databasePassword);
	}

}
