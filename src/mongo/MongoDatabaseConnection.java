package mongo;

import java.util.Map;

import main.DatabaseException;
import main.DatabaseObject;
import main.IDatabaseConnection;
import mysql.MySqlColumnType;

public class MongoDatabaseConnection implements IDatabaseConnection{

	@Override
	public void createTable(final String tableName, final Map<String, MySqlColumnType> tableColumns) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void query(final String query) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void persistObject(final String tableName, final DatabaseObject object) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}

}
