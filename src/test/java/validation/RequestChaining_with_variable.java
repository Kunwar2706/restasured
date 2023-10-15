package validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import genericLibrary.JavaLibrary;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.CreateProjUSing_pojo;

public class RequestChaining_with_variable {
	public void requestChaining()
	{
		//step 1 create project using pojo
		JavaLibrary jlib=new JavaLibrary();
		CreateProjUSing_pojo emp=new CreateProjUSing_pojo("advik","google"+jlib.getRandomNo(),"completed",30);
		baseURI="http://rmgtestingserver";
		port=8084;
		//precondtion
		Response resp = given().body(emp).contentType(ContentType.JSON)
		.when().post("/addProject");
		//captue the project id
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		resp.then().log().all();
		//create a ge4et request  and pass proId As variable
		
		when().get("/projects/"+proId)
		.then().assertThat().statusCode(200).log().all();
}

	
	}
	
