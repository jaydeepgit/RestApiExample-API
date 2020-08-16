package apiScenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Base {

	protected RequestSpecification request;
	public static String empId;
	
	@BeforeSuite
	public void setUp() throws FileNotFoundException, IOException {
		
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
		RestAssured.baseURI = "http://"+prop.getProperty("server")+"/";
		request=RestAssured.given().log().all()
				.contentType(ContentType.JSON);
				
	}

	
}