package API;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class DeleteEmployee {

    public void Delete(int u_id, String base){


        RestAssured.baseURI=base;

        given().log().all().pathParams("uid", u_id).header("Content-Type", "application/json")
                .when().delete("api/users/{uid}").then().log().all().assertThat().statusCode(204);
    }
}
