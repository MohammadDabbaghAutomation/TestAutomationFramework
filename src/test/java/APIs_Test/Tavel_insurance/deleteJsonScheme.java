package APIs_Test.Tavel_insurance;

import capital.capital.APIGlobalVariable;
import capital.capital.CustomKeywords;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class deleteJsonScheme {

    public void delete_Json_Scheme() throws IOException, InterruptedException {

        CustomKeywords CustomKeywords = new CustomKeywords();

        baseURI = "http://localhost:3000/";

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .header("Content-Type", "application/json")
                        //.param("lastName", "Dabbagh")
                        .when()
                        .delete("/users/5")
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
