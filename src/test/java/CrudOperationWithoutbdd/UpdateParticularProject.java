 package CrudOperationWithoutbdd;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class UpdateParticularProject {
public void update()
{
	JSONObject job=new JSONObject();
	job.put("createdBy"," ak singh");
	job.put("projectName","vpa AquaFarm9");
	job.put("Status","Complited");
	job.put("teamSize", 12);
	RequestSpecification reqsp = RestAssured.given();
	reqsp.body(job);
	reqsp.contentType(ContentType.JSON);
	//updation
	reqsp.put("http://rmgtestingserver:8084/projects/TY_PROJ_18841");
}
}
