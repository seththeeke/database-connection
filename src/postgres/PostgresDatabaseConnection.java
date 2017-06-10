package postgres;

import java.util.Map;

import main.DatabaseException;
import main.DatabaseObject;
import main.IDatabaseConnection;
import mysql.MySqlColumnType;

public class PostgresDatabaseConnection implements IDatabaseConnection{

	@Override
	public void createTable(String tableName, Map<String, MySqlColumnType> tableColumns) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void query(String query) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void persistObject(String tableName, DatabaseObject object) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}

}
