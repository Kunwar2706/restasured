package validation;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

import io.restassured.response.Response;

public class StaticValidation {

	public void staticvalid()
	{
	
		//pre condtion
		String expData=" TY_PROJ_11289";
		baseURI = "http://rmgtestingsever";
		port=8084;
		// action
		Response res=when().get("/projects");
		//validation
		String actData=res.jsonPath().get("[1].projectId");
		
		Assert.assertEquals(actData,expData);
		System.out.println("data is verfied");
		res.then().log().all();
		
		
	}
}
