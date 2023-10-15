package validation;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.CreateProjUSing_pojo;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import genericLibrary.JavaLibrary;


public class RequestChainingUSingPathParameter {
@Test
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
	//create a ge4et request  and pass proId As path Parameter
	given()
	.pathParam("pid", proId)
	.when().get("projects/{pid}")
	.then().assertThat().statusCode(200).log().all();
	
	
	
}
}
