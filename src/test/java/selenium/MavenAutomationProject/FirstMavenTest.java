package selenium.MavenAutomationProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.MavenAutomationProject.pageModels.FaceBookPage;

public class FirstMavenTest extends Configurations{

	/*
	 * public static void main(String[] args) {
	 * 
	 * String[] array = {"emran", "automation", "course", "selenium"};
	 * 
	 * for (int i = 0; i < array.length; i ++) {
	 * 
	 * System.out.println("Value in index " + i + " is " + array[i] ); } }
	 */

	@Test(enabled = false)
	public void firstTest() throws InterruptedException {

		// Setting the Chrome WebDriver
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\LAB-3C-PC-5\\Documents\\FireFoxDriver\\geckodriver.exe");

		// Initialize WebDriver
		WebDriver fireFoxDriver = new FirefoxDriver();

		// Navigate to FB
		fireFoxDriver.get("https://www.facebook.com/");

		// Get and Print Current URL
		String currentURL = fireFoxDriver.getCurrentUrl();
		System.out.println("Current URL is : " + currentURL);

		// Get Page Source
		String pageSource = fireFoxDriver.getPageSource();
//		System.out.println("Page Source is : " + pageSource);

		// Fill Email & Password
		fireFoxDriver.findElement(By.id("email")).sendKeys("email@yahoo.com");
		fireFoxDriver.findElement(By.name("pass")).sendKeys("123456789");

		// Get and Print Sign Up Button
		String createNewAccountButton = fireFoxDriver
				.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).getText();
		System.out.println("Text of Button is : " + createNewAccountButton);

		// Submit Login
		fireFoxDriver.findElement(By.name("pass")).submit();

		Thread.sleep(3000);

		// Store Login Button in a Variable
		WebElement loginButton = fireFoxDriver.findElement(By.xpath("//button[@name='login']"));
//		loginButton.click();

		Thread.sleep(5000);

