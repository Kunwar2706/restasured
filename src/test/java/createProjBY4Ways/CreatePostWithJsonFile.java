package createProjBY4Ways;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.io.File;

import org.testng.annotations.Test;

import genericLibrary.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatePostWithJsonFile {
@Test
	public void createProj()
	{
		baseURI = "http://rmgtestingserver";
		port=8084;
		JavaLibrary jlib=new JavaLibrary();
		File f=new File("./src/test/resources/createProject.json");
        
	 given().body(f).contentType(ContentType.JSON)
	 .when().post("/addProject")
	 .then().assertThat().statusCode(201).log().all();

		
	}
}

	

