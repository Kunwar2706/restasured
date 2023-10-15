package ThreelayerTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;




public class VerifyProjectThroughDataBase{
	
	@Test
	public void verifyProject() throws Throwable
	{
		String actPro="vpa AquaFarm497";
		 Connection conn = null;
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
		
			conn=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%","root");
			Statement state = conn.createStatement();
		String query=" select*from project where created_by='aks'";
		ResultSet result = state.executeQuery(query);
		while(result.next())
		{
			String createdPro = result.getString(4);
			System.out.println(createdPro);
			if(actPro.equalsIgnoreCase(createdPro));
			
			
		}
		System.out.println("project created sucessfully");
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		finally {
			conn.close();
		}
	}
	
	
	}



