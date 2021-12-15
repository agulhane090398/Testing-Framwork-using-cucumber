package stepdefination;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.datatable.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjectModel.CustomerAccountInterface;
import pageObjectModel.CustomerLoginInterface;
import pageObjectModel.SavingsAccount;
import pageObjectModel.Transfer_Funds;

@SuppressWarnings("deprecation")
public class TC_Transfer {

	public WebDriver driver;
	public CustomerLoginInterface cli;
	public CustomerAccountInterface cai;
	public SavingsAccount sa;
	public Transfer_Funds tf;
	Actions action;
	Map<String, String> map;
	Connection con;
	Statement stmt;
	String from_accno;
	String amt;
	String to_accno;
	Double from_acc_balance_initial;
	Double from_acc_balance_final;
	Double to_acc_balance_initial;
	Double to_acc_balance_final;
	ResultSet rs;
	WebDriverWait myWait;
	Wait<WebDriver> wait;

	@Given("c-user is  On Saving Account Interface {string}")
	public void c_user_is_on_saving_account_interface(String url) {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		cli = new CustomerLoginInterface(driver);
		sa = new SavingsAccount(driver);
	}

	@Given("c-user   Clicks on Customer  Link")
	public void c_user_clicks_on_customer_link() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		sa.openCustomer();
		Thread.sleep(5000);
		myWait = new WebDriverWait(driver, 5);
	}

	@When("c-user  Enters Valid Credential  {string} and {string}")
	public void c_user_enters_valid_credential_and(String username, String pwd) {
		// Write code here that turns the phrase above into concrete actions
		cli.enterCredentials(username, pwd);
	}

	@Then("c-user  Click on Login    buttons")
	public void c_user_click_on_login_buttons() {
		// Write code here that turns the phrase above into concrete actions
		cli.clickOnLogin();
		cai = new CustomerAccountInterface(driver);
	}

	@When("c-user  Moves  mouse Over  Transaction")
	public void c_user_moves_mouse_over_transaction() {
		// Write code here that turns the phrase above into concrete actions
		action = new Actions(driver);
		action.moveToElement(cai.moveToTransaction()).perform();
	}

	@When("c-user  Click On Transfer  Sub-Menu")
	public void c_user_click_on_transfer_sub_menu() {
		// Write code here that turns the phrase above into concrete actions
		cai.clickTransfer();
		tf = new Transfer_Funds(driver);
	}

	@Then("c-user  Verify   Title  {string}")
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
	}

	@When("C-User Enters the following data")
	public void c_user_enters_the_following_data(DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.

		try {
			map = dataTable.asMap(String.class, String.class);
			Thread.sleep(3000);
			tf.selectFromAcc(map.get("from_account").toString());
			tf.enterToAcc(map.get("to_account").toString());
			tf.enterReconfirmAcc(map.get("reconfirm_account").toString());
			tf.enterAmt(map.get("amount").toString());
			Thread.sleep(3000);
			tf.enterNarration(map.get("naration").toString());
			tf.enterIFSC(map.get("ifsc").toString());
			Thread.sleep(3000);
			tf.enterAccHolderName(map.get("acc_holder_name").toString());
			from_accno = Integer.parseInt(map.get("from_account").replaceAll("\\D", "")) + "";
			to_accno = map.get("to_account").toString();
			System.out.println(from_accno + "        @@@@@           " + to_accno);
			amt = map.get("amount").toString();
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			// driver.close();
		}
	}

	@When("C-User retrives the initial balance of both the acconts")
	public void c_user_retrives_the_initial_balance_of_both_the_acconts() throws SQLException {
		// Write code here that turns the phrase above into concrete actions
		String SQL_SELECT = "SELECT * FROM banking.account Where account_no=" + from_accno + " order by id limit 0,1;";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "root");
				// here banking is database name, root is username and password
				PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				from_acc_balance_initial = rs.getDouble("balance");
				System.out.println("from account=" + from_accno + "   " + from_acc_balance_initial);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			conn.close();
		}

		SQL_SELECT = "SELECT * FROM banking.account Where account_no=" + to_accno + " order by id limit 0,1;";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "root");
				// here banking is database name, root is username and password
				PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				to_acc_balance_initial = rs.getDouble("balance");
				System.out.println("to account=" + to_accno + "   " + to_acc_balance_initial);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
//				conn.close();
		}
		tf.clickConfirm();

	}

	@Then("C-User verify The contain of page with correct results")
	public void c_user_verify_the_contain_of_page_with_correct_results() throws SQLException {
		// Write code here that turns the phrase above into concrete actions
		String SQL_SELECT = "SELECT * FROM banking.account Where account_no=" + from_accno + " order by id limit 0,1;";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "root");
				// here banking is database name, root is username and password
				PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				from_acc_balance_final = rs.getDouble("balance");
				System.out.println("from account=" + from_accno + "   " + from_acc_balance_final);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
//					conn.close();
		}

		SQL_SELECT = "SELECT * FROM banking.account Where account_no=" + to_accno + " order by id limit 0,1;";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "root");
				// here banking is database name, root is username and password
				PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				to_acc_balance_final = rs.getDouble("balance");
				System.out.println("to account=" + to_accno + "   " + to_acc_balance_final);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
//			con.close();
			tf.clickClose();
			// driver.close();
		}
		try {
			System.out.println(to_acc_balance_final + "=" + to_acc_balance_initial + "+" + Double.parseDouble(amt));
			System.out.println(from_acc_balance_final + "=" + from_acc_balance_initial + "-" + Double.parseDouble(amt));
			Assert.assertEquals(to_acc_balance_final, to_acc_balance_initial + Double.parseDouble(amt));
			Assert.assertEquals(from_acc_balance_final, from_acc_balance_initial - Double.parseDouble(amt));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
//			driver.close();
		}
	}

	@When("C-user enters {int} as amount and {string} as ifsc code")
	public void c_user_enters_as_amount_and_as_ifsc_code(Integer amt, String ifsc) {
		// Write code here that turns the phrase above into concrete actions
		tf.enterAmt(amt + "");
		tf.enterIFSC(ifsc);
	}

	@When("click on clear button")
	public void click_on_clear_button() {
		// Write code here that turns the phrase above into concrete actions
		tf.clickClear();
	}

	@Then("C-user verfies feild is empty")
	public void c_user_verfies_feild_is_empty() {
		// Write code here that turns the phrase above into concrete actions
		try {
			Assert.assertEquals("", tf.getIFSCfield());
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
