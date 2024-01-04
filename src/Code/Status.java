package Code;

public enum Status {
	
	RENTALABLE("0", "대여가능"), RENTALING("1", "대여중"), LOST("2", "분실");
	
	private String name;
	private String value;
	
	private Status(String name, String value) {
		this.name = name;
		this.value = value;
		
	}

	public String getName() {
		return name;
	}


	public String getValue() {
		return value;
	}
	
}