package ThreelayerTesting;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import genericLibrary.JavaLibrary;

import static io.restassured.RestAssured.*;

public class CreatepProjFromGui_verifyThroughDatabase {

@Test
public void verifyProj() throws Throwable

{
WebDriver driver=new ChromeDriver();
JavaLibrary jlib=new JavaLibrary();
	String actualProject="vpaAuaFarm"+jlib.getRandomNo();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(" http://rmgtestingserver:8084/");
	driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[.='Sign in']")).click();
	driver.findElement(By.linkText("Projects")).click(); 
	driver.findElement(By.xpath("//span[.='Create Project']")).click();
	driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(actualProject);
	driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Amit singh");
	WebElement status = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
	Select s=new Select(status);
	s.selectByVisibleText("Created");
driver.findElement(By.xpath("//input[@type='submit']")).click();

String proId = driver.findElement(By.xpath("//td[text()='"+actualProject+"']/preceding-sibling::td")).getText();
System.out.println(proId);
//Assert.assertEquals(proId, actualProject);
//Reporter.log("projectAddedSucessfullythrough gui",true);


//veryify hrough database
		//String actPro="vpaAuaFarm314";
		 Connection conn = null;
		try {
			Driver driver1=new Driver();
			DriverManager.registerDriver(driver1);
		
			conn=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%","root");
			Statement state = conn.createStatement();
		String query=" select*from project where created_by='Amit singh'";
		ResultSet result = state.executeQuery(query);
		while(result.next())
		{
			String createdPro = result.getString(4);
			System.out.println(createdPro);
			if(actualProject.equalsIgnoreCase(createdPro))
			System.out.println("project created sucesfully");
			
		}
	
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		finally {
			conn.close();
		}
	//fetch throug api
		baseURI = "http://rmgtestingserver";
		port=8084;
//		proId="TY_PROJ_20387";
		when().get("/projects"+proId)
	.then().assertThat().statusCode(200);
	Reporter.log(" project present in database",true);
		
		
	
	
}
}
