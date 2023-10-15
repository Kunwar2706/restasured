package createProjBY4Ways;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojoClass.CreateProjUSing_pojo;

public class createProj_UsingPojo {

@Test

	public void createProj()
	{
	baseURI="http://rmstestingserver";
	port=8084;
		CreateProjUSing_pojo cp=new CreateProjUSing_pojo("aks","vpa55" , "created", 40);
		given().body(cp).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
		
		
	}
}
