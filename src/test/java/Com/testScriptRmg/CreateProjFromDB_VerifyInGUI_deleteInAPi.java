package Com.testScriptRmg;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import genericLibrary.EndPointsLibrary;

import io.restassured.response.Response;

import  static io.restassured.RestAssured.*;
import objectRepository.HomePage;

public class CreateProjFromDB_VerifyInGUI_deleteInAPi extends BaseClass {

	@Test
	public void create() throws Throwable
	{ 
		String proId = eu.readDataFromExcel("Sheet3", 0, 1)+ju.getRandomNo();
		String createBy = eu.readDataFromExcel("Sheet3", 1, 1);
		String date = eu.readDataFromExcel("Sheet3", 2, 1);
		String projName = eu.readDataFromExcel("Sheet3", 3, 1)+ju.getRandomNo();
		String status = eu.readDataFromExcel("Sheet3", 4, 1);
		String teamSize = eu.readDataFromExcel("Sheet3", 5, 1);
		 
		int tSize = ju.convertStringToInteger(teamSize);
		 
		 System.out.println(proId+" "+createBy+" "+date+" "+projName+" "+status+" "+tSize );
	dbl.creteProjThroughDB(proId, createBy, date, projName, status, tSize);
	System.out.println("created");
	
	// validate in gui
			HomePage hp=new HomePage(d);
			hp.getProjectFeature().click();
			
			String expectedId = d.findElement(By.xpath("//tbody//td[text()='"+projName+"']/preceding-sibling::td")).getText();
			Assert.assertEquals(proId,expectedId);
			Reporter.log("verified!!",true);      //td[.='NEWPROJECT']/preceding-sibling::td[1]
			
			// delete through api
		 Response response = given().spec(reqst)
			.when().delete(EndPointsLibrary.deleteProject+expectedId);
		 
			response.then().log().all();
			Reporter.log("deleted from api", true);
			
	}
}
