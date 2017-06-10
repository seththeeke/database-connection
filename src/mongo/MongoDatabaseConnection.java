package mongo;

import java.sql.SQLException;
import java.util.Map;

import main.IDatabaseConnection;
import mysql.MySqlColumnType;

public class MongoDatabaseConnection implements IDatabaseConnection{

	@Override
	public void createTable(String tableName, Map<String, MySqlColumnType> tableColumns) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void query(String query) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
