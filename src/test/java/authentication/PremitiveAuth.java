package authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PremitiveAuth {
	@Test
	public void premitive()
	{
		given().auth().preemptive().basic("rmgyantra","rmgy@9999")
		.when().get("http://rmgtestingserver:8084/login")
		.then().log().all();
	}

}
