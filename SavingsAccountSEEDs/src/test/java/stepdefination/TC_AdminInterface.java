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
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjectModel.AdminInterface;
import pageObjectModel.AdminLoginInterface;
import pageObjectModel.SavingsAccount;

@SuppressWarnings("deprecation")
public class TC_AdminInterface {

	public WebDriver driver;
	public AdminLoginInterface ai;
	public AdminInterface a;
	public SavingsAccount sa;
	WebDriverWait myWait;
	
	

	@Given("user is on Savings Account interface {string}")
	public void user_is_on_Savings_Account_interface(String url) {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		ai = new AdminLoginInterface(driver);
		sa = new SavingsAccount(driver);
	}

	@When("user click on Admin link")
	public void user_click_on_Admin_link() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		sa.openAdmin();
		myWait = new WebDriverWait(driver, 5);
		myWait.until(ExpectedConditions.alertIsPresent()).accept();
	}

	@Then("check Admin interface is opened")
	public void check_Admin_interface_is_opened() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("Admin" , driver.findElement(By.xpath("//h3/i")).getText());
//		driver.navigate().back();
//		driver.close();
	}

	@When("User enter {string} and {string}")
	public void user_enter_and(String username, String password) {
		// Write code here that turns the phrase above into concrete actions

		ai.enterCredentials(username, password);
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		ai.clickOnLogin();
	}

	@Then("user verify the {string} in step")
	public void user_verify_the_in_step(String heading) {
		// Write code here that turns the phrase above into concrete actions
		try{
			myWait.until(ExpectedConditions.alertIsPresent()).accept();
			Assert.assertEquals(heading, driver.findElement(By.xpath("//h1")).getText());
	
		}
		catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
//			driver.close();
		}
	}

	@Then("user verify by checking heading as {string}")
	public void user_verify_by_checking_heading_as(String heading) {
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

	@When("user click on logout button")
	public void user_click_on_logout_button() {
	    // Write code here that turns the phrase above into concrete actions
		a=new AdminInterface(driver);
		a.clickLogout();
	}


	@When("user click on forgot userId")
	public void user_click_on_forgot_userId() {
		// Write code here that turns the phrase above into concrete actions
		ai.clickOnForgotId();
	}

	@Then("user verify that count of windowhandler is {int}")
	public void user_verify_that_count_of_windowhandler_is(Integer noOfWindows) {
		// Write code here that turns the phrase above into concrete actions
		// Assert.assertEquals(noOfWindows+"", driver.getWindowHandles().size()+"");
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
//			driver.quit();
		}
	}

	@When("user click on forgot password")
	public void user_click_on_forgot_password() {
		// Write code here that turns the phrase above into concrete actions
		ai.clickOnForgotpwd();
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
