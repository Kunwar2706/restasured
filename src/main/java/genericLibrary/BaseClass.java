package genericLibrary;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import  static io.restassured.RestAssured.*;
import objectRepository.HomePage;
import objectRepository.LoginPage;


public class BaseClass {

	public WebDriver d;
	public static WebDriver sdriver;
	
	public WebDriverUtility wdu=new WebDriverUtility();
	public ExcelUtility eu=new ExcelUtility();
	public DatabaseLibrary dbl=new DatabaseLibrary();
	public FileUtility fu=new FileUtility();
	public JavaLibrary ju=new JavaLibrary();
	public RestAssuredLibrary ral=new RestAssuredLibrary();
	public RequestSpecification reqst;
	public ResponseSpecification resp;
	
	@BeforeSuite
	public void configDB() throws Throwable
	{
		
		dbl.connectToDB();
		//baseURI = "http://rmgtestingserver";
		//port = 8084;
	reqst = new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084")
	.setContentType(ContentType.JSON).build();
		System.out.println("---connect to DB---");
	}
	
	@BeforeClass
	public void configBC() throws Throwable
	//public void configBC(String BROWSER) throws IOException
	{
//		String BROWSER = fu.readDataFromPropertFile("browser");
//		
//		String URL = fu.readDataFromPropertFile("Url");
//		
//		if(BROWSER.equalsIgnoreCase("firefox"))
//		{
//			d=new FirefoxDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("chrome"))
//		{
//			d=new ChromeDriver();
//		}
//		else
//		{
//			System.out.println("Invalid Browser");
//		}
//		
//		sdriver=d;
		d =new ChromeDriver();

		wdu.maximizeWindow(d);
		wdu.implicitWait(d);
		d.get(IPathConstant.Url);
		
		System.out.println("---Launch the browser---");
	}
	
	@BeforeMethod
	public void configBM() throws Throwable
	{
		//String USERNAME = fu.readDataFromPropertFile("username");
		//String PASSWORD = fu.readDataFromPropertFile("password");
		
		Thread.sleep(2000);
		LoginPage lp=new LoginPage(d);
		//lp.login(USERNAME, PASSWORD);
		lp.login(IPathConstant.appUserName,IPathConstant.appPassword);
		System.out.println("---Login to App---");
	}
	
	
	@AfterMethod
	public void configAM()
	{
		HomePage hp=new HomePage(d);
		hp.logout();
		System.out.println("---Logout from the App---");
	}
	
	@AfterClass
	public void configAC()
	{
		d.quit();
		System.out.println("---Close the browser---");
	}
	
	@AfterSuite
	public void disconnectDB() throws SQLException
	{
		dbl.closeDB();
		resp = new ResponseSpecBuilder().expectContentType("application/json")
		.build();
		System.out.println("---Close the DB---");
	}

}
