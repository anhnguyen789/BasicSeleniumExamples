package testcases;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import base.SetupBrowserDriver;

public class DemoCheckboxTest {

	private String chromePath ="D:\\HoangAnh\\software\\selenium\\chromedriver_win32\\chromedriver.exe";
	SetupBrowserDriver setupBrowser ;
	WebDriver driver;
	public String testUrl = "https://demoqa.com/checkbox";
	
	@Test	
	public void checkboxTest() throws Exception {
		
			
			setupBrowser = new SetupBrowserDriver();
			setupBrowser.setBrowserDriver(1, chromePath, testUrl);
			driver = setupBrowser.getDriver();
			String strError ="";
			
			
			WebElement treeNode = driver.findElement(By.id("tree-node"));
			WebElement nodeItems = treeNode.findElement(By.xpath("ol/li"));
			WebElement btnExpandHome = nodeItems.findElement(By.xpath("//button[@class='rct-collapse rct-collapse-btn']"));			
			
			btnExpandHome.click();		
						
			WebElement svgHome = btnExpandHome.findElement(By.tagName("svg"));
			String iconStatus = svgHome.getAttribute("class");	
			
			if(!iconStatus.equals("rct-icon rct-icon-expand-open")) {
				strError += "The expand icon of home is wrong. \n";
			}			
		
			List<WebElement> subNodes = nodeItems.findElements(By.xpath("ol"));			
			if(subNodes.size() > 0 ){
				List<WebElement> subNodeItems = nodeItems.findElements(By.xpath("ol/li"));
				System.out.println("node item "+ subNodeItems.size());
			}else {
				System.out.println("ssssssssssssssssssss");
			}
		
		
		
		
		
		setupBrowser.quitDriver();
	}
}
