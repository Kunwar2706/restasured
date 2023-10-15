package ThreelayerTesting;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import genericLibrary.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;



public class CraeteProjectFromApiVerifyOnguiand_validate_usngdb {
	
@Test
	public void createProjfromApi   () throws Throwable
	{
		baseURI = "http://rmgtestingserver";
		port=8084;
	JavaLibrary jlib= new JavaLibrary(); 

	JSONObject jobj=new JSONObject();
	jobj.put("createdBy","aks");
	jobj.put("projectName","vpa AquaFarm4"+jlib.getRandomNo());
	jobj.put("Status","onGoing");
	jobj.put("teamSize", 3);
	 Response resp = given().body(jobj).contentType(ContentType.JSON)
			.when().post("/addProject");
	 resp.then().log().all();
	 String pid = resp.jsonPath().get("projectId");
	// Object proName = resp.jsonPath().get("");
     
	WebDriver driver=new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(" http://rmgtestingserver:8084/");
	driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[.='Sign in']")).click();
	driver.findElement(By.linkText("Projects")).click(); 
	String proid=driver.findElement(By.xpath("//td[text()='"+pid+"']")).getText();
	Assert.assertEquals(proid,pid);
	Reporter.log("verified!!",true);
	

	//veryify hrough database
		String actPro="vpa AquaFarm497";
		 Connection conn = null;
		try {
			Driver driver1=new Driver();
			DriverManager.registerDriver(driver1);
		
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


