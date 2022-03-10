package APIs_Test.Tavel_insurance;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;

import capital.capital.APIGlobalVariable;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class postCreatePolicy {
	
	public void post_create_policy() throws IOException, InterruptedException {
		
		 
		String body = "{\n"
				+ "  \"accountNumber\": \"4501140\",\n"  
				+ "  \"accountCurrency\": \"JOD\",\n"
				+ "  \"quotationId\": \""+APIGlobalVariable.quotationId+"\"\n"
				+ "}";
		
		APIGlobalVariable.requestBody = body;
		
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiJkYWYzYmMxNS05ZGU5LTQwZmQtYjQyZC00ZTkxODQzMTExYWEiLCJleHAiOjE2NDQyMjU0NDAsIm5iZiI6MCwiaWF0IjoxNjQ0MjIzNjQwLCJpc3MiOiJodHRwOi8vMTAuMC4yOC43Mjo4MTgwL2F1dGgvcmVhbG1zL2Nib2otcmV0YWlsIiwic3ViIjoiNmMwYzliM2EtMTQ1Ni00ZDg4LTg2NzEtZDQ1Yjk1ZWJhMjQwIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiY2Jvai1yZXRhaWwtd2ViIiwibm9uY2UiOiJmNmZmNDZmYy1mMGYzLTQ1ZDAtOGEwZS0wOGY0YTkxZmVmYTUiLCJhdXRoX3RpbWUiOjE2NDQyMjM1MzQsInNlc3Npb25fc3RhdGUiOiJhMTMyZWJiMS01NjNjLTQ3ZWItOTZmNS1iMDFhNmJlYTg3MTAiLCJhY3IiOiIwIiwic2NvcGUiOiJvcGVuaWQgcHJvZmlsZSBlbWFpbCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwidXNlcl9uYW1lIjoiMjAwMjMwMyIsIm5hbWUiOiJBWlpBTSBXQVNGSSBEQVJXSVNIIEFOTkFCIiwicHJlZmVycmVkX3VzZXJuYW1lIjoiMjAwMjMwMyIsIkN1c3RvbWVySUQiOiIyMDAyMzAzIiwiZ2l2ZW5fbmFtZSI6IkFaWkFNIFdBU0ZJIERBUldJU0giLCJsb2NhbGUiOiJlbi1HQiIsImZhbWlseV9uYW1lIjoiQU5OQUIiLCJCYW5rSUQiOiJDQk9KIiwiVXNlclR5cGUiOiJSZXRhaWwiLCJlbWFpbCI6ImF6emFtQGEuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9ncm91cF91c2VyKFVTRVIpIiwiUk9MRV9VU0VSIiwiUk9MRV9ncm91cF9yZXRhaWxfam9yZGFuKFVTRVIpIl19.a7E07RNe3K9IxCkYLcGxirGzfZgDPH_WmarArbceUgw";

		Response response =
				
				   given()
				   .header("Authorization", "Bearer "+token)
			       .contentType(ContentType.JSON)
			       .body(body)
			       .when()
			       //.post("http://10.0.28.73:80/cboj-bb-travel-insurance-service/v2/travelInsurance/createPolicy") 
			       .post("http://172.20.6.110:8080/cboj-bb-travel-insurance-service/v2/travelInsurance/createPolicy")
			       .then()
			       .log()
			       .all()
			       .extract().response();
				System.out.println(body);
		
				
				APIGlobalVariable.Consol = response.jsonPath().prettify();
		
				// Verifications and extracting needed values go here	
				
				Assert.assertEquals(response.getStatusCode(), 200, "header status code is not 200");
				
				
	}

}
