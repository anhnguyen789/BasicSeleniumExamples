package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SigninPage {

	
	private WebDriver driver;
	private By userNameInput = By.name("uid");
	private By passwordInput = By.name("password");
	private By btnloginInput = By.name("btnLogin");
	
	
	public void  inputDriver(WebDriver driver) {
		this.driver =  driver;
	}
	public void singIn(String userName, String password) {
		setUserName(userName);
		setPassword(password);
		
		clickSignIn();
	}
	
	private void setUserName(String userName) {
		System.out.println("set use name");
		WebElement uName = driver.findElement(userNameInput);
		if(uName.isDisplayed()) {
			uName.sendKeys(userName);
		}
	}
	private void setPassword(String password) {
		System.out.println("set pass");
		WebElement uPassword = driver.findElement(passwordInput);
		if(uPassword.isDisplayed()) {
			uPassword.sendKeys(password);
		}
	}
	private void clickSignIn()  {
		try {
			WebElement btnSignIn = driver.findElement(btnloginInput);
			if(btnSignIn.isDisplayed()) {
				btnSignIn.click();
			}
		} catch (Exception e) {
			System.out.println("Error... " + e.getStackTrace());
		}
		
	}
	
	

}
