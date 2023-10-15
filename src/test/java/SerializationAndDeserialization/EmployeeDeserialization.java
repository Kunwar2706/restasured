package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.Employee;

public class EmployeeDeserialization {
@Test
	public void employeeDesi() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper omap=new ObjectMapper();
		Employee data=omap.readValue(new File("./emp.json"), Employee.class);
		System.out.println(data.getName());
		System.out.println(data.getPhNo());
		System.out.println(data.getId());
	}
}
