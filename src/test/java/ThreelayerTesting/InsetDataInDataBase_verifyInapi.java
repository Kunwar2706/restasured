package ThreelayerTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

public class InsetDataInDataBase_verifyInapi {
	public static void main(String[] args) throws Throwable {
		
		Connection conn = null;
		int result=0;
		try {
			Driver driver=new Driver();

			
			//step1: get register to the data base
			DriverManager.registerDriver((java.sql.Driver) driver);

			//step2: get connection to the database
			conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%","root");

			//step 3: issue create statement

			Statement state = conn.createStatement();
			String query = "insert into project values('TY_project_210','ak'.21/12/2022','vtiger','created',4);";

			//step4: update query
			result = state.executeUpdate(query);
		}


		catch(Exception e) {

		}
		finally {
			if(result==1) {
				System.out.println("inserted sucessfully");
			}
			else {
				System.out.println("failed to insert");
			}

		}
		WebDriver driver=new ChromeDriver();
		driver.get("http:rmgtestingserver:8084");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputpassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
	}
}
