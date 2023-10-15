package CrudOperationWithoutbdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

public class ReadProject {
@Test
public void fetch()
{
	//RequestSender resSen=RestAssured.when();
	Response respo = RestAssured.get("http://rmgtestingserver:8084/projects");
	System.out.println(respo.contentType());
	System.out.println(respo.prettyPrint());
	System.out.println(respo.asString());
	respo.then().log().all();
}

}
