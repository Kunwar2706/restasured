package CrudOperationWithoutbdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

public class ReadParticularProject {
@Test
public void fetchSingleProject()
{
	//RequestSender reqsen=RestAssured.when();
	Response respo = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_18806");
	System.out.println(respo.contentType());
	System.out.println(respo.prettyPrint());
	System.out.println(respo.asPrettyString());
}
}
