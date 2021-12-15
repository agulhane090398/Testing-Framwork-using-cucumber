package stepdefination;


import java.time.Duration;
import java.util.Map;
import io.cucumber.datatable.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pageObjectModel.AC_Opening;
import pageObjectModel.CustomerAccountInterface;
import pageObjectModel.CustomerLoginInterface;
import pageObjectModel.SavingsAccount;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TC_AC_Opening {

	public WebDriver driver;
	public CustomerLoginInterface cli;
	public CustomerAccountInterface cai;
	public SavingsAccount sa;
	public AC_Opening ao;
	Actions action;
	Map<String, String> map;
	WebDriverWait myWait;
	Wait<WebDriver> wait;
	
	

	@Given("c-user is on Savings-Account Interface {string}")
	public void c_user_is_on_Savings_Account_Interface(String url) {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		cli = new CustomerLoginInterface(driver);
		sa = new SavingsAccount(driver);
		
	}

	@Given("c-user c-user clicks on Customer Link")
	public void c_user_c_user_clicks_on_Customer_Link() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		sa.openCustomer();
		Thread.sleep(5000);
		myWait = new WebDriverWait(driver, 5);
	}

	@When("c-user enters valid Credential {string} and {string}")
	public void c_user_enters_valid_Credential_and(String username, String pwd) {
		// Write code here that turns the phrase above into concrete actions
		cli.enterCredentials(username, pwd);
	}

	@Then("c-user click on login buttons")
	public void c_user_click_on_login_buttons() {
		// Write code here that turns the phrase above into concrete actions
		cli.clickOnLogin();
		cai = new CustomerAccountInterface(driver);
	}

	@When("c-user mouse Over Account")
	public void c_user_mouse_Over_Account() {
		// Write code here that turns the phrase above into concrete actions
		action = new Actions(driver);
		action.moveToElement(cai.moveToAccount()).perform();
	}

	@When("c-user click On A\\/C Opening Sub-Menu")
	public void c_user_click_On_A_C_Opening_Sub_Menu() {
		// Write code here that turns the phrase above into concrete actions
		cai.clickAccOperning();
		ao = new AC_Opening(driver);
	}

	@Then("c-user verify Title as {string}")
	public void c_user_verify_Title_as(String title) {
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

	@When("C-User enter the following data")
	public void c_User_enter_the_following_data(DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		// ao = new AC_Opening(driver);
		try {
			wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);

			map = dataTable.asMap(String.class, String.class);
			System.out.println(map.get("bank_id"));
			ao.selectBankId(map.get("bank_id").toString());
			System.out.println(map.get("branch_id").toString());
			ao.selectBranchId(map.get("branch_id").toString());
			System.out.println(map.get("account_type").toString());
			ao.selectAccountType(map.get("account_type").toString());
			System.out.println(map.get("account_status"));
			ao.selectAccountStatus(map.get("account_status").toString());
			System.out.println(map.get("operation"));
			ao.selectOperation(map.get("operation"));
			System.out.println(map.get("balance"));
			ao.enterBalance(map.get("balance"));
			System.out.println(map.get("debit_card_no"));
			ao.enterDebitCardNo(map.get("debit_card_no"));
			System.out.println(map.get("nomination"));
			ao.enterNomination(map.get("nomination"));
			System.out.println(map.get("cosigner"));
			ao.enterCosigner(map.get("cosigner"));
			System.out.println(map.get("account_no"));
			ao.enterAccountNo(map.get("account_no"));
//		wait.until(ExpectedConditions.alertIsPresent()).accept();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			// driver.close();
		}

	}

	@When("C-User clicks on Submit button")
	public void c_User_clicks_on_Submit_button() {
		// Write code here that turns the phrase above into concrete actions

		ao.clickSubmit();
	}

	@Then("C-User verify The contain of page")
	public void c_User_verify_The_contain_of_page() {
		// Write code here that turns the phrase above into concrete actions
		try {
			wait.until(ExpectedConditions.alertIsPresent()).accept();
			if (driver.getPageSource().contains(map.get("text_feild_Contains_mgs")))
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

	@When("user navigate to balance Enquiry")
	public void user_navigate_to_balance_Enquiry() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Not Implemented,wait for next build");
	}

	@Then("verify the balance")
	public void verify_the_balance() {
		// Write code here that turns the phrase above into concrete actions
		try{
			Assert.assertTrue(false);
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
