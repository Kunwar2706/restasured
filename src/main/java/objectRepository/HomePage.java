package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(linkText = "Home")
	private WebElement homeFeature;
	
	@FindBy(linkText = "Projects")
	private WebElement projectFeature;
	
	@FindBy(linkText = "Logout")
	private WebElement lgBtn;
	
	public HomePage(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}

	public WebElement getHomeFeature() {
		return homeFeature;
	}

	public void setHomeFeature(WebElement homeFeature) {
		this.homeFeature = homeFeature;
	}

	public WebElement getProjectFeature() {
		return projectFeature;
	}

	public void setProjectFeature(WebElement projectFeature) {
		this.projectFeature = projectFeature;
	}

	public WebElement getLgBtn() {
		return lgBtn;
	}

	public void setLgBtn(WebElement lgBtn) {
		this.lgBtn = lgBtn;
	}
	
	public void logout()
	{
		lgBtn.click();
	}

}
