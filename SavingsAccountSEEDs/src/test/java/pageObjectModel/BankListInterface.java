package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankListInterface {
	
	//variables
	WebDriver driver;

	//C
	public BankListInterface(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//WE
	@FindBy(xpath="//*[@onclick='addBank()']")
	WebElement addButton;
	
	@FindBy(xpath="//*[@onclick='editBank()']")
	WebElement removeButton;
	
	@FindBy(xpath="//tbody/tr[5]/td[15]/input[1]")
	WebElement editButton1;

	@FindBy(xpath="//tbody/tr[6]/td[15]/input[1]")
	WebElement editButton2;
	
	@FindBy(linkText="Home")
	WebElement homeButton;
	
	//M
	public void addBank()
	{
		addButton.click();
	}
	
	public void removeBank()
	{
		removeButton.click();;
	}
	
	public void editBank1()
	{
		editButton1.click();
	}

	public void editBank2()
	{
		editButton2.click();
	}
	
	public void clickHome()
	{
		homeButton.click();
	}
}
