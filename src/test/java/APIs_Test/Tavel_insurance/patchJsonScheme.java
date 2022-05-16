package APIs_Test.Tavel_insurance;

import capital.capital.APIGlobalVariable;
import capital.capital.CustomKeywords;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class patchJsonScheme {

    public void patch_Json_Scheme() throws IOException, InterruptedException {

        CustomKeywords CustomKeywords = new CustomKeywords();

        String body;

        JSONArray array = new JSONArray();
        JSONObject item = new JSONObject();

        String jsonString = new JSONObject()
                .put("firstName", "Robert")
                .put("lastName", "Downey Jr.")
                .put("subjectId", 1)
                .toString();

        body = jsonString;

        APIGlobalVariable.requestBody = body;

        baseURI = "http://localhost:3000/";

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .header("Content-Type", "application/json")
                        //.param("lastName", "Dabbagh")
                        .body(body)
                        .when()
                        .put("/users/7")
                        .then()
                        .statusCode(200)
                        .log().all()  // This is to log all the response on the consol
                        //.body("jicoId", equalToPath("jicoId"))
                        //.body("jicoId", equalTo("42374"))
                        .extract().response();

        APIGlobalVariable.Consol = response.jsonPath().prettify();

        // Verifications and extracting needed values go here

        Assert.assertEquals(response.getStatusCode(), 200, "header status code is not 200");

    }
}
