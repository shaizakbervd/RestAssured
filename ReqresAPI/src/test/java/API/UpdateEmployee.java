package API;

import JsonPaths.Rawtojson;
import PayLoads.PayLoad;
import io.restassured.RestAssured;
import junit.framework.Assert;

import static io.restassured.RestAssured.given;

public class UpdateEmployee {

    public void Update(int u_id, String uname, String ujob, String base){

        System.out.println("Updating emp");
        RestAssured.baseURI=base;

        String updateresponse=given().log().all().pathParams("uid", u_id).header("Content-Type", "application/json")
                .body(PayLoad.AddUser(uname,ujob)).when().put("/api/users/{uid}").then().log().all().assertThat().statusCode(200).extract().response().asString();

        String updated_name= Rawtojson.rawtojson(updateresponse).getString("name");
        String updated_job=Rawtojson.rawtojson(updateresponse).getString("job");

        Assert.assertEquals(updated_name, uname);
        Assert.assertEquals(updated_job, ujob);
        System.out.println("updated");
    }
}
