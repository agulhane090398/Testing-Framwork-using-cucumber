package pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerAddInterface {

	WebDriver driver;

	// C
	public CustomerAddInterface(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// WE & M
	@FindBy(xpath = "//tbody/tr[2]/td[2]/select[1]")
	WebElement customer_type;

	public void selectCustomerType(String type) {
		System.out.println(type+"@@@@@@@@@@@");
		Select s = new Select(customer_type);
		s.selectByVisibleText(type);
	}

	@FindBy(xpath = "//tbody/tr[3]/td[2]/input")
	List<WebElement> title;

	public void radioTitle(String type) {
		System.out.println(type+"@@@@@@@@@@@");
		for (WebElement rb : title) {
			if (rb.getAttribute("value").equalsIgnoreCase(type)) {
				rb.click();
				break;
			}
		}
	}

	@FindBy(xpath = "//tbody/tr[4]/td[2]/input[1]")
	WebElement fName;

	public void enterFName(String fname) {
		fName.sendKeys(fname);
	}

	@FindBy(xpath = "//tbody/tr[4]/td[4]/input[1]")
	WebElement mName;

	public void enterMName(String mname) {
		mName.clear();
		mName.sendKeys(mname);
	}

	@FindBy(xpath = "//tbody/tr[5]/td[2]/input[1]")
	WebElement lName;

	public void enterLName(String lname) {
		lName.clear();
		lName.sendKeys(lname);
	}

	@FindBy(xpath = "//tbody/tr[5]/td[4]/input[1]")
	WebElement dob;

	public void enterDOB(String date) {
		System.out.println(date+"@@@@@@@@@@@");
		dob.sendKeys(date);
	}

	@FindBy(xpath = "//tbody/tr[7]/td[2]/input")
	List<WebElement> gender;

	public void checkGender(String gen) {
		System.out.println(gen+"@@@@@@@@@@@");
		for (WebElement g : gender) {
			if (g.getAttribute("value").equalsIgnoreCase(gen)) {
				g.click();
				break;
			}
		}
	}

	@FindBy(xpath = "//tbody/tr[8]/td[2]/input[1]")
	WebElement addr1;

	public void enterAddr1(String name) {
		addr1.clear();
		addr1.sendKeys(name);
	}

	@FindBy(xpath = "//tbody/tr[8]/td[4]/input[1]")
	WebElement addr2;

	public void enterAddr2(String name) {
		addr2.clear();
		addr2.sendKeys(name);
	}

	@FindBy(xpath = "//tbody/tr[9]/td[2]/input[1]")
	WebElement addr3;

	public void enterAddr3(String name) {
		addr3.clear();
		addr3.sendKeys(name);
	}

	@FindBy(xpath = "//tbody/tr[10]/td[2]/input[1]")
	WebElement city;

	public void enterCity(String name) {
		city.clear();
		city.sendKeys(name);
	}

	@FindBy(xpath = "//tbody/tr[10]/td[4]/input[1]")
	WebElement state;

	public void enterState(String name) {
		state.clear();
		state.sendKeys(name);
	}

	@FindBy(xpath = "//tbody/tr[11]/td[2]/input[1]")
	WebElement country;

	public void enterCountry(String name) {
		country.clear();
		country.sendKeys(name);
	}

	@FindBy(xpath = "//tbody/tr[9]/td[4]/input[1]")
	WebElement pinCode;

	public void enterPin(String name) {
		pinCode.clear();
		pinCode.sendKeys(name);
	}

	@FindBy(xpath = "//tbody/tr[11]/td[4]/input[1]")
	WebElement nationality;

	public void enterNationality(String name) {
		nationality.clear();
		nationality.sendKeys(name);
	}

	@FindBy(xpath = "//tbody/tr[12]/td[2]/input[1]")
	WebElement panNum;

	public void enterPan(String name) {
		panNum.clear();
		panNum.sendKeys(name);
	}
	
	public String getPan() {
		return panNum.getText();
	}

	@FindBy(xpath = "//tbody/tr[12]/td[4]/input[1]")
	WebElement adharNUM;

	public void enterAdhar(String name) {
		adharNUM.clear();
		adharNUM.sendKeys(name);
	}

	@FindBy(xpath = "//tbody/tr[13]/td[2]/input")
	List<WebElement> maritualSta;

	public void checkMaritualSta(String name) {
		for (WebElement e : maritualSta) {
			if (e.getAttribute("value").equalsIgnoreCase(name)) {
				e.click();
				break;
			}
		}
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement username;

	public void enterUserName(String uname) {
		username.clear();
		username.sendKeys(uname);
	}

	@FindBy(xpath = "//tbody/tr[14]/td[4]/input[1]")
	WebElement password;

	public void enterPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}


	@FindBy(xpath = "//tbody/tr[6]/td[2]/input[1]")
	WebElement mobile;

	public void enterMobile(String no) {
		mobile.clear();
		mobile.sendKeys(no);
	}

	@FindBy(xpath = "//tbody/tr[6]/td[4]/input[1]")
	WebElement mail;

	public void enterMail(String pwd) {
		mail.clear();
		mail.sendKeys(pwd);
	}

	
	@FindBy(xpath = "//tbody/tr[16]/th[1]/input[1]")
	WebElement submit;

	public void clickSubmit() {
		submit.click();
	}

	@FindBy(xpath = "//tbody/tr[16]/th[1]/input[2]")
	WebElement reset;

	public void clickReset() {
		reset.click();
	}
}
