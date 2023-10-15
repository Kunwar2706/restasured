package Com.testScriptRmg;

import static io.restassured.RestAssured.given;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import genericLibrary.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import objectRepository.HomePage;
import pojoClass.CreateProjUSing_pojo;

public class CreateProApi_validateInGui_deleteDB extends BaseClass{

	@Test
	public void createProj() throws Throwable
	{
		//Step 1 : create pre requisites
		String createBy = eu.readDataFromExcel("Sheet2", 0, 1);
		String proName = eu.readDataFromExcel("Sheet2", 1, 1)+ju.getRandomNo();	
		String status = eu.readDataFromExcel("Sheet2", 2, 1);
		String teamSize = eu.readDataFromExcel("Sheet2", 3, 1);
		
		int tSize = ju.convertStringToInteger(teamSize);
		
		
	CreateProjUSing_pojo cpup=new CreateProjUSing_pojo(createBy, proName, status, tSize);
	System.out.println("creaetd throuh api+");
	
		
	//	CreateProjUSing_pojo cpup=new CreateProjUSing_pojo("Amit019", "vpaAquaFarm_01"+ju.getRandomNo(), "created", 11);
		
		//Step 2 : send the request
		Response resp = given().body(cpup).contentType(ContentType.JSON)
				.when().post(genericLibrary.EndPointsLibrary.createProject);
		
		//Step : capture the project ID
		String expData = ral.getJsonData(resp, "projectId");
		System.out.println(expData);
	
		
		// validate in gui
		HomePage hp=new HomePage(d);
		hp.getProjectFeature().click();
		
		String proId = d.findElement(By.xpath("//tbody//td[text()='"+proName+"']/preceding-sibling::td")).getText();
		Assert.assertEquals(proId,expData);
		Reporter.log("verified!!",true);
		
		
		

}
}
