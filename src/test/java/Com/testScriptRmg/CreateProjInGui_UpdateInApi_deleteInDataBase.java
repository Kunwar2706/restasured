package Com.testScriptRmg;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import genericLibrary.EndPointsLibrary;
import genericLibrary.WebDriverUtility;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import objectRepository.HomePage;
import objectRepository.ProjectManagementSystemPage;
import pojoClass.CreateProjUSing_pojo;

public class CreateProjInGui_UpdateInApi_deleteInDataBase extends BaseClass {
	@Test
	public void createPojThrouhGui_upApi_DelDb() throws Throwable, IOException
	{

		HomePage hp=new HomePage(d);
		hp.getProjectFeature().click();
		String projName = eu.readDataFromExcel("Sheet1", 0, 1)+ju.getRandomNo();
		String createdBy = eu.readDataFromExcel("Sheet1", 1, 1)+ju.getRandomNo();
		String valuee = eu.readDataFromExcel("Sheet1", 2, 1);
		ProjectManagementSystemPage pm= new ProjectManagementSystemPage(d);
		pm.createProject(projName, createdBy, valuee);
		System.out.println(projName);
		String proId = d.findElement(By.xpath("//tbody//td[text()='"+projName+"']/preceding-sibling::td")).getText();
		System.out.println(proId);


		//update through api

		String proName = eu.readDataFromExcel("Sheet1", 3, 1)+ju.getRandomNo();
		String teams = eu.readDataFromExcel("Sheet1", 4, 1);
		String status = eu.readDataFromExcel("Sheet1", 5, 1);
		System.out.println(teams);

		int teamSize = Integer.parseInt(teams);
		CreateProjUSing_pojo cp=new CreateProjUSing_pojo(createdBy,proName,status,teamSize);
		Response response = given().spec((RequestSpecification) resp).body(cp)
				.when().put(EndPointsLibrary.updateProject+proId);
		String exprPoId = ral.getJsonData(response,"projectId");
		System.out.println("project updated in api");

		//validate in db

		String query="select*from project";
		dbl.readDataFromDBAndValidate(query, 1, exprPoId);
		System.out.println("sucessfully verfied in db");







	}



}
