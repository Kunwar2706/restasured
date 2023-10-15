 package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.Employee;
import pojoClass.EmpoyeeWithArray;

public class EmployeeWithArrayDeseilization {
	@Test
public void employeeWithArrDesi() throws JsonParseException, JsonMappingException, IOException
{
	ObjectMapper omap=new ObjectMapper();
	EmpoyeeWithArray data = omap.readValue(new File("./empArr.json"),EmpoyeeWithArray.class);
	System.out.println();
	System.out.println(data.getName());
	System.out.println(data.getPhone()[1]);
	System.out.println(data.getId());
}
}
