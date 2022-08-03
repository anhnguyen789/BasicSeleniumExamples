package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.SetupBrowserDriver;
import pages.DemoActionClass;
import base.SetupBrowserDriver;

public class DemoActionClassTest {
	
	private String chromePath ="D:\\HoangAnh\\software\\selenium\\chromedriver_win32\\chromedriver.exe";
	private String urlTest ="https://demo.automationtesting.in/Register.html";
	private WebDriver driver;
	private SetupBrowserDriver setupBrowserDriver;
	private DemoActionClass demoActionClass;
	String menuHoverColor = "rgba(0, 87, 154, 1)"; //hex #00579a rgba(0, 87, 154, 1)
	String menuColor = "rgba(76, 174, 234, 1)"; //#65b7ead9
	@Test
	public void checkPlaceHolder() throws InterruptedException, Exception {
		try {
			setupBrowserDriver = new SetupBrowserDriver();
			demoActionClass = new DemoActionClass();
			
			setupBrowserDriver.setBrowserDriver(1, chromePath, urlTest );
			this.driver = setupBrowserDriver.getDriver();
			demoActionClass.setDriver(this.driver);
			
			demoActionClass.validateMenu(menuColor, menuHoverColor);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
	}

}
