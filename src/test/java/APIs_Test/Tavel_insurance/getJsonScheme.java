package APIs_Test.Tavel_insurance;

import capital.capital.APIGlobalVariable;
import capital.capital.CustomKeywords;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.Matchers;
import org.testng.Assert;

import javax.swing.text.html.HTML;
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
import static org.jsoup.nodes.Document.OutputSettings.Syntax.html;


public class getJsonScheme {

   /* public void get_Json_Scheme() throws IOException, InterruptedException {

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

        Assert.assertTrue(firstName.contains("Robert"), "It does not contain Robert");



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

    }*/



    /*  This is for Top Orchards by quality API

    public void get_Json_Scheme()throws IOException, InterruptedException{
        CustomKeywords CustomKeywords = new CustomKeywords();

        APIGlobalVariable.requestBody = "http://a6e37865bfad34bac8c59252d10805a5-325300214.us-east-1.elb.amazonaws.com/v1/prediction/supply-model/top-orchards-by-quality";

        int min_quality_value = 1;
        String min_quality = "min_quality = "+ min_quality_value;

        String  quality_period_value = "overall";
        String quality_period = "quality_period = "+quality_period_value;

        int page_size_value = 9246;
        String page_size = "page_size = "+page_size_value;

        int page_num_value = 1;
        String page_num = "page_num = "+page_num_value;

        String orchard_name_value = "JOYA";
        String orchard_name = "orchard_name = "+orchard_name_value;


        Response response =
                given()
                        .header("Authorization", "Bearer "+APIGlobalVariable.ACCESS_TOKEN)
                        .param("min_quality", min_quality_value)
                        .param("quality_period", quality_period_value)
                        .param("page_size", page_size_value)
                        .param("page_num", page_num_value)
                        //.param("orchard_name", orchard_name_value)
                        .when()
                        .get(APIGlobalVariable.requestBody)
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .log().all()  // This is to log all the response on the consol
                        //.body("jicoId", equalToPath("jicoId"))
                        //.body("lastName[1:]", equalTo("Dabbagh"))
                        .contentType(ContentType.JSON)
                        .extract().response();

        APIGlobalVariable.Consol = response.jsonPath().prettify();

//        APIGlobalVariable.requestBody = APIGlobalVariable.requestBody + "\n"+ min_quality+"\n"+ quality_period+"\n"+page_size+"\n"+page_num+"\n"+orchard_name;

        APIGlobalVariable.requestBody = APIGlobalVariable.requestBody + "\n"+ min_quality+"\n"+ quality_period+"\n"+page_size;

    }*/


    // Find Orchards API
    public void get_Json_Scheme()throws IOException, InterruptedException{

        CustomKeywords CustomKeywords = new CustomKeywords();

        APIGlobalVariable.requestBody = "http://a6e37865bfad34bac8c59252d10805a5-325300214.us-east-1.elb.amazonaws.com/v1/prediction/supply-model/find-orchards";

        int quantity_percentage_value = 10;
        int size_value = 48;
        int page_size_value = 10;
        int page_num_value= 0;
        int category_value = 1;

        String quantity_percentage = "quantity_percentage: "+quantity_percentage_value;
        String size = "size: "+ size_value;
        String page_size = "page_size: "+page_size_value;
        String page_num = "page_num: "+ page_num_value;

       // String category = "category: "+category_value;

        Response response = null;

        try {

            response =
            given()
                    .header("Authorization", "Bearer " + APIGlobalVariable.ACCESS_TOKEN)
                    .param("quantity_percentage", quantity_percentage_value)
                    .param("size", size_value)
                    .param("page_size", page_size_value)
                    .param("page_num", page_num_value)
                    .param("category", category_value)
                    .when()
                    .get(APIGlobalVariable.requestBody)
                    .then()
                    .assertThat()
                    //.statusCode(200)
                    .log().all()
                    .contentType(ContentType.JSON)
                    .extract().response();

        }catch(Throwable t){

            response =
                    given()
                            .header("Authorization", "Bearer " + APIGlobalVariable.ACCESS_TOKEN)
                            .param("quantity_percentage", quantity_percentage_value)
                            .param("size", size_value)
                            .param("page_size", page_size_value)
                            .param("page_num", page_num_value)
                            .param("category", category_value)
                            .when()
                            .get(APIGlobalVariable.requestBody)
                            .then()
                            .assertThat()
                            //.statusCode(200)
                            .log().all()
                            .contentType(ContentType.HTML)
                            .extract().response();
        }


        try {
            APIGlobalVariable.Consol = response.jsonPath().prettify();
        }catch(Throwable t){
            APIGlobalVariable.Consol = response.htmlPath().prettify();
        }

        //APIGlobalVariable.requestBody = APIGlobalVariable.requestBody + "\n"+ quantity_percentage+"\n"+ size+"\n"+page_size+"\n"+page_num+"\n"+category ;

        //APIGlobalVariable.requestBody = APIGlobalVariable.requestBody + "\n"+ quantity_percentage+"\n"+ size+"\n"+page_size+"\n"+page_num ;
        Assert.assertEquals(response.getStatusCode(), 200, "header status code is not 200");




    }


}
