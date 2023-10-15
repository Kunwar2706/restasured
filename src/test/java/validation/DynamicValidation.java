package validation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicValidation {
	@Test
	public void dynamicResP()
	{

		//pre condtion 
		String expData="TY_PROJ_11287";
		port=8084;
		//action
		Response resp = when().get("/projects");
		//validation
		boolean flag = false;
	List<String> pIDs = resp.jsonPath().get("projectId");
	for(String ProjectID:pIDs)
	{
		if(ProjectID.equalsIgnoreCase(expData))
		{
			flag=true;
		}
	}
	Assert.assertTrue(flag);
	System.out.println("data verified");
	resp.then().statusCode(200).log().all();

	}
}
