package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v101.css.CSS.GetBackgroundColorsResponse;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DemoActionClass {

	private WebDriver driver;
	
//	@FindBy(xpath = "//header/nav[1]")
	@FindBy(xpath = "//header[@id='header']//ul[@class='nav navbar-nav']/li")
	List<WebElement> elHeader;
	@FindBy(xpath = "//header[@id='header']//nav[@class='navbar navbar-inverse']")
	WebElement nabar;
	
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void validateMenu(String menuColor, String menuHoverColor) throws InterruptedException, Exception { 
		try {
			Actions clsAction = new Actions(this.driver);
			String  strError ="" ;
			
			String currentMenuColor = nabar.getCssValue("background-color");
			if(currentMenuColor.equals(menuColor) == false) {				
				strError += "Color of the menu doesn't display right. The color is display as  "+ currentMenuColor +"\n";
			}
			for(int i = 0; i < elHeader.size(); i++) {		
				Action mouseMoveMenu = clsAction.moveToElement(elHeader.get(i)).build();
				mouseMoveMenu.perform();
				Thread.sleep(100);
				WebElement currentMenuHover = elHeader.get(i).findElement(By.tagName("a"));
				String currentMenuHoverColor = currentMenuHover.getCssValue("background-color");									
				if(currentMenuHoverColor.equals(menuHoverColor) == false) {
					strError +="Color of the menu hover doesn't display right. The color is display as "+currentMenuHoverColor+ " at menu item: "+ currentMenuHover.getAttribute("textContent")+"\n";
				}																	
				if(elHeader.get(i).getAttribute("class").replaceAll(" ", "").contentEquals("dropdown")) { 					
					WebElement subMenuUL = elHeader.get(i).findElement(By.className("dropdown-menu"));										
					List<WebElement> submenuItems = subMenuUL.findElements(By.xpath("li")); 							
					for(int j=0; j < submenuItems.size(); j++) {		
						WebElement currentSubMenuHover = submenuItems.get(j).findElement(By.tagName("a")); 
						Action mouseMoveSubMenu = clsAction.moveToElement(submenuItems.get(j)).build();
						mouseMoveSubMenu.perform();
						Thread.sleep(100);		
						String currentSubMenuHoverColor = currentSubMenuHover.getCssValue("background-color");							
						if(currentSubMenuHoverColor.contentEquals(menuHoverColor) == false ) {
							strError +="Color of the sub menu hover doesn't display right. The color is display as "+currentMenuHoverColor+ " at sub menu item: "+ currentSubMenuHover.getAttribute("textContent")+"\n";
						}
						if(!currentSubMenuHover.getAttribute("class").isEmpty()) {	
							
							WebElement childMenu =  submenuItems.get(j).findElement(By.className("childmenu"));							
							if(childMenu.isEnabled()) {								
								List<WebElement> childMenuItems =  childMenu.findElements(By.tagName("li"));								
								for(int z = 0; z < childMenuItems.size(); z++) {										
									Action mouseMoveChildMenu = clsAction.moveToElement(childMenuItems.get(z)).build();
									mouseMoveChildMenu.perform();
									Thread.sleep(100);																
									String childMenuHoverColor = childMenuItems.get(z).getCssValue("background-color");									
									if(childMenuHoverColor.equals(menuHoverColor) == false) {
										strError +="Color of the child menu hover doesn't display right. The color is display as "+childMenuHoverColor+ " at child menu item: "+ childMenuItems.get(z).getAttribute("textContent")+"\n";
									}
								}
							}
						}
					}	
					
				}
			}
			String finalResult = strError.isBlank() ? "Testcase passed" : "Testcase failed. \n" + strError;
			System.out.println(finalResult);
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		

	
		
	}
	
}
