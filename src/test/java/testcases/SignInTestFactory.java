package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.SetupBrowserDriver; 
import PagesPactory.SignInPactory;

public class SignInTestFactory {
	
	public String chromePath ="D:\\HoangAnh\\software\\selenium\\chromedriver_win32\\chromedriver.exe";
	public String appUrl ="http://demo.guru99.com/V4/";
	
	private String userName ="mgr123";
	private String password ="mgr!23";
	public WebDriver driver;
	
	@BeforeClass
	public void setupDriver() {
		SetupBrowserDriver setupBrower = new SetupBrowserDriver();
		setupBrower.setBrowserDriver(1, chromePath, appUrl);
		driver = setupBrower.getDriver();
		
		
	}
	
	@Test
	public void SignIn() {
		try {
			SignInPactory signInF = new SignInPactory();
			signInF.inputDriver(driver);
			signInF.signIn(userName, password);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		
		
	}

}
