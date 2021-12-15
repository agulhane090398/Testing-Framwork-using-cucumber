package stepdefination;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjectModel.AdminInterface;
import pageObjectModel.AdminLoginInterface;
import pageObjectModel.SavingsAccount;

@SuppressWarnings("deprecation")
public class TC_AdminLoginInterface {

	public WebDriver driver;
	Actions action;
	public AdminLoginInterface ai;
	public AdminInterface a;
	public SavingsAccount sa;
	WebDriverWait myWait;

	@Given("user is on Savings-Account interface {string}")
	public void user_is_on_Savings_Account_interface(String url) {
		// Write code here that turns the phrase above into concrete actions

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		ai = new AdminLoginInterface(driver);
		sa = new SavingsAccount(driver);

	}

	@Given("user clicks on Admin link")
	public void user_clicks_on_Admin_link() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		sa.openAdmin();
		myWait = new WebDriverWait(driver, 5);
		myWait.until(ExpectedConditions.alertIsPresent()).accept();
	}

	@Then("click on login button")
	public void click_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		ai.clickOnLogin();
		a = new AdminInterface(driver);
	}

	@When("user enters valid credential {string} and {string}")
	public void user_enters_valid_credential_and(String id, String pwd) {
		// Write code here that turns the phrase above into concrete actions
		ai = new AdminLoginInterface(driver);
		ai.enterCredentials(id, pwd);
	}

	@When("user clicks on admin profile link")
	public void user_clicks_on_admin_profile_link() {
		// Write code here that turns the phrase above into concrete actions

		a.clickProfile();
	}

	@Then("user verify admin-profile")
	public void user_verify_admin_profile() {
		// Write code here that turns the phrase above into concrete actions
		try {
			if (driver.getTitle().equals("Customer Profile")) {
				Assert.assertTrue(true);
			} else {
				// Capture screenshot can be implemented here
				System.out.print("Test Fails");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
//			driver.close();
		}
	}

	@When("user mouse over Setup")
	public void user_mouse_over_Setup() {
		// Write code here that turns the phrase above into concrete actions
		action = new Actions(driver);
		action.moveToElement(a.moveToSetup()).perform();
	}

	@When("click on bank Sub-Menu")
	public void click_on_bank_Sub_Menu() {
		// Write code here that turns the phrase above into concrete actions
		action.moveToElement(a.moveToBank()).perform();
		action.click().perform();
	}

	@Then("user verify title as {string}")
	public void user_verify_title_as(String exp_title) {
		// Write code here that turns the phrase above into concrete actions
		try {
//			Thread.sleep(5000);
			String act_title = driver.getTitle();
//			System.out.println(act_title);
			if (exp_title.equals(act_title)) {
				Assert.assertTrue(true);
			} else {
				// Capture ss
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
//			driver.quit();
		}
	}

	@When("click on branch Sub-Menu")
	public void click_on_branch_Sub_Menu() {
		// Write code here that turns the phrase above into concrete actions
		action.moveToElement(a.moveToBranch()).perform();
		action.click().perform();
	}

	@When("click on customer Sub-Menu")
	public void click_on_customer_Sub_Menu() {
		// Write code here that turns the phrase above into concrete actions
		action.moveToElement(a.moveToCustomer()).perform();
		action.click().perform();
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
