package Code;

public enum Category {
	
	CARTOON("0", "만화"), MAGAGIN("1", "잡지"), NOVEL("2", "소설");
	
	private String name;
	private String value;
	
	private Category(String name, String value) {
		this.name = name;
		this.value = value;
		
	}

	public String getName() {
		return name;
	}
	public String getValue()	{
		return value;
	}


	
}