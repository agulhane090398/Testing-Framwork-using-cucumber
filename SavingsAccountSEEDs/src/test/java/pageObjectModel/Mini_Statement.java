package pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mini_Statement {

	WebDriver driver;

	public Mini_Statement(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//tbody/tr/th[5]")
	WebElement balance;
	
	public boolean balanceIsPresent()
	{
		return balance.isDisplayed();
	}

	@FindBy(xpath="//tbody/tr")
	List<WebElement> noOfRows;
	
	public int noOfRow()
	{
		return noOfRows.size();
	}
}
