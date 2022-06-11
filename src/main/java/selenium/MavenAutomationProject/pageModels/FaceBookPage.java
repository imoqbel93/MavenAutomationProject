package selenium.MavenAutomationProject.pageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookPage {

	WebDriver driver;

	public FaceBookPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	public WebElement emailTextField;
	
	@FindBy(name = "pass")
	public WebElement passwordTextField;
	
}
