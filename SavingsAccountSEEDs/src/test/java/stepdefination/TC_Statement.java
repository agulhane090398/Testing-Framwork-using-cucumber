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
import pageObjectModel.Statement;
import pageObjectModel.SavingsAccount;

@SuppressWarnings("deprecation")
public class TC_Statement {

	public WebDriver driver;
	public CustomerLoginInterface cli;
	public CustomerAccountInterface cai;
	public SavingsAccount sa;
	public Statement s;
	Actions action;
	Map<String, String> map;
	WebDriverWait myWait;
	Wait<WebDriver> wait;

	@Given("c-user is  on  Saving Account Interface {string}")
	public void c_user_is_on_saving_account_interface(String url) {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		cli = new CustomerLoginInterface(driver);
		sa = new SavingsAccount(driver);
	}

	@Given("c-user   clicks  on Customer Link")
	public void c_user_clicks_on_customer_link() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		sa.openCustomer();
		Thread.sleep(5000);
		myWait = new WebDriverWait(driver, 5);
	}

	@When("c-user  Enters  valid Credential {string} and {string}")
	public void c_user_enters_valid_credential_and(String username, String pwd) {
		// Write code here that turns the phrase above into concrete actions
		cli.enterCredentials(username, pwd);
	}

	@Then("c-user  Click  on login buttons")
	public void c_user_click_on_login_buttons() {
		// Write code here that turns the phrase above into concrete actions
		cli.clickOnLogin();
		cai = new CustomerAccountInterface(driver);
	}

	@When("c-user  moves   mouse Over Account")
	public void c_user_moves_mouse_over_account() {
		// Write code here that turns the phrase above into concrete actions
		action = new Actions(driver);
		action.moveToElement(cai.moveToAccount()).perform();
	}

	@When("c-user  click On Statement Sub-Menu")
	public void c_user_click_on_statement_sub_menu() {
		// Write code here that turns the phrase above into concrete actions
		cai.clickstatement();
		s = new Statement(driver);
	}

	@When("C-user enter account details for {string}")
	public void c_user_enter_account_details_for(String type) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		s.enterAccountNo("1");
		Thread.sleep(3000);
		s.enterAmount("1");
		Thread.sleep(3000);
		s.enterFromDate("07-10-2021");
		Thread.sleep(3000);
		s.enterToDate("07-11-2021");
		Thread.sleep(3000);
		s.selectTransactioType(type);
		Thread.sleep(3000);
	}

	@When("click on generate statement button")
	public void click_on_generate_statement_button() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		s.clickGenerateButton();
		Thread.sleep(3000);
	}

	@Then("C-user verify all data not for {string}")
	public void c_user_verify_all_data_not_for(String type) {
		// Write code here that turns the phrase above into concrete actions
		if(driver.getPageSource().contains(type))
		{
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
	}

	@Then("c-user  verify Title  {string}")
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
		finally {
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
