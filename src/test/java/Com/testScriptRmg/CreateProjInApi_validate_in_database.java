package Com.testScriptRmg;

import org.testng.Assert;
import org.testng.annotations.Test;



import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import pojoClass.CreateProjUSing_pojo;

public class CreateProjInApi_validate_in_database extends genericLibrary.BaseClass {
	
	@Test
	public void createProj() throws Throwable
	{
		//Step 1 : create pre requisites
		CreateProjUSing_pojo cpup=new CreateProjUSing_pojo("Amit019", "vpaAquaFarm_01"+ju.getRandomNo(), "created", 11);
		
		//Step 2 : send the request
		Response resp = given().body(cpup).contentType(ContentType.JSON)
				.when().post(genericLibrary.EndPointsLibrary.createProject);
		
		
		
		//Step : capture the project ID
		String expData = ral.getJsonData(resp, "projectId");
		System.out.println(expData);
		
		//Step 4 : validate the id in database
		String query = "select * from project;";
		String actData = dbl.readDataFromDBAndValidate(query, 1, expData);
		 
		Assert.assertEquals(expData, actData);
		System.out.println("TC PASS");
		
		resp.then().log().all();
		
		when().delete(genericLibrary.EndPointsLibrary.deleteProject+actData);
		
		
				
	}
}
