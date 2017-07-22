package mongo;

import java.util.List;
import java.util.Map;

import database.DatabaseException;
import database.DatabaseObject;
import database.IDatabaseConnection;
import mysql.MySqlColumnType;

public class MongoDatabaseConnection implements IDatabaseConnection{

	@Override
	public List<DatabaseObject> query(final String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persistObject(final String tableName, final DatabaseObject object) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createTable(String tableName, Map<String, MySqlColumnType> tableColumns) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}

}
