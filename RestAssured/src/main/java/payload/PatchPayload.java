package payload;

public class PatchPayload {
	
	public static String patchRequest(String email)
	{
		String request= " {\"data\":{\"id\":2,\"email\":\""+email+"\",\"first_name\":\"Janet\",\"last_name\":\"Weaver\",\"avatar\":\"https://reqres.in/img/faces/2-image.jpg\"},\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}} ";
		return request;
	}

}
