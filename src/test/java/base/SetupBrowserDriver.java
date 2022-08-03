package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SetupBrowserDriver {
	
	private WebDriver driver ;

    public WebDriver getDriver() {
		return driver;
	}

	private void setDriver(int browserType, String appUrl, String driverPath) {
		switch(browserType) {
		case 1:
			driver = setupChromeDriver(appUrl, driverPath);
			break;
		case 2:
			driver = setupFirefoxDriver(appUrl, driverPath);
			break;
		default:
			System.out.println("Brower "+browserType+ " is invalid. launching chrome");
			driver = setupChromeDriver(appUrl, driverPath);
		}
		
	}
	
	private static WebDriver setupChromeDriver(String appUrl, String driverPath ) {
		System.setProperty("webdriver.chrome.driver",driverPath);
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.get(appUrl);
		chromeDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return chromeDriver;
		
		
	}
	private static WebDriver setupFirefoxDriver(String appUrl, String driverPath) {
		System.setProperty("webdriver.gecko.driver", driverPath);
		WebDriver firefoxDriver = new FirefoxDriver();
		firefoxDriver.manage().window().maximize();
		firefoxDriver.get(appUrl);
		firefoxDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		firefoxDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return firefoxDriver;
	}
	
	@BeforeClass
	public void setBrowserDriver(int browserType, String driverPath, String appUrl) {
		try {
			setDriver(browserType, appUrl, driverPath);
		} catch (Exception e) {
			System.out.println("Error... "+ e.getStackTrace());
		}
	}

	@AfterClass
	public void quitDriver() throws Exception{
		
			Thread.sleep(2000);
			driver.quit();
		
	}
	
}
