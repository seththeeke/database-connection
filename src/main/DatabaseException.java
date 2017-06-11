package main;

public class DatabaseException extends Throwable{
	
	public DatabaseException(Exception e) {
		e.printStackTrace();
	}

}
