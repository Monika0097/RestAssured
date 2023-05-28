package reusableMethods;
import io.restassured.path.json.JsonPath;

public class JsonPathObect {
	public static JsonPath convertToJson(String response)
	{
		JsonPath js  = new JsonPath(response);
		return js;
		
	}

}
