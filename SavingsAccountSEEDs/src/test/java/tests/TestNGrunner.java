package tests;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//import io.cucumber.testng.AbstractTestMGCucumberTests;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
//@CucumberOptions(
//		
//		//dryRun=true,
//		strict=true,
//		monochrome = true,
//		features="src/test/resources/Features/Transfer.feature",
//		glue="stepdefination",
//		plugin= {"pretty" }
//		)
//public class TestRunner {
//
//}


		//add cucumber-testng dependency


//@CucumberOptions(
//		
//		//dryRun=true,
//		//strict=true,
//		monochrome = true,
//		features="src/test/resources/Features/Transfer.feature",
//		glue="stepdefination",
//		publish = true,
//		plugin= {"pretty" , "html:html-report" , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
//		)
//public class TestNGrunner extends AbstractTestMGCucumberTests{
//	
//	
//	}
	
	
	
	
//	@AfterClass
//	public static void setup()
//	{
//	Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
//	//Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
//	Reporter.setSystemInfo("User Name", "AJ");
//	Reporter.setSystemInfo("Application Name", "Test App ");
//	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
//	Reporter.setSystemInfo("Environment", "Production");
//	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
//	}
//}