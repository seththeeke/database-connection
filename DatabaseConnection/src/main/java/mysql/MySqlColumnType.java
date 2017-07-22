package mysql;

public enum MySqlColumnType {
	DOUBLE ("DOUBLE"),
	FLOAT ("FLOAT"),
	STRING ("VARCHAR(255)"),
	INTEGER ("INTEGER"),
	TIMESTAMP ("TIMESTAMP");
	
	private String columnType;
	
	MySqlColumnType(final String columnType){
		this.columnType = columnType;
	}
	
	public String getColumnType() {
		return columnType;
	}
}