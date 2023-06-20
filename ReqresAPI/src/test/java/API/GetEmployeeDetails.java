package API;

import JsonPaths.Rawtojson;
import PayLoads.PayLoad;
import io.restassured.RestAssured;
import junit.framework.Assert;

import static io.restassured.RestAssured.given;

public class GetEmployeeDetails {


    public void GetDetails(String base, int id){
        System.out.println("Getting info of "+id);

        RestAssured.baseURI=base;

        String response=given().log().all().header("Content-Type", "application/json").pathParam("key", id)
                .when().get("/api/users/{key}").then().log().all().assertThat().statusCode(200).extract().response().asString();

        System.out.println(response);
        int retrive_id= Rawtojson.rawtojson(response).getInt("data.id");

        Assert.assertEquals(retrive_id,id);
    }
}
