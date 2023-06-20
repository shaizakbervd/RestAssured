package API;

import JsonPaths.Rawtojson;
import PayLoads.PayLoad;
import io.restassured.RestAssured;
import junit.framework.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.*;

public class CreateEmployee {

    public int Create(String name, String job, String base) throws IOException {

        System.out.println("creating user");

        RestAssured.baseURI=base;
        String response=given().log().all().header("Content-Type", "application/json")
                .body(PayLoad.AddUser(name, job))
                .when().post("/api/users").then().log().all().assertThat().statusCode(201).extract().response().asString();

        int u_id=Rawtojson.rawtojson(response).getInt("id");
        System.out.println(u_id);
        return u_id;
    }
}
