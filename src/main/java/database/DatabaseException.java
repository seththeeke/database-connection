package main.java.database;

public class DatabaseException extends Throwable{
	
	public DatabaseException(Exception e) {
		e.printStackTrace();
	}

}
