package stepdefination;

import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjectModel.CustomerAccountInterface;
import pageObjectModel.CustomerLoginInterface;
import pageObjectModel.Deposit;
import pageObjectModel.SavingsAccount;

@SuppressWarnings("deprecation")
public class TC_Deposit {

	public WebDriver driver;
	public CustomerLoginInterface cli;
	public CustomerAccountInterface cai;
	public SavingsAccount sa;
	public Deposit d;
	Actions action;
	Map<String, String> map;
	WebDriverWait myWait;
	Wait<WebDriver> wait;
//	public Hooks hooks;

	@Given("c-user is  on Saving Account Interface {string}")
	public void c_user_is_on_saving_account_interface(String url) {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		cli = new CustomerLoginInterface(driver);
		sa = new SavingsAccount(driver);
//		hooks=new Hooks(driver);
	}

	@Given("c-user   clicks on Customer  Link")
	public void c_user_clicks_on_customer_link() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		sa.openCustomer();
		Thread.sleep(5000);
		myWait = new WebDriverWait(driver, 5);
	}

	@When("c-user  Enters valid Credential  {string} and {string}")
	public void c_user_enters_valid_credential_and(String username, String pwd) {
		// Write code here that turns the phrase above into concrete actions
		cli.enterCredentials(username, pwd);
	}

	@Then("c-user  Click on login  buttons")
	public void c_user_click_on_login_buttons() {
		// Write code here that turns the phrase above into concrete actions
		cli.clickOnLogin();
		cai = new CustomerAccountInterface(driver);
	}

	@When("c-user  moves  mouse Over  Account")
	public void c_user_moves_mouse_over_account() {
		// Write code here that turns the phrase above into concrete actions
		action = new Actions(driver);
		action.moveToElement(cai.moveToTransaction()).perform();
	}

	@When("c-user  click On Deposit  Sub-Menu")
	public void c_user_click_on_deposit_sub_menu() {
		// Write code here that turns the phrase above into concrete actions
		cai.clickDeposit();
		d = new Deposit(driver);
	}

	@Then("c-user  verify   Title  {string}")
	public void c_user_verify_title(String title) {
		// Write code here that turns the phrase above into concrete actions
		try {
			if (title.equalsIgnoreCase(driver.getTitle()))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
//			driver.close();
		}
	}

	@When("C-user provideds account num as {string} and amount as {int}")
	public void c_user_provideds_account_num_as_and_amount_as(String accNum, Integer amt) {
		// Write code here that turns the phrase above into concrete actions
		d.selectAccount(accNum);
		d.enterAmount(amt);
	}

	@When("C-user provideds account num as {int}-SBI-SBI Wardha-Saving and amount as {int}")
	public void c_user_provideds_account_num_as_sbi_sbi_wardha_saving_and_amount_as(Integer acc, Integer amt)
			throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		d.selectAccount(acc.toString() + "-SBI-SBI Wardha-Saving");
		Thread.sleep(3000);
		d.enterAmount(amt);
		d.clickConfirmBtn();
	}

	@Then("C-user verify the Successful in step")
	public void c_user_verify_the_successful_in_step() {
		// Write code here that turns the phrase above into concrete actions
		try {
			if (driver.getPageSource().contains("Successful")) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		} finally {
//			driver.close();
		}
	}

	@When("click on cancel button")
	public void click_on_cancel_button() {
		// Write code here that turns the phrase above into concrete actions
		d.clickCancelBtn();
	}

	@Then("C-user verify the amount field as empty")
	public void c_user_verify_the_amount_field_as_empty() {
		// Write code here that turns the phrase above into concrete actions
		try {
			if (d.getAmtFeild().equals("")) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		} finally {
//			driver.close();
		}
	}

	@After
	 public void addScreenshot(Scenario scenario) {

		// validate if scenario has failed
		if (driver!=null && scenario.isFailed()) {
			PageFactory.initElements(driver, this);
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");
			driver.quit();
		}
		if(!scenario.isFailed() && driver!=null)
		{
			driver.quit();
		}

	}
}
