package apiScenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class GetEmployee extends Base {

	@Test
	public void getEmp() {		
		// get the request
		Response response=request
				.contentType(ContentType.JSON)
				.get(RestAssured.baseURI + "employee/"+"24")
				;
		
		System.out.println(response.getContentType());
		response.prettyPrint();
		
		
		
		JsonPath jsonResponse= response.jsonPath();
		String empId=jsonResponse.get("data.id");
		String empName=jsonResponse.get("data.employee_name");
		System.out.println(empName);
		Assert.assertEquals(empName, "Doris Wilder");

		
	}


}
