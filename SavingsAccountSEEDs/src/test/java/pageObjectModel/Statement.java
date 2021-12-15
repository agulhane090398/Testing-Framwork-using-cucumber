package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Statement {
	WebDriver driver;

	public Statement(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//tbody/tr[1]/td[2]/input[1]")
	WebElement accountNo;
	
	public void enterAccountNo(String num)
	{
		accountNo.sendKeys(num);
	}

	@FindBy(xpath="//tbody/tr[2]/td[2]/input[1]")
	WebElement amount;
	
	public void enterAmount(String num)
	{
		amount.sendKeys(num);
	}

	@FindBy(xpath="//tbody/tr[3]/td[2]/input[1]")
	WebElement fromDate;
	
	public void enterFromDate(String num)
	{
		fromDate.sendKeys(num);
	}

	@FindBy(xpath="//tbody/tr[4]/td[2]/input[1]")
	WebElement toDate;
	
	public void enterToDate(String num)
	{
		toDate.sendKeys(num);
	}

	@FindBy(xpath="//tbody/tr[5]/td[2]/select[1]")
	WebElement transactioType;
	
	public void selectTransactioType(String num)
	{
		Select s=new Select(transactioType);
		s.selectByVisibleText(num);
	}

	@FindBy(xpath="//tbody/tr[6]/td[2]/input[1]")
	WebElement generateBtn;
	
	public void clickGenerateButton()
	{
		generateBtn.click();;
	}

	public String getPageSource() {
		// TODO Auto-generated method stub
		return driver.getPageSource();
	}
	
	
}
