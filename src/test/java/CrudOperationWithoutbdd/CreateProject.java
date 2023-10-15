 package CrudOperationWithoutbdd;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	@Test
	public void Create()
	{
		Random ran=new Random();
		int rando = ran.nextInt(50);
		//create pre condtion request
		JSONObject job=new JSONObject();
		job.put("createdBy"," ak singh");
		job.put("projectName","vpa AquaFarm9"+rando);
		job.put("Status","onGoing");
		job.put("teamSize", 10);
		// perform the action
		RequestSpecification res=RestAssured.given();

		//res.body(job);
		
		res.contentType(ContentType.JSON);
		 Response respo = res.post("http://rmgtestingserver:8084/addProject");
		ResponseBody responsebody = respo.getBody();
		String bodyString = responsebody.asString();
		Assert.assertEquals(bodyString.contains("vpa"), true,"validated");
		 //validate the response
//		 System.out.println(respo.contentType());
//		 System.out.println(respo.prettyPrint());
//		 System.out.println(respo.prettyPeek());
//		 System.out.println(respo.asString());
//		 
				 
	
	}
}
