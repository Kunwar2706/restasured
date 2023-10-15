package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.EmpoyeeWithArray;

public class EmployeeWithArraySerialization {
@Test
	public void EmployeeWithArraySeri() throws JsonGenerationException, JsonMappingException, IOException
	{ 
	int []ar= {92333,6666};
		EmpoyeeWithArray emp=new EmpoyeeWithArray("Arshit",310,ar);
		ObjectMapper omap=new ObjectMapper();
		omap.writeValue(new File("./empArr.json"), emp);
	}
}
