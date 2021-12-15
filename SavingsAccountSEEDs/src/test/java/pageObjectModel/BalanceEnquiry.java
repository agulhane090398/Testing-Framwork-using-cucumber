package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BalanceEnquiry {

	WebDriver driver;
	
	public BalanceEnquiry(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//WE & M
	@FindBy(xpath="")
	WebElement balance;
	
	public String getBalance()
	{
		return balance.getText();
	}
}
