package main.java.database;

import java.util.Map;

public class DatabaseObject {
	
	private Map<String, Object> rowProperties;
	
	public DatabaseObject(Map<String, Object> rowProperties){
		this.rowProperties = rowProperties;
	}
	
	public Object getProperty(String column){
		return this.rowProperties.get(column);
	}
	
	public Map<String, Object> getProperties(){
		return this.rowProperties;
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		for (String key: this.rowProperties.keySet()){
			builder.append(key + " ==> " + this.rowProperties.get(key)).append("\n");
		}
		return builder.toString();
	}
}
