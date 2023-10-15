package DataDrivenTesting;

import org.junit.experimental.theories.DataPoint;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericLibrary.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import pojoClass.CreateProjUSing_pojo;

public class CreateMultipleProjectWithDiffData {
	@Test(dataProvider="addProject")
	public void createProjectByDataProvider(String createdBy,String projectName,String status,int teamSize)
	
	
	{
		baseURI="http://rmgtestingserver";
		port=8084;
	CreateProjUSing_pojo cp=new CreateProjUSing_pojo(createdBy, projectName, status, teamSize);
	System.out.println(createdBy+" "+projectName+" "+status+" "+teamSize);
	given().body(cp).contentType(ContentType.JSON)
	.when().post("/addProject")
	.then().assertThat().statusCode(201).contentType(ContentType.JSON)
	.log().all();
	
	}
	@DataProvider
	public Object[][] addProject()
	{
		JavaLibrary jlib=new JavaLibrary();
		Object[][] obj= new Object[2][4];
		obj[0][0]="Amit";
		obj[0][1]="Selenium"+jlib.getRandomNo();
		obj[0][2]="done";
		obj[0][3]=5;
		
		obj[1][0]="Amit Munda";
		obj[1][1]="Java"+jlib.getRandomNo();
		obj[1][2]="done";
		obj[1][3]=5;
		
		return obj;
		
	}

}
