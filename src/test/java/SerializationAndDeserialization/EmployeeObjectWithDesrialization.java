 package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.EmployeeWithObject;
@Test
public class EmployeeObjectWithDesrialization {

	public void empObjWithDesi() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper omap=new ObjectMapper();
		EmployeeWithObject data = omap.readValue(new File("./empObj.json"),EmployeeWithObject.class);
		System.out.println(data.getEspouse().getName());
		System.out.println(data.getEspouse().getPhnNo());
	}
}
