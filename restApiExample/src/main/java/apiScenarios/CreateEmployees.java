package apiScenarios;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class CreateEmployees extends Base {

	@Test
	public void createEmp() {		
		File fileSrc = new File("./data/empdetail.json");
		// Post the request
		Response response=request
				.body(fileSrc).contentType(ContentType.JSON)
				.post(RestAssured.baseURI + "create/")
				;
		
		System.out.println(response.getContentType());
		response.prettyPrint();	
		JsonPath jsonResponse= response.jsonPath();
		empId=jsonResponse.get("data.id");
	

		
	}


}
