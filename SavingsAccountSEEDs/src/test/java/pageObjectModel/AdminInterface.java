package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminInterface {
	WebDriver driver;
	
	//C
	public AdminInterface(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//WE
	@FindBy(xpath="//*[@value='Logout']")
	WebElement logout;
	
	@FindBy(linkText="Setup")
	WebElement setup;
	
	@FindBy(linkText="admin")
	WebElement profile;
	
	@FindBy(linkText="Bank")
	WebElement bank;
	
	@FindBy(linkText="Branch")
	WebElement branch;
	
	@FindBy(linkText="Customer")
	WebElement customer;
	
	//M
	public void clickLogout()
	{
		logout.click();
	}

	public void clickProfile()
	{
		profile.click();
	}

	public void clickBank()
	{
		bank.click();
	}

	public void clickBranch()
	{
		branch.click();
	}

	public void clickCustomer()
	{
		customer.click();
	}

	public WebElement moveOverSetup()
	{
		return setup;
	}
	
	public WebElement moveToSetup()
	{
		return setup;
	}

	public WebElement moveToBank()
	{
		return bank;
	}
	
	public WebElement moveToBranch()
	{
		return branch;
	}
	
	public WebElement moveToCustomer()
	{
		return customer;
	}

}
