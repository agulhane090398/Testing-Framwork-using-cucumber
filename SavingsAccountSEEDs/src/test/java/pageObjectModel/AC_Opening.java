package pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import stepdefination.Hooks;

public class AC_Opening {

	WebDriver driver;

	// C
	public AC_Opening(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// WE & M
	@FindBy(xpath = "//tbody/tr[3]/td[2]/select[1]")
	WebElement bank_id;

	public void selectBankId(String bank) {
		bank_id.click();
		Select s = new Select(bank_id);
		List<WebElement> options = s.getOptions();
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(bank)) {
				option.click();
				break;
			}
		}
	}

	@FindBy(xpath = "//tbody/tr[3]/td[4]/select[1]")
	WebElement branch_id;

	public void selectBranchId(String bank) {
		Select s = new Select(branch_id);
		List<WebElement> options = s.getOptions();
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(bank)) {
				option.click();
				break;
			}
		}
	}

	@FindBy(xpath = "//tbody/tr[4]/td[2]/select[1]")
	WebElement account_type;

	public void selectAccountType(String bank) {
		Select s = new Select(account_type);
		List<WebElement> options = s.getOptions();
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(bank)) {
				option.click();
				break;
			}
		}
	}

	@FindBy(xpath = "//input[@id='account_no']")
	WebElement account_no;

	public void enterAccountNo(String bank) {
		account_no.clear();
		account_no.sendKeys(bank);
	}

	@FindBy(xpath = "//tbody/tr[5]/td[2]/select[1]")
	WebElement account_status;

	public void selectAccountStatus(String bank) {
		Select s = new Select(account_status);
		List<WebElement> options = s.getOptions();
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(bank)) {
				option.click();
				break;
			}
		}
	}

	@FindBy(xpath = "//tbody/tr[5]/td[4]/select[1]")
	WebElement operation;

	public void selectOperation(String bank) {
		Select s = new Select(operation);
		List<WebElement> options = s.getOptions();
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(bank)) {
				option.click();
				break;
			}
		}
	}

	@FindBy(xpath = "//tbody/tr[6]/td[4]/input[1]")
	WebElement balance;

	public void enterBalance(String bank) {
		balance.clear();
		balance.sendKeys(bank);
	}

	@FindBy(xpath = "//tbody/tr[7]/td[2]/input[1]")
	WebElement debit_card_no;

	public void enterDebitCardNo(String bank) {
		debit_card_no.clear();
		debit_card_no.sendKeys(bank);
	}

	@FindBy(xpath = "//tbody/tr[7]/td[4]/input[1]")
	WebElement nomination;

	public void enterNomination(String bank) {
		nomination.clear();
		nomination.sendKeys(bank);
	}

	@FindBy(xpath = "//tbody/tr[8]/td[2]/input[1]")
	WebElement cosigner;

	public void enterCosigner(String bank) {
		cosigner.clear();
		cosigner.sendKeys(bank);
	}

	@FindBy(xpath = "//tbody/tr[9]/th[1]/input[1]")
	WebElement submit;

	public void clickSubmit() {
		submit.click();
	}

	@FindBy(xpath = "//tbody/tr[9]/th[1]/input[2]")
	WebElement Reset;

	public void clickReset() {
		Reset.click();
	}

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement home;

	public void clickHome() {
		home.click();
	}

	@FindBy(xpath = "//*[contains(text(),'successfully')]")
	WebElement bodtContext;

	public WebElement getBodyMgs() {
		return bodtContext;
	}
}
