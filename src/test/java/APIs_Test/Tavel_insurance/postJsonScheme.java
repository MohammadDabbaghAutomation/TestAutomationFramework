package APIs_Test.Tavel_insurance;

import capital.capital.APIGlobalVariable;
import capital.capital.CustomKeywords;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.equalToPath;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class postJsonScheme {

    public void post_Json_Scheme() throws IOException, InterruptedException {

        CustomKeywords CustomKeywords = new CustomKeywords();

        String body;

        JSONArray array = new JSONArray();
        JSONObject item = new JSONObject();

        String jsonString = new JSONObject()
                .put("firstName", "Mohammad")
                .put("lastName", "Dabbagh")
                .put("subjectId", 1)
                .toString();

        body = jsonString;

        APIGlobalVariable.requestBody = body;



        baseURI = "http://localhost:3000/";

        Response response =
                given()
                        .header("Content-Type", "application/json")
                        //.param("lastName", "Dabbagh")
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(body)
                        .when()
                        .post("/users")
                        .then()
                        .statusCode(201)
                        .log().all()  // This is to log all the response on the consol
                        //.body("jicoId", equalToPath("jicoId"))
                        //.body("jicoId", equalTo("42374"))
                        .extract().response();

        APIGlobalVariable.Consol = response.jsonPath().prettify();

        // Verifications and extracting needed values go here

        Assert.assertEquals(response.getStatusCode(), 201, "header status code is not 201");

        // Hamcrest assertions go here
        //assertThat(response.jsonPath().getString("$.firstName.*"), equalTo("1234"));








    }


}
