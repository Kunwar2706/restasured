package CrudOperationWithoutbdd;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

import io.restassured.http.ContentType;

public class DeleteParticularProject1 {

	public void delete()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
	
		when().get("/projects/TY_PROJ_19089")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)
		.time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS).log().all();
}
}
