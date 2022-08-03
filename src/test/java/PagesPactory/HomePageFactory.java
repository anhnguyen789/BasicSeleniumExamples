package PagesPactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {
	
	private WebDriver driver;
	
	@FindBy(xpath="//table//tr[@class='heading3']")
	WebElement homePageUserName;
	
	public void inputDriver(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePageUserName() {
		return homePageUserName.getText();
	}
}
