package APIs_Test.Tavel_insurance;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;

import capital.capital.CustomKeywords;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import capital.capital.APIGlobalVariable;

public class getCustomerInfo {
	
	public void get_customer_info() throws IOException, InterruptedException {
		
		 CustomKeywords CustomKeywords = new CustomKeywords();
		 
		 
		 String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiJkYWYzYmMxNS05ZGU5LTQwZmQtYjQyZC00ZTkxODQzMTExYWEiLCJleHAiOjE2NDQyMjU0NDAsIm5iZiI6MCwiaWF0IjoxNjQ0MjIzNjQwLCJpc3MiOiJodHRwOi8vMTAuMC4yOC43Mjo4MTgwL2F1dGgvcmVhbG1zL2Nib2otcmV0YWlsIiwic3ViIjoiNmMwYzliM2EtMTQ1Ni00ZDg4LTg2NzEtZDQ1Yjk1ZWJhMjQwIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiY2Jvai1yZXRhaWwtd2ViIiwibm9uY2UiOiJmNmZmNDZmYy1mMGYzLTQ1ZDAtOGEwZS0wOGY0YTkxZmVmYTUiLCJhdXRoX3RpbWUiOjE2NDQyMjM1MzQsInNlc3Npb25fc3RhdGUiOiJhMTMyZWJiMS01NjNjLTQ3ZWItOTZmNS1iMDFhNmJlYTg3MTAiLCJhY3IiOiIwIiwic2NvcGUiOiJvcGVuaWQgcHJvZmlsZSBlbWFpbCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwidXNlcl9uYW1lIjoiMjAwMjMwMyIsIm5hbWUiOiJBWlpBTSBXQVNGSSBEQVJXSVNIIEFOTkFCIiwicHJlZmVycmVkX3VzZXJuYW1lIjoiMjAwMjMwMyIsIkN1c3RvbWVySUQiOiIyMDAyMzAzIiwiZ2l2ZW5fbmFtZSI6IkFaWkFNIFdBU0ZJIERBUldJU0giLCJsb2NhbGUiOiJlbi1HQiIsImZhbWlseV9uYW1lIjoiQU5OQUIiLCJCYW5rSUQiOiJDQk9KIiwiVXNlclR5cGUiOiJSZXRhaWwiLCJlbWFpbCI6ImF6emFtQGEuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9ncm91cF91c2VyKFVTRVIpIiwiUk9MRV9VU0VSIiwiUk9MRV9ncm91cF9yZXRhaWxfam9yZGFuKFVTRVIpIl19.a7E07RNe3K9IxCkYLcGxirGzfZgDPH_WmarArbceUgw";
		 
		 Response response = 
				 given()				
				 .header("Authorization", "Bearer "+token)				
				 .when()				
				 //.get("http://172.20.6.99:8080/cboj-bb-travel-insurance-service/v2/travelInsurance/customerInfo")	
				//.get("http://travel-insurance/cboj-bb-travel-insurance-service/v2/travelInsurance/customerInfo")
				 .get("http://172.20.6.110:8080/cboj-bb-travel-insurance-service/v2/travelInsurance/customerInfo")			 
				 .then()					
				 .log()				
				 .all()				
				 .contentType(ContentType.JSON)
				 .extract().response()   	
				 ;
		 
		 
		 APIGlobalVariable.Consol = response.jsonPath().prettify();
		
		 
		// Verifications and extracting needed values go here	
		 
		 Assert.assertEquals(response.getStatusCode(), 200, "header status code is not 200");
		 
		 String jicoId = response.jsonPath().getString("jicoId");
		 
		 int jicoId_as_int = Integer.parseInt(jicoId);
		 
		 APIGlobalVariable.jicoId = jicoId_as_int;
		 
		 //Assert.assertEquals(jicoId, "42077", "jicoId tag does not retrieve '42077' value");
		 
		 Assert.assertNotNull(response.jsonPath().getString("jicoId"), "jicoId is not retrieved");
		 
		 System.out.println("jicoId value is:  "+APIGlobalVariable.jicoId);
		 
		 	 
	}

}
