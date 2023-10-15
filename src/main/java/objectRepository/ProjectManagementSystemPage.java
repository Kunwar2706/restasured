package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibrary.JavaLibrary;
import genericLibrary.WebDriverUtility;


public class ProjectManagementSystemPage {
	
	WebDriverUtility wdu=new WebDriverUtility();
	JavaLibrary jl=new JavaLibrary();
	
	
	@FindBy(xpath = "//span[text()='Create Project']")
	private WebElement createProjBtn;
	
	@FindBy(name = "projectName")
	private WebElement projNameTbx;
	
	@FindBy(name = "createdBy")
	private WebElement projManagerOrcreatedByTbx;
	
	@FindBy(name = "status")
	private WebElement sSStatusLBx;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement addProjectBtn;
	
	public ProjectManagementSystemPage(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}
	
	public WebElement getCreateProjBtn() {
		return createProjBtn;
	}

	public void setCreateProjBtn(WebElement createProjBtn) {
		this.createProjBtn = createProjBtn;
	}

	public WebElement getProjNameTbx() {
		return projNameTbx;
	}

	public void setProjNameTbx(WebElement projNameTbx) {
		this.projNameTbx = projNameTbx;
	}

	public WebElement getProjManagerOrcreatedByTbx() {
		return projManagerOrcreatedByTbx;
	}

	public void setProjManagerOrcreatedByTbx(WebElement projManagerOrcreatedByTbx) {
		this.projManagerOrcreatedByTbx = projManagerOrcreatedByTbx;
	}

	public WebElement getsSStatusLBx() {
		return sSStatusLBx;
	}

	public void setsSStatusLBx(WebElement sSStatusLBx) {
		this.sSStatusLBx = sSStatusLBx;
	}

	public WebElement getAddProjectBtn() {
		return addProjectBtn;
	}

	public void setAddProjectBtn(WebElement addProjectBtn) {
		this.addProjectBtn = addProjectBtn;
	}

	public void createProject(String projName, String createdBy, String value) throws Throwable
	{
		createProjBtn.click();
		projNameTbx.sendKeys(projName);
		projManagerOrcreatedByTbx.sendKeys(createdBy);
		Thread.sleep(2000);
		wdu.selectByValue(sSStatusLBx, value);
		addProjectBtn.click();
		
	}
}