		// Quit the whole Driver Session
		fireFoxDriver.quit();
	}

	@Test(enabled = false)
	public void radioButtonTest() throws InterruptedException {

		// Setting the FireFox WebDriver
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\LAB-3C-PC-5\\Documents\\FireFoxDriver\\geckodriver.exe");

		// Initialize WebDriver
		WebDriver fireFoxDriver = new FirefoxDriver();

		// Navigate to FB
		fireFoxDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Click on Radio Button 1
		WebElement radioButton1 = fireFoxDriver.findElement(By.xpath("//input[@value='radio2']"));
		radioButton1.click();

		Thread.sleep(5000);

		// Quit the whole Driver Session
		fireFoxDriver.quit();
	}

	@Test(enabled = false)
	public void dropDownTest() throws InterruptedException {

		// Setting the FireFox WebDriver
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\LAB-3C-PC-5\\Documents\\FireFoxDriver\\geckodriver.exe");

		// Initialize WebDriver
		WebDriver fireFoxDriver = new FirefoxDriver();

		// Navigate to Practice Site
		fireFoxDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Initialize Drop DOwn
		WebElement dropDownListElement = fireFoxDriver.findElement(By.id("dropdown-class-example"));

		// Store Drop Down into a Select Object
		Select dropDownList = new Select(dropDownListElement);

		// Select a Value from the Drop Down - By Option
//		dropDownList.selectByValue("option2");

		// Select a Value from the Drop Down - By Index
//		dropDownList.selectByIndex(3);

		// Select a Value from the Drop Down - By Visible Text
		dropDownList.selectByVisibleText("Option1");

		Thread.sleep(5000);

		// Quit the whole Driver Session
		fireFoxDriver.quit();
	}

	@Test(enabled = false)
	public void webTableTest() throws InterruptedException {

		// Setting the FireFox WebDriver
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\LAB-3C-PC-5\\Documents\\FireFoxDriver\\geckodriver.exe");

		// Initialize WebDriver
		WebDriver fireFoxDriver = new FirefoxDriver();

		// Navigate to Practice Site
		fireFoxDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Maximize the window
		fireFoxDriver.manage().window().maximize();

		// Scroll into the Table using JavaScriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) fireFoxDriver;
		js.executeScript("window.scrollBy(0,550)");

		// Initialize Web Table
		List<WebElement> webTable = fireFoxDriver.findElements(By.cssSelector("#product td:nth-child(4)"));

		for (int i = 0; i < webTable.size(); i++) {

			System.out.println("Value in index " + i + " is " + webTable.get(i).getText());
		}

		Thread.sleep(5000);

		// Quit the whole Driver Session
		fireFoxDriver.quit();
	}

	@Test(enabled = false)
	public void waitTest() throws InterruptedException {

		// Setting the FireFox WebDriver
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\LAB-3C-PC-5\\Documents\\FireFoxDriver\\geckodriver.exe");

		// Initialize WebDriver
		WebDriver fireFoxDriver = new FirefoxDriver();

		// Implicit Wait
		fireFoxDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Navigate to Practice Site
		fireFoxDriver.get("http://www.quadinfotech.com/");

		// Maximize the window
		fireFoxDriver.manage().window().maximize();

		// Find an Element that takes time to load
		WebElement logo = fireFoxDriver.findElement(By.xpath("//img[@alt='QUAD Logo']"));

		String logoText = logo.getText();
		System.out.println("Logo Text is : " + logoText);

		// Go to About section
		fireFoxDriver.findElement(By.id("menu-item-5978")).click();

		// Find an Element within About section
		By sectionElement = By.id("x-section-1");

		// Explicit Wait
		WebDriverWait wait = new WebDriverWait(fireFoxDriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(sectionElement));

		Thread.sleep(5000);

		// Quit the whole Driver Session
		fireFoxDriver.quit();
	}

	@Test(enabled = false)
	public void switchTabTest() throws InterruptedException {

		// Setting the FireFox WebDriver
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\LAB-3C-PC-5\\Documents\\FireFoxDriver\\geckodriver.exe");

		// Initialize WebDriver
		WebDriver fireFoxDriver = new FirefoxDriver();

		// Navigate to Practice Site
		fireFoxDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Maximize the window
		fireFoxDriver.manage().window().maximize();

		// Open New Tab
		fireFoxDriver.findElement(By.id("openwindow")).click();

		Thread.sleep(5000);

		// Switch to First Tab
		fireFoxDriver.switchTo().window("Practice Page");

		Thread.sleep(5000);

		// Switch to Opened Window
		fireFoxDriver.switchTo()
				.window("QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy");

		Thread.sleep(5000);

		// Quit the whole Driver Session
		fireFoxDriver.quit();
	}

	@Test(enabled = false)
	public void alertExampleWithAssertion() throws InterruptedException {

		// Setting the FireFox WebDriver
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\LAB-3C-PC-5\\Documents\\FireFoxDriver\\geckodriver.exe");

		// Initialize WebDriver
		WebDriver fireFoxDriver = new FirefoxDriver();

		// Navigate to Practice Site
		fireFoxDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Maximize the window
		fireFoxDriver.manage().window().maximize();

		// Click on Alert Button
		fireFoxDriver.findElement(By.xpath("//input[@id='alertbtn']")).click();

		// Switch into Alert & Get Text & Print it
		String actualAlertText = fireFoxDriver.switchTo().alert().getText();
		System.out.println("Alert Text is " + actualAlertText);

		// Expected Result
		String expectedAlertText = "Hello , share thiss practice page and share your knowledge";

		// ِAssertion
		Assert.assertEquals(actualAlertText, expectedAlertText);

		// Accept the Alert
//		fireFoxDriver.switchTo().alert().accept();

		Thread.sleep(5000);

		// Quit the whole Driver Session
		fireFoxDriver.quit();
	}

	@Test(enabled = false)
	public void windowHandlesExample() throws InterruptedException {

		// Setting the FireFox WebDriver
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\LAB-3C-PC-5\\Documents\\FireFoxDriver\\geckodriver.exe");

		// Initialize WebDriver
		WebDriver fireFoxDriver = new FirefoxDriver();

		// Navigate to Practice Site
		fireFoxDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Maximize the window
		fireFoxDriver.manage().window().maximize();

		// Click on Open Window
		fireFoxDriver.findElement(By.id("openwindow")).click();

		// Get all Opened Windows / Handles
		Set<String> windowHandles = fireFoxDriver.getWindowHandles();

		// Activating an Iterator on Window Handles
		Iterator<String> iterator = windowHandles.iterator();

		Thread.sleep(3000);

		// Actual Iteration -- On First Page
		fireFoxDriver.switchTo().window(iterator.next());

		System.out.println("1st Page Title is : " + fireFoxDriver.getTitle());

		String secondWindow = iterator.next();

		fireFoxDriver.switchTo().window(secondWindow);

		System.out.println("2nd Page Title is : " + fireFoxDriver.getTitle());

		Thread.sleep(5000);

		// Quit the whole Driver Session
		fireFoxDriver.quit();
	}

	@Test(enabled = false)
	public void iframeExample() throws InterruptedException {

		// Setting the FireFox WebDriver
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\LAB-3C-PC-5\\Documents\\FireFoxDriver\\geckodriver.exe");

		// Initialize WebDriver
		WebDriver fireFoxDriver = new FirefoxDriver();

		// Navigate to Practice Site
		fireFoxDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Maximize the window
		fireFoxDriver.manage().window().maximize();

		// Scroll into iFrame
		JavascriptExecutor jse = (JavascriptExecutor) fireFoxDriver;
		jse.executeScript("window.scrollBy('0','1400')");

		Thread.sleep(3000);

		// Switch into Frame by Index
//		fireFoxDriver.switchTo().frame(0);

		// Switch into Frame by ID
		fireFoxDriver.switchTo().frame("courses-iframe");

		String classAttribute = fireFoxDriver.findElement(By.xpath("//span[@class='fa fa-linkedin']"))
				.getAttribute("class");
		System.out.println("Class Attribute is : " + classAttribute);

		fireFoxDriver.findElement(By.xpath("(//a[@class='theme-btn'])[1]")).click();

		Thread.sleep(5000);

		// Quit the whole Driver Session
		fireFoxDriver.quit();
	}

	@Test(enabled = true)
	public void propertiesDataTest() throws InterruptedException, FileNotFoundException, IOException {

		// Setting the Chrome WebDriver
//		System.setProperty("webdriver.gecko.driver",
//				System.getProperty("user.dir") + "/src/main/java/resources/geckodriver.exe");

		// Initialize WebDriver
//		WebDriver fireFoxDriver = new FirefoxDriver();

		FaceBookPage faceBookPage = new FaceBookPage(fireFoxDriver);

		// Navigate to FB
//		fireFoxDriver.get("https://www.facebook.com/");

		// Get and Print Current URL
		String currentURL = fireFoxDriver.getCurrentUrl();
		System.out.println("Current URL is : " + currentURL);

		// Get Page Source
		String pageSource = fireFoxDriver.getPageSource();
//		System.out.println("Page Source is : " + pageSource);

		// Fill Email & Password
//		fireFoxDriver.findElement(By.id("email")).sendKeys("email@yahoo.com");
//		fireFoxDriver.findElement(By.name("pass")).sendKeys("123456789");

		// Define an object out of Properties Class
		Properties prop = new Properties();
		// Set the path of the file and load it
		prop.load(new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\testData.properties"));
		// Get needed value out of the file
		String email = prop.getProperty("email");
		String pass = prop.getProperty("password");

		// Fill Email & Password - Enhanced Implementation
		faceBookPage.emailTextField.sendKeys(email);
		faceBookPage.passwordTextField.sendKeys(pass);

		Thread.sleep(5000);

		// Quit the whole Driver Session
//		fireFoxDriver.quit();
	}
}
