package CrudOperationWithoutbdd;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSender;

public class DeleteParticularProject {
public void delete()
{
	RequestSender del = RestAssured.when();
	del.delete("http://rmgtestingserver:8084/projects/TY_PROJ_18806");
}
}
