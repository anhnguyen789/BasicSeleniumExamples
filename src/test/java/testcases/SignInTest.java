package testcases;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.SetupBrowserDriver;
import pages.SigninPage;

public class SignInTest {
	
	public String chromePath ="D:\\HoangAnh\\software\\selenium\\chromedriver_win32\\chromedriver.exe";
	public String appUrl ="http://demo.guru99.com/V4/";
	
	private String userName ="mgr123";
	private String password ="mgr!23";
	public WebDriver driver;
	
	@BeforeClass
	public void  setupDriver() {
						
		SetupBrowserDriver setupDriver = new SetupBrowserDriver();
		
		setupDriver.setBrowserDriver(1, chromePath, appUrl);
		driver = setupDriver.getDriver();
		
		
	}
	
	@Test
	public void signIn() {
		
		SigninPage signInPage = new SigninPage();
		signInPage.inputDriver(driver);
		signInPage.singIn(userName, password);
		
	}
	
	

}
