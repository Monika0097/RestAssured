package payload;

public class UpdatePlace {
	
	public static String newAddress = "Dreamy Glass Door House";
	public static String upgradePlace(String placeID)
	{
	    
		String upgrade = "{\r\n"
				+ "\"place_id\":\""+placeID+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}";
		return upgrade;
	}

}
