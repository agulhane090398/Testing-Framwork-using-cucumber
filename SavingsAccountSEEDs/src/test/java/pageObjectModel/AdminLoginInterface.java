package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginInterface {
	
	WebDriver driver;
	
	//C
	public AdminLoginInterface(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//L
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//*[@type=\"submit\"]")
	WebElement login;

	@FindBy(xpath = "//td/u[1]")
	WebElement forgotPassword;
	
	@FindBy(xpath = "//td/u[2]")
	WebElement forgotId;

//	@FindBy(linkText = "Setup")
//	WebElement setup;
//
//	@FindBy(linkText = "Bank")
//	WebElement bank;
//	
//	@FindBy(linkText = "Branch")
//	WebElement branch;
//	
//	@FindBy(linkText = "Customer")
//	WebElement customer;
	
	
	//M
	
	public void enterCredentials(String id,String pwd)
	{
		username.clear();
		username.sendKeys(id);
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickOnLogin()
	{
		login.click();
	}
	
	public void clickOnForgotId()
	{
		forgotId.click();
	}
	
	public void clickOnForgotpwd()
	{
		forgotPassword.click();
	}
	


}
