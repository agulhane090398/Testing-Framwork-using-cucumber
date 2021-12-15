package pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Transfer_Funds {
	
	WebDriver driver;
	
	public Transfer_Funds(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//WE&M
	@FindBy(xpath="//tbody/tr[2]/td[1]/select[1]")
	WebElement fromAcc;
	
	public void selectFromAcc(String s)
	{
		Select sFromAcc=new Select(fromAcc);
		List<WebElement> options = sFromAcc.getOptions();
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(s)) {
				option.click();
				break;
			}
		}
	}
	
	@FindBy(xpath="//tbody/tr[3]/td[1]/input[1]")
	WebElement toAcc;
	
	public void enterToAcc(String s)
	{
		toAcc.clear();
		toAcc.sendKeys(s+"");
	}

	@FindBy(xpath="//tbody/tr[4]/td[1]/input[1]")
	WebElement reConfirmAcc;
	
	public void enterReconfirmAcc(String s)
	{
		reConfirmAcc.clear();
		reConfirmAcc.sendKeys(s+"");
	}

	@FindBy(xpath="//tbody/tr[5]/td[1]/input[1]")
	WebElement amt;
	
	public void enterAmt(String s)
	{
		amt.clear();
		amt.sendKeys(s+"");
	}

	@FindBy(xpath="//tbody/tr[6]/td[1]/input[1]")
	WebElement narration;
	
	public void enterNarration(String s)
	{
		narration.clear();
		narration.sendKeys(s+"");
	}

	@FindBy(xpath="//tbody/tr[7]/td[1]/input[1]")
	WebElement ifsc;
	
	public void enterIFSC(String s)
	{
		ifsc.clear();
		ifsc.sendKeys(s+"");
	}
	public String getIFSCfield()
	{
		return ifsc.getText();
	}

	@FindBy(xpath="//tbody/tr[8]/td[1]/input[1]")
	WebElement accHolderName;
	
	public void enterAccHolderName(String s)
	{
		accHolderName.clear();
		accHolderName.sendKeys(s+"");
	}

	@FindBy(xpath="//tbody/tr[9]/th[1]/input[1]")
	WebElement confirmBtn;
	
	public void clickConfirm()
	{
		confirmBtn.click();
	}

	@FindBy(xpath="//tbody/tr[9]/th[1]/input[2]")
	WebElement clearBtn;
	
	public void clickClear()
	{
		clearBtn.click();
	}
	
	@FindBy(xpath="//h1[contains(text(),'Transfer\rSuccessful')]")
	WebElement successMgs;
	
	public String getSuccessMgs()
	{
		return successMgs.getText();
	}
	
	@FindBy(xpath="//tbody/tr[11]/th[1]/input[1]")
	WebElement closeBtn;
	public void clickClose() {
		// TODO Auto-generated method stub
		closeBtn.click();
	}
	
	
}
