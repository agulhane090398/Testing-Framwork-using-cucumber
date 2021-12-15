package stepdefination;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjectModel.CustomerAccountInterface;
import pageObjectModel.CustomerLoginInterface;
import pageObjectModel.SavingsAccount;

@SuppressWarnings("deprecation")
public class TC_CustomerLoginInterface {

	public WebDriver driver;
	public CustomerLoginInterface cli;
	public CustomerAccountInterface cai;
	public SavingsAccount sa;
	Actions action;
	WebDriverWait myWait;

	@Given("c-user is on Savings-Account interface {string}")
	public void c_user_is_on_Savings_Account_interface(String url) {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		cli = new CustomerLoginInterface(driver);
		sa = new SavingsAccount(driver);

	}

	@Given("c-user c-user clicks on Customer link")
	public void c_user_c_user_clicks_on_Customer_link() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		sa.openCustomer();
		Thread.sleep(5000);
		myWait = new WebDriverWait(driver, 5);
	}

	@When("c-user enters valid credential {string} and {string}")
	public void c_user_enters_valid_credential_and(String uname, String pwd) {
		// Write code here that turns the phrase above into concrete actions
		cli.enterCredentials(uname, pwd);
	}

	@Then("c-user click on login button")
	public void c_user_click_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		cli.clickOnLogin();
		cai = new CustomerAccountInterface(driver);
	}

	@When("c-user c-user clicks on customer profile link")
	public void c_user_c_user_clicks_on_customer_profile_link() {
		// Write code here that turns the phrase above into concrete actions
		cai.clickProfile();
	}

	@Then("c-user verify title as {string}")
	public void c_user_verify_title_as(String title) {
		// Write code here that turns the phrase above into concrete actions
		try {
			Assert.assertEquals(title, driver.getTitle());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
//			driver.close();
		}
	}

	@When("c-user mouse over Account")
	public void c_user_mouse_over_Account() {
		// Write code here that turns the phrase above into concrete actions
		action=new Actions(driver);
		action.moveToElement(cai.moveToAccount()).perform();
	}

	@When("c-user click on A\\/C Opening Sub-Menu")
	public void c_user_click_on_A_C_Opening_Sub_Menu() {
		// Write code here that turns the phrase above into concrete actions
		cai.clickAccOperning();
	}

	@When("c-user click on Balanace Enquiry Sub-Menu")
	public void c_user_click_on_Balanace_Enquiry_Sub_Menu() {
		// Write code here that turns the phrase above into concrete actions
		cai.clickbalanceEnquiry();
	}

	@When("c-user click on Mini-Statement Sub-Menu")
	public void c_user_click_on_Mini_Statement_Sub_Menu() {
		// Write code here that turns the phrase above into concrete actions
		cai.clickminiStatement();
	}

	@When("c-user click on Statement Sub-Menu")
	public void c_user_click_on_Statement_Sub_Menu() {
		// Write code here that turns the phrase above into concrete actions
		cai.clickminiStatement();
		}

//	@Then("c-user verify title as {string}							#{string}")
//	public void c_user_verify_title_as(String string, String string2) {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}

	@When("c-user mouse over Transaction")
	public void c_user_mouse_over_Transaction() {
		// Write code here that turns the phrase above into concrete actions
		action=new Actions(driver);
		action.moveToElement(cai.moveToTransaction()).perform();
		}

	@When("c-user click on Deposit Sub-Menu")
	public void c_user_click_on_Deposit_Sub_Menu() {
		// Write code here that turns the phrase above into concrete actions
		cai.clickDeposit();
	}

	@When("c-user click on Withdraw Sub-Menu")
	public void c_user_click_on_Withdraw_Sub_Menu() {
		// Write code here that turns the phrase above into concrete actions
		cai.clickWithDraw();
}

	@When("c-user click on Transfer Sub-Menu")
	public void c_user_click_on_Transfer_Sub_Menu() {
		// Write code here that turns the phrase above into concrete actions
		cai.clickTransfer();
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
