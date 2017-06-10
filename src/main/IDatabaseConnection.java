package main;

import java.sql.SQLException;
import java.util.Map;

import mysql.MySqlColumnType;

public interface IDatabaseConnection {

	public void createTable(final String tableName, Map<String, MySqlColumnType> tableColumns) throws SQLException;
		
	public void query(String query) throws SQLException;
}
