package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BranchListInterface {

	//variables
	WebDriver driver;

	//C
	public BranchListInterface(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//WE
	@FindBy(xpath="//*[@onclick='addBranch()']")
	WebElement addButton;
	
	@FindBy(xpath="//*[@onclick='editBranch()']")
	WebElement removeButton;
	
	@FindBy(xpath="//tbody/tr[5]/td[16]/input[1]")
	WebElement editButton1;

	@FindBy(xpath="//tbody/tr[6]/td[16]/input[1]")
	WebElement editButton2;
	
	@FindBy(linkText="Home")
	WebElement homeButton;
	
	//M
	public void addBranch()
	{
		addButton.click();
	}
	
	public void removeBranch()
	{
		removeButton.click();;
	}
	
	public void editBranch1()
	{
		editButton1.click();
	}

	public void editBranch2()
	{
		editButton2.click();
	}
	
	public void clickHome()
	{
		homeButton.click();
	}
}
