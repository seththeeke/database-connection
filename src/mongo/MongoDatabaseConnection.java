package mongo;

import java.util.List;
import java.util.Map;

import main.DatabaseException;
import main.IDatabaseConnection;
import main.DatabaseObject;
import mysql.MySqlColumnType;

public class MongoDatabaseConnection implements IDatabaseConnection{

	@Override
	public void createTable(final String tableName, final Map<String, MySqlColumnType> tableColumns) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DatabaseObject> query(final String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persistObject(final String tableName, final DatabaseObject object) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}

}
