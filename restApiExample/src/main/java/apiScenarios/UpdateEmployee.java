package apiScenarios;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UpdateEmployee extends Base {

	@Test
	public void getEmp() {		
		File fileSrc = new File("./data/UpdateEmpDetail.json");
		// Put the request
		Response response=request
				.body(fileSrc).contentType(ContentType.JSON)
				.put(RestAssured.baseURI + "update/"+ empId)
				;
		
		System.out.println(response.getContentType());
		response.prettyPrint();
		
	

		
	}


}
