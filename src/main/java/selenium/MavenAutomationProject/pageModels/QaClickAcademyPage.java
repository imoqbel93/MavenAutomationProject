package selenium.MavenAutomationProject.pageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QaClickAcademyPage {

	WebDriver driver;

	public QaClickAcademyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fa fa-lock fa-lg']")
	public WebElement loginButton;
	
	@FindBy(xpath = "//input[@name='email']")
	public WebElement emailTextField;
	
	
}
