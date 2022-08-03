package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.SetupBrowserDriver;

import base.SetupBrowserDriver;
import pages.ExamTextBox;


public class ExamTextboxTest {

	private String chromePath ="D:\\HoangAnh\\software\\selenium\\chromedriver_win32\\chromedriver.exe";
	private String urlTest ="https://demoqa.com/text-box";
	private WebDriver driver;
	private SetupBrowserDriver setupBrowserDriver;
	
//	@BeforeClass
//	public void setupDriver() {
//		setupBrowserDriver = new SetupBrowserDriver();
//		
//		setupBrowserDriver.setBrowserDriver(1, chromePath, urlTest);
//		this.driver = setupBrowserDriver.getDriver();
//	
//	}
//	@AfterClass
//	public void quitDriver() throws Exception {
//		setupBrowserDriver.quitDriver();
//	}
	
	@Test
	public void submitCorrectData() throws Exception {
		setupBrowserDriver = new SetupBrowserDriver();
		
		setupBrowserDriver.setBrowserDriver(1, chromePath, urlTest);
		this.driver = setupBrowserDriver.getDriver();
		
		String fillUserName ="Nguyen Anh";
		String fillUserEmail = "sss@gmail.com";
		String fillUserAddress= "ssssssss";
		ExamTextBox examTextbox = new ExamTextBox();
		
		examTextbox.inputDriver(this.driver);
		examTextbox.fillDataTextbox(fillUserName, fillUserEmail, fillUserAddress);
		examTextbox.clickSubmit();	
		if(examTextbox.checkOutputDataDiv() == false) {
			System.out.println("Testcse submit correct data : Passed");
		}else {
			System.out.println("Testcse submit correct data : Failed");
		}
			
	}
	
	@Test
	public void submitWrongEmail() {
		
		setupBrowserDriver = new SetupBrowserDriver();
		
		setupBrowserDriver.setBrowserDriver(1, chromePath, urlTest);
		this.driver = setupBrowserDriver.getDriver();
		String fillUserName ="Khang An";
		String fillUserEmail = "testmail";
		String fillUserAddress= "ssssssss";
		ExamTextBox examTextbox = new ExamTextBox();
		
		examTextbox.inputDriver(this.driver);
		
		examTextbox.fillDataTextbox(fillUserName, fillUserEmail, fillUserAddress);
		
		examTextbox.clickSubmit();
				
		if(examTextbox.checkEmailValidate()== true && examTextbox.checkOutputDataDiv()) {
			System.out.println("Testcase submit worng data : Passed. The red line is appeard");
		}else {
			System.out.println("Testcase submit worng data: Failed");
		}
		
		
	}
}
