package PagesPactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPactory {
	
	private WebDriver driver;
	
	@FindBy (name="uid")
	private WebElement userNameInput;
	@FindBy(name = "password")
	private WebElement userPassInput;
	@FindBy (name = "btnLogin")
	private WebElement btnLoginInput;
	
	public void inputDriver(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 public void signIn(String userName, String userPassword) throws Exception {
		 userNameInput.sendKeys(userName);
		 userPassInput.sendKeys(userPassword);
		 Thread.sleep(1000);
		 btnLoginInput.click();
		 
		 
	 }
}
