package objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	
	//genericLibrary.FileUtility fu=new genericLibrary.FileUtility();
	
	@FindBy(id = "usernmae")
	private WebElement username;
	
	@FindBy(id = "inputPassword")
	private WebElement password;
	
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement signBtn;
	
	public LoginPage(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}

	public WebElement getUsername() {
		return username;
	}

	public void setUsername(WebElement username) {
		this.username = username;
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getSignBtn() {
		return signBtn;
	}

	public void setSignBtn(WebElement signBtn) {
		this.signBtn = signBtn;
	}
	
	public void login(String userName, String passWord) throws Throwable
	{
		username.sendKeys(userName);
		password.sendKeys(passWord);
		signBtn.click();
	}

}
