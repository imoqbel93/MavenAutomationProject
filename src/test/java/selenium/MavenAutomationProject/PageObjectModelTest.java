package selenium.MavenAutomationProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import selenium.MavenAutomationProject.pageModels.HomePage;
import selenium.MavenAutomationProject.pageModels.QaClickAcademyPage;

public class PageObjectModelTest {

	@Test(enabled = true)
	public void pomExample() throws InterruptedException {

		// Setting the Chrome WebDriver
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\LAB-3C-PC-5\\Documents\\FireFoxDriver\\geckodriver.exe");

		// Initialize WebDriver
		WebDriver fireFoxDriver = new FirefoxDriver();

		// Create an Object from Home Page class (Page Object Model)
		HomePage homePage = new HomePage(fireFoxDriver);
		QaClickAcademyPage academyPage = new QaClickAcademyPage(fireFoxDriver);

		// Navigate to FB
		fireFoxDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

		fireFoxDriver.manage().window().maximize();

		Thread.sleep(3000);

		homePage.autoCompleteTextField.sendKeys("Selenium Course!");
		homePage.optionTwoCheckBox.click();
		// Open New Tab
				homePage.openWindowButton.click();

				Thread.sleep(5000);

				// Switch to First Tab
				fireFoxDriver.switchTo().window("Practice Page");

				Thread.sleep(5000);

				// Switch to Opened Window
				fireFoxDriver.switchTo()
						.window("QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy");

				Thread.sleep(5000);

		fireFoxDriver.quit();
	}
}
