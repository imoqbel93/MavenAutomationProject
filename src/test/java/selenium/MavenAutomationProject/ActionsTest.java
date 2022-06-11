package selenium.MavenAutomationProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest {

	@Test(enabled = false)
	public void dragAndDropExampleByElement() throws InterruptedException {

		// Setting the WebDriver to be Chrome WebDriver
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\LAB-3C-PC-5\\Documents\\FireFoxDriver\\geckodriver.exe");

		// Initialize WebDriver
		WebDriver fireFoxDriver = new FirefoxDriver();

		// Navigate to FB
		fireFoxDriver.get("https://jqueryui.com/droppable/");

		fireFoxDriver.manage().window().maximize();

		Thread.sleep(3000);

		// Create object from Actions class
		Actions actions = new Actions(fireFoxDriver);

		// Switch nito iFrame
		fireFoxDriver.switchTo().frame(0);

		// Initialize Source & Destination WebElements
		WebElement sourceElement = fireFoxDriver.findElement(By.id("draggable"));
		WebElement destinationElement = fireFoxDriver.findElement(By.id("droppable"));

		actions.dragAndDrop(sourceElement, destinationElement).build().perform();

		Thread.sleep(5000);

		// Quit the whole Driver Session
		fireFoxDriver.manage().deleteAllCookies();
		fireFoxDriver.quit();
	}


	@Test(enabled = false)
	public void dragAndDropExampleByOffset() throws InterruptedException {

		// Setting the Chrome WebDriver
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\LAB-3C-PC-5\\Documents\\FireFoxDriver\\geckodriver.exe");

		// Initialize WebDriver
		WebDriver fireFoxDriver = new FirefoxDriver();

		// Navigate to FB
		fireFoxDriver.get("https://jqueryui.com/droppable/");

		fireFoxDriver.manage().window().maximize();

		Thread.sleep(3000);

		// Create object from Actions class
		Actions actions = new Actions(fireFoxDriver);

		// Switch nito iFrame
		fireFoxDriver.switchTo().frame(0);

		// Initialize Source & Destination WebElements
		WebElement sourceElement = fireFoxDriver.findElement(By.id("draggable"));

		actions.dragAndDropBy(sourceElement, 400, 1000);

		Thread.sleep(5000);

		// Quit the whole Driver Session
		fireFoxDriver.quit();
	}

	@Test(enabled = false)
	public void mouseHoverExample() throws InterruptedException {

		// Setting the Chrome WebDriver
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\LAB-3C-PC-5\\Documents\\FireFoxDriver\\geckodriver.exe");

		// Initialize WebDriver
		WebDriver fireFoxDriver = new FirefoxDriver();

		// Navigate to FB
		fireFoxDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

		fireFoxDriver.manage().window().maximize();

		Thread.sleep(3000);

		// Scroll into iFrame
		JavascriptExecutor jse = (JavascriptExecutor) fireFoxDriver;
		jse.executeScript("window.scrollBy('0','1100')");

		// Create object from Actions class
		Actions actions = new Actions(fireFoxDriver);
		WebElement mouseHoverButton = fireFoxDriver.findElement(By.id("mousehover"));
		actions.moveToElement(mouseHoverButton).build().perform();

		Thread.sleep(4000);

		fireFoxDriver.quit();

	}

}
