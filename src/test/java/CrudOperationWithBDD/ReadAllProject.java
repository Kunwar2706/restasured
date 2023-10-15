package CrudOperationWithBDD;

import  static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ReadAllProject {
	@Test
	public void readAllProject()
	{
		baseURI = "http://rmgtestingserver";
		port=8084;
		
		when().get("/projects")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
		
		
		
	}
}
