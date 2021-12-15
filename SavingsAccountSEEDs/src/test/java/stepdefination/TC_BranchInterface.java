package stepdefination;

import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.datatable.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjectModel.AddBranch;
import pageObjectModel.AdminInterface;
import pageObjectModel.AdminLoginInterface;
import pageObjectModel.BranchListInterface;
import pageObjectModel.SavingsAccount;

@SuppressWarnings("deprecation")
public class TC_BranchInterface {

	public WebDriver driver;
	Actions action;
	public AdminLoginInterface ai;
	public AdminInterface a;
	public SavingsAccount sa;
	public BranchListInterface bi;
	public AddBranch ab;
	String mainWindows;
	Map<String, String> data;
	WebDriverWait myWait;

	@Given("User should be on Savings-Account interface {string}")
	public void user_should_be_on_Savings_Account_interface(String url) {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		ai = new AdminLoginInterface(driver);
		sa = new SavingsAccount(driver);
	}

	@Given("Clicks on Admin link")
	public void clicks_on_Admin_link() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		sa.openAdmin();
		myWait = new WebDriverWait(driver, 5);
		myWait.until(ExpectedConditions.alertIsPresent()).accept();
	}

	@When("User enters valid credentials {string} and {string}")
	public void user_enters_valid_credentials_and(String id, String pwd) {
		// Write code here that turns the phrase above into concrete actions
		ai = new AdminLoginInterface(driver);
		ai.enterCredentials(id, pwd);
	}

	@Then("Click on login button present")
	public void click_on_login_button_present() {
		// Write code here that turns the phrase above into concrete actions
		ai.clickOnLogin();
		a = new AdminInterface(driver);
	}

	@When("User moves mouse over Setup")
	public void user_moves_mouse_over_Setup() {
		// Write code here that turns the phrase above into concrete actions
		action = new Actions(driver);
		action.moveToElement(a.moveToSetup()).perform();
	}

	@When("Click on branch Sub-menu")
	public void click_on_branch_Sub_menu() {
		// Write code here that turns the phrase above into concrete actions
		action.moveToElement(a.moveToBranch()).perform();
		action.click().perform();
	}

	@Then("User verifys title as {string}")
	public void user_verifys_title_as(String exp_title) {
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
//			driver.close();
		}
	}

	@When("User clicks on add button")
	public void user_clicks_on_add_button() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		mainWindows = driver.getWindowHandle();
		System.out.println(mainWindows);
		bi = new BranchListInterface(driver);
		bi.addBranch();
		// System.out.println("user_clicks_on_add_button()");
		Thread.sleep(5000);
	}

	@Then("new Window is opened")
	public void new_Window_is_opened() {
		// Write code here that turns the phrase above into concrete actions
		Set<String> diffWindows = driver.getWindowHandles();
		for (String addBankWindow : diffWindows) {
			if (addBankWindow != mainWindows) {
				System.out.println("new_window_is_opened()");
				driver.switchTo().window(addBankWindow);
			}
		}
	}

	@When("User enters the following data")
	public void user_enters_the_following_data(DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		data = dataTable.asMap(String.class, String.class);
		ab = new AddBranch(driver);
		ab.selectBank(data.get("bank"));
		ab.enterBankname(data.get("branch_name"));
		ab.enterAddr1(data.get("address_1"));
		ab.enterAddr2(data.get("address_2"));
		ab.enterAddr3(data.get("address_3"));
		ab.enterCity(data.get("city"));
		ab.enterCountry(data.get("country"));
		ab.enterEmail(data.get("email"));
		ab.enterMob(data.get("phone_no"));
		ab.enterPin(data.get("pin_code"));
		ab.enterMIRC(data.get("MIRC_code"));
		ab.enterIFSC(data.get("IFSC_code"));
		ab.enterState(data.get("state"));
		ab.enterHQAddr(data.get("hqAdd"));

	}

	@When("Clicks on submit buttom")
	public void clicks_on_submit_buttom() {
		// Write code here that turns the phrase above into concrete actions
		ab.clickSubmit();
	}

	@Then("User validate the outcomes from the list of branch")
	public void user_validate_the_outcomes_from_the_list_of_branch() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[contains(text(),'ok')]")).click();
		driver.close();
		driver.switchTo().window(mainWindows);
		driver.navigate().refresh();
		try {
			if (driver.findElement(By.xpath("//*[contains(text(),'" + data.get("IFSC_code") + "')]")).isDisplayed()) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		} finally {
//			driver.close();
		}
	}

	@Then("Verify mgs contains {string}")
	public void verify_mgs_contains(String Mgs) {
		// Write code here that turns the phrase above into concrete actions
		try {
			if (driver.findElement(By.xpath("//body")).getText().contains(Mgs)) {
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

	@When("User clicks on edit button")
	public void user_clicks_on_edit_button() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		mainWindows = driver.getWindowHandle();
		System.out.println(mainWindows);
		bi = new BranchListInterface(driver);
		bi.editBranch1();
		// System.out.println("user_clicks_on_add_button()");
		Thread.sleep(5000);
	}

	@When("User enters ifsc code as {string}")
	public void user_enters_ifsc_code_as(String new_IFSC) {
		// Write code here that turns the phrase above into concrete actions
		Set<String> diffWindows = driver.getWindowHandles();
		for (String addBankWindow : diffWindows) {
			if (addBankWindow != mainWindows) {
				System.out.println("new_window_is_opened()");
				driver.switchTo().window(addBankWindow);
			}
		}
		ab = new AddBranch(driver);
		ab.enterIFSC(new_IFSC);

	}

	@When("User clicks on edit button	next to preciding entry")
	public void user_clicks_on_edit_button_next_to_preciding_entry() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		mainWindows = driver.getWindowHandle();
		System.out.println(mainWindows);
		bi = new BranchListInterface(driver);
		bi.editBranch2();
		// System.out.println("user_clicks_on_add_button()");
		Thread.sleep(5000);
	}

	@When("Clicks on clear buttom")
	public void clicks_on_clear_buttom() {
		// Write code here that turns the phrase above into concrete actions
		ab = new AddBranch(driver);
		ab.clickClear();
	}

	@Then("Verify textfeild is cleared")
	public void verify_textfeild_is_cleared() {
		// Write code here that turns the phrase above into concrete actions
		String act_ifsc = ab.getIFSC();
		System.out.println(act_ifsc);
		try {
			if (act_ifsc.equals("")) {
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

	@Then("User verify remove button persent on DOM")
	public void user_verify_remove_button_persent_on_DOM() {
		// Write code here that turns the phrase above into concrete actions
		try {
			bi = new BranchListInterface(driver);
			bi.removeBranch();
			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
			Assert.assertTrue(false);
		} finally {
//			driver.quit();
		}
	}

	@Then("checks for assert fails")
	public void checks_for_assert_fails() {
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
