package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
public class TC_CustomerAccountInterface {

	public WebDriver driver;
	public CustomerLoginInterface cli;
	public CustomerAccountInterface cai;
	public SavingsAccount sa;
	WebDriverWait myWait;

	@Given("C-user is on Savings Account interface {string}")
	public void c_user_is_on_Savings_Account_interface(String url) {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		cli = new CustomerLoginInterface(driver);
		sa = new SavingsAccount(driver);
	}

	@When("user click on Customer link")
	public void user_click_on_Customer_link() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		sa.openCustomer();
		Thread.sleep(5000);
		myWait = new WebDriverWait(driver, 5);
//	myWait.until(ExpectedConditions.alertIsPresent()).accept();
	}

	@Then("check Customer interface is opened")
	public void check_Customer_interface_is_opened() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("Customer", driver.findElement(By.xpath("//body/div[1]/div[1]/h3[1]")).getText());
	}

	@When("C-User enter {string} and {string}")
	public void c_User_enter_and(String username, String password) {
		// Write code here that turns the phrase above into concrete actions
		cli.enterCredentials(username, password);
	}

	@When("C-User clicks on login button")
	public void c_User_clicks_on_login_button() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		cli.clickOnLogin();
//	Thread.sleep(5000);
	}

	@Then("C-User verify the {string} in step")
	public void c_User_verify_the_in_step(String heading) {
		// Write code here that turns the phrase above into concrete actions
		try {
			myWait.until(ExpectedConditions.alertIsPresent()).accept();
			Assert.assertEquals(heading, driver.findElement(By.xpath("//h1")).getText());
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
//			driver.close();
		}
	}

	@When("C-User enters {string} and {string}")
	public void c_User_enters_and(String username, String password) {
		// Write code here that turns the phrase above into concrete actions
		cli.enterCredentials(username, password);
	}

	@Then("C-User verify by checking heading as {string}")
	public void c_User_verify_by_checking_heading_as(String heading) {
		// Write code here that turns the phrase above into concrete actions
		try {
			myWait.until(ExpectedConditions.alertIsPresent()).accept();
			// driver.switchTo().alert().accept();
			Assert.assertEquals(heading, driver.findElement(By.xpath("//h1")).getText());
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
//			driver.close();
		}
	}

	@When("C-User click on forgot userId")
	public void c_User_click_on_forgot_userId() {
		// Write code here that turns the phrase above into concrete actions
		cli.clickOnForgotId();
	}

	@Then("C-User verify that count of windowhandler is {int}")
	public void c_User_verify_that_count_of_windowhandler_is(Integer noOfWindows) {
		// Write code here that turns the phrase above into concrete actions
		int win = driver.getWindowHandles().size();
		System.out.println(win);
		try {
			if (win == noOfWindows) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
//			driver.close();
		}
	}

	@When("C-User click on forgot password")
	public void c_User_click_on_forgot_password() {
		// Write code here that turns the phrase above into concrete actions
		cli.clickOnForgotpwd();
	}

	@When("C-User click on logout button")
	public void c_User_click_on_logout_button() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
//	myWait.until(ExpectedConditions.alertIsPresent()).accept();
//	Thread.sleep(5000);
		cai = new CustomerAccountInterface(driver);
		cai.clickLogout();
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
