package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Withdraw {

	WebDriver driver;
	public Withdraw(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//*[@name='account_id']")
	WebElement accout;
	
	public void selectAccount(String accNum) {
		// TODO Auto-generated method stub
		Select s=new Select(accout);
		s.selectByVisibleText(accNum);
	}
	
	@FindBy(xpath="//tbody/tr[3]/td[1]/input[1]")
	WebElement amtVal;
	public void enterAmount(Integer amt) {
		// TODO Auto-generated method stub
		amtVal.sendKeys(amt.toString());
	}
	
	public String getAmtFeild() {
		// TODO Auto-generated method stub
		return amtVal.getText();
	}

	@FindBy(xpath="//tbody/tr[4]/th[1]/input[2]")
	WebElement cancelBtn;
	public void clickCancelBtn() {
		// TODO Auto-generated method stub
		cancelBtn.click();
	}
	
	@FindBy(xpath="//tbody/tr[4]/th[1]/input[1]")
	WebElement confirmBtn;
	public void clickConfirmBtn() {
		// TODO Auto-generated method stub
		confirmBtn.click();
	}
	
}
