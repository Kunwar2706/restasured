package createProjBY4Ways;

import  static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import genericLibrary.JavaLibrary;
import io.restassured.http.ContentType;

public class CreateProject {
	@Test
public void create()
{       
		Random ran=new Random();
		int rano = ran.nextInt(500);
		baseURI="http://rmstestingserver";
		port=8084;
		
HashMap<String,Object>	map=new HashMap<String,Object>();
map.put(" createdBy","A Singh");
map.put("projectName"," vtig 09"+rano);
map.put("status", "created");
map.put("teamSize",8);
given().body(map).contentType(ContentType.JSON)
.when().post("/addProject")
.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();






	
}
}
