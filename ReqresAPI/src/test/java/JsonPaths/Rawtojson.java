package JsonPaths;

import io.restassured.path.json.JsonPath;

public class Rawtojson {

    public static JsonPath rawtojson(String response){
        JsonPath js=new JsonPath(response); //parsing json
        return js;
    }
}
