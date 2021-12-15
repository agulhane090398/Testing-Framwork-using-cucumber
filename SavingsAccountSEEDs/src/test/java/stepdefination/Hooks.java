package stepdefination;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import io.cucumber.java.Scenario;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//
//
//
import org.openqa.selenium.support.PageFactory;

public class Hooks {
	public WebDriver driver;

//	@After
//	public void addScreenshot(Scenario scenario) {
//
//		// validate if scenario has failed
//		if (scenario.isFailed()) {
//			 driver =  scenario.;
//			
//			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//			scenario.attach(screenshot, "image/png", "image");
//		}
//
//	}
}
