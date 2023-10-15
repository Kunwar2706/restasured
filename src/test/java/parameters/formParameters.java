package parameters;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class formParameters {

	public void formPara()
	{
		baseURI = "http://rmgtestingserver";
		port=8084;
		given().formParam("createdBy"," akkk")
		.formParam("projectName", "vpa aqua")
		.formParam("status", " created")
		.formParam("teamSize", 4)
		.contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
		
	}
	
}
