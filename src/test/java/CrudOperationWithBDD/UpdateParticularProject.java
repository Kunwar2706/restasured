package CrudOperationWithBDD;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import javax.swing.text.AbstractDocument.Content;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericLibrary.JavaLibrary;
import io.restassured.http.ContentType;

public class UpdateParticularProject  {
	
@Test
	public void  updatePartProject()
	{
	baseURI = "http://rmgtestingserver";
	port=8084;
	JavaLibrary jlib=new JavaLibrary();
		JSONObject jobj=new  JSONObject();
		jobj.put("createdBy","aks");
		jobj.put("projectName","vpa AquaFarm4"+jlib.getRandomNo());
		jobj.put("Status","comlited");
		jobj.put("teamSize", 5);
		given().body(jobj).contentType(ContentType.JSON)
		.when().put("/projects/TY_PROJ_19055")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)
		
		.time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS).log().all();
		
	}

}
