package authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Oauth2Auth {
@Test
public void oauth()

{
	//create a request to generate access token
	Response resp = given()
			.formParam("client_id", "OFOS")
			.formParam("client_secret", "8d3ed04192a014cda761c8b9f26c6fb6")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri", "http://example.com")
			.formParam("code", "authorization_code")
			
			.when().post("http://coop.apps.symfonycasts.com/token");
			
			//capture the acces token from the responce of the above request
			
			String token = resp.jsonPath().get("access_token");
			System.out.println(token);
			
			//create another request and use the token to access the apis 
			given()
			.auth().oauth2(token)
			.pathParam("USER_ID", 4352)
			
			.when().post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
			.then().log().all();
}
}
