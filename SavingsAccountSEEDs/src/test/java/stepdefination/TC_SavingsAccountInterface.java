package stepdefination;

import java.util.concurrent.TimeUnit;
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
import pageObjectModel.SavingsAccount;

@SuppressWarnings("deprecation")
public class TC_SavingsAccountInterface {
	public WebDriver driver;
	public SavingsAccount sa;
	WebDriverWait myWait;
	
	@Given("user is on Savings Account interface")
	public void user_is_on_Savings_Account_interface() {
		 // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//lib/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:8080/SavingsAccount/");
		sa=new SavingsAccount(driver);
	}

	@When("user click on Admin")
	public void user_click_on_Admin() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		sa.openAdmin();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		myWait = new WebDriverWait(driver, 5);
		myWait.until(ExpectedConditions.alertIsPresent()).accept();
	
	}

	@Then("Admin interface is opened")
	public void admin_interface_is_opened() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(driver.findElement(By.xpath("//h3/i")).getText(), "Admin");
//		driver.navigate().back();
//		driver.close();
	}

	@When("user click on Customer")
	public void user_click_on_Customer() {
	    // Write code here that turns the phrase above into concrete actions
		sa.openCustomer();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Then("Customer interface is opened")
	public void customer_interface_is_opened() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(driver.findElement(By.xpath("//i[text()='Customer']")).getText(), "Customer");
		driver.navigate().back();
//		driver.close();
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
