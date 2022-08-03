package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import base.SetupBrowserDriver;

public class DemoRobotTest {
	public String driverPath = "D:\\HoangAnh\\software\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe";
	public String sampleUrl = "http://spreadsheetpage.com/index.php/file/C35/P10/";
	public WebDriver driver;
	 @Test	
	    public  void  execution() throws InterruptedException, AWTException {
		 try {
			    SetupBrowserDriver setupBrowser = new SetupBrowserDriver();
			    setupBrowser.setBrowserDriver(2, driverPath, sampleUrl);
		        
		        Robot robot = new Robot();	
		        robot.mouseMove(630, 530); // move mouse point to specific location	
		        robot.delay(1500);        // delay is to make code wait for mentioned milliseconds before executing next step	
		        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // press left click	
		        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // release left click	
		        robot.delay(1500);	
		        robot.keyPress(KeyEvent.VK_DOWN); // press keyboard arrow key to select Save radio button	
		        Thread.sleep(2000);	
		        robot.keyPress(KeyEvent.VK_ENTER);	
		        // press enter key of keyboard to perform above selected action	
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	        
	    }	
	 

}
