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
import pageObjectModel.BalanceEnquiry;
import pageObjectModel.CustomerAccountInterface;
import pageObjectModel.CustomerLoginInterface;
import pageObjectModel.SavingsAccount;

@SuppressWarnings("deprecation")
public class TC_BalanceEnquiry {

	public WebDriver driver;
	public CustomerLoginInterface cli;
	public CustomerAccountInterface cai;
	public SavingsAccount sa;
	public BalanceEnquiry be;
	Actions action;
	Map<String, String> map;
	WebDriverWait myWait;
	Wait<WebDriver> wait;

	@Given("c-user is On Savings-Account Interface {string}")
	public void c_user_is_On_Savings_Account_Interface(String url) {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		cli = new CustomerLoginInterface(driver);
		sa = new SavingsAccount(driver);
	}

	@Given("c-user c-user clicks On Customer Link")
	public void c_user_c_user_clicks_On_Customer_Link() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		sa.openCustomer();
		Thread.sleep(5000);
		myWait = new WebDriverWait(driver, 5);
	}

	@When("c-user enters Valid Credential {string} and {string}")
	public void c_user_enters_Valid_Credential_and(String username, String pwd) {
		// Write code here that turns the phrase above into concrete actions
		cli.enterCredentials(username, pwd);
	}

	@Then("c-user click On login buttons")
	public void c_user_click_On_login_buttons() {
		// Write code here that turns the phrase above into concrete actions
		cli.clickOnLogin();
		cai = new CustomerAccountInterface(driver);
	}

	@When("c-user moves mouse over Account")
	public void c_user_moves_mouse_over_Account() {
		// Write code here that turns the phrase above into concrete actions
		action = new Actions(driver);
		action.moveToElement(cai.moveToAccount()).perform();
	}

	@When("c-user click On Balance Enquiry Sub-Menu")
	public void c_user_click_On_Balance_Enquiry_Sub_Menu() {
		// Write code here that turns the phrase above into concrete actions
		cai.clickbalanceEnquiry();
		be = new BalanceEnquiry(driver);
	}

	@Then("c-user Verify Title as {string}")
	public void c_user_Verify_Title_as(String title) {
		// Write code here that turns the phrase above into concrete actions
		try {
			if (title.equalsIgnoreCase(driver.getTitle()))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		} finally {
//			driver.close();
		}
	}

	@When("C-user reads numerical value displayed on screen and database")
	public void c_user_reads_numerical_value_displayed_on_screen_and_database() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Database JDBC connection steps-->read data with global variable ad validate in next step");
	}

	@Then("C-user validate the Assert.assert")
	public void c_user_validate_the_assert() {
		// Write code here that turns the phrase above into concrete actions
		try {
			Assert.assertTrue(false);
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
