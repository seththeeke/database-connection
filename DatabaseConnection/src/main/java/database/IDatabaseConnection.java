package database;

import java.util.List;
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
	public List<DatabaseObject> query(String query) throws DatabaseException;
	
	/**
	 * Persist an object in a table
	 * 
	 * @throws DatabaseException
	 */
	public void persistObject(final String tableName, final DatabaseObject object) throws DatabaseException;
}