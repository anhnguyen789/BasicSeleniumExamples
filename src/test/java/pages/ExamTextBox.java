package pages;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.SetupBrowserDriver;

public class ExamTextBox {
	
	private WebDriver driver;
	 @FindBy(id="userName")
	 WebElement elUsertName;
	 
	 @FindBy(id="userEmail")
	 WebElement elUserEmail;
	 @FindBy(id="currentAddress")
	 WebElement elUserAddress;
	 @FindBy(id="permanentAddress")
	 WebElement elUserPamanentAddress;
	 @FindBy(id="submit")
	 WebElement btnSubmit;	 
	 @FindBy(id="output")
	 WebElement divOutputData;
	 
	 public void inputDriver(WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 private boolean checkValidate() {
		 String useName = elUsertName.getText();
		 String userEmail = elUserEmail.getText();
		 String useraddress = elUserAddress.getText();
		 String userPermanentAddress = elUserPamanentAddress.getText();
		 if(useName.isBlank() && userEmail.isBlank() && useraddress.isBlank() && userPermanentAddress.isBlank()) {
			 return false;
			 
		 }else {
			 return true;
		 }
	 }
	 public void fillDataTextbox(String userName, String userEmail, String userAddress) {		
		 elUsertName.sendKeys(userName);
		 elUserEmail.sendKeys(userEmail);
		 elUserAddress.sendKeys(userAddress);
	 }
	 public void clickSubmit() {
		 if(btnSubmit.isEnabled()) {
			 btnSubmit.click();
		 }		
	 }
	 public boolean checkEmailValidate() {
		 String clEmail = elUserEmail.getAttribute("class");
		 return  clEmail.contentEquals("mr-sm-2 field-error form-control");
			 
	
	 }
	 public void clearData() {
		 elUserAddress.clear();
		 elUserEmail.clear();
		 elUserPamanentAddress.clear();
	 }
	 public boolean checkOutputDataDiv() {
		 
		 String outputData = divOutputData.getText();		 
		 return outputData.isBlank();
				  
	 }
	 
	 
	

}
