package mysql;

public enum ColumnType {
	DOUBLE ("DOUBLE"),
	FLOAT ("FLOAT"),
	STRING ("VARCHAR(255)"),
	INTEGER ("INTEGER"),
	TIMESTAMP ("TIMESTAMP");
	
	private String columnType;
	
	ColumnType(final String columnType){
		this.columnType = columnType;
	}
	
	public String getColumnType() {
		return columnType;
	}
}
