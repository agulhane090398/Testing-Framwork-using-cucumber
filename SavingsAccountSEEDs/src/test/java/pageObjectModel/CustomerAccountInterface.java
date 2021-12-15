package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerAccountInterface {
	
	WebDriver driver;
	
	//C
	public CustomerAccountInterface(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//body/form[1]/input[1]")
	WebElement logout;
	
	public void clickLogout()
	{
		logout.click();
	}
	
	@FindBy(xpath="//a")
	WebElement profile;
	
	public void clickProfile()
	{
		profile.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'Account')]")
	WebElement Account;
	
	public WebElement moveToAccount()
	{
		return Account;
	}
	public void clickAccount()
	{
		Account.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'Transaction')]")
	WebElement Transaction;
	
	public WebElement moveToTransaction()
	{
		return Transaction;
	}
	public void clickTransaction()
	{
		Transaction.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'A/C Opening')]")
	WebElement AccOperning;

	public WebElement moveToAccOperning()
	{
		return AccOperning;
	}
	public void clickAccOperning()
	{
		AccOperning.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'Balance Enquiry')]")
	WebElement balanceEnquiry;

	public WebElement moveTobalanceEnquiry()
	{
		return balanceEnquiry;
	}
	public void clickbalanceEnquiry()
	{
		balanceEnquiry.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'Mini Statement')]")
	WebElement miniStatement;

	public WebElement moveTominiStatement()
	{
		return miniStatement;
	}
	public void clickminiStatement()
	{
		miniStatement.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'Statements')]")
	WebElement statement;

	public WebElement moveTostatement()
	{
		return statement;
	}
	public void clickstatement()
	{
		statement.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'Deposit')]")
	WebElement Deposit;

	public WebElement moveToDeposit()
	{
		return Deposit;
	}
	public void clickDeposit()
	{
		Deposit.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'Withdraw')]")
	WebElement WithDraw;

	public WebElement moveToWithDraw()
	{
		return WithDraw;
	}
	public void clickWithDraw()
	{
		WithDraw.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'Transfer')]")
	WebElement Transfer;

	public WebElement moveToTransfer()
	{
		return Transfer;
	}
	public void clickTransfer()
	{
		Transfer.click();
	}
	
}
