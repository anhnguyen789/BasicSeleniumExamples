package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.SetupBrowserDriver;

public class ParameterByDataProvider  {
	
	WebDriver driver;
	public String chromePath ="D:\\HoangAnh\\software\\selenium\\chromedriver_win32\\chromedriver.exe";
	public String appUrl ="https://google.com";
	
	@BeforeClass
	public void setupDriver() {
		SetupBrowserDriver setupBrowser = new SetupBrowserDriver();
		
		setupBrowser.setBrowserDriver(1, chromePath, appUrl);
		driver = setupBrowser.getDriver();
	}
	
	@Test(dataProvider = "SearchProvider", dataProviderClass = parameters.DataProviderClass.class)
	public void serchMethod(String author, String keyWord) throws InterruptedException {
		WebElement txtSearch = driver.findElement(By.name("q"));
		txtSearch.sendKeys(keyWord);
		System.out.println("Welcome ->"+author+" Your search key is->"+keyWord);
        Thread.sleep(3000);
        String testValue = txtSearch.getAttribute("value");
        System.out.println(testValue +"::::"+keyWord);
        txtSearch.clear();
        //Verify if the value in google search box is correct
        Assert.assertTrue(testValue.equalsIgnoreCase(keyWord));
		
	}
	
//	@DataProvider(name="SearchProvider")
//    public Object[][] getDataFromDataprovider(){
//    return new Object[][] 
//    	{
//            { "Guru99", "India" },
//            { "Krishna", "UK" },
//            { "Bhupesh", "USA" }
//        };
//
//    }
	

}
