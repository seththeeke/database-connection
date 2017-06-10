package mysql;

import java.sql.Connection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import main.IDatabaseConnection;

@RunWith(MockitoJUnitRunner.class)
public class MySqlDatabaseConnectionTest {
	
	@Mock
	IDatabaseConnection mySqlDatabaseConnection;
	
	@Mock
	Connection connection;

	@Before
	public void before(){
		this.mySqlDatabaseConnection = Mockito.spy(new MySqlDatabaseConnection("", "", ""));
		
		Mockito.doReturn(this.connection).when(this.mySqlDatabaseConnection);
	}
	
	@After
	public void after(){
		
	}
	
	@Test
	public void testCreateTable(){
		
	}

}
