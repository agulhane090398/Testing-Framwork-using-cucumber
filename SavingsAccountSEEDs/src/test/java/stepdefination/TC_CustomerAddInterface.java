package stepdefination;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjectModel.AdminInterface;
import pageObjectModel.AdminLoginInterface;
import pageObjectModel.CustomerAddInterface;
import pageObjectModel.SavingsAccount;
import java.util.Map;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.*;

@SuppressWarnings("deprecation")
public class TC_CustomerAddInterface {

	public WebDriver driver;
	Actions action;
	public AdminLoginInterface ai;
	public AdminInterface a;
	public SavingsAccount sa;
	Map<String, String> data;
	Alert alert;
	public CustomerAddInterface cai;
	WebDriverWait myWait;

	@Given("User should be on Savings-Account Interface {string}")
	public void user_should_be_on_Savings_Account_Interface(String url) {
		// Write code here that turns the phrase caiove into concrete actions
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		ai = new AdminLoginInterface(driver);
		sa = new SavingsAccount(driver);
	}

	@Given("Clicks on Admin Link")
	public void clicks_on_Admin_Link() throws InterruptedException {
		// Write code here that turns the phrase caiove into concrete actions
		sa.openAdmin();
		myWait = new WebDriverWait(driver, 5);
		myWait.until(ExpectedConditions.alertIsPresent()).accept();
	}

	@When("User Enters valid credentials {string} and {string}")
	public void user_Enters_valid_credentials_and(String id, String pwd) {
		// Write code here that turns the phrase caiove into concrete actions
		ai = new AdminLoginInterface(driver);
		ai.enterCredentials(id, pwd);
	}

	@Then("Click on login button present on it")
	public void click_on_login_button_present_on_it() {
		// Write code here that turns the phrase caiove into concrete actions
		ai.clickOnLogin();
		a = new AdminInterface(driver);
	}

	@When("User moves mouse over Setup Menu")
	public void user_moves_mouse_over_Setup_Menu() {
		// Write code here that turns the phrase caiove into concrete actions
		action = new Actions(driver);
		action.moveToElement(a.moveToSetup()).perform();
	}

	@When("Click on Customer Sub-menu")
	public void click_on_Customer_Sub_menu() {
		// Write code here that turns the phrase caiove into concrete actions
		action.moveToElement(a.moveToCustomer()).perform();
		action.click().perform();
	}

	@When("User Enters the following data")
	public void user_Enters_the_following_data(DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		data = dataTable.asMap(String.class, String.class);
		cai = new CustomerAddInterface(driver);
		cai.selectCustomerType(data.get("customer_type"));
		cai.radioTitle(data.get("Title"));
		cai.enterFName(data.get("first_name"));
		cai.enterMName(data.get("middle_name"));
		cai.enterLName(data.get("last_name"));
		cai.enterMail(data.get("email_id"));
		cai.checkGender(data.get("gender"));
		cai.enterAddr1(data.get("address_line1"));
		cai.enterAddr2(data.get("address_line2"));
		cai.enterAddr3(data.get("address_line3"));
		cai.enterPin(data.get("pin_code"));
		cai.enterCity(data.get("city"));
		cai.enterState(data.get("state"));
		cai.enterCountry(data.get("country"));
		cai.enterNationality(data.get("nationality"));
		cai.enterPan(data.get("pan"));
		cai.enterAdhar(data.get("aadhar_no"));
		cai.checkMaritualSta(data.get("marital_status"));
		cai.enterDOB(data.get("dob"));
		cai.enterMobile(data.get("phone_no"));
		cai.enterPassword(data.get("password"));
		cai.enterUserName(data.get("username"));

	}

	@Then("Verify mgs Contains {string}")
	public void verify_mgs_Contains(String Mgs) {
		// Write code here that turns the phrase above into concrete actions

		try {
			alert = driver.switchTo().alert();
			Thread.sleep(5000);
			System.out.println("verify_mgs_Contains(String Mgs)@@@@@@@@@");
			if (alert.getText().contains(Mgs)) {
				Assert.assertTrue(true);
			} else {
				myWait.until(ExpectedConditions.alertIsPresent()).accept();
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
//			driver.switchTo().alert().accept();
//			driver.quit();
		}
	}

	@When("Clicks on reset buttom")
	public void clicks_on_reset_buttom() {
		// Write code here that turns the phrase above into concrete actions
		cai = new CustomerAddInterface(driver);
		cai.clickReset();
	}

	@Then("Verify textfeilds are cleared")
	public void verify_textfeilds_are_cleared() {
		// Write code here that turns the phrase above into concrete actions
		String act_pan = cai.getPan();
		System.out.println(act_pan);
		try {
			if (act_pan.equals("")) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
//			driver.quit();
		}
	}

	@When("Clicks on Submit buttom")
	public void clicks_on_Submit_buttom() {
		// Write code here that turns the phrase above into concrete actions
		cai.clickSubmit();
	}

	@Then("assert fails")
	public void assert_fails() {
		// Write code here that turns the phrase above into concrete actions
		try {
			System.out.println("Unimplemented Steps");
			Assert.assertTrue(false);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
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
