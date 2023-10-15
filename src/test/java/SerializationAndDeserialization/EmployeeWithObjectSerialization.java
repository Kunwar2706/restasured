package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.EmployeeWithObject;
import pojoClass.Spouse;

public class EmployeeWithObjectSerialization {
@Test
	public void employeeWihObjSeri() throws JsonGenerationException, JsonMappingException, IOException
	{
		int[]ar= {9431295,620388};
		Spouse sp=new Spouse("anjali",255,74445);
		EmployeeWithObject eobj=new EmployeeWithObject("kunwar", 310, ar,sp);
		ObjectMapper omap=new ObjectMapper();
		omap.writeValue(new File("./empObj.json"), eobj);
	}
}
