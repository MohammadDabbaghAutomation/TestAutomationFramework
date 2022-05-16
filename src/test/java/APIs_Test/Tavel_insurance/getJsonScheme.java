package APIs_Test.Tavel_insurance;

import capital.capital.APIGlobalVariable;
import capital.capital.CustomKeywords;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.Matchers;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.equalToPath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;



public class getJsonScheme {

    public void get_Json_Scheme() throws IOException, InterruptedException {

        CustomKeywords CustomKeywords = new CustomKeywords();

        baseURI = "http://localhost:3000/";

        Response response =
                given()
                        //.header("id", 2)
                        //.param("lastName", "Dabbagh")
                        .when()
                        .get("/users")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .log().all()  // This is to log all the response on the consol
                        //.body("jicoId", equalToPath("jicoId"))
                        //.body("lastName[1:]", equalTo("Dabbagh"))
                        .contentType(ContentType.JSON)
                        .extract().response();

        APIGlobalVariable.Consol = response.jsonPath().prettify();

        // Verifications and extracting needed values go here

        // Assertion using TestNG assertion library
        Assert.assertEquals(response.getStatusCode(), 200, "header status code is not 200");

        // Assertion using Hamcrest assertion library
        assertThat(response.jsonPath().getString("firstName[0]"), equalTo("Leonardo"));


        // Assertion using TestNG assertion library
        List<String> firstName = new ArrayList<>();
        firstName=   response.jsonPath().get("firstName");

        Assert.assertTrue(firstName.contains("Robert"), "It does not contains Robert");



        // Assertion using Hamcrest assertion library
        List<String> filteredColors = firstName.stream()
                .filter(color -> color.equals("Robert"))
                .sorted()
                .collect(Collectors.toList());

        System.out.println(filteredColors);

        assertThat(filteredColors, contains("Robert"));

        // Assertion using AssertJ assertion library



        // Showing specific fields' values

        JsonPath jsonPathEvaluator = response.jsonPath();

        System.out.println("jsonPathEvaluator is:    "+jsonPathEvaluator.get("lastName[3]"));

        System.out.println("jsonPathEvaluator.getList(lastName)"+ jsonPathEvaluator.getList("lastName"));

    }
}
