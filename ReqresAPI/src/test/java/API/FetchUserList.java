package API;

import JsonPaths.Rawtojson;
import io.restassured.RestAssured;
import junit.framework.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.*;

public class FetchUserList {

    public void Fetch(String base) throws IOException{

        RestAssured.baseURI=base;

        String response=given().log().all().header("Content-Type", "application/json")
                .when().get("/api/users?page=2").then().log().all().assertThat().statusCode(200).extract().response().asString();

        int totalpages= Rawtojson.rawtojson(response).getInt("total_pages");
        int totalrecords= Rawtojson.rawtojson(response).getInt("total");

        Assert.assertEquals(totalpages, 2);
        Assert.assertEquals(totalrecords, 12);
        System.out.println("totalpages found "+totalpages);
        System.out.println("totalrecords found "+totalrecords);
    }

}
