package main.java.mongo;

import java.util.List;
import java.util.Map;

import main.java.database.DatabaseException;
import main.java.database.DatabaseObject;
import main.java.database.IDatabaseConnection;
import main.java.mysql.MySqlColumnType;

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
