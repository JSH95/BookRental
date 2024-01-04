package Code;

public class CategoryUtil {
	public String getDispValue(String name) {
		switch(name)  {
			case "0" :
				return Category.CARTOON.getValue();
		
			case "1" :
				return Category.MAGAGIN.getValue();
			case "2" :
				return Category.NOVEL.getValue();
			default : 
				return "카테고리없음"; 
		}
	}
}