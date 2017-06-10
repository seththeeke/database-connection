package main;

import java.util.Map;

import mysql.MySqlColumnType;

public interface IDatabaseConnection {
	
	/**
	 * Create a table in the database you are connected
	 * 
	 * @param tableName
	 * @param tableColumns
	 * @throws DatabaseException
	 */
	public void createTable(final String tableName, Map<String, MySqlColumnType> tableColumns) throws DatabaseException;
		
	/**
	 * Query a database table
	 * 
	 * @param query
	 * @throws DatabaseException
	 */
	public void query(String query) throws DatabaseException;
}
