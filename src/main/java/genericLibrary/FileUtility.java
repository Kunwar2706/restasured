package genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {

	public  String readDataFromPropertFile(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstant.FILEPATH);
		Properties pObj=new Properties();
		pObj.load(fis);
		    String value = pObj.getProperty(key);
		    return value;
		
	}
		

	}


