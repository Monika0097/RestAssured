package payload;

import org.json.simple.JSONObject;

public class PostPayload {
	
	/*------------ Demo request
	 * {
	    "name": "morpheus",
	    "job": "zion resident"
	}*/
	public static String postRequest(String name, String job)
	{
		JSONObject request = new JSONObject();
		request.put(name, job);
		return request.toJSONString();
	}


}
