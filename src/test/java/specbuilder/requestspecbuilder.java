package specbuilder;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericLibrary.JavaLibrary;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

public class requestspecbuilder {
	
	@Test
public void reqSpecBuild()
{
  RequestSpecification reqs = new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084").setContentType(ContentType.JSON).build();
  
   ResponseSpecification resp = new ResponseSpecBuilder().expectContentType("application/json") 
		   .expectStatusCode(201).build();
   
   JavaLibrary jlib= new JavaLibrary();

JSONObject jobj=new JSONObject();
jobj.put("createdBy","aks");
jobj.put("projectName","vpa AquaFarm4"+jlib.getRandomNo());
jobj.put("Status","onGoing");
jobj.put("teamSize", 3);
//step 2 action

//step 3
given().spec(reqs).body(jobj)
.when().post("/addProject")
.then().spec(resp).log().all();
	}

   
	  
}

