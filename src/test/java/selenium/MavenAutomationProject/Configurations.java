package selenium.MavenAutomationProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Configurations {

	WebDriver fireFoxDriver;
	WebDriver chromeDriver;

	@BeforeMethod
	public void testSetup() {

		// Setting the Chrome WebDriver
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + "/src/main/java/resources/geckodriver.exe");

		fireFoxDriver = new FirefoxDriver();
		fireFoxDriver.get("https://www.google.com/");
	}

	@AfterMethod
	public void tessTearDown() {

		fireFoxDriver.manage().deleteAllCookies();
		fireFoxDriver.quit();
	}

}
