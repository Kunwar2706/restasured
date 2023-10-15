package authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class BasicAuth {
@Test
	public void basicAuth()
	{
		given().auth().basic("rmgyantra","rmgy@9999")
		.when().get("http://rmgtestingserver:8084/login")
		.then().assertThat().log().all();
	
	}
}
