package main;

import java.sql.SQLException;
import java.util.Map;

import mysql.ColumnType;

public interface IDatabaseConnection {

	public void createTable(Map<String, ColumnType> tableColumns) throws SQLException;
}
