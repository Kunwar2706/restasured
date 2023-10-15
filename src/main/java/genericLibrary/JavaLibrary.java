package genericLibrary;

import java.util.Random;

public class JavaLibrary {
	public  int getRandomNo() {
		Random ran=new Random();
		int random = ran.nextInt(500);
		return random ;
	}
	public int convertStringToInteger(String str)
	{

		double data=Double.parseDouble(str);
		int data1=(int)data;
		return data1;
	}
}

