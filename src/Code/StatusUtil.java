package Code;

public class StatusUtil {
	public String getDispValue(String name) {
		switch(name)  {
			case "0" :
				return Status.RENTALABLE.getValue();
		
			case "1" :
				return Status.RENTALING.getValue();
			case "2" :
				return Status.LOST.getValue();
			default : 
				return "정보없음"; 
		}
	}
}