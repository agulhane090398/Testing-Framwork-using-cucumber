package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavingsAccount {

	WebDriver driver;
	
	//variable declaration
	@FindBy(partialLinkText ="Admin")
	WebElement admin;
	
	@FindBy(partialLinkText ="Customer")
	WebElement customer;
		
	//Constructor
	public SavingsAccount(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Methods
	public void openAdmin() throws InterruptedException
	{
		admin.click();
//		Thread.sleep(5000);
//		driver.switchTo().alert().accept();
//		driver.switchTo().defaultContent();
//		Thread.sleep(3000);
	}
	
	public void openCustomer()
	{
		customer.click();
		driver.switchTo().alert().accept();
	}
		
}
