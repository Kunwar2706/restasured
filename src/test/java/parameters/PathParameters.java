package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameters {
	
@Test
public void pathpara()
{
	given().pathParam("pid", "TY_PROJ_19255")
	.when().get("http://rmgtestingserver:8084/projects/{pid}")
	.then().assertThat().statusCode(200).log().all();
	
}
}
