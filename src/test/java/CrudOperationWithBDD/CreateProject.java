package CrudOperationWithBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericLibrary.JavaLibrary;
import io.restassured.http.ContentType;

public class CreateProject {
	@Test

	public void  crreateProj() {
	baseURI = "http://rmgtestingserver";
	port=8084;
JavaLibrary jlib= new JavaLibrary(); 

JSONObject jobj=new JSONObject();
jobj.put("createdBy","aks");
jobj.put("projectName","vpa AquaFarm4"+jlib.getRandomNo());
jobj.put("Status","onGoing");
jobj.put("teamSize", 3);
given().body(jobj).contentType(ContentType.JSON)
//step 2 action
.when().post("/addProject")
//step 3
.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}

}
