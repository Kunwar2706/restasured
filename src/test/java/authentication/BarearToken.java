package authentication;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;

public class BarearToken {

	public void barearToken()
	{
	baseURI="https://github.com";
	JSONObject job=new JSONObject();
	job.put("name"," aks");
	job.put("description"," this is my new proj");
	given().auth().oauth2("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 ").body(job).contentType(ContentType.JSON)
	.when().post("https://api.github.com/orgs/ORG/repos ")
	.then().log().all();
	}
}
