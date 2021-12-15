package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddBank {
	
	WebDriver driver;
	
	//C
	public AddBank(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//WE
	@FindBy(xpath="//tbody/tr[15]/th[1]/input[1]")
	WebElement submit;
	
	public void clickSubmit()
	{
		submit.click();
	}

	@FindBy(xpath="//tbody/tr[15]/th[1]/input[2]")
	WebElement clear;

	public void clickClear()
	{
		clear.click();
	}
	
	@FindBy(xpath="//tbody/tr[2]/td[1]/input[1]")
	WebElement bankName;

	public void enterBankname(String name)
	{
		bankName.clear();
		bankName.sendKeys(name);
	}

	@FindBy(xpath="//tbody/tr[3]/td[1]/input[1]")
	WebElement addr1;
	
	public void enterAddr1(String name)
	{
		addr1.clear();
		addr1.sendKeys(name);
	}

	@FindBy(xpath="//tbody/tr[4]/td[1]/input[1]")
	WebElement addr2;
	
	public void enterAddr2(String name)
	{
		addr2.clear();
		addr2.sendKeys(name);
	}

	@FindBy(xpath="//tbody/tr[5]/td[1]/input[1]")
	WebElement addr3;
	
	public void enterAddr3(String name)
	{
		addr3.clear();
		addr3.sendKeys(name);
	}

	@FindBy(xpath="//tbody/tr[6]/td[1]/input[1]")
	WebElement city;
	
	public void enterCity(String name)
	{
		city.clear();
		city.sendKeys(name);
	}

	@FindBy(xpath="//tbody/tr[7]/td[1]/input[1]")
	WebElement state;
	
	public void enterState(String name)
	{
		state.clear();
		state.sendKeys(name);
	}

	@FindBy(xpath="//tbody/tr[8]/td[1]/input[1]")
	WebElement country;
	
	public void enterCountry(String name)
	{
		country.clear();
		country.sendKeys(name);
	}

	@FindBy(xpath="//tbody/tr[9]/td[1]/input[1]")
	WebElement pinCode;
	
	public void enterPin(String name)
	{
		pinCode.clear();
		pinCode.sendKeys(name);
	}
	
	@FindBy(xpath="//tbody/tr[11]/td[1]/input[1]")
	WebElement email;
	public void enterEmail(String name)
	{
		email.clear();
		email.sendKeys(name);
	}

	@FindBy(xpath="//tbody/tr[10]/td[1]/input[1]")
	WebElement mob;
	
	public void enterMob(String name)
	{
		mob.clear();
		mob.sendKeys(name);
	}

	@FindBy(xpath="//tbody/tr[12]/td[1]/input[1]")
	WebElement ifsc;
	
	public void enterIFSC(String name)
	{
		ifsc.clear();
		ifsc.sendKeys(name);
	}

	public String getIFSC()
	{
		return ifsc.getAttribute("value");
	}

	@FindBy(xpath="//tbody/tr[13]/td[1]/input[1]")
	WebElement mirc;
	
	public void enterMIRC(String name)
	{
		mirc.clear();
		mirc.sendKeys(name);
	}

	@FindBy(xpath="//tbody/tr[14]/td[1]/textarea")
	WebElement HQAddr;
	
	public void enterHQAddr(String name)
	{
		HQAddr.clear();
		HQAddr.sendKeys(name);
	}

}
