package APIs_Test.Tavel_insurance;

import capital.capital.APIGlobalVariable;
import capital.capital.CustomKeywords;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class PostToken {

    //http://a6e37865bfad34bac8c59252d10805a5-325300214.us-east-1.elb.amazonaws.com/v1/auth/token/

    public void postToken()throws IOException, InterruptedException{

            CustomKeywords CustomKeywords = new CustomKeywords();

            String url = "http://a6e37865bfad34bac8c59252d10805a5-325300214.us-east-1.elb.amazonaws.com/v1/auth/token/";

        String body;

        JSONArray array = new JSONArray();
        JSONObject item = new JSONObject();

        String jsonString = new JSONObject()
                .put("email", "admin@admin.me")
                .put("password", "!@#$%^&*()")
                .toString();

        body = jsonString;

        APIGlobalVariable.requestBody = body;

        Response response =  given()
                .header("Content-Type", "application/json")
                //.param("lastName", "Dabbagh")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(200)
                .log().all()  // This is to log all the response on the consol
                .extract().response();

        APIGlobalVariable.Consol = response.jsonPath().prettify();

        Assert.assertEquals(response.getStatusCode(), 200, "header status code is not 200");

        APIGlobalVariable.ACCESS_TOKEN =   response.jsonPath().get("access");

        System.out.println("ACCESS_TOKEN = "+APIGlobalVariable.ACCESS_TOKEN);
    }

}
